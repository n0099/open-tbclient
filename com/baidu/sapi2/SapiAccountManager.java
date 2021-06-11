package com.baidu.sapi2;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.TidConvertSidCallback;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.outsdk.PassBiometricCall;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.service.interfaces.ISAccountService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.CommonUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SafeService;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
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
    public static final String TAG = "SapiAccountManager";
    public static final int VERSION_CODE = 250;
    public static final String VERSION_NAME = "9.3.2.5";
    public static CheckUrlIsAvailableListener checkUrlIsAvailablelister;
    public static GlobalCallback globalCallback;
    public static SapiAccountManager instance;
    public static SapiAccountService sapiAccountService;
    public static SapiConfiguration sapiConfiguration;
    public static ServiceManager serviceManager;
    public static final List<String> sessionKeys;
    public static TidConvertSidCallback tidConvertSidCallback;
    public char isUseOpenBdussTpl = 0;

    /* loaded from: classes2.dex */
    public interface CheckUrlIsAvailableListener {
        void handleWebPageUrl(String str);

        boolean onCheckUrlIsAvailable(String str);
    }

    static {
        ArrayList arrayList = new ArrayList();
        sessionKeys = arrayList;
        arrayList.add("uid");
        sessionKeys.add("displayname");
        sessionKeys.add("bduss");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIntegratedEnviroment() {
        try {
            Class.forName("com.baidu.pass.Constant");
        } catch (Exception unused) {
            CommonUtil.throwException("please update pass-httpclient sdk to last version");
        }
        try {
            Class.forName("com.baidu.sofire.ac.FH");
        } catch (Exception unused2) {
            CommonUtil.throwException("please import the package : sofire-sdk-*.aar");
        }
        if (sapiConfiguration.supportFaceLogin) {
            try {
                Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
            } catch (Throwable unused3) {
                CommonUtil.throwException("please import the package :pass-module-face.aar");
            }
        }
        if (sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED || globalCallback != null) {
            return;
        }
        CommonUtil.showErrorNotice("please register globalCallback to support share login function");
    }

    private String getAppProcessName(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    public static CheckUrlIsAvailableListener getCheckUrlIsAvailablelister() {
        return checkUrlIsAvailablelister;
    }

    public static GlobalCallback getGlobalCallback() {
        GlobalCallback globalCallback2 = globalCallback;
        return globalCallback2 == null ? new GlobalCallback() { // from class: com.baidu.sapi2.SapiAccountManager.2
            @Override // com.baidu.sapi2.callback.GlobalCallback
            public void onLoginStatusChange() {
            }

            @Override // com.baidu.sapi2.callback.GlobalCallback
            public void onNeedInitPassSdk() {
            }
        } : globalCallback2;
    }

    public static synchronized SapiAccountManager getInstance() {
        SapiAccountManager sapiAccountManager;
        synchronized (SapiAccountManager.class) {
            if (instance == null) {
                instance = new SapiAccountManager();
            }
            sapiAccountManager = instance;
        }
        return sapiAccountManager;
    }

    public static TidConvertSidCallback getTidConvertSidCallback() {
        return tidConvertSidCallback;
    }

    private boolean isAppProcess(Context context) {
        String curProcessName = SapiUtils.getCurProcessName(context);
        if (TextUtils.isEmpty(curProcessName)) {
            return false;
        }
        String appProcessName = getAppProcessName(context);
        if (TextUtils.isEmpty(appProcessName)) {
            return false;
        }
        return curProcessName.equals(appProcessName) || curProcessName.equals(sapiConfiguration.processName);
    }

    public static void registerCheckUrlIsAvailableListener(CheckUrlIsAvailableListener checkUrlIsAvailableListener) {
        checkUrlIsAvailablelister = checkUrlIsAvailableListener;
    }

    public static void setGlobalCallback(GlobalCallback globalCallback2) {
        globalCallback = globalCallback2;
    }

    public static void setTidConvertSidCallback(TidConvertSidCallback tidConvertSidCallback2) {
        tidConvertSidCallback = tidConvertSidCallback2;
    }

    public static void unregisterCheckUrlIsAvailableListener() {
        checkUrlIsAvailablelister = null;
    }

    public void checkInitialization() {
        if (sapiConfiguration == null) {
            getGlobalCallback().onNeedInitPassSdk();
        }
        if (sapiConfiguration == null) {
            if (!Log.enabled) {
                android.util.Log.e(Log.TAG, "pass sdk have not been initialized");
                return;
            }
            throw new IllegalStateException(SapiAccountManager.class.getSimpleName() + " have not been initialized");
        }
    }

    public SapiAccountService getAccountService() {
        checkInitialization();
        return sapiAccountService;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiConfiguration getConfignation() {
        return sapiConfiguration;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getCurrentZid(Context context) {
        return SapiSafeFacade.getInstance().getCurrentZid(context);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public ISAccountService getIsAccountService() {
        return getAccountService();
    }

    public List<SapiAccount> getLoginAccounts() {
        checkInitialization();
        return SapiContext.getInstance().getLoginAccounts();
    }

    public void getOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback) {
        GetOneKeyLoginStateDTO getOneKeyLoginStateDTO = new GetOneKeyLoginStateDTO();
        getOneKeyLoginStateDTO.connectTimeout = 15000;
        sapiAccountService.getOneKeyLoginIsAvailable(getOneKeyLoginStateDTO, oneKeyLoginCallback);
    }

    public SapiSafeFacade getSafeFacade() {
        checkInitialization();
        return SapiSafeFacade.getInstance();
    }

    public SapiConfiguration getSapiConfiguration() {
        checkInitialization();
        return sapiConfiguration;
    }

    public String getSession(String str, String str2) {
        JSONObject jSONObject;
        checkInitialization();
        SapiAccount session = getSession();
        return (!isValidSessionKey(str) || !isLogin() || session == null || (jSONObject = session.toJSONObject()) == null) ? str2 : jSONObject.optString(str, str2);
    }

    public void getShareModels(long j, ShareModelCallback shareModelCallback) {
        checkInitialization();
        ShareLoginModel.getInstance().getShareModels(j, shareModelCallback);
    }

    public String getTpl() {
        SapiConfiguration sapiConfiguration2 = sapiConfiguration;
        return sapiConfiguration2 == null ? "" : sapiConfiguration2.tpl;
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList() {
        return getV2ShareModelList("");
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getVersionName() {
        return "9.3.2.5";
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getZidAndCheckSafe(Context context, String str, int i2) {
        return SapiSafeFacade.getInstance().getZidAndCheckSafe(context, str, i2);
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration2) {
        if (sapiConfiguration2 != null) {
            new OneKeyLoginSdkCall().initOneKeyLoginSdk(sapiConfiguration2);
            if (sapiConfiguration == null) {
                sapiConfiguration = sapiConfiguration2;
                sapiAccountService = new SapiAccountService();
                ServiceManager serviceManager2 = ServiceManager.getInstance();
                serviceManager = serviceManager2;
                serviceManager2.setIsAccountManager(this);
                if (isAppProcess(sapiConfiguration2.context)) {
                    Log.d("SDK_INIT", "start time=" + System.currentTimeMillis());
                    ActivityStackManager.getInstance().register((Application) sapiConfiguration2.context);
                    ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z;
                            try {
                                SapiAccountManager.this.checkIntegratedEnviroment();
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
                            new ShareCallPacking().syncMarkLoginState((!sapiContext.isFirstLaunch() || SapiAccountManager.sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) ? 0 : 4);
                            sapiConfiguration2.clientIp = SapiUtils.getLocalIpAddress();
                            List<String> initialCachePackagesWhiteList = SapiOptions.getInitialCachePackagesWhiteList();
                            String packageName = sapiConfiguration2.context.getPackageName();
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
                                new SapiCache().init(sapiConfiguration2.context);
                            }
                            sapiContext.setHostsHijacked(SapiDeviceUtils.checkHosts(sapiConfiguration2.context));
                            if (sapiConfiguration2.supportFaceLogin) {
                                new PassBiometricCall().initPassBioSDK(SapiAccountManager.sapiConfiguration);
                            }
                            SafeService safeService = SafeService.getInstance();
                            SapiConfiguration sapiConfiguration3 = sapiConfiguration2;
                            safeService.init(sapiConfiguration3.context, sapiConfiguration3.sofireAppKey, sapiConfiguration3.sofireSecKey, 1);
                            if (TextUtils.isEmpty(SapiUtils.getCookieBduss()) || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
                                SapiAccountManager.getInstance().getAccountService().webLogin(sapiConfiguration2.context);
                            }
                            Log.d("SDK_INIT", "end time=" + System.currentTimeMillis());
                        }
                    }));
                }
            } else {
                Log.d(getClass().getSimpleName() + " had already been initialized", new Object[0]);
            }
        } else {
            throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        }
    }

    public boolean isLogin() {
        checkInitialization();
        return SapiAccount.isValidAccount(SapiContext.getInstance().getCurrentAccount());
    }

    public boolean isValidSessionKey(String str) {
        return !TextUtils.isEmpty(str) && sessionKeys.contains(str);
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
        checkInitialization();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiContext.getInstance().removeLoginAccount(sapiAccount);
        new ShareCallPacking().asyncMarkLoginState(3);
        try {
            new OpenBdussService(getSapiConfiguration(), "9.3.2.5").logout();
        } catch (Throwable unused) {
        }
        if (currentAccount == null || TextUtils.isEmpty(sapiAccount.uid) || !sapiAccount.uid.equals(currentAccount.uid)) {
            return;
        }
        getGlobalCallback().onLogoutSuccess(sapiAccount);
    }

    public void setSid() {
        if (tidConvertSidCallback != null) {
            String tid = SapiContext.getInstance().getTid();
            if (!TextUtils.isEmpty(tid)) {
                SapiContext.getInstance().setSearchBoxSid(tidConvertSidCallback.tidConvertSid(tid.split("-")));
                return;
            } else {
                Log.d(TAG, "tid is null or empty");
                return;
            }
        }
        Log.d(TAG, "convert tid to sid failed, because tidConvertSidCallback is null");
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public boolean validate(SapiAccount sapiAccount) {
        checkInitialization();
        if (sapiAccount == null) {
            return false;
        }
        ShareAccountAccessor.getAccessor().updatePtoken(sapiAccount);
        SapiContext sapiContext = SapiContext.getInstance();
        sapiContext.setCurrentAccount(sapiAccount);
        sapiContext.addLoginAccount(sapiAccount);
        new PtokenStat().onEvent(PtokenStat.NATIVE_2_WEB);
        new ShareStorage().asyncSet(2);
        return true;
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        checkInitialization();
        return ShareLoginModel.getInstance().getV2ShareModelList(str);
    }

    public String getSession(String str) {
        checkInitialization();
        return getSession(str, null);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiAccount getSession() {
        checkInitialization();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (this.isUseOpenBdussTpl == 0) {
            SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
            if (sapiOptions.getOpenBdussTpls().contains(getConfignation().tpl) && !sapiOptions.canGetBduss) {
                this.isUseOpenBdussTpl = (char) 1;
            } else {
                this.isUseOpenBdussTpl = (char) 2;
            }
        }
        if (currentAccount != null && this.isUseOpenBdussTpl == 1) {
            currentAccount.uid = "";
            currentAccount.bduss = "";
        }
        return currentAccount;
    }
}
