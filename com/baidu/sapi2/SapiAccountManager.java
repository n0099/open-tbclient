package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.sapi2.a.d;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.service.interfaces.ISAccountService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SafeService;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiAccountManager implements ISAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 215;
    public static final String VERSION_NAME = "8.7.17";
    private static SapiAccountManager a;
    private static SapiConfiguration b;
    private static SapiAccountService c;
    private static ServiceManager d;
    private static SilentShareListener e;
    private static ReceiveShareListener f;
    private static GlobalAuthorizationListener g;
    private static final List<String> h = new ArrayList();
    private static HashSet<String> i;

    /* loaded from: classes.dex */
    public interface ReceiveShareListener {
        void onReceiveShare();
    }

    /* loaded from: classes.dex */
    public interface SilentShareListener {
        void onSilentShare();
    }

    static {
        h.add("uid");
        h.add(SESSION_DISPLAYNAME);
        h.add("bduss");
        i = new HashSet<>();
        i.add("com.baidu.sapi2.httpwrap.HttpClientWrap");
        i.add("com.baidu.pass.http.PassHttpClient");
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

    private SapiAccountManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            Iterator<String> it = i.iterator();
            while (it.hasNext()) {
                Class.forName(it.next());
            }
        } catch (Throwable th) {
            Log.e(th);
            b("proguard error. Please check groguard file in your project.");
        }
        try {
            Class.forName("com.baidu.sofire.ac.FH");
        } catch (ClassNotFoundException e2) {
            Log.e(e2);
            b("please import the package : sofire-sdk-*.jar");
        }
        if (getConfignation().registMode == RegistMode.FAST) {
            try {
                Class.forName("com.baidu.sapi2.SmsService");
            } catch (ClassNotFoundException e3) {
                Log.e(e3);
                b("please import the package : sapi-pass-sms-*.jar");
            }
        }
        if (TextUtils.isEmpty(getConfignation().sofireAppKey) || TextUtils.isEmpty(getConfignation().sofireSecKey) || getConfignation().sofireHostID == -1) {
            throw new IllegalArgumentException("sofireAppKey or sofireSecKey can't be empty and sofireHostID can't equal -1");
        }
        if (b.supportFaceLogin) {
            if (b.rimSDKEnable) {
                try {
                    Class.forName("com.baidu.fsg.api.BaiduRIM");
                } catch (Throwable th2) {
                    Log.e(th2);
                    b("please import the package :rim-sdk-api-*.aar and rim-sdk-face-*.aar and then call BaiduRIM.getInstance().initRIM method in Application class to initialize the RIM SDK");
                }
            } else {
                try {
                    Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
                } catch (Throwable th3) {
                    Log.e(th3);
                    b("please import the package :pass-biometrics-face-*.aar and pass-biometrics-base-*.aar");
                }
            }
        }
        if (b.loginShareStrategy() != LoginShareStrategy.DISABLED && getReceiveShareListener() == null) {
            throw new RuntimeException("please registerReceiveShareListener to support share login function");
        }
    }

    private void b(String str) {
        if (SapiUtils.isDebug(b.context) || b.debug) {
            throw new RuntimeException(str);
        }
        Log.e(str, new Object[0]);
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration) {
        if (sapiConfiguration == null) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        }
        if (b == null) {
            b = sapiConfiguration;
            c = new SapiAccountService();
            d = ServiceManager.getInstance();
            d.setIsAccountManager(this);
            if (c(sapiConfiguration.context)) {
                ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z;
                        SapiContext sapiContext = SapiContext.getInstance(sapiConfiguration.context);
                        sapiContext.setShareStorage(null);
                        new ShareCallPacking().markLoginState(true);
                        com.baidu.sapi2.share.a.a().b(sapiConfiguration.context);
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
                        sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
                        sapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
                        com.baidu.sapi2.share.a.c();
                        if (sapiConfiguration.syncCacheOnInit) {
                            new SapiCache().a(sapiConfiguration.context);
                        } else {
                            List<String> initialCachePackagesWhiteList = SapiOptions.getInitialCachePackagesWhiteList();
                            String packageName = sapiConfiguration.context.getPackageName();
                            Iterator<String> it = initialCachePackagesWhiteList.iterator();
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
                                new SapiCache().a(sapiConfiguration.context);
                            }
                        }
                        sapiContext.setHostsHijacked(SapiDeviceUtils.checkHosts(sapiConfiguration.context));
                        if (sapiConfiguration.supportFaceLogin && !SapiAccountManager.b.rimSDKEnable) {
                            new d().a(SapiAccountManager.b);
                        }
                        SafeService.getInstance().init(sapiConfiguration.context, sapiConfiguration.sofireAppKey, sapiConfiguration.sofireSecKey, 1);
                        if (SapiAccountManager.this.isLogin()) {
                            new com.baidu.sapi2.b.a().a(sapiConfiguration.context);
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
            Log.d(getClass().getSimpleName() + " had already been initialized", new Object[0]);
        }
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getVersionName() {
        return VERSION_NAME;
    }

    public int getVersionCode() {
        return VERSION_CODE;
    }

    public SapiConfiguration getSapiConfiguration() {
        a();
        return b;
    }

    public SapiAccountService getAccountService() {
        a();
        return c;
    }

    public SapiSafeFacade getSafeFacade() {
        a();
        return SapiSafeFacade.a();
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getCurrentZid(Context context) {
        return SapiSafeFacade.a().getCurrentZid(context);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getZidAndCheckSafe(Context context, String str, int i2) {
        return SapiSafeFacade.a().getZidAndCheckSafe(context, str, i2);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getDeviceAuthToken(Context context, String str, int i2) {
        return SapiSafeFacade.a().getDeviceAuthToken(context, str, i2);
    }

    public boolean isLogin() {
        a();
        return SapiContext.getInstance(b.context).getCurrentAccount() != null;
    }

    public void logout() {
        StatService.onEvent("logout", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo("sdk_api_logout")));
        removeLoginAccount(getSession());
        new ShareCallPacking().markLoginState(false);
        SapiUtils.reportGid(10005);
    }

    public String getSession(String str, String str2) {
        JSONObject jSONObject;
        a();
        SapiAccount session = getSession();
        if (a(str) && isLogin() && session != null && (jSONObject = session.toJSONObject()) != null) {
            return jSONObject.optString(str, str2);
        }
        return str2;
    }

    public String getSession(String str) {
        a();
        return getSession(str, null);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiAccount getSession() {
        a();
        return SapiContext.getInstance(b.context).getCurrentAccount();
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public boolean validate(SapiAccount sapiAccount) {
        a();
        if (!SapiUtils.isValidAccount(sapiAccount)) {
            return false;
        }
        com.baidu.sapi2.share.a.a().a(sapiAccount);
        return true;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public void invalidate(SapiAccount sapiAccount) {
        a();
        com.baidu.sapi2.share.a.a().b(sapiAccount);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public List<SapiAccount> getShareAccounts() {
        a();
        ArrayList arrayList = new ArrayList();
        if (b.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            return arrayList;
        }
        for (SapiAccount sapiAccount : SapiContext.getInstance(b.context).getShareAccounts()) {
            if (SapiUtils.isValidAccount(sapiAccount)) {
                arrayList.add(sapiAccount);
            } else {
                SapiContext.getInstance(b.context).removeShareAccount(sapiAccount);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        a();
        SapiAccount currentAccount = SapiContext.getInstance(b.context).getCurrentAccount();
        SapiContext.getInstance(b.context).removeLoginAccount(sapiAccount);
        new ShareCallPacking().markLoginState(false);
        if (currentAccount != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(currentAccount.uid)) {
            if (getGlobalAuthorizationListener() != null) {
                try {
                    getGlobalAuthorizationListener().onLogoutSuccess(sapiAccount);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
            getInstance().getAccountService().checkFaceLoginEnable(b.context, null);
        }
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList() {
        return getV2ShareModelList("");
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        a();
        SapiStatUtil.statLoadLogin("product_line_call");
        List<ShareStorage.StorageModel> a2 = com.baidu.sapi2.share.a.a().a(b.context);
        if (a2.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            SapiStatUtil.statShareV2Open(a2, "product_line_call", arrayList);
        }
        return a2;
    }

    public List<SapiAccount> getLoginAccounts() {
        a();
        return SapiContext.getInstance(b.context).getLoginAccounts();
    }

    public SapiAccount getAccountByOpenid(String str) {
        String str2 = SapiUtils.urlParamsToMap(SapiContext.getInstance(getConfignation().context).getString(SapiContext.KEY_OPENID_UID_LIST)).get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        List<SapiAccount> loginAccounts = getLoginAccounts();
        loginAccounts.addAll(getShareAccounts());
        for (SapiAccount sapiAccount : loginAccounts) {
            if (str2.equals(sapiAccount.uid)) {
                SapiContext.getInstance(getConfignation().context).setCurrentAccount(sapiAccount);
                return sapiAccount;
            }
        }
        return null;
    }

    public void preFetchStoken(SapiAccount sapiAccount, boolean z) {
        List<String> preFetchTplList = SapiContext.getInstance(b.context).getSapiOptions().getPreFetchTplList();
        if (sapiAccount != null && preFetchTplList != null && !preFetchTplList.isEmpty() && !getInstance().getAccountService().a(sapiAccount, preFetchTplList)) {
            getInstance().getAccountService().a(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiAccountManager.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            }, sapiAccount.bduss, preFetchTplList, z);
        }
    }

    boolean a(String str) {
        return !TextUtils.isEmpty(str) && h.contains(str);
    }

    void a() {
        if (b == null && f != null) {
            f.onReceiveShare();
        }
        if (b == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " have not been initialized");
        }
    }

    /* loaded from: classes.dex */
    public static abstract class GlobalAuthorizationListener {
        public void onLogoutSuccess(SapiAccount sapiAccount) {
        }
    }

    public static void registerSilentShareListener(SilentShareListener silentShareListener) {
        e = silentShareListener;
    }

    public static void unregisterSilentShareListener() {
        e = null;
    }

    public static SilentShareListener getSilentShareListener() {
        return e;
    }

    public static void registerReceiveShareListener(ReceiveShareListener receiveShareListener) {
        f = receiveShareListener;
    }

    public static void unregisterReceiveShareListener() {
        f = null;
    }

    public static ReceiveShareListener getReceiveShareListener() {
        return f;
    }

    public static void registerGlobalAuthorizationListener(GlobalAuthorizationListener globalAuthorizationListener) {
        g = globalAuthorizationListener;
    }

    public static void unregisterGlobalAuthorizationListener() {
        g = null;
    }

    public static GlobalAuthorizationListener getGlobalAuthorizationListener() {
        return g;
    }

    @TargetApi(3)
    private String a(Context context) {
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

    private String b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    private boolean c(Context context) {
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        return a2.equals(b2) || a2.equals(b.processName);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public ISAccountService getIsAccountService() {
        return getAccountService();
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiConfiguration getConfignation() {
        return b;
    }
}
