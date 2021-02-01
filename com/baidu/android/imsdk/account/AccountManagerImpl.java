package com.baidu.android.imsdk.account;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.request.IMGetMsgSettingSwitchRequest;
import com.baidu.android.imsdk.account.request.IMGetPaidByAppidRequest;
import com.baidu.android.imsdk.account.request.IMGetTokenByCuidRequest;
import com.baidu.android.imsdk.account.request.IMGetUidByUkRequest;
import com.baidu.android.imsdk.account.request.IMSetMsgSettingSwitchRequest;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.account.request.IMUserLogoutMsg;
import com.baidu.android.imsdk.account.request.IMUserQueryPrivacyRequest;
import com.baidu.android.imsdk.account.request.IMUserSetPrivacyRequest;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.pushservice.PushManager;
import com.baidu.g.a;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AccountManagerImpl {
    private static Context mContext;
    private static volatile AccountManagerImpl mInstance;
    private String mAppVersion;
    private long mAppid;
    private ILoginStateChangedListener mILoginStateChangedListener;
    private IKickOutListener mKickOutListener;
    private String mToken;
    private static final String TAG = AccountManagerImpl.class.getSimpleName();
    public static int mCuidTokenTryTimes = 0;
    private String mUid = "";
    private CopyOnWriteArrayList<TodoAfterLogin> mToDoListenersAfterLogin = new CopyOnWriteArrayList<>();
    private ArrayList<TodoBeforeLogout> mToDoListenersBeforeLogout = new ArrayList<>();
    private int mLoginType = -1;
    private String mCuid = null;
    private String mFrom = "";
    private String mCFrom = "";
    private String mZid = "";
    private String mVersionCode = "";
    private int mLoginState = 0;
    private Timer mTimer = null;
    private int mOpenType = 0;
    private boolean isMediaRole = false;

    private AccountManagerImpl() {
        this.mAppid = -1L;
        this.mAppid = Utility.getAppId(mContext);
        Class<?>[] clsArr = {IMUserLoginByTokenMsg.class, IMUserLogoutMsg.class};
        int[] iArr = {50, 52};
        for (int i = 0; i < clsArr.length; i++) {
            MessageFactory.getInstance().addType(iArr[i], clsArr[i]);
        }
    }

    public static synchronized AccountManagerImpl getInstance(Context context) {
        AccountManagerImpl accountManagerImpl;
        synchronized (AccountManagerImpl.class) {
            if (mInstance == null) {
                mContext = context.getApplicationContext();
                mInstance = new AccountManagerImpl();
            }
            accountManagerImpl = mInstance;
        }
        return accountManagerImpl;
    }

    public boolean setAppid(long j) {
        this.mAppid = j;
        Utility.writeAppId(mContext, j);
        return true;
    }

    public long getAppid() {
        long j = this.mAppid;
        if (j == -1) {
            return Utility.readAppId(mContext);
        }
        return j;
    }

    public void setZid(String str) {
        this.mZid = str;
        Utility.writeZid(mContext, str);
    }

    public String getZid() {
        String str = this.mZid;
        if (TextUtils.isEmpty(str)) {
            return Utility.readStringData(mContext, Constants.KEY_ZID, "");
        }
        return str;
    }

    public void setVersionCode(String str) {
        this.mVersionCode = str;
        Utility.writeVersionCode(mContext, str);
    }

    public String getVersionCode() {
        String str = this.mVersionCode;
        if (TextUtils.isEmpty(str)) {
            return Utility.readStringData(mContext, Constants.KEY_VCODE, "");
        }
        return str;
    }

    public void setAppVersion(String str) {
        this.mAppVersion = str;
        Utility.writeStringData(mContext, Constants.KEY_PRODUCT_VERSION, str);
    }

    public String getAppVersion() {
        return TextUtils.isEmpty(this.mAppVersion) ? Utility.readStringData(mContext, Constants.KEY_PRODUCT_VERSION, "0") : this.mAppVersion;
    }

    public boolean setUid(String str) {
        if (str != null) {
            this.mUid = str;
            Utility.writeUid(mContext, str);
        }
        return str != null;
    }

    public String getUid() {
        String str = this.mUid;
        if (TextUtils.isEmpty(str)) {
            String readUid = Utility.readUid(mContext);
            this.mUid = readUid;
            return readUid;
        }
        return str;
    }

    public int getLoginType() {
        if (this.mLoginType != -1) {
            return this.mLoginType;
        }
        this.mLoginType = Utility.readLoginType(mContext);
        return this.mLoginType;
    }

    public void setLoginType(int i) {
        this.mLoginType = i;
        Utility.writeLoginType(mContext, this.mLoginType);
    }

    public String getCuid() {
        if (this.mCuid != null) {
            return this.mCuid;
        }
        this.mCuid = Utility.readCuid(mContext);
        return this.mCuid;
    }

    public void setCuid(String str) {
        this.mCuid = str;
        Utility.writeCuid(mContext, this.mCuid);
    }

    public boolean clearUid(Context context) {
        boolean removeKey = Utility.removeKey(mContext, Constants.KEY_PASSPORT_UID);
        if (removeKey) {
            this.mUid = "";
        }
        return removeKey;
    }

    public void login(final int i, final String str, final String str2, final String str3, final String str4, final ILoginListener iLoginListener) {
        if (str2 == null) {
            onLoginResult("", 1005, Constants.ERROR_MSG_PARAMETER_ERROR, false);
            return;
        }
        LogUtils.d(TAG, "login type :" + i);
        LogUtils.d(TAG, "start login loginState:" + LoginManager.getInstance(mContext).getCurrentState());
        LogUtils.d(TAG, "current version:" + IMConfigInternal.getInstance().getSDKVersionValue(mContext) + " " + IMConfigInternal.getInstance().getSDKVersionValue(mContext));
        Utility.writeLoginFlag(mContext, "5N_1", "login begin");
        ConversationStudioManImpl.getInstance(mContext);
        ConversationStudioManImpl.resetHeartBeat(60000);
        if (Utility.isPeakTime()) {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
            this.mTimer = new Timer();
            long nextInt = (new Random().nextInt(Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) + 10) * 1000;
            LogUtils.d(TAG, "*** peak time! login will delay " + nextInt + " ms ***");
            try {
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        AccountManagerImpl.this.startLoginServiceRunnable(i, str, str2, str3, str4, iLoginListener);
                    }
                }, nextInt);
                return;
            } catch (Exception e) {
                LogUtils.e(TAG, "timer exception", e);
                startLoginServiceRunnable(i, str, str2, str3, str4, iLoginListener);
                return;
            }
        }
        Utility.writeLoginFlag(mContext, "5N_2", "startLoginServiceRunnable");
        if (!TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AccountManagerImpl.this.startLoginServiceRunnable(i, str, str2, str3, str4, iLoginListener);
            }
        })) {
            startLoginServiceRunnable(i, str, str2, str3, str4, iLoginListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoginServiceRunnable(final int i, final String str, final String str2, final String str3, final String str4, final ILoginListener iLoginListener) {
        LogUtils.d(TAG, "*** startLoginServiceRunnable will start ***");
        String token = getToken();
        boolean z = (i == 6 || TextUtils.isEmpty(token) || str2.equals(token)) ? false : true;
        Utility.writeLoginFlag(mContext, "5N", "startLoginServiceRunnable begin, loginType = " + i + "，needLogout :" + z);
        if (z) {
            LogUtils.d(TAG, "need logout before login");
            if (a.aug) {
                BIMManager.imLogoutByLcp(mContext);
                startLoginService(i, str, str2, str3, str4, iLoginListener);
                return;
            }
            LoginManager.getInstance(mContext).logoutInternal(null);
            Utility.clearCache(mContext);
            logout(0, new ILoginListener() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.3
                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLoginResult(int i2, String str5) {
                }

                @Override // com.baidu.android.imsdk.account.ILoginListener
                public void onLogoutResult(int i2, String str5, int i3) {
                    LogUtils.d(AccountManagerImpl.TAG, "logout onLogoutResult");
                    AccountManagerImpl.this.disconnect(ListenerManager.getInstance().addListener(new ILoginListener() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.3.1
                        @Override // com.baidu.android.imsdk.account.ILoginListener
                        public void onLoginResult(int i4, String str6) {
                        }

                        @Override // com.baidu.android.imsdk.account.ILoginListener
                        public void onLogoutResult(int i4, String str6, int i5) {
                            LogUtils.d(AccountManagerImpl.TAG, "disconnect onLogoutResult");
                            Utility.writeLoginFlag(AccountManagerImpl.mContext, "5Y", "Logout and disconnect success");
                            AccountManagerImpl.this.startLoginService(i, str, str2, str3, str4, iLoginListener);
                        }
                    }));
                }
            });
            return;
        }
        startLoginService(i, str, str2, str3, str4, iLoginListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoginService(int i, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        boolean loginInternal = LoginManager.getInstance(mContext).loginInternal(iLoginListener);
        LogUtils.d(TAG, "startLoginService isNeedLogin: " + loginInternal);
        Utility.writeLoginFlag(mContext, "6N", "startLoginService isNeedLogin :" + loginInternal);
        if (loginInternal) {
            noticeStateChanged(1);
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 50);
            creatMethodIntent.putExtra(Constants.EXTRA_INTERNAL_LOGIN, true);
            if (!TextUtils.isEmpty(str3)) {
                this.mFrom = str3;
                Utility.writeLoginFrom(mContext, str3);
                creatMethodIntent.putExtra(Constants.EXTRA_LOGIN_FROM, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                this.mCFrom = str4;
                Utility.writeLoginCFrom(mContext, str4);
                creatMethodIntent.putExtra(Constants.EXTRA_LOGIN_CFROM, str4);
            }
            if (i == 1 && !TextUtils.isEmpty(str)) {
                setUid(str);
            }
            getInstance(mContext).setLoginType(i);
            this.mToken = str2;
            Utility.writeAccessToken(mContext, str2);
            try {
                a.ao(mContext).e(mContext, creatMethodIntent);
                Utility.writeLoginFlag(mContext, "6Y", "startLoginService");
            } catch (Exception e) {
                Utility.writeLoginFlag(mContext, "6N_1", "startLoginService exception");
                LogUtils.e(TAG, "startService", e);
            }
        }
    }

    public long getUK() {
        if (isLogin()) {
            return Utility.getUK(mContext);
        }
        return 0L;
    }

    public boolean clearToken(String str) {
        boolean clearAccessToken = Utility.clearAccessToken(mContext);
        if (clearAccessToken) {
            Utility.clearCache(mContext);
            this.mToken = null;
        }
        if (!a.aug) {
            clearLoginParam(mContext);
            clearUid(mContext);
            disconnect(str);
        } else if (!TextUtils.isEmpty(str)) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener instanceof ILoginListener) {
                LoginManager.getInstance(mContext).logoutInternal((ILoginListener) removeListener);
                ((ILoginListener) removeListener).onLogoutResult(0, "logout success", getInstance(mContext).getLoginType());
            }
        }
        return clearAccessToken;
    }

    public String getToken() {
        String str = this.mToken;
        if (TextUtils.isEmpty(str)) {
            return Utility.getAccessToken(mContext);
        }
        return str;
    }

    public String getcFrom() {
        String str = this.mCFrom;
        if (TextUtils.isEmpty(str)) {
            return Utility.getLoginCFrom(mContext);
        }
        return str;
    }

    public String getFrom() {
        String str = this.mFrom;
        if (TextUtils.isEmpty(str)) {
            return Utility.getLoginFrom(mContext);
        }
        return str;
    }

    public boolean clearLoginParam(Context context) {
        if (Utility.removeKey(mContext, Constants.EXTRA_LOGIN_FROM)) {
            this.mFrom = "";
        }
        if (Utility.removeKey(mContext, Constants.EXTRA_LOGIN_CFROM)) {
            this.mCFrom = "";
        }
        if (Utility.removeKey(mContext, Constants.KEY_ZID)) {
            this.mZid = "";
        }
        if (Utility.removeKey(mContext, Constants.KEY_VCODE)) {
            this.mVersionCode = "";
            return true;
        }
        return true;
    }

    public void logout(int i, ILoginListener iLoginListener) {
        noticeStateChanged(4);
        BIMManager.connectStatusNotify(1);
        Iterator<TodoBeforeLogout> it = this.mToDoListenersBeforeLogout.iterator();
        while (it.hasNext()) {
            TodoBeforeLogout next = it.next();
            if (next != null) {
                next.todo();
            }
        }
        String addListener = ListenerManager.getInstance().addListener(iLoginListener);
        if (isLogin()) {
            Intent creatMethodIntent = Utility.creatMethodIntent(mContext, 52);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            creatMethodIntent.putExtra(Constants.EXTRA_CLEAR_AFTER_LOGOUT, i);
            try {
                a.ao(mContext).e(mContext, creatMethodIntent);
                return;
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
                onLogoutResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, i);
                return;
            }
        }
        onLogoutResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, i);
    }

    public void onLoginResult(String str, int i, String str2, boolean z) {
        LogUtils.d(TAG, "onLoginResult----errorCode: " + i + " msg: " + str2);
        LoginManager.getInstance(mContext).onLoginResultInternal(i, str2);
        if (i == 0) {
            ConversationStudioManImpl.getInstance(mContext).clear();
            ConversationStudioManImpl.getInstance(mContext).clearAckCastList();
            noticeStateChanged(3);
            BIMManager.connectStatusNotify(0);
            if (!a.aug) {
                Utility.sendConnectionStateBroadCast(mContext, 0);
            }
        } else {
            noticeStateChanged(2);
        }
        if (i == 0 && this.mToDoListenersAfterLogin != null && this.mToDoListenersAfterLogin.size() > 0) {
            Iterator<TodoAfterLogin> it = this.mToDoListenersAfterLogin.iterator();
            while (it.hasNext()) {
                it.next().todo(z);
            }
        }
        if (i == 0) {
            ConversationManagerImpl.getInstance(mContext).init(getUid());
        }
    }

    public void onLogoutResult(String str, int i, String str2, int i2) {
        LogUtils.d(TAG, "onLogoutResult----errorCode: " + i + " msg: " + str2);
        Utility.writeLoginFlag(mContext, "5Y", "onLogoutResult errCode = " + i + ", errMsg :" + str2);
        if (i == 0) {
            noticeStateChanged(6);
            Utility.sendConnectionStateBroadCast(mContext, 1);
            if (i2 == 1) {
                Utility.clearAccessToken(mContext);
                Utility.clearCache(mContext);
            }
            LoginManager.getInstance(mContext).onLogoutResultInternal(i, str2);
        } else {
            noticeStateChanged(5);
        }
        ILoginListener iLoginListener = (ILoginListener) ListenerManager.getInstance().removeListener(str);
        if (iLoginListener != null) {
            iLoginListener.onLogoutResult(i, str2, BIMManager.getLoginType(mContext));
            return;
        }
        Utility.writeLoginFlag(mContext, "5N", "onLogoutResult listener is null");
        LogUtils.d(LogUtils.TAG, TAG + "mLoginListener is null");
    }

    public boolean isLogin() {
        return !TextUtils.isEmpty(getToken());
    }

    public boolean setEnv(Context context, int i) {
        return Constants.setEnv(context, i);
    }

    public void registerKillOutListener(IKickOutListener iKickOutListener) {
        this.mKickOutListener = iKickOutListener;
    }

    public void clearKillOutListener() {
    }

    public void registerToDoAfterLoginListener(TodoAfterLogin todoAfterLogin) {
        if (todoAfterLogin != null && !this.mToDoListenersAfterLogin.contains(todoAfterLogin)) {
            this.mToDoListenersAfterLogin.add(todoAfterLogin);
        }
    }

    public void disconnect(String str) {
        try {
            Intent intent = new Intent(mContext, a.class);
            intent.putExtra(Constants.EXTRA_LISTENER_ID, str);
            intent.putExtra(Constants.EXTRA_DISCONNECT, "1");
            intent.setPackage(mContext.getPackageName());
            a.ao(mContext).e(mContext, intent);
        } catch (Exception e) {
            LogUtils.e(TAG, LogConfig.DISCONNECT, e);
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener != null && (removeListener instanceof ILoginListener)) {
                ((ILoginListener) removeListener).onLogoutResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, BIMManager.getLoginType(mContext));
            }
        }
    }

    public void registerToDoBeforeLogoutListener(TodoBeforeLogout todoBeforeLogout) {
        if (todoBeforeLogout != null && !this.mToDoListenersBeforeLogout.contains(todoBeforeLogout)) {
            this.mToDoListenersBeforeLogout.add(todoBeforeLogout);
        }
    }

    public void getTokenByCuid(final long j, final String str, IGetTokenByCuidListener iGetTokenByCuidListener) {
        if (TextUtils.isEmpty(str) || j == -1) {
            iGetTokenByCuidListener.onGetTokenByCuidResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        }
        LogUtils.d(TAG, "getTokenByCuid----appid: " + j + " cuid: " + str);
        final String addListener = ListenerManager.getInstance().addListener(iGetTokenByCuidListener);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.mTimer = new Timer();
        try {
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    AccountManagerImpl.this.getTokenByCuid(j, str, addListener);
                }
            }, Utility.getPeakDelayTime());
        } catch (Exception e) {
            LogUtils.e(TAG, "getTokenByCuid Exception", e);
            getTokenByCuid(j, str, addListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTokenByCuid(long j, String str, String str2) {
        IMGetTokenByCuidRequest iMGetTokenByCuidRequest = new IMGetTokenByCuidRequest(mContext, j, str, str2);
        HttpHelper.executor(mContext, iMGetTokenByCuidRequest, iMGetTokenByCuidRequest);
    }

    public void onGetTokenByCuidResult(String str, int i, String str2, String str3) {
        LogUtils.d(TAG, "onGetTokenByCuidResult----errorCode: " + i + " msg: " + str2);
        IGetTokenByCuidListener iGetTokenByCuidListener = (IGetTokenByCuidListener) ListenerManager.getInstance().removeListener(str);
        if (iGetTokenByCuidListener != null) {
            iGetTokenByCuidListener.onGetTokenByCuidResult(i, str2, str3);
            return;
        }
        Utility.writeLoginFlag(mContext, "3N", "onGetTokenByCuidResult listener is null");
        LogUtils.d(TAG, "onGetTokenByCuidResult> listener is null");
    }

    public void getUidByUk(long[] jArr, IGetUidByUkListener iGetUidByUkListener) {
        if (jArr == null || jArr.length == 0) {
            iGetUidByUkListener.onGetUidByUkResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, jArr, null);
        }
        IMGetUidByUkRequest iMGetUidByUkRequest = new IMGetUidByUkRequest(mContext, jArr, ListenerManager.getInstance().addListener(iGetUidByUkListener));
        HttpHelper.executor(mContext, iMGetUidByUkRequest, iMGetUidByUkRequest);
    }

    public void onGetUidByUkResult(String str, int i, String str2, long[] jArr, Map<Long, Long> map) {
        LogUtils.d(TAG, "onGetUidByUkResult----errorCode: " + i + " msg: " + str2);
        IGetUidByUkListener iGetUidByUkListener = (IGetUidByUkListener) ListenerManager.getInstance().removeListener(str);
        if (iGetUidByUkListener != null) {
            iGetUidByUkListener.onGetUidByUkResult(i, str2, jArr, map);
        } else {
            LogUtils.d(TAG, "onGetUidByUkResult is null");
        }
    }

    public void setZhidaAppid(long j, String str, ISwitchZhidaListener iSwitchZhidaListener) {
        long readLongData = Utility.readLongData(mContext, Constants.ZHIDA_SP_PRE + j, -1L);
        if (readLongData != -1) {
            Utility.setPaid(mContext, readLongData);
            iSwitchZhidaListener.onSwitchZhidaResult(0, Constants.ERROR_MSG_SUCCESS);
            return;
        }
        IMGetPaidByAppidRequest iMGetPaidByAppidRequest = new IMGetPaidByAppidRequest(mContext, j, str, ListenerManager.getInstance().addListener(iSwitchZhidaListener));
        HttpHelper.executor(mContext, iMGetPaidByAppidRequest, iMGetPaidByAppidRequest);
    }

    public void setNotifyPaid(long j) {
        Utility.setNotifyPaid(mContext, j);
    }

    public void onSetZhidaAppidResult(String str, int i, String str2, long j, long j2) {
        LogUtils.d(TAG, String.format("onSetZhidaAppidResult errorCode=%d,appid=%d,paid=%d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)));
        if (i == 0) {
            Utility.writeLongData(mContext, Constants.ZHIDA_SP_PRE + j, j2);
            Utility.setPaid(mContext, j2);
        }
        ISwitchZhidaListener iSwitchZhidaListener = (ISwitchZhidaListener) ListenerManager.getInstance().removeListener(str);
        if (iSwitchZhidaListener != null) {
            iSwitchZhidaListener.onSwitchZhidaResult(i, str2);
        } else {
            LogUtils.d(TAG, "onSetZhidaAppidResult is null");
        }
    }

    public long getZhidaAppid() {
        return Utility.getZhidaAppid(mContext);
    }

    public boolean stopService() {
        try {
            Intent intent = new Intent(mContext, a.class);
            intent.setPackage(mContext.getPackageName());
            intent.setAction(Constants.ACTION_STOP);
            a.ao(mContext).e(mContext, intent);
            return true;
        } catch (Exception e) {
            LogUtils.e(TAG, "Stop Service SecurityException");
            return true;
        }
    }

    public void setNotificationPrivacy(int i, ISetNotificationPrivacyListener iSetNotificationPrivacyListener) {
        IMUserSetPrivacyRequest iMUserSetPrivacyRequest = new IMUserSetPrivacyRequest(mContext, ListenerManager.getInstance().addListener(iSetNotificationPrivacyListener), AccountManager.getAppid(mContext), i);
        HttpHelper.executor(mContext, iMUserSetPrivacyRequest, iMUserSetPrivacyRequest);
    }

    public void onSetPrivacyResult(String str, int i, String str2, int i2) {
        LogUtils.d(TAG, "onSetPrivacyResult " + i + " " + str2 + " " + i2);
        ISetNotificationPrivacyListener iSetNotificationPrivacyListener = (ISetNotificationPrivacyListener) ListenerManager.getInstance().removeListener(str);
        if (iSetNotificationPrivacyListener != null) {
            iSetNotificationPrivacyListener.onResult(i, str2);
            if (i == 0) {
                Utility.writePrivate(mContext, i2);
                return;
            }
            return;
        }
        LogUtils.d(TAG, "ISetNotificationPrivacyListener is null");
    }

    public void onQueryPrivacyResult(int i, String str, int i2) {
        LogUtils.d(TAG, "onQueryPrivacyResult " + i + " " + str + " " + i2);
        if (i == 0) {
            Utility.writePrivate(mContext, i2);
        } else {
            LogUtils.e(TAG, "sync account privacy error " + i + " " + str);
        }
    }

    public void syncPrivacy() {
        IMUserQueryPrivacyRequest iMUserQueryPrivacyRequest = new IMUserQueryPrivacyRequest(mContext, AccountManager.getAppid(mContext));
        HttpHelper.executor(mContext, iMUserQueryPrivacyRequest, iMUserQueryPrivacyRequest);
    }

    public int getNotificationPrivacy(Context context) {
        return Utility.readPrivate(context);
    }

    public static void tryConnection(Context context) {
        try {
            Intent intent = new Intent(mContext, a.class);
            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
            intent.setPackage(mContext.getPackageName());
            a.ao(context).e(mContext, intent);
        } catch (Exception e) {
            LogUtils.e(TAG, "tryConnection failed......");
        }
    }

    public String getExtraSafeParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("zid", getZid());
            jSONObject.put("version_code", getVersionCode());
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
        }
        return jSONObject.toString();
    }

    public int getLoginState() {
        return this.mLoginState;
    }

    public void setLogStateChangedListener(ILoginStateChangedListener iLoginStateChangedListener) {
        this.mILoginStateChangedListener = iLoginStateChangedListener;
    }

    private synchronized void noticeStateChanged(int i) {
        this.mLoginState = i;
        if (this.mILoginStateChangedListener != null) {
            this.mILoginStateChangedListener.onLoginStateChanged(this.mLoginState);
        }
    }

    public void pushReStartWork() {
        LogUtils.d(TAG, "in pushReStartWork---");
        TaskManager.getInstance(mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.d(AccountManagerImpl.TAG, "will do pushReStartWork---");
                try {
                    PushManager.reStartWork(AccountManagerImpl.mContext);
                } catch (Throwable th) {
                    LogUtils.d(AccountManagerImpl.TAG, "pushReStartWork---ERROR---" + th.getMessage());
                    new IMTrack.CrashBuilder(AccountManagerImpl.mContext).exception(Log.getStackTraceString(th)).build();
                }
            }
        });
    }

    public void setAppOpenType(int i) {
        this.mOpenType = i;
    }

    public int getAppOpenType() {
        return this.mOpenType;
    }

    public void setUpdateSwitch(int i) {
        switch (i) {
            case 1:
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, false);
                return;
            case 2:
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, false);
                return;
            case 3:
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, false);
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, false);
                return;
            default:
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, true);
                Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, true);
                return;
        }
    }

    public void setMediaRole(boolean z) {
        this.isMediaRole = z;
    }

    public boolean getMediaRole() {
        return this.isMediaRole;
    }

    public void getMsgSettingSwitchStatus(IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        if (iGetMsgSettingSwitchListener != null) {
            if (isLogin()) {
                IMGetMsgSettingSwitchRequest iMGetMsgSettingSwitchRequest = new IMGetMsgSettingSwitchRequest(mContext, iGetMsgSettingSwitchListener);
                HttpHelper.executor(mContext, iMGetMsgSettingSwitchRequest, iMGetMsgSettingSwitchRequest);
                return;
            }
            iGetMsgSettingSwitchListener.onGetMsgSettingSwitch(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, 0, 0);
        }
    }

    public void setMsgSettingSwitchStatus(int i, int i2, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        if (iSetMsgSettingSwitchListener != null) {
            if (isLogin()) {
                IMSetMsgSettingSwitchRequest iMSetMsgSettingSwitchRequest = new IMSetMsgSettingSwitchRequest(mContext, i, i2, iSetMsgSettingSwitchListener);
                HttpHelper.executor(mContext, iMSetMsgSettingSwitchRequest, iMSetMsgSettingSwitchRequest);
                return;
            }
            iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
        }
    }
}
