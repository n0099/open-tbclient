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
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
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
import com.baidu.sapi2.utils.k;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class SapiAccountManager implements ISAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 249;
    public static final String VERSION_NAME = "8.9.9.1";
    private static final String b = "SapiAccountManager";
    private static SapiAccountManager c;
    private static SapiConfiguration d;
    private static SapiAccountService e;
    private static ServiceManager f;
    private static SilentShareListener g;
    private static ReceiveShareListener h;
    private static GlobalAuthorizationListener i;
    private static CheckUrlIsAvailableListener j;
    private static TidConvertSidCallback k;
    private static final List<String> l = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private char f3221a = 0;

    /* loaded from: classes5.dex */
    public interface CheckUrlIsAvailableListener {
        void handleWebPageUrl(String str);

        boolean onCheckUrlIsAvailable(String str);
    }

    /* loaded from: classes5.dex */
    public static abstract class GlobalAuthorizationListener {
        public void onLogoutSuccess(SapiAccount sapiAccount) {
        }
    }

    /* loaded from: classes5.dex */
    public interface ReceiveShareListener {
        void onReceiveShare();
    }

    /* loaded from: classes5.dex */
    public interface SilentShareListener {
        void onSilentShare();
    }

    static {
        l.add("uid");
        l.add(SESSION_DISPLAYNAME);
        l.add("bduss");
    }

    private SapiAccountManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            Class.forName("com.baidu.pass.Constant");
        } catch (Exception e2) {
            b("please update pass-httpclient sdk to last version");
        }
        try {
            Class.forName("com.baidu.sofire.ac.FH");
        } catch (Exception e3) {
            b("please import the package : sofire-sdk-*.aar");
        }
        if (d.supportFaceLogin) {
            try {
                Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
            } catch (Throwable th) {
                b("please import the package :pass-biometrics-face-*.aar and pass-biometrics-base-*.aar");
            }
        }
        if (d.loginShareStrategy() == LoginShareStrategy.DISABLED || getReceiveShareListener() != null) {
            return;
        }
        b("please registerReceiveShareListener to support share login function");
    }

    public static CheckUrlIsAvailableListener getCheckUrlIsAvailablelister() {
        return j;
    }

    public static GlobalAuthorizationListener getGlobalAuthorizationListener() {
        return i;
    }

    public static synchronized SapiAccountManager getInstance() {
        SapiAccountManager sapiAccountManager;
        synchronized (SapiAccountManager.class) {
            if (c == null) {
                c = new SapiAccountManager();
            }
            sapiAccountManager = c;
        }
        return sapiAccountManager;
    }

    public static ReceiveShareListener getReceiveShareListener() {
        return h;
    }

    public static SilentShareListener getSilentShareListener() {
        return g;
    }

    public static TidConvertSidCallback getTidConvertSidCallback() {
        return k;
    }

    public static void registerCheckUrlIsAvailableListener(CheckUrlIsAvailableListener checkUrlIsAvailableListener) {
        j = checkUrlIsAvailableListener;
    }

    public static void registerGlobalAuthorizationListener(GlobalAuthorizationListener globalAuthorizationListener) {
        i = globalAuthorizationListener;
    }

    public static void registerReceiveShareListener(ReceiveShareListener receiveShareListener) {
        h = receiveShareListener;
    }

    public static void registerSilentShareListener(SilentShareListener silentShareListener) {
        g = silentShareListener;
    }

    public static void setTidConvertSidCallback(TidConvertSidCallback tidConvertSidCallback) {
        k = tidConvertSidCallback;
    }

    public static void unregisterCheckUrlIsAvailableListener() {
        j = null;
    }

    public static void unregisterGlobalAuthorizationListener() {
        i = null;
    }

    public static void unregisterReceiveShareListener() {
        h = null;
    }

    public static void unregisterSilentShareListener() {
        g = null;
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
        a();
        return e;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiConfiguration getConfignation() {
        return d;
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
        getOneKeyLoginIsAvailable(getOneKeyLoginStateDTO, oneKeyLoginCallback);
    }

    public SapiSafeFacade getSafeFacade() {
        a();
        return SapiSafeFacade.a();
    }

    public SapiConfiguration getSapiConfiguration() {
        a();
        return d;
    }

    public String getSession(String str, String str2) {
        JSONObject jSONObject;
        a();
        SapiAccount session = getSession();
        return (!a(str) || !isLogin() || session == null || (jSONObject = session.toJSONObject()) == null) ? str2 : jSONObject.optString(str, str2);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public List<SapiAccount> getShareAccounts() {
        a();
        ArrayList arrayList = new ArrayList();
        if (d.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            return arrayList;
        }
        for (SapiAccount sapiAccount : SapiContext.getInstance().getShareAccounts()) {
            if (SapiAccount.isValidAccount(sapiAccount)) {
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
        return 249;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getVersionName() {
        return "8.9.9.1";
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getZidAndCheckSafe(Context context, String str, int i2) {
        return SapiSafeFacade.a().getZidAndCheckSafe(context, str, i2);
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration) {
        if (sapiConfiguration != null) {
            if (d == null) {
                d = sapiConfiguration;
                e = new SapiAccountService();
                f = ServiceManager.getInstance();
                f.setIsAccountManager(this);
                if (c(sapiConfiguration.context)) {
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
                            new com.baidu.sapi2.share.b().a(0);
                            int versionCode = SapiUtils.getVersionCode(sapiConfiguration.context);
                            if (sapiConfiguration.silentShareOnUpgrade && versionCode > sapiContext.getAppVersionCode()) {
                                SapiUtils.resetSilentShareStatus();
                            }
                            if (versionCode > sapiContext.getAppVersionCode()) {
                                SapiUtils.webLogin(sapiConfiguration.context, SapiUtils.getCookieBduss(), "");
                            }
                            if ("8.9.9.1".compareTo(sapiContext.getString(SapiContext.KEY_SDK_VERSION)) > 0) {
                                sapiContext.put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, false);
                            }
                            sapiContext.setAppVersionCode(versionCode);
                            sapiContext.put(SapiContext.KEY_SDK_VERSION, "8.9.9.1");
                            SapiConfiguration sapiConfiguration2 = sapiConfiguration;
                            sapiConfiguration2.clientId = SapiUtils.getClientId(sapiConfiguration2.context);
                            sapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
                            SapiShareClient.syncShareAccounts();
                            SapiShareClient.sendCloudShareAccountReset();
                            List<String> s = e.s();
                            String packageName = sapiConfiguration.context.getPackageName();
                            Iterator<String> it = s.iterator();
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
                            sapiContext.setHostsHijacked(SapiDeviceUtils.a(sapiConfiguration.context));
                            if (sapiConfiguration.supportFaceLogin) {
                                new com.baidu.sapi2.outsdk.a().a(SapiAccountManager.d);
                            }
                            com.baidu.sapi2.utils.c a2 = com.baidu.sapi2.utils.c.a();
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
        a();
        SapiShareClient.getInstance().invalidate(sapiAccount);
    }

    public boolean isLogin() {
        a();
        return SapiAccount.isValidAccount(SapiContext.getInstance().getCurrentAccount());
    }

    public void logout() {
        k.a("logout", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo("sdk_api_logout")));
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        removeLoginAccount(currentAccount);
        if (currentAccount != null) {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_UID, currentAccount.uid);
        }
    }

    public void preFetchStoken(SapiAccount sapiAccount, boolean z) {
        List<String> o = SapiContext.getInstance().getSapiOptions().o();
        if (sapiAccount == null || o == null || o.isEmpty() || getInstance().getAccountService().a(sapiAccount, o)) {
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
        }, sapiAccount.bduss, o, z);
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        a();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiContext.getInstance().removeLoginAccount(sapiAccount);
        new com.baidu.sapi2.share.b().a(3);
        try {
            new OpenBdussService(getSapiConfiguration(), "8.9.9.1").logout();
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
        if (k != null) {
            String tid = SapiContext.getInstance().getTid();
            if (!TextUtils.isEmpty(tid)) {
                SapiContext.getInstance().setSearchBoxSid(k.tidConvertSid(tid.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)));
                return;
            } else {
                Log.d(b, "tid is null or empty");
                return;
            }
        }
        Log.d(b, "convert tid to sid failed, because tidConvertSidCallback is null");
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public boolean validate(SapiAccount sapiAccount) {
        a();
        if (SapiAccount.isValidAccount(sapiAccount)) {
            SapiShareClient.getInstance().validate(sapiAccount);
            return true;
        }
        return false;
    }

    private void b(String str) {
        if (!SapiUtils.isDebug(d.context) && !d.debug) {
            Log.e(str, new Object[0]);
            return;
        }
        throw new RuntimeException(str);
    }

    boolean a(String str) {
        return !TextUtils.isEmpty(str) && l.contains(str);
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        a();
        SapiStatUtil.statLoadLogin("product_line_call");
        List<ShareStorage.StorageModel> shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(d.context);
        if (shareStorageModel.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            SapiStatUtil.statShareV2Open(shareStorageModel, "product_line_call", arrayList);
        }
        return shareStorageModel;
    }

    void a() {
        ReceiveShareListener receiveShareListener;
        if (d == null && (receiveShareListener = h) != null) {
            receiveShareListener.onReceiveShare();
        }
        if (d == null) {
            if (Log.enabled) {
                throw new IllegalStateException(SapiAccountManager.class.getSimpleName() + " have not been initialized");
            }
            android.util.Log.e(Log.TAG, "pass sdk have not been initialized");
        }
    }

    public void getOneKeyLoginIsAvailable(GetOneKeyLoginStateDTO getOneKeyLoginStateDTO, OneKeyLoginCallback oneKeyLoginCallback) {
        if (oneKeyLoginCallback == null) {
            Log.e(b, "When check oneKeyLogin's ability, oneKeyLoginCallback can't be null!");
        } else if (Build.VERSION.SDK_INT < 19) {
            new OneKeyLoginSdkCall().b(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_ANDROID_VERSION_BELOW_KITKAT, null);
        } else if (new OneKeyLoginSdkCall().a()) {
            JSONObject b2 = new OneKeyLoginSdkCall().b();
            e.checkOneKeyLoginIsAvailable(oneKeyLoginCallback, b2 != null ? b2.optString("phone") : null, getOneKeyLoginStateDTO.connectTimeout);
        } else {
            new OneKeyLoginSdkCall().a(d, OneKeyLoginSdkCall.m, getOneKeyLoginStateDTO.connectTimeout, oneKeyLoginCallback);
        }
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

    public String getSession(String str) {
        a();
        return getSession(str, null);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiAccount getSession() {
        a();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (this.f3221a == 0) {
            e sapiOptions = SapiContext.getInstance().getSapiOptions();
            if (sapiOptions.m().contains(getConfignation().tpl) && !sapiOptions.m) {
                this.f3221a = (char) 1;
            } else {
                this.f3221a = (char) 2;
            }
        }
        if (currentAccount != null && this.f3221a == 1) {
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

    private boolean c(Context context) {
        String curProcessName = SapiUtils.getCurProcessName(context);
        if (TextUtils.isEmpty(curProcessName)) {
            return false;
        }
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return curProcessName.equals(a2) || curProcessName.equals(d.processName);
    }
}
