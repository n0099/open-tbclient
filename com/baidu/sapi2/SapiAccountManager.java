package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.service.interfaces.ISAccountService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiAccountManager implements ISapiAccountManagerService, ISAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 200;
    public static final String VERSION_NAME = "8.7.7.0.2";
    private static SapiAccountManager a;
    private static SapiConfiguration b;
    private static SapiAccountService c;
    private static ServiceManager d;
    private static SilentShareListener e;
    private static ReceiveShareListener f;
    private static GlobalAuthorizationListener g;
    private static SharedPreferences.OnSharedPreferenceChangeListener h = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.baidu.sapi2.SapiAccountManager.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_SP_CHANGE, IEventCenterService.EventResult.PHASE.SUCCESS, str);
        }
    };
    private static final List<String> i = new ArrayList();
    private static HashSet<String> j;

    /* loaded from: classes.dex */
    public interface ReceiveShareListener {
        void onReceiveShare();
    }

    /* loaded from: classes.dex */
    public interface SilentShareListener {
        void onSilentShare();
    }

    static {
        i.add("uid");
        i.add("displayname");
        i.add("bduss");
        j = new HashSet<>();
        j.add("com.baidu.sapi2.passhost.pluginsdk.AbsPassPi");
        j.add("com.baidu.sapi2.base.network.Apn");
        j.add("com.baidu.sapi2.base.utils.EncodeUtils");
        j.add("com.baidu.sapi2.utils.SapiDataEncryptor");
        j.add("com.baidu.sapi2.utils.enums.Domain");
        j.add("com.baidu.sapi2.utils.MD5");
        j.add("com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService");
        j.add("com.baidu.sapi2.httpwrap.HttpClientWrap");
        j.add("com.baidu.pass.http.PassHttpClient");
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

    private void c() {
        try {
            Iterator<String> it = j.iterator();
            while (it.hasNext()) {
                Class.forName(it.next());
            }
            try {
                Class.forName("com.baidu.sofire.ac.FH");
                if (getConfignation().registMode == RegistMode.FAST) {
                    try {
                        Class.forName("com.baidu.sapi2.SmsService");
                    } catch (ClassNotFoundException e2) {
                        Log.e(e2);
                        throw new IllegalArgumentException("please import the package : sapi-pass-sms-*.jar");
                    }
                }
                if (b.supportFaceLogin) {
                    try {
                        Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
                    } catch (Throwable th) {
                        Log.e(th);
                        throw new RuntimeException("please import the package :pass-biometrics-face-*.aar and pass-biometrics-base-*.aarand then call BaiduRIM.getInstance().initRIM method in Application class to initialize the RIM SDK");
                    }
                }
                if (b.loginShareStrategy() != LoginShareStrategy.DISABLED && getReceiveShareListener() == null) {
                    throw new RuntimeException("please registerReceiveShareListener to support share login function");
                }
            } catch (ClassNotFoundException e3) {
                Log.e(e3);
                throw new IllegalArgumentException("please import the package : sofire-sdk-*.jar");
            }
        } catch (Throwable th2) {
            Log.e(th2);
            throw new RuntimeException("proguard error. Please check groguard file in your project.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String str;
        if (b.supportFaceLogin) {
            PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
            if (biometric == null || ((PassFaceRecogManager) biometric).getConfiguration() == null) {
                if (b.environment == Domain.DOMAIN_QA) {
                    str = PassBioEnv.PASSPORT_QA_DOMAIN;
                } else if (b.environment == Domain.DOMAIN_NEW_QA) {
                    str = PassBioEnv.PASSPORT_NEW_QA_DOMAIN;
                } else if (b.environment != Domain.DOMAIN_RD) {
                    str = PassBioEnv.PASSPORT_DOMAIN;
                } else {
                    str = PassBioEnv.PASSPORT_RD_DOMAIN;
                }
                biometric.config(new PassBiometricConfiguration.Builder((Application) b.context.getApplicationContext()).setProductLineInfo(b.tpl, b.appId, b.appSignKey).setRuntimeEnvironment(str).debug(b.debug).build());
                if (b.loginShareStrategy() != LoginShareStrategy.DISABLED && getReceiveShareListener() == null) {
                    throw new RuntimeException("please registerReceiveShareListener to support share login function");
                }
            }
        }
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration) {
        if (sapiConfiguration == null) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        }
        if (b == null) {
            b = sapiConfiguration;
            c();
            c = new SapiAccountService(sapiConfiguration.context);
            d = ServiceManager.getInstance();
            d.setIsAccountManager(this);
            if (c(sapiConfiguration.context)) {
                ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z;
                        SapiContext sapiContext = SapiContext.getInstance(sapiConfiguration.context);
                        sapiContext.setShareStorage(null);
                        new ShareCallPacking().markLoginState(true);
                        com.baidu.sapi2.share.a.a().d(sapiConfiguration.context);
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
                        sapiContext.registerOnSharedPreferenceChangeListener(SapiAccountManager.h);
                        sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
                        sapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
                        com.baidu.sapi2.share.a.c();
                        if (sapiConfiguration.syncCacheOnInit) {
                            SapiCache.init(sapiConfiguration.context);
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
                                SapiCache.init(sapiConfiguration.context);
                            }
                        }
                        sapiContext.setHostsHijacked(SapiDeviceUtils.checkHosts(sapiConfiguration.context));
                        com.baidu.sapi2.share.a.a().b(sapiConfiguration.context);
                        SapiAccountManager.this.d();
                    }
                }));
            }
        } else {
            Log.d(getClass().getSimpleName() + " had already been initialized", new Object[0]);
        }
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService, com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getVersionName() {
        return VERSION_NAME;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService
    public int getVersionCode() {
        return 200;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService
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

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService
    public boolean isLogin() {
        a();
        return SapiContext.getInstance(b.context).getCurrentAccount() != null;
    }

    public void logout() {
        StatService.onEvent("logout", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo("sdk_api_logout")), false);
        StatService.onEvent("logout", Collections.singletonMap("pis_di", SapiDeviceInfo.getPisDeviceInfo()), false);
        removeLoginAccount(getSession());
        new ShareCallPacking().markLoginState(false);
        SapiUtils.reportGid(SapiGIDEvent.BUSINESS_LOGOUT);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService, com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiAccount getSession() {
        a();
        return SapiContext.getInstance(b.context).getCurrentAccount();
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public boolean validate(ISapiAccount iSapiAccount) {
        a();
        SapiAccount sapiAccount = (SapiAccount) iSapiAccount;
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

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService
    public int getShareAccountsSize() {
        return getInstance().getShareAccounts().size();
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService
    public List<String> buildShareUidList() {
        List<SapiAccount> shareAccounts = getInstance().getShareAccounts();
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : shareAccounts) {
            arrayList.add(sapiAccount.uid);
        }
        return arrayList;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService
    public List<String> getPackageList() {
        return SapiUtils.getPackageList(b.context);
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
        a();
        HashMap hashMap = new HashMap();
        hashMap.put("cuid", SapiUtils.getClientId(getConfignation().context));
        hashMap.put("device", Build.MODEL);
        hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, "product_line_call");
        StatService.onEvent("load_login", hashMap, false);
        List<ShareStorage.StorageModel> a2 = com.baidu.sapi2.share.a.a().a(b.context);
        if (a2.size() > 0) {
            hashMap.clear();
            hashMap.put("cuid", SapiUtils.getClientId(getConfignation().context));
            hashMap.put("device", Build.MODEL);
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, "product_line_call");
            StatService.onEvent("share_account_open", hashMap, false);
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
            getInstance().getAccountService().a(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiAccountManager.3
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
        return !TextUtils.isEmpty(str) && i.contains(str);
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
    static String a(Context context) {
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

    static String b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService
    public boolean isAppProcess() {
        return c(getSapiConfiguration().context);
    }

    static boolean c(Context context) {
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

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccountManagerService
    public boolean isOutsideCompany() {
        return "500000".equals(getConfignation().sofireAppKey) && "ec750ac71e32856ba4909a77a4e81889".equals(getConfignation().sofireSecKey);
    }
}
