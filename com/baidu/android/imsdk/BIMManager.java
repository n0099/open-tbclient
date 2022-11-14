package com.baidu.android.imsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.account.IGetTokenByCuidListener;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.IFetchMessageListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener;
import com.baidu.android.imsdk.chatmessage.IGetNewMsgCountListener;
import com.baidu.android.imsdk.chatmessage.IGetSessionListener;
import com.baidu.android.imsdk.chatmessage.IMediaChatMsgChangedListener;
import com.baidu.android.imsdk.chatmessage.IMediaContactorSettingListener;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener;
import com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener;
import com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener;
import com.baidu.android.imsdk.chatmessage.IMediaGetContactorPauidListener;
import com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener;
import com.baidu.android.imsdk.chatmessage.IMediaSetSessionReadListener;
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.IUserPrivacyListener;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.conversation.IConversationChangeListener;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMManagerImpl;
import com.baidu.android.imsdk.internal.IMSettings;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.retrieve.RetrieveMsgReceiver;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.android.imsdk.shield.ISetForbidListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.c80;
import com.baidu.tieba.k90;
import com.baidu.tieba.m80;
import com.baidu.tieba.o80;
import com.baidu.tieba.p70;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BIMManager extends BaseManager implements NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Runnable checkIMLoginState;
    public static IConnectListener mConnectListener;
    public static List<IConnectListener> mConnectListeners;
    public static Context sContext;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isSupportMsgType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65598, null, i)) == null) ? i == 0 || i == 8 || i == 2 || i == 1 || i == 13 || i == 16 || i == 18 || i == 12 || i == 21 || i == 9 || i == 1002 || i == 1001 || i == 1003 || i == 1004 || i == 1005 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011 || i == 2010 || i == 1012 || i == 2001 || i == 80 || i == 31 || i == 32 || i == 33 || i == 20 || i == 22 || i == 25 || i == 26 || i == 24 || i == 2012 || i == 2014 || i == 28 || i == 27 || i == 29 || i == 30 || i == 35 || i == 36 || i == 38 || i == 1013 || i == 1014 || i == 39 || i == 40 || i == 41 : invokeI.booleanValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class CATEGORY {
        public static final /* synthetic */ CATEGORY[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CATEGORY ALL;
        public static final CATEGORY GROUP;
        public static final CATEGORY PA;
        public static final CATEGORY SINGLEPERSON;
        public static final CATEGORY STUDIO;
        public static final CATEGORY SYSTEM;
        public static final CATEGORY UNKOWN;
        public static final CATEGORY ZHIDA;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(845770119, "Lcom/baidu/android/imsdk/BIMManager$CATEGORY;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(845770119, "Lcom/baidu/android/imsdk/BIMManager$CATEGORY;");
                    return;
                }
            }
            ALL = new CATEGORY("ALL", 0, -1);
            SINGLEPERSON = new CATEGORY("SINGLEPERSON", 1, 0);
            GROUP = new CATEGORY("GROUP", 2, 1);
            SYSTEM = new CATEGORY("SYSTEM", 3, 2);
            PA = new CATEGORY("PA", 4, 0);
            ZHIDA = new CATEGORY("ZHIDA", 5, 0);
            STUDIO = new CATEGORY("STUDIO", 6, 4);
            CATEGORY category = new CATEGORY("UNKOWN", 7, -1);
            UNKOWN = category;
            $VALUES = new CATEGORY[]{ALL, SINGLEPERSON, GROUP, SYSTEM, PA, ZHIDA, STUDIO, category};
        }

        public CATEGORY(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i2;
        }

        public static CATEGORY valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CATEGORY) Enum.valueOf(CATEGORY.class, str);
            }
            return (CATEGORY) invokeL.objValue;
        }

        public static CATEGORY[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CATEGORY[]) $VALUES.clone();
            }
            return (CATEGORY[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.value;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-671636915, "Lcom/baidu/android/imsdk/BIMManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-671636915, "Lcom/baidu/android/imsdk/BIMManager;");
                return;
            }
        }
        mConnectListeners = new ArrayList();
        checkIMLoginState = new Runnable() { // from class: com.baidu.android.imsdk.BIMManager.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (m80.b() == 0 && LoginManager.getInstance(BIMManager.sContext).getCurrentState() != LoginManager.LoginState.LOGINED) {
                        LogUtils.e("BIMManager", "checkIMLoginState lcp connected, but im not login, triggle im relogin");
                        LoginManager.getInstance(BIMManager.sContext).triggleLogoutListener(4001, Constants.ERROR_LOGIN_STATE_ERROR);
                    }
                    BIMManager.postCheckRunnable();
                }
            }
        };
    }

    public BIMManager() {
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

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) {
            return IMManagerImpl.getVersion();
        }
        return (String) invokeV.objValue;
    }

    public static void initLCP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65596, null) == null) {
            o80.e().i(sContext);
        }
    }

    public static void pingRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65628, null) == null) {
            m80.e();
        }
    }

    public static void postCheckRunnable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65629, null) == null) {
            try {
                LogUtils.i("BIMManager", "postCheckRunnable after 30s");
                c80.c.postDelayed(checkIMLoginState, 30000L);
            } catch (Exception e) {
                LogUtils.e(BaseManager.TAG, "postCheckRunnable exception ", e);
            }
        }
    }

    public static void unregisterConnectListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65659, null) == null) {
            mConnectListener = null;
        }
    }

    public static void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            LogUtils.d(BaseManager.TAG, "start clearCache");
            Utility.clearFileCache(context);
            IMTrackDatabase.getInstance(context).clearAllTables();
            Utility.writeLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, Utility.getImTrackDbSize(context));
        }
    }

    public static boolean deleteConversation(BIMConversation bIMConversation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bIMConversation)) == null) {
            if (!BaseManager.isNullContext(sContext) && bIMConversation != null) {
                return ConversationManagerImpl.getInstance(sContext).deleteConversation(bIMConversation);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean enableDebugMode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65557, null, z)) == null) {
            if (BaseManager.isNullContext(sContext)) {
                return false;
            }
            try {
                k90.a = z;
            } catch (Throwable unused) {
                LogUtils.e(BaseManager.TAG, "LCPConstants.LOG_DEBUG not found");
            }
            return IMSettings.enableDebugMode(sContext.getApplicationContext(), z);
        }
        return invokeZ.booleanValue;
    }

    public static String getAllCastIdList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            return ConversationStudioManImpl.getInstance(context).getAllCastIdList();
        }
        return (String) invokeL.objValue;
    }

    public static ArrayList<BIMConversation> getAllConversation(CATEGORY category) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, category)) == null) {
            if (BaseManager.isNullContext(sContext)) {
                return null;
            }
            return ConversationManagerImpl.getInstance(sContext).getAllConversation(category);
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String getAppVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            return AccountManagerImpl.getInstance(context).getAppVersion();
        }
        return (String) invokeL.objValue;
    }

    public static String getCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            return Utility.getDeviceId(context);
        }
        return (String) invokeL.objValue;
    }

    public static long getJoinedCastId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            return ConversationStudioManImpl.getInstance(context).getJoinedCastId();
        }
        return invokeL.longValue;
    }

    public static int getLoginType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) {
            return AccountManagerImpl.getInstance(context).getLoginType();
        }
        return invokeL.intValue;
    }

    public static int getNewMsgCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            return ChatMsgManager.getNewMsgCount(context);
        }
        return invokeL.intValue;
    }

    public static void imLogoutByLcp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, null, context) == null) {
            try {
                c80.e(context);
                LoginManager.getInstance(context).onLogoutResultInternal(0, "lcp unconnected");
            } catch (Exception e) {
                LogUtils.e(BaseManager.TAG, "imLogoutByLcp exception ", e);
            }
        }
    }

    public static void imLogoutByLcpAsync(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65593, null, context) == null) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context) { // from class: com.baidu.android.imsdk.BIMManager.3
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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BIMManager.imLogoutByLcp(this.val$context);
                    }
                }
            });
        }
    }

    public static void initIMServiceImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65595, null, context) == null) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context) { // from class: com.baidu.android.imsdk.BIMManager.2
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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c80.g(this.val$context);
                    }
                }
            });
        }
    }

    public static boolean isIMLogined(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, context)) == null) {
            return LoginManager.getInstance(context).isIMLogined();
        }
        return invokeL.booleanValue;
    }

    public static void registerConnectListener(IConnectListener iConnectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65632, null, iConnectListener) == null) {
            mConnectListener = iConnectListener;
            registerConnectListenerToList(iConnectListener);
        }
    }

    public static void registerConversationListener(IConversationChangeListener iConversationChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65634, null, iConversationChangeListener) != null) || BaseManager.isNullContext(sContext)) {
            return;
        }
        ConversationManagerImpl.getInstance(sContext).registerConversationListener(iConversationChangeListener);
    }

    public static void registerInternalListener(IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65635, null, iMessageReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(sContext).registerInternalMessageReceiveListener(iMessageReceiveListener);
        }
    }

    public static void tryConnection(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65656, null, context) != null) || c80.e) {
            return;
        }
        AccountManagerImpl.getInstance(context);
        AccountManagerImpl.tryConnection(context);
    }

    public static void unregisterConversationListener(IConversationChangeListener iConversationChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65661, null, iConversationChangeListener) != null) || BaseManager.isNullContext(sContext)) {
            return;
        }
        ConversationManagerImpl.getInstance(sContext).unregisterConversationListener(iConversationChangeListener);
    }

    public static void asyncUploadImgToBos(Context context, String str, String str2, int i, int i2, int i3, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iUploadTransferListener}) == null) {
            ChatMsgManager.asyncUploadImgToBos(context, str, str2, i, i2, i3, iUploadTransferListener);
        }
    }

    public static void mediaContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65604, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaContactorSetting(context, j, i, j2, str, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j, int i, long j2, String str, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65610, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaDeleteChatSessionListener}) == null) {
            ChatMsgManager.mediaDeleteChatSession(context, j, i, j2, str, j3, iMediaDeleteChatSessionListener);
        }
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65618, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaGetContactorSetting(context, j, i, j2, str, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaSendChatMsg(Context context, long j, int i, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65621, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManager.mediaSendChatMsg(context, j, i, j2, str, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j, int i, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65625, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaSetSessionReadListener}) == null) {
            ChatMsgManager.mediaSetSessionRead(context, j, i, j2, str, j3, iMediaSetSessionReadListener);
        }
    }

    public static void audioTrans(Context context, String str, String str2, String str3, int i, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), bIMValueCallBack}) == null) {
            ChatMsgManager.audioTrans(context, str, str2, str3, i, bIMValueCallBack);
        }
    }

    public static void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65613, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.mediaFetchChatMsgs(context, j, j2, j3, i, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaGetContactorPauid(Context context, long j, int i, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65616, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, iMediaGetContactorPauidListener}) == null) {
            ChatMsgManager.mediaGetContactorPauid(context, j, i, j2, str, iMediaGetContactorPauidListener);
        }
    }

    public static void autoClearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            long imTrackDbSize = Utility.getImTrackDbSize(context);
            long readLongData = Utility.readLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, 0L);
            String str = BaseManager.TAG;
            LogUtils.d(str, "autoClearCache trackSize = " + imTrackDbSize + " defSize = " + readLongData);
            if (imTrackDbSize - readLongData >= 307200) {
                LogUtils.d(BaseManager.TAG, "autoClearCache start clean db");
                IMTrackDatabase.getInstance(context).clearAllTables();
                Utility.writeLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, Utility.getImTrackDbSize(context));
            }
            long sumCacheSize = Utility.sumCacheSize(context);
            String str2 = BaseManager.TAG;
            LogUtils.d(str2, "autoClearCache pluginCacheSize = " + sumCacheSize);
            if (sumCacheSize >= 31457280) {
                LogUtils.d(BaseManager.TAG, "autoClearCache start clean cache");
                Utility.clearFileCache(context);
            }
        }
    }

    public static void connectStatusNotify(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i) == null) {
            String str = BaseManager.TAG;
            LogUtils.i(str, "connectStatusNotify:" + i);
            String str2 = BaseManager.TAG;
            LogUtils.i(str2, "IConnectListener size:" + mConnectListeners.size());
            synchronized (mConnectListeners) {
                for (IConnectListener iConnectListener : mConnectListeners) {
                    if (iConnectListener != null) {
                        String str3 = BaseManager.TAG;
                        LogUtils.i(str3, "im connect Status changed，成功回调业务监听, listener :" + iConnectListener.hashCode());
                        iConnectListener.onResult(i);
                    }
                }
            }
        }
    }

    public static void clearDb(Context context) {
        File[] listFiles;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            File file = new File(context.getDatabasePath("bdimsdk_.db").getParent());
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && (name = file2.getName()) != null && name.startsWith(TableDefine.DB_NAME_PREFIX)) {
                        file2.delete();
                    }
                }
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().clear().commit();
            }
        }
    }

    public static long getCacheSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            long sumCacheSize = Utility.sumCacheSize(context);
            long imTrackDbSize = Utility.getImTrackDbSize(context);
            long j = 0;
            long readLongData = Utility.readLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, 0L);
            String str = BaseManager.TAG;
            LogUtils.d(str, "getCacheSize pluginCacheSize = " + sumCacheSize + " trackSize = " + imTrackDbSize + " defSize = " + readLongData);
            long j2 = imTrackDbSize - readLongData;
            if (j2 >= 0) {
                j = j2;
            }
            return sumCacheSize + j;
        }
        return invokeL.longValue;
    }

    public static int deleteDraftMsg(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return ChatMsgManager.deleteDraftMsg(context, i, j);
        }
        return invokeCommon.intValue;
    }

    public static void getChatSession(Context context, List<Integer> list, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, list, iGetSessionListener) == null) {
            IMBoxManager.getChatSession(context, list, iGetSessionListener);
        }
    }

    public static ChatMsg getDraftMsg(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65580, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return ChatMsgManager.getDraftMsg(context, i, j);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public static void getNewMsgCount(Context context, List<Integer> list, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65586, null, context, list, iGetNewMsgCountListener) == null) {
            IMBoxManager.getNewMsgCount(context, list, iGetNewMsgCountListener);
        }
    }

    public static void mediaGetContactorPauid(Context context, long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65617, null, new Object[]{context, Long.valueOf(j), iMediaGetContactorPauidListener}) == null) {
            ChatMsgManager.mediaGetContactorPauid(context, j, iMediaGetContactorPauidListener);
        }
    }

    public static void sendMessage(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65642, null, context, chatMsg, iSendMessageListener) != null) || context == null) {
            return;
        }
        ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
    }

    public static int deleteMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, chatMsg)) == null) {
            return ChatMsgManager.deleteMsg(context, chatMsg);
        }
        return invokeLL.intValue;
    }

    @Deprecated
    public static long deleteMsgs(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65556, null, context, j)) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(0, j, false);
        }
        return invokeLJ.longValue;
    }

    @Deprecated
    public static List<ChatSession> getChatSession(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, context, list)) == null) {
            return ChatMsgManager.getChatRecords(context, list);
        }
        return (List) invokeLL.objValue;
    }

    public static ChatUser getChatUserSync(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65574, null, context, j)) == null) {
            return ChatUserManager.getChatUserSync(context, j);
        }
        return (ChatUser) invokeLJ.objValue;
    }

    public static long getMaxReliableMsgId(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65584, null, context, j)) == null) {
            return ConversationStudioManImpl.getInstance(context).getMaxReliableMsgId(j);
        }
        return invokeLJ.longValue;
    }

    public static long getReliableMsgCount(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65588, null, context, j)) == null) {
            return ConversationStudioManImpl.getInstance(context).getReliableMsgCount(j);
        }
        return invokeLJ.longValue;
    }

    public static int getUnReadMsgCountByPaid(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65589, null, context, j)) == null) {
            return ChatMsgManager.getUnReadMsgCountByPaid(context, j);
        }
        return invokeLJ.intValue;
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65603, null, context, chatMsg)) == null) {
            return ChatMsgManager.markMsgClicked(context, chatMsg);
        }
        return invokeLL.intValue;
    }

    public static void mediaRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65620, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManager.mediaRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
        }
    }

    public static void mediaSetAllSessionRead(Context context, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65623, null, context, iMediaSetSessionReadListener) == null) {
            ChatMsgManager.setMediaAllSessionRead(context, iMediaSetSessionReadListener);
        }
    }

    public static void mediaSetRole(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65624, null, context, z) == null) {
            AccountManager.setMediaRole(context, z);
        }
    }

    public static void mediaUnRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65627, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManager.mediaUnRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
        }
    }

    public static void registerChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65630, null, context, iChatSessionChangeListener) == null) {
            IMBoxManager.registerChatSessionChangeListener(context, iChatSessionChangeListener);
        }
    }

    public static void registerChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65631, null, context, iChatSessionChangeListener) == null) {
            ChatMsgManager.registerChatSessionListener(context, iChatSessionChangeListener);
        }
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65636, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.registerMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static void registerStudioUsePaReceiveMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65638, null, context, iLiveMsgReceiveListener) == null) {
            if (context == null && iLiveMsgReceiveListener != null) {
                iLiveMsgReceiveListener.onReceiveMessage(-1, null);
            }
            ChatMsgManager.registerStudioUsePaReceivePaMsg(context, iLiveMsgReceiveListener);
        }
    }

    public static void removeSessionByClasstype(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65639, null, context, i) == null) {
            IMBoxManager.removeSessionByClasstype(context, i);
        }
    }

    public static int saveAsDraftMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65640, null, context, chatMsg)) == null) {
            return ChatMsgManager.saveAsDraftMsg(context, chatMsg);
        }
        return invokeLL.intValue;
    }

    public static void saveMessage(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65641, null, context, chatMsg) == null) {
            ChatMsgManager.saveMessage(context, chatMsg);
        }
    }

    public static void setUpdateSwitch(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65653, null, context, i) == null) {
            AccountManager.setUpdateSwitch(context, i);
        }
    }

    public static void unregisterChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65657, null, context, iChatSessionChangeListener) == null) {
            IMBoxManager.unregisterChatSessionChangeListener(context, iChatSessionChangeListener);
        }
    }

    public static void unregisterChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65658, null, context, iChatSessionChangeListener) == null) {
            ChatMsgManager.unregisterChatSessionListener(context, iChatSessionChangeListener);
        }
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65662, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.unregisterMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static void unregisterStudioUsePaReceiveMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65663, null, context, iLiveMsgReceiveListener) == null) {
            if (context == null && iLiveMsgReceiveListener != null) {
                iLiveMsgReceiveListener.onReceiveMessage(-1, null);
            }
            ChatMsgManager.unregisterStudioUsePaReceivePaMsg(context, iLiveMsgReceiveListener);
        }
    }

    public static int deleteMsgs(Context context, long j, long[] jArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{context, Long.valueOf(j), jArr, Boolean.valueOf(z)})) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) {
            return ChatMsgManager.fetchMessageSync(context, 0, j, j2, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static void mediaDeleteAllChatMsg(Context context, long j, long j2, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65607, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j, j2, null, iMediaDeleteChatMsgListener);
        }
    }

    public static boolean setAllMsgRead(Context context, int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65645, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            return ChatMsgManager.setAllMsgRead(context, i, j, z);
        }
        return invokeCommon.booleanValue;
    }

    public static void setGroupMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65647, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j, 3, i, iStatusListener);
        }
    }

    public static void setMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65648, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j, 1, i, iStatusListener);
        }
    }

    public static boolean setMsgRead(Context context, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65650, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            return ChatMsgManager.setMsgRead(context, 0, j, j2, z);
        }
        return invokeCommon.booleanValue;
    }

    public static void setUserMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65655, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j, 0, i, iStatusListener);
        }
    }

    public static long deleteMsgs(Context context, int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i, j, z);
        }
        return invokeCommon.longValue;
    }

    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), chatMsg})) == null) {
            return ChatMsgManager.fetchMessageSyncWithState(context, i, j, i2, chatMsg);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static BIMConversation getConversation(Context context, String str, CATEGORY category, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{context, str, category, str2, Integer.valueOf(i)})) == null) {
            return getConversation(context, str, false, category, str2, i);
        }
        return (BIMConversation) invokeCommon.objValue;
    }

    public static void mediaGetChatSessions(Context context, long j, long j2, int i, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65615, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), iMediaGetChatSessionListener}) == null) {
            ChatMsgManager.mediaGetChatSessions(context, j, j2, i, iMediaGetChatSessionListener);
        }
    }

    public static void setForbid(Context context, long j, long j2, int i, ISetForbidListener iSetForbidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65646, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), iSetForbidListener}) == null) {
            ShieldAndTopManager.getInstance(context).setForbid(j, j2, i, iSetForbidListener);
        }
    }

    public static void fetchMsgByHostRequest(Context context, long j, int i, long j2, long j3, long j4, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            fetchMsgByHostRequest(context, j, i, j2, j3, j4, i2, i3, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchMsgByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManager.fetchMsgRequst(context, Utility.getAppId(context), Utility.getUK(context), i, j, j2, j3, i2, iFetchMsgByIdListener, z);
        }
    }

    public static void fetchMsgByHostRequest(Context context, long j, int i, long j2, long j3, long j4, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManager.fetchMsgByHostRequst(context, j, i, j2, j3, j4, i2, iFetchMsgByIdListener);
        }
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            fetchMsgRequest(context, j, j2, i, j3, j4, j5, i2, i3, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchMsgByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            fetchMsgByMsgid(context, i, j, j2, j3, i2, i3, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManager.fetchMsgRequst(context, j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener, z);
        }
    }

    public static void fetchPaChatMsgs(Context context, int i, int i2, long j, long j2, long j3, int i3, IFetchMessageListener iFetchMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), iFetchMessageListener}) == null) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "fetchPaChatMsgs patype = " + i + " subPatype = " + i2 + " paid = " + j + " msgid = " + j2 + " time = " + j3 + " count = " + i3);
            ChatMsgManager.fetchPaChatMsgs(context, i, i2, j, j2, j3, i3, iFetchMessageListener);
        }
    }

    public static void genBosObjectUrl(Context context, String str, String str2, String str3, int i, int i2, int i3, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iGenBosObjectUrlListener}) == null) {
            ChatMsgManager.genBosObjectUrl(context, str, str2, str3, i, i2, i3, iGenBosObjectUrlListener);
        }
    }

    public static BIMConversation getConversation(Context context, String str, boolean z, CATEGORY category, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{context, str, Boolean.valueOf(z), category, str2, Integer.valueOf(i)})) == null) {
            if (BaseManager.isNullContext(context)) {
                LogUtils.e(BaseManager.TAG, "GETCONVERSATION context is null");
                return null;
            }
            sContext = context;
            if (CATEGORY.ALL != category && CATEGORY.SYSTEM != category) {
                return ConversationStudioManImpl.getInstance(sContext).getConversation(category, str, z, str2, i);
            }
            LogUtils.e(LogUtils.TAG, "GETCONVERSATION category should not be ALL or SYSTEM");
            return null;
        }
        return (BIMConversation) invokeCommon.objValue;
    }

    public static void loginExecutor(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65601, null, new Object[]{Integer.valueOf(i), str, str2, str3, str4, iLoginListener}) == null) {
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "accessToken is NULL");
                }
            } else {
                if (i != 6) {
                    if (TextUtils.isEmpty(str)) {
                        Utility.writeLoginFlag(sContext, "4N", "uid is null");
                        if (iLoginListener != null) {
                            iLoginListener.onLoginResult(1005, "uid is NULL");
                            return;
                        }
                        return;
                    }
                    Utility.writeLoginFlag(sContext, "4Y", "uid is nonnull");
                }
                AccountManagerImpl.getInstance(sContext).login(i, str, str2, str3, str4, iLoginListener);
            }
        }
    }

    public static void setPaMsgsRead(Context context, int i, int i2, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65651, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "setPaMsgsRead patype = " + i + " subPatype = " + i2 + " paid = " + j + " msgid = " + j2 + " time = " + j3);
            ChatMsgManager.setPaMsgsRead(context, i, i2, j, j2, j3);
        }
    }

    public static BIMConversation getConversation(String str, CATEGORY category) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, str, category)) == null) {
            if (BaseManager.isNullContext(sContext)) {
                return null;
            }
            if (CATEGORY.ALL != category && CATEGORY.SYSTEM != category) {
                return ConversationManagerImpl.getInstance(sContext).getConversation(category, str);
            }
            LogUtils.e(LogUtils.TAG, "category should not be ALL or SYSTEM");
            return null;
        }
        return (BIMConversation) invokeLL.objValue;
    }

    public static void getCuidTokenAndLogin(String str, int i, String str2, String str3, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65579, null, new Object[]{str, Integer.valueOf(i), str2, str3, iLoginListener}) == null) {
            Context context = sContext;
            Utility.writeLoginFlag(context, "3N", "getCuidTokenAndLogin accessToken = " + str);
            AccountManagerImpl.getInstance(sContext).getTokenByCuid(AccountManager.getAppid(sContext), str, new IGetTokenByCuidListener(i, str2, str3, iLoginListener, str) { // from class: com.baidu.android.imsdk.BIMManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$accessToken;
                public final /* synthetic */ String val$cfrom;
                public final /* synthetic */ String val$from;
                public final /* synthetic */ ILoginListener val$listener;
                public final /* synthetic */ int val$loginType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i), str2, str3, iLoginListener, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$loginType = i;
                    this.val$from = str2;
                    this.val$cfrom = str3;
                    this.val$listener = iLoginListener;
                    this.val$accessToken = str;
                }

                @Override // com.baidu.android.imsdk.account.IGetTokenByCuidListener
                public void onGetTokenByCuidResult(int i2, String str4, String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str4, str5) == null) {
                        if (i2 == 0) {
                            if (!TextUtils.isEmpty(str5)) {
                                AccountManagerImpl.getInstance(BIMManager.sContext);
                                AccountManagerImpl.mCuidTokenTryTimes = 0;
                                LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token =  " + str5);
                                Utility.writeLoginFlag(BIMManager.sContext, "3Y", "genToken success, token = " + str5);
                                BIMManager.loginExecutor(this.val$loginType, null, str5, this.val$from, this.val$cfrom, this.val$listener);
                                return;
                            }
                            LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token is null,  responseCode = " + i2 + ", errMsg = " + str4);
                            AccountManagerImpl.getInstance(BIMManager.sContext);
                            AccountManagerImpl.mCuidTokenTryTimes = AccountManagerImpl.mCuidTokenTryTimes + 1;
                            AccountManagerImpl.getInstance(BIMManager.sContext);
                            if (AccountManagerImpl.mCuidTokenTryTimes <= 3) {
                                try {
                                    Thread.sleep(200L);
                                } catch (Exception e) {
                                    LogUtils.e(BaseManager.TAG, "Exception ", e);
                                    Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken retry exception, errCode = " + i2);
                                    new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e)).build();
                                }
                                BIMManager.getCuidTokenAndLogin(this.val$accessToken, this.val$loginType, this.val$from, this.val$cfrom, this.val$listener);
                                return;
                            }
                            Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken is null, errCode = 1005");
                            this.val$listener.onLoginResult(1005, "gen token is NULL");
                        } else if (i2 == 70) {
                            this.val$listener.onLoginResult(i2, str4);
                        } else {
                            AccountManagerImpl.getInstance(BIMManager.sContext);
                            AccountManagerImpl.mCuidTokenTryTimes++;
                            LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, responseCode = " + i2 + ", errMsg = " + str4);
                            AccountManagerImpl.getInstance(BIMManager.sContext);
                            if (AccountManagerImpl.mCuidTokenTryTimes > 3) {
                                Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken retryTime >= 3, errCode = " + i2 + ", errMsg :" + str4);
                                this.val$listener.onLoginResult(i2, str4);
                                return;
                            }
                            try {
                                Thread.sleep(200L);
                            } catch (Exception e2) {
                                LogUtils.e(BaseManager.TAG, "Exception ", e2);
                                Utility.writeLoginFlag(BIMManager.sContext, "3N", "gen token retry exception, errCode = " + i2);
                                new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e2)).build();
                            }
                            BIMManager.getCuidTokenAndLogin(this.val$accessToken, this.val$loginType, this.val$from, this.val$cfrom, this.val$listener);
                        }
                    }
                }
            });
        }
    }

    public static void getPaNewMsgCount(Context context, int i, int i2, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65587, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), iGetNewMsgCountListener}) == null) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "getPaNewMsgCount patype = " + i + " subPatype = " + i2 + " paid = " + j);
            ChatMsgManager.getPaNewMsgCount(context, i, i2, j, iGetNewMsgCountListener);
        }
    }

    public static String getLoginUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            if (BaseManager.isNullContext(sContext) || !AccountManagerImpl.getInstance(sContext).isLogin() || !LoginManager.LoginState.LOGINED.equals(LoginManager.getInstance(sContext).getCurrentState())) {
                return null;
            }
            return AccountManagerImpl.getInstance(sContext).getUid();
        }
        return (String) invokeV.objValue;
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65590, null, new Object[]{context, arrayList, Boolean.valueOf(z), iGetUsersProfileBatchListener}) == null) {
            ChatUserManager.getUsersProfiles(context, arrayList, z, iGetUsersProfileBatchListener);
        }
    }

    public static void mediaContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65605, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaContactorSetting(context, j, i, iMediaContactorSettingListener);
        }
    }

    public static void mediaDeleteChatMsg(Context context, long j, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65609, null, new Object[]{context, Long.valueOf(j), list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j, -1L, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65611, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iMediaDeleteChatSessionListener}) == null) {
            ChatMsgManager.mediaDeleteChatSession(context, j, j2, iMediaDeleteChatSessionListener);
        }
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65619, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaGetContactorSetting(context, j, i, iMediaContactorSettingListener);
        }
    }

    public static void mediaSendChatMsg(Context context, long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65622, null, new Object[]{context, Long.valueOf(j), chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManager.mediaSendChatMsg(context, j, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65626, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iMediaSetSessionReadListener}) == null) {
            ChatMsgManager.mediaSetSessionRead(context, j, j2, iMediaSetSessionReadListener);
        }
    }

    public static void sendMsgRequest(Context context, boolean z, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65643, null, new Object[]{context, Boolean.valueOf(z), chatMsg, iSendMessageListener}) != null) || context == null) {
            return;
        }
        Utility.setStudioHostSendMsg(context, z);
        ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
    }

    public static void setUserDisturb(Context context, long j, int i, IUserPrivacyListener iUserPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65654, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iUserPrivacyListener}) == null) {
            IMBoxManager.setUserDisturb(context, j, i, iUserPrivacyListener);
        }
    }

    public static boolean init(Context context, long j, int i, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65594, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str})) == null) {
            boolean z = false;
            if (BaseManager.isNullContext(context) || TextUtils.isEmpty(str)) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            sContext = applicationContext;
            c80.e = m80.d(applicationContext);
            if (c80.e) {
                try {
                    initLCP();
                    if (i != 0) {
                        z = true;
                    }
                    k90.c(applicationContext, z);
                    k90.d(applicationContext, i);
                } catch (Throwable unused) {
                    LogUtils.e(BaseManager.TAG, "LCPConstants.setLcpEnv not found");
                }
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(applicationContext).registerReceiver(new BroadcastReceiver() { // from class: com.baidu.android.imsdk.BIMManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    boolean z2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && intent != null && "com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                        if (intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        LogUtils.e("BIMManager", "BLCPClient notifyConnectState :" + z2);
                        if (!z2) {
                            BIMManager.imLogoutByLcpAsync(context2);
                            BIMManager.connectStatusNotify(1);
                        }
                        try {
                            BIMManager.initIMServiceImpl(context2);
                            c80.c.removeCallbacks(BIMManager.checkIMLoginState);
                            if (z2) {
                                BIMManager.postCheckRunnable();
                            }
                        } catch (Exception e) {
                            String str2 = BaseManager.TAG;
                            LogUtils.e(str2, "registerLCPReceiver exception" + e.getMessage());
                        }
                    }
                }
            }, intentFilter);
            Log.d(RetrieveReportRequest.APP_NAME, "set env as " + i + "， appId:" + j + ", cuid :" + str);
            AccountManagerImpl.getInstance(applicationContext).setAppid(j);
            Utility.setDeviceId(applicationContext, str);
            Constants.setEnv(applicationContext, i);
            IMManagerImpl.getInstance(applicationContext);
            IMSettings.setContext(applicationContext);
            ConversationManagerImpl.getInstance(applicationContext);
            Utility.clearExpiredMsg(applicationContext);
            registerInternalListener(RetrieveMsgReceiver.getInstance(applicationContext));
            p70.d().e(applicationContext, str, i, Constants.isDebugMode());
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void login(String str, String str2, int i, String str3, String str4, ILoginListener iLoginListener) {
        IMTrack.RequestBuilder requestId;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65599, null, new Object[]{str, str2, Integer.valueOf(i), str3, str4, iLoginListener}) == null) {
            String str6 = BaseManager.TAG;
            LogUtils.d(str6, "HB> im in login, uid = " + str + " ,cuid = " + str2 + ", loginType = " + i);
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                    return;
                }
                return;
            }
            long j = 0;
            try {
                try {
                    String[] loginFlag = Utility.getLoginFlag(sContext);
                    if (loginFlag.length < 2) {
                        str5 = "1Y";
                    } else {
                        j = Long.valueOf(loginFlag[0]).longValue();
                        str5 = loginFlag[1];
                    }
                    requestId = new IMTrack.RequestBuilder(sContext).method(String.valueOf(AccountManagerImpl.getInstance(sContext).getAppOpenType())).requestId(str5);
                } catch (Exception unused) {
                    LogUtils.e(BaseManager.TAG, "IMTrack init request getLoginFlag Exception ");
                    requestId = new IMTrack.RequestBuilder(sContext).method(String.valueOf(AccountManagerImpl.getInstance(sContext).getAppOpenType())).requestId("1Y");
                }
                requestId.requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                Utility.writeLoginCallTime(sContext);
                Context context = sContext;
                Utility.writeLoginFlag(context, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
                if (TextUtils.isEmpty(str2)) {
                    Utility.writeLoginFlag(sContext, "2N", "accessToken is null");
                    if (iLoginListener != null) {
                        iLoginListener.onLoginResult(1005, "accessToken is NULL");
                        return;
                    }
                    return;
                }
                Context context2 = sContext;
                Utility.writeLoginFlag(context2, "2Y", "accessToken is nonnull, loginType = " + i);
                if (i == 6) {
                    AccountManagerImpl.getInstance(sContext).setCuid(str2);
                    String token = AccountManagerImpl.getInstance(sContext).getToken();
                    if (!TextUtils.isEmpty(token)) {
                        loginExecutor(i, str, token, str3, str4, iLoginListener);
                        return;
                    }
                    AccountManagerImpl.getInstance(sContext);
                    AccountManagerImpl.mCuidTokenTryTimes = 0;
                    getCuidTokenAndLogin(str2, i, str3, str4, iLoginListener);
                    return;
                }
                loginExecutor(i, str, str2, str3, str4, iLoginListener);
            } catch (Throwable th) {
                new IMTrack.RequestBuilder(sContext).method(String.valueOf(AccountManagerImpl.getInstance(sContext).getAppOpenType())).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void login(String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, ILoginListener iLoginListener) {
        long j;
        IMTrack.RequestBuilder requestId;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65600, null, new Object[]{str, str2, Integer.valueOf(i), str3, str4, str5, str6, Integer.valueOf(i2), iLoginListener}) == null) {
            String str8 = BaseManager.TAG;
            LogUtils.d(str8, "HB> im in login, uid = " + str + ", cuid = " + str2 + ", loginType = " + i + ", zid = " + str5 + ", vCode = " + str6 + ", openType = " + i2);
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                    return;
                }
                return;
            }
            try {
                String[] loginFlag = Utility.getLoginFlag(sContext);
                if (loginFlag.length < 2) {
                    str7 = "1Y";
                    j = 0;
                } else {
                    j = Long.valueOf(loginFlag[0]).longValue();
                    try {
                        try {
                            str7 = loginFlag[1];
                        } catch (Exception unused) {
                            LogUtils.e(BaseManager.TAG, "IMTrack init request getLoginFlag Exception ");
                            requestId = new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId("1Y");
                            requestId.requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                            Utility.writeLoginCallTime(sContext);
                            Context context = sContext;
                            Utility.writeLoginFlag(context, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
                            Utility.writeLoginOpenType(sContext, i2);
                            AccountManagerImpl.getInstance(sContext).setAppOpenType(i2);
                            AccountManagerImpl.getInstance(sContext).pushReStartWork();
                            if (!TextUtils.isEmpty(str2)) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                        throw th;
                    }
                }
                requestId = new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId(str7);
            } catch (Exception unused2) {
                j = 0;
            } catch (Throwable th2) {
                th = th2;
                j = 0;
                new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                throw th;
            }
            requestId.requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
            Utility.writeLoginCallTime(sContext);
            Context context2 = sContext;
            Utility.writeLoginFlag(context2, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
            Utility.writeLoginOpenType(sContext, i2);
            AccountManagerImpl.getInstance(sContext).setAppOpenType(i2);
            AccountManagerImpl.getInstance(sContext).pushReStartWork();
            if (!TextUtils.isEmpty(str2)) {
                Utility.writeLoginFlag(sContext, "2N", "accessToken is null");
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "accessToken is NULL");
                    return;
                }
                return;
            }
            Context context3 = sContext;
            Utility.writeLoginFlag(context3, "2Y", "accessToken is nonnull, loginType = " + i);
            if (!TextUtils.isEmpty(str5)) {
                LogUtils.d(BaseManager.TAG, "HB> im in login, zid is not null !");
                AccountManagerImpl.getInstance(sContext).setZid(str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                LogUtils.d(BaseManager.TAG, "HB> im in login, vCode is not null !");
                AccountManagerImpl.getInstance(sContext).setVersionCode(str6);
            }
            if (i == 6) {
                AccountManagerImpl.getInstance(sContext).setCuid(str2);
                String token = AccountManagerImpl.getInstance(sContext).getToken();
                if (!TextUtils.isEmpty(token)) {
                    loginExecutor(i, str, token, str3, str4, iLoginListener);
                    return;
                }
                AccountManagerImpl.getInstance(sContext);
                AccountManagerImpl.mCuidTokenTryTimes = 0;
                getCuidTokenAndLogin(str2, i, str3, str4, iLoginListener);
                return;
            }
            loginExecutor(i, str, str2, str3, str4, iLoginListener);
        }
    }

    public static void logout(ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, null, iLoginListener) == null) {
            LogUtils.d(BaseManager.TAG, "logout");
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLogoutResult(1005, "Context is null", -1);
                    return;
                }
                return;
            }
            AccountManagerImpl.getInstance(sContext).logout(1, new ILoginListener(iLoginListener) { // from class: com.baidu.android.imsdk.BIMManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
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
                        Object[] objArr = {iLoginListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = iLoginListener;
                }

                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLogoutResult(int i, String str, int i2) {
                    String str2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                        String str3 = BaseManager.TAG;
                        LogUtils.i(str3, "onLogoutResult errorCode : " + i + " , errMsg, " + str + " , loginType, " + i2);
                        if (i != 0) {
                            Utility.logout(BIMManager.sContext, null);
                        }
                        LoginManager.getInstance(BIMManager.sContext).onLogoutResultInternal(0, str);
                        ILoginListener iLoginListener2 = this.val$listener;
                        if (iLoginListener2 != null) {
                            if (i != 0) {
                                str2 = "Force logout";
                            } else {
                                str2 = "";
                            }
                            iLoginListener2.onLogoutResult(0, str2, i2);
                        }
                    }
                }
            });
        }
    }

    public static void registerConnectListenerToList(IConnectListener iConnectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65633, null, iConnectListener) == null) {
            synchronized (mConnectListeners) {
                if (!mConnectListeners.contains(iConnectListener)) {
                    mConnectListeners.add(iConnectListener);
                    String str = BaseManager.TAG;
                    LogUtils.i(str, "registerConnectListenerToList:" + iConnectListener.hashCode());
                }
            }
        }
    }

    public static void unregisterConnectListenerFromList(IConnectListener iConnectListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65660, null, iConnectListener) != null) || iConnectListener == null) {
            return;
        }
        synchronized (mConnectListeners) {
            mConnectListeners.remove(iConnectListener);
            String str = BaseManager.TAG;
            LogUtils.i(str, "unregisterConnectListenerFromList:" + iConnectListener.hashCode());
        }
    }

    public static void mediaDeleteAllChatMsg(Context context, long j, int i, long j2, String str, long j3, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65606, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j, i, j2, str, j3, null, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatMsg(Context context, long j, int i, long j2, String str, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65608, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j, i, j2, str, -1L, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaFetchChatMsgs(Context context, long j, int i, long j2, String str, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65612, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.mediaFetchChatMsgs(context, j, i, j2, str, j3, j4, i2, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaGetChatSessions(Context context, long j, int i, long j2, String str, long j3, int i2, int i3, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65614, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iMediaGetChatSessionListener}) == null) {
            ChatMsgManager.mediaGetChatSessions(context, j, i, j2, str, j3, i2, i3, iMediaGetChatSessionListener);
        }
    }

    public static boolean registerNotify(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65637, null, str, str2, str3)) == null) {
            String str4 = BaseManager.TAG;
            LogUtils.d(str4, "channelId=" + str + ";userId=" + str2 + ";appId=" + str3);
            if (BaseManager.isNullContext(sContext)) {
                LogUtils.d(BaseManager.TAG, "Context is NULL!");
                return false;
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                return ChatMsgManagerImpl.getInstance(sContext).registerNotify(str, str2, str3, null);
            } else {
                LogUtils.d(BaseManager.TAG, Constants.ERROR_MSG_PARAMETER_ERROR);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void sendPaChatMsg(Context context, int i, int i2, long j, int i3, String str, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65644, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), str, iSendMessageListener}) == null) {
            String str2 = BaseManager.TAG;
            LogUtils.d(str2, "sendPaChatMsg patype = " + i + " subPatype = " + i2 + " paid = " + j + " msgtype = " + i3 + " content = " + str);
            ChatMsgManager.sendPaChatMsg(context, i, i2, j, i3, str, iSendMessageListener);
        }
    }

    @Deprecated
    public static boolean setMsgRead(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65649, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return ChatMsgManager.setMsgRead(context, 0, j, j2, false);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean setProductLine(Context context, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65652, null, context, i, str)) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.equals(AccountManagerImpl.getInstance(context).getAppVersion())) {
                    IMConstants.IS_UPDATE_VERSION = false;
                } else {
                    IMConstants.IS_UPDATE_VERSION = true;
                }
            }
            AccountManagerImpl.getInstance(context).setAppVersion(str);
            return IMManager.init(context, i);
        }
        return invokeLIL.booleanValue;
    }
}
