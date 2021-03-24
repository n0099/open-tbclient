package com.baidu.sapi2;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.TidConvertSidCallback;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.f;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SapiAccountManager implements ISAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 250;
    public static final String VERSION_NAME = "9.2.9.8";

    /* renamed from: b  reason: collision with root package name */
    public static final String f10614b = "SapiAccountManager";

    /* renamed from: c  reason: collision with root package name */
    public static SapiAccountManager f10615c;

    /* renamed from: d  reason: collision with root package name */
    public static SapiConfiguration f10616d;

    /* renamed from: e  reason: collision with root package name */
    public static SapiAccountService f10617e;

    /* renamed from: f  reason: collision with root package name */
    public static ServiceManager f10618f;

    /* renamed from: g  reason: collision with root package name */
    public static GlobalCallback f10619g;

    /* renamed from: h  reason: collision with root package name */
    public static CheckUrlIsAvailableListener f10620h;
    public static TidConvertSidCallback i;
    public static final List<String> j;

    /* renamed from: a  reason: collision with root package name */
    public char f10621a = 0;

    /* loaded from: classes2.dex */
    public interface CheckUrlIsAvailableListener {
        void handleWebPageUrl(String str);

        boolean onCheckUrlIsAvailable(String str);
    }

    static {
        ArrayList arrayList = new ArrayList();
        j = arrayList;
        arrayList.add("uid");
        j.add("displayname");
        j.add("bduss");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            Class.forName("com.baidu.pass.Constant");
        } catch (Exception unused) {
            com.baidu.sapi2.utils.a.b("please update pass-httpclient sdk to last version");
        }
        try {
            Class.forName("com.baidu.sofire.ac.FH");
        } catch (Exception unused2) {
            com.baidu.sapi2.utils.a.b("please import the package : sofire-sdk-*.aar");
        }
        if (f10616d.supportFaceLogin) {
            try {
                Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
            } catch (Throwable unused3) {
                com.baidu.sapi2.utils.a.b("please import the package :pass-biometrics-face-*.aar and pass-biometrics-base-*.aar");
            }
        }
        if (f10616d.loginShareStrategy() == LoginShareStrategy.DISABLED || f10619g != null) {
            return;
        }
        com.baidu.sapi2.utils.a.a("please register globalCallback to support share login function");
    }

    public static CheckUrlIsAvailableListener getCheckUrlIsAvailablelister() {
        return f10620h;
    }

    public static GlobalCallback getGlobalCallback() {
        GlobalCallback globalCallback = f10619g;
        return globalCallback == null ? new GlobalCallback() { // from class: com.baidu.sapi2.SapiAccountManager.2
            @Override // com.baidu.sapi2.callback.GlobalCallback
            public void onLoginStatusChange() {
            }

            @Override // com.baidu.sapi2.callback.GlobalCallback
            public void onNeedInitPassSdk() {
            }
        } : globalCallback;
    }

    public static synchronized SapiAccountManager getInstance() {
        SapiAccountManager sapiAccountManager;
        synchronized (SapiAccountManager.class) {
            if (f10615c == null) {
                f10615c = new SapiAccountManager();
            }
            sapiAccountManager = f10615c;
        }
        return sapiAccountManager;
    }

    public static TidConvertSidCallback getTidConvertSidCallback() {
        return i;
    }

    public static void registerCheckUrlIsAvailableListener(CheckUrlIsAvailableListener checkUrlIsAvailableListener) {
        f10620h = checkUrlIsAvailableListener;
    }

    public static void setGlobalCallback(GlobalCallback globalCallback) {
        f10619g = globalCallback;
    }

    public static void setTidConvertSidCallback(TidConvertSidCallback tidConvertSidCallback) {
        i = tidConvertSidCallback;
    }

    public static void unregisterCheckUrlIsAvailableListener() {
        f10620h = null;
    }

    public SapiAccountService getAccountService() {
        a();
        return f10617e;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiConfiguration getConfignation() {
        return f10616d;
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
        a();
        return SapiContext.getInstance().getLoginAccounts();
    }

    public void getOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback) {
        GetOneKeyLoginStateDTO getOneKeyLoginStateDTO = new GetOneKeyLoginStateDTO();
        getOneKeyLoginStateDTO.connectTimeout = 15000;
        f10617e.getOneKeyLoginIsAvailable(getOneKeyLoginStateDTO, oneKeyLoginCallback);
    }

    public SapiSafeFacade getSafeFacade() {
        a();
        return SapiSafeFacade.a();
    }

    public SapiConfiguration getSapiConfiguration() {
        a();
        return f10616d;
    }

    public String getSession(String str, String str2) {
        JSONObject jSONObject;
        a();
        SapiAccount session = getSession();
        return (!a(str) || !isLogin() || session == null || (jSONObject = session.toJSONObject()) == null) ? str2 : jSONObject.optString(str, str2);
    }

    public void getShareModels(long j2, ShareModelCallback shareModelCallback) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("must timeoutMills > 0");
        }
        if (shareModelCallback == null) {
            return;
        }
        if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_V3_EXTERNAL_RECOVERY).isMeetGray()) {
            shareModelCallback.onReceiveShareModels(getV2ShareModelList());
            return;
        }
        a();
        SapiConfiguration sapiConfiguration = getInstance().getSapiConfiguration();
        if (sapiConfiguration == null) {
            Log.d(com.baidu.sapi2.share.d.f11376a, "getShareModels config is null");
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
        } else if (!SapiUtils.isOnline(sapiConfiguration.context)) {
            Log.d(com.baidu.sapi2.share.d.f11376a, "getShareModels environment is not online");
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
        } else if (sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            Log.d(com.baidu.sapi2.share.d.f11376a, "getShareModels config loginShareStrategy is not DISABLED");
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
        } else {
            com.baidu.sapi2.share.d.a(j2, sapiConfiguration.context, sapiConfiguration.tpl, shareModelCallback);
        }
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList() {
        return getV2ShareModelList("");
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getVersionName() {
        return "9.2.9.8";
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getZidAndCheckSafe(Context context, String str, int i2) {
        return SapiSafeFacade.a().getZidAndCheckSafe(context, str, i2);
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration) {
        if (sapiConfiguration != null) {
            if (f10616d == null) {
                f10616d = sapiConfiguration;
                f10617e = new SapiAccountService();
                ServiceManager serviceManager = ServiceManager.getInstance();
                f10618f = serviceManager;
                serviceManager.setIsAccountManager(this);
                if (b(sapiConfiguration.context)) {
                    a.e().a((Application) sapiConfiguration.context);
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
                            new com.baidu.sapi2.share.a().a(0);
                            sapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
                            com.baidu.sapi2.share.d.b(sapiConfiguration);
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
                                new d().a(sapiConfiguration.context);
                            }
                            sapiContext.setHostsHijacked(f.a(sapiConfiguration.context));
                            if (sapiConfiguration.supportFaceLogin) {
                                new com.baidu.sapi2.outsdk.a().a(SapiAccountManager.f10616d);
                            }
                            com.baidu.sapi2.utils.d a2 = com.baidu.sapi2.utils.d.a();
                            SapiConfiguration sapiConfiguration2 = sapiConfiguration;
                            a2.a(sapiConfiguration2.context, sapiConfiguration2.sofireAppKey, sapiConfiguration2.sofireSecKey, 1);
                            if (TextUtils.isEmpty(SapiUtils.getCookieBduss()) || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
                                SapiAccountManager.getInstance().getAccountService().webLogin(sapiConfiguration.context);
                            }
                            new OneKeyLoginSdkCall().initOneKeyLoginSdk(sapiConfiguration);
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

    public boolean isLogin() {
        a();
        return SapiAccount.isValidAccount(SapiContext.getInstance().getCurrentAccount());
    }

    public void logout() {
        StatService.onEvent("logout", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo("sdk_api_logout")));
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        removeLoginAccount(currentAccount);
        if (currentAccount != null) {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_UID, currentAccount.uid);
        }
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        a();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiContext.getInstance().removeLoginAccount(sapiAccount);
        new com.baidu.sapi2.share.a().a(3);
        try {
            new OpenBdussService(getSapiConfiguration(), "9.2.9.8").logout();
        } catch (Throwable unused) {
        }
        if (currentAccount == null || TextUtils.isEmpty(sapiAccount.uid) || !sapiAccount.uid.equals(currentAccount.uid)) {
            return;
        }
        getGlobalCallback().onLogoutSuccess(sapiAccount);
    }

    public void setSid() {
        if (i != null) {
            String tid = SapiContext.getInstance().getTid();
            if (!TextUtils.isEmpty(tid)) {
                SapiContext.getInstance().setSearchBoxSid(i.tidConvertSid(tid.split("-")));
                return;
            } else {
                Log.d(f10614b, "tid is null or empty");
                return;
            }
        }
        Log.d(f10614b, "convert tid to sid failed, because tidConvertSidCallback is null");
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public boolean validate(SapiAccount sapiAccount) {
        a();
        if (sapiAccount == null) {
            return false;
        }
        e.a().d(sapiAccount);
        SapiContext sapiContext = SapiContext.getInstance();
        sapiContext.setCurrentAccount(sapiAccount);
        sapiContext.addLoginAccount(sapiAccount);
        new com.baidu.sapi2.utils.c().a(com.baidu.sapi2.utils.c.f11448h);
        new ShareStorage().set(2);
        return true;
    }

    private boolean b(Context context) {
        String curProcessName = SapiUtils.getCurProcessName(context);
        if (TextUtils.isEmpty(curProcessName)) {
            return false;
        }
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return curProcessName.equals(a2) || curProcessName.equals(f10616d.processName);
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && j.contains(str);
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        a();
        Log.d(com.baidu.sapi2.share.d.f11376a, "build version is " + Build.VERSION.SDK_INT);
        SapiStatUtil.statLoadLogin("product_line_call");
        List<ShareStorage.StorageModel> e2 = com.baidu.sapi2.share.d.e();
        if (e2 != null && e2.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            SapiStatUtil.statShareV2Open(e2, "product_line_call", arrayList);
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(e2 != null ? e2.size() : 0);
        hashMap.put("shareModels", sb.toString());
        StatService.onEventAutoStat(com.baidu.sapi2.share.c.f11368a, hashMap);
        return e2;
    }

    public void a() {
        if (f10616d == null) {
            getGlobalCallback().onNeedInitPassSdk();
        }
        if (f10616d == null) {
            if (!Log.enabled) {
                android.util.Log.e(Log.TAG, "pass sdk have not been initialized");
                return;
            }
            throw new IllegalStateException(SapiAccountManager.class.getSimpleName() + " have not been initialized");
        }
    }

    public String getSession(String str) {
        a();
        return getSession(str, null);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiAccount getSession() {
        a();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (this.f10621a == 0) {
            SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
            if (sapiOptions.getOpenBdussTpls().contains(getConfignation().tpl) && !sapiOptions.canGetBduss) {
                this.f10621a = (char) 1;
            } else {
                this.f10621a = (char) 2;
            }
        }
        if (currentAccount != null && this.f10621a == 1) {
            currentAccount.uid = "";
            currentAccount.bduss = "";
        }
        return currentAccount;
    }

    private String a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }
}
