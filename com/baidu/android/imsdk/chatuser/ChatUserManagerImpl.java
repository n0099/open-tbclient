package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.t.a;
import com.baidu.android.imsdk.Filter;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IGetUidByUkListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.chatuser.request.IMGetUserIdentityRequest;
import com.baidu.android.imsdk.chatuser.request.IMGetUserIpLocation;
import com.baidu.android.imsdk.chatuser.request.IMGetUsersStatusRequest;
import com.baidu.android.imsdk.chatuser.request.IMUserQueryRequest;
import com.baidu.android.imsdk.chatuser.request.IMUserSetRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ChatUserManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ChatUserManagerImpl";
    public static Context mContext;
    public static volatile ChatUserManagerImpl mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Filter filter;
    public LongSparseArray<ChatUser> mWaitSyncDisturbUKs;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1837512118, "Lcom/baidu/android/imsdk/chatuser/ChatUserManagerImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1837512118, "Lcom/baidu/android/imsdk/chatuser/ChatUserManagerImpl;");
        }
    }

    public ChatUserManagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mWaitSyncDisturbUKs = new LongSparseArray<>();
        this.filter = new Filter(this) { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatUserManagerImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.imsdk.Filter
            public void fileter(List<ChatMsg> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    Iterator<ChatMsg> it = list.iterator();
                    while (it.hasNext()) {
                        ChatMsg next = it.next();
                        long fromUser = next.getFromUser();
                        if (fromUser == AccountManager.getUK(ChatUserManagerImpl.mContext)) {
                            fromUser = next.getContacter();
                        }
                        if (next.getCategory() == 0 && (Constants.PAFLAG & fromUser) == 0 && !this.this$0.isUserExist(fromUser)) {
                            it.remove();
                        }
                    }
                }
            }
        };
        Class<?>[] clsArr = {IMGetUserIpLocation.class, IMGetUsersStatusRequest.class};
        int[] iArr = {91, 21};
        for (int i4 = 0; i4 < 2; i4++) {
            MessageFactory.getInstance().addType(iArr[i4], clsArr[i4]);
        }
    }

    public static ChatUserManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (mInstance == null) {
                synchronized (ChatUserManagerImpl.class) {
                    if (mInstance == null) {
                        mContext = context.getApplicationContext();
                        mInstance = new ChatUserManagerImpl();
                    }
                }
            }
            return mInstance;
        }
        return (ChatUserManagerImpl) invokeL.objValue;
    }

    private void requestUserIdentity(List<Long> list, IGetUserIdentityListener iGetUserIdentityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, list, iGetUserIdentityListener) == null) {
            IMGetUserIdentityRequest iMGetUserIdentityRequest = new IMGetUserIdentityRequest(mContext, list, iGetUserIdentityListener);
            HttpHelper.executor(mContext, iMGetUserIdentityRequest, iMGetUserIdentityRequest);
        }
    }

    private ChatUser syncUserDisturbExtra(ChatUser chatUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, chatUser)) == null) {
            if (chatUser != null && this.mWaitSyncDisturbUKs.size() > 0 && this.mWaitSyncDisturbUKs.get(chatUser.getUk()) != null) {
                ChatUser chatUser2 = this.mWaitSyncDisturbUKs.get(chatUser.getUk());
                chatUser.setDisturb(chatUser2.getDisturb());
                chatUser.setBlack(chatUser2.getBlack());
                ChatUserDBManager.getInstance(mContext).updateUser(chatUser);
                this.mWaitSyncDisturbUKs.delete(chatUser.getUk());
                LogUtils.d(TAG, "onGetUsersProfileBatchResult add disturb and black value");
            }
            return chatUser;
        }
        return (ChatUser) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUserInfoToDB(int i2, List<ChatUser> list, String str, ArrayList<Long> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i2), list, str, arrayList}) == null) {
            if (i2 == 0) {
                onGetUsersProfileBatchResult(str, 0, Constants.ERROR_MSG_SUCCESS, arrayList, (ArrayList) list);
                for (ChatUser chatUser : list) {
                    IMUserManager.getInstance(mContext).updateUser(chatUser);
                    ChatMessageDBManager.getInstance(mContext).updateSessionClass(chatUser);
                }
                return;
            }
            onGetUsersProfileBatchResult(str, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList, null);
        }
    }

    public ArrayList<ChatUser> getChatUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ChatUserDBManager.getInstance(mContext).getChatUser() : (ArrayList) invokeV.objValue;
    }

    public ChatUser getChatUserSync(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            ChatUser chatUser = ChatUserDBManager.getInstance(mContext).getChatUser(j2);
            if (chatUser == null) {
                return chatUser;
            }
            if (chatUser.getBuid() <= 0) {
                getUser(j2, 1, null);
            }
            return syncUserDisturbExtra(chatUser);
        }
        return (ChatUser) invokeJ.objValue;
    }

    public void getUKbyBuid(long j2, IGetUkByBuidListener iGetUkByBuidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, iGetUkByBuidListener) == null) {
            long uKbyBuid = IMUserManager.getInstance(mContext).getUKbyBuid(j2);
            if (uKbyBuid < 0) {
                getUserByBuid(j2, 0, new IGetUserListener(this, iGetUkByBuidListener, j2) { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatUserManagerImpl this$0;
                    public final /* synthetic */ long val$buid;
                    public final /* synthetic */ IGetUkByBuidListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iGetUkByBuidListener, Long.valueOf(j2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = iGetUkByBuidListener;
                        this.val$buid = j2;
                    }

                    @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                    public void onGetUserResult(int i2, long j3, ChatUser chatUser) {
                        IGetUkByBuidListener iGetUkByBuidListener2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j3), chatUser}) == null) || (iGetUkByBuidListener2 = this.val$listener) == null) {
                            return;
                        }
                        if (chatUser != null) {
                            iGetUkByBuidListener2.onFetchUk(i2, this.val$buid, chatUser.getUk());
                        } else {
                            iGetUkByBuidListener2.onFetchUk(i2, this.val$buid, -1L);
                        }
                    }
                });
            } else if (iGetUkByBuidListener != null) {
                iGetUkByBuidListener.onFetchUk(0, j2, uKbyBuid);
            }
        }
    }

    public void getUnconcernedUserDisturb(IGetUnconcernedMsgListener iGetUnconcernedMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iGetUnconcernedMsgListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iGetUnconcernedMsgListener);
            Context context = mContext;
            IMUserQueryRequest iMUserQueryRequest = new IMUserQueryRequest(context, AccountManager.getAppid(context), addListener);
            HttpHelper.executor(mContext, iMUserQueryRequest, iMUserQueryRequest);
        }
    }

    public void getUser(long j2, int i2, IGetUserListener iGetUserListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), iGetUserListener}) == null) {
            if (j2 <= 0) {
                j2 = com.baidu.android.imsdk.utils.Utility.getUK(mContext);
            }
            long j3 = j2;
            String addListener = ListenerManager.getInstance().addListener(iGetUserListener);
            String str = TAG;
            LogUtils.d(str, "getUser uid:" + j3);
            if (!com.baidu.android.imsdk.utils.Utility.isContacterCorrect(j3)) {
                onGetUserResult(mContext, i2, addListener, 1005, j3);
            } else if (AccountManager.isLogin(mContext)) {
                if (IMUserManager.getInstance(mContext).isUserExist(j3)) {
                    String str2 = TAG;
                    LogUtils.d(str2, "isUserExist:" + j3);
                    onGetUserResult(mContext, i2, addListener, 0, j3);
                    return;
                }
                String str3 = TAG;
                LogUtils.d(str3, "updateUserProfileByUks:" + j3);
                updateUserProfileByUks(new long[]{j3}, true, addListener);
            } else {
                String str4 = TAG;
                LogUtils.d(str4, "ACCOUNT_NOT_LOGIN:" + j3);
                onGetUserResult(mContext, i2, addListener, 1000, j3);
            }
        }
    }

    public void getUserByBuid(long j2, int i2, IGetUserListener iGetUserListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), iGetUserListener}) == null) {
            if (j2 <= 0) {
                j2 = com.baidu.android.imsdk.utils.Utility.getBuid(mContext);
            }
            long j3 = j2;
            String addListener = ListenerManager.getInstance().addListener(iGetUserListener);
            if (!com.baidu.android.imsdk.utils.Utility.isContacterCorrect(j3)) {
                onGetUserResultByBuid(mContext, i2, addListener, 1005, j3);
            } else if (AccountManager.isLogin(mContext)) {
                long uKbyBuid = IMUserManager.getInstance(mContext).getUKbyBuid(j3);
                if (uKbyBuid > -1 && IMUserManager.getInstance(mContext).isUserExist(uKbyBuid)) {
                    onGetUserResultByBuid(mContext, i2, addListener, 0, j3);
                } else {
                    updateUserProfileByUks(new long[]{j3}, true, addListener);
                }
            } else {
                onGetUserResultByBuid(mContext, i2, addListener, 1000, j3);
            }
        }
    }

    public void getUserIp(int i2, ArrayList<Long> arrayList, IGetUserIpListener iGetUserIpListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, arrayList, iGetUserIpListener) == null) {
            String str = TAG;
            LogUtils.d(str, "getUserIp----Start: " + arrayList);
            String addListener = ListenerManager.getInstance().addListener(iGetUserIpListener);
            if (arrayList != null && arrayList.size() != 0) {
                if (AccountManager.isLogin(mContext)) {
                    Intent creatMethodIntent = com.baidu.android.imsdk.utils.Utility.creatMethodIntent(mContext, 91);
                    creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Constants.EXTRA_UIDS, arrayList);
                    creatMethodIntent.putExtras(bundle);
                    creatMethodIntent.putExtra(Constants.EXTRA_SAVE_TO_DB, i2);
                    try {
                        a.g(mContext).f(mContext, creatMethodIntent);
                        return;
                    } catch (Exception e2) {
                        ListenerManager.getInstance().removeListener(addListener);
                        onGetUserIpResult(mContext, i2, addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, arrayList, null);
                        LogUtils.e(TAG, "Exception ", e2);
                        return;
                    }
                }
                LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                onGetUserIpResult(mContext, i2, addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, arrayList, null);
                return;
            }
            onGetUserIpResult(mContext, i2, addListener, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList, null);
        }
    }

    public void getUsersProfileBatch(ArrayList<Long> arrayList, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, arrayList, iGetUsersProfileBatchListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iGetUsersProfileBatchListener);
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<ChatUser> arrayList2 = new ArrayList<>();
                Iterator<Long> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatUser chatUserByBuid = ChatUserDBManager.getInstance(mContext).getChatUserByBuid(it.next().longValue());
                    if (chatUserByBuid != null) {
                        arrayList2.add(chatUserByBuid);
                    }
                }
                if (arrayList2.size() > 0) {
                    onGetUsersProfileBatchResult(addListener, 0, Constants.ERROR_MSG_SUCCESS, arrayList, arrayList2);
                    return;
                }
                String str = TAG;
                LogUtils.d(str, "getUsersProfileBatch uks :" + arrayList.toString());
                updateUserIdentity(arrayList, new IGetUserIdentityListener(this, addListener, arrayList) { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatUserManagerImpl this$0;
                    public final /* synthetic */ String val$key;
                    public final /* synthetic */ ArrayList val$usersId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, addListener, arrayList};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$key = addListener;
                        this.val$usersId = arrayList;
                    }

                    @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                    public void onGetUserIdentityResult(int i2, List<ChatUser> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                            this.this$0.updateUserInfoToDB(i2, list, this.val$key, this.val$usersId);
                        }
                    }
                });
                return;
            }
            onGetUsersProfileBatchResult(addListener, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList, null);
        }
    }

    public void getUsersProfileBatchByBuid(ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{arrayList, Boolean.valueOf(z), iGetUsersProfileBatchListener}) == null) {
            String addListener = ListenerManager.getInstance().addListener(iGetUsersProfileBatchListener);
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<ChatUser> arrayList2 = new ArrayList<>();
                Iterator<Long> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatUser chatUserByBuid = ChatUserDBManager.getInstance(mContext).getChatUserByBuid(it.next().longValue());
                    if (chatUserByBuid != null) {
                        arrayList2.add(chatUserByBuid);
                    }
                }
                if (arrayList2.size() > 0 && arrayList2.size() >= arrayList.size()) {
                    onGetUsersProfileBatchResult(addListener, 0, Constants.ERROR_MSG_SUCCESS, arrayList, arrayList2);
                    return;
                }
                String str = TAG;
                LogUtils.d(str, "getUsersProfileBatchByBuid buids :" + arrayList.toString());
                updateUserIdentity(arrayList, new IGetUserIdentityListener(this, addListener, arrayList) { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatUserManagerImpl this$0;
                    public final /* synthetic */ ArrayList val$buids;
                    public final /* synthetic */ String val$key;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, addListener, arrayList};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$key = addListener;
                        this.val$buids = arrayList;
                    }

                    @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                    public void onGetUserIdentityResult(int i2, List<ChatUser> list) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                            this.this$0.updateUserInfoToDB(i2, list, this.val$key, this.val$buids);
                        }
                    }
                });
                return;
            }
            onGetUsersProfileBatchResult(addListener, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList, null);
        }
    }

    public void getUsersStatus(ArrayList<Long> arrayList, IGetUserStatusListener iGetUserStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, arrayList, iGetUserStatusListener) == null) {
            String addListener = ListenerManager.getInstance().addListener(iGetUserStatusListener);
            if (arrayList != null && arrayList.size() >= 1) {
                if (!RequsetNetworkUtils.isConnected(mContext)) {
                    onGetUsersStatusResult(addListener, 1001, Constants.ERROR_MSG_NETWORK_ERROR, null);
                    return;
                } else if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
                    Intent creatMethodIntent = com.baidu.android.imsdk.utils.Utility.creatMethodIntent(mContext, 21);
                    creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Constants.EXTRA_UIDS, arrayList);
                    creatMethodIntent.putExtras(bundle);
                    try {
                        a.g(mContext).f(mContext, creatMethodIntent);
                        return;
                    } catch (Exception e2) {
                        ListenerManager.getInstance().removeListener(addListener);
                        onGetUsersStatusResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, null);
                        LogUtils.e(TAG, "Exception ", e2);
                        return;
                    }
                } else {
                    LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
                    onGetUsersStatusResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
                    return;
                }
            }
            onGetUsersStatusResult(addListener, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        }
    }

    public boolean isUserExist(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) ? IMUserManager.getInstance(mContext).isUserExist(j2) : invokeJ.booleanValue;
    }

    public void onGetUserIpResult(Context context, int i2, String str, int i3, String str2, ArrayList<Long> arrayList, ArrayList<IpInfo> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Integer.valueOf(i2), str, Integer.valueOf(i3), str2, arrayList, arrayList2}) == null) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener != null && (removeListener instanceof IGetUserIpListener)) {
                ((IGetUserIpListener) removeListener).onGetUserIpResult(i3, str2, arrayList, arrayList2);
                return;
            }
            String str3 = TAG;
            LogUtils.d(str3, "onGetUserIpResult --errorCode:" + i3 + "---strMsg:" + str2 + "--listener:" + removeListener);
        }
    }

    public void onGetUserResult(Context context, int i2, String str, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i2), str, Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener != null && (removeListener instanceof IGetUserListener)) {
                IGetUserListener iGetUserListener = (IGetUserListener) removeListener;
                ChatUser chatUser = IMUserManager.getInstance(mContext).getChatUser(j2);
                String str2 = TAG;
                LogUtils.d(str2, "onGetUserResult :" + chatUser);
                if (chatUser != null) {
                    String str3 = TAG;
                    LogUtils.d(str3, "onGetUserResult: " + chatUser.getUserName());
                }
                iGetUserListener.onGetUserResult(i3, j2, chatUser);
                return;
            }
            LogUtils.d(TAG, "onGetUserResult IGetUserListener is null!");
        }
    }

    public void onGetUserResultByBuid(Context context, int i2, String str, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Integer.valueOf(i2), str, Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener != null && (removeListener instanceof IGetUserListener)) {
                IGetUserListener iGetUserListener = (IGetUserListener) removeListener;
                long uKbyBuid = IMUserManager.getInstance(mContext).getUKbyBuid(j2);
                if (uKbyBuid > 0) {
                    ChatUser chatUser = IMUserManager.getInstance(mContext).getChatUser(uKbyBuid);
                    if (chatUser != null) {
                        String str2 = TAG;
                        LogUtils.d(str2, "onGetUserResultByBuid: " + chatUser.getUserName());
                    }
                    iGetUserListener.onGetUserResult(i3, j2, chatUser);
                    return;
                }
                iGetUserListener.onGetUserResult(i3, j2, null);
                return;
            }
            LogUtils.d(TAG, "onGetUserResultByBuid IGetUserListener is null!");
        }
    }

    public void onGetUsersProfileBatchResult(String str, int i2, String str2, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, Integer.valueOf(i2), str2, arrayList, arrayList2}) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onGetUsersProfileBatchResult----errorCode: " + i2);
            if (arrayList2 != null) {
                Iterator<ChatUser> it = arrayList2.iterator();
                while (it.hasNext()) {
                    ChatUser next = it.next();
                    String str4 = TAG;
                    LogUtils.d(str4, "onGetUsersProfileBatchResult ChatUser: " + next.toString());
                    String iconUrl = next.getIconUrl();
                    if (!TextUtils.isEmpty(iconUrl)) {
                        next.setIconUrl(iconUrl.replace("http://himg", "https://himg"));
                    }
                    String tinyUrl = next.getTinyUrl();
                    if (!TextUtils.isEmpty(tinyUrl)) {
                        next.setTinyUrl(tinyUrl.replace("http://himg", "https://himg"));
                    }
                }
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener != null && (removeListener instanceof IGetUsersProfileBatchListener)) {
                ((IGetUsersProfileBatchListener) removeListener).onGetUsersProfileBatchResult(i2, str2, arrayList, arrayList2);
            } else {
                LogUtils.d(TAG, "onGetUsersProfileBatchResult is null");
            }
        }
    }

    public void onGetUsersStatusResult(String str, int i2, String str2, ArrayList<UserStatus> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048592, this, str, i2, str2, arrayList) == null) {
            String str3 = TAG;
            LogUtils.d(str3, "onGetUsersStatusResult----errorCode: " + i2);
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener != null && (removeListener instanceof IGetUserStatusListener)) {
                ((IGetUserStatusListener) removeListener).onGetUsersStatusResult(i2, str2, arrayList);
            } else {
                LogUtils.d(TAG, "onGetUsersStatusResult is null");
            }
        }
    }

    public void onQueryResult(int i2, String str, List<ChatUser> list, String str2) {
        IMListener removeListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), str, list, str2}) == null) {
            if (list != null) {
                for (ChatUser chatUser : list) {
                    if (chatUser.getUk() == -2) {
                        Context context = mContext;
                        com.baidu.android.imsdk.utils.Utility.writeIntData(context, Constants.KEY_USER_SETTING_NOT_CONCERNED + AccountManager.getUK(mContext), chatUser.getDisturb());
                    } else {
                        ChatUser chatUser2 = ChatUserDBManager.getInstance(mContext).getChatUser(chatUser.getUk());
                        if (chatUser2 != null) {
                            chatUser2.setDisturb(chatUser.getDisturb());
                            chatUser2.setBlack(chatUser.getBlack());
                            ChatUserDBManager.getInstance(mContext).updateUser(chatUser2);
                            String str3 = TAG;
                            LogUtils.d(str3, "user onQueryResult --->" + chatUser.toString());
                        } else {
                            this.mWaitSyncDisturbUKs.put(chatUser.getUk(), chatUser);
                            String str4 = TAG;
                            LogUtils.d(str4, "wattting user onQueryResult --->" + chatUser.getUk());
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str2) || (removeListener = ListenerManager.getInstance().removeListener(str2)) == null || !(removeListener instanceof IGetUnconcernedMsgListener)) {
                return;
            }
            String str5 = TAG;
            LogUtils.d(str5, "call back for IGetUnconcernedMsgListener error = " + i2);
            Context context2 = mContext;
            ((IGetUnconcernedMsgListener) removeListener).onResult(i2, com.baidu.android.imsdk.utils.Utility.readIntData(context2, Constants.KEY_USER_SETTING_NOT_CONCERNED + AccountManager.getUK(mContext), 0));
        }
    }

    public void onSetPrivacyResult(String str, int i2, String str2, long j2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            IUserPrivacyListener iUserPrivacyListener = (IUserPrivacyListener) ListenerManager.getInstance().removeListener(str);
            if (iUserPrivacyListener != null) {
                if (i2 == 0) {
                    if (j2 == -2) {
                        Context context = mContext;
                        com.baidu.android.imsdk.utils.Utility.writeIntData(context, Constants.KEY_USER_SETTING_NOT_CONCERNED + AccountManager.getUK(mContext), i3);
                    } else {
                        ChatUser chatUser = ChatUserDBManager.getInstance(mContext).getChatUser(j2);
                        if (chatUser != null) {
                            if (i3 != -1) {
                                chatUser.setDisturb(i3);
                            }
                            if (i4 != -1) {
                                chatUser.setBlack(i4);
                            }
                            ChatUserDBManager.getInstance(mContext).updateUser(chatUser);
                        }
                    }
                }
                iUserPrivacyListener.onResult(i2, str2);
                return;
            }
            LogUtils.d(TAG, "IRetrieveServicesListener is null");
        }
    }

    public void setUserPrivacy(long j2, int i2, int i3, IUserPrivacyListener iUserPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), iUserPrivacyListener}) == null) {
            IMUserSetRequest iMUserSetRequest = new IMUserSetRequest(mContext, ListenerManager.getInstance().addListener(iUserPrivacyListener), j2 == -2 ? -2L : IMUserManager.getInstance(mContext).getUKbyBuid(j2), AccountManager.getAppid(mContext), i2, i3);
            HttpHelper.executor(mContext, iMUserSetRequest, iMUserSetRequest);
        }
    }

    public void syncUsersAttr() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Context context = mContext;
            IMUserQueryRequest iMUserQueryRequest = new IMUserQueryRequest(context, AccountManager.getAppid(context));
            HttpHelper.executor(mContext, iMUserQueryRequest, iMUserQueryRequest);
        }
    }

    public void updateUserIdentity(List<Long> list, @NonNull IGetUserIdentityListener iGetUserIdentityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, list, iGetUserIdentityListener) == null) {
            if (list != null && list.size() > 0) {
                String str = TAG;
                LogUtils.d(str, "updateUserIdentity bduids :" + list.toString());
                int size = list.size() / 20;
                int i2 = 0;
                while (i2 < size) {
                    int i3 = i2 * 20;
                    i2++;
                    requestUserIdentity(list.subList(i3, i2 * 20), iGetUserIdentityListener);
                }
                if (list.size() % 20 > 0) {
                    requestUserIdentity(list.subList(size * 20, list.size()), iGetUserIdentityListener);
                    return;
                }
                return;
            }
            iGetUserIdentityListener.onGetUserIdentityResult(1005, null);
        }
    }

    public void updateUserProfileByUks(long[] jArr, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{jArr, Boolean.valueOf(z), str}) == null) {
            AccountManagerImpl.getInstance(mContext).getUidByUk(jArr, new IGetUidByUkListener(this, str) { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatUserManagerImpl this$0;
                public final /* synthetic */ String val$key;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$key = str;
                }

                @Override // com.baidu.android.imsdk.account.IGetUidByUkListener
                public void onGetUidByUkResult(int i2, String str2, long[] jArr2, Map<Long, Long> map) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, jArr2, map}) == null) {
                        if (i2 != 0) {
                            if (TextUtils.isEmpty(this.val$key)) {
                                return;
                            }
                            this.this$0.onGetUserResult(ChatUserManagerImpl.mContext, 0, this.val$key, 1011, -1L);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (Map.Entry<Long, Long> entry : map.entrySet()) {
                            if (entry.getValue().longValue() > 0) {
                                arrayList.add(entry.getValue());
                            }
                        }
                        String str3 = ChatUserManagerImpl.TAG;
                        LogUtils.d(str3, "updateUserProfileByUks bduidList :" + arrayList.toString());
                        this.this$0.updateUserIdentity(arrayList, new IGetUserIdentityListener(this) { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                            public void onGetUserIdentityResult(int i3, List<ChatUser> list) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i3, list) == null) {
                                    if (i3 != 0 || list == null) {
                                        LogUtils.i(ChatUserManagerImpl.TAG, "updateUserProfileByUks fail");
                                        if (TextUtils.isEmpty(this.this$1.val$key)) {
                                            return;
                                        }
                                        this.this$1.this$0.onGetUserResult(ChatUserManagerImpl.mContext, 0, this.this$1.val$key, 0, -1L);
                                        return;
                                    }
                                    if (!TextUtils.isEmpty(this.this$1.val$key)) {
                                        AnonymousClass3 anonymousClass3 = this.this$1;
                                        anonymousClass3.this$0.onGetUserResult(anonymousClass3.val$key, list.get(0), 0, list.get(0).getUk());
                                    }
                                    for (ChatUser chatUser : list) {
                                        ChatUserDBManager.getInstance(ChatUserManagerImpl.mContext).updateUser(chatUser);
                                        ChatMessageDBManager.getInstance(ChatUserManagerImpl.mContext).updateSessionClass(chatUser);
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void onGetUserResult(String str, ChatUser chatUser, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, chatUser, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener instanceof IGetUserListener) {
                IGetUserListener iGetUserListener = (IGetUserListener) removeListener;
                if (chatUser != null) {
                    String str2 = TAG;
                    LogUtils.d(str2, "onGetUserResult: " + chatUser.toString());
                }
                iGetUserListener.onGetUserResult(i2, j2, chatUser);
                return;
            }
            LogUtils.d(TAG, "onGetUserResult IGetUserListener is null!");
        }
    }
}
