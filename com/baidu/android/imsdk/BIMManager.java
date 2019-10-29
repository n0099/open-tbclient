package com.baidu.android.imsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.IUserPrivacyListener;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.conversation.IConversationChangeListener;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMManagerImpl;
import com.baidu.android.imsdk.internal.IMSettings;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.upload.action.IMTrackManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class BIMManager extends BaseManager implements NoProGuard {
    private static Context sContext = null;

    /* loaded from: classes6.dex */
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
        if (!isNullContext(context) && !TextUtils.isEmpty(str)) {
            Context applicationContext = context.getApplicationContext();
            sContext = context;
            boolean appid = AccountManagerImpl.getInstance(context).setAppid(j);
            if (appid) {
                if (i == 0 || i == 1 || i == 2 || i == 3) {
                    Log.d("imsdk", "set env as " + i);
                    appid = Constants.setEnv(applicationContext, i);
                    if (!appid) {
                        return false;
                    }
                }
                IMManagerImpl.getInstance(applicationContext);
                IMSettings.setContext(context);
                Utility.setDeviceId(context, str);
                ConversationManagerImpl.getInstance(applicationContext);
                return appid;
            }
            return false;
        }
        return false;
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

    public static void login(String str, String str2, int i, String str3, String str4, String str5, String str6, ILoginListener iLoginListener) {
        LogUtils.d(TAG, "HB> im in login, uid = " + str + ", cuid = " + str2 + ", loginType = " + i + ", zid = " + str5 + ", vCode = " + str6);
        if (isNullContext(sContext)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "Context is NULL");
                return;
            }
            return;
        }
        AccountManagerImpl.getInstance(sContext).pushReStartWork();
        if (TextUtils.isEmpty(str2)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "accessToken is NULL");
                return;
            }
            return;
        }
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
    }

    public static void login(String str, String str2, int i, String str3, String str4, ILoginListener iLoginListener) {
        LogUtils.d(TAG, "HB> im in login, uid = " + str + " ,cuid = " + str2 + ", loginType = " + i);
        if (isNullContext(sContext)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "Context is NULL");
            }
        } else if (TextUtils.isEmpty(str2)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void getCuidTokenAndLogin(final String str, final int i, final String str2, final String str3, final ILoginListener iLoginListener) {
        AccountManagerImpl.getInstance(sContext).getTokenByCuid(AccountManager.getAppid(sContext), str, new IGetTokenByCuidListener() { // from class: com.baidu.android.imsdk.BIMManager.1
            @Override // com.baidu.android.imsdk.account.IGetTokenByCuidListener
            public void onGetTokenByCuidResult(int i2, String str4, String str5) {
                if (i2 == 0) {
                    if (!TextUtils.isEmpty(str5)) {
                        AccountManagerImpl.getInstance(BIMManager.sContext);
                        AccountManagerImpl.mCuidTokenTryTimes = 0;
                        LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token =  " + str5);
                        BIMManager.loginExecutor(i, null, str5, str2, str3, iLoginListener);
                        return;
                    }
                    LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token is null,  responseCode = " + i2 + ", errMsg = " + str4);
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    AccountManagerImpl.mCuidTokenTryTimes++;
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    if (AccountManagerImpl.mCuidTokenTryTimes <= 3) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception e) {
                            LogUtils.e(BaseManager.TAG, "Exception ", e);
                            new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e)).build();
                        }
                        BIMManager.getCuidTokenAndLogin(str, i, str2, str3, iLoginListener);
                        return;
                    }
                    iLoginListener.onLoginResult(1005, "gen token is NULL");
                } else if (i2 != 70) {
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    AccountManagerImpl.mCuidTokenTryTimes++;
                    LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, responseCode = " + i2 + ", errMsg = " + str4);
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    if (AccountManagerImpl.mCuidTokenTryTimes <= 3) {
                        try {
                            Thread.sleep(200L);
                        } catch (Exception e2) {
                            LogUtils.e(BaseManager.TAG, "Exception ", e2);
                            new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e2)).build();
                        }
                        BIMManager.getCuidTokenAndLogin(str, i, str2, str3, iLoginListener);
                        return;
                    }
                    iLoginListener.onLoginResult(i2, str4);
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
                return;
            }
            return;
        }
        if (Utility.isUploadIMInitTrack(sContext)) {
            IMTrackManager.uploadIMInitAction(sContext);
        }
        if (TextUtils.isEmpty(str2)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "accessToken is NULL");
            }
        } else if (i != 6 && TextUtils.isEmpty(str)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "uid is NULL");
            }
        } else {
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
                    LoginManager.getInstance(BIMManager.sContext).onLogoutResultInternal(0, str);
                    if (ILoginListener.this != null) {
                        ILoginListener.this.onLogoutResult(0, "Force logout", i2);
                    }
                } else if (ILoginListener.this != null) {
                    ILoginListener.this.onLogoutResult(0, "", i2);
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
        if (isNullContext(context)) {
            LogUtils.e(TAG, "GETCONVERSATION context is null");
            return null;
        }
        sContext = context;
        if (CATEGORY.ALL == category || CATEGORY.SYSTEM == category) {
            LogUtils.e(LogUtils.TAG, "GETCONVERSATION category should not be ALL or SYSTEM");
            return null;
        }
        return ConversationManagerImpl.getInstance(sContext).getConversation(category, str, str2, i);
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

    public static void registerMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        if (!isNullContext(sContext)) {
            ChatMsgManagerImpl.getInstance(sContext).registerMessageReceiveListener(iMessageReceiveListener);
        }
    }

    public static void unregisterMessageReceiveListener(IMessageReceiveListener iMessageReceiveListener) {
        if (!isNullContext(sContext)) {
            ChatMsgManagerImpl.getInstance(sContext).unregisterMessageReceiveListener(sContext, iMessageReceiveListener);
        }
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
        if (!isNullContext(sContext)) {
            AccountManagerImpl.getInstance(sContext).setConnectListener(iConnectListener);
        }
    }

    public static void unregisterConnectListener() {
        if (!isNullContext(sContext)) {
            AccountManagerImpl.getInstance(sContext).removeConnectListener();
        }
    }

    public static void clearCache() {
        Utility.clearFileCache();
    }

    public static long getCacheSize() {
        return Utility.sumCacheSize();
    }

    public static String getCuid(Context context) {
        return Utility.getDeviceId(context);
    }

    public static void fetchMsgByMsgid(Context context, int i, long j, long j2, long j3, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        ChatMsgManager.fetchMsgidByMsgid(context, i, j, j2, j3, i2, i3, iFetchMsgByIdListener);
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, IFetchMsgByIdListener iFetchMsgByIdListener) {
        ChatMsgManager.fetchMsgRequst(context, j, j2, i, j3, j4, j5, i2, iFetchMsgByIdListener);
    }

    public static boolean isSupportMsgType(int i) {
        return i == 0 || i == 8 || i == 2 || i == 1 || i == 13 || i == 16 || i == 18 || i == 12 || i == 21 || i == 9 || i == 1002 || i == 1001 || i == 1003 || i == 1004 || i == 1005 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011 || i == 2010 || i == 1012 || i == 2001 || i == 80 || i == 31 || i == 32 || i == 33 || i == 20 || i == 22 || i == 24;
    }

    public static int getLoginType(Context context) {
        return AccountManagerImpl.getInstance(context).getLoginType();
    }

    public static void tryConnection(Context context) {
        AccountManagerImpl.getInstance(context);
        AccountManagerImpl.tryConnection(context);
    }

    public static void setMarkTop(Context context, long j, int i, IStatusListener iStatusListener) {
        IMBoxManager.setMarkTop(context, j, i, iStatusListener);
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
}
