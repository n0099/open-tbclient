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
import d.a.t.a.b.a;
import d.a.t.a.h.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BIMManager extends BaseManager implements NoProGuard {
    public static IConnectListener mConnectListener;
    public static Context sContext;
    public static List<IConnectListener> mConnectListeners = new ArrayList();
    public static volatile Runnable checkIMLoginState = new Runnable() { // from class: com.baidu.android.imsdk.BIMManager.4
        @Override // java.lang.Runnable
        public void run() {
            if (a.b() == 0 && LoginManager.getInstance(BIMManager.sContext).getCurrentState() != LoginManager.LoginState.LOGINED) {
                LogUtils.e("BIMManager", "checkIMLoginState lcp connected, but im not login, triggle im relogin");
                LoginManager.getInstance(BIMManager.sContext).triggleLogoutListener(4001, Constants.ERROR_LOGIN_STATE_ERROR);
            }
            BIMManager.postCheckRunnable();
        }
    };

    /* loaded from: classes.dex */
    public enum CATEGORY {
        ALL(-1),
        SINGLEPERSON(0),
        GROUP(1),
        SYSTEM(2),
        PA(0),
        ZHIDA(0),
        STUDIO(4),
        UNKOWN(-1);
        
        public final int value;

        CATEGORY(int i2) {
            this.value = i2;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void asyncUploadImgToBos(Context context, String str, String str2, int i2, int i3, int i4, IUploadTransferListener iUploadTransferListener) {
        ChatMsgManager.asyncUploadImgToBos(context, str, str2, i2, i3, i4, iUploadTransferListener);
    }

    public static void audioTrans(Context context, String str, String str2, String str3, int i2, BIMValueCallBack bIMValueCallBack) {
        ChatMsgManager.audioTrans(context, str, str2, str3, i2, bIMValueCallBack);
    }

    public static void autoClearCache(Context context) {
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

    public static void clearCache(Context context) {
        LogUtils.d(BaseManager.TAG, "start clearCache");
        Utility.clearFileCache(context);
        IMTrackDatabase.getInstance(context).clearAllTables();
        Utility.writeLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, Utility.getImTrackDbSize(context));
    }

    public static void clearDb(Context context) {
        File[] listFiles;
        String name;
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

    public static void connectStatusNotify(int i2) {
        String str = BaseManager.TAG;
        LogUtils.i(str, "connectStatusNotify:" + i2);
        String str2 = BaseManager.TAG;
        LogUtils.i(str2, "IConnectListener size:" + mConnectListeners.size());
        synchronized (mConnectListeners) {
            for (IConnectListener iConnectListener : mConnectListeners) {
                if (iConnectListener != null) {
                    String str3 = BaseManager.TAG;
                    LogUtils.i(str3, "im connect Status changed，成功回调业务监听, listener :" + iConnectListener.hashCode());
                    iConnectListener.onResult(i2);
                }
            }
        }
    }

    public static boolean deleteConversation(BIMConversation bIMConversation) {
        if (BaseManager.isNullContext(sContext) || bIMConversation == null) {
            return false;
        }
        return ConversationManagerImpl.getInstance(sContext).deleteConversation(bIMConversation);
    }

    public static int deleteDraftMsg(Context context, int i2, long j) {
        return ChatMsgManager.deleteDraftMsg(context, i2, j);
    }

    public static int deleteMsg(Context context, ChatMsg chatMsg) {
        return ChatMsgManager.deleteMsg(context, chatMsg);
    }

    public static long deleteMsgs(Context context, int i2, long j, boolean z) {
        if (BaseManager.isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i2, j, z);
    }

    public static boolean enableDebugMode(boolean z) {
        if (BaseManager.isNullContext(sContext)) {
            return false;
        }
        try {
            c.f68437a = z;
        } catch (Throwable unused) {
            LogUtils.e(BaseManager.TAG, "LCPConstants.LOG_DEBUG not found");
        }
        return IMSettings.enableDebugMode(sContext.getApplicationContext(), z);
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, long j, long j2, int i2) {
        return ChatMsgManager.fetchMessageSync(context, 0, j, j2, i2);
    }

    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i2, long j, int i3, ChatMsg chatMsg) {
        return ChatMsgManager.fetchMessageSyncWithState(context, i2, j, i3, chatMsg);
    }

    public static void fetchMsgByHostRequest(Context context, long j, int i2, long j2, long j3, long j4, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgByHostRequest(context, j, i2, j2, j3, j4, i3, i4, iFetchMsgByIdListener, false);
    }

    public static void fetchMsgByMsgid(Context context, int i2, long j, long j2, long j3, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgByMsgid(context, i2, j, j2, j3, i3, i4, iFetchMsgByIdListener, false);
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i2, long j3, long j4, long j5, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        fetchMsgRequest(context, j, j2, i2, j3, j4, j5, i3, i4, iFetchMsgByIdListener, false);
    }

    public static void fetchPaChatMsgs(Context context, int i2, int i3, long j, long j2, long j3, int i4, IFetchMessageListener iFetchMessageListener) {
        String str = BaseManager.TAG;
        LogUtils.d(str, "fetchPaChatMsgs patype = " + i2 + " subPatype = " + i3 + " paid = " + j + " msgid = " + j2 + " time = " + j3 + " count = " + i4);
        ChatMsgManager.fetchPaChatMsgs(context, i2, i3, j, j2, j3, i4, iFetchMessageListener);
    }

    public static void genBosObjectUrl(Context context, String str, String str2, String str3, int i2, int i3, int i4, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        ChatMsgManager.genBosObjectUrl(context, str, str2, str3, i2, i3, i4, iGenBosObjectUrlListener);
    }

    public static String getAllCastIdList(Context context) {
        return ConversationStudioManImpl.getInstance(context).getAllCastIdList();
    }

    public static ArrayList<BIMConversation> getAllConversation(CATEGORY category) {
        if (BaseManager.isNullContext(sContext)) {
            return null;
        }
        return ConversationManagerImpl.getInstance(sContext).getAllConversation(category);
    }

    public static String getAppVersion(Context context) {
        return AccountManagerImpl.getInstance(context).getAppVersion();
    }

    public static long getCacheSize(Context context) {
        long sumCacheSize = Utility.sumCacheSize(context);
        long imTrackDbSize = Utility.getImTrackDbSize(context);
        long readLongData = Utility.readLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, 0L);
        String str = BaseManager.TAG;
        LogUtils.d(str, "getCacheSize pluginCacheSize = " + sumCacheSize + " trackSize = " + imTrackDbSize + " defSize = " + readLongData);
        long j = imTrackDbSize - readLongData;
        return sumCacheSize + (j >= 0 ? j : 0L);
    }

    @Deprecated
    public static List<ChatSession> getChatSession(Context context, List<Integer> list) {
        return ChatMsgManager.getChatRecords(context, list);
    }

    public static ChatUser getChatUserSync(Context context, long j) {
        return ChatUserManager.getChatUserSync(context, j);
    }

    public static BIMConversation getConversation(String str, CATEGORY category) {
        if (BaseManager.isNullContext(sContext)) {
            return null;
        }
        if (CATEGORY.ALL != category && CATEGORY.SYSTEM != category) {
            return ConversationManagerImpl.getInstance(sContext).getConversation(category, str);
        }
        LogUtils.e(LogUtils.TAG, "category should not be ALL or SYSTEM");
        return null;
    }

    public static String getCuid(Context context) {
        return Utility.getDeviceId(context);
    }

    public static void getCuidTokenAndLogin(final String str, final int i2, final String str2, final String str3, final ILoginListener iLoginListener) {
        Context context = sContext;
        Utility.writeLoginFlag(context, "3N", "getCuidTokenAndLogin accessToken = " + str);
        AccountManagerImpl.getInstance(sContext).getTokenByCuid(AccountManager.getAppid(sContext), str, new IGetTokenByCuidListener() { // from class: com.baidu.android.imsdk.BIMManager.5
            @Override // com.baidu.android.imsdk.account.IGetTokenByCuidListener
            public void onGetTokenByCuidResult(int i3, String str4, String str5) {
                if (i3 != 0) {
                    if (i3 != 70) {
                        AccountManagerImpl.getInstance(BIMManager.sContext);
                        AccountManagerImpl.mCuidTokenTryTimes++;
                        LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, responseCode = " + i3 + ", errMsg = " + str4);
                        AccountManagerImpl.getInstance(BIMManager.sContext);
                        if (AccountManagerImpl.mCuidTokenTryTimes > 3) {
                            Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken retryTime >= 3, errCode = " + i3 + ", errMsg :" + str4);
                            iLoginListener.onLoginResult(i3, str4);
                            return;
                        }
                        try {
                            Thread.sleep(200L);
                        } catch (Exception e2) {
                            LogUtils.e(BaseManager.TAG, "Exception ", e2);
                            Utility.writeLoginFlag(BIMManager.sContext, "3N", "gen token retry exception, errCode = " + i3);
                            new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e2)).build();
                        }
                        BIMManager.getCuidTokenAndLogin(str, i2, str2, str3, iLoginListener);
                        return;
                    }
                    iLoginListener.onLoginResult(i3, str4);
                } else if (!TextUtils.isEmpty(str5)) {
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    AccountManagerImpl.mCuidTokenTryTimes = 0;
                    LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token =  " + str5);
                    Utility.writeLoginFlag(BIMManager.sContext, "3Y", "genToken success, token = " + str5);
                    BIMManager.loginExecutor(i2, null, str5, str2, str3, iLoginListener);
                } else {
                    LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token is null,  responseCode = " + i3 + ", errMsg = " + str4);
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    AccountManagerImpl.mCuidTokenTryTimes = AccountManagerImpl.mCuidTokenTryTimes + 1;
                    AccountManagerImpl.getInstance(BIMManager.sContext);
                    if (AccountManagerImpl.mCuidTokenTryTimes > 3) {
                        Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken is null, errCode = 1005");
                        iLoginListener.onLoginResult(1005, "gen token is NULL");
                        return;
                    }
                    try {
                        Thread.sleep(200L);
                    } catch (Exception e3) {
                        LogUtils.e(BaseManager.TAG, "Exception ", e3);
                        Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken retry exception, errCode = " + i3);
                        new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e3)).build();
                    }
                    BIMManager.getCuidTokenAndLogin(str, i2, str2, str3, iLoginListener);
                }
            }
        });
    }

    public static ChatMsg getDraftMsg(Context context, int i2, long j) {
        return ChatMsgManager.getDraftMsg(context, i2, j);
    }

    public static long getJoinedCastId(Context context) {
        return ConversationStudioManImpl.getInstance(context).getJoinedCastId();
    }

    public static int getLoginType(Context context) {
        return AccountManagerImpl.getInstance(context).getLoginType();
    }

    public static String getLoginUser() {
        if (!BaseManager.isNullContext(sContext) && AccountManagerImpl.getInstance(sContext).isLogin() && LoginManager.LoginState.LOGINED.equals(LoginManager.getInstance(sContext).getCurrentState())) {
            return AccountManagerImpl.getInstance(sContext).getUid();
        }
        return null;
    }

    public static long getMaxReliableMsgId(Context context, long j) {
        return ConversationStudioManImpl.getInstance(context).getMaxReliableMsgId(j);
    }

    public static int getNewMsgCount(Context context) {
        return ChatMsgManager.getNewMsgCount(context);
    }

    public static void getPaNewMsgCount(Context context, int i2, int i3, long j, IGetNewMsgCountListener iGetNewMsgCountListener) {
        String str = BaseManager.TAG;
        LogUtils.d(str, "getPaNewMsgCount patype = " + i2 + " subPatype = " + i3 + " paid = " + j);
        ChatMsgManager.getPaNewMsgCount(context, i2, i3, j, iGetNewMsgCountListener);
    }

    public static long getReliableMsgCount(Context context, long j) {
        return ConversationStudioManImpl.getInstance(context).getReliableMsgCount(j);
    }

    public static int getUnReadMsgCountByPaid(Context context, long j) {
        return ChatMsgManager.getUnReadMsgCountByPaid(context, j);
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        ChatUserManager.getUsersProfiles(context, arrayList, z, iGetUsersProfileBatchListener);
    }

    public static String getVersion() {
        return IMManagerImpl.getVersion();
    }

    public static void imLogoutByLcp(Context context) {
        try {
            d.a.s.a.e(context);
            LoginManager.getInstance(context).onLogoutResultInternal(0, "lcp unconnected");
        } catch (Exception e2) {
            LogUtils.e(BaseManager.TAG, "imLogoutByLcp exception ", e2);
        }
    }

    public static void imLogoutByLcpAsync(final Context context) {
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.BIMManager.3
            @Override // java.lang.Runnable
            public void run() {
                BIMManager.imLogoutByLcp(context);
            }
        });
    }

    public static boolean init(Context context, long j, int i2, String str) {
        if (BaseManager.isNullContext(context) || TextUtils.isEmpty(str)) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        d.a.s.a.f68195e = a.d(applicationContext);
        if (d.a.s.a.f68195e) {
            try {
                initLCP();
                c.c(applicationContext, i2 != 0);
                c.d(applicationContext, i2);
            } catch (Throwable unused) {
                LogUtils.e(BaseManager.TAG, "LCPConstants.setLcpEnv not found");
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(applicationContext).registerReceiver(new BroadcastReceiver() { // from class: com.baidu.android.imsdk.BIMManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null || !"com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                    return;
                }
                boolean z = intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0;
                LogUtils.e("BIMManager", "BLCPClient notifyConnectState :" + z);
                if (!z) {
                    BIMManager.imLogoutByLcpAsync(context2);
                    BIMManager.connectStatusNotify(1);
                }
                try {
                    BIMManager.initIMServiceImpl(context2);
                    d.a.s.a.f68193c.removeCallbacks(BIMManager.checkIMLoginState);
                    if (z) {
                        BIMManager.postCheckRunnable();
                    }
                } catch (Exception e2) {
                    String str2 = BaseManager.TAG;
                    LogUtils.e(str2, "registerLCPReceiver exception" + e2.getMessage());
                }
            }
        }, intentFilter);
        Log.d(RetrieveReportRequest.APP_NAME, "set env as " + i2 + "， appId:" + j + ", cuid :" + str);
        AccountManagerImpl.getInstance(applicationContext).setAppid(j);
        Utility.setDeviceId(applicationContext, str);
        Constants.setEnv(applicationContext, i2);
        IMManagerImpl.getInstance(applicationContext);
        IMSettings.setContext(applicationContext);
        ConversationManagerImpl.getInstance(applicationContext);
        Utility.clearExpiredMsg(applicationContext);
        registerInternalListener(RetrieveMsgReceiver.getInstance(applicationContext));
        d.a.r.a.a.d().e(applicationContext, str, i2, Constants.isDebugMode());
        return true;
    }

    public static void initIMServiceImpl(final Context context) {
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.BIMManager.2
            @Override // java.lang.Runnable
            public void run() {
                d.a.s.a.g(context);
            }
        });
    }

    public static void initLCP() {
        d.a.t.a.b.c.f().j(sContext);
    }

    public static boolean isIMLogined(Context context) {
        return LoginManager.getInstance(context).isIMLogined();
    }

    public static boolean isSupportMsgType(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 2 || i2 == 1 || i2 == 13 || i2 == 16 || i2 == 18 || i2 == 12 || i2 == 21 || i2 == 9 || i2 == 1002 || i2 == 1001 || i2 == 1003 || i2 == 1004 || i2 == 1005 || i2 == 1007 || i2 == 1008 || i2 == 1009 || i2 == 1010 || i2 == 1011 || i2 == 2010 || i2 == 1012 || i2 == 2001 || i2 == 80 || i2 == 31 || i2 == 32 || i2 == 33 || i2 == 20 || i2 == 22 || i2 == 25 || i2 == 26 || i2 == 24 || i2 == 2012 || i2 == 2014 || i2 == 28 || i2 == 27 || i2 == 29 || i2 == 30 || i2 == 35 || i2 == 36 || i2 == 38 || i2 == 1013 || i2 == 1014 || i2 == 39 || i2 == 40 || i2 == 41;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void login(String str, String str2, int i2, String str3, String str4, String str5, String str6, int i3, ILoginListener iLoginListener) {
        long j;
        IMTrack.RequestBuilder requestId;
        String str7;
        String str8 = BaseManager.TAG;
        LogUtils.d(str8, "HB> im in login, uid = " + str + ", cuid = " + str2 + ", loginType = " + i2 + ", zid = " + str5 + ", vCode = " + str6 + ", openType = " + i3);
        if (BaseManager.isNullContext(sContext)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "Context is NULL");
                return;
            }
            return;
        }
        try {
            String[] loginFlag = Utility.getLoginFlag(sContext);
            if (loginFlag.length >= 2) {
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
                        Utility.writeLoginOpenType(sContext, i3);
                        AccountManagerImpl.getInstance(sContext).setAppOpenType(i3);
                        AccountManagerImpl.getInstance(sContext).pushReStartWork();
                        if (!TextUtils.isEmpty(str2)) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                    throw th;
                }
            } else {
                str7 = "1Y";
                j = 0;
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
        Utility.writeLoginOpenType(sContext, i3);
        AccountManagerImpl.getInstance(sContext).setAppOpenType(i3);
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
        Utility.writeLoginFlag(context3, "2Y", "accessToken is nonnull, loginType = " + i2);
        if (!TextUtils.isEmpty(str5)) {
            LogUtils.d(BaseManager.TAG, "HB> im in login, zid is not null !");
            AccountManagerImpl.getInstance(sContext).setZid(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            LogUtils.d(BaseManager.TAG, "HB> im in login, vCode is not null !");
            AccountManagerImpl.getInstance(sContext).setVersionCode(str6);
        }
        if (i2 == 6) {
            AccountManagerImpl.getInstance(sContext).setCuid(str2);
            String token = AccountManagerImpl.getInstance(sContext).getToken();
            if (!TextUtils.isEmpty(token)) {
                loginExecutor(i2, str, token, str3, str4, iLoginListener);
                return;
            }
            AccountManagerImpl.getInstance(sContext);
            AccountManagerImpl.mCuidTokenTryTimes = 0;
            getCuidTokenAndLogin(str2, i2, str3, str4, iLoginListener);
            return;
        }
        loginExecutor(i2, str, str2, str3, str4, iLoginListener);
    }

    public static void loginExecutor(int i2, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        if (BaseManager.isNullContext(sContext)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "Context is NULL");
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (iLoginListener != null) {
                iLoginListener.onLoginResult(1005, "accessToken is NULL");
            }
        } else {
            if (i2 != 6) {
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
            AccountManagerImpl.getInstance(sContext).login(i2, str, str2, str3, str4, iLoginListener);
        }
    }

    public static void logout(final ILoginListener iLoginListener) {
        LogUtils.d(BaseManager.TAG, "logout");
        if (!BaseManager.isNullContext(sContext)) {
            AccountManagerImpl.getInstance(sContext).logout(1, new ILoginListener() { // from class: com.baidu.android.imsdk.BIMManager.6
                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLoginResult(int i2, String str) {
                }

                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLogoutResult(int i2, String str, int i3) {
                    String str2 = BaseManager.TAG;
                    LogUtils.i(str2, "onLogoutResult errorCode : " + i2 + " , errMsg, " + str + " , loginType, " + i3);
                    if (i2 != 0) {
                        Utility.logout(BIMManager.sContext, null);
                    }
                    LoginManager.getInstance(BIMManager.sContext).onLogoutResultInternal(0, str);
                    ILoginListener iLoginListener2 = ILoginListener.this;
                    if (iLoginListener2 != null) {
                        iLoginListener2.onLogoutResult(0, i2 != 0 ? "Force logout" : "", i3);
                    }
                }
            });
        } else if (iLoginListener != null) {
            iLoginListener.onLogoutResult(1005, "Context is null", -1);
        }
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        return ChatMsgManager.markMsgClicked(context, chatMsg);
    }

    public static void mediaContactorSetting(Context context, long j, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatMsgManager.mediaContactorSetting(context, j, i2, iMediaContactorSettingListener);
    }

    public static void mediaDeleteAllChatMsg(Context context, long j, long j2, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManager.mediaDeleteChatMsg(context, j, j2, null, iMediaDeleteChatMsgListener);
    }

    public static void mediaDeleteChatMsg(Context context, long j, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManager.mediaDeleteChatMsg(context, j, -1L, list, iMediaDeleteChatMsgListener);
    }

    public static void mediaDeleteChatSession(Context context, long j, long j2, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        ChatMsgManager.mediaDeleteChatSession(context, j, j2, iMediaDeleteChatSessionListener);
    }

    public static void mediaFetchChatMsgs(Context context, long j, long j2, long j3, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        ChatMsgManager.mediaFetchChatMsgs(context, j, j2, j3, i2, iMediaFetchChatMsgsListener);
    }

    public static void mediaGetChatSessions(Context context, long j, long j2, int i2, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        ChatMsgManager.mediaGetChatSessions(context, j, j2, i2, iMediaGetChatSessionListener);
    }

    public static void mediaGetContactorPauid(Context context, long j, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        ChatMsgManager.mediaGetContactorPauid(context, j, iMediaGetContactorPauidListener);
    }

    public static void mediaGetContactorSetting(Context context, long j, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatMsgManager.mediaGetContactorSetting(context, j, i2, iMediaContactorSettingListener);
    }

    public static void mediaRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        ChatMsgManager.mediaRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
    }

    public static void mediaSendChatMsg(Context context, long j, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        ChatMsgManager.mediaSendChatMsg(context, j, chatMsg, iMediaSendChatMsgListener);
    }

    public static void mediaSetAllSessionRead(Context context, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        ChatMsgManager.setMediaAllSessionRead(context, iMediaSetSessionReadListener);
    }

    public static void mediaSetRole(Context context, boolean z) {
        AccountManager.setMediaRole(context, z);
    }

    public static void mediaSetSessionRead(Context context, long j, long j2, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        ChatMsgManager.mediaSetSessionRead(context, j, j2, iMediaSetSessionReadListener);
    }

    public static void mediaUnRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        ChatMsgManager.mediaUnRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
    }

    public static void pingRequest() {
        a.e();
    }

    public static void postCheckRunnable() {
        try {
            LogUtils.i("BIMManager", "postCheckRunnable after 30s");
            d.a.s.a.f68193c.postDelayed(checkIMLoginState, 30000L);
        } catch (Exception e2) {
            LogUtils.e(BaseManager.TAG, "postCheckRunnable exception ", e2);
        }
    }

    public static void registerChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        IMBoxManager.registerChatSessionChangeListener(context, iChatSessionChangeListener);
    }

    public static void registerChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        ChatMsgManager.registerChatSessionListener(context, iChatSessionChangeListener);
    }

    public static void registerConnectListener(IConnectListener iConnectListener) {
        mConnectListener = iConnectListener;
        registerConnectListenerToList(iConnectListener);
    }

    public static void registerConnectListenerToList(IConnectListener iConnectListener) {
        synchronized (mConnectListeners) {
            if (!mConnectListeners.contains(iConnectListener)) {
                mConnectListeners.add(iConnectListener);
                String str = BaseManager.TAG;
                LogUtils.i(str, "registerConnectListenerToList:" + iConnectListener.hashCode());
            }
        }
    }

    public static void registerConversationListener(IConversationChangeListener iConversationChangeListener) {
        if (BaseManager.isNullContext(sContext)) {
            return;
        }
        ConversationManagerImpl.getInstance(sContext).registerConversationListener(iConversationChangeListener);
    }

    public static void registerInternalListener(IMessageReceiveListener iMessageReceiveListener) {
        ChatMsgManagerImpl.getInstance(sContext).registerInternalMessageReceiveListener(iMessageReceiveListener);
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        ChatMsgManager.registerMessageReceiveListener(context, iMessageReceiveListener);
    }

    public static boolean registerNotify(String str, String str2, String str3) {
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

    public static void registerStudioUsePaReceiveMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        if (context == null && iLiveMsgReceiveListener != null) {
            iLiveMsgReceiveListener.onReceiveMessage(-1, null);
        }
        ChatMsgManager.registerStudioUsePaReceivePaMsg(context, iLiveMsgReceiveListener);
    }

    public static void removeSessionByClasstype(Context context, int i2) {
        IMBoxManager.removeSessionByClasstype(context, i2);
    }

    public static int saveAsDraftMsg(Context context, ChatMsg chatMsg) {
        return ChatMsgManager.saveAsDraftMsg(context, chatMsg);
    }

    public static void saveMessage(Context context, ChatMsg chatMsg) {
        ChatMsgManager.saveMessage(context, chatMsg);
    }

    public static void sendMessage(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        if (context == null) {
            return;
        }
        ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
    }

    public static void sendMsgRequest(Context context, boolean z, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        if (context == null) {
            return;
        }
        Utility.setStudioHostSendMsg(context, z);
        ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
    }

    public static void sendPaChatMsg(Context context, int i2, int i3, long j, int i4, String str, ISendMessageListener iSendMessageListener) {
        String str2 = BaseManager.TAG;
        LogUtils.d(str2, "sendPaChatMsg patype = " + i2 + " subPatype = " + i3 + " paid = " + j + " msgtype = " + i4 + " content = " + str);
        ChatMsgManager.sendPaChatMsg(context, i2, i3, j, i4, str, iSendMessageListener);
    }

    public static boolean setAllMsgRead(Context context, int i2, long j, boolean z) {
        return ChatMsgManager.setAllMsgRead(context, i2, j, z);
    }

    public static void setForbid(Context context, long j, long j2, int i2, ISetForbidListener iSetForbidListener) {
        ShieldAndTopManager.getInstance(context).setForbid(j, j2, i2, iSetForbidListener);
    }

    public static void setGroupMarkTop(Context context, long j, int i2, IStatusListener iStatusListener) {
        ShieldAndTopManager.getInstance(context).setMarkTop(j, 3, i2, iStatusListener);
    }

    public static void setMarkTop(Context context, long j, int i2, IStatusListener iStatusListener) {
        ShieldAndTopManager.getInstance(context).setMarkTop(j, 1, i2, iStatusListener);
    }

    public static boolean setMsgRead(Context context, long j, long j2, boolean z) {
        return ChatMsgManager.setMsgRead(context, 0, j, j2, z);
    }

    public static void setPaMsgsRead(Context context, int i2, int i3, long j, long j2, long j3) {
        String str = BaseManager.TAG;
        LogUtils.d(str, "setPaMsgsRead patype = " + i2 + " subPatype = " + i3 + " paid = " + j + " msgid = " + j2 + " time = " + j3);
        ChatMsgManager.setPaMsgsRead(context, i2, i3, j, j2, j3);
    }

    public static boolean setProductLine(Context context, int i2, String str) {
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
        return IMManager.init(context, i2);
    }

    public static void setUpdateSwitch(Context context, int i2) {
        AccountManager.setUpdateSwitch(context, i2);
    }

    public static void setUserDisturb(Context context, long j, int i2, IUserPrivacyListener iUserPrivacyListener) {
        IMBoxManager.setUserDisturb(context, j, i2, iUserPrivacyListener);
    }

    public static void setUserMarkTop(Context context, long j, int i2, IStatusListener iStatusListener) {
        ShieldAndTopManager.getInstance(context).setMarkTop(j, 0, i2, iStatusListener);
    }

    public static void tryConnection(Context context) {
        if (d.a.s.a.f68195e) {
            return;
        }
        AccountManagerImpl.getInstance(context);
        AccountManagerImpl.tryConnection(context);
    }

    public static void unregisterChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        IMBoxManager.unregisterChatSessionChangeListener(context, iChatSessionChangeListener);
    }

    public static void unregisterChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        ChatMsgManager.unregisterChatSessionListener(context, iChatSessionChangeListener);
    }

    public static void unregisterConnectListener() {
        mConnectListener = null;
    }

    public static void unregisterConnectListenerFromList(IConnectListener iConnectListener) {
        if (iConnectListener == null) {
            return;
        }
        synchronized (mConnectListeners) {
            mConnectListeners.remove(iConnectListener);
            String str = BaseManager.TAG;
            LogUtils.i(str, "unregisterConnectListenerFromList:" + iConnectListener.hashCode());
        }
    }

    public static void unregisterConversationListener(IConversationChangeListener iConversationChangeListener) {
        if (BaseManager.isNullContext(sContext)) {
            return;
        }
        ConversationManagerImpl.getInstance(sContext).unregisterConversationListener(iConversationChangeListener);
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        ChatMsgManager.unregisterMessageReceiveListener(context, iMessageReceiveListener);
    }

    public static void unregisterStudioUsePaReceiveMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        if (context == null && iLiveMsgReceiveListener != null) {
            iLiveMsgReceiveListener.onReceiveMessage(-1, null);
        }
        ChatMsgManager.unregisterStudioUsePaReceivePaMsg(context, iLiveMsgReceiveListener);
    }

    public static void fetchMsgByHostRequest(Context context, long j, int i2, long j2, long j3, long j4, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        ChatMsgManager.fetchMsgByHostRequst(context, j, i2, j2, j3, j4, i3, iFetchMsgByIdListener);
    }

    public static void fetchMsgByMsgid(Context context, int i2, long j, long j2, long j3, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        ChatMsgManager.fetchMsgRequst(context, Utility.getAppId(context), Utility.getUK(context), i2, j, j2, j3, i3, iFetchMsgByIdListener, z);
    }

    public static void fetchMsgRequest(Context context, long j, long j2, int i2, long j3, long j4, long j5, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        ChatMsgManager.fetchMsgRequst(context, j, j2, i2, j3, j4, j5, i3, iFetchMsgByIdListener, z);
    }

    public static void getChatSession(Context context, List<Integer> list, IGetSessionListener iGetSessionListener) {
        IMBoxManager.getChatSession(context, list, iGetSessionListener);
    }

    public static void getNewMsgCount(Context context, List<Integer> list, IGetNewMsgCountListener iGetNewMsgCountListener) {
        IMBoxManager.getNewMsgCount(context, list, iGetNewMsgCountListener);
    }

    public static void mediaContactorSetting(Context context, long j, int i2, long j2, String str, int i3, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatMsgManager.mediaContactorSetting(context, j, i2, j2, str, i3, iMediaContactorSettingListener);
    }

    public static void mediaDeleteAllChatMsg(Context context, long j, int i2, long j2, String str, long j3, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManager.mediaDeleteChatMsg(context, j, i2, j2, str, j3, null, iMediaDeleteChatMsgListener);
    }

    public static void mediaDeleteChatMsg(Context context, long j, int i2, long j2, String str, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        ChatMsgManager.mediaDeleteChatMsg(context, j, i2, j2, str, -1L, list, iMediaDeleteChatMsgListener);
    }

    public static void mediaDeleteChatSession(Context context, long j, int i2, long j2, String str, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        ChatMsgManager.mediaDeleteChatSession(context, j, i2, j2, str, j3, iMediaDeleteChatSessionListener);
    }

    public static void mediaFetchChatMsgs(Context context, long j, int i2, long j2, String str, long j3, long j4, int i3, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        ChatMsgManager.mediaFetchChatMsgs(context, j, i2, j2, str, j3, j4, i3, iMediaFetchChatMsgsListener);
    }

    public static void mediaGetChatSessions(Context context, long j, int i2, long j2, String str, long j3, int i3, int i4, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        ChatMsgManager.mediaGetChatSessions(context, j, i2, j2, str, j3, i3, i4, iMediaGetChatSessionListener);
    }

    public static void mediaGetContactorPauid(Context context, long j, int i2, long j2, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        ChatMsgManager.mediaGetContactorPauid(context, j, i2, j2, str, iMediaGetContactorPauidListener);
    }

    public static void mediaGetContactorSetting(Context context, long j, int i2, long j2, String str, int i3, IMediaContactorSettingListener iMediaContactorSettingListener) {
        ChatMsgManager.mediaGetContactorSetting(context, j, i2, j2, str, i3, iMediaContactorSettingListener);
    }

    public static void mediaSendChatMsg(Context context, long j, int i2, long j2, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        ChatMsgManager.mediaSendChatMsg(context, j, i2, j2, str, chatMsg, iMediaSendChatMsgListener);
    }

    public static void mediaSetSessionRead(Context context, long j, int i2, long j2, String str, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        ChatMsgManager.mediaSetSessionRead(context, j, i2, j2, str, j3, iMediaSetSessionReadListener);
    }

    @Deprecated
    public static boolean setMsgRead(Context context, long j, long j2) {
        return ChatMsgManager.setMsgRead(context, 0, j, j2, false);
    }

    public static int deleteMsgs(Context context, long j, long[] jArr, boolean z) {
        if (BaseManager.isNullContext(context)) {
            return -1;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteMsgs(0, j, jArr, z);
    }

    @Deprecated
    public static long deleteMsgs(Context context, long j) {
        if (BaseManager.isNullContext(context)) {
            return -1L;
        }
        return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(0, j, false);
    }

    public static BIMConversation getConversation(Context context, String str, CATEGORY category, String str2, int i2) {
        return getConversation(context, str, false, category, str2, i2);
    }

    public static BIMConversation getConversation(Context context, String str, boolean z, CATEGORY category, String str2, int i2) {
        if (BaseManager.isNullContext(context)) {
            LogUtils.e(BaseManager.TAG, "GETCONVERSATION context is null");
            return null;
        }
        sContext = context;
        if (CATEGORY.ALL != category && CATEGORY.SYSTEM != category) {
            return ConversationStudioManImpl.getInstance(sContext).getConversation(category, str, z, str2, i2);
        }
        LogUtils.e(LogUtils.TAG, "GETCONVERSATION category should not be ALL or SYSTEM");
        return null;
    }

    public static void login(String str, String str2, int i2, String str3, String str4, ILoginListener iLoginListener) {
        IMTrack.RequestBuilder requestId;
        String str5;
        String str6 = BaseManager.TAG;
        LogUtils.d(str6, "HB> im in login, uid = " + str + " ,cuid = " + str2 + ", loginType = " + i2);
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
                if (loginFlag.length >= 2) {
                    j = Long.valueOf(loginFlag[0]).longValue();
                    str5 = loginFlag[1];
                } else {
                    str5 = "1Y";
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
            Utility.writeLoginFlag(context2, "2Y", "accessToken is nonnull, loginType = " + i2);
            if (i2 == 6) {
                AccountManagerImpl.getInstance(sContext).setCuid(str2);
                String token = AccountManagerImpl.getInstance(sContext).getToken();
                if (!TextUtils.isEmpty(token)) {
                    loginExecutor(i2, str, token, str3, str4, iLoginListener);
                    return;
                }
                AccountManagerImpl.getInstance(sContext);
                AccountManagerImpl.mCuidTokenTryTimes = 0;
                getCuidTokenAndLogin(str2, i2, str3, str4, iLoginListener);
                return;
            }
            loginExecutor(i2, str, str2, str3, str4, iLoginListener);
        } catch (Throwable th) {
            new IMTrack.RequestBuilder(sContext).method(String.valueOf(AccountManagerImpl.getInstance(sContext).getAppOpenType())).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
            throw th;
        }
    }
}
