package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class IMMediaBuildSessionListener implements IGetUserIdentityListener, IGetPaInfosListener {
    private static final String TAG = "IMMediaBuildSessionListener";
    private Context mContext;
    private boolean mHasMore;
    private IMediaGetChatSessionListener mListener;
    private int mNewNum;
    private Map<Long, ChatSession> mPaMap = null;
    private Map<Long, ChatSession> mUserMap = null;
    private List<ChatSession> mUserResultList = null;
    private List<ChatSession> mPaResultList = null;

    public IMMediaBuildSessionListener(Context context, int i, boolean z, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        this.mNewNum = 0;
        this.mHasMore = false;
        this.mContext = context;
        this.mNewNum = i;
        this.mHasMore = z;
        this.mListener = iMediaGetChatSessionListener;
    }

    @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
    public synchronized void onGetUserIdentityResult(int i, List<ChatUser> list) {
        this.mUserResultList = new ArrayList();
        if (i == 0 && list != null && this.mUserMap != null) {
            for (ChatUser chatUser : list) {
                ChatSession chatSession = this.mUserMap.get(Long.valueOf(chatUser.getBuid()));
                if (chatSession != null) {
                    updateChatSessionByChatUser(chatSession, chatUser);
                    this.mUserResultList.add(chatSession);
                }
            }
        }
        if (this.mListener != null) {
            if (i != 0) {
                this.mListener.onMediaGetChatSessionResult(i, 0, false, null);
                this.mListener = null;
            } else if (this.mPaMap == null) {
                this.mListener.onMediaGetChatSessionResult(i, this.mNewNum, this.mHasMore, this.mUserResultList);
            } else if (this.mPaResultList != null) {
                this.mUserResultList.addAll(this.mPaResultList);
                this.mListener.onMediaGetChatSessionResult(i, this.mNewNum, this.mHasMore, this.mUserResultList);
            }
        }
    }

    @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
    public synchronized void onResult(int i, String str, ArrayList<PaInfo> arrayList) {
        this.mPaResultList = new ArrayList();
        if (i == 0 && arrayList != null && this.mPaMap != null) {
            Iterator<PaInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                PaInfo next = it.next();
                ChatSession chatSession = this.mPaMap.get(Long.valueOf(next.getPaId()));
                if (chatSession != null) {
                    updateChatSessionByPaInfo(this.mPaMap.get(Long.valueOf(next.getPaId())), next);
                    this.mPaResultList.add(chatSession);
                }
            }
        }
        if (this.mListener != null) {
            if (i != 0) {
                this.mListener.onMediaGetChatSessionResult(i, 0, false, null);
                this.mListener = null;
            } else if (this.mUserMap == null) {
                this.mListener.onMediaGetChatSessionResult(i, this.mNewNum, this.mHasMore, this.mPaResultList);
            } else if (this.mUserResultList != null) {
                this.mPaResultList.addAll(this.mUserResultList);
                this.mListener.onMediaGetChatSessionResult(i, this.mNewNum, this.mHasMore, this.mPaResultList);
            }
        }
    }

    private void updateChatSessionByPaInfo(ChatSession chatSession, PaInfo paInfo) {
        if (chatSession != null && paInfo != null) {
            chatSession.setName(paInfo.getNickName());
            chatSession.setChatType(paInfo.getSubtype());
            chatSession.setBusinessType(Utility.getBusinessType(paInfo.getSubtype(), paInfo.getSubsetType()));
            chatSession.setIconUrl(paInfo.getAvatar());
            chatSession.setClassType(paInfo.getClassType());
            chatSession.setClassTitle(paInfo.getClassTitle());
            chatSession.setClassAvatar(paInfo.getClassavatar());
            chatSession.setClassShow(paInfo.getClassshow());
            chatSession.setShield(paInfo.getShield());
            chatSession.setShieldTime(paInfo.getShieldTime());
            chatSession.setVipId(paInfo.getVipId());
            chatSession.setVPortrait(paInfo.getVPortrait());
            chatSession.setCertification(paInfo.getIdentity());
            try {
                PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.mContext).queryPaInfo(paInfo.getPaId());
                if (queryPaInfo == null || queryPaInfo.getPaId() < 1) {
                    paInfo.setMarkTop(chatSession.getMarkTop());
                    paInfo.setMarkTopTime(chatSession.getLastMsgTime());
                    PaInfoDBManager.getInstance(this.mContext).subscribePa(paInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateChatSessionByChatUser(ChatSession chatSession, ChatUser chatUser) {
        if (chatSession != null && chatUser != null) {
            chatSession.setName(chatUser.getUserName());
            chatSession.setChatType(0);
            chatSession.setBusinessType(1);
            chatSession.setIconUrl(chatUser.getIconUrl());
            chatSession.setClassType(0);
            chatSession.setClassShow(0);
            chatSession.setShield(chatUser.getShield());
            chatSession.setShieldTime(chatUser.getShieldTime());
            chatSession.setVipId(chatUser.getVipId());
            chatSession.setVPortrait(chatUser.getVPortrait());
            chatSession.setCertification(chatUser.getIdentity());
            chatSession.setContacter(chatUser.getUk());
            try {
                ChatUser chatUser2 = ChatUserDBManager.getInstance(this.mContext).getChatUser(chatUser.getUk());
                if (chatUser2 == null || chatUser2.getUk() < 1) {
                    chatUser.setMarkTop(chatSession.getMarkTop());
                    chatUser.setMarkTopTime(chatSession.getLastMsgTime());
                    ChatUserDBManager.getInstance(this.mContext).updateUser(chatUser);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setPaMap(Map<Long, ChatSession> map) {
        this.mPaMap = map;
    }

    public void setUserMap(Map<Long, ChatSession> map) {
        this.mUserMap = map;
    }
}
