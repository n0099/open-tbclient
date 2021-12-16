package com.baidu.android.imsdk.box;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IGetMsgSettingSwitchListener;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.account.ISetMsgSettingSwitchListener;
import com.baidu.android.imsdk.account.ISetNotificationPrivacyListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.IFetchMessageListener;
import com.baidu.android.imsdk.chatmessage.IGetNewMsgCountListener;
import com.baidu.android.imsdk.chatmessage.IGetSessionListener;
import com.baidu.android.imsdk.chatmessage.IGetSmartChatSessionListener;
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.IOnRegisterNotifyListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.ISetMessageReadListener;
import com.baidu.android.imsdk.chatmessage.SessionClass;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUnconcernedMsgListener;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.IUserPrivacyListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupManagerImpl;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.notification.IFetchNotificationDataListener;
import com.baidu.android.imsdk.pubaccount.IAcceptPaPushListener;
import com.baidu.android.imsdk.pubaccount.IClickPaQuickReplyListener;
import com.baidu.android.imsdk.pubaccount.IGetPaInfoListener;
import com.baidu.android.imsdk.pubaccount.IGetPaInfosListener;
import com.baidu.android.imsdk.pubaccount.IGetQuickReplyListener;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.android.imsdk.pubaccount.IPaSubscriptionChangeListener;
import com.baidu.android.imsdk.pubaccount.IQuerySubscribedPaListListener;
import com.baidu.android.imsdk.pubaccount.ISubscribePaListener;
import com.baidu.android.imsdk.pubaccount.ISubscriptionChangeListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.shield.IGetDisturbListListener;
import com.baidu.android.imsdk.shield.IGetServiceNotifyMenuListener;
import com.baidu.android.imsdk.shield.IGetShieldAndTopListener;
import com.baidu.android.imsdk.shield.IGetSubscriptionListener;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.shield.ISetSubscriptionListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class IMBoxManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMBoxManager";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1737668202, "Lcom/baidu/android/imsdk/box/IMBoxManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1737668202, "Lcom/baidu/android/imsdk/box/IMBoxManager;");
        }
    }

    public IMBoxManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void acceptPaPush(Context context, long j2, boolean z, IAcceptPaPushListener iAcceptPaPushListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Long.valueOf(j2), Boolean.valueOf(z), iAcceptPaPushListener}) == null) {
            PaManager.acceptPaPush(context, j2, z, iAcceptPaPushListener);
        }
    }

    public static void clearToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            AccountManager.clearToken(context, null);
        }
    }

    public static void clearUid(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            AccountManager.clearUid(context);
        }
    }

    public static void clickPaQuickReply(Context context, long j2, String str, long j3, IClickPaQuickReplyListener iClickPaQuickReplyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, Long.valueOf(j2), str, Long.valueOf(j3), iClickPaQuickReplyListener}) == null) {
            PaManager.clickPaQuickReply(context, j2, str, j3, iClickPaQuickReplyListener);
        }
    }

    @Deprecated
    public static long deleteMsgs(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, context, j2)) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(0, j2, false);
        }
        return invokeLJ.longValue;
    }

    public static void disconnect(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            AccountManager.disconnect(context);
        }
    }

    public static boolean enableDebugMode(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, context, z)) == null) ? IMManager.enableDebugMode(context, z) : invokeLZ.booleanValue;
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, long j2, long j3, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)})) == null) ? ChatMsgManager.fetchMessageSync(context, 0, j2, j3, i2) : (ArrayList) invokeCommon.objValue;
    }

    public static void forwardMessage(Context context, String str, int i2, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, str, Integer.valueOf(i2), chatMsg, iSendMessageListener}) == null) {
            ChatMsgManager.forwardMessage(context, str, i2, chatMsg, iSendMessageListener);
        }
    }

    public static ArrayList<SessionClass> getAllClassType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? ChatMsgManager.getAllClassType(context) : (ArrayList) invokeL.objValue;
    }

    @Deprecated
    public static ArrayList<ChatSession> getChatRecordsByClass(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, list)) == null) ? ChatMsgManager.getChatRecordsByClass(context, list) : (ArrayList) invokeLL.objValue;
    }

    public static List<ChatSession> getChatSession(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) ? ChatMsgManager.getChatRecords(context) : (List) invokeL.objValue;
    }

    public static ChatUser getChatUserSync(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65558, null, context, j2)) == null) ? ChatUserManager.getChatUserSync(context, j2) : (ChatUser) invokeLJ.objValue;
    }

    public static void getGroupAndStrangerDisturbList(Context context, IGetDisturbListListener iGetDisturbListListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, iGetDisturbListListener) == null) {
            ShieldAndTopManager.getInstance(context).getGroupAndStrangerDisturbList(iGetDisturbListListener);
        }
    }

    public static void getMsgSettingSwitchStatus(Context context, IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, context, iGetMsgSettingSwitchListener) == null) {
            AccountManager.getMsgSettingSwitchStatus(context, iGetMsgSettingSwitchListener);
        }
    }

    @Deprecated
    public static int getNewCountOfClass(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65561, null, context, i2)) == null) ? ChatMessageDBManager.getInstance(context).getNewMsgCountOfClass(i2) : invokeLI.intValue;
    }

    @Deprecated
    public static int getNewMsgCount(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65564, null, context, j2)) == null) ? (int) ChatMsgManager.getUnReadMsgCount(context, 0, j2) : invokeLJ.intValue;
    }

    public static void getNotificationMsgDataList(Context context, SparseArray<List<Integer>> sparseArray, long j2, int i2, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{context, sparseArray, Long.valueOf(j2), Integer.valueOf(i2), iFetchNotificationDataListener}) == null) {
            ChatMsgManager.getNotificationMsgDataList(context, sparseArray, j2, i2, iFetchNotificationDataListener);
        }
    }

    public static int getNotificationPrivacy(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? AccountManager.getNotificationPrivacy(context) : invokeL.intValue;
    }

    public static void getPaInfo(Context context, long j2, IGetPaInfoListener iGetPaInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, null, new Object[]{context, Long.valueOf(j2), iGetPaInfoListener}) == null) {
            PaManager.getPaInfo(context, j2, iGetPaInfoListener);
        }
    }

    public static PaInfo getPaInfoSync(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65572, null, context, j2)) == null) ? PaManager.getPaInfo(context, j2) : (PaInfo) invokeLJ.objValue;
    }

    public static void getPaInfos(Context context, ArrayList<Long> arrayList, IGetPaInfosListener iGetPaInfosListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, arrayList, iGetPaInfosListener) == null) {
            PaManager.getPaInfos(context, arrayList, iGetPaInfosListener);
        }
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65574, null, context, i2, i3)) == null) ? ChatMsgManager.getPaMsgByChatType(context, i2, i3) : (List) invokeLII.objValue;
    }

    public static void getPaMsgByChatTypeAndPaidList(Context context, List<Integer> list, List<Long> list2, long j2, int i2, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65576, null, new Object[]{context, list, list2, Long.valueOf(j2), Integer.valueOf(i2), iFetchNotificationDataListener}) == null) {
            ChatMsgManager.getPaMsgByChatTypeAndPaidList(context, list, list2, j2, i2, iFetchNotificationDataListener);
        }
    }

    public static void getPaQuickReplies(Context context, long j2, IGetQuickReplyListener iGetQuickReplyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65577, null, new Object[]{context, Long.valueOf(j2), iGetQuickReplyListener}) == null) {
            PaManager.getPaQuickReplies(context, j2, iGetQuickReplyListener);
        }
    }

    public static void getServiceNotifyMenuStatus(Context context, long j2, List<Long> list, List<String> list2, int i2, String str, IGetServiceNotifyMenuListener iGetServiceNotifyMenuListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65578, null, new Object[]{context, Long.valueOf(j2), list, list2, Integer.valueOf(i2), str, iGetServiceNotifyMenuListener}) == null) {
            ShieldAndTopManager.getInstance(context).getServiceNotifyMenuStatus(j2, list, list2, str, i2, iGetServiceNotifyMenuListener);
        }
    }

    public static void getShield(Context context, long j2, IGetShieldAndTopListener iGetShieldAndTopListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65579, null, new Object[]{context, Long.valueOf(j2), iGetShieldAndTopListener}) == null) {
            ShieldAndTopManager.getInstance(context).getOneShieldAndTopRequest(j2, iGetShieldAndTopListener);
        }
    }

    public static void getSingleContacterSetting(Context context, long j2, int i2, IGetShieldAndTopListener iGetShieldAndTopListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65580, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iGetShieldAndTopListener}) == null) {
            ShieldAndTopManager.getInstance(context).getSingleContacterSetting(j2, i2, iGetShieldAndTopListener);
        }
    }

    public static void getSmartChatSession(Context context, List<Integer> list, IGetSmartChatSessionListener iGetSmartChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65581, null, context, list, iGetSmartChatSessionListener) == null) {
            LogUtils.d(TAG, "getSmartChatSession by callback ~ ");
            if (iGetSmartChatSessionListener == null) {
                return;
            }
            if (list != null && !list.isEmpty()) {
                TaskManager.getInstance(context).submitForNetWork(new Runnable(context, list, iGetSmartChatSessionListener) { // from class: com.baidu.android.imsdk.box.IMBoxManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List val$chattypes;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ IGetSmartChatSessionListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, list, iGetSmartChatSessionListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$chattypes = list;
                        this.val$listener = iGetSmartChatSessionListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ArrayList<ChatSession> chatRecords = ChatMsgManager.getChatRecords(this.val$context, this.val$chattypes);
                            if (chatRecords != null) {
                                i2 = 0;
                            } else if (AccountManager.isLogin(this.val$context)) {
                                i2 = LoginManager.getInstance(this.val$context).getCurrentState().equals(LoginManager.LoginState.LOGINING) ? -2 : -3;
                            } else {
                                i2 = -1;
                            }
                            this.val$listener.onGetSessionResult(i2, chatRecords);
                        }
                    }
                });
                return;
            }
            LogUtils.d(TAG, "getSmartChatSession by callback ~ returned null ~");
            iGetSmartChatSessionListener.onGetSessionResult(-4, null);
        }
    }

    public static void getSubscription(Context context, long j2, List<Long> list, List<String> list2, String str, IGetSubscriptionListener iGetSubscriptionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65582, null, new Object[]{context, Long.valueOf(j2), list, list2, str, iGetSubscriptionListener}) == null) {
            ShieldAndTopManager.getInstance(context).getSubscription(j2, list, list2, str, iGetSubscriptionListener);
        }
    }

    public static String getUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) ? AccountManager.getUid(context) : (String) invokeL.objValue;
    }

    public static void getUnconcernedUserDisturb(Context context, IGetUnconcernedMsgListener iGetUnconcernedMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65584, null, context, iGetUnconcernedMsgListener) == null) {
            ChatUserManager.getUnconcernedUserDisturb(context, iGetUnconcernedMsgListener);
        }
    }

    public static void getUserShieldList(Context context, int i2, IGetUserShieldListener iGetUserShieldListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65585, null, context, i2, iGetUserShieldListener) == null) {
            ShieldAndTopManager.getInstance(context).getUserShieldListToShow(i2, iGetUserShieldListener);
        }
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65586, null, new Object[]{context, arrayList, Boolean.valueOf(z), iGetUsersProfileBatchListener}) == null) {
            ChatUserManager.getUsersProfiles(context, arrayList, z, iGetUsersProfileBatchListener);
        }
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, null, context) == null) {
            IMManager.init(context, 3);
        }
    }

    public static void isSubscribed(Context context, long j2, IIsSubscribedListener iIsSubscribedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65588, null, new Object[]{context, Long.valueOf(j2), iIsSubscribedListener}) == null) {
            PaManager.isSubscribed(context, j2, iIsSubscribedListener);
        }
    }

    public static void login(Context context, String str, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65589, null, context, str, iLoginListener) == null) {
            AccountManager.login(context, str, iLoginListener);
        }
    }

    public static synchronized void logout(Context context, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65590, null, context, iLoginListener) == null) {
            synchronized (IMBoxManager.class) {
                ILoginListener iLoginListener2 = new ILoginListener(context, iLoginListener) { // from class: com.baidu.android.imsdk.box.IMBoxManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ ILoginListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, iLoginListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$listener = iLoginListener;
                    }

                    @Override // com.baidu.android.imsdk.account.ILoginListener
                    public void onLoginResult(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        }
                    }

                    @Override // com.baidu.android.imsdk.account.ILoginListener
                    public void onLogoutResult(int i2, String str, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                            if (i2 == 0) {
                                AccountManager.clearToken(this.val$context, null);
                                AccountManager.clearUid(this.val$context);
                                AccountManager.disconnect(this.val$context);
                                try {
                                    Thread.sleep(200L);
                                } catch (InterruptedException e2) {
                                    LogUtils.e(IMBoxManager.TAG, "Exception ", e2);
                                    new IMTrack.CrashBuilder(this.val$context).exception(Log.getStackTraceString(e2)).build();
                                }
                            }
                            ILoginListener iLoginListener3 = this.val$listener;
                            if (iLoginListener3 != null) {
                                iLoginListener3.onLogoutResult(i2, str, i3);
                            }
                        }
                    }
                };
                unRegisterNotify(context, null);
                AccountManager.logout(context, iLoginListener2);
            }
        }
    }

    public static void querySubscribedPaList(Context context, IQuerySubscribedPaListListener iQuerySubscribedPaListListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65591, null, context, iQuerySubscribedPaListListener) == null) {
            PaManager.querySubscribedPaList(context, iQuerySubscribedPaListListener);
        }
    }

    public static List<PaInfo> querySubscribedPaListSync(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65592, null, context)) == null) ? PaManager.querySubscribedPaListSync(context) : (List) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean receiveRemoteNotification(Context context, String str, IFetchMessageListener iFetchMessageListener) {
        InterceptResult invokeLLL;
        long j2;
        long j3;
        long j4;
        long j5;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65593, null, context, str, iFetchMessageListener)) == null) {
            if (BaseManager.isNullContext(context)) {
                LogUtils.e(TAG, " Context is NULL!");
                return false;
            }
            LogUtils.d(TAG, "receive custom msg:" + str);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            long j6 = -1;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e = e2;
                j2 = -1;
                j3 = -1;
            }
            if (jSONObject.has("bd_transformer")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("bd_transformer");
                j2 = optJSONObject.optLong("to", -1L);
                try {
                    j3 = optJSONObject.optLong("from", -1L);
                    try {
                        j4 = optJSONObject.optLong("msgid", -1L);
                        try {
                            j5 = optJSONObject.optLong("appid", -1L);
                        } catch (JSONException e3) {
                            e = e3;
                            LogUtils.e(TAG, str, e);
                            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                            j5 = -1;
                            j6 = j2;
                            if (j6 != Utility.getUK(context)) {
                            }
                            LogUtils.d(TAG, "touser:" + j6 + "  uk:" + Utility.getUK(context) + "  appId:" + j5 + "  realAppid" + AccountManager.getAppid(context));
                            return false;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        j4 = -1;
                    }
                } catch (JSONException e5) {
                    e = e5;
                    j3 = -1;
                    j4 = j3;
                    LogUtils.e(TAG, str, e);
                    new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                    j5 = -1;
                    j6 = j2;
                    if (j6 != Utility.getUK(context)) {
                    }
                    LogUtils.d(TAG, "touser:" + j6 + "  uk:" + Utility.getUK(context) + "  appId:" + j5 + "  realAppid" + AccountManager.getAppid(context));
                    return false;
                }
                j6 = j2;
                if (j6 != Utility.getUK(context) && j3 >= 0 && j4 >= 0) {
                    IMManager.init(context, IMConfigInternal.getInstance().getProductLine(context));
                    login(context, AccountManager.getToken(context), null);
                    return true;
                }
                LogUtils.d(TAG, "touser:" + j6 + "  uk:" + Utility.getUK(context) + "  appId:" + j5 + "  realAppid" + AccountManager.getAppid(context));
                return false;
            }
            j5 = -1;
            j3 = -1;
            j4 = -1;
            if (j6 != Utility.getUK(context)) {
            }
            LogUtils.d(TAG, "touser:" + j6 + "  uk:" + Utility.getUK(context) + "  appId:" + j5 + "  realAppid" + AccountManager.getAppid(context));
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void registerChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65594, null, context, iChatSessionChangeListener) == null) {
            ChatMsgManager.registerChatSessionListener(context, iChatSessionChangeListener);
        }
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65595, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.registerMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static boolean registerNotify(Context context, String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65596, null, context, str, str2, str3, iOnRegisterNotifyListener)) == null) {
            LogUtils.d(TAG, "channelId=" + str + ";userId=" + str2 + ";appId=" + str3);
            if (BaseManager.isNullContext(context)) {
                if (iOnRegisterNotifyListener != null) {
                    iOnRegisterNotifyListener.onRegisterNotifyResult(1005, "Context is NULL!");
                }
                return false;
            } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                if (iOnRegisterNotifyListener != null) {
                    iOnRegisterNotifyListener.onRegisterNotifyResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                }
                return false;
            } else {
                return ChatMsgManagerImpl.getInstance(context).registerNotify(str, str2, str3, iOnRegisterNotifyListener);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public static void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65597, null, context, iPaSubscriptionChangeListener) == null) {
            PaManager.registerPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
        }
    }

    public static void registerSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65598, null, context, iSubscriptionChangeListener) == null) {
            PaManager.registerSubscriptionChangeListener(context, iSubscriptionChangeListener);
        }
    }

    public static void removeSessionByClasstype(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65599, null, context, i2) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i2));
            ArrayList<ChatSession> chatRecordsByClass = getChatRecordsByClass(context, arrayList);
            if (chatRecordsByClass != null) {
                Iterator<ChatSession> it = chatRecordsByClass.iterator();
                while (it.hasNext()) {
                    ChatSession next = it.next();
                    ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(next.getCategory(), next.getContacter(), false);
                }
            }
        }
    }

    @Deprecated
    public static boolean setAllMsgRead(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65601, null, context, j2)) == null) ? ChatMsgManager.setAllMsgRead(context, 0, j2, false) : invokeLJ.booleanValue;
    }

    public static boolean setAppid(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65602, null, context, j2)) == null) ? AccountManager.setAppid(context, j2) : invokeLJ.booleanValue;
    }

    public static void setDisturb(Context context, long j2, int i2, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65603, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iStatusListener}) == null) {
            setShield(context, j2, 1, i2, iStatusListener);
        }
    }

    @Deprecated
    public static void setEnv(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65604, null, context, i2) == null) {
            AccountManager.setEnv(context, i2);
        }
    }

    public static void setGroupAndStrangerDisturb(Context context, long j2, int i2, int i3, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65605, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).requestDisturbAndRemind(j2, 3, i2, i3, iStatusListener);
        }
    }

    public static void setGroupDisturb(Context context, String str, int i2, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65606, null, context, str, i2, bIMValueCallBack) == null) {
            GroupManagerImpl.getInstance(context).setGroupDisturb(str, i2, bIMValueCallBack);
        }
    }

    public static void setInterActiveMsgStatus(Context context, long j2, long j3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65607, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            ChatMsgManager.setInterActiveMsgStatus(context, j2, j3, i2, i3);
        }
    }

    public static void setMarkTop(Context context, long j2, int i2, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65608, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j2, 1, i2, iStatusListener);
        }
    }

    @Deprecated
    public static boolean setMsgRead(Context context, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65609, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? ChatMsgManager.setMsgRead(context, 0, j2, j3, false) : invokeCommon.booleanValue;
    }

    public static void setMsgReadByChatTypeAndSubType(Context context, SparseArray<List<Integer>> sparseArray, long j2, ISetMessageReadListener iSetMessageReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65611, null, new Object[]{context, sparseArray, Long.valueOf(j2), iSetMessageReadListener}) == null) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context, sparseArray, j2, iSetMessageReadListener) { // from class: com.baidu.android.imsdk.box.IMBoxManager.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ ISetMessageReadListener val$listener;
                public final /* synthetic */ SparseArray val$map;
                public final /* synthetic */ long val$msgid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, sparseArray, Long.valueOf(j2), iSetMessageReadListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                    this.val$map = sparseArray;
                    this.val$msgid = j2;
                    this.val$listener = iSetMessageReadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatMsgManager.setMsgReadByChatTypeAndSubType(this.val$context, this.val$map, this.val$msgid, this.val$listener);
                    }
                }
            });
        }
    }

    public static void setMsgReadByChatTypes(Context context, List<Integer> list, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65612, null, new Object[]{context, list, Long.valueOf(j2)}) == null) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context, list, j2) { // from class: com.baidu.android.imsdk.box.IMBoxManager.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ List val$chatypes;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ long val$msgid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, list, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                    this.val$chatypes = list;
                    this.val$msgid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ChatMsgManager.setMsgReadByChatTpyes(this.val$context, this.val$chatypes, this.val$msgid);
                    }
                }
            });
        }
    }

    public static boolean setMsgReadByMsgId(Context context, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65613, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            String str = TAG;
            LogUtils.d(str, "setMsgReadByMsgId...msgid=" + j2 + "， setType=" + i2);
            return ChatMsgManager.setMsgReadByMsgId(context, j2, i2);
        }
        return invokeCommon.booleanValue;
    }

    public static void setMsgSettingSwitchStatus(Context context, int i2, int i3, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65614, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), iSetMsgSettingSwitchListener}) == null) {
            AccountManager.setMsgSettingSwitchStatus(context, i2, i3, iSetMsgSettingSwitchListener);
        }
    }

    public static void setNotificationPrivacy(Context context, int i2, ISetNotificationPrivacyListener iSetNotificationPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65615, null, context, i2, iSetNotificationPrivacyListener) == null) {
            AccountManager.setNotificationPrivacy(context, i2, iSetNotificationPrivacyListener);
        }
    }

    public static void setShield(Context context, long j2, int i2, int i3, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65616, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setShield(j2, i2, i3, iStatusListener);
        }
    }

    public static void setSubscription(Context context, long j2, List<Long> list, List<String> list2, int i2, String str, ISetSubscriptionListener iSetSubscriptionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65617, null, new Object[]{context, Long.valueOf(j2), list, list2, Integer.valueOf(i2), str, iSetSubscriptionListener}) == null) {
            ShieldAndTopManager.getInstance(context).setSubscription(j2, list, list2, i2, str, iSetSubscriptionListener);
        }
    }

    public static boolean setUid(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65618, null, context, str)) == null) ? AccountManager.setUid(context, str) : invokeLL.booleanValue;
    }

    public static void setUserDisturb(Context context, long j2, int i2, IUserPrivacyListener iUserPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65619, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iUserPrivacyListener}) == null) {
            ChatUserManager.setUserDisturb(context, j2, i2, iUserPrivacyListener);
        }
    }

    public static boolean stopService(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65620, null, context)) == null) {
            if (context == null) {
                return false;
            }
            return AccountManagerImpl.getInstance(context.getApplicationContext()).stopService();
        }
        return invokeL.booleanValue;
    }

    public static void subscribePa(Context context, long j2, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65621, null, new Object[]{context, Long.valueOf(j2), iSubscribePaListener}) == null) {
            PaManager.subscribePa(context, j2, iSubscribePaListener);
        }
    }

    public static void unRegisterNotify(Context context, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65622, null, context, iOnRegisterNotifyListener) == null) {
            if (!BaseManager.isNullContext(context)) {
                ChatMsgManagerImpl.getInstance(context).unRegisterNotify(iOnRegisterNotifyListener);
            } else if (iOnRegisterNotifyListener != null) {
                iOnRegisterNotifyListener.onUnRegisterNotifyResult(1005, "Context is NULL!");
            }
        }
    }

    public static void unSubscribePa(Context context, long j2, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65623, null, new Object[]{context, Long.valueOf(j2), iSubscribePaListener}) == null) {
            PaManager.unSubscribePa(context, j2, iSubscribePaListener);
        }
    }

    public static void unregisterChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65624, null, context, iChatSessionChangeListener) == null) {
            ChatMsgManager.unregisterChatSessionListener(context, iChatSessionChangeListener);
        }
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65625, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.unregisterMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65626, null, context, iPaSubscriptionChangeListener) == null) {
            PaManager.unregisterPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
        }
    }

    public static void unregisterSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65627, null, context, iSubscriptionChangeListener) == null) {
            PaManager.unregisterSubscriptionChangeListener(context, iSubscriptionChangeListener);
        }
    }

    public static void updateMsgUsersFromMsgCenter(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65628, null, context) == null) && Utility.isNeedSync(context, Constants.KEY_SYNC_MSG_TAB_TIME) && AccountManager.isLogin(context)) {
            try {
                List<ChatSession> chatSession = getChatSession(context);
                if (chatSession != null && chatSession.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<Long> arrayList3 = new ArrayList<>();
                    for (ChatSession chatSession2 : chatSession) {
                        if (chatSession2.getChatType() == 0) {
                            ChatUser chatUser = ChatUserDBManager.getInstance(context).getChatUser(chatSession2.getContacter());
                            if (chatUser != null) {
                                arrayList.add(Long.valueOf(chatUser.getBuid()));
                            } else {
                                arrayList2.add(Long.valueOf(chatSession2.getContacter()));
                            }
                        } else if (chatSession2.getChatType() == 7) {
                            arrayList3.add(Long.valueOf(chatSession2.getContacter()));
                        }
                    }
                    if (arrayList.size() > 0) {
                        ChatUserManagerImpl.getInstance(context).updateUserIdentity(arrayList, new IGetUserIdentityListener(context) { // from class: com.baidu.android.imsdk.box.IMBoxManager.12
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Context val$context;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {context};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$context = context;
                            }

                            @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                            public void onGetUserIdentityResult(int i2, List<ChatUser> list) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                                    for (ChatUser chatUser2 : list) {
                                        IMUserManager.getInstance(this.val$context).updateUser(chatUser2);
                                        ChatMessageDBManager.getInstance(this.val$context).updateSessionClass(chatUser2);
                                    }
                                }
                            }
                        });
                    }
                    if (arrayList2.size() > 0) {
                        long[] jArr = new long[arrayList2.size()];
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            if (arrayList2.get(i2) != null) {
                                jArr[i2] = ((Long) arrayList2.get(i2)).longValue();
                            }
                        }
                        String str = TAG;
                        LogUtils.d(str, "updateMsgUsersFromMsgCenter noBduidUks :" + arrayList2.toString());
                        ChatUserManagerImpl.getInstance(context).updateUserProfileByUks(jArr, false, "");
                    }
                    if (arrayList3.size() > 0) {
                        String str2 = TAG;
                        LogUtils.d(str2, "updateMsgUsersFromMsgCenter paIds :" + arrayList3.toString());
                        PaManagerImpl.getInstance(context).getPaInfos(arrayList3, new IGetPaInfosListener(context) { // from class: com.baidu.android.imsdk.box.IMBoxManager.13
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Context val$context;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {context};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$context = context;
                            }

                            @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                            public void onResult(int i3, String str3, ArrayList<PaInfo> arrayList4) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str3, arrayList4) == null) && i3 == 0) {
                                    Iterator<PaInfo> it = arrayList4.iterator();
                                    while (it.hasNext()) {
                                        PaInfo next = it.next();
                                        PaInfoDBManager.getInstance(this.val$context).subscribePa(next);
                                        ChatMessageDBManager.getInstance(this.val$context).updateSessionClass(next);
                                    }
                                }
                            }
                        });
                    }
                    ShieldAndTopManager.getInstance(context).requestSubbusinessContacterList(0, 1, "");
                    ShieldAndTopManager.getInstance(context).requestMsgMarkTopList();
                    Utility.writeLongData(context, Constants.KEY_SYNC_MSG_TAB_TIME, System.currentTimeMillis() + Constants.SYNC_MSG_DELAY_TIME);
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "updateMsgUsersFromMsgCenter :", e2);
            }
        }
    }

    public static void updateSubscribe(Context context, long j2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65629, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (i2 == 0) {
                ChatUserDBManager.getInstance(context).updateSubscribedUser(j2, i3);
            } else if (i2 == 7) {
                PaInfoDBManager.getInstance(context).updateSubscribedUser(j2, i3);
            }
        }
    }

    public static void updateSubscribedPaList(Context context, @NonNull List<Long> list, @NonNull List<Long> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65630, null, context, list, list2) == null) {
            HashMap hashMap = new HashMap();
            for (Long l : list) {
                hashMap.put(l, 1);
            }
            for (Long l2 : list2) {
                hashMap.put(l2, 0);
            }
            PaInfoDBManager.getInstance(context).updateSubscribedPaList(hashMap);
        }
    }

    public static void updateSubscribedUsers(Context context, @NonNull List<Long> list, @NonNull List<Long> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65631, null, context, list, list2) == null) {
            HashMap hashMap = new HashMap();
            for (Long l : list) {
                hashMap.put(l, 1);
            }
            for (Long l2 : list2) {
                hashMap.put(l2, 0);
            }
            ChatUserDBManager.getInstance(context).updateSubscribedUsers(hashMap);
        }
    }

    public void syncPa(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            PaManager.syncAllPainfo(context);
        }
    }

    public static void getChatRecordsByClass(Context context, List<Integer> list, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, context, list, iGetSessionListener) == null) {
            if (iGetSessionListener == null) {
                LogUtils.d(TAG, "in getChatRecordsByClass type, listener is null!");
            } else if (context != null && list != null && !list.isEmpty()) {
                TaskManager.getInstance(context).submitForLocalOperation(new Runnable(iGetSessionListener, context, list) { // from class: com.baidu.android.imsdk.box.IMBoxManager.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List val$classtypes;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ IGetSessionListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iGetSessionListener, context, list};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = iGetSessionListener;
                        this.val$context = context;
                        this.val$classtypes = list;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$listener.onGetSessionResult(ChatMsgManager.getChatRecordsByClass(this.val$context, this.val$classtypes));
                        }
                    }
                });
            } else {
                LogUtils.d(TAG, "in getChatRecordsByClass type, context == null || classtypes == null || classtypes.isEmpty() is true!");
                iGetSessionListener.onGetSessionResult(null);
            }
        }
    }

    public static void getChatSession(Context context, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, context, iGetSessionListener) == null) || iGetSessionListener == null) {
            return;
        }
        if (context == null) {
            iGetSessionListener.onGetSessionResult(null);
        } else {
            TaskManager.getInstance(context).submitForLocalOperation(new Runnable(iGetSessionListener, context) { // from class: com.baidu.android.imsdk.box.IMBoxManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ IGetSessionListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iGetSessionListener, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = iGetSessionListener;
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$listener.onGetSessionResult(ChatMsgManager.getChatRecords(this.val$context));
                    }
                }
            });
        }
    }

    public static void getNewCountOfClass(Context context, int i2, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65562, null, context, i2, iGetNewMsgCountListener) == null) {
            if (iGetNewMsgCountListener == null) {
                LogUtils.d(TAG, "getNewCountOfClass, listener is null! ");
            } else if (context == null) {
                LogUtils.d(TAG, "getNewCountOfClass, context is null! return 0! ");
                iGetNewMsgCountListener.onGetNewMsgCount(0);
            } else {
                TaskManager.getInstance(context).submitForLocalOperation(new Runnable(iGetNewMsgCountListener, context, i2) { // from class: com.baidu.android.imsdk.box.IMBoxManager.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int val$classtype;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ IGetNewMsgCountListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iGetNewMsgCountListener, context, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = iGetNewMsgCountListener;
                        this.val$context = context;
                        this.val$classtype = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$listener.onGetNewMsgCount(ChatMessageDBManager.getInstance(this.val$context).getNewMsgCountOfClass(this.val$classtype));
                        }
                    }
                });
                AccountManagerImpl.getInstance(context);
                AccountManagerImpl.tryConnection(context);
            }
        }
    }

    public static void getNewMsgCount(Context context, long j2, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{context, Long.valueOf(j2), iGetNewMsgCountListener}) == null) || iGetNewMsgCountListener == null) {
            return;
        }
        if (context != null && j2 != -1) {
            TaskManager.getInstance(context).submitForLocalOperation(new Runnable(iGetNewMsgCountListener, context, j2) { // from class: com.baidu.android.imsdk.box.IMBoxManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ IGetNewMsgCountListener val$listener;
                public final /* synthetic */ long val$paId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iGetNewMsgCountListener, context, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = iGetNewMsgCountListener;
                    this.val$context = context;
                    this.val$paId = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$listener.onGetNewMsgCount((int) ChatMsgManager.getUnReadMsgCount(this.val$context, 0, this.val$paId));
                    }
                }
            });
            AccountManagerImpl.getInstance(context);
            AccountManagerImpl.tryConnection(context);
            return;
        }
        iGetNewMsgCountListener.onGetNewMsgCount(0);
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, List<Integer> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65575, null, context, list, i2)) == null) ? ChatMsgManager.getPaMsgByChatType(context, list, i2) : (List) invokeLLI.objValue;
    }

    public static boolean setAllMsgRead(Context context, int i2, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65600, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z)})) == null) ? ChatMsgManager.setAllMsgRead(context, i2, j2, z) : invokeCommon.booleanValue;
    }

    public static boolean setMsgRead(Context context, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65610, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) ? ChatMsgManager.setMsgRead(context, 0, j2, j3, z) : invokeCommon.booleanValue;
    }

    public static long deleteMsgs(Context context, int i2, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i2, j2, z);
        }
        return invokeCommon.longValue;
    }

    @Deprecated
    public static List<ChatSession> getChatSession(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, list)) == null) {
            LogUtils.d(TAG, "HBBH im in getChatSession!!!");
            return ChatMsgManager.getChatRecords(context, list);
        }
        return (List) invokeLL.objValue;
    }

    @Deprecated
    public static int deleteMsgs(Context context, long j2, long[] jArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, Long.valueOf(j2), jArr})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteMsgs(0, j2, jArr, false);
        }
        return invokeCommon.intValue;
    }

    @Deprecated
    public static int getNewMsgCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) ? ChatMsgManager.getNewMsgCount(context) : invokeL.intValue;
    }

    public static void getChatSession(Context context, List<Integer> list, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, context, list, iGetSessionListener) == null) {
            LogUtils.d(TAG, "getChatSession by callback ~ ");
            if (iGetSessionListener == null) {
                return;
            }
            if (list != null && !list.isEmpty()) {
                TaskManager.getInstance(context).submitForNetWork(new Runnable(iGetSessionListener, context, list) { // from class: com.baidu.android.imsdk.box.IMBoxManager.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List val$chattypes;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ IGetSessionListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iGetSessionListener, context, list};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = iGetSessionListener;
                        this.val$context = context;
                        this.val$chattypes = list;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            LogUtils.d(IMBoxManager.TAG, "getChatSession by callback ~ start run ~");
                            this.val$listener.onGetSessionResult(ChatMsgManager.getChatRecords(this.val$context, this.val$chattypes));
                        }
                    }
                });
                return;
            }
            LogUtils.d(TAG, "getChatSession by callback ~ returned null ~");
            iGetSessionListener.onGetSessionResult(null);
        }
    }

    public static void getNewMsgCount(Context context, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, context, iGetNewMsgCountListener) == null) {
            if (iGetNewMsgCountListener == null) {
                LogUtils.d(TAG, "getNewMsgCount all, listener is null! ");
            } else if (context == null) {
                LogUtils.d(TAG, "getNewMsgCount all, context is null, return 0! ");
                iGetNewMsgCountListener.onGetNewMsgCount(0);
            } else {
                TaskManager.getInstance(context).submitForLocalOperation(new Runnable(iGetNewMsgCountListener, context) { // from class: com.baidu.android.imsdk.box.IMBoxManager.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ IGetNewMsgCountListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iGetNewMsgCountListener, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = iGetNewMsgCountListener;
                        this.val$context = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$listener.onGetNewMsgCount(ChatMsgManager.getNewMsgCount(this.val$context));
                        }
                    }
                });
                AccountManagerImpl.getInstance(context);
                AccountManagerImpl.tryConnection(context);
            }
        }
    }

    public static int deleteMsgs(Context context, long j2, long[] jArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, Long.valueOf(j2), jArr, Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteMsgs(0, j2, jArr, z);
        }
        return invokeCommon.intValue;
    }

    @Deprecated
    public static int getNewMsgCount(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, list)) == null) ? ChatMessageDBManager.getInstance(context).getNewMsgCount(list) : invokeLL.intValue;
    }

    public static void getNewMsgCount(Context context, List<Integer> list, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65568, null, context, list, iGetNewMsgCountListener) == null) {
            if (iGetNewMsgCountListener == null) {
                LogUtils.d(TAG, "getNewMsgCount type, listener is null! ");
            } else if (list != null && !list.isEmpty()) {
                TaskManager.getInstance(context).submitForNetWork(new Runnable(iGetNewMsgCountListener, context, list) { // from class: com.baidu.android.imsdk.box.IMBoxManager.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List val$chattypes;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ IGetNewMsgCountListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iGetNewMsgCountListener, context, list};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = iGetNewMsgCountListener;
                        this.val$context = context;
                        this.val$chattypes = list;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$listener.onGetNewMsgCount(ChatMessageDBManager.getInstance(this.val$context).getNewMsgCount(this.val$chattypes));
                        }
                    }
                });
            } else {
                LogUtils.d(TAG, "getNewMsgCount type, chattypes == null || chattypes.isEmpty() is true! return 0! ");
                iGetNewMsgCountListener.onGetNewMsgCount(0);
            }
        }
    }
}
