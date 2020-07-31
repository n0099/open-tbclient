package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.TidConvertSidCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public final class SapiAccountManager implements ISAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 242;
    public static final String VERSION_NAME = "8.9.5.6";
    private static final String a = "SapiAccountManager";
    private static SapiAccountManager b;
    private static SapiConfiguration c;
    private static SapiAccountService d;
    private static ServiceManager e;
    private static SilentShareListener f;
    private static ReceiveShareListener g;
    private static GlobalAuthorizationListener h;
    private static CheckUrlIsAvailableListener i;
    private static TidConvertSidCallback j;
    private static final List<String> k = new ArrayList();
    private char l = 0;

    /* loaded from: classes19.dex */
    public interface CheckUrlIsAvailableListener {
        void handleWebPageUrl(String str);

        boolean onCheckUrlIsAvailable(String str);
    }

    /* loaded from: classes19.dex */
    public static abstract class GlobalAuthorizationListener {
        public void onLogoutSuccess(SapiAccount sapiAccount) {
        }
    }

    /* loaded from: classes19.dex */
    public interface ReceiveShareListener {
        void onReceiveShare();
    }

    /* loaded from: classes19.dex */
    public interface SilentShareListener {
        void onSilentShare();
    }

    static {
        k.add("uid");
        k.add(SESSION_DISPLAYNAME);
        k.add("bduss");
    }

    private SapiAccountManager() {
    }

    private void b(String str) {
        if (!SapiUtils.isDebug(c.context) && !c.debug) {
            Log.e(str, new Object[0]);
            return;
        }
        throw new RuntimeException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            Class.forName("com.baidu.sofire.ac.FH");
        } catch (Exception e2) {
            b("please import the package : sofire-sdk-*.jar");
        }
        if (c.supportFaceLogin) {
            try {
                Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
            } catch (Throwable th) {
                b("please import the package :pass-biometrics-face-*.aar and pass-biometrics-base-*.aar");
            }
        }
        if (c.loginShareStrategy() == LoginShareStrategy.DISABLED || getReceiveShareListener() != null) {
            return;
        }
        throw new RuntimeException("please registerReceiveShareListener to support share login function");
    }

    public static CheckUrlIsAvailableListener getCheckUrlIsAvailablelister() {
        return i;
    }

    public static GlobalAuthorizationListener getGlobalAuthorizationListener() {
        return h;
    }

    public static synchronized SapiAccountManager getInstance() {
        SapiAccountManager sapiAccountManager;
        synchronized (SapiAccountManager.class) {
            if (b == null) {
                b = new SapiAccountManager();
            }
            sapiAccountManager = b;
        }
        return sapiAccountManager;
    }

    public static ReceiveShareListener getReceiveShareListener() {
        return g;
    }

    public static SilentShareListener getSilentShareListener() {
        return f;
    }

    public static TidConvertSidCallback getTidConvertSidCallback() {
        return j;
    }

    public static void registerCheckUrlIsAvailableListener(CheckUrlIsAvailableListener checkUrlIsAvailableListener) {
        i = checkUrlIsAvailableListener;
    }

    public static void registerGlobalAuthorizationListener(GlobalAuthorizationListener globalAuthorizationListener) {
        h = globalAuthorizationListener;
    }

    public static void registerReceiveShareListener(ReceiveShareListener receiveShareListener) {
        g = receiveShareListener;
    }

    public static void registerSilentShareListener(SilentShareListener silentShareListener) {
        f = silentShareListener;
    }

    public static void setTidConvertSidCallback(TidConvertSidCallback tidConvertSidCallback) {
        j = tidConvertSidCallback;
    }

    public static void unregisterCheckUrlIsAvailableListener() {
        i = null;
    }

    public static void unregisterGlobalAuthorizationListener() {
        h = null;
    }

    public static void unregisterReceiveShareListener() {
        g = null;
    }

    public static void unregisterSilentShareListener() {
        f = null;
    }

    public SapiAccount getAccountByOpenid(String str) {
        String str2 = SapiUtils.urlParamsToMap(SapiContext.getInstance().getString(SapiContext.KEY_OPENID_UID_LIST)).get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        List<SapiAccount> loginAccounts = getLoginAccounts();
        loginAccounts.addAll(getShareAccounts());
        for (SapiAccount sapiAccount : loginAccounts) {
            if (str2.equals(sapiAccount.uid)) {
                SapiContext.getInstance().setCurrentAccount(sapiAccount);
                return sapiAccount;
            }
        }
        return null;
    }

    public SapiAccountService getAccountService() {
        b();
        return d;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiConfiguration getConfignation() {
        return c;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getCurrentZid(Context context) {
        return SapiSafeFacade.a().getCurrentZid(context);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public com.baidu.sapi2.service.interfaces.a getIsAccountService() {
        return getAccountService();
    }

    public List<SapiAccount> getLoginAccounts() {
        b();
        return SapiContext.getInstance().getLoginAccounts();
    }

    public void getOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback) {
        if (oneKeyLoginCallback == null) {
            Log.e(a, "When check oneKeyLogin's ability, oneKeyLoginCallback can't be null!");
        } else if (Build.VERSION.SDK_INT < 19) {
            new com.baidu.sapi2.outsdk.c().b(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_ANDROID_VERSION_BELOW_KITKAT, null);
        } else if (new com.baidu.sapi2.outsdk.c().a()) {
            JSONObject b2 = new com.baidu.sapi2.outsdk.c().b();
            d.checkOneKeyLoginIsAvailable(oneKeyLoginCallback, b2 != null ? b2.optString("phone") : null);
        } else {
            new com.baidu.sapi2.outsdk.c().a(c, com.baidu.sapi2.outsdk.c.m, oneKeyLoginCallback);
        }
    }

    public SapiSafeFacade getSafeFacade() {
        b();
        return SapiSafeFacade.a();
    }

    public SapiConfiguration getSapiConfiguration() {
        b();
        return c;
    }

    public String getSession(String str, String str2) {
        JSONObject jSONObject;
        b();
        SapiAccount session = getSession();
        return (!a(str) || !isLogin() || session == null || (jSONObject = session.toJSONObject()) == null) ? str2 : jSONObject.optString(str, str2);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public List<SapiAccount> getShareAccounts() {
        b();
        ArrayList arrayList = new ArrayList();
        if (c.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            return arrayList;
        }
        for (SapiAccount sapiAccount : SapiContext.getInstance().getShareAccounts()) {
            if (SapiUtils.isValidAccount(sapiAccount)) {
                arrayList.add(sapiAccount);
            } else {
                SapiContext.getInstance().removeShareAccount(sapiAccount);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList() {
        return getV2ShareModelList("");
    }

    public int getVersionCode() {
        return 242;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getVersionName() {
        return VERSION_NAME;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getZidAndCheckSafe(Context context, String str, int i2) {
        return SapiSafeFacade.a().getZidAndCheckSafe(context, str, i2);
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration) {
        if (sapiConfiguration != null) {
            if (c == null) {
                c = sapiConfiguration;
                d = new SapiAccountService();
                e = ServiceManager.getInstance();
                e.setIsAccountManager(this);
                if (c(sapiConfiguration.context)) {
                    b.b().a((Application) sapiConfiguration.context);
                    ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z;
                            try {
                                SapiAccountManager.this.c();
                            } catch (RuntimeException e2) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        throw e2;
                                    }
                                });
                            }
                            SapiContext sapiContext = SapiContext.getInstance();
                            sapiContext.setShareStorage(null);
                            new com.baidu.sapi2.share.m().a(true);
                            SapiShareClient.getInstance().registerActivityLifecycleCallbacks(sapiConfiguration.context);
                            int versionCode = SapiUtils.getVersionCode(sapiConfiguration.context);
                            if (sapiConfiguration.silentShareOnUpgrade && versionCode > sapiContext.getAppVersionCode()) {
                                SapiUtils.resetSilentShareStatus();
                            }
                            if (versionCode > sapiContext.getAppVersionCode()) {
                                SapiUtils.webLogin(sapiConfiguration.context, SapiUtils.getCookieBduss(), "");
                            }
                            if (SapiAccountManager.VERSION_NAME.compareTo(sapiContext.getString(SapiContext.KEY_SDK_VERSION)) > 0) {
                                sapiContext.put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, false);
                            }
                            sapiContext.setAppVersionCode(versionCode);
                            sapiContext.put(SapiContext.KEY_SDK_VERSION, SapiAccountManager.VERSION_NAME);
                            SapiConfiguration sapiConfiguration2 = sapiConfiguration;
                            sapiConfiguration2.clientId = SapiUtils.getClientId(sapiConfiguration2.context);
                            sapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
                            SapiShareClient.syncShareAccounts();
                            List<String> k2 = X.k();
                            String packageName = sapiConfiguration.context.getPackageName();
                            Iterator<String> it = k2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = true;
                                    break;
                                } else if (packageName.matches(it.next())) {
                                    z = false;
                                    break;
                                }
                            }
                            if (z) {
                                new V().a(sapiConfiguration.context);
                            }
                            sapiContext.setHostsHijacked(SapiDeviceUtils.a(sapiConfiguration.context));
                            if (sapiConfiguration.supportFaceLogin) {
                                new com.baidu.sapi2.outsdk.d().a(SapiAccountManager.c);
                            }
                            com.baidu.sapi2.utils.d a2 = com.baidu.sapi2.utils.d.a();
                            SapiConfiguration sapiConfiguration3 = sapiConfiguration;
                            a2.a(sapiConfiguration3.context, sapiConfiguration3.sofireAppKey, sapiConfiguration3.sofireSecKey, 1);
                            if (TextUtils.isEmpty(SapiUtils.getCookieBduss())) {
                                SapiAccountManager.getInstance().getAccountService().webLogin(sapiConfiguration.context);
                            }
                        }
                    }));
                }
            } else {
                Log.d(SapiAccountManager.class.getSimpleName() + " had already been initialized", new Object[0]);
            }
        } else {
            throw new IllegalArgumentException(SapiAccountManager.class.getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        }
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public void invalidate(SapiAccount sapiAccount) {
        b();
        SapiShareClient.getInstance().invalidate(sapiAccount);
    }

    public boolean isLogin() {
        b();
        return SapiContext.getInstance().getCurrentAccount() != null;
    }

    public void logout() {
        com.baidu.sapi2.utils.t.a("logout", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo("sdk_api_logout")));
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        removeLoginAccount(currentAccount);
        new com.baidu.sapi2.share.m().a(false);
        SapiUtils.reportGid(10005);
        if (currentAccount != null) {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_UID, currentAccount.uid);
        }
    }

    public void preFetchStoken(SapiAccount sapiAccount, boolean z) {
        List<String> s = SapiContext.getInstance().getSapiOptions().s();
        if (sapiAccount == null || s == null || s.isEmpty() || getInstance().getAccountService().a(sapiAccount, s)) {
            return;
        }
        getInstance().getAccountService().a(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiAccountManager.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
            }
        }, sapiAccount.bduss, s, z);
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        b();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiContext.getInstance().removeLoginAccount(sapiAccount);
        new com.baidu.sapi2.share.m().a(false);
        try {
            new OpenBdussService(getSapiConfiguration(), VERSION_NAME).logout();
        } catch (Throwable th) {
        }
        if (currentAccount != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(currentAccount.uid) && getGlobalAuthorizationListener() != null) {
            try {
                getGlobalAuthorizationListener().onLogoutSuccess(sapiAccount);
            } catch (Throwable th2) {
                Log.e(th2);
            }
        }
    }

    public void setSid() {
        if (j != null) {
            String tid = SapiContext.getInstance().getTid();
            if (!TextUtils.isEmpty(tid)) {
                SapiContext.getInstance().setSearchBoxSid(j.tidConvertSid(tid.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)));
                return;
            } else {
                Log.d(a, "tid is null or empty");
                return;
            }
        }
        Log.d(a, "convert tid to sid failed, because tidConvertSidCallback is null");
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public boolean validate(SapiAccount sapiAccount) {
        b();
        if (SapiUtils.isValidAccount(sapiAccount)) {
            SapiShareClient.getInstance().validate(sapiAccount);
            return true;
        }
        return false;
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        b();
        SapiStatUtil.statLoadLogin("product_line_call");
        List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(c.context);
        if (shareStorageModel.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            SapiStatUtil.statShareV2Open(shareStorageModel, "product_line_call", arrayList);
        }
        return shareStorageModel;
    }

    boolean a(String str) {
        return !TextUtils.isEmpty(str) && k.contains(str);
    }

    private String a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    void b() {
        ReceiveShareListener receiveShareListener;
        if (c == null && (receiveShareListener = g) != null) {
            receiveShareListener.onReceiveShare();
        }
        if (c == null) {
            if (Log.enabled) {
                throw new IllegalStateException(SapiAccountManager.class.getSimpleName() + " have not been initialized");
            }
            android.util.Log.e(Log.TAG, "pass sdk have not been initialized");
        }
    }

    public String getSession(String str) {
        b();
        return getSession(str, null);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiAccount getSession() {
        b();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (this.l == 0) {
            X sapiOptions = SapiContext.getInstance().getSapiOptions();
            if (sapiOptions.q().contains(getConfignation().tpl) && !sapiOptions.S) {
                this.l = (char) 1;
            } else {
                this.l = (char) 2;
            }
        }
        if (currentAccount != null && this.l == 1) {
            currentAccount.uid = "";
            currentAccount.bduss = "";
        }
        return currentAccount;
    }

    private boolean c(Context context) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return b2.equals(a2) || b2.equals(c.processName);
    }

    @TargetApi(3)
    private String b(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return "";
    }
}
