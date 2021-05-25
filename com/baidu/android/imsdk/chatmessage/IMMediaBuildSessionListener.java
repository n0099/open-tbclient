package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class IMMediaBuildSessionListener implements IMListener {
    public static final String TAG = "IMMediaBuildSessionListener";
    public Context mContext;
    public boolean mHasMore;
    public IMediaGetChatSessionListener mListener;
    public int mNewNum;
    public int mTopHasMore;
    public List<ChatSession> mResultList = Collections.synchronizedList(new ArrayList());
    public IGetPaInfosListener mGetPaInfosListener = null;
    public IGetUserIdentityListener mGetUserIdentityListener = null;
    public BIMValueCallBack<ArrayList<GroupInfo>> mGetGroupInfoListener = null;
    public int mResultCode = 0;
    public AtomicInteger count = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public class GetGroupInfoListener implements BIMValueCallBack<ArrayList<GroupInfo>> {
        public Map<String, ChatSession> mGroupMap;

        public GetGroupInfoListener(Map<String, ChatSession> map) {
            this.mGroupMap = map;
        }

        private void updateChatSessionByGroupInfo(ChatSession chatSession, GroupInfo groupInfo) {
            if (chatSession == null || groupInfo == null) {
                return;
            }
            chatSession.setName(groupInfo.getGroupName());
            chatSession.setChatType(groupInfo.getType() == 3 ? 57 : 3);
            chatSession.setBusinessType(2);
            chatSession.setIconUrl(groupInfo.getHeadUrl());
            if (chatSession.getLastMsgUid() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(chatSession.getLastMsgUid()));
                ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(IMMediaBuildSessionListener.this.mContext, groupInfo.getGroupId(), arrayList, 1);
                if (groupMember == null || groupMember.size() <= 0) {
                    return;
                }
                chatSession.setLastMsgName(groupMember.get(0).getShowName());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.group.BIMValueCallBack
        public void onResult(int i2, String str, ArrayList<GroupInfo> arrayList) {
            if (i2 == 0 && arrayList != null && this.mGroupMap != null) {
                Iterator<GroupInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    GroupInfo next = it.next();
                    ChatSession chatSession = this.mGroupMap.get(next.getGroupId());
                    if (chatSession != null) {
                        updateChatSessionByGroupInfo(chatSession, next);
                        IMMediaBuildSessionListener.this.mResultList.add(chatSession);
                    }
                }
            }
            IMMediaBuildSessionListener.this.callBack(i2);
        }
    }

    /* loaded from: classes.dex */
    public class GetPaInfosListener implements IGetPaInfosListener {
        public Map<Long, ChatSession> mPaMap;

        public GetPaInfosListener(Map<Long, ChatSession> map) {
            this.mPaMap = map;
        }

        private void updateChatSessionByPaInfo(ChatSession chatSession, PaInfo paInfo) {
            if (chatSession == null || paInfo == null) {
                return;
            }
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
                PaInfo queryPaInfo = PaInfoDBManager.getInstance(IMMediaBuildSessionListener.this.mContext).queryPaInfo(paInfo.getPaId());
                if (queryPaInfo == null || queryPaInfo.getPaId() < 1) {
                    paInfo.setMarkTop(chatSession.getMarkTop());
                    paInfo.setMarkTopTime(chatSession.getLastMsgTime());
                    PaInfoDBManager.getInstance(IMMediaBuildSessionListener.this.mContext).subscribePa(paInfo);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
        public void onResult(int i2, String str, ArrayList<PaInfo> arrayList) {
            if (i2 == 0 && arrayList != null && this.mPaMap != null) {
                Iterator<PaInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    PaInfo next = it.next();
                    ChatSession chatSession = this.mPaMap.get(Long.valueOf(next.getPaId()));
                    if (chatSession != null) {
                        updateChatSessionByPaInfo(this.mPaMap.get(Long.valueOf(next.getPaId())), next);
                        IMMediaBuildSessionListener.this.mResultList.add(chatSession);
                    }
                }
            }
            IMMediaBuildSessionListener.this.callBack(i2);
        }
    }

    /* loaded from: classes.dex */
    public class GetUserIdentityListener implements IGetUserIdentityListener {
        public Map<Long, ChatSession> mUserMap;

        public GetUserIdentityListener(Map<Long, ChatSession> map) {
            this.mUserMap = map;
        }

        private void updateChatSessionByChatUser(ChatSession chatSession, ChatUser chatUser) {
            if (chatSession == null || chatUser == null) {
                return;
            }
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
                ChatUser chatUser2 = ChatUserDBManager.getInstance(IMMediaBuildSessionListener.this.mContext).getChatUser(chatUser.getUk());
                if (chatUser2 == null || chatUser2.getUk() < 1) {
                    chatUser.setMarkTop(chatSession.getMarkTop());
                    chatUser.setMarkTopTime(chatSession.getLastMsgTime());
                    ChatUserDBManager.getInstance(IMMediaBuildSessionListener.this.mContext).updateUser(chatUser);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
        public void onGetUserIdentityResult(int i2, List<ChatUser> list) {
            if (i2 == 0 && list != null && this.mUserMap != null) {
                for (ChatUser chatUser : list) {
                    ChatSession chatSession = this.mUserMap.get(Long.valueOf(chatUser.getBuid()));
                    if (chatSession != null) {
                        updateChatSessionByChatUser(chatSession, chatUser);
                        IMMediaBuildSessionListener.this.mResultList.add(chatSession);
                    }
                }
            }
            IMMediaBuildSessionListener.this.callBack(i2);
        }
    }

    public IMMediaBuildSessionListener(Context context, int i2, int i3, boolean z, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        this.mNewNum = 0;
        this.mHasMore = false;
        this.mTopHasMore = 0;
        this.mContext = context;
        this.mNewNum = i2;
        this.mHasMore = z;
        this.mListener = iMediaGetChatSessionListener;
        this.mTopHasMore = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBack(int i2) {
        this.mResultCode |= i2;
        if (this.count.decrementAndGet() != 0 || this.mListener == null) {
            return;
        }
        if (this.mResultList.size() > 0) {
            this.mResultCode = 0;
        } else {
            this.mResultCode = i2;
        }
        this.mListener.onMediaGetChatSessionResult(0, this.mNewNum, this.mTopHasMore, this.mHasMore, this.mResultList);
    }

    public BIMValueCallBack<ArrayList<GroupInfo>> getGroupInfoListener(Map<String, ChatSession> map) {
        if (this.mGetGroupInfoListener == null) {
            this.mGetGroupInfoListener = new GetGroupInfoListener(map);
            this.count.incrementAndGet();
        }
        return this.mGetGroupInfoListener;
    }

    public IGetPaInfosListener getPaInfosListener(Map<Long, ChatSession> map) {
        if (this.mGetPaInfosListener == null) {
            this.mGetPaInfosListener = new GetPaInfosListener(map);
            this.count.incrementAndGet();
        }
        return this.mGetPaInfosListener;
    }

    public IGetUserIdentityListener getUserIdentityListener(Map<Long, ChatSession> map) {
        if (this.mGetUserIdentityListener == null) {
            this.mGetUserIdentityListener = new GetUserIdentityListener(map);
            this.count.incrementAndGet();
        }
        return this.mGetUserIdentityListener;
    }
}
