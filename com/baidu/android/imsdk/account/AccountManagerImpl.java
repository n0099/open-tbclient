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
import d.a.r.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AccountManagerImpl {
    public static final String TAG = "AccountManagerImpl";
    public static Context mContext;
    public static int mCuidTokenTryTimes;
    public static volatile AccountManagerImpl mInstance;
    public String mAppVersion;
    public long mAppid;
    public ILoginStateChangedListener mILoginStateChangedListener;
    public IKickOutListener mKickOutListener;
    public String mToken;
    public String mUid = "";
    public CopyOnWriteArrayList<TodoAfterLogin> mToDoListenersAfterLogin = new CopyOnWriteArrayList<>();
    public ArrayList<TodoBeforeLogout> mToDoListenersBeforeLogout = new ArrayList<>();
    public int mLoginType = -1;
    public String mCuid = null;
    public String mFrom = "";
    public String mCFrom = "";
    public String mZid = "";
    public String mVersionCode = "";
    public int mLoginState = 0;
    public Timer mTimer = null;
    public int mOpenType = 0;
    public boolean isMediaRole = false;

    public AccountManagerImpl() {
        this.mAppid = -1L;
        this.mAppid = Utility.getAppId(mContext);
        Class<?>[] clsArr = {IMUserLoginByTokenMsg.class, IMUserLogoutMsg.class};
        int[] iArr = {50, 52};
        for (int i2 = 0; i2 < 2; i2++) {
            MessageFactory.getInstance().addType(iArr[i2], clsArr[i2]);
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

    private synchronized void noticeStateChanged(int i2) {
        this.mLoginState = i2;
        if (this.mILoginStateChangedListener != null) {
            this.mILoginStateChangedListener.onLoginStateChanged(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoginService(int i2, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        boolean loginInternal = LoginManager.getInstance(mContext).loginInternal(iLoginListener);
        String str5 = TAG;
        LogUtils.d(str5, "startLoginService isNeedLogin: " + loginInternal);
        Context context = mContext;
        Utility.writeLoginFlag(context, "6N", "startLoginService isNeedLogin :" + loginInternal);
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
            if (i2 == 1 && !TextUtils.isEmpty(str)) {
                setUid(str);
            }
            getInstance(mContext).setLoginType(i2);
            this.mToken = str2;
            Utility.writeAccessToken(mContext, str2);
            try {
                a.e(mContext).d(mContext, creatMethodIntent);
                Utility.writeLoginFlag(mContext, "6Y", "startLoginService");
            } catch (Exception e2) {
                Utility.writeLoginFlag(mContext, "6N_1", "startLoginService exception");
                LogUtils.e(TAG, "startService", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startLoginServiceRunnable(final int i2, final String str, final String str2, final String str3, final String str4, final ILoginListener iLoginListener) {
        boolean z;
        LogUtils.d(TAG, "*** startLoginServiceRunnable will start ***");
        String token = getToken();
        if (i2 != 6 && !TextUtils.isEmpty(token)) {
            if (!str2.equals(token)) {
                z = true;
                Context context = mContext;
                Utility.writeLoginFlag(context, "5N", "startLoginServiceRunnable begin, loginType = " + i2 + "，needLogout :" + z);
                if (!z) {
                    LogUtils.d(TAG, "need logout before login");
                    if (a.f64518e) {
                        BIMManager.imLogoutByLcp(mContext);
                        startLoginService(i2, str, str2, str3, str4, iLoginListener);
                        return;
                    }
                    LoginManager.getInstance(mContext).logoutInternal(null);
                    Utility.clearCache(mContext);
                    logout(0, new ILoginListener() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.3
                        @Override // com.baidu.android.imsdk.account.ILoginListener
                        public void onLoginResult(int i3, String str5) {
                        }

                        @Override // com.baidu.android.imsdk.account.ILoginListener
                        public void onLogoutResult(int i3, String str5, int i4) {
                            LogUtils.d(AccountManagerImpl.TAG, "logout onLogoutResult");
                            AccountManagerImpl.this.disconnect(ListenerManager.getInstance().addListener(new ILoginListener() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.3.1
                                @Override // com.baidu.android.imsdk.account.ILoginListener
                                public void onLoginResult(int i5, String str6) {
                                }

                                @Override // com.baidu.android.imsdk.account.ILoginListener
                                public void onLogoutResult(int i5, String str6, int i6) {
                                    LogUtils.d(AccountManagerImpl.TAG, "disconnect onLogoutResult");
                                    Utility.writeLoginFlag(AccountManagerImpl.mContext, "5Y", "Logout and disconnect success");
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    AccountManagerImpl.this.startLoginService(i2, str, str2, str3, str4, iLoginListener);
                                }
                            }));
                        }
                    });
                    return;
                }
                startLoginService(i2, str, str2, str3, str4, iLoginListener);
                return;
            }
        }
        z = false;
        Context context2 = mContext;
        Utility.writeLoginFlag(context2, "5N", "startLoginServiceRunnable begin, loginType = " + i2 + "，needLogout :" + z);
        if (!z) {
        }
    }

    public static void tryConnection(Context context) {
        try {
            Intent intent = new Intent(mContext, a.class);
            intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
            intent.setPackage(mContext.getPackageName());
            a.e(context).d(mContext, intent);
        } catch (Exception unused) {
            LogUtils.e(TAG, "tryConnection failed......");
        }
    }

    public void clearKillOutListener() {
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

    public boolean clearToken(String str) {
        boolean clearAccessToken = Utility.clearAccessToken(mContext);
        if (clearAccessToken) {
            Utility.clearCache(mContext);
            this.mToken = null;
        }
        if (!a.f64518e) {
            clearLoginParam(mContext);
            clearUid(mContext);
            disconnect(str);
        } else if (!TextUtils.isEmpty(str)) {
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener instanceof ILoginListener) {
                ILoginListener iLoginListener = (ILoginListener) removeListener;
                LoginManager.getInstance(mContext).logoutInternal(iLoginListener);
                iLoginListener.onLogoutResult(0, "logout success", getInstance(mContext).getLoginType());
            }
        }
        return clearAccessToken;
    }

    public boolean clearUid(Context context) {
        boolean removeKey = Utility.removeKey(mContext, Constants.KEY_PASSPORT_UID);
        if (removeKey) {
            this.mUid = "";
        }
        return removeKey;
    }

    public void disconnect(String str) {
        try {
            Intent intent = new Intent(mContext, a.class);
            intent.putExtra(Constants.EXTRA_LISTENER_ID, str);
            intent.putExtra(Constants.EXTRA_DISCONNECT, "1");
            intent.setPackage(mContext.getPackageName());
            a.e(mContext).d(mContext, intent);
        } catch (Exception e2) {
            LogUtils.e(TAG, "disconnect", e2);
            IMListener removeListener = ListenerManager.getInstance().removeListener(str);
            if (removeListener == null || !(removeListener instanceof ILoginListener)) {
                return;
            }
            ((ILoginListener) removeListener).onLogoutResult(1003, Constants.ERROR_MSG_SERVICE_ERROR, BIMManager.getLoginType(mContext));
        }
    }

    public int getAppOpenType() {
        return this.mOpenType;
    }

    public String getAppVersion() {
        if (TextUtils.isEmpty(this.mAppVersion)) {
            return Utility.readStringData(mContext, Constants.KEY_PRODUCT_VERSION, "0");
        }
        return this.mAppVersion;
    }

    public long getAppid() {
        long j = this.mAppid;
        return j == -1 ? Utility.readAppId(mContext) : j;
    }

    public String getCuid() {
        String str = this.mCuid;
        if (str != null) {
            return str;
        }
        String readCuid = Utility.readCuid(mContext);
        this.mCuid = readCuid;
        return readCuid;
    }

    public String getExtraSafeParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("zid", getZid());
            jSONObject.put("version_code", getVersionCode());
        } catch (Exception e2) {
            LogUtils.e(TAG, "Exception ", e2);
            new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
        }
        return jSONObject.toString();
    }

    public String getFrom() {
        String str = this.mFrom;
        return TextUtils.isEmpty(str) ? Utility.getLoginFrom(mContext) : str;
    }

    public int getLoginState() {
        return this.mLoginState;
    }

    public int getLoginType() {
        int i2 = this.mLoginType;
        if (i2 != -1) {
            return i2;
        }
        int readLoginType = Utility.readLoginType(mContext);
        this.mLoginType = readLoginType;
        return readLoginType;
    }

    public boolean getMediaRole() {
        return this.isMediaRole;
    }

    public void getMsgSettingSwitchStatus(IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        if (iGetMsgSettingSwitchListener == null) {
            return;
        }
        if (isLogin()) {
            IMGetMsgSettingSwitchRequest iMGetMsgSettingSwitchRequest = new IMGetMsgSettingSwitchRequest(mContext, iGetMsgSettingSwitchListener);
            HttpHelper.executor(mContext, iMGetMsgSettingSwitchRequest, iMGetMsgSettingSwitchRequest);
            return;
        }
        iGetMsgSettingSwitchListener.onGetMsgSettingSwitch(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, 0, 0);
    }

    public int getNotificationPrivacy(Context context) {
        return Utility.readPrivate(context);
    }

    public String getToken() {
        String str = this.mToken;
        return TextUtils.isEmpty(str) ? Utility.getAccessToken(mContext) : str;
    }

    public void getTokenByCuid(final long j, final String str, IGetTokenByCuidListener iGetTokenByCuidListener) {
        if (TextUtils.isEmpty(str) || j == -1) {
            iGetTokenByCuidListener.onGetTokenByCuidResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        }
        String str2 = TAG;
        LogUtils.d(str2, "getTokenByCuid----appid: " + j + " cuid: " + str);
        final String addListener = ListenerManager.getInstance().addListener(iGetTokenByCuidListener);
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        Timer timer2 = new Timer();
        this.mTimer = timer2;
        try {
            timer2.schedule(new TimerTask() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    AccountManagerImpl.this.getTokenByCuid(j, str, addListener);
                }
            }, Utility.getPeakDelayTime());
        } catch (Exception e2) {
            LogUtils.e(TAG, "getTokenByCuid Exception", e2);
            getTokenByCuid(j, str, addListener);
        }
    }

    public long getUK() {
        if (isLogin()) {
            return Utility.getUK(mContext);
        }
        return 0L;
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

    public void getUidByUk(long[] jArr, IGetUidByUkListener iGetUidByUkListener) {
        if (jArr == null || jArr.length == 0) {
            iGetUidByUkListener.onGetUidByUkResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, jArr, null);
        }
        IMGetUidByUkRequest iMGetUidByUkRequest = new IMGetUidByUkRequest(mContext, jArr, ListenerManager.getInstance().addListener(iGetUidByUkListener));
        HttpHelper.executor(mContext, iMGetUidByUkRequest, iMGetUidByUkRequest);
    }

    public String getVersionCode() {
        String str = this.mVersionCode;
        return TextUtils.isEmpty(str) ? Utility.readStringData(mContext, Constants.KEY_VCODE, "") : str;
    }

    public long getZhidaAppid() {
        return Utility.getZhidaAppid(mContext);
    }

    public String getZid() {
        String str = this.mZid;
        return TextUtils.isEmpty(str) ? Utility.readStringData(mContext, Constants.KEY_ZID, "") : str;
    }

    public String getcFrom() {
        String str = this.mCFrom;
        return TextUtils.isEmpty(str) ? Utility.getLoginCFrom(mContext) : str;
    }

    public boolean isLogin() {
        return !TextUtils.isEmpty(getToken());
    }

    public void login(final int i2, final String str, final String str2, final String str3, final String str4, final ILoginListener iLoginListener) {
        if (str2 == null) {
            onLoginResult("", 1005, Constants.ERROR_MSG_PARAMETER_ERROR, false);
            return;
        }
        LogUtils.d(TAG, "login type :" + i2);
        LogUtils.d(TAG, "start login loginState:" + LoginManager.getInstance(mContext).getCurrentState());
        LogUtils.d(TAG, "current version:" + IMConfigInternal.getInstance().getSDKVersionValue(mContext) + " " + IMConfigInternal.getInstance().getSDKVersionValue(mContext));
        Utility.writeLoginFlag(mContext, "5N_1", "login begin");
        ConversationStudioManImpl.getInstance(mContext);
        ConversationStudioManImpl.resetHeartBeat(60000);
        if (Utility.isPeakTime()) {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
            }
            this.mTimer = new Timer();
            long nextInt = (new Random().nextInt(Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID) + 10) * 1000;
            LogUtils.d(TAG, "*** peak time! login will delay " + nextInt + " ms ***");
            try {
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        AccountManagerImpl.this.startLoginServiceRunnable(i2, str, str2, str3, str4, iLoginListener);
                    }
                }, nextInt);
                return;
            } catch (Exception e2) {
                LogUtils.e(TAG, "timer exception", e2);
                startLoginServiceRunnable(i2, str, str2, str3, str4, iLoginListener);
                return;
            }
        }
        Utility.writeLoginFlag(mContext, "5N_2", "startLoginServiceRunnable");
        if (TaskManager.getInstance(mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.account.AccountManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AccountManagerImpl.this.startLoginServiceRunnable(i2, str, str2, str3, str4, iLoginListener);
            }
        })) {
            return;
        }
        startLoginServiceRunnable(i2, str, str2, str3, str4, iLoginListener);
    }

    public void logout(int i2, ILoginListener iLoginListener) {
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
            creatMethodIntent.putExtra(Constants.EXTRA_CLEAR_AFTER_LOGOUT, i2);
            try {
                a.e(mContext).d(mContext, creatMethodIntent);
                return;
            } catch (Exception e2) {
                LogUtils.e(TAG, "Exception ", e2);
                onLogoutResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, i2);
                return;
            }
        }
        onLogoutResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, i2);
    }

    public void onGetTokenByCuidResult(String str, int i2, String str2, String str3) {
        String str4 = TAG;
        LogUtils.d(str4, "onGetTokenByCuidResult----errorCode: " + i2 + " msg: " + str2);
        IGetTokenByCuidListener iGetTokenByCuidListener = (IGetTokenByCuidListener) ListenerManager.getInstance().removeListener(str);
        if (iGetTokenByCuidListener != null) {
            iGetTokenByCuidListener.onGetTokenByCuidResult(i2, str2, str3);
            return;
        }
        Utility.writeLoginFlag(mContext, "3N", "onGetTokenByCuidResult listener is null");
        LogUtils.d(TAG, "onGetTokenByCuidResult> listener is null");
    }

    public void onGetUidByUkResult(String str, int i2, String str2, long[] jArr, Map<Long, Long> map) {
        String str3 = TAG;
        LogUtils.d(str3, "onGetUidByUkResult----errorCode: " + i2 + " msg: " + str2);
        IGetUidByUkListener iGetUidByUkListener = (IGetUidByUkListener) ListenerManager.getInstance().removeListener(str);
        if (iGetUidByUkListener != null) {
            iGetUidByUkListener.onGetUidByUkResult(i2, str2, jArr, map);
        } else {
            LogUtils.d(TAG, "onGetUidByUkResult is null");
        }
    }

    public void onLoginResult(String str, int i2, String str2, boolean z) {
        CopyOnWriteArrayList<TodoAfterLogin> copyOnWriteArrayList;
        String str3 = TAG;
        LogUtils.d(str3, "onLoginResult----errorCode: " + i2 + " msg: " + str2);
        LoginManager.getInstance(mContext).onLoginResultInternal(i2, str2);
        if (i2 == 0) {
            ConversationStudioManImpl.getInstance(mContext).clear();
            ConversationStudioManImpl.getInstance(mContext).clearAckCastList();
            noticeStateChanged(3);
            BIMManager.connectStatusNotify(0);
            if (!a.f64518e) {
                Utility.sendConnectionStateBroadCast(mContext, 0);
            }
        } else {
            noticeStateChanged(2);
        }
        if (i2 == 0 && (copyOnWriteArrayList = this.mToDoListenersAfterLogin) != null && copyOnWriteArrayList.size() > 0) {
            Iterator<TodoAfterLogin> it = this.mToDoListenersAfterLogin.iterator();
            while (it.hasNext()) {
                it.next().todo(z);
            }
        }
        if (i2 == 0) {
            ConversationManagerImpl.getInstance(mContext).init(getUid());
        }
    }

    public void onLogoutResult(String str, int i2, String str2, int i3) {
        String str3 = TAG;
        LogUtils.d(str3, "onLogoutResult----errorCode: " + i2 + " msg: " + str2);
        Context context = mContext;
        Utility.writeLoginFlag(context, "5Y", "onLogoutResult errCode = " + i2 + ", errMsg :" + str2);
        if (i2 == 0) {
            noticeStateChanged(6);
            Utility.sendConnectionStateBroadCast(mContext, 1);
            if (i3 == 1) {
                Utility.clearAccessToken(mContext);
                Utility.clearCache(mContext);
            }
            LoginManager.getInstance(mContext).onLogoutResultInternal(i2, str2);
        } else {
            noticeStateChanged(5);
        }
        ILoginListener iLoginListener = (ILoginListener) ListenerManager.getInstance().removeListener(str);
        if (iLoginListener != null) {
            iLoginListener.onLogoutResult(i2, str2, BIMManager.getLoginType(mContext));
            return;
        }
        Utility.writeLoginFlag(mContext, "5N", "onLogoutResult listener is null");
        String str4 = LogUtils.TAG;
        LogUtils.d(str4, TAG + "mLoginListener is null");
    }

    public void onQueryPrivacyResult(int i2, String str, int i3) {
        String str2 = TAG;
        LogUtils.d(str2, "onQueryPrivacyResult " + i2 + " " + str + " " + i3);
        if (i2 == 0) {
            Utility.writePrivate(mContext, i3);
            return;
        }
        String str3 = TAG;
        LogUtils.e(str3, "sync account privacy error " + i2 + " " + str);
    }

    public void onSetPrivacyResult(String str, int i2, String str2, int i3) {
        String str3 = TAG;
        LogUtils.d(str3, "onSetPrivacyResult " + i2 + " " + str2 + " " + i3);
        ISetNotificationPrivacyListener iSetNotificationPrivacyListener = (ISetNotificationPrivacyListener) ListenerManager.getInstance().removeListener(str);
        if (iSetNotificationPrivacyListener != null) {
            iSetNotificationPrivacyListener.onResult(i2, str2);
            if (i2 == 0) {
                Utility.writePrivate(mContext, i3);
                return;
            }
            return;
        }
        LogUtils.d(TAG, "ISetNotificationPrivacyListener is null");
    }

    public void onSetZhidaAppidResult(String str, int i2, String str2, long j, long j2) {
        LogUtils.d(TAG, String.format("onSetZhidaAppidResult errorCode=%d,appid=%d,paid=%d", Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)));
        if (i2 == 0) {
            Context context = mContext;
            Utility.writeLongData(context, Constants.ZHIDA_SP_PRE + j, j2);
            Utility.setPaid(mContext, j2);
        }
        ISwitchZhidaListener iSwitchZhidaListener = (ISwitchZhidaListener) ListenerManager.getInstance().removeListener(str);
        if (iSwitchZhidaListener != null) {
            iSwitchZhidaListener.onSwitchZhidaResult(i2, str2);
        } else {
            LogUtils.d(TAG, "onSetZhidaAppidResult is null");
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
                    String str = AccountManagerImpl.TAG;
                    LogUtils.d(str, "pushReStartWork---ERROR---" + th.getMessage());
                    new IMTrack.CrashBuilder(AccountManagerImpl.mContext).exception(Log.getStackTraceString(th)).build();
                }
            }
        });
    }

    public void registerKillOutListener(IKickOutListener iKickOutListener) {
        this.mKickOutListener = iKickOutListener;
    }

    public void registerToDoAfterLoginListener(TodoAfterLogin todoAfterLogin) {
        if (todoAfterLogin == null || this.mToDoListenersAfterLogin.contains(todoAfterLogin)) {
            return;
        }
        this.mToDoListenersAfterLogin.add(todoAfterLogin);
    }

    public void registerToDoBeforeLogoutListener(TodoBeforeLogout todoBeforeLogout) {
        if (todoBeforeLogout == null || this.mToDoListenersBeforeLogout.contains(todoBeforeLogout)) {
            return;
        }
        this.mToDoListenersBeforeLogout.add(todoBeforeLogout);
    }

    public void setAppOpenType(int i2) {
        this.mOpenType = i2;
    }

    public void setAppVersion(String str) {
        this.mAppVersion = str;
        Utility.writeStringData(mContext, Constants.KEY_PRODUCT_VERSION, str);
    }

    public boolean setAppid(long j) {
        this.mAppid = j;
        Utility.writeAppId(mContext, j);
        return true;
    }

    public void setCuid(String str) {
        this.mCuid = str;
        Utility.writeCuid(mContext, str);
    }

    public boolean setEnv(Context context, int i2) {
        return Constants.setEnv(context, i2);
    }

    public void setLogStateChangedListener(ILoginStateChangedListener iLoginStateChangedListener) {
        this.mILoginStateChangedListener = iLoginStateChangedListener;
    }

    public void setLoginType(int i2) {
        this.mLoginType = i2;
        Utility.writeLoginType(mContext, i2);
    }

    public void setMediaRole(boolean z) {
        this.isMediaRole = z;
    }

    public void setMsgSettingSwitchStatus(int i2, int i3, ISetMsgSettingSwitchListener iSetMsgSettingSwitchListener) {
        if (iSetMsgSettingSwitchListener == null) {
            return;
        }
        if (isLogin()) {
            IMSetMsgSettingSwitchRequest iMSetMsgSettingSwitchRequest = new IMSetMsgSettingSwitchRequest(mContext, i2, i3, iSetMsgSettingSwitchListener);
            HttpHelper.executor(mContext, iMSetMsgSettingSwitchRequest, iMSetMsgSettingSwitchRequest);
            return;
        }
        iSetMsgSettingSwitchListener.onSetMsgSettingSwitch(1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
    }

    public void setNotificationPrivacy(int i2, ISetNotificationPrivacyListener iSetNotificationPrivacyListener) {
        IMUserSetPrivacyRequest iMUserSetPrivacyRequest = new IMUserSetPrivacyRequest(mContext, ListenerManager.getInstance().addListener(iSetNotificationPrivacyListener), AccountManager.getAppid(mContext), i2);
        HttpHelper.executor(mContext, iMUserSetPrivacyRequest, iMUserSetPrivacyRequest);
    }

    public void setNotifyPaid(long j) {
        Utility.setNotifyPaid(mContext, j);
    }

    public boolean setUid(String str) {
        if (str != null) {
            this.mUid = str;
            Utility.writeUid(mContext, str);
        }
        return str != null;
    }

    public void setUpdateSwitch(int i2) {
        if (i2 == 1) {
            Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, false);
        } else if (i2 == 2) {
            Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, false);
        } else if (i2 != 3) {
            Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, true);
            Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, true);
        } else {
            Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_USER, false);
            Utility.writeBooleanData(mContext, Constants.KEY_UPDATE_SWITCH_PA, false);
        }
    }

    public void setVersionCode(String str) {
        this.mVersionCode = str;
        Utility.writeVersionCode(mContext, str);
    }

    public void setZhidaAppid(long j, String str, ISwitchZhidaListener iSwitchZhidaListener) {
        Context context = mContext;
        long readLongData = Utility.readLongData(context, Constants.ZHIDA_SP_PRE + j, -1L);
        if (readLongData != -1) {
            Utility.setPaid(mContext, readLongData);
            iSwitchZhidaListener.onSwitchZhidaResult(0, Constants.ERROR_MSG_SUCCESS);
            return;
        }
        IMGetPaidByAppidRequest iMGetPaidByAppidRequest = new IMGetPaidByAppidRequest(mContext, j, str, ListenerManager.getInstance().addListener(iSwitchZhidaListener));
        HttpHelper.executor(mContext, iMGetPaidByAppidRequest, iMGetPaidByAppidRequest);
    }

    public void setZid(String str) {
        this.mZid = str;
        Utility.writeZid(mContext, str);
    }

    public boolean stopService() {
        try {
            Intent intent = new Intent(mContext, a.class);
            intent.setPackage(mContext.getPackageName());
            intent.setAction(Constants.ACTION_STOP);
            a.e(mContext).d(mContext, intent);
            return true;
        } catch (Exception unused) {
            LogUtils.e(TAG, "Stop Service SecurityException");
            return true;
        }
    }

    public void syncPrivacy() {
        IMUserQueryPrivacyRequest iMUserQueryPrivacyRequest = new IMUserQueryPrivacyRequest(mContext, AccountManager.getAppid(mContext));
        HttpHelper.executor(mContext, iMUserQueryPrivacyRequest, iMUserQueryPrivacyRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTokenByCuid(long j, String str, String str2) {
        IMGetTokenByCuidRequest iMGetTokenByCuidRequest = new IMGetTokenByCuidRequest(mContext, j, str, str2);
        HttpHelper.executor(mContext, iMGetTokenByCuidRequest, iMGetTokenByCuidRequest);
    }
}
