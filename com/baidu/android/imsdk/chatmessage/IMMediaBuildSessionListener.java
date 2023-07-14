package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.media.request.IMFetchBusinessSessionMsg;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class IMMediaBuildSessionListener implements IMListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMediaBuildSessionListener";
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger count;
    public int mConsultUnreadNum;
    public Context mContext;
    public BIMValueCallBack<ArrayList<GroupInfo>> mGetGroupInfoListener;
    public IGetPaInfosListener mGetPaInfosListener;
    public IGetUsersProfileBatchListener mGetUserIdentityListener;
    public boolean mHasMore;
    public IMListener mListener;
    public int mNewNum;
    public int mResultCode;
    public List<ChatSession> mResultList;
    public int mTopHasMore;

    /* loaded from: classes.dex */
    public class GetGroupInfoListener implements BIMValueCallBack<ArrayList<GroupInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, ChatSession> mGroupMap;
        public final /* synthetic */ IMMediaBuildSessionListener this$0;

        public GetGroupInfoListener(IMMediaBuildSessionListener iMMediaBuildSessionListener, Map<String, ChatSession> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMMediaBuildSessionListener, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMMediaBuildSessionListener;
            this.mGroupMap = map;
        }

        private void updateChatSessionByGroupInfo(ChatSession chatSession, GroupInfo groupInfo) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65537, this, chatSession, groupInfo) == null) && chatSession != null && groupInfo != null) {
                chatSession.setName(groupInfo.getGroupName());
                if (groupInfo.getType() == 3) {
                    i = 57;
                } else {
                    i = 3;
                }
                chatSession.setChatType(i);
                chatSession.setBusinessType(2);
                chatSession.setIconUrl(groupInfo.getHeadUrl());
                if (chatSession.getDisturb() == -1) {
                    if (groupInfo.getType() != 2 && (groupInfo.getType() != 3 || (groupInfo.getSubType() != 0 && groupInfo.getSubType() != 2000 && groupInfo.getSubType() != 3))) {
                        chatSession.setDisturb(0);
                    } else {
                        chatSession.setDisturb(1);
                    }
                }
                try {
                    if (groupInfo.getDisturb() != chatSession.getDisturb() || groupInfo.getMarkTop() != chatSession.getMarkTop() || groupInfo.getMarkTopTime() != chatSession.getMarkTopTime()) {
                        long parseLong = Long.parseLong(groupInfo.getGroupId());
                        GroupInfoDAOImpl.updateGroupInfoDoNotDisturb(this.this$0.mContext, parseLong, chatSession.getDisturb());
                        GroupInfoDAOImpl.updateGroupInfoMarkTop(this.this$0.mContext, parseLong, chatSession.getMarkTop(), chatSession.getMarkTopTime());
                    }
                } catch (Exception unused) {
                }
                if (chatSession.getLastMsgUid() > 0 && !TextUtils.isEmpty(chatSession.getLastMsg())) {
                    ChatMessageDBManager.getInstance(this.this$0.mContext).setChatSessionLastName(chatSession, String.valueOf(chatSession.getLastMsgUid()));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.group.BIMValueCallBack
        public void onResult(int i, String str, ArrayList<GroupInfo> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, arrayList) == null) {
                if (i == 0 && arrayList != null && this.mGroupMap != null) {
                    Iterator<GroupInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        GroupInfo next = it.next();
                        ChatSession chatSession = this.mGroupMap.get(next.getGroupId());
                        if (chatSession != null) {
                            updateChatSessionByGroupInfo(chatSession, next);
                            this.this$0.mResultList.add(chatSession);
                        }
                    }
                }
                this.this$0.callBack(i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class GetPaInfosListener implements IGetPaInfosListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<Long, ChatSession> mPaMap;
        public final /* synthetic */ IMMediaBuildSessionListener this$0;

        public GetPaInfosListener(IMMediaBuildSessionListener iMMediaBuildSessionListener, Map<Long, ChatSession> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMMediaBuildSessionListener, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMMediaBuildSessionListener;
            this.mPaMap = map;
        }

        private void updateChatSessionByPaInfo(ChatSession chatSession, PaInfo paInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65537, this, chatSession, paInfo) == null) && chatSession != null && paInfo != null && chatSession.getChatType() != 58 && chatSession.getBusinessType() != 27) {
                if (chatSession.getClassType() > 0) {
                    chatSession.setLastMsgName(paInfo.getNickName());
                    chatSession.setNewMsgSum(ChatMessageDBManager.getInstance(this.this$0.mContext).getNewMsgCountOfClass(chatSession.getClassType()));
                } else {
                    chatSession.setName(paInfo.getNickName());
                    chatSession.setChatType(paInfo.getSubtype());
                    chatSession.setBusinessType(Utility.getBusinessType(paInfo.getSubtype(), paInfo.getSubsetType()));
                    chatSession.setIconUrl(paInfo.getAvatar());
                    chatSession.setClassType(paInfo.getClassType());
                    chatSession.setClassTitle(paInfo.getClassTitle());
                    chatSession.setClassAvatar(paInfo.getClassavatar());
                    chatSession.setClassShow(paInfo.getClassshow());
                    chatSession.setVipId(paInfo.getVipId());
                    chatSession.setVPortrait(paInfo.getVPortrait());
                    chatSession.setCertification(paInfo.getIdentity());
                }
                boolean z = false;
                if (chatSession.getClassType() <= 0 && (paInfo.getShield() != chatSession.getShield() || paInfo.getShieldTime() != chatSession.getShieldTime() || paInfo.getMarkTop() != chatSession.getMarkTop() || paInfo.getMarkTopTime() != chatSession.getMarkTopTime())) {
                    z = true;
                    paInfo.setMarkTop(chatSession.getMarkTop());
                    paInfo.setMarkTopTime(chatSession.getLastMsgTime());
                    paInfo.setShield(chatSession.getShield());
                    paInfo.setShieldTime(chatSession.getShieldTime());
                }
                PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.this$0.mContext).queryPaInfo(paInfo.getPaId());
                if (queryPaInfo == null || queryPaInfo.getPaId() < 1 || z) {
                    PaInfoDBManager.getInstance(this.this$0.mContext).subscribePa(paInfo);
                }
            }
        }

        @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
        public void onResult(int i, String str, ArrayList<PaInfo> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, arrayList) == null) {
                if (i == 0 && arrayList != null && this.mPaMap != null) {
                    Iterator<PaInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        PaInfo next = it.next();
                        ChatSession chatSession = this.mPaMap.get(Long.valueOf(next.getPaId()));
                        if (chatSession != null) {
                            updateChatSessionByPaInfo(this.mPaMap.get(Long.valueOf(next.getPaId())), next);
                            this.this$0.mResultList.add(chatSession);
                        }
                    }
                }
                this.this$0.callBack(i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class GetUserIdentityListener implements IGetUsersProfileBatchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<Long, ChatSession> mUserMap;
        public final /* synthetic */ IMMediaBuildSessionListener this$0;

        public GetUserIdentityListener(IMMediaBuildSessionListener iMMediaBuildSessionListener, Map<Long, ChatSession> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMMediaBuildSessionListener, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMMediaBuildSessionListener;
            this.mUserMap = map;
        }

        private void updateChatSessionByChatUser(ChatSession chatSession, ChatUser chatUser) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65537, this, chatSession, chatUser) == null) && chatSession != null && chatUser != null) {
                chatSession.setName(chatUser.getUserName());
                chatSession.setChatType(0);
                chatSession.setBusinessType(1);
                chatSession.setIconUrl(chatUser.getIconUrl());
                chatSession.setClassType(0);
                chatSession.setClassShow(0);
                chatSession.setVipId(chatUser.getVipId());
                chatSession.setVPortrait(chatUser.getVPortrait());
                chatSession.setCertification(chatUser.getIdentity());
                chatSession.setContacter(chatUser.getUk());
                chatSession.setSubscribe(chatUser.getSubscribe());
                if (chatSession.getShield() != chatUser.getShield() || chatSession.getShieldTime() != chatUser.getShieldTime() || chatSession.getMarkTop() != chatUser.getMarkTop() || chatSession.getMarkTopTime() != chatUser.getMarkTop()) {
                    chatUser.setMarkTop(chatSession.getMarkTop());
                    chatUser.setMarkTopTime(chatSession.getLastMsgTime());
                    chatUser.setShield(chatSession.getShield());
                    chatUser.setShieldTime(chatSession.getShieldTime());
                    ChatUserDBManager.getInstance(this.this$0.mContext).updateUser(chatUser);
                }
            }
        }

        @Override // com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener
        public void onGetUsersProfileBatchResult(int i, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, arrayList, arrayList2}) == null) {
                if (i == 0 && arrayList2 != null && this.mUserMap != null) {
                    Iterator<ChatUser> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ChatUser next = it.next();
                        ChatSession chatSession = this.mUserMap.get(Long.valueOf(next.getBuid()));
                        if (chatSession != null) {
                            updateChatSessionByChatUser(chatSession, next);
                            this.this$0.mResultList.add(chatSession);
                        }
                    }
                }
                this.this$0.callBack(i);
            }
        }
    }

    public IMMediaBuildSessionListener(Context context, int i, int i2, int i3, boolean z, IMListener iMListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), iMListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNewNum = 0;
        this.mConsultUnreadNum = 0;
        this.mHasMore = false;
        this.mTopHasMore = 0;
        this.mResultList = Collections.synchronizedList(new ArrayList());
        this.mGetPaInfosListener = null;
        this.mGetUserIdentityListener = null;
        this.mGetGroupInfoListener = null;
        this.mResultCode = 0;
        this.count = new AtomicInteger(0);
        this.mContext = context;
        this.mNewNum = i;
        this.mConsultUnreadNum = i2;
        this.mHasMore = z;
        this.mListener = iMListener;
        this.mTopHasMore = i3;
    }

    public IMMediaBuildSessionListener(Context context, IMListener iMListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iMListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNewNum = 0;
        this.mConsultUnreadNum = 0;
        this.mHasMore = false;
        this.mTopHasMore = 0;
        this.mResultList = Collections.synchronizedList(new ArrayList());
        this.mGetPaInfosListener = null;
        this.mGetUserIdentityListener = null;
        this.mGetGroupInfoListener = null;
        this.mResultCode = 0;
        this.count = new AtomicInteger(0);
        this.mContext = context;
        this.mListener = iMListener;
    }

    public BIMValueCallBack<ArrayList<GroupInfo>> getGroupInfoListener(Map<String, ChatSession> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            if (this.mGetGroupInfoListener == null) {
                this.mGetGroupInfoListener = new GetGroupInfoListener(this, map);
                this.count.incrementAndGet();
            }
            return this.mGetGroupInfoListener;
        }
        return (BIMValueCallBack) invokeL.objValue;
    }

    public IGetPaInfosListener getPaInfosListener(Map<Long, ChatSession> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            if (this.mGetPaInfosListener == null) {
                this.mGetPaInfosListener = new GetPaInfosListener(this, map);
                this.count.incrementAndGet();
            }
            return this.mGetPaInfosListener;
        }
        return (IGetPaInfosListener) invokeL.objValue;
    }

    public IGetUsersProfileBatchListener getUserIdentityListener(Map<Long, ChatSession> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            if (this.mGetUserIdentityListener == null) {
                this.mGetUserIdentityListener = new GetUserIdentityListener(this, map);
                this.count.incrementAndGet();
            }
            return this.mGetUserIdentityListener;
        }
        return (IGetUsersProfileBatchListener) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBack(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            this.mResultCode |= i;
            if (this.count.decrementAndGet() == 0 && this.mListener != null) {
                if (this.mResultList.size() > 0) {
                    this.mResultCode = 0;
                } else {
                    this.mResultCode = i;
                }
                onResult(0, this.mResultList, this.mListener);
            }
        }
    }

    public void onResult(int i, List<ChatSession> list, IMListener iMListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, list, iMListener) == null) {
            if (iMListener instanceof IGetMediaMixedChatSessionListener) {
                ((IGetMediaMixedChatSessionListener) iMListener).onMediaGetChatSessionResult(i, this.mNewNum, this.mConsultUnreadNum, this.mTopHasMore, this.mHasMore, list);
            } else if (iMListener instanceof IMediaGetChatSessionListener) {
                ((IMediaGetChatSessionListener) iMListener).onMediaGetChatSessionResult(i, this.mNewNum, this.mTopHasMore, this.mHasMore, list);
            } else if (iMListener instanceof IMFetchBusinessSessionMsg.CompleteSessionInfoListener) {
                ((IMFetchBusinessSessionMsg.CompleteSessionInfoListener) iMListener).onResult(i, "", list);
            }
        }
    }
}
