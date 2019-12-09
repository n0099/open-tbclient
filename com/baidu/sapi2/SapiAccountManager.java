package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.GetTplStokenResult;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SapiAccountManager implements ISAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 223;
    public static final String VERSION_NAME = "8.8.8.2";
    private static SapiAccountManager a;
    private static SapiConfiguration b;
    private static SapiAccountService c;
    private static ServiceManager d;
    private static SilentShareListener e;
    private static ReceiveShareListener f;
    private static GlobalAuthorizationListener g;
    private static final List<String> h = new ArrayList();
    private char i = 0;

    /* loaded from: classes2.dex */
    public static abstract class GlobalAuthorizationListener {
        public void onLogoutSuccess(SapiAccount sapiAccount) {
        }
    }

    /* loaded from: classes2.dex */
    public interface ReceiveShareListener {
        void onReceiveShare();
    }

    /* loaded from: classes2.dex */
    public interface SilentShareListener {
        void onSilentShare();
    }

    static {
        h.add("uid");
        h.add(SESSION_DISPLAYNAME);
        h.add("bduss");
    }

    private SapiAccountManager() {
    }

    private void b(String str) {
        if (!SapiUtils.isDebug(b.context) && !b.debug) {
            Log.e(str, new Object[0]);
            return;
        }
        throw new RuntimeException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            Class.forName("com.baidu.sofire.ac.FH");
        } catch (ClassNotFoundException e2) {
            Log.e(e2);
            b("please import the package : sofire-sdk-*.jar");
        }
        if (b.supportFaceLogin) {
            try {
                Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
            } catch (Throwable th) {
                Log.e(th);
                b("please import the package :pass-biometrics-face-*.aar and pass-biometrics-base-*.aar");
            }
        }
        if (b.loginShareStrategy() == LoginShareStrategy.DISABLED || getReceiveShareListener() != null) {
            return;
        }
        throw new RuntimeException("please registerReceiveShareListener to support share login function");
    }

    public static GlobalAuthorizationListener getGlobalAuthorizationListener() {
        return g;
    }

    public static synchronized SapiAccountManager getInstance() {
        SapiAccountManager sapiAccountManager;
        synchronized (SapiAccountManager.class) {
            if (a == null) {
                a = new SapiAccountManager();
            }
            sapiAccountManager = a;
        }
        return sapiAccountManager;
    }

    public static ReceiveShareListener getReceiveShareListener() {
        return f;
    }

    public static SilentShareListener getSilentShareListener() {
        return e;
    }

    public static void registerGlobalAuthorizationListener(GlobalAuthorizationListener globalAuthorizationListener) {
        g = globalAuthorizationListener;
    }

    public static void registerReceiveShareListener(ReceiveShareListener receiveShareListener) {
        f = receiveShareListener;
    }

    public static void registerSilentShareListener(SilentShareListener silentShareListener) {
        e = silentShareListener;
    }

    public static void unregisterGlobalAuthorizationListener() {
        g = null;
    }

    public static void unregisterReceiveShareListener() {
        f = null;
    }

    public static void unregisterSilentShareListener() {
        e = null;
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
        return c;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiConfiguration getConfignation() {
        return b;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getCurrentZid(Context context) {
        return SapiSafeFacade.a().getCurrentZid(context);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getDeviceAuthToken(Context context, String str, int i) {
        return SapiSafeFacade.a().getDeviceAuthToken(context, str, i);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public com.baidu.sapi2.service.interfaces.a getIsAccountService() {
        return getAccountService();
    }

    public List<SapiAccount> getLoginAccounts() {
        b();
        return SapiContext.getInstance().getLoginAccounts();
    }

    public SapiSafeFacade getSafeFacade() {
        b();
        return SapiSafeFacade.a();
    }

    public SapiConfiguration getSapiConfiguration() {
        b();
        return b;
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
        if (b.loginShareStrategy() == LoginShareStrategy.DISABLED) {
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
        return VERSION_CODE;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getVersionName() {
        return VERSION_NAME;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getZidAndCheckSafe(Context context, String str, int i) {
        return SapiSafeFacade.a().getZidAndCheckSafe(context, str, i);
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration) {
        if (sapiConfiguration != null) {
            if (b == null) {
                b = sapiConfiguration;
                c = new SapiAccountService();
                d = ServiceManager.getInstance();
                d.setIsAccountManager(this);
                if (c(sapiConfiguration.context)) {
                    b.b().a((Application) sapiConfiguration.context);
                    ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z;
                            SapiContext sapiContext = SapiContext.getInstance();
                            sapiContext.setShareStorage(null);
                            new com.baidu.sapi2.share.m().a(true);
                            SapiShareClient.getInstance().registerActivityLifecycleCallbacks(sapiConfiguration.context);
                            int versionCode = SapiUtils.getVersionCode(sapiConfiguration.context);
                            if (sapiConfiguration.silentShareOnUpgrade && versionCode > sapiContext.getAppVersionCode()) {
                                SapiUtils.resetSilentShareStatus(sapiConfiguration.context);
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
                            if (sapiConfiguration.syncCacheOnInit) {
                                new P().a(sapiConfiguration.context);
                            } else {
                                List<String> l = S.l();
                                String packageName = sapiConfiguration.context.getPackageName();
                                Iterator<String> it = l.iterator();
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
                                    new P().a(sapiConfiguration.context);
                                }
                            }
                            sapiContext.setHostsHijacked(SapiDeviceUtils.a(sapiConfiguration.context));
                            if (sapiConfiguration.supportFaceLogin) {
                                new com.baidu.sapi2.outsdk.d().a(SapiAccountManager.b);
                            }
                            com.baidu.sapi2.utils.d a2 = com.baidu.sapi2.utils.d.a();
                            SapiConfiguration sapiConfiguration3 = sapiConfiguration;
                            a2.a(sapiConfiguration3.context, sapiConfiguration3.sofireAppKey, sapiConfiguration3.sofireSecKey, 1);
                            if (SapiAccountManager.this.isLogin()) {
                                new com.baidu.sapi2.a.b().a(sapiConfiguration.context);
                            }
                            if (TextUtils.isEmpty(SapiUtils.getCookieBduss())) {
                                SapiAccountManager.getInstance().getAccountService().webLogin(sapiConfiguration.context);
                            }
                            try {
                                SapiAccountManager.this.c();
                            } catch (RuntimeException e2) {
                                ThreadPoolService.getInstance().runInUiThread(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        throw e2;
                                    }
                                }));
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
        com.baidu.sapi2.utils.r.a("logout", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo("sdk_api_logout")));
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        removeLoginAccount(currentAccount);
        new com.baidu.sapi2.share.m().a(false);
        SapiUtils.reportGid(10005);
        if (currentAccount != null) {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_UID, currentAccount.uid);
        }
    }

    public void preFetchStoken(SapiAccount sapiAccount, boolean z) {
        List<String> t = SapiContext.getInstance().getSapiOptions().t();
        if (sapiAccount == null || t == null || t.isEmpty() || getInstance().getAccountService().a(sapiAccount, t)) {
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
        }, sapiAccount.bduss, t, z);
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        b();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiContext.getInstance(b.context).removeLoginAccount(sapiAccount);
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
        List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(b.context);
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
        return !TextUtils.isEmpty(str) && h.contains(str);
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
        if (b == null && (receiveShareListener = f) != null) {
            receiveShareListener.onReceiveShare();
        }
        if (b == null) {
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
        if (this.i == 0) {
            S sapiOptions = SapiContext.getInstance().getSapiOptions();
            if (sapiOptions.r().contains(getConfignation().tpl) && !sapiOptions.W) {
                this.i = (char) 1;
            } else {
                this.i = (char) 2;
            }
        }
        if (currentAccount != null && this.i == 1) {
            currentAccount.uid = "";
            currentAccount.bduss = "";
        }
        return currentAccount;
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

    private boolean c(Context context) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return b2.equals(a2) || b2.equals(b.processName);
    }
}
