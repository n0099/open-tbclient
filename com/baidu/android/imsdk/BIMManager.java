package com.baidu.android.imsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.account.IGetTokenByCuidListener;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.AdvAdBtnShowInfo;
import com.baidu.android.imsdk.chatmessage.ChatAdvCustomMsg;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IAdvisoryAdBtnShowGetListener;
import com.baidu.android.imsdk.chatmessage.IAdvisoryAdBtnShowSaveListener;
import com.baidu.android.imsdk.chatmessage.IAdvisoryCustomMsgGetListener;
import com.baidu.android.imsdk.chatmessage.IAdvisoryCustomMsgSaveListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomExitListener;
import com.baidu.android.imsdk.chatmessage.IChatRoomFetchListener;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.IDelBusinessChatSessionListener;
import com.baidu.android.imsdk.chatmessage.IDelBusinessMsgListener;
import com.baidu.android.imsdk.chatmessage.IFetchMessageListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener;
import com.baidu.android.imsdk.chatmessage.IGetMediaMixedChatSessionListener;
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
import com.baidu.android.imsdk.chatmessage.IStatusNotifyListener;
import com.baidu.android.imsdk.chatmessage.MediaChatMessageManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.request.IMShareRequest;
import com.baidu.android.imsdk.chatmessage.request.params.DelMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
import com.baidu.android.imsdk.chatmessage.response.FetchMsgResponse;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.IGetUserListener;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.IUserPrivacyListener;
import com.baidu.android.imsdk.consult.db.BusinessMessageDBManager;
import com.baidu.android.imsdk.consult.listener.IBusinessSessionUnReadListener;
import com.baidu.android.imsdk.consult.listener.IChatMsgChangedListener;
import com.baidu.android.imsdk.consult.listener.ICustomizeNotifyListener;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.conversation.IConversationChangeListener;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMCmdQueueHelper;
import com.baidu.android.imsdk.internal.IMManagerImpl;
import com.baidu.android.imsdk.internal.IMSettings;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.mcast.IChatRoomMsgReceiveListener;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.McastManagerImpl;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.media.bean.GetSessionResult;
import com.baidu.android.imsdk.media.bean.SessionParam;
import com.baidu.android.imsdk.media.db.MediaMessageDBManager;
import com.baidu.android.imsdk.media.listener.BIMValuesCallBack;
import com.baidu.android.imsdk.media.listener.IChatSessionUpdateListener;
import com.baidu.android.imsdk.media.listener.ISessionUpdateManager;
import com.baidu.android.imsdk.media.update.ChatSessionUpdateManager;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.request.AckHandlerThread;
import com.baidu.android.imsdk.request.AckMessage;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.retrieve.RetrieveMsgReceiver;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.android.imsdk.shield.ISetForbidListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.ubc.ScreenUbc;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.upload.IUploadTransferMultipleParamListener;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.g70;
import com.baidu.tieba.p70;
import com.baidu.tieba.p80;
import com.baidu.tieba.r70;
import com.baidu.tieba.u60;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.codec.language.bm.Rule;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class BIMManager extends BaseManager implements NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Runnable checkIMLoginState;
    public static ConcurrentHashMap<Integer, Boolean> hasReturenTopSession;
    public static boolean hudongTop;
    public static IConnectListener mConnectListener;
    public static List<IConnectListener> mConnectListeners;
    public static Context sContext;
    public static List<SessionParam> sShieldSessionList;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isSupportMsgType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65642, null, i)) == null) ? i == 0 || i == 8 || i == 2 || i == 1 || i == 13 || i == 18 || i == 12 || i == 21 || i == 9 || i == 1002 || i == 1001 || i == 1003 || i == 1004 || i == 1005 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011 || i == 1012 || i == 1016 || i == 2001 || i == 80 || i == 31 || i == 32 || i == 33 || i == 20 || i == 22 || i == 25 || i == 26 || i == 24 || i == 2012 || i == 2014 || i == 28 || i == 27 || i == 29 || i == 30 || i == 35 || i == 36 || i == 38 || i == 1013 || i == 1014 || i == 39 || i == 40 || i == 41 || i == 51 || i == 42 || i == 43 || i == 44 || i == 45 || i == 46 || i == 47 || i == 52 || i == 53 || i == 2015 || i == 2016 || i == 2017 || i == 2019 || i == 2020 || i == 2022 || i == 2023 || i == 2024 || i == 2031 || i == 2025 || i == 2026 || i == 2027 || i == 2028 || i == 2029 || i == 1015 || i == 1017 || i == 1018 || i == 48 || i == 49 || i == 50 || i == 54 || i == 55 || i == 82 || i == 56 || i == 57 || i == 1019 || i == 1020 || i == 58 || i == 1021 || i == 1022 || i == 1023 || i == 1024 || i == 1025 || i == 1026 || i == 1027 || i == 1028 || i == 1029 || i == 5001 || i == 60 || i == 84 : invokeI.booleanValue;
    }

    public static void tryConnection(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65729, null, context) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class CATEGORY {
        public static final /* synthetic */ CATEGORY[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CATEGORY ALL;
        public static final CATEGORY CONSULT;
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
            ALL = new CATEGORY(Rule.ALL, 0, -1);
            SINGLEPERSON = new CATEGORY("SINGLEPERSON", 1, 0);
            GROUP = new CATEGORY("GROUP", 2, 1);
            SYSTEM = new CATEGORY("SYSTEM", 3, 2);
            PA = new CATEGORY("PA", 4, 0);
            ZHIDA = new CATEGORY("ZHIDA", 5, 0);
            STUDIO = new CATEGORY("STUDIO", 6, 4);
            CONSULT = new CATEGORY("CONSULT", 7, 9);
            CATEGORY category = new CATEGORY("UNKOWN", 8, -1);
            UNKOWN = category;
            $VALUES = new CATEGORY[]{ALL, SINGLEPERSON, GROUP, SYSTEM, PA, ZHIDA, STUDIO, CONSULT, category};
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
        sShieldSessionList = new ArrayList();
        hasReturenTopSession = new ConcurrentHashMap<>();
        hudongTop = false;
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
                    if (p70.b() == 0) {
                        if (LoginManager.getInstance(BIMManager.sContext).getCurrentState() != LoginManager.LoginState.LOGINED) {
                            LogUtils.e("BIMManager", "checkIMLoginState lcp connected, but im not login, triggle im relogin");
                            LoginManager.getInstance(BIMManager.sContext).triggleLogoutListener(1000, Constants.ERROR_LOGIN_STATE_ERROR);
                        } else if (LoginManager.getInstance(BIMManager.sContext).getCurrentState() == LoginManager.LoginState.LOGINED) {
                            TaskManager.getInstance(BIMManager.sContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.BIMManager.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 this$0;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        LogUtils.w(BaseManager.TAG, "checkIMLoginState begin getAckCmdQueueMsgs");
                                        List<NewAckMessage> ackCmdQueueMsgs = IMCmdQueueHelper.getAckCmdQueueMsgs(BIMManager.sContext);
                                        LogUtils.d(BaseManager.TAG, "checkIMLoginState, getAckCmdQueueMsgs end");
                                        if (ackCmdQueueMsgs != null && ackCmdQueueMsgs.size() > 0) {
                                            String str = BaseManager.TAG;
                                            LogUtils.d(str, "checkIMLoginState, ack.size :" + ackCmdQueueMsgs.size());
                                            for (NewAckMessage newAckMessage : ackCmdQueueMsgs) {
                                                if (newAckMessage.getJsonArray() != null && newAckMessage.getJsonArray().length() > 0) {
                                                    Message sendMessage = AckMessage.getSendMessage(1, newAckMessage);
                                                    String str2 = BaseManager.TAG;
                                                    LogUtils.w(str2, "checkIMLoginState, send ackMsg : " + newAckMessage.getUUID());
                                                    AckHandlerThread.getInstance(BIMManager.sContext).getAckHandler().sendMessageDelayed(sendMessage, 1000L);
                                                } else {
                                                    String str3 = BaseManager.TAG;
                                                    LogUtils.w(str3, "JsonArray null, and delete uuid :" + newAckMessage.getUUID());
                                                    DBManager.getInstance(BIMManager.sContext).deleteCmdMsg(newAckMessage.getUUID());
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            });
                        }
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

    public static String getProtocolType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65627, null)) == null) {
            return p70.getProtocolType();
        }
        return (String) invokeV.objValue;
    }

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65633, null)) == null) {
            return IMManagerImpl.getVersion();
        }
        return (String) invokeV.objValue;
    }

    public static void initLCP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65639, null) == null) {
            r70.g().l(sContext);
        }
    }

    public static void pingRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65674, null) == null) {
            p70.e();
        }
    }

    public static void postCheckRunnable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65675, null) == null) {
            try {
                LogUtils.i("BIMManager", "postCheckRunnable after 30s");
                g70.c.postDelayed(checkIMLoginState, 30000L);
            } catch (Exception e) {
                LogUtils.e(BaseManager.TAG, "postCheckRunnable exception ", e);
            }
        }
    }

    public static void unregisterConnectListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65735, null) == null) {
            mConnectListener = null;
        }
    }

    public static void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            LogUtils.d(BaseManager.TAG, "start clearCache");
            Utility.clearFileCache(context);
        }
    }

    public static boolean deleteConversation(BIMConversation bIMConversation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bIMConversation)) == null) {
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65567, null, z)) == null) {
            if (BaseManager.isNullContext(sContext)) {
                return false;
            }
            try {
                p80.a = z;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
            return ConversationStudioManImpl.getInstance(context).getAllCastIdList();
        }
        return (String) invokeL.objValue;
    }

    public static ArrayList<BIMConversation> getAllConversation(CATEGORY category) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, category)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, context)) == null) {
            return AccountManagerImpl.getInstance(context).getAppVersion();
        }
        return (String) invokeL.objValue;
    }

    public static String getBdUKFromBdUid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, str)) == null) {
            return Utility.transBDUID(str);
        }
        return (String) invokeL.objValue;
    }

    public static String getBdUidFromBdUK(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, str)) == null) {
            return Utility.transBDUK(str);
        }
        return (String) invokeL.objValue;
    }

    public static long getCacheSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, context)) == null) {
            long sumCacheSize = Utility.sumCacheSize(context);
            String str = BaseManager.TAG;
            LogUtils.d(str, "getCacheSize pluginCacheSize = " + sumCacheSize);
            return sumCacheSize;
        }
        return invokeL.longValue;
    }

    public static String getCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, null, context)) == null) {
            return Utility.getDeviceId(context);
        }
        return (String) invokeL.objValue;
    }

    public static long getJoinedCastId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, context)) == null) {
            return ConversationStudioManImpl.getInstance(context).getJoinedCastId();
        }
        return invokeL.longValue;
    }

    public static int getLoginType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65620, null, context)) == null) {
            return AccountManagerImpl.getInstance(context).getLoginType();
        }
        return invokeL.intValue;
    }

    public static int getNewMsgCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65624, null, context)) == null) {
            return ChatMsgManager.getNewMsgCount(context);
        }
        return invokeL.intValue;
    }

    public static int getTotalUnReadMsgCountByAdvisoryGFH(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65630, null, context)) == null) {
            if (ChatMsgManager.getTotalUnReadMsgCountByAdvisory(context, 0L) > 0) {
                return -1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void imLogoutByLcp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65635, null, context) == null) {
            try {
                g70.c(context);
                LoginManager.getInstance(context).onLogoutResultInternal(0, "lcp unconnected");
            } catch (Exception e) {
                LogUtils.e(BaseManager.TAG, "imLogoutByLcp exception ", e);
            }
        }
    }

    public static void imLogoutByLcpAsync(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65636, null, context) == null) {
            imLogoutByLcp(context);
        }
    }

    public static void initIMServiceImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65638, null, context) == null) {
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
                        g70.e(this.val$context);
                    }
                }
            });
        }
    }

    public static boolean isIMLogined(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65640, null, context)) == null) {
            return LoginManager.getInstance(context).isIMLogined();
        }
        return invokeL.booleanValue;
    }

    public static void registerConnectListener(IConnectListener iConnectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65679, null, iConnectListener) == null) {
            mConnectListener = iConnectListener;
            registerConnectListenerToList(iConnectListener);
        }
    }

    public static void registerConversationListener(IConversationChangeListener iConversationChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65682, null, iConversationChangeListener) != null) || BaseManager.isNullContext(sContext)) {
            return;
        }
        ConversationManagerImpl.getInstance(sContext).registerConversationListener(iConversationChangeListener);
    }

    public static void registerInternalListener(IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65684, null, iMessageReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(sContext).registerInternalMessageReceiveListener(iMessageReceiveListener);
        }
    }

    public static void setBIMContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65705, null, context) == null) {
            sContext = context;
        }
    }

    public static void setHuDongTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65712, null, z) == null) {
            hudongTop = z;
        }
    }

    public static void setShieldSessions(List<SessionParam> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65722, null, list) == null) {
            sShieldSessionList = list;
        }
    }

    public static void setTplSToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65723, null, str) == null) {
            AccountManagerImpl.getInstance(sContext).setTplSToken(str);
        }
    }

    public static void unregisterConversationListener(IConversationChangeListener iConversationChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65737, null, iConversationChangeListener) != null) || BaseManager.isNullContext(sContext)) {
            return;
        }
        ConversationManagerImpl.getInstance(sContext).unregisterConversationListener(iConversationChangeListener);
    }

    public static void sendAtMsgToChatRoom(Context context, long j, String str, @NonNull ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65695, null, new Object[]{context, Long.valueOf(j), str, chatMsg, iSendMessageListener}) == null) {
            ChatMsgManager.sendMsgToChatRoom(context, j, str, chatMsg, iSendMessageListener);
        }
    }

    public static void sendMsgToChatRoom(Context context, long j, String str, @NonNull ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65702, null, new Object[]{context, Long.valueOf(j), str, chatMsg, iSendMessageListener}) == null) {
            ChatMsgManager.sendMsgToChatRoom(context, j, str, chatMsg, iSendMessageListener);
        }
    }

    public static void asyncFetchMsgAndNotify(Context context, SessionParam sessionParam, BIMValuesCallBack<GetSessionResult, SessionParam> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, sessionParam, bIMValuesCallBack) == null) {
            if (BaseManager.isNullContext(context)) {
                if (bIMValuesCallBack != null) {
                    bIMValuesCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null, null);
                    return;
                }
                return;
            }
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context, bIMValuesCallBack, sessionParam) { // from class: com.baidu.android.imsdk.BIMManager.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ BIMValuesCallBack val$listener;
                public final /* synthetic */ SessionParam val$param;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, bIMValuesCallBack, sessionParam};
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
                    this.val$listener = bIMValuesCallBack;
                    this.val$param = sessionParam;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (AccountManager.getMediaRole(this.val$context)) {
                            BIMValuesCallBack bIMValuesCallBack2 = this.val$listener;
                            if (bIMValuesCallBack2 != null) {
                                bIMValuesCallBack2.onResult(0, Constants.ERROR_MSG_SUCCESS, new GetSessionResult(), null);
                                return;
                            }
                            return;
                        }
                        ChatSessionManagerImpl.getInstance(this.val$context).getUnReadChatSession(this.val$param, this.val$listener);
                    }
                }
            });
        }
    }

    public static int deleteAdvisoryDraft(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return ChatMsgManager.deleteAdvisoryDraft(context, i, j);
        }
        return invokeCommon.intValue;
    }

    public static void deleteSession(Context context, @NonNull SessionParam sessionParam, BIMValueCallBack<Object> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65566, null, context, sessionParam, bIMValueCallBack) == null) {
            if (BaseManager.isNullContext(context)) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                    return;
                }
                return;
            }
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context, sessionParam, bIMValueCallBack) { // from class: com.baidu.android.imsdk.BIMManager.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ BIMValueCallBack val$listener;
                public final /* synthetic */ SessionParam val$param;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, sessionParam, bIMValueCallBack};
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
                    this.val$param = sessionParam;
                    this.val$listener = bIMValueCallBack;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!AccountManager.getMediaRole(this.val$context) && this.val$param.businessType != 9) {
                            ChatSessionManagerImpl.getInstance(this.val$context).deleteSession(this.val$param, this.val$listener);
                        } else {
                            MediaSessionManager.getInstance(this.val$context).deleteSession(this.val$param, this.val$listener);
                        }
                    }
                }
            });
        }
    }

    public static void enterChatRoom(Context context, long j, IChatRoomEnterListener iChatRoomEnterListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, null, new Object[]{context, Long.valueOf(j), iChatRoomEnterListener}) == null) {
            McastManagerImpl.getInstance(context).enterChatRoom(context, j, iChatRoomEnterListener);
        }
    }

    public static void exitChatRoom(Context context, long j, IChatRoomExitListener iChatRoomExitListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{context, Long.valueOf(j), iChatRoomExitListener}) == null) {
            McastManagerImpl.getInstance(context).exitChatRoom(context, j, iChatRoomExitListener);
        }
    }

    public static void getBdUkFromImUK(Context context, long j, IGetUserListener iGetUserListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65591, null, new Object[]{context, Long.valueOf(j), iGetUserListener}) == null) {
            ChatUserManagerImpl.getInstance(context).getUser(j, 0, new IGetUserListener(iGetUserListener) { // from class: com.baidu.android.imsdk.BIMManager.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IGetUserListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iGetUserListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = iGetUserListener;
                }

                @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                public void onGetUserResult(int i, long j2, ChatUser chatUser) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j2), chatUser}) == null) {
                        if (chatUser != null) {
                            chatUser.setBdUk(Utility.transBDUID("" + chatUser.getBuid()));
                        }
                        this.val$listener.onGetUserResult(i, j2, chatUser);
                    }
                }
            });
        }
    }

    public static void getBusiAdvCustomMsgByMsgId(Context context, long j, IAdvisoryCustomMsgGetListener iAdvisoryCustomMsgGetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65592, null, new Object[]{context, Long.valueOf(j), iAdvisoryCustomMsgGetListener}) == null) {
            ChatMsgManager.getBusiAdvCustomMsgByMsgId(context, j, iAdvisoryCustomMsgGetListener);
        }
    }

    public static void getBusinessAdvAdShowInfoByUK(Context context, String str, IAdvisoryAdBtnShowGetListener iAdvisoryAdBtnShowGetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65593, null, context, str, iAdvisoryAdBtnShowGetListener) == null) {
            ChatMsgManager.getBusinessAdvAdShowInfoByUK(context, str, iAdvisoryAdBtnShowGetListener);
        }
    }

    public static void getChatSession(Context context, List<Integer> list, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65605, null, context, list, iGetSessionListener) == null) {
            IMBoxManager.getChatSession(context, list, iGetSessionListener);
        }
    }

    public static void getImUkFromBdUk(Context context, String str, IGetUserListener iGetUserListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65615, null, context, str, iGetUserListener) == null) {
            long parseLong = Long.parseLong(Utility.transBDUK(str));
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(parseLong));
            ChatUserManagerImpl.getInstance(context).updateUserIdentity(arrayList, new IGetUserIdentityListener(iGetUserListener, parseLong) { // from class: com.baidu.android.imsdk.BIMManager.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long val$bduid;
                public final /* synthetic */ IGetUserListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iGetUserListener, Long.valueOf(parseLong)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = iGetUserListener;
                    this.val$bduid = parseLong;
                }

                @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                public void onGetUserIdentityResult(int i, List<ChatUser> list) {
                    ChatUser chatUser;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, list) == null) {
                        IGetUserListener iGetUserListener2 = this.val$listener;
                        long j = this.val$bduid;
                        if (list.size() > 0) {
                            chatUser = list.get(0);
                        } else {
                            chatUser = null;
                        }
                        iGetUserListener2.onGetUserResult(i, j, chatUser);
                    }
                }
            });
        }
    }

    public static void getNewMsgCount(Context context, List<Integer> list, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65625, null, context, list, iGetNewMsgCountListener) == null) {
            IMBoxManager.getNewMsgCount(context, list, iGetNewMsgCountListener);
        }
    }

    public static void mediaGetContactorPauid(Context context, long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65663, null, new Object[]{context, Long.valueOf(j), iMediaGetContactorPauidListener}) == null) {
            ChatMsgManager.mediaGetContactorPauid(context, j, iMediaGetContactorPauidListener);
        }
    }

    public static void registerChatRoomMsgReceiveListener(Context context, long j, IChatRoomMsgReceiveListener iChatRoomMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65676, null, new Object[]{context, Long.valueOf(j), iChatRoomMsgReceiveListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).registerChatRoomMsgReceiveListener(j, iChatRoomMsgReceiveListener);
        }
    }

    public static void saveBusinessAdvAdShowInfo(Context context, AdvAdBtnShowInfo advAdBtnShowInfo, IAdvisoryAdBtnShowSaveListener iAdvisoryAdBtnShowSaveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65692, null, context, advAdBtnShowInfo, iAdvisoryAdBtnShowSaveListener) == null) {
            ChatMsgManager.saveBusinessAdvAdShowInfo(context, advAdBtnShowInfo, iAdvisoryAdBtnShowSaveListener);
        }
    }

    public static void saveBusinessAdvCustomMsg(Context context, ChatAdvCustomMsg chatAdvCustomMsg, IAdvisoryCustomMsgSaveListener iAdvisoryCustomMsgSaveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65693, null, context, chatAdvCustomMsg, iAdvisoryCustomMsgSaveListener) == null) {
            ChatMsgManager.saveBusinessAdvCustomMsg(context, chatAdvCustomMsg, iAdvisoryCustomMsgSaveListener);
        }
    }

    public static void sendChatMsgByHostRequest(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65698, null, context, chatMsg, iSendMessageListener) == null) {
            ChatMsgManager.sendChatMsgByHostRequest(context, chatMsg, iSendMessageListener);
        }
    }

    public static void sendMessage(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65699, null, context, chatMsg, iSendMessageListener) != null) || context == null) {
            return;
        }
        chatMsg.setSdkSendMsgTime(System.currentTimeMillis());
        ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
    }

    public static void setSessionRead(Context context, @NonNull SessionParam sessionParam, BIMValueCallBack<Object> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65719, null, context, sessionParam, bIMValueCallBack) == null) {
            if (BaseManager.isNullContext(context)) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                    return;
                }
                return;
            }
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context, sessionParam, bIMValueCallBack) { // from class: com.baidu.android.imsdk.BIMManager.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ BIMValueCallBack val$listener;
                public final /* synthetic */ SessionParam val$param;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, sessionParam, bIMValueCallBack};
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
                    this.val$param = sessionParam;
                    this.val$listener = bIMValueCallBack;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if ((AccountManager.getMediaRole(this.val$context) && this.val$param.classType <= 0) || this.val$param.businessType == 9) {
                            MediaSessionManager.getInstance(this.val$context).setSessionRead(this.val$param, this.val$listener);
                        } else {
                            ChatSessionManagerImpl.getInstance(this.val$context).setSessionRead(this.val$param, this.val$listener);
                        }
                    }
                }
            });
        }
    }

    public static void unregisterChatRoomMsgReceiveListener(Context context, long j, IChatRoomMsgReceiveListener iChatRoomMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65732, null, new Object[]{context, Long.valueOf(j), iChatRoomMsgReceiveListener}) == null) {
            ChatMsgManagerImpl.getInstance(context).unregisterChatRoomMsgReceiveListener(j, iChatRoomMsgReceiveListener);
        }
    }

    public static long updateLocalChatMsgByBusiness(Context context, int i, List<ChatMsg> list) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65742, null, context, i, list)) == null) {
            return ChatMsgManager.updateLocalChatMsgByBusiness(context, i, list);
        }
        return invokeLIL.longValue;
    }

    public static void asyncUploadImgToBos(Context context, String str, String str2, int i, int i2, int i3, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iUploadTransferListener}) == null) {
            ChatMsgManager.asyncUploadImgToBos(context, str, str2, i, i2, i3, iUploadTransferListener);
        }
    }

    public static void mediaContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65649, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaContactorSetting(context, j, i, j2, str, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65664, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaGetContactorSetting(context, j, i, j2, str, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaSendChatMsg(Context context, long j, int i, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65667, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManager.mediaSendChatMsg(context, j, i, j2, str, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j, int i, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65671, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaSetSessionReadListener}) == null) {
            ChatMsgManager.mediaSetSessionRead(context, j, i, j2, str, j3, iMediaSetSessionReadListener);
        }
    }

    public static void asyncUploadImgToBos(Context context, String str, String str2, int i, int i2, int i3, IUploadTransferMultipleParamListener iUploadTransferMultipleParamListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iUploadTransferMultipleParamListener}) == null) {
            ChatMsgManager.asyncUploadImgToBos(context, str, str2, i, i2, i3, iUploadTransferMultipleParamListener);
        }
    }

    public static void audioTrans(Context context, String str, String str2, String str3, int i, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), bIMValueCallBack}) == null) {
            ChatMsgManager.audioTrans(context, str, str2, str3, i, bIMValueCallBack);
        }
    }

    public static void handleConsultMsgNotify(Context context, int i, int i2, long j, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65634, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            ChatMsgManager.handleConsultMsgNotify(context, i, i2, j, i3, j2);
        }
    }

    public static void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65659, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.mediaFetchChatMsgs(context, j, j2, j3, i, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaGetContactorPauid(Context context, long j, int i, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65662, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, iMediaGetContactorPauidListener}) == null) {
            ChatMsgManager.mediaGetContactorPauid(context, j, i, j2, str, iMediaGetContactorPauidListener);
        }
    }

    public static void sendMsgToChatRoom(Context context, long j, String str, @NonNull ChatMsg chatMsg, @NonNull IChatRoomEnterListener.UserInfo userInfo, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65701, null, new Object[]{context, Long.valueOf(j), str, chatMsg, userInfo, iSendMessageListener}) == null) {
            ChatMsgManager.sendMsgToChatRoom(context, j, str, chatMsg, userInfo, iSendMessageListener);
        }
    }

    public static int setBusinessChatMsgContacterRead(Context context, int i, int i2, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65707, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            return ChatMsgManager.setBusinessChatMsgContacterRead(context, i, i2, j, j2, j3);
        }
        return invokeCommon.intValue;
    }

    public static void autoClearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            long sumCacheSize = Utility.sumCacheSize(context);
            String str = BaseManager.TAG;
            LogUtils.d(str, "autoClearCache pluginCacheSize = " + sumCacheSize);
            if (sumCacheSize >= 31457280) {
                LogUtils.d(BaseManager.TAG, "autoClearCache start clean cache");
                Utility.clearFileCache(context);
            }
        }
    }

    public static void logout(ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65647, null, iLoginListener) == null) {
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
                            Context context = BIMManager.sContext;
                            Utility.logout(context, null, BaseManager.TAG + " logout : " + i);
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
        if (interceptable == null || interceptable.invokeL(65680, null, iConnectListener) == null) {
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
        if ((interceptable != null && interceptable.invokeL(65736, null, iConnectListener) != null) || iConnectListener == null) {
            return;
        }
        synchronized (mConnectListeners) {
            mConnectListeners.remove(iConnectListener);
            String str = BaseManager.TAG;
            LogUtils.i(str, "unregisterConnectListenerFromList:" + iConnectListener.hashCode());
        }
    }

    public static void clearDb(Context context) {
        File[] listFiles;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, context) == null) {
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

    public static void connectStatusNotify(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, null, i) == null) {
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

    public static boolean deleteBusiChatSession(Context context, long j, int i, int i2, int i3, long j2, long j3, IDelBusinessChatSessionListener iDelBusinessChatSessionListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), iDelBusinessChatSessionListener})) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            return ChatSessionManagerImpl.getInstance(context).delBusinessChatSession(j, i, i2, i3, j2, j3, iDelBusinessChatSessionListener);
        }
        return invokeCommon.booleanValue;
    }

    public static void getFilterSessionsByBusiness(Context context, int i, long j, long j2, int i2, Map<String, Integer> map, List<Integer> list, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65614, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), map, list, iMediaGetChatSessionListener}) == null) {
            if (BaseManager.isNullContext(context)) {
                if (iMediaGetChatSessionListener != null) {
                    iMediaGetChatSessionListener.onMediaGetChatSessionResult(1005, 0, 0, false, null);
                    return;
                }
                return;
            }
            ChatSessionManagerImpl.getInstance(context).getFilterSessionsByBusiness(i, j, j2, i2, map, list, iMediaGetChatSessionListener);
        }
    }

    public static List<ChatSession> getLocalDbChatSessionsByBusiness(Context context, int i, int i2, long j, long j2, long j3, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65617, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            return ChatSessionManagerImpl.getInstance(context).getBusiChatSessionsFromDb(i, i2, j, j2, j3, i3, i4);
        }
        return (List) invokeCommon.objValue;
    }

    public static int deleteBusiMsgs(Context context, long j, int i, int i2, int i3, long j2, IDelBusinessMsgListener iDelBusinessMsgListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), iDelBusinessMsgListener})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).sendDelMsgs(i, i2, i3, j, new long[]{j2}, iDelBusinessMsgListener);
        }
        return invokeCommon.intValue;
    }

    public static void getChatMsgByBusiness(Context context, int i, int i2, int i3, long j, long j2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65596, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.getChatMsgsByBusiness(context, i, i2, i3, j, j2, j2, 1, -1L, -1L, "", "Na", iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaDeleteAllChatMsg(Context context, long j, int i, long j2, String str, long j3, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65651, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j, i, j2, str, j3, null, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatMsg(Context context, long j, int i, long j2, String str, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65653, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j, i, j2, str, -1L, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j, int i, long j2, String str, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65656, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), iMediaDeleteChatSessionListener}) == null) {
            ChatMsgManager.mediaDeleteChatSession(context, j, i, j2, str, j3, 0, iMediaDeleteChatSessionListener);
        }
    }

    public static void setChatSessionReadByBusiness(Context context, int i, int i2, int i3, long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65709, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), iMediaSetSessionReadListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).setChatSessionReadByBusiness(i, i2, i3, j, j2, 0L, iMediaSetSessionReadListener);
        }
    }

    public static int deleteBusiMsgs(Context context, long j, int i, int i2, int i3, long[] jArr, IDelBusinessMsgListener iDelBusinessMsgListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jArr, iDelBusinessMsgListener})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).sendDelMsgs(i, i2, i3, j, jArr, iDelBusinessMsgListener);
        }
        return invokeCommon.intValue;
    }

    public static int deleteDbBusiChatSession(Context context, long j, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return ChatSessionManagerImpl.getInstance(context).delDbBusiChatSession(i3, i2, i, j);
        }
        return invokeCommon.intValue;
    }

    public static void getLocalDbNewUnReadCount(Context context, long j, long j2, int i, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65618, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), iGetSessionListener}) == null) {
            List<ChatSession> businessChatSessions = BusinessMessageDBManager.getInstance(context).getBusinessChatSessions(i, 2, j, j2, true);
            if (iGetSessionListener != null) {
                iGetSessionListener.onGetSessionResult(businessChatSessions);
            }
            if (businessChatSessions == null || businessChatSessions.isEmpty()) {
                BusinessMessageDBManager.getInstance(context).registerSessionChangeListener(new IBusinessSessionUnReadListener(context, j, j2, iGetSessionListener) { // from class: com.baidu.android.imsdk.BIMManager.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ long val$currentTime;
                    public final /* synthetic */ IGetSessionListener val$getSessionListener;
                    public final /* synthetic */ long val$interval;

                    @Override // com.baidu.android.imsdk.consult.listener.IBusiSessionChangeListener
                    public void notifyBusiSessionChange(int i2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), iGetSessionListener};
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
                        this.val$interval = j;
                        this.val$currentTime = j2;
                        this.val$getSessionListener = iGetSessionListener;
                    }

                    @Override // com.baidu.android.imsdk.consult.listener.IBusinessSessionUnReadListener
                    public void notifyBusinessSessionUnread(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                            List<ChatSession> businessChatSessions2 = BusinessMessageDBManager.getInstance(this.val$context).getBusinessChatSessions(i2, 2, this.val$interval, this.val$currentTime, true);
                            if (this.val$getSessionListener != null && businessChatSessions2 != null && !businessChatSessions2.isEmpty()) {
                                this.val$getSessionListener.onGetSessionResult(businessChatSessions2);
                            }
                        }
                    }
                });
            }
        }
    }

    public static void getPaNewMsgCount(Context context, int i, int i2, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65626, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), iGetNewMsgCountListener}) == null) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "getPaNewMsgCount patype = " + i + " subPatype = " + i2 + " paid = " + j);
            ChatMsgManager.getPaNewMsgCount(context, i, i2, j, iGetNewMsgCountListener);
        }
    }

    public static int deleteDbBusiMsgsByMsgId(Context context, long j, int i, int i2, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteDBBusiMsgsByMsgId(i, j, i2, i3, new long[]{j2});
        }
        return invokeCommon.intValue;
    }

    public static void setSessionCollectStatusByBusiness(Context context, int i, long j, int i2, int i3, BIMValueCallBack<Void> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65718, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), bIMValueCallBack}) == null) {
            if (BaseManager.isNullContext(context)) {
                if (bIMValueCallBack != null) {
                    bIMValueCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
                    return;
                }
                return;
            }
            ChatSessionManagerImpl.getInstance(context).setSessionCollectStatusByBusiness(i, j, i2, i3, bIMValueCallBack);
        }
    }

    public static int deleteDraftMsg(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return 0;
            }
            if (AccountManager.getMediaRole(context)) {
                return MediaChatMessageManager.getInstance(context).delDraftMsg(i, j);
            }
            return ChatMsgManager.deleteDraftMsg(context, i, j);
        }
        return invokeCommon.intValue;
    }

    public static void login(String str, String str2, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65645, null, str, str2, iLoginListener) == null) {
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                    return;
                }
                return;
            }
            AccountManagerImpl.getInstance(sContext).setXDClientId(str2);
            login("", str, 11, "", "", iLoginListener);
        }
    }

    @Deprecated
    public static boolean setMsgRead(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65714, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return ChatMsgManager.setMsgRead(context, 0, j, j2, false);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean setProductLine(Context context, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65717, null, context, i, str)) == null) {
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

    public static int deleteMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, context, chatMsg)) == null) {
            return ChatMsgManager.deleteMsg(context, chatMsg);
        }
        return invokeLL.intValue;
    }

    @Deprecated
    public static long deleteMsgs(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65565, null, context, j)) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(0, j, false, 1);
        }
        return invokeLJ.longValue;
    }

    public static void fetchBusinessOfficialPASessionCompletion(Context context, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65570, null, context, iMediaGetChatSessionListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).getSessionByGfhPA(iMediaGetChatSessionListener, 27);
    }

    @Deprecated
    public static List<ChatSession> getChatSession(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65604, null, context, list)) == null) {
            return ChatMsgManager.getChatRecords(context, list);
        }
        return (List) invokeLL.objValue;
    }

    public static ChatUser getChatUserSync(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65607, null, context, j)) == null) {
            return ChatUserManager.getChatUserSync(context, j);
        }
        return (ChatUser) invokeLJ.objValue;
    }

    public static int getLocalDbUnReadCountByBusiness(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65619, null, context, i)) == null) {
            return ChatSessionManagerImpl.getInstance(context).getBusiSessionTotalUnread(i);
        }
        return invokeLI.intValue;
    }

    public static long getMaxReliableMsgId(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65622, null, context, j)) == null) {
            return ConversationStudioManImpl.getInstance(context).getMaxReliableMsgId(j);
        }
        return invokeLJ.longValue;
    }

    public static long getReliableMsgCount(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65628, null, context, j)) == null) {
            return ConversationStudioManImpl.getInstance(context).getReliableMsgCount(j);
        }
        return invokeLJ.longValue;
    }

    public static int getTotalPAAndConsultUnReadCountByBusiness(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65629, null, context, i)) == null) {
            return ChatSessionManagerImpl.getInstance(context).getBusiSessionTotalUnread(i) + ChatMsgManager.getTotalUnReadMsgCountByAdvisory(context, 0L);
        }
        return invokeLI.intValue;
    }

    public static int getUnReadMsgCountByPaid(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65631, null, context, j)) == null) {
            return ChatMsgManager.getUnReadMsgCountByPaid(context, j, 0L);
        }
        return invokeLJ.intValue;
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65648, null, context, chatMsg)) == null) {
            return ChatMsgManager.markMsgClicked(context, chatMsg);
        }
        return invokeLL.intValue;
    }

    public static void mediaRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65666, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManager.mediaRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
        }
    }

    public static void mediaSetAllSessionRead(Context context, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65669, null, context, iMediaSetSessionReadListener) == null) {
            ChatMsgManager.setMediaAllSessionRead(context, iMediaSetSessionReadListener);
        }
    }

    public static void mediaSetRole(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65670, null, context, z) == null) {
            AccountManager.setMediaRole(context, z);
        }
    }

    public static void mediaUnRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65673, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManager.mediaUnRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
        }
    }

    @Deprecated
    public static void registerChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65677, null, context, iChatSessionChangeListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionUpdateManager.getInstance(context).registerRecordChangeListener(iChatSessionChangeListener);
    }

    @Deprecated
    public static void registerChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65678, null, context, iChatSessionChangeListener) == null) {
            registerChatSessionChangeListener(context, iChatSessionChangeListener);
        }
    }

    public static void registerConsultMsgNotifyListener(Context context, IChatMsgChangedListener iChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65681, null, context, iChatMsgChangedListener) == null) {
            ChatMsgManager.registerConsultMsgNotifyListener(context, iChatMsgChangedListener);
        }
    }

    public static void registerCustomNotifyListener(Context context, ICustomizeNotifyListener iCustomizeNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65683, null, context, iCustomizeNotifyListener) == null) {
            ChatMsgManager.registerCustomNotifyListener(context, iCustomizeNotifyListener);
        }
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65685, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.registerMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static void registerSessionUpdateListener(Context context, IChatSessionUpdateListener iChatSessionUpdateListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65687, null, context, iChatSessionUpdateListener) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionUpdateManager.getInstance(context).registerRecordChangeListener(iChatSessionUpdateListener);
    }

    public static void registerStudioUsePaReceiveMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65688, null, context, iLiveMsgReceiveListener) == null) {
            if (context == null && iLiveMsgReceiveListener != null) {
                iLiveMsgReceiveListener.onReceiveMessage(-1, null);
            }
            ChatMsgManager.registerStudioUsePaReceivePaMsg(context, iLiveMsgReceiveListener);
        }
    }

    public static void removeSessionByClasstype(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65689, null, context, i) == null) {
            IMBoxManager.removeSessionByClasstype(context, i);
        }
    }

    public static int saveAdvisoryDraftMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65690, null, context, chatMsg)) == null) {
            return ChatMsgManager.saveAdvisoryDraftMsg(context, chatMsg);
        }
        return invokeLL.intValue;
    }

    public static int saveAsDraftMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65691, null, context, chatMsg)) == null) {
            if (BaseManager.isNullContext(context)) {
                return 0;
            }
            if (AccountManager.getMediaRole(context)) {
                return MediaChatMessageManager.getInstance(context).saveDraftMsg(chatMsg);
            }
            return ChatMsgManager.saveAsDraftMsg(context, chatMsg);
        }
        return invokeLL.intValue;
    }

    public static void saveMessage(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65694, null, context, chatMsg) == null) {
            if (AccountManager.getMediaRole(context)) {
                MediaChatMessageManager.getInstance(context).saveChatMsg(chatMsg);
            } else {
                ChatMsgManager.saveMessage(context, chatMsg);
            }
        }
    }

    public static void setSessionUpdataManager(Context context, ISessionUpdateManager iSessionUpdateManager) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65721, null, context, iSessionUpdateManager) != null) || context == null) {
            return;
        }
        ChatSessionUpdateManager.getInstance(context).setSessionUpdateManager(iSessionUpdateManager);
    }

    public static void setUpdateSwitch(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65724, null, context, i) == null) {
            AccountManager.setUpdateSwitch(context, i);
        }
    }

    public static void unRegisterConsultMsgNotifyListener(Context context, IChatMsgChangedListener iChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65730, null, context, iChatMsgChangedListener) == null) {
            ChatMsgManager.unRegisterConsultMsgNotifyListener(context, iChatMsgChangedListener);
        }
    }

    public static void unRegisterCustomNotifyListener(Context context, ICustomizeNotifyListener iCustomizeNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65731, null, context, iCustomizeNotifyListener) == null) {
            ChatMsgManager.unRegisterCustomNotifyListener(context, iCustomizeNotifyListener);
        }
    }

    @Deprecated
    public static void unregisterChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65733, null, context, iChatSessionChangeListener) == null) {
            ChatSessionUpdateManager.getInstance(context).unregisterRecordChangeListener(iChatSessionChangeListener);
        }
    }

    @Deprecated
    public static void unregisterChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65734, null, context, iChatSessionChangeListener) == null) {
            unregisterChatSessionChangeListener(context, iChatSessionChangeListener);
        }
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65738, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.unregisterMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static void unregisterSessionUpdateListener(Context context, IChatSessionUpdateListener iChatSessionUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65739, null, context, iChatSessionUpdateListener) == null) {
            ChatSessionUpdateManager.getInstance(context).unregisterRecordChangeListener(iChatSessionUpdateListener);
        }
    }

    public static void unregisterStudioUsePaReceiveMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65740, null, context, iLiveMsgReceiveListener) == null) {
            if (context == null && iLiveMsgReceiveListener != null) {
                iLiveMsgReceiveListener.onReceiveMessage(-1, null);
            }
            ChatMsgManager.unregisterStudioUsePaReceivePaMsg(context, iLiveMsgReceiveListener);
        }
    }

    public static int deleteMsg(Context context, DelMsgParam delMsgParam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, delMsgParam)) == null) {
            if (context != null && delMsgParam != null) {
                if (AccountManager.getMediaRole(context)) {
                    return MediaChatMessageManager.getInstance(context).deleteMsg(context, delMsgParam);
                }
                return ChatMsgManager.deleteMsg(context, delMsgParam.delMsg);
            } else if (delMsgParam != null) {
                delMsgParam.onRequestResult(1005, "param invalid", null);
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public static BIMConversation getConversation(String str, CATEGORY category) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65610, null, str, category)) == null) {
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

    public static boolean isShieldSession(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65641, null, i, i2)) == null) {
            if (sShieldSessionList.size() == 0) {
                return false;
            }
            for (SessionParam sessionParam : sShieldSessionList) {
                if (sessionParam != null && sessionParam.category == i && sessionParam.businessType == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static int deleteMsgs(Context context, long j, long[] jArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{context, Long.valueOf(j), jArr, Boolean.valueOf(z)})) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) {
            return ChatMsgManager.fetchMessageSync(context, 0, j, j2, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static String getAdvisoryDraftStr(Context context, int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65585, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            return ChatMsgManager.getAdvisoryDraftStr(context, i, j, i2);
        }
        return (String) invokeCommon.objValue;
    }

    public static void getChatRoomLastMsg(Context context, List<Long> list, long j, IChatRoomFetchListener iChatRoomFetchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65603, null, new Object[]{context, list, Long.valueOf(j), iChatRoomFetchListener}) == null) {
            McastManagerImpl.getInstance(context).getChatRoomLastMsg(context, list, j, iChatRoomFetchListener);
        }
    }

    public static void mediaDeleteAllChatMsg(Context context, long j, long j2, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65652, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j, j2, null, iMediaDeleteChatMsgListener);
        }
    }

    public static boolean setAllMsgRead(Context context, int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65704, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            return ChatMsgManager.setAllMsgRead(context, i, j, z);
        }
        return invokeCommon.booleanValue;
    }

    public static void setGroupMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65711, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j, 3, i, iStatusListener);
        }
    }

    public static void setMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65713, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j, 1, i, iStatusListener);
        }
    }

    public static boolean setMsgRead(Context context, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65715, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            return ChatMsgManager.setMsgRead(context, 0, j, j2, z);
        }
        return invokeCommon.booleanValue;
    }

    public static int setSessionSubscribeStatusByBusiness(Context context, int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65720, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return 0;
            }
            return ChatSessionManagerImpl.getInstance(context).setSessionSubscribeStatusByBusiness(i, j, i2);
        }
        return invokeCommon.intValue;
    }

    public static void setUserMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65726, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j, 0, i, iStatusListener);
        }
    }

    public static long deleteMsgs(Context context, int i, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i, j, z, 1);
        }
        return invokeCommon.longValue;
    }

    public static void fetchChatRoomMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            ChatMsgManager.fetchMsgRequest(context, j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener, false, true, i3);
        }
    }

    public static void fetchMsgByHostRequest(Context context, long j, int i, long j2, long j3, long j4, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65576, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManager.fetchMsgByHostRequst(context, j, i, j2, j3, j4, i2, iFetchMsgByIdListener);
        }
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65580, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            fetchMsgRequest(context, j, j2, i, j3, j4, j5, i2, i3, iFetchMsgByIdListener, false);
        }
    }

    public static void updateBusiSessionAndGet(Context context, int i, int i2, long j, long j2, long j3, int i3, int i4, int i5, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65741, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iMediaGetChatSessionListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).updateBusiSessionAndGet(i, i2, j, j2, j3, i3, i4, i5, iMediaGetChatSessionListener);
        }
    }

    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), chatMsg})) == null) {
            return ChatMsgManager.fetchMessageSyncWithState(context, i, j, i2, chatMsg);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static BIMConversation getConversation(Context context, String str, CATEGORY category, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65608, null, new Object[]{context, str, category, str2, Integer.valueOf(i)})) == null) {
            return getConversation(context, str, false, category, str2, i);
        }
        return (BIMConversation) invokeCommon.objValue;
    }

    public static void getCuidTokenAndLogin(String str, int i, String str2, String str3, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65612, null, new Object[]{str, Integer.valueOf(i), str2, str3, iLoginListener}) == null) {
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
                                }
                                BIMManager.getCuidTokenAndLogin(this.val$accessToken, this.val$loginType, this.val$from, this.val$cfrom, this.val$listener);
                                return;
                            }
                            this.val$listener.onLoginResult(1005, "gen token is NULL");
                        } else if (i2 == 70) {
                            this.val$listener.onLoginResult(i2, str4);
                        } else {
                            AccountManagerImpl.getInstance(BIMManager.sContext);
                            AccountManagerImpl.mCuidTokenTryTimes++;
                            LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, responseCode = " + i2 + ", errMsg = " + str4);
                            AccountManagerImpl.getInstance(BIMManager.sContext);
                            if (AccountManagerImpl.mCuidTokenTryTimes <= 3) {
                                try {
                                    Thread.sleep(200L);
                                } catch (Exception e2) {
                                    LogUtils.e(BaseManager.TAG, "Exception ", e2);
                                }
                                BIMManager.getCuidTokenAndLogin(this.val$accessToken, this.val$loginType, this.val$from, this.val$cfrom, this.val$listener);
                                return;
                            }
                            this.val$listener.onLoginResult(i2, str4);
                        }
                    }
                }
            });
        }
    }

    public static void mediaGetChatSessions(Context context, long j, long j2, int i, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65661, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), iMediaGetChatSessionListener}) == null) {
            ChatMsgManager.mediaGetChatSessions(context, j, j2, i, iMediaGetChatSessionListener);
        }
    }

    public static void setForbid(Context context, long j, long j2, int i, ISetForbidListener iSetForbidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65710, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), iSetForbidListener}) == null) {
            ShieldAndTopManager.getInstance(context).setForbid(j, j2, i, iSetForbidListener);
        }
    }

    public static void fetchMsg(Context context, FetchMsgParam fetchMsgParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65574, null, context, fetchMsgParam) == null) {
            TextMsg textMsg = null;
            if (context != null && fetchMsgParam != null) {
                ScreenUbc.MethodInfo methodInfo = new ScreenUbc.MethodInfo();
                if (!TextUtils.isEmpty(fetchMsgParam.getScreenKey())) {
                    methodInfo.startTime = System.currentTimeMillis();
                    methodInfo.method = "fetchMsg";
                    methodInfo.eventList = new JSONArray();
                    Utility.setScreenMethodInfo(fetchMsgParam.getScreenKey(), methodInfo);
                }
                if (AccountManager.getMediaRole(context) && !shouldFetchMsgFromCUser(context, fetchMsgParam.getCategory(), fetchMsgParam.getContacterPa())) {
                    Utility.addEventList(methodInfo.eventList, "fetchMsg");
                    MediaChatMessageManager.getInstance(context).fetchMsg(fetchMsgParam);
                    return;
                }
                if (fetchMsgParam.getBeginMsgId() != 0) {
                    textMsg = new TextMsg();
                    textMsg.setMsgId(fetchMsgParam.getBeginMsgId());
                } else if (fetchMsgParam.getEndMsgId() != Long.MAX_VALUE) {
                    textMsg = new TextMsg();
                    textMsg.setMsgId(fetchMsgParam.getEndMsgId());
                }
                Utility.addEventList(methodInfo.eventList, "fetchMessageSyncWithState");
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState = fetchMessageSyncWithState(context, fetchMsgParam.getCategory(), fetchMsgParam.getTo(), fetchMsgParam.getCount(), textMsg);
                FetchMsgResponse fetchMsgResponse = new FetchMsgResponse();
                ArrayList arrayList = (ArrayList) fetchMessageSyncWithState.second;
                if (arrayList != null && fetchMsgParam.getCount() > 0 && arrayList.size() > fetchMsgParam.getCount()) {
                    fetchMsgResponse.msgs = new ArrayList(arrayList.subList(0, fetchMsgParam.getCount()));
                    fetchMsgResponse.hasMore = true;
                    Utility.addEventList(methodInfo.eventList, "has_more");
                } else {
                    fetchMsgResponse.hasMore = false;
                    fetchMsgResponse.msgs = arrayList;
                    Utility.addEventList(methodInfo.eventList, "! has_more");
                }
                fetchMsgParam.getRequestCallBack().onResult(0, "fetch msg succeed", fetchMsgResponse);
                methodInfo.errCode = 0;
                methodInfo.errMsg = "fetch msg succeed";
                methodInfo.endTime = System.currentTimeMillis();
                ScreenUbc.onEvent(context, fetchMsgParam.getScreenKey(), methodInfo);
            } else if (fetchMsgParam != null) {
                fetchMsgParam.onRequestResult(1005, "param invalid", null);
            }
        }
    }

    public static void fetchMsgByHostRequest(Context context, long j, int i, long j2, long j3, long j4, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            fetchMsgByHostRequest(context, j, i, j2, j3, j4, i2, i3, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchMsgByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65579, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManager.fetchMsgRequst(context, Utility.getAppId(context), Utility.getUK(context), i, j, j2, j3, i2, iFetchMsgByIdListener, z, false);
        }
    }

    public static void getChatMsgsByBusiness(Context context, int i, int i2, int i3, long j, long j2, long j3, int i4, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65599, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.getChatMsgsByBusiness(context, i, i2, i3, j, j2, j3, i4, -1L, -1L, "", "Na", iMediaFetchChatMsgsListener);
        }
    }

    public static void getChatMsgsByBusinessByHostRequest(Context context, int i, int i2, int i3, long j, long j2, long j3, int i4, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65602, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.getChatMsgsByBusinessByHostRequest(context, i, i2, i3, j, j2, j3, i4, "Na", iMediaFetchChatMsgsListener);
        }
    }

    public static void getChatSessionsByBusiness(Context context, int i, int i2, long j, long j2, long j3, int i3, int i4, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65606, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), iMediaGetChatSessionListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).getChatSessionsByBusiness(i, i2, j, j2, j3, i3, 3, i4, iMediaGetChatSessionListener);
        }
    }

    public static void getMediaMixedChatSessions(Context context, long j, int i, long j2, String str, long j3, int i2, int i3, IGetMediaMixedChatSessionListener iGetMediaMixedChatSessionListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65623, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iGetMediaMixedChatSessionListener}) != null) || BaseManager.isNullContext(context)) {
            return;
        }
        ChatSessionManagerImpl.getInstance(context).getMediaMixedChatSessions(j, i, j2, str, j3, i2, i3, iGetMediaMixedChatSessionListener);
    }

    public static ChatMsg fetchMsgByMsgIdFromLocal(Context context, int i, long j, long j2) {
        InterceptResult invokeCommon;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (AccountManager.getMediaRole(context) && !shouldFetchMsgFromCUser(context, i, j)) {
                return MediaMessageDBManager.getInstance(context).getMsg(i, j, j2);
            }
            TextMsg textMsg = new TextMsg();
            textMsg.setMsgId(j2);
            Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState = ChatMsgManager.fetchMessageSyncWithState(context, i, j, 0, textMsg);
            if (fetchMessageSyncWithState != null && (obj = fetchMessageSyncWithState.second) != null && ((ArrayList) obj).size() > 0) {
                return (ChatMsg) ((ArrayList) fetchMessageSyncWithState.second).get(0);
            }
            return null;
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public static void fetchMsgByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65578, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener}) == null) {
            fetchMsgByMsgid(context, i, j, j2, j3, i2, i3, iFetchMsgByIdListener, false);
        }
    }

    public static void getBusinessSessionFromServer(Context context, int i, int i2, long j, long j2, long j3, int i3, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65594, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), iMediaGetChatSessionListener}) == null) {
            ChatMsgManager.getBusinessSessionFromServer(context, i, i2, j, j2, j3, i3, iMediaGetChatSessionListener);
        }
    }

    public static void getChatMsgByBusinessAddSource(Context context, int i, int i2, int i3, long j, long j2, String str, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65597, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), str, iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.getChatMsgsByBusiness(context, i, i2, i3, j, j2, j2, 1, -1L, -1L, "", str, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j, int i, long j2, String str, long j3, int i2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65655, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), iMediaDeleteChatSessionListener}) == null) {
            ChatMsgManager.mediaDeleteChatSession(context, j, i, j2, str, j3, i2, iMediaDeleteChatSessionListener);
        }
    }

    public static void sendBusinessImNotifyMsg(Context context, int i, long j, int i2, int i3, int i4, String str, IStatusNotifyListener iStatusNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65696, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, iStatusNotifyListener}) == null) {
            ChatMsgManager.sendBusinessImNotifyMsg(context, i, j, i2, i3, i4, str, iStatusNotifyListener);
        }
    }

    public static void setChatSessionReadByBusiness(Context context, int i, int i2, int i3, long j, long j2, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65708, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), iMediaSetSessionReadListener}) == null) {
            ChatSessionManagerImpl.getInstance(context).setChatSessionReadByBusiness(i, i2, i3, j, j3, j2, iMediaSetSessionReadListener);
        }
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65581, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), Integer.valueOf(i3), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManager.fetchMsgRequst(context, j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener, z, true);
        }
    }

    public static void fetchPaChatMsgs(Context context, int i, int i2, long j, long j2, long j3, int i3, IFetchMessageListener iFetchMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65582, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), iFetchMessageListener}) == null) {
            long j4 = j2;
            String str = BaseManager.TAG;
            LogUtils.d(str, "fetchPaChatMsgs patype = " + i + " subPatype = " + i2 + " paid = " + j + " msgid = " + j4 + " time = " + j3 + " count = " + i3);
            if (j4 == 0) {
                j4 = Long.MAX_VALUE;
            }
            FetchMsgParam.newInstanceByPa(context, 0L, j4, i3, 0, j, "", new BIMValueCallBack<FetchMsgResponse>(iFetchMessageListener) { // from class: com.baidu.android.imsdk.BIMManager.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IFetchMessageListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {iFetchMessageListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = iFetchMessageListener;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                public void onResult(int i4, String str2, FetchMsgResponse fetchMsgResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i4, str2, fetchMsgResponse) == null) {
                        if (fetchMsgResponse != null) {
                            this.val$listener.onFetchMessageResult(i4, (ArrayList) fetchMsgResponse.msgs);
                        } else {
                            this.val$listener.onFetchMessageResult(i4, null);
                        }
                    }
                }
            }, new FetchMsgParam.FetchMsgParamConstruct(context) { // from class: com.baidu.android.imsdk.BIMManager.8
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
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam.FetchMsgParamConstruct
                public void construct(FetchMsgParam fetchMsgParam) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, fetchMsgParam) == null) {
                        BIMManager.fetchMsg(this.val$context, fetchMsgParam);
                    }
                }
            });
        }
    }

    public static void fetchSessionList(Context context, SessionParam sessionParam, BIMValuesCallBack<GetSessionResult, SessionParam> bIMValuesCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65583, null, context, sessionParam, bIMValuesCallBack) == null) {
            if (BaseManager.isNullContext(context)) {
                if (bIMValuesCallBack != null) {
                    bIMValuesCallBack.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null, null);
                    return;
                }
                return;
            }
            ScreenUbc.MethodInfo methodInfo = new ScreenUbc.MethodInfo();
            if (!TextUtils.isEmpty(sessionParam.screenKey)) {
                methodInfo.startTime = System.currentTimeMillis();
                methodInfo.method = "fetchSessionList";
                methodInfo.eventList = new JSONArray();
                Utility.setScreenMethodInfo(sessionParam.screenKey, methodInfo);
            }
            TaskManager.getInstance(context).submitForNetWork(new Runnable(methodInfo, context, sessionParam, bIMValuesCallBack) { // from class: com.baidu.android.imsdk.BIMManager.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ ScreenUbc.MethodInfo val$info;
                public final /* synthetic */ BIMValuesCallBack val$listener;
                public final /* synthetic */ SessionParam val$param;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {methodInfo, context, sessionParam, bIMValuesCallBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$info = methodInfo;
                    this.val$context = context;
                    this.val$param = sessionParam;
                    this.val$listener = bIMValuesCallBack;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Utility.addEventList(this.val$info.eventList, "submitForNetWork_fetch");
                        if (AccountManager.getMediaRole(this.val$context) && this.val$param.classType <= 0) {
                            MediaSessionManager.getInstance(this.val$context).getChatSession(this.val$param, this.val$listener, this.val$info);
                        } else {
                            ChatSessionManagerImpl.getInstance(this.val$context).getChatSession(this.val$param, this.val$listener, this.val$info);
                        }
                    }
                }
            });
        }
    }

    public static ChatMsg getDraftMsg(Context context, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65613, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return null;
            }
            if (AccountManager.getMediaRole(context)) {
                return MediaChatMessageManager.getInstance(context).getDraftMsg(i, j);
            }
            return ChatMsgManager.getDraftMsg(context, i, j);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    public static void genBosObjectUrl(Context context, String str, String str2, String str3, int i, int i2, int i3, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65584, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iGenBosObjectUrlListener}) == null) {
            ChatMsgManager.genBosObjectUrl(context, str, str2, str3, i, i2, i3, iGenBosObjectUrlListener);
        }
    }

    public static void getChatMsgsByBusiness(Context context, int i, int i2, int i3, long j, long j2, long j3, int i4, long j4, long j5, String str, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65598, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Long.valueOf(j5), str, iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.getChatMsgsByBusiness(context, i, i2, i3, j, j2, j3, i4, j4, j5, str, "Na", iMediaFetchChatMsgsListener);
        }
    }

    public static void getChatMsgsByBusinessAddSource(Context context, int i, int i2, int i3, long j, long j2, long j3, int i4, long j4, long j5, String str, String str2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65600, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Long.valueOf(j5), str, str2, iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.getChatMsgsByBusiness(context, i, i2, i3, j, j2, j3, i4, j4, j5, str, str2, iMediaFetchChatMsgsListener);
        }
    }

    public static void getChatMsgsByBusinessByHostAddSource(Context context, int i, int i2, int i3, long j, long j2, long j3, int i4, String str, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65601, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), str, iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.getChatMsgsByBusinessByHostRequest(context, i, i2, i3, j, j2, j3, i4, str, iMediaFetchChatMsgsListener);
        }
    }

    public static BIMConversation getConversation(Context context, String str, boolean z, CATEGORY category, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65609, null, new Object[]{context, str, Boolean.valueOf(z), category, str2, Integer.valueOf(i)})) == null) {
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

    public static void login(String str, String str2, int i, String str3, String str4, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65643, null, new Object[]{str, str2, Integer.valueOf(i), str3, str4, iLoginListener}) == null) {
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                    return;
                }
                return;
            }
            initLCP();
            if (TextUtils.isEmpty(str2)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "accessToken is NULL");
                }
            } else if (i == 6) {
                AccountManagerImpl.getInstance(sContext).setCuid(str2);
                String token = AccountManagerImpl.getInstance(sContext).getToken();
                if (!TextUtils.isEmpty(token)) {
                    loginExecutor(i, str, token, str3, str4, iLoginListener);
                    return;
                }
                AccountManagerImpl.getInstance(sContext);
                AccountManagerImpl.mCuidTokenTryTimes = 0;
                getCuidTokenAndLogin(str2, i, str3, str4, iLoginListener);
            } else {
                loginExecutor(i, str, str2, str3, str4, iLoginListener);
            }
        }
    }

    public static void loginExecutor(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65646, null, new Object[]{Integer.valueOf(i), str, str2, str3, str4, iLoginListener}) == null) {
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "accessToken is NULL");
                }
            } else if (i == 1 && TextUtils.isEmpty(str)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "uid is NULL");
                }
            } else {
                AccountManagerImpl.getInstance(sContext).login(i, str, str2, str3, str4, iLoginListener);
            }
        }
    }

    public static void setPaMsgsRead(Context context, int i, int i2, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65716, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "setPaMsgsRead patype = " + i + " subPatype = " + i2 + " paid = " + j + " msgid = " + j2 + " time = " + j3);
            SessionParam bjhReadOrDelParam = SessionParam.getBjhReadOrDelParam(0, j, 0, 0);
            bjhReadOrDelParam.clientMaxMsgid = j2;
            setSessionRead(context, bjhReadOrDelParam, null);
        }
    }

    public static String getLoginUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) {
            if (BaseManager.isNullContext(sContext) || !AccountManagerImpl.getInstance(sContext).isLogin() || !LoginManager.LoginState.LOGINED.equals(LoginManager.getInstance(sContext).getCurrentState())) {
                return null;
            }
            return AccountManagerImpl.getInstance(sContext).getUid();
        }
        return (String) invokeV.objValue;
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65632, null, new Object[]{context, arrayList, Boolean.valueOf(z), iGetUsersProfileBatchListener}) == null) {
            ChatUserManager.getUsersProfiles(context, arrayList, z, iGetUsersProfileBatchListener);
        }
    }

    public static void mediaContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65650, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaContactorSetting(context, j, i, iMediaContactorSettingListener);
        }
    }

    public static void mediaDeleteChatMsg(Context context, long j, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65654, null, new Object[]{context, Long.valueOf(j), list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j, -1L, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65657, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iMediaDeleteChatSessionListener}) == null) {
            ChatMsgManager.mediaDeleteChatSession(context, j, j2, iMediaDeleteChatSessionListener);
        }
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65665, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaGetContactorSetting(context, j, i, iMediaContactorSettingListener);
        }
    }

    public static void mediaSendChatMsg(Context context, long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65668, null, new Object[]{context, Long.valueOf(j), chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManager.mediaSendChatMsg(context, j, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65672, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), iMediaSetSessionReadListener}) == null) {
            ChatMsgManager.mediaSetSessionRead(context, j, j2, iMediaSetSessionReadListener);
        }
    }

    public static void sendMsgRequest(Context context, boolean z, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65700, null, new Object[]{context, Boolean.valueOf(z), chatMsg, iSendMessageListener}) != null) || context == null) {
            return;
        }
        Utility.setStudioHostSendMsg(context, z);
        ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
    }

    public static void setBusinessAdvAdShowClickedInfoByUK(Context context, String str, boolean z, IAdvisoryAdBtnShowSaveListener iAdvisoryAdBtnShowSaveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65706, null, new Object[]{context, str, Boolean.valueOf(z), iAdvisoryAdBtnShowSaveListener}) == null) {
            ChatMsgManager.setBusinessAdvAdShowClickedInfoByUK(context, str, z, iAdvisoryAdBtnShowSaveListener);
        }
    }

    public static void setUserDisturb(Context context, long j, int i, IUserPrivacyListener iUserPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65725, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), iUserPrivacyListener}) == null) {
            IMBoxManager.setUserDisturb(context, j, i, iUserPrivacyListener);
        }
    }

    public static boolean init(Context context, long j, int i, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65637, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str})) == null) {
            boolean z = false;
            if (BaseManager.isNullContext(context) || TextUtils.isEmpty(str)) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            sContext = applicationContext;
            try {
                initLCP();
                if (i != 0) {
                    z = true;
                }
                p80.c(applicationContext, z);
                p80.d(applicationContext, i);
            } catch (Throwable unused) {
                LogUtils.e(BaseManager.TAG, "LCPConstants.setLcpEnv not found");
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(applicationContext).registerReceiver(new BroadcastReceiver() { // from class: com.baidu.android.imsdk.BIMManager.2
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
                            g70.c.removeCallbacks(BIMManager.checkIMLoginState);
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
            u60.d().e(applicationContext, str, i, Constants.isDebugMode());
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void login(String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65644, null, new Object[]{str, str2, Integer.valueOf(i), str3, str4, str5, str6, Integer.valueOf(i2), iLoginListener}) == null) {
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                    return;
                }
                return;
            }
            AccountManagerImpl.getInstance(sContext).setAppOpenType(i2);
            AccountManagerImpl.getInstance(sContext).pushReStartWork();
            if (TextUtils.isEmpty(str2)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "accessToken is NULL");
                    return;
                }
                return;
            }
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

    public static void mediaFetchChatMsgs(Context context, long j, int i, long j2, String str, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65658, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.mediaFetchChatMsgs(context, j, i, j2, str, j3, j4, i2, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaGetChatSessions(Context context, long j, int i, long j2, String str, long j3, int i2, int i3, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65660, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), iMediaGetChatSessionListener}) == null) {
            ChatMsgManager.mediaGetChatSessions(context, j, i, j2, str, j3, i2, i3, iMediaGetChatSessionListener);
        }
    }

    public static boolean registerNotify(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65686, null, str, str2, str3)) == null) {
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

    public static boolean shouldFetchMsgFromCUser(Context context, int i, long j) {
        InterceptResult invokeCommon;
        PaInfo queryPaInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65728, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (i == 1) {
                return true;
            }
            if (i == 0 && j > 0 && (Constants.PAFLAG & j) != 0 && (queryPaInfo = PaInfoDBManager.getInstance(context.getApplicationContext()).queryPaInfo(j)) != null && queryPaInfo.getSubtype() != 7) {
                if (!SessionParam.USER_SESSION_NOTIFICATION_CHAT_TYPES.contains(Integer.valueOf(queryPaInfo.getSubtype())) || queryPaInfo.getBusinessType() == 27) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void sendChatMsg(Context context, SendMsgParam sendMsgParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65697, null, context, sendMsgParam) == null) {
            if (context != null && sendMsgParam != null) {
                sendMsgParam.getChatMsg().setSdkSendMsgTime(System.currentTimeMillis());
                if (AccountManager.getMediaRole(context)) {
                    MediaChatMessageManager.getInstance(context).sendChatMsg(context, sendMsgParam);
                } else {
                    sendMessage(context, sendMsgParam.getChatMsg(), new ISendMessageListener(sendMsgParam) { // from class: com.baidu.android.imsdk.BIMManager.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SendMsgParam val$sendMsgParam;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {sendMsgParam};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$sendMsgParam = sendMsgParam;
                        }

                        @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
                        public void onSendMessageResult(int i, ChatMsg chatMsg) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, chatMsg) == null) {
                                SendMsgResponse sendMsgResponse = new SendMsgResponse();
                                sendMsgResponse.msg = chatMsg;
                                this.val$sendMsgParam.onRequestResult(i, "", sendMsgResponse);
                            }
                        }
                    });
                }
            } else if (sendMsgParam != null) {
                sendMsgParam.onRequestResult(1005, "param invalid", null);
            }
        }
    }

    public static void sendPaChatMsg(Context context, int i, int i2, long j, int i3, String str, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65703, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), str, iSendMessageListener}) == null) {
            String str2 = BaseManager.TAG;
            LogUtils.d(str2, "sendPaChatMsg patype = " + i + " subPatype = " + i2 + " paid = " + j + " msgtype = " + i3 + " content = " + str);
            ChatMsgManager.sendPaChatMsg(context, i, i2, j, i3, str, iSendMessageListener);
        }
    }

    public static void shareInIM(Context context, String str, String str2, String str3, int i, String str4, BIMValueCallBack<String> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65727, null, new Object[]{context, str, str2, str3, Integer.valueOf(i), str4, bIMValueCallBack}) == null) {
            LogUtils.d(BaseManager.TAG, "shareInIM --->");
            if (bIMValueCallBack != null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && context != null) {
                    IMShareRequest iMShareRequest = new IMShareRequest(context, str, str2, str3, i, ListenerManager.getInstance().addListener(bIMValueCallBack));
                    HttpHelper.executor(context, iMShareRequest, iMShareRequest);
                    return;
                }
                LogUtils.d(BaseManager.TAG, "shareInIM ---> params is incorrect, pls check params：shareTarget、shareContent、listener、context is required");
                bIMValueCallBack.onResult(-1, "params incorrect", "");
            }
        }
    }
}
