package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupInfo;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes10.dex */
public class IMMediaBuildSessionListener implements IMListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMediaBuildSessionListener";
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger count;
    public Context mContext;
    public BIMValueCallBack<ArrayList<GroupInfo>> mGetGroupInfoListener;
    public IGetPaInfosListener mGetPaInfosListener;
    public IGetUserIdentityListener mGetUserIdentityListener;
    public boolean mHasMore;
    public IMediaGetChatSessionListener mListener;
    public int mNewNum;
    public int mResultCode;
    public List<ChatSession> mResultList;
    public int mTopHasMore;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMMediaBuildSessionListener;
            this.mGroupMap = map;
        }

        private void updateChatSessionByGroupInfo(ChatSession chatSession, GroupInfo groupInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65537, this, chatSession, groupInfo) == null) || chatSession == null || groupInfo == null) {
                return;
            }
            chatSession.setName(groupInfo.getGroupName());
            chatSession.setChatType(groupInfo.getType() == 3 ? 57 : 3);
            chatSession.setBusinessType(2);
            chatSession.setIconUrl(groupInfo.getHeadUrl());
            if (chatSession.getLastMsgUid() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(chatSession.getLastMsgUid()));
                ArrayList<GroupMember> groupMember = GroupInfoDAOImpl.getGroupMember(this.this$0.mContext, groupInfo.getGroupId(), arrayList, 1);
                if (groupMember == null || groupMember.size() <= 0) {
                    return;
                }
                chatSession.setLastMsgName(groupMember.get(0).getShowName());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.group.BIMValueCallBack
        public void onResult(int i2, String str, ArrayList<GroupInfo> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, arrayList) == null) {
                if (i2 == 0 && arrayList != null && this.mGroupMap != null) {
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
                this.this$0.callBack(i2);
            }
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeLL(65537, this, chatSession, paInfo) == null) || chatSession == null || paInfo == null) {
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
                PaInfo queryPaInfo = PaInfoDBManager.getInstance(this.this$0.mContext).queryPaInfo(paInfo.getPaId());
                if (queryPaInfo == null || queryPaInfo.getPaId() < 1) {
                    paInfo.setMarkTop(chatSession.getMarkTop());
                    paInfo.setMarkTopTime(chatSession.getLastMsgTime());
                    PaInfoDBManager.getInstance(this.this$0.mContext).subscribePa(paInfo);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
        public void onResult(int i2, String str, ArrayList<PaInfo> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, arrayList) == null) {
                if (i2 == 0 && arrayList != null && this.mPaMap != null) {
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
                this.this$0.callBack(i2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class GetUserIdentityListener implements IGetUserIdentityListener {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeLL(65537, this, chatSession, chatUser) == null) || chatSession == null || chatUser == null) {
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
                ChatUser chatUser2 = ChatUserDBManager.getInstance(this.this$0.mContext).getChatUser(chatUser.getUk());
                if (chatUser2 == null || chatUser2.getUk() < 1) {
                    chatUser.setMarkTop(chatSession.getMarkTop());
                    chatUser.setMarkTopTime(chatSession.getLastMsgTime());
                    ChatUserDBManager.getInstance(this.this$0.mContext).updateUser(chatUser);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
        public void onGetUserIdentityResult(int i2, List<ChatUser> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, list) == null) {
                if (i2 == 0 && list != null && this.mUserMap != null) {
                    for (ChatUser chatUser : list) {
                        ChatSession chatSession = this.mUserMap.get(Long.valueOf(chatUser.getBuid()));
                        if (chatSession != null) {
                            updateChatSessionByChatUser(chatSession, chatUser);
                            this.this$0.mResultList.add(chatSession);
                        }
                    }
                }
                this.this$0.callBack(i2);
            }
        }
    }

    public IMMediaBuildSessionListener(Context context, int i2, int i3, boolean z, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), iMediaGetChatSessionListener};
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
        this.mHasMore = false;
        this.mTopHasMore = 0;
        this.mResultList = Collections.synchronizedList(new ArrayList());
        this.mGetPaInfosListener = null;
        this.mGetUserIdentityListener = null;
        this.mGetGroupInfoListener = null;
        this.mResultCode = 0;
        this.count = new AtomicInteger(0);
        this.mContext = context;
        this.mNewNum = i2;
        this.mHasMore = z;
        this.mListener = iMediaGetChatSessionListener;
        this.mTopHasMore = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBack(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
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

    public IGetUserIdentityListener getUserIdentityListener(Map<Long, ChatSession> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            if (this.mGetUserIdentityListener == null) {
                this.mGetUserIdentityListener = new GetUserIdentityListener(this, map);
                this.count.incrementAndGet();
            }
            return this.mGetUserIdentityListener;
        }
        return (IGetUserIdentityListener) invokeL.objValue;
    }
}
