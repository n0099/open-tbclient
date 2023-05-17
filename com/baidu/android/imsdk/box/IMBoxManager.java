package com.baidu.android.imsdk.box;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
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
import com.baidu.android.imsdk.chatmessage.IMGetBottomMenuListener;
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.IOnRegisterNotifyListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.ISetMessageReadListener;
import com.baidu.android.imsdk.chatmessage.IShowSendMsgPVListener;
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
import com.baidu.android.imsdk.shield.IGetTopicsListener;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.shield.IIsAllowSendMsgListener;
import com.baidu.android.imsdk.shield.ISetSubscriptionListener;
import com.baidu.android.imsdk.shield.IShowingToastListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.task.TaskManager;
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
/* loaded from: classes.dex */
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

    public static void getUnreadNotificationMsgsByTime(Context context, SparseArray<List<Integer>> sparseArray, long j, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65594, null, new Object[]{context, sparseArray, Long.valueOf(j), iFetchNotificationDataListener}) == null) {
        }
    }

    public IMBoxManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void acceptPaPush(Context context, long j, boolean z, IAcceptPaPushListener iAcceptPaPushListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z), iAcceptPaPushListener}) == null) {
            PaManager.acceptPaPush(context, j, z, iAcceptPaPushListener);
        }
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65596, null, new Object[]{context, arrayList, Boolean.valueOf(z), iGetUsersProfileBatchListener}) == null) {
            ChatUserManager.getUsersProfiles(context, arrayList, z, iGetUsersProfileBatchListener);
        }
    }

    public static void setGroupDisturb(Context context, String str, int i, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65617, null, context, str, i, bIMValueCallBack) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        GroupManagerImpl.getInstance(context).setGroupDisturb(str, i, bIMValueCallBack);
    }

    public static void setMsgSettingSwitchStatus(Context context, int i, int i2, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65625, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), iSetMsgSettingSwitchListener}) == null) {
            AccountManager.setMsgSettingSwitchStatus(context, i, i2, iSetMsgSettingSwitchListener);
        }
    }

    public static void setUserDisturb(Context context, long j, int i, IUserPrivacyListener iUserPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65632, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iUserPrivacyListener}) == null) {
            ChatUserManager.setUserDisturb(context, j, i, iUserPrivacyListener);
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

    public static long deleteAllMsg(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (AccountManager.getMediaRole(context)) {
                return 0L;
            }
            return ChatMsgManager.deleteAllMsg(context);
        }
        return invokeL.longValue;
    }

    public static void disconnect(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            AccountManager.disconnect(context);
        }
    }

    public static ArrayList<SessionClass> getAllClassType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            return ChatMsgManager.getAllClassType(context);
        }
        return (ArrayList) invokeL.objValue;
    }

    public static List<ChatSession> getChatSession(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            return ChatMsgManager.getChatRecords(context);
        }
        return (List) invokeL.objValue;
    }

    @Deprecated
    public static int getNewMsgCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            return ChatMsgManager.getNewMsgCount(context);
        }
        return invokeL.intValue;
    }

    public static int getNotificationPrivacy(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            return AccountManager.getNotificationPrivacy(context);
        }
        return invokeL.intValue;
    }

    public static String getUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, context)) == null) {
            return AccountManager.getUid(context);
        }
        return (String) invokeL.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65597, null, context) == null) {
            IMManager.init(context, 3);
        }
    }

    public static List<PaInfo> querySubscribedPaListSync(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65603, null, context)) == null) {
            return PaManager.querySubscribedPaListSync(context);
        }
        return (List) invokeL.objValue;
    }

    public static boolean stopService(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65634, null, context)) == null) {
            if (context == null) {
                return false;
            }
            return AccountManagerImpl.getInstance(context.getApplicationContext()).stopService();
        }
        return invokeL.booleanValue;
    }

    public void syncPa(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, context) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManager.syncAllPainfo(context);
    }

    public static void clickPaQuickReply(Context context, long j, String str, long j2, IClickPaQuickReplyListener iClickPaQuickReplyListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, null, new Object[]{context, Long.valueOf(j), str, Long.valueOf(j2), iClickPaQuickReplyListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManager.clickPaQuickReply(context, j, str, j2, iClickPaQuickReplyListener);
    }

    public static void getNotificationMsgDataList(Context context, SparseArray<List<Integer>> sparseArray, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65572, null, new Object[]{context, sparseArray, Long.valueOf(j), Integer.valueOf(i), iFetchNotificationDataListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManager.getNotificationMsgDataList(context, sparseArray, j, i, iFetchNotificationDataListener);
    }

    public static void getNotificationMsgsByTopicSource(Context context, long j, boolean z, String str, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z), str, iFetchNotificationDataListener}) == null) {
            if (BaseManager.isNullContext(context)) {
                iFetchNotificationDataListener.onFetchResult(null, false);
            } else {
                ChatMsgManager.getNotificationMsgsByTopicSource(context, j, z, str, iFetchNotificationDataListener);
            }
        }
    }

    public static void setInterActiveMsgStatus(Context context, long j, long j2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65618, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManager.setInterActiveMsgStatus(context, j, j2, i, i2);
    }

    @Deprecated
    public static void setShield(Context context, long j, int i, int i2, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65628, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iStatusListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).setShield(j, i, i2, iStatusListener);
    }

    @Deprecated
    public static int deleteMsgs(Context context, long j, long[] jArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, Long.valueOf(j), jArr})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteMsgs(0, j, jArr, false);
        }
        return invokeCommon.intValue;
    }

    public static void getChatRecordsByClass(Context context, List<Integer> list, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, null, context, list, iGetSessionListener) == null) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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

    public static void getChatSession(Context context, List<Integer> list, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65559, null, context, list, iGetSessionListener) == null) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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

    public static void getNewCountOfClass(Context context, int i, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65564, null, context, i, iGetNewMsgCountListener) == null) {
            if (iGetNewMsgCountListener == null) {
                LogUtils.d(TAG, "getNewCountOfClass, listener is null! ");
            } else if (context == null) {
                LogUtils.d(TAG, "getNewCountOfClass, context is null! return 0! ");
                iGetNewMsgCountListener.onGetNewMsgCount(0);
            } else {
                TaskManager.getInstance(context).submitForLocalOperation(new Runnable(iGetNewMsgCountListener, context, i) { // from class: com.baidu.android.imsdk.box.IMBoxManager.8
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
                            Object[] objArr = {iGetNewMsgCountListener, context, Integer.valueOf(i)};
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
                        this.val$classtype = i;
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

    public static void getSmartChatSession(Context context, List<Integer> list, IGetSmartChatSessionListener iGetSmartChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65587, null, context, list, iGetSmartChatSessionListener) == null) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                        int i;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ArrayList<ChatSession> chatRecords = ChatMsgManager.getChatRecords(this.val$context, this.val$chattypes);
                            if (chatRecords == null) {
                                if (!AccountManager.isLogin(this.val$context)) {
                                    i = -1;
                                } else if (LoginManager.getInstance(this.val$context).getCurrentState().equals(LoginManager.LoginState.LOGINING)) {
                                    i = -2;
                                } else {
                                    i = -3;
                                }
                            } else {
                                i = 0;
                            }
                            this.val$listener.onGetSessionResult(i, chatRecords);
                        }
                    }
                });
                return;
            }
            LogUtils.d(TAG, "getSmartChatSession by callback ~ returned null ~");
            iGetSmartChatSessionListener.onGetSessionResult(-4, null);
        }
    }

    @Deprecated
    public static boolean setMsgRead(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65620, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return ChatMsgManager.setMsgRead(context, 0, j, j2, false);
        }
        return invokeCommon.booleanValue;
    }

    public static void setMsgReadByChatTypes(Context context, List<Integer> list, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65623, null, new Object[]{context, list, Long.valueOf(j)}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        TaskManager.getInstance(context).submitForNetWork(new Runnable(context, list, j) { // from class: com.baidu.android.imsdk.box.IMBoxManager.10
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
                    Object[] objArr = {context, list, Long.valueOf(j)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$context = context;
                this.val$chatypes = list;
                this.val$msgid = j;
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

    public static int deleteMsgs(Context context, long j, long[] jArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, Long.valueOf(j), jArr, Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteMsgs(0, j, jArr, z);
        }
        return invokeCommon.intValue;
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) {
            return ChatMsgManager.fetchMessageSync(context, 0, j, j2, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static void getChatBarMenu(Context context, long j, int i, IMGetBottomMenuListener iMGetBottomMenuListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65553, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iMGetBottomMenuListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManager.getChatPageBottomMenu(context, j, i, iMGetBottomMenuListener);
    }

    public static void getSingleContacterSetting(Context context, long j, int i, IGetShieldAndTopListener iGetShieldAndTopListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65586, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iGetShieldAndTopListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).getSingleContacterSetting(j, i, iGetShieldAndTopListener);
    }

    public static boolean setAllMsgRead(Context context, int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65611, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            return ChatMsgManager.setAllMsgRead(context, i, j, z);
        }
        return invokeCommon.booleanValue;
    }

    public static void setDisturb(Context context, long j, int i, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65614, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iStatusListener}) == null) {
            setShield(context, j, 1, i, iStatusListener);
        }
    }

    public static void setMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65619, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iStatusListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).setMarkTop(j, 1, i, iStatusListener);
    }

    public static boolean setMsgRead(Context context, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65621, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            return ChatMsgManager.setMsgRead(context, 0, j, j2, z);
        }
        return invokeCommon.booleanValue;
    }

    public static void setMsgReadByChatTypeAndSubType(Context context, SparseArray<List<Integer>> sparseArray, long j, ISetMessageReadListener iSetMessageReadListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65622, null, new Object[]{context, sparseArray, Long.valueOf(j), iSetMessageReadListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        TaskManager.getInstance(context).submitForNetWork(new Runnable(context, sparseArray, j, iSetMessageReadListener) { // from class: com.baidu.android.imsdk.box.IMBoxManager.11
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
                    Object[] objArr = {context, sparseArray, Long.valueOf(j), iSetMessageReadListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$context = context;
                this.val$map = sparseArray;
                this.val$msgid = j;
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

    public static void showSendMsgPV(Context context, long j, long j2, IShowSendMsgPVListener iShowSendMsgPVListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65633, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iShowSendMsgPVListener}) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iShowSendMsgPVListener != null) {
                    iShowSendMsgPVListener.onResult(0);
                    return;
                }
                return;
            }
            ChatMsgManager.showSendMsgPV(context, j, j2, iShowSendMsgPVListener);
        }
    }

    public static void switchGroupDisturb(Context context, long j, int i, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65636, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iStatusListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).setDisturb(j, 3, i, iStatusListener);
    }

    public static long deleteMsgs(Context context, int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i, j, z, 1);
        }
        return invokeCommon.longValue;
    }

    public static void getNewMsgCount(Context context, List<Integer> list, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{context, list, Long.valueOf(j), iGetNewMsgCountListener}) == null) {
            if (iGetNewMsgCountListener == null) {
                LogUtils.d(TAG, "getNewMsgCount type, listener is null! ");
            } else if (list != null && !list.isEmpty()) {
                TaskManager.getInstance(context).submitForNetWork(new Runnable(iGetNewMsgCountListener, context, list, j) { // from class: com.baidu.android.imsdk.box.IMBoxManager.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ List val$chattypes;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ IGetNewMsgCountListener val$listener;
                    public final /* synthetic */ long val$timeInterval;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iGetNewMsgCountListener, context, list, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = iGetNewMsgCountListener;
                        this.val$context = context;
                        this.val$chattypes = list;
                        this.val$timeInterval = j;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$listener.onGetNewMsgCount(ChatMessageDBManager.getInstance(this.val$context).getNewMsgCount(this.val$chattypes, this.val$timeInterval));
                        }
                    }
                });
            } else {
                LogUtils.d(TAG, "getNewMsgCount type, chattypes == null || chattypes.isEmpty() is true! return 0! ");
                iGetNewMsgCountListener.onGetNewMsgCount(0);
            }
        }
    }

    public static void updateSubscribe(Context context, long j, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65645, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        if (i == 0) {
            ChatUserDBManager.getInstance(context).updateSubscribedUser(j, i2);
        } else if (i == 7) {
            PaInfoDBManager.getInstance(context).updateSubscribedUser(j, i2);
        }
    }

    @Deprecated
    public static long deleteMsgs(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65547, null, context, j)) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(0, j, false, 1);
        }
        return invokeLJ.longValue;
    }

    public static boolean enableDebugMode(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, context, z)) == null) {
            return IMManager.enableDebugMode(context, z);
        }
        return invokeLZ.booleanValue;
    }

    @Deprecated
    public static ArrayList<ChatSession> getChatRecordsByClass(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, list)) == null) {
            return ChatMsgManager.getChatRecordsByClass(context, list);
        }
        return (ArrayList) invokeLL.objValue;
    }

    @Deprecated
    public static List<ChatSession> getChatSession(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, list)) == null) {
            LogUtils.d(TAG, "HBBH im in getChatSession!!!");
            return ChatMsgManager.getChatRecords(context, list);
        }
        return (List) invokeLL.objValue;
    }

    public static ChatUser getChatUserSync(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65560, null, context, j)) == null) {
            return ChatUserManager.getChatUserSync(context, j);
        }
        return (ChatUser) invokeLJ.objValue;
    }

    public static void getGroupAndStrangerDisturbList(Context context, IGetDisturbListListener iGetDisturbListListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65561, null, context, iGetDisturbListListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).getGroupAndStrangerDisturbList(iGetDisturbListListener);
    }

    public static void getMsgSettingSwitchStatus(Context context, IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, iGetMsgSettingSwitchListener) == null) {
            AccountManager.getMsgSettingSwitchStatus(context, iGetMsgSettingSwitchListener);
        }
    }

    @Deprecated
    public static int getNewCountOfClass(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65563, null, context, i)) == null) {
            return ChatMessageDBManager.getInstance(context).getNewMsgCountOfClass(i);
        }
        return invokeLI.intValue;
    }

    @Deprecated
    public static int getNewMsgCount(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65566, null, context, j)) == null) {
            return (int) ChatMsgManager.getUnReadMsgCount(context, 0, j);
        }
        return invokeLJ.intValue;
    }

    public static PaInfo getPaInfoByThirdId(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, context, str)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return PaManager.getPaInfoByThirdId(context, str);
        }
        return (PaInfo) invokeLL.objValue;
    }

    public static List<PaInfo> getPaInfoListFromDb(Context context, List<Long> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, context, list)) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            return PaManager.getPaInfoListFromDb(context, list);
        }
        return (List) invokeLL.objValue;
    }

    public static PaInfo getPaInfoSync(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65578, null, context, j)) == null) {
            return PaManager.getPaInfo(context, j);
        }
        return (PaInfo) invokeLJ.objValue;
    }

    public static void getUnconcernedUserDisturb(Context context, IGetUnconcernedMsgListener iGetUnconcernedMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65593, null, context, iGetUnconcernedMsgListener) == null) {
            ChatUserManager.getUnconcernedUserDisturb(context, iGetUnconcernedMsgListener);
        }
    }

    public static synchronized void logout(Context context, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65600, null, context, iLoginListener) == null) {
            synchronized (IMBoxManager.class) {
                ILoginListener iLoginListener2 = new ILoginListener(context, iLoginListener) { // from class: com.baidu.android.imsdk.box.IMBoxManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ ILoginListener val$listener;

                    @Override // com.baidu.android.imsdk.account.ILoginListener
                    public void onLoginResult(int i, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, iLoginListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$listener = iLoginListener;
                    }

                    @Override // com.baidu.android.imsdk.account.ILoginListener
                    public void onLogoutResult(int i, String str, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                            if (i == 0) {
                                AccountManager.clearToken(this.val$context, null);
                                AccountManager.clearUid(this.val$context);
                                AccountManager.disconnect(this.val$context);
                                try {
                                    Thread.sleep(200L);
                                } catch (InterruptedException e) {
                                    LogUtils.e(IMBoxManager.TAG, "Exception ", e);
                                }
                            }
                            ILoginListener iLoginListener3 = this.val$listener;
                            if (iLoginListener3 != null) {
                                iLoginListener3.onLogoutResult(i, str, i2);
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
        if (interceptable == null || interceptable.invokeLL(65602, null, context, iQuerySubscribedPaListListener) == null) {
            PaManager.querySubscribedPaList(context, iQuerySubscribedPaListListener);
        }
    }

    @Deprecated
    public static void registerChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65605, null, context, iChatSessionChangeListener) == null) {
            BIMManager.registerChatSessionChangeListener(context, iChatSessionChangeListener);
        }
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65606, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.registerMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static void registerPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65608, null, context, iPaSubscriptionChangeListener) == null) {
            PaManager.registerPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
        }
    }

    public static void registerSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65609, null, context, iSubscriptionChangeListener) == null) {
            PaManager.registerSubscriptionChangeListener(context, iSubscriptionChangeListener);
        }
    }

    @Deprecated
    public static boolean setAllMsgRead(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65612, null, context, j)) == null) {
            return ChatMsgManager.setAllMsgRead(context, 0, j, false);
        }
        return invokeLJ.booleanValue;
    }

    public static boolean setAppid(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65613, null, context, j)) == null) {
            return AccountManager.setAppid(context, j);
        }
        return invokeLJ.booleanValue;
    }

    @Deprecated
    public static void setEnv(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65615, null, context, i) == null) {
            AccountManager.setEnv(context, i);
        }
    }

    public static boolean setUid(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65631, null, context, str)) == null) {
            return AccountManager.setUid(context, str);
        }
        return invokeLL.booleanValue;
    }

    public static void syncPa(Context context, IGetPaInfosListener iGetPaInfosListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65637, null, context, iGetPaInfosListener) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iGetPaInfosListener != null) {
                    iGetPaInfosListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                    return;
                }
                return;
            }
            PaManager.syncAllPainfo(context, iGetPaInfosListener);
        }
    }

    public static void unRegisterNotify(Context context, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65638, null, context, iOnRegisterNotifyListener) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iOnRegisterNotifyListener != null) {
                    iOnRegisterNotifyListener.onUnRegisterNotifyResult(1005, "Context is NULL!");
                    return;
                }
                return;
            }
            ChatMsgManagerImpl.getInstance(context).unRegisterNotify(iOnRegisterNotifyListener);
        }
    }

    @Deprecated
    public static void unregisterChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65640, null, context, iChatSessionChangeListener) == null) {
            BIMManager.unregisterChatSessionChangeListener(context, iChatSessionChangeListener);
        }
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65641, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.unregisterMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static void unregisterPaSubscriptionChangeListener(Context context, IPaSubscriptionChangeListener iPaSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65642, null, context, iPaSubscriptionChangeListener) == null) {
            PaManager.unregisterPaSubscriptionChangeListener(context, iPaSubscriptionChangeListener);
        }
    }

    public static void unregisterSubscriptionChangeListener(Context context, ISubscriptionChangeListener iSubscriptionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65643, null, context, iSubscriptionChangeListener) == null) {
            PaManager.unregisterSubscriptionChangeListener(context, iSubscriptionChangeListener);
        }
    }

    public static void forwardMessage(Context context, long j, long j2, int i, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), chatMsg, iSendMessageListener}) == null) {
            ChatMsgManager.forwardMessage(context, j, j2, i, chatMsg, iSendMessageListener);
        }
    }

    public static void getPaMsgByChatTypeAndPaidList(Context context, List<Integer> list, List<Long> list2, long j, int i, IFetchNotificationDataListener iFetchNotificationDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65582, null, new Object[]{context, list, list2, Long.valueOf(j), Integer.valueOf(i), iFetchNotificationDataListener}) == null) {
            ChatMsgManager.getPaMsgByChatTypeAndPaidList(context, list, list2, j, i, iFetchNotificationDataListener);
        }
    }

    public static void getSubscription(Context context, long j, List<Long> list, List<String> list2, String str, IGetSubscriptionListener iGetSubscriptionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65588, null, new Object[]{context, Long.valueOf(j), list, list2, str, iGetSubscriptionListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).getSubscription(j, list, list2, str, false, iGetSubscriptionListener);
    }

    public static void getSubscriptionForFeed(Context context, long j, List<Long> list, List<String> list2, String str, IGetSubscriptionListener iGetSubscriptionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65589, null, new Object[]{context, Long.valueOf(j), list, list2, str, iGetSubscriptionListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).getSubscription(j, list, list2, str, true, iGetSubscriptionListener);
    }

    public static void uploadBottomMenuEvent(Context context, long j, int i, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65648, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str, Long.valueOf(j2), str2}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatMsgManager.uploadBottomMenuEvent(context, j, i, str, j2, str2);
    }

    public static void getChatSession(Context context, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65558, null, context, iGetSessionListener) != null) || iGetSessionListener == null) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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

    @Deprecated
    public static int getNewMsgCount(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, context, list)) == null) {
            return ChatMessageDBManager.getInstance(context).getNewMsgCount(list, 0L);
        }
        return invokeLL.intValue;
    }

    public static void getNewMsgCount(Context context, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65568, null, new Object[]{context, Long.valueOf(j), iGetNewMsgCountListener}) != null) || iGetNewMsgCountListener == null) {
            return;
        }
        if (context != null && j != -1) {
            TaskManager.getInstance(context).submitForLocalOperation(new Runnable(iGetNewMsgCountListener, context, j) { // from class: com.baidu.android.imsdk.box.IMBoxManager.2
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
                        Object[] objArr = {iGetNewMsgCountListener, context, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = iGetNewMsgCountListener;
                    this.val$context = context;
                    this.val$paId = j;
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

    public static boolean setMsgReadByMsgId(Context context, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65624, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            String str = TAG;
            LogUtils.d(str, "setMsgReadByMsgId...msgid=" + j + "， setType=" + i);
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return ChatMsgManager.setMsgReadByMsgId(context, j, i);
        }
        return invokeCommon.booleanValue;
    }

    public static void updateSubscribedPaList(Context context, @NonNull List<Long> list, @NonNull List<Long> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65646, null, context, list, list2) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (Long l : list) {
            hashMap.put(l, 1);
        }
        for (Long l2 : list2) {
            hashMap.put(l2, 0);
        }
        PaInfoDBManager.getInstance(context).updateSubscribedPaList(hashMap);
    }

    public static void updateSubscribedUsers(Context context, @NonNull List<Long> list, @NonNull List<Long> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65647, null, context, list, list2) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (Long l : list) {
            hashMap.put(l, 1);
        }
        for (Long l2 : list2) {
            hashMap.put(l2, 0);
        }
        ChatUserDBManager.getInstance(context).updateSubscribedUsers(hashMap);
    }

    public static void getNewMsgCount(Context context, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, null, context, iGetNewMsgCountListener) == null) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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

    public static void removeSessionByClasstype(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65610, null, context, i) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i));
            ArrayList<ChatSession> chatRecordsByClass = getChatRecordsByClass(context, arrayList);
            if (chatRecordsByClass != null) {
                Iterator<ChatSession> it = chatRecordsByClass.iterator();
                while (it.hasNext()) {
                    ChatSession next = it.next();
                    ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(next.getCategory(), next.getContacter(), false, 0);
                }
            }
        }
    }

    public static void getNewMsgCount(Context context, List<Integer> list, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65571, null, context, list, iGetNewMsgCountListener) == null) {
            getNewMsgCount(context, list, 0L, iGetNewMsgCountListener);
        }
    }

    public static void getPaInfo(Context context, long j, IGetPaInfoListener iGetPaInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, null, new Object[]{context, Long.valueOf(j), iGetPaInfoListener}) == null) {
            PaManager.getPaInfo(context, j, iGetPaInfoListener);
        }
    }

    public static void getPaInfos(Context context, ArrayList<Long> arrayList, IGetPaInfosListener iGetPaInfosListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65579, null, context, arrayList, iGetPaInfosListener) == null) {
            PaManager.getPaInfos(context, arrayList, iGetPaInfosListener);
        }
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65580, null, context, i, i2)) == null) {
            return ChatMsgManager.getPaMsgByChatType(context, i, i2);
        }
        return (List) invokeLII.objValue;
    }

    public static void getPaQuickReplies(Context context, long j, IGetQuickReplyListener iGetQuickReplyListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65583, null, new Object[]{context, Long.valueOf(j), iGetQuickReplyListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        PaManager.getPaQuickReplies(context, j, iGetQuickReplyListener);
    }

    public static void getShield(Context context, long j, IGetShieldAndTopListener iGetShieldAndTopListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65585, null, new Object[]{context, Long.valueOf(j), iGetShieldAndTopListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).getOneShieldAndTopRequest(j, iGetShieldAndTopListener);
    }

    public static void getToastShowing(Context context, String str, IShowingToastListener iShowingToastListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65590, null, context, str, iShowingToastListener) == null) {
            if (!BaseManager.isNullContext(context) && !AccountManager.getMediaRole(context)) {
                ChatMsgManager.getToastShowing(context, str, iShowingToastListener);
            } else if (iShowingToastListener != null) {
                iShowingToastListener.onResult(false);
            }
        }
    }

    public static void getTopicsByPa(Context context, long j, IGetTopicsListener iGetTopicsListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65591, null, new Object[]{context, Long.valueOf(j), iGetTopicsListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).getTopicsByPa(j, iGetTopicsListener);
    }

    public static void getUserShieldList(Context context, int i, IGetUserShieldListener iGetUserShieldListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65595, null, context, i, iGetUserShieldListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).getUserShieldListToShow(i, iGetUserShieldListener);
    }

    public static void isSubscribed(Context context, long j, IIsSubscribedListener iIsSubscribedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65598, null, new Object[]{context, Long.valueOf(j), iIsSubscribedListener}) == null) {
            PaManager.isSubscribed(context, j, iIsSubscribedListener);
        }
    }

    public static void login(Context context, String str, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65599, null, context, str, iLoginListener) == null) {
            AccountManager.login(context, str, iLoginListener);
        }
    }

    public static void setNotificationPrivacy(Context context, int i, ISetNotificationPrivacyListener iSetNotificationPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65626, null, context, i, iSetNotificationPrivacyListener) == null) {
            AccountManager.setNotificationPrivacy(context, i, iSetNotificationPrivacyListener);
        }
    }

    public static void subscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65635, null, new Object[]{context, Long.valueOf(j), iSubscribePaListener}) == null) {
            PaManager.subscribePa(context, j, iSubscribePaListener);
        }
    }

    public static void unSubscribePa(Context context, long j, ISubscribePaListener iSubscribePaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65639, null, new Object[]{context, Long.valueOf(j), iSubscribePaListener}) == null) {
            PaManager.unSubscribePa(context, j, iSubscribePaListener);
        }
    }

    public static List<ChatMsg> getPaMsgByChatType(Context context, List<Integer> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65581, null, context, list, i)) == null) {
            return ChatMsgManager.getPaMsgByChatType(context, list, i);
        }
        return (List) invokeLLI.objValue;
    }

    public static void getServiceNotifyMenuStatus(Context context, long j, List<Long> list, List<String> list2, int i, String str, IGetServiceNotifyMenuListener iGetServiceNotifyMenuListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65584, null, new Object[]{context, Long.valueOf(j), list, list2, Integer.valueOf(i), str, iGetServiceNotifyMenuListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).getServiceNotifyMenuStatus(j, list, list2, str, i, iGetServiceNotifyMenuListener);
    }

    public static void queryPaSendMsgPolicy(Context context, Long l, IIsAllowSendMsgListener iIsAllowSendMsgListener, int i, int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65601, null, new Object[]{context, l, iIsAllowSendMsgListener, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).getSendMsgPolicy(l.longValue(), iIsAllowSendMsgListener, i, false, i2, i3, j);
    }

    public static void setSubscription(Context context, long j, List<Long> list, List<String> list2, int i, String str, ISetSubscriptionListener iSetSubscriptionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65629, null, new Object[]{context, Long.valueOf(j), list, list2, Integer.valueOf(i), str, iSetSubscriptionListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).setSubscription(j, list, list2, i, str, false, iSetSubscriptionListener);
    }

    public static void setSubscriptionForFeed(Context context, long j, List<Long> list, List<String> list2, int i, String str, ISetSubscriptionListener iSetSubscriptionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65630, null, new Object[]{context, Long.valueOf(j), list, list2, Integer.valueOf(i), str, iSetSubscriptionListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).setSubscription(j, list, list2, i, str, true, iSetSubscriptionListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean receiveRemoteNotification(Context context, String str, IFetchMessageListener iFetchMessageListener) {
        InterceptResult invokeLLL;
        long j;
        long j2;
        long j3;
        long j4;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65604, null, context, str, iFetchMessageListener)) == null) {
            if (BaseManager.isNullContext(context)) {
                LogUtils.e(TAG, " Context is NULL!");
                return false;
            }
            LogUtils.d(TAG, "receive custom msg:" + str);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            long j5 = -1;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e = e;
                j = -1;
                j2 = -1;
            }
            if (jSONObject.has("bd_transformer")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("bd_transformer");
                j = optJSONObject.optLong("to", -1L);
                try {
                    j2 = optJSONObject.optLong("from", -1L);
                    try {
                        j3 = optJSONObject.optLong("msgid", -1L);
                        try {
                            j4 = optJSONObject.optLong("appid", -1L);
                        } catch (JSONException e2) {
                            e = e2;
                            LogUtils.e(TAG, str, e);
                            j4 = -1;
                            j5 = j;
                            if (j5 != Utility.getUK(context)) {
                            }
                            LogUtils.d(TAG, "touser:" + j5 + "  uk:" + Utility.getUK(context) + "  appId:" + j4 + "  realAppid" + AccountManager.getAppid(context));
                            return false;
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        j3 = -1;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    j2 = -1;
                    j3 = j2;
                    LogUtils.e(TAG, str, e);
                    j4 = -1;
                    j5 = j;
                    if (j5 != Utility.getUK(context)) {
                    }
                    LogUtils.d(TAG, "touser:" + j5 + "  uk:" + Utility.getUK(context) + "  appId:" + j4 + "  realAppid" + AccountManager.getAppid(context));
                    return false;
                }
                j5 = j;
                if (j5 != Utility.getUK(context) && j2 >= 0 && j3 >= 0) {
                    IMManager.init(context, IMConfigInternal.getInstance().getProductLine(context));
                    login(context, AccountManager.getToken(context), null);
                    return true;
                }
                LogUtils.d(TAG, "touser:" + j5 + "  uk:" + Utility.getUK(context) + "  appId:" + j4 + "  realAppid" + AccountManager.getAppid(context));
                return false;
            }
            j4 = -1;
            j2 = -1;
            j3 = -1;
            if (j5 != Utility.getUK(context)) {
            }
            LogUtils.d(TAG, "touser:" + j5 + "  uk:" + Utility.getUK(context) + "  appId:" + j4 + "  realAppid" + AccountManager.getAppid(context));
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean registerNotify(Context context, String str, String str2, String str3, IOnRegisterNotifyListener iOnRegisterNotifyListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65607, null, context, str, str2, str3, iOnRegisterNotifyListener)) == null) {
            LogUtils.d(TAG, "channelId=" + str + ";userId=" + str2 + ";appId=" + str3);
            if (BaseManager.isNullContext(context)) {
                if (iOnRegisterNotifyListener != null) {
                    iOnRegisterNotifyListener.onRegisterNotifyResult(1005, "Context is NULL!");
                }
                return false;
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                return ChatMsgManagerImpl.getInstance(context).registerNotify(str, str2, str3, iOnRegisterNotifyListener);
            } else {
                if (iOnRegisterNotifyListener != null) {
                    iOnRegisterNotifyListener.onRegisterNotifyResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
                }
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public static void setGroupAndStrangerDisturb(Context context, long j, int i, int i2, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65616, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iStatusListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).requestDisturbAndRemind(j, 3, i, i2, iStatusListener);
    }

    public static void setShield(Context context, long j, int i, int i2, int i3, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65627, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iStatusListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ShieldAndTopManager.getInstance(context).setShield(j, i, i2, i3, iStatusListener);
    }

    public static void updateMsgUsersFromMsgCenter(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65644, null, context) == null) && !BaseManager.isNullContext(context) && Utility.isNeedSync(context, Constants.KEY_SYNC_MSG_TAB_TIME) && AccountManager.isLogin(context)) {
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
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$context = context;
                            }

                            @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                            public void onGetUserIdentityResult(int i, List<ChatUser> list) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, list) == null) {
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
                        for (int i = 0; i < arrayList2.size(); i++) {
                            if (arrayList2.get(i) != null) {
                                jArr[i] = ((Long) arrayList2.get(i)).longValue();
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

                            @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfosListener
                            public void onResult(int i2, String str3, ArrayList<PaInfo> arrayList4) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str3, arrayList4) == null) && i2 == 0) {
                                    Iterator<PaInfo> it = arrayList4.iterator();
                                    while (it.hasNext()) {
                                        PaInfoDBManager.getInstance(this.val$context).subscribePa(it.next());
                                    }
                                    ChatMessageDBManager.getInstance(this.val$context).updateSessionClassAndNotify(arrayList4);
                                }
                            }
                        });
                    }
                    ShieldAndTopManager.getInstance(context).requestMsgMarkTopList();
                    ShieldAndTopManager.getInstance(context).requestMsgDisturb();
                    Utility.writeLongData(context, Constants.KEY_SYNC_MSG_TAB_TIME, System.currentTimeMillis() + Constants.SYNC_MSG_DELAY_TIME);
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "updateMsgUsersFromMsgCenter :", e);
            }
        }
    }
}
