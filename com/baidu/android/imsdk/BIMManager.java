package com.baidu.android.imsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
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
import com.baidu.android.imsdk.shield.ISetForbidListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class BIMManager extends BaseManager implements NoProGuard {
    private static IConnectListener mConnectListener;
    private static Context sContext = null;

    /* loaded from: classes9.dex */
    public enum CATEGORY {
        ALL(-1),
        SINGLEPERSON(0),
        GROUP(1),
        SYSTEM(2),
        PA(0),
        ZHIDA(0),
        STUDIO(4),
        UNKOWN(-1);
        
        private final int value;

        CATEGORY(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static boolean setProductLine(Context context, int i, String str) {
        if (isNullContext(context)) {
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

    public static String getAppVersion(Context context) {
        return AccountManagerImpl.getInstance(context).getAppVersion();
    }

    public static boolean init(Context context, long j, int i, String str) {
        if (isNullContext(context) || TextUtils.isEmpty(str)) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        a.ayp = false;
        Log.d("imsdk", "set env as " + i + "， appId:" + j + ", cuid :" + str);
        AccountManagerImpl.getInstance(applicationContext).setAppid(j);
        Utility.setDeviceId(applicationContext, str);
        Constants.setEnv(applicationContext, i);
        IMManagerImpl.getInstance(applicationContext);
        IMSettings.setContext(applicationContext);
        ConversationManagerImpl.getInstance(applicationContext);
        return true;
    }

    public static void imLogoutByLcp(Context context) {
        try {
            a.am(context);
            LoginManager.getInstance(context).onLogoutResultInternal(0, "lcp unconnected");
        } catch (Exception e) {
            LogUtils.e(TAG, "imLogoutByLcp exception ", e);
        }
    }

    public static boolean enableDebugMode(boolean z) {
        if (isNullContext(sContext)) {
            return false;
        }
        return IMSettings.enableDebugMode(sContext.getApplicationContext(), z);
    }

    public static String getVersion() {
        return IMManagerImpl.getVersion();
    }

    public static void login(String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, ILoginListener iLoginListener) {
        LogUtils.d(TAG, "HB> im in login, uid = " + str + ", cuid = " + str2 + ", loginType = " + i + ", zid = " + str5 + ", vCode = " + str6 + ", openType = " + i2);
        if (isNullContext(sContext)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "Context is NULL");
                return;
            }
            return;
        }
        String str7 = "1Y";
        long j = 0;
        try {
            try {
                String[] loginFlag = Utility.getLoginFlag(sContext);
                if (loginFlag.length >= 2) {
                    j = Long.valueOf(loginFlag[0]).longValue();
                    str7 = loginFlag[1];
                }
                new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId(str7).requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
            } catch (Exception e) {
                LogUtils.e(TAG, "IMTrack init request getLoginFlag Exception ");
                new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
            }
            Utility.writeLoginCallTime(sContext);
            Utility.writeLoginFlag(sContext, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
            Utility.writeLoginOpenType(sContext, i2);
            AccountManagerImpl.getInstance(sContext).setAppOpenType(i2);
            AccountManagerImpl.getInstance(sContext).pushReStartWork();
            if (TextUtils.isEmpty(str2)) {
                Utility.writeLoginFlag(sContext, "2N", "accessToken is null");
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "accessToken is NULL");
                    return;
                }
                return;
            }
            Utility.writeLoginFlag(sContext, "2Y", "accessToken is nonnull, loginType = " + i);
            if (!TextUtils.isEmpty(str5)) {
                LogUtils.d(TAG, "HB> im in login, zid is not null !");
                AccountManagerImpl.getInstance(sContext).setZid(str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                LogUtils.d(TAG, "HB> im in login, vCode is not null !");
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
        } catch (Throwable th) {
            new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
            throw th;
        }
    }

    public static void login(String str, String str2, int i, String str3, String str4, ILoginListener iLoginListener) {
        LogUtils.d(TAG, "HB> im in login, uid = " + str + " ,cuid = " + str2 + ", loginType = " + i);
        if (isNullContext(sContext)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "Context is NULL");
                return;
            }
            return;
        }
        String str5 = "1Y";
        long j = 0;
        try {
            try {
                String[] loginFlag = Utility.getLoginFlag(sContext);
                if (loginFlag.length >= 2) {
                    j = Long.valueOf(loginFlag[0]).longValue();
                    str5 = loginFlag[1];
                }
                new IMTrack.RequestBuilder(sContext).method(String.valueOf(AccountManagerImpl.getInstance(sContext).getAppOpenType())).requestId(str5).requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
            } catch (Exception e) {
                LogUtils.e(TAG, "IMTrack init request getLoginFlag Exception ");
                new IMTrack.RequestBuilder(sContext).method(String.valueOf(AccountManagerImpl.getInstance(sContext).getAppOpenType())).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
            }
            Utility.writeLoginCallTime(sContext);
            Utility.writeLoginFlag(sContext, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
            if (TextUtils.isEmpty(str2)) {
                Utility.writeLoginFlag(sContext, "2N", "accessToken is null");
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "accessToken is NULL");
                    return;
                }
                return;
            }
            Utility.writeLoginFlag(sContext, "2Y", "accessToken is nonnull, loginType = " + i);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void getCuidTokenAndLogin(final String str, final int i, final String str2, final String str3, final ILoginListener iLoginListener) {
        Utility.writeLoginFlag(sContext, "3N", "getCuidTokenAndLogin accessToken = " + str);
        AccountManagerImpl.getInstance(sContext).getTokenByCuid(AccountManager.getAppid(sContext), str, new IGetTokenByCuidListener() { // from class: com.baidu.android.imsdk.BIMManager.1
            @Override // com.baidu.android.imsdk.account.IGetTokenByCuidListener
            public void onGetTokenByCuidResult(int i2, String str4, String str5) {
                if (i2 == 0) {
                    if (!TextUtils.isEmpty(str5)) {
                        AccountManagerImpl.getInstance(BIMManager.sContext);
                        AccountManagerImpl.mCuidTokenTryTimes = 0;
                        LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token =  " + str5);
                        Utility.writeLoginFlag(BIMManager.sContext, "3Y", "genToken success, token = " + str5);
                        BIMManager.loginExecutor(i, null, str5, str2, str3, iLoginListener);
                        return;
                    }
                    LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token is null,  responseCode = " + i2 + ", errMsg = " + str4);
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    AccountManagerImpl.mCuidTokenTryTimes++;
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    if (AccountManagerImpl.mCuidTokenTryTimes > 3) {
                        Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken is null, errCode = 1005");
                        iLoginListener.onLoginResult(1005, "gen token is NULL");
                        return;
                    }
                    try {
                        Thread.sleep(200L);
                    } catch (Exception e) {
                        LogUtils.e(BaseManager.TAG, "Exception ", e);
                        Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken retry exception, errCode = " + i2);
                        new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e)).build();
                    }
                    BIMManager.getCuidTokenAndLogin(str, i, str2, str3, iLoginListener);
                } else if (i2 != 70) {
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    AccountManagerImpl.mCuidTokenTryTimes++;
                    LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, responseCode = " + i2 + ", errMsg = " + str4);
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    if (AccountManagerImpl.mCuidTokenTryTimes > 3) {
                        Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken retryTime >= 3, errCode = " + i2 + ", errMsg :" + str4);
                        iLoginListener.onLoginResult(i2, str4);
                        return;
                    }
                    try {
                        Thread.sleep(200L);
                    } catch (Exception e2) {
                        LogUtils.e(BaseManager.TAG, "Exception ", e2);
                        Utility.writeLoginFlag(BIMManager.sContext, "3N", "gen token retry exception, errCode = " + i2);
                        new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e2)).build();
                    }
                    BIMManager.getCuidTokenAndLogin(str, i, str2, str3, iLoginListener);
                } else {
                    iLoginListener.onLoginResult(i2, str4);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loginExecutor(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        if (isNullContext(sContext)) {
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

    public static void logout(final ILoginListener iLoginListener) {
        LogUtils.d(TAG, "logout");
        if (isNullContext(sContext)) {
            if (iLoginListener != null) {
                iLoginListener.onLogoutResult(1005, "Context is null", -1);
                return;
            }
            return;
        }
        AccountManagerImpl.getInstance(sContext).logout(1, new ILoginListener() { // from class: com.baidu.android.imsdk.BIMManager.2
            @Override // com.baidu.android.imsdk.account.ILoginListener
            public void onLoginResult(int i, String str) {
            }

            @Override // com.baidu.android.imsdk.account.ILoginListener
            public void onLogoutResult(int i, String str, int i2) {
                LogUtils.i(BaseManager.TAG, "onLogoutResult errorCode : " + i + " , errMsg, " + str + " , loginType, " + i2);
                if (i != 0) {
                    Utility.logout(BIMManager.sContext, null);
                }
                LoginManager.getInstance(BIMManager.sContext).onLogoutResultInternal(0, str);
                if (ILoginListener.this != null) {
                    ILoginListener.this.onLogoutResult(0, i != 0 ? "Force logout" : "", i2);
                }
            }
        });
    }

    public static String getLoginUser() {
        if (!isNullContext(sContext) && AccountManagerImpl.getInstance(sContext).isLogin() && LoginManager.LoginState.LOGINED.equals(LoginManager.getInstance(sContext).getCurrentState())) {
            return AccountManagerImpl.getInstance(sContext).getUid();
        }
        return null;
    }

    public static BIMConversation getConversation(String str, CATEGORY category) {
        if (isNullContext(sContext)) {
            return null;
        }
        if (CATEGORY.ALL == category || CATEGORY.SYSTEM == category) {
            LogUtils.e(LogUtils.TAG, "category should not be ALL or SYSTEM");
            return null;
        }
        return ConversationManagerImpl.getInstance(sContext).getConversation(category, str);
    }

    public static BIMConversation getConversation(Context context, String str, CATEGORY category, String str2, int i) {
        return getConversation(context, str, false, category, str2, i);
    }

    public static BIMConversation getConversation(Context context, String str, boolean z, CATEGORY category, String str2, int i) {
        if (isNullContext(context)) {
            LogUtils.e(TAG, "GETCONVERSATION context is null");
            return null;
        }
        sContext = context;
        if (CATEGORY.ALL == category || CATEGORY.SYSTEM == category) {
            LogUtils.e(LogUtils.TAG, "GETCONVERSATION category should not be ALL or SYSTEM");
            return null;
        }
        return ConversationStudioManImpl.getInstance(sContext).getConversation(category, str, z, str2, i);
    }

    public static String getAllCastIdList(Context context) {
        return ConversationStudioManImpl.getInstance(context).getAllCastIdList();
    }

    public static long getJoinedCastId(Context context) {
        return ConversationStudioManImpl.getInstance(context).getJoinedCastId();
    }

    public static long getMaxReliableMsgId(Context context, long j) {
        return ConversationStudioManImpl.getInstance(context).getMaxReliableMsgId(j);
    }

    public static long getReliableMsgCount(Context context, long j) {
        return ConversationStudioManImpl.getInstance(context).getReliableMsgCount(j);
    }

    public static boolean isIMLogined(Context context) {
        return LoginManager.getInstance(context).isIMLogined();
    }

    public static ArrayList<BIMConversation> getAllConversation(CATEGORY category) {
        if (isNullContext(sContext)) {
            return null;
        }
        return ConversationManagerImpl.getInstance(sContext).getAllConversation(category);
    }

    @Deprecated
    public static List<ChatSession> getChatSession(Context context, List<Integer> list) {
        return ChatMsgManager.getChatRecords(context, list);
    }

    public static void getChatSession(Context context, List<Integer> list, IGetSessionListener iGetSessionListener) {
        IMBoxManager.getChatSession(context, list, iGetSessionListener);
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, long j, long j2, int i) {
        return ChatMsgManager.fetchMessageSync(context, 0, j, j2, i);
    }

    public static long deleteMsgs(Context context, int i, long j, boolean z) {
        if (IMManager.isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i, j, z);
    }

    public static int deleteMsgs(Context context, long j, long[] jArr, boolean z) {
        if (IMManager.isNullContext(context)) {
            return -1;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteMsgs(0, j, jArr, z);
    }

    @Deprecated
    public static long deleteMsgs(Context context, long j) {
        if (IMManager.isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(0, j, false);
    }

    public static boolean setMsgRead(Context context, long j, long j2, boolean z) {
        return ChatMsgManager.setMsgRead(context, 0, j, j2, z);
    }

    @Deprecated
    public static boolean setMsgRead(Context context, long j, long j2) {
        return ChatMsgManager.setMsgRead(context, 0, j, j2, false);
    }

    public static boolean setAllMsgRead(Context context, int i, long j, boolean z) {
        return ChatMsgManager.setAllMsgRead(context, i, j, z);
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        ChatUserManager.getUsersProfiles(context, arrayList, z, iGetUsersProfileBatchListener);
    }

    public static ChatUser getChatUserSync(Context context, long j) {
        return ChatUserManager.getChatUserSync(context, j);
    }

    public static void genBosObjectUrl(Context context, String str, String str2, String str3, int i, int i2, int i3, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        ChatMsgManager.genBosObjectUrl(context, str, str2, str3, i, i2, i3, iGenBosObjectUrlListener);
    }

    public static void audioTrans(Context context, String str, String str2, String str3, int i, BIMValueCallBack bIMValueCallBack) {
        ChatMsgManager.audioTrans(context, str, str2, str3, i, bIMValueCallBack);
    }

    public static void registerConversationListener(IConversationChangeListener iConversationChangeListener) {
        if (!isNullContext(sContext)) {
            ConversationManagerImpl.getInstance(sContext).registerConversationListener(iConversationChangeListener);
        }
    }

    public static void unregisterConversationListener(IConversationChangeListener iConversationChangeListener) {
        if (!isNullContext(sContext)) {
            ConversationManagerImpl.getInstance(sContext).unregisterConversationListener(iConversationChangeListener);
        }
    }

    public static boolean deleteConversation(BIMConversation bIMConversation) {
        if (isNullContext(sContext) || bIMConversation == null) {
            return false;
        }
        return ConversationManagerImpl.getInstance(sContext).deleteConversation(bIMConversation);
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        ChatMsgManager.registerMessageReceiveListener(context, iMessageReceiveListener);
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        ChatMsgManager.unregisterMessageReceiveListener(context, iMessageReceiveListener);
    }

    public static boolean registerNotify(String str, String str2, String str3) {
        LogUtils.d(TAG, "channelId=" + str + ";userId=" + str2 + ";appId=" + str3);
        if (IMManager.isNullContext(sContext)) {
            LogUtils.d(TAG, "Context is NULL!");
            return false;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            LogUtils.d(TAG, Constants.ERROR_MSG_PARAMETER_ERROR);
            return false;
        } else {
            return ChatMsgManagerImpl.getInstance(sContext).registerNotify(str, str2, str3, null);
        }
    }

    public static void clearDb(Context context) {
        File[] listFiles;
        String name;
        File file = new File(context.getDatabasePath("bdimsdk_.db").getParent());
        if (file != null && file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
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

    public static void registerConnectListener(IConnectListener iConnectListener) {
        mConnectListener = iConnectListener;
    }

    public static void unregisterConnectListener() {
        mConnectListener = null;
    }

    public static void connectStatusNotify(int i) {
        LogUtils.i(TAG, "connectStatusNotify:" + i);
        LogUtils.i(TAG, "IConnectListener is:" + mConnectListener);
        if (mConnectListener != null) {
            LogUtils.i(TAG, "im login success，成功回调业务监听");
            mConnectListener.onResult(i);
        }
    }

    public static void clearCache(Context context) {
        Utility.clearFileCache(context);
    }

    public static long getCacheSize(Context context) {
        return Utility.sumCacheSize(context);
    }

    public static String getCuid(Context context) {
        return Utility.getDeviceId(context);
    }

    public static void fetchMsgByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgByMsgid(context, i, j, j2, j3, i2, i3, iFetchMsgByIdListener, false);
    }

    public static void fetchMsgByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        ChatMsgManager.fetchMsgRequst(context, Utility.getAppId(context), Utility.getUK(context), i, j, j2, j3, i2, iFetchMsgByIdListener, z);
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgRequest(context, j, j2, i, j3, j4, j5, i2, i3, iFetchMsgByIdListener, false);
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        ChatMsgManager.fetchMsgRequst(context, j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener, z);
    }

    public static void fetchMsgByHostRequest(Context context, long j, int i, long j2, long j3, long j4, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgByHostRequest(context, j, i, j2, j3, j4, i2, i3, iFetchMsgByIdListener, false);
    }

    public static void fetchMsgByHostRequest(Context context, long j, int i, long j2, long j3, long j4, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        ChatMsgManager.fetchMsgByHostRequst(context, j, i, j2, j3, j4, i2, iFetchMsgByIdListener);
    }

    public static void sendMsgRequest(Context context, boolean z, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        if (context != null) {
            Utility.setStudioHostSendMsg(context, z);
            ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
        }
    }

    public static void sendMessage(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        if (context != null) {
            ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
        }
    }

    public static int saveAsDraftMsg(Context context, ChatMsg chatMsg) {
        return ChatMsgManager.saveAsDraftMsg(context, chatMsg);
    }

    public static void saveMessage(Context context, ChatMsg chatMsg) {
        ChatMsgManager.saveMessage(context, chatMsg);
    }

    public static int deleteDraftMsg(Context context, int i, long j) {
        return ChatMsgManager.deleteDraftMsg(context, i, j);
    }

    public static ChatMsg getDraftMsg(Context context, int i, long j) {
        return ChatMsgManager.getDraftMsg(context, i, j);
    }

    public static int deleteMsg(Context context, ChatMsg chatMsg) {
        return ChatMsgManager.deleteMsg(context, chatMsg);
    }

    public static int getNewMsgCount(Context context) {
        return ChatMsgManager.getNewMsgCount(context);
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        return ChatMsgManager.markMsgClicked(context, chatMsg);
    }

    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        return ChatMsgManager.fetchMessageSyncWithState(context, i, j, i2, chatMsg);
    }

    public static int getUnReadMsgCountByPaid(Context context, long j) {
        return ChatMsgManager.getUnReadMsgCountByPaid(context, j);
    }

    public static void registerChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        ChatMsgManager.registerChatSessionListener(context, iChatSessionChangeListener);
    }

    public static void unregisterChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        ChatMsgManager.unregisterChatSessionListener(context, iChatSessionChangeListener);
    }

    public static boolean isSupportMsgType(int i) {
        return i == 0 || i == 8 || i == 2 || i == 1 || i == 13 || i == 16 || i == 18 || i == 12 || i == 21 || i == 9 || i == 1002 || i == 1001 || i == 1003 || i == 1004 || i == 1005 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011 || i == 2010 || i == 1012 || i == 2001 || i == 80 || i == 31 || i == 32 || i == 33 || i == 20 || i == 22 || i == 25 || i == 26 || i == 24 || i == 2012 || i == 2014;
    }

    public static int getLoginType(Context context) {
        return AccountManagerImpl.getInstance(context).getLoginType();
    }

    public static void tryConnection(Context context) {
        if (!a.ayp) {
            AccountManagerImpl.getInstance(context);
            AccountManagerImpl.tryConnection(context);
        }
    }

    public static void setMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        ShieldAndTopManager.getInstance(context).setMarkTop(j, 1, i, iStatusListener);
    }

    public static void setUserMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        ShieldAndTopManager.getInstance(context).setMarkTop(j, 0, i, iStatusListener);
    }

    public static void removeSessionByClasstype(Context context, int i) {
        IMBoxManager.removeSessionByClasstype(context, i);
    }

    public static void registerChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        IMBoxManager.registerChatSessionChangeListener(context, iChatSessionChangeListener);
    }

    public static void unregisterChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        IMBoxManager.unregisterChatSessionChangeListener(context, iChatSessionChangeListener);
    }

    public static void getNewMsgCount(Context context, List<Integer> list, IGetNewMsgCountListener iGetNewMsgCountListener) {
        IMBoxManager.getNewMsgCount(context, list, iGetNewMsgCountListener);
    }

    public static void setUserDisturb(Context context, long j, int i, IUserPrivacyListener iUserPrivacyListener) {
        IMBoxManager.setUserDisturb(context, j, i, iUserPrivacyListener);
    }

    public static void setUpdateSwitch(Context context, int i) {
        AccountManager.setUpdateSwitch(context, i);
    }

    public static void mediaSetRole(Context context, boolean z) {
        AccountManager.setMediaRole(context, z);
    }

    public static void mediaGetChatSessions(Context context, long j, long j2, int i, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        ChatMsgManager.mediaGetChatSessions(context, j, j2, i, iMediaGetChatSessionListener);
    }

    public static void mediaGetChatSessions(Context context, long j, int i, long j2, String str, long j3, int i2, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        ChatMsgManager.mediaGetChatSessions(context, j, i, j2, str, j3, i2, iMediaGetChatSessionListener);
    }

    public static void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        ChatMsgManager.mediaFetchChatMsgs(context, j, j2, j3, i, iMediaFetchChatMsgsListener);
    }

    public static void mediaFetchChatMsgs(Context context, long j, int i, long j2, String str, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        ChatMsgManager.mediaFetchChatMsgs(context, j, i, j2, str, j3, j4, i2, iMediaFetchChatMsgsListener);
    }

    public static void mediaSendChatMsg(Context context, long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        ChatMsgManager.mediaSendChatMsg(context, j, chatMsg, iMediaSendChatMsgListener);
    }

    public static void mediaSendChatMsg(Context context, long j, int i, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        ChatMsgManager.mediaSendChatMsg(context, j, i, j2, str, chatMsg, iMediaSendChatMsgListener);
    }

    public static void mediaDeleteChatMsg(Context context, long j, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManager.mediaDeleteChatMsg(context, j, -1L, list, iMediaDeleteChatMsgListener);
    }

    public static void mediaDeleteChatMsg(Context context, long j, int i, long j2, String str, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManager.mediaDeleteChatMsg(context, j, i, j2, str, -1L, list, iMediaDeleteChatMsgListener);
    }

    public static void mediaDeleteAllChatMsg(Context context, long j, long j2, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManager.mediaDeleteChatMsg(context, j, j2, null, iMediaDeleteChatMsgListener);
    }

    public static void mediaDeleteAllChatMsg(Context context, long j, int i, long j2, String str, long j3, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManager.mediaDeleteChatMsg(context, j, i, j2, str, j3, null, iMediaDeleteChatMsgListener);
    }

    public static void mediaSetSessionRead(Context context, long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        ChatMsgManager.mediaSetSessionRead(context, j, j2, iMediaSetSessionReadListener);
    }

    public static void mediaSetSessionRead(Context context, long j, int i, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        ChatMsgManager.mediaSetSessionRead(context, j, i, j2, str, j3, iMediaSetSessionReadListener);
    }

    public static void mediaDeleteChatSession(Context context, long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        ChatMsgManager.mediaDeleteChatSession(context, j, j2, iMediaDeleteChatSessionListener);
    }

    public static void mediaDeleteChatSession(Context context, long j, int i, long j2, String str, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        ChatMsgManager.mediaDeleteChatSession(context, j, i, j2, str, j3, iMediaDeleteChatSessionListener);
    }

    public static void mediaGetContactorPauid(Context context, long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        ChatMsgManager.mediaGetContactorPauid(context, j, iMediaGetContactorPauidListener);
    }

    public static void mediaGetContactorPauid(Context context, long j, int i, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        ChatMsgManager.mediaGetContactorPauid(context, j, i, j2, str, iMediaGetContactorPauidListener);
    }

    public static void mediaContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatMsgManager.mediaContactorSetting(context, j, i, iMediaContactorSettingListener);
    }

    public static void mediaContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatMsgManager.mediaContactorSetting(context, j, i, j2, str, i2, iMediaContactorSettingListener);
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatMsgManager.mediaGetContactorSetting(context, j, i, iMediaContactorSettingListener);
    }

    public static void mediaGetContactorSetting(Context context, long j, int i, long j2, String str, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatMsgManager.mediaGetContactorSetting(context, j, i, j2, str, i2, iMediaContactorSettingListener);
    }

    public static void mediaRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        ChatMsgManager.mediaRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
    }

    public static void mediaUnRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        ChatMsgManager.mediaUnRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
    }

    public static void setForbid(Context context, long j, long j2, int i, ISetForbidListener iSetForbidListener) {
        ShieldAndTopManager.getInstance(context).setForbid(j, j2, i, iSetForbidListener);
    }
}
