package com.baidu.sapi2;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.GetUserAttrInfoCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.callback.IsShowRealNameCallback;
import com.baidu.sapi2.callback.LoginWithUCAuthCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.ShareModelResultCallback;
import com.baidu.sapi2.callback.ShareModelWithCheckCallback;
import com.baidu.sapi2.callback.TidConvertSidCallback;
import com.baidu.sapi2.callback.UbcUploadImplCallback;
import com.baidu.sapi2.callback.UserLogoutCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.GetUserAttrInfoDTO;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.loginhistory.AccountLoginAction;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.outsdk.PassBiometricCall;
import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.LoginWithUCAuthResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.service.interfaces.ISAccountService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.stat.HistoryLoginStat;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.CommonUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.tieba.nl1;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SapiAccountManager implements ISAccountManager {
    public static final int LOGOUT_TYPE_CLOSE_AN_ACCOUNT = 4;
    public static final int LOGOUT_TYPE_DEFAULT = 0;
    public static final int LOGOUT_TYPE_FREEZE_AN_ACCOUNT = 5;
    public static final int LOGOUT_TYPE_LOGIN_STATUS_ERROR = 3;
    public static final int LOGOUT_TYPE_LOGIN_STATUS_OVERDUE = 2;
    public static final int LOGOUT_TYPE_USER_OPERATION = 1;
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final String TAG = "SapiAccountManager";
    public static final int VERSION_CODE = 250;
    public static final String VERSION_NAME = "9.7.5";
    public static CheckUrlIsAvailableListener checkUrlIsAvailablelister;
    public static GlobalCallback globalCallback;
    public static SapiAccountManager instance;
    public static SapiAccountService sapiAccountService;
    public static SapiConfiguration sapiConfiguration;
    public static ServiceManager serviceManager;
    public static final List<String> sessionKeys;
    public static TidConvertSidCallback tidConvertSidCallback;
    public char isUseOpenBdussTpl = 0;
    public UbcUploadImplCallback ubcUploadImplCallback;

    /* loaded from: classes2.dex */
    public interface CheckUrlIsAvailableListener {
        void handleWebPageUrl(String str);

        boolean onCheckUrlIsAvailable(String str);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getVersionName() {
        return "9.7.5";
    }

    static {
        ArrayList arrayList = new ArrayList();
        sessionKeys = arrayList;
        arrayList.add("uid");
        sessionKeys.add("displayname");
        sessionKeys.add("bduss");
    }

    public static CheckUrlIsAvailableListener getCheckUrlIsAvailablelister() {
        return checkUrlIsAvailablelister;
    }

    public static GlobalCallback getGlobalCallback() {
        GlobalCallback globalCallback2 = globalCallback;
        if (globalCallback2 == null) {
            return new GlobalCallback() { // from class: com.baidu.sapi2.SapiAccountManager.8
                @Override // com.baidu.sapi2.callback.GlobalCallback
                public void onLoginStatusChange() {
                }

                @Override // com.baidu.sapi2.callback.GlobalCallback
                public void onNeedInitPassSdk() {
                }
            };
        }
        return globalCallback2;
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

    public static void unregisterCheckUrlIsAvailableListener() {
        checkUrlIsAvailablelister = null;
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
    public ISAccountService getIsAccountService() {
        return getAccountService();
    }

    public List<SapiAccount> getLoginAccounts() {
        checkInitialization();
        return SapiContext.getInstance().getLoginAccounts();
    }

    public SapiSafeFacade getSafeFacade() {
        checkInitialization();
        return SapiSafeFacade.getInstance();
    }

    public SapiConfiguration getSapiConfiguration() {
        checkInitialization();
        return sapiConfiguration;
    }

    public int getSmsCodeLength() {
        return EnhancedService.getInstance(sapiConfiguration, "9.7.5").getSmsCodeLength();
    }

    public String getTpl() {
        SapiConfiguration sapiConfiguration2 = sapiConfiguration;
        if (sapiConfiguration2 == null) {
            return "";
        }
        return sapiConfiguration2.tpl;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public UbcUploadImplCallback getUbcUploadImplCallback() {
        UbcUploadImplCallback ubcUploadImplCallback = this.ubcUploadImplCallback;
        if (ubcUploadImplCallback == null) {
            return new UbcUploadImplCallback() { // from class: com.baidu.sapi2.SapiAccountManager.9
                @Override // com.baidu.sapi2.callback.UbcUploadImplCallback
                public void onEvent(String str, JSONObject jSONObject) {
                }
            };
        }
        return ubcUploadImplCallback;
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList() {
        return getV2ShareModelList("");
    }

    public boolean isLogin() {
        checkInitialization();
        return SapiAccount.isValidAccount(SapiContext.getInstance().getCurrentAccount());
    }

    public void logout() {
        logout(0);
    }

    private String getAppProcessName(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSofireSDK(SapiConfiguration sapiConfiguration2) {
        FH.init(sapiConfiguration2.context, sapiConfiguration2.sofireAppKey, sapiConfiguration2.sofireSecKey, 1);
        FH.setAgreePolicy(sapiConfiguration2.context, sapiConfiguration2.isAgreeDangerousProtocol());
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
        if (!curProcessName.equals(appProcessName) && !curProcessName.equals(sapiConfiguration.processName)) {
            return false;
        }
        return true;
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

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getCurrentZid(Context context) {
        return SapiSafeFacade.getInstance().getCurrentZid(context);
    }

    public void getOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback) {
        GetOneKeyLoginStateDTO getOneKeyLoginStateDTO = new GetOneKeyLoginStateDTO();
        getOneKeyLoginStateDTO.connectTimeout = 15000;
        sapiAccountService.getOneKeyLoginIsAvailable(getOneKeyLoginStateDTO, oneKeyLoginCallback);
    }

    public String getSession(String str) {
        checkInitialization();
        return getSession(str, null);
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        checkInitialization();
        ShareLoginStat.GetShareListStat.statExtMap.put("api_name", ShareLoginStat.GetShareListStat.VALUE_API_NAME_V2);
        List<ShareStorage.StorageModel> v2ShareModelList = ShareLoginModel.getInstance().getV2ShareModelList(str);
        ShareLoginStat.GetShareListStat.upload();
        return v2ShareModelList;
    }

    public void isShowRealNameGuide(IsShowRealNameCallback isShowRealNameCallback) {
        String str;
        IsShowRealNameGuideDTO isShowRealNameGuideDTO = new IsShowRealNameGuideDTO();
        isShowRealNameGuideDTO.type = IsShowRealNameGuideDTO.TYPE_SETTING;
        SapiAccount session = getSession();
        if (session != null) {
            str = session.uid;
        } else {
            str = "";
        }
        isShowRealNameGuideDTO.historyTime = SapiContext.getInstance().getClickRealNameTimes(str);
        getInstance().getAccountService().isShowRealNameGuide(isShowRealNameGuideDTO, isShowRealNameCallback);
    }

    public boolean isValidSessionKey(String str) {
        if (!TextUtils.isEmpty(str) && sessionKeys.contains(str)) {
            return true;
        }
        return false;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        SapiConfiguration sapiConfiguration2 = getSapiConfiguration();
        if (sapiConfiguration2 != null) {
            sapiConfiguration2.setAgreeDangerousProtocol(z);
            nl1.d().i(sapiConfiguration2.context, sapiConfiguration2.isAgreeDangerousProtocol());
            sapiConfiguration2.clientIp = SapiUtils.getLocalIpAddress();
            if (sapiConfiguration2.supportFaceLogin) {
                new PassBiometricCall().setFaceModuleAgreeDangerousProtocol(z);
            }
        }
    }

    public void setUbcUploadImplCallback(UbcUploadImplCallback ubcUploadImplCallback) {
        this.ubcUploadImplCallback = ubcUploadImplCallback;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public boolean validate(SapiAccount sapiAccount) {
        return validate(sapiAccount, true, true);
    }

    private void statLoginHistoryLogin(boolean z, boolean z2) {
        String str;
        HashMap hashMap = new HashMap();
        String str2 = "1";
        hashMap.put("show_count", "1");
        if (!z2) {
            str2 = "0";
        }
        hashMap.put("success_count", str2);
        if (z) {
            str = "na";
        } else {
            str = DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB;
        }
        hashMap.put("f", str);
        StatService.onEventAutoStat("na_history_login", hashMap);
    }

    public String getSession(String str, String str2) {
        JSONObject jSONObject;
        checkInitialization();
        SapiAccount session = getSession();
        if (isValidSessionKey(str) && isLogin() && session != null && (jSONObject = session.toJSONObject()) != null) {
            return jSONObject.optString(str, str2);
        }
        return str2;
    }

    public void getShareModels(long j, final ShareModelCallback shareModelCallback) {
        checkInitialization();
        ShareLoginStat.GetShareListStat.statExtMap.put("api_name", ShareLoginStat.GetShareListStat.VALUE_API_NAME_NEW);
        ShareLoginModel.getInstance().getShareModels(j, new ShareModelWithCheckCallback() { // from class: com.baidu.sapi2.SapiAccountManager.6
            public void compatibilityOld(List<ShareStorage.StorageModel> list, String str) {
                SapiAccountManager.this.onShareEvent(list, str);
                shareModelCallback.onReceiveShareModels(list);
            }

            @Override // com.baidu.sapi2.callback.ShareModelWithCheckCallback
            public void onSuccess(List<ShareStorage.StorageModel> list, String str) {
                compatibilityOld(list, str);
            }

            @Override // com.baidu.sapi2.callback.ShareModelWithCheckCallback
            public void onFailure(int i, String str, String str2) {
                compatibilityOld(new ArrayList(), str2);
            }
        });
    }

    public void loadHistoryActionLoginFromNa(LoginHistoryModel loginHistoryModel, LoginHistoryCallback loginHistoryCallback) {
        loadHistoryActionLogin(loginHistoryModel, loginHistoryCallback, true);
        HistoryLoginStat.HistoryClickLoginStat.sValueSence = "out";
    }

    public void loadHistoryActionLoginFromWap(LoginHistoryModel loginHistoryModel, LoginHistoryCallback loginHistoryCallback) {
        loadHistoryActionLogin(loginHistoryModel, loginHistoryCallback, false);
        HistoryLoginStat.HistoryClickLoginStat.sValueSence = "in";
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
        if (sapiConfiguration.loginShareStrategy() != LoginShareStrategy.DISABLED && globalCallback == null) {
            CommonUtil.showErrorNotice("please register globalCallback to support share login function");
        }
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

    private void loadHistoryActionLogin(LoginHistoryModel loginHistoryModel, LoginHistoryCallback loginHistoryCallback, boolean z) {
        List<AccountLoginAction> loadHistoryAccounts = LoginHistoryLoginModel.loadHistoryAccounts();
        if (loadHistoryAccounts != null && loadHistoryAccounts.size() != 0) {
            int size = loadHistoryAccounts.size();
            for (int i = 0; i < size; i++) {
                AccountLoginAction accountLoginAction = loadHistoryAccounts.get(i);
                if (TextUtils.equals(SecurityUtil.md5(accountLoginAction.sapiAccount.bduss.getBytes(), false), loginHistoryModel.bduss)) {
                    statLoginHistoryLogin(z, true);
                    validate(accountLoginAction.sapiAccount);
                    getUserInfoAndRefershAccount(accountLoginAction.sapiAccount, Enums.LastLoginType.HISTORY.getValue(), new JSONObject().toString());
                    SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.HISTORY.getName());
                    SapiUtils.getLastLoginType();
                    loginHistoryCallback.onLoginSuccess(accountLoginAction.sapiAccount);
                    HistoryLoginStat.HistoryClickLoginStat.sValue = "1";
                    HistoryLoginStat.HistoryClickLoginStat.upload();
                    return;
                }
            }
            statLoginHistoryLogin(z, false);
            HistoryLoginStat.HistoryClickLoginStat.sValue = "0";
            HistoryLoginStat.HistoryClickLoginStat.upload();
            loginHistoryCallback.onLoginFailure();
            return;
        }
        statLoginHistoryLogin(z, false);
        loginHistoryCallback.onLoginFailure();
        HistoryLoginStat.HistoryClickLoginStat.sValue = "0";
        HistoryLoginStat.HistoryClickLoginStat.upload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAvailableHistory(List<LoginHistoryItem> list, JSONArray jSONArray, LoginHistoryCallback loginHistoryCallback) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                String optString = jSONObject.optString("loginType");
                String optString2 = jSONObject.optString("bduss");
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(optString, "history")) {
                    List<AccountLoginAction> loadHistoryAccounts = LoginHistoryLoginModel.loadHistoryAccounts();
                    if (loadHistoryAccounts != null && !loadHistoryAccounts.isEmpty()) {
                        for (int i2 = 0; i2 < loadHistoryAccounts.size(); i2++) {
                            AccountLoginAction accountLoginAction = loadHistoryAccounts.get(i2);
                            if (TextUtils.equals(SecurityUtil.md5(accountLoginAction.sapiAccount.bduss.getBytes(), false), optString2)) {
                                jSONObject.put("uid", accountLoginAction.sapiAccount.uid);
                            }
                        }
                    }
                    arrayList.add(LoginHistoryModel.fromJSONObject(jSONObject));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_HISTORY_COUNT, "" + list.size());
        hashMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_AVAILABLE_COUNT, "" + arrayList.size());
        StatService.onEventAutoStat("na_history_show", hashMap);
        if (arrayList.size() > 0) {
            HistoryLoginStat.HistoryShowStat.statExtMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_AVAILABLE_COUNT, Integer.valueOf(arrayList.size()));
            loginHistoryCallback.onSuccess(arrayList);
        } else {
            HistoryLoginStat.HistoryShowStat.statExtMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_AVAILABLE_COUNT, 0);
            loginHistoryCallback.onFailure();
        }
        HistoryLoginStat.HistoryShowStat.upload();
    }

    public void checkAvailableLoginHistory(final LoginHistoryCallback loginHistoryCallback) {
        String jSONArray;
        final List<LoginHistoryItem> availableLoginHistoryItems = LoginHistoryLoginModel.getAvailableLoginHistoryItems();
        JSONArray jSONArray2 = LoginHistoryItem.toJSONArray(availableLoginHistoryItems);
        if (jSONArray2 == null) {
            jSONArray = null;
        } else {
            jSONArray = jSONArray2.toString();
        }
        if (availableLoginHistoryItems != null) {
            HistoryLoginStat.HistoryShowStat.statExtMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_HISTORY_COUNT, Integer.valueOf(availableLoginHistoryItems.size()));
        } else {
            HistoryLoginStat.HistoryShowStat.statExtMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_HISTORY_COUNT, 0);
        }
        if (TextUtils.isEmpty(jSONArray)) {
            HashMap hashMap = new HashMap();
            hashMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_HISTORY_COUNT, "0");
            hashMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_AVAILABLE_COUNT, "0");
            StatService.onEventAutoStat("na_history_show", hashMap);
            loginHistoryCallback.onFailure();
            return;
        }
        getInstance().getAccountService().checkAvailableLoginHistory(jSONArray, new LoginHistoryCallback() { // from class: com.baidu.sapi2.SapiAccountManager.4
            @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
            public void onFailure() {
                HistoryLoginStat.HistoryShowStat.statExtMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_AVAILABLE_COUNT, 0);
                HistoryLoginStat.HistoryShowStat.upload();
                loginHistoryCallback.onFailure();
            }

            @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
            public void onResult(JSONArray jSONArray3) {
                SapiAccountManager.this.processAvailableHistory(availableLoginHistoryItems, jSONArray3, loginHistoryCallback);
            }
        });
    }

    public void getShareModels(long j, final ShareModelResultCallback shareModelResultCallback) {
        checkInitialization();
        ShareLoginStat.GetShareListStat.statExtMap.put("api_name", ShareLoginStat.GetShareListStat.VALUE_API_NAME_NEW);
        ShareLoginModel.getInstance().getShareModels(j, new ShareModelWithCheckCallback() { // from class: com.baidu.sapi2.SapiAccountManager.7
            @Override // com.baidu.sapi2.callback.ShareModelWithCheckCallback
            public void onSuccess(List<ShareStorage.StorageModel> list, String str) {
                shareModelResultCallback.onSuccess(list);
            }

            @Override // com.baidu.sapi2.callback.ShareModelWithCheckCallback
            public void onFailure(int i, String str, String str2) {
                SapiAccountManager.this.onShareEvent(new ArrayList(), str2);
                ShareModelResultCallback shareModelResultCallback2 = shareModelResultCallback;
                if (shareModelResultCallback2 != null) {
                    shareModelResultCallback2.onFailure(i, str);
                }
            }
        });
    }

    public void getUserAttrInfo(GetUserAttrInfoDTO getUserAttrInfoDTO, GetUserAttrInfoCallback getUserAttrInfoCallback) {
        if (getUserAttrInfoDTO != null && !TextUtils.isEmpty(getUserAttrInfoDTO.mAppname)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null && !TextUtils.isEmpty(currentAccount.bduss)) {
                List<String> list = getUserAttrInfoDTO.mFields;
                StringBuilder sb = new StringBuilder();
                sb.append(PreferencesUtil.LEFT_MOUNT);
                if (list != null && list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
                        String str = list.get(i);
                        if (str != null) {
                            sb.append("\"");
                            sb.append(str);
                            sb.append("\"");
                            if (i < list.size() - 1) {
                                sb.append(",");
                            }
                        }
                    }
                }
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                List<String> list2 = getUserAttrInfoDTO.mExtFields;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(PreferencesUtil.LEFT_MOUNT);
                if (list2 != null && list2.size() != 0) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        String str2 = list2.get(i2);
                        if (str2 != null) {
                            sb2.append("\"");
                            sb2.append(str2);
                            sb2.append("\"");
                            if (i2 < list2.size() - 1) {
                                sb2.append(",");
                            }
                        }
                    }
                }
                sb2.append(PreferencesUtil.RIGHT_MOUNT);
                String substring = SecurityUtil.md5(String.format("%s%s%s%s", currentAccount.bduss, getUserAttrInfoDTO.mAppname, sb, sb2).getBytes(), false).substring(0, 16);
                GetUserAttrInfoResult parseFromJSONObject = GetUserAttrInfoResult.parseFromJSONObject(SapiContext.getInstance().getUserAttrInfo(substring));
                String str3 = SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_FUSION).extraParams;
                long j = 0;
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        j = new JSONObject(str3).optLong("rt");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (parseFromJSONObject.isAvailable(j)) {
                    getUserAttrInfoCallback.onSuccess(parseFromJSONObject);
                    return;
                } else {
                    getInstance().getAccountService().getUserAttrInfo(getUserAttrInfoDTO.mAppname, sb.toString(), sb2.toString(), substring, getUserAttrInfoCallback);
                    return;
                }
            }
            GetUserAttrInfoResult getUserAttrInfoResult = new GetUserAttrInfoResult();
            getUserAttrInfoResult.setResultCode(-102);
            getUserAttrInfoResult.setResultMsg(GetUserAttrInfoResult.MSG_NOT_LOGIN);
            getUserAttrInfoCallback.onFailure(getUserAttrInfoResult);
            return;
        }
        GetUserAttrInfoResult getUserAttrInfoResult2 = new GetUserAttrInfoResult();
        getUserAttrInfoResult2.setResultCode(-103);
        getUserAttrInfoResult2.setResultMsg("请核对入参");
        getUserAttrInfoCallback.onFailure(getUserAttrInfoResult2);
    }

    public void getUserInfoAndRefershAccount(final SapiAccount sapiAccount, int i, String str) {
        if (sapiAccount == null) {
            return;
        }
        getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiAccountManager.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                if (getUserInfoResult != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(getUserInfoResult.uid)) {
                    SapiAccount sapiAccount2 = sapiAccount;
                    sapiAccount2.username = getUserInfoResult.username;
                    sapiAccount2.displayname = getUserInfoResult.displayname;
                    sapiAccount2.portrait = getUserInfoResult.portraitSign;
                    SapiAccountManager.getInstance().validate(sapiAccount);
                }
            }
        }, sapiAccount.bduss, String.valueOf(i), str);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getZidAndCheckSafe(Context context, String str, int i) {
        return SapiSafeFacade.getInstance().getZidAndCheckSafe(context, str, i);
    }

    public boolean validate(SapiAccount sapiAccount, boolean z, boolean z2) {
        checkInitialization();
        if (sapiAccount == null) {
            return false;
        }
        ShareAccountAccessor.getAccessor().updatePtoken(sapiAccount);
        SapiContext sapiContext = SapiContext.getInstance();
        sapiContext.setCurrentAccount(sapiAccount, z2);
        sapiContext.addLoginAccount(sapiAccount);
        new PtokenStat().onEvent(PtokenStat.NATIVE_2_WEB);
        if (z) {
            new ShareStorage().asyncSet(2);
            return true;
        }
        return true;
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration2) {
        if (sapiConfiguration2 != null) {
            if (sapiConfiguration == null) {
                sapiConfiguration = sapiConfiguration2;
                sapiAccountService = new SapiAccountService();
                ServiceManager serviceManager2 = ServiceManager.getInstance();
                serviceManager = serviceManager2;
                serviceManager2.setIsAccountManager(this);
                setUbcUploadImplCallback(sapiConfiguration2.ubcUploadImplCallback);
                new OneKeyLoginSdkCall().initOneKeyLoginSdk(sapiConfiguration2);
                if (isAppProcess(sapiConfiguration2.context)) {
                    Log.d("SDK_INIT", "start time=" + System.currentTimeMillis());
                    ActivityStackManager.getInstance().register((Application) sapiConfiguration2.context);
                    ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i;
                            boolean z;
                            try {
                                SapiAccountManager.this.checkIntegratedEnviroment();
                            } catch (RuntimeException e) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        throw e;
                                    }
                                });
                            }
                            SapiContext sapiContext = SapiContext.getInstance();
                            sapiContext.setShareStorage(null);
                            if (sapiContext.isFirstLaunch() && SapiAccountManager.sapiConfiguration.loginShareStrategy() != LoginShareStrategy.DISABLED) {
                                i = 4;
                            } else {
                                i = 0;
                            }
                            new ShareCallPacking().syncMarkLoginState(i);
                            sapiConfiguration2.clientIp = SapiUtils.getLocalIpAddress();
                            List<String> initialCachePackagesWhiteList = SapiOptions.getInitialCachePackagesWhiteList();
                            String packageName = sapiConfiguration2.context.getPackageName();
                            Iterator<String> it = initialCachePackagesWhiteList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (packageName.matches(it.next())) {
                                        z = false;
                                        break;
                                    }
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                new SapiCache().init(sapiConfiguration2.context);
                            }
                            sapiContext.setHostsHijacked(SapiDeviceUtils.checkHosts(sapiConfiguration2.context));
                            if (sapiConfiguration2.supportFaceLogin) {
                                try {
                                    Class.forName("com.baidu.pass.face.platform.FaceSDKManager");
                                    new PassBiometricCall().initPassBioSDK(SapiAccountManager.sapiConfiguration);
                                } catch (Exception unused) {
                                    Log.e("SDK_INIT", "VIS SDK可能未集成，请集成正确的VIS SDK");
                                    sapiConfiguration2.supportFaceLogin = false;
                                }
                            }
                            if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_NEW_INIT_SOFIRE).meetGray) {
                                Log.e("SDK_INIT", "old sofire init run");
                                SapiAccountManager.this.initSofireSDK(sapiConfiguration2);
                            }
                            if (TextUtils.isEmpty(SapiUtils.getCookieBduss()) || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
                                SapiAccountManager.getInstance().getAccountService().webLogin(sapiConfiguration2.context);
                            }
                            Log.d("SDK_INIT", "end time=" + System.currentTimeMillis());
                            LoginHistoryLoginModel.updateLoginHistoryInfo();
                            SapiConfiguration sapiConfiguration3 = sapiConfiguration2;
                            SapiUtils.setCookiesTPLCuid(sapiConfiguration3.context, sapiConfiguration3.mTPLCuid);
                        }
                    }));
                    if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_NEW_INIT_SOFIRE).meetGray) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.sapi2.SapiAccountManager.2.1
                                        @Override // android.os.MessageQueue.IdleHandler
                                        public boolean queueIdle() {
                                            Log.e("SDK_INIT", "new sofire init run");
                                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                            SapiAccountManager.this.initSofireSDK(sapiConfiguration2);
                                            return false;
                                        }
                                    });
                                } catch (Exception e) {
                                    SapiAccountManager.this.initSofireSDK(sapiConfiguration2);
                                    Log.e(e);
                                }
                            }
                        });
                    }
                }
            } else {
                Log.d(getClass().getSimpleName() + " had already been initialized", new Object[0]);
            }
        } else {
            throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        }
    }

    public void loginWithUCAuth(String str, LoginWithUCAuthCallback loginWithUCAuthCallback) {
        if (TextUtils.isEmpty(str)) {
            LoginWithUCAuthResult loginWithUCAuthResult = new LoginWithUCAuthResult();
            loginWithUCAuthResult.setResultCode(-103);
            loginWithUCAuthResult.setResultMsg("请核对入参");
            loginWithUCAuthCallback.onFailure(loginWithUCAuthResult);
        } else if (sapiConfiguration == null) {
            LoginWithUCAuthResult loginWithUCAuthResult2 = new LoginWithUCAuthResult();
            loginWithUCAuthResult2.setResultCode(-102);
            loginWithUCAuthResult2.setResultMsg(LoginWithUCAuthResult.MSG_NOT_INIT);
            loginWithUCAuthCallback.onFailure(loginWithUCAuthResult2);
        } else {
            SapiAccountService accountService = getInstance().getAccountService();
            SapiConfiguration sapiConfiguration2 = sapiConfiguration;
            accountService.loginWithUCAuth(sapiConfiguration2.tpl, sapiConfiguration2.appId, str, loginWithUCAuthCallback);
        }
    }

    public void logout(int i) {
        getInstance().getAccountService().userLogout(i, new UserLogoutCallback() { // from class: com.baidu.sapi2.SapiAccountManager.3
            @Override // com.baidu.sapi2.callback.UserLogoutCallback
            public void onFailure(SapiResult sapiResult) {
                Object valueOf;
                Object[] objArr = new Object[1];
                if (sapiResult == null) {
                    valueOf = "result is null";
                } else {
                    valueOf = Integer.valueOf(sapiResult.getResultCode());
                }
                objArr[0] = valueOf;
                Log.e(Log.TAG, objArr);
            }

            @Override // com.baidu.sapi2.callback.UserLogoutCallback
            public void onSuccess(SapiResult sapiResult) {
                Object valueOf;
                Object[] objArr = new Object[1];
                if (sapiResult == null) {
                    valueOf = "result is null";
                } else {
                    valueOf = Integer.valueOf(sapiResult.getResultCode());
                }
                objArr[0] = valueOf;
                Log.e(Log.TAG, objArr);
            }
        });
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
        if (currentAccount != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(currentAccount.uid)) {
            getGlobalCallback().onLogoutSuccess(sapiAccount);
        }
    }

    public void onShareEvent(List<ShareStorage.StorageModel> list, String str) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            for (ShareStorage.StorageModel storageModel : list) {
                if (storageModel != null) {
                    jSONArray.put(storageModel.tpl);
                    jSONArray2.put(storageModel.app);
                    i++;
                }
            }
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_APPS, jSONArray2);
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_TPLS, jSONArray);
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_SIZE, Integer.valueOf(i));
            ShareLoginStat.GetShareListStat.upload();
            return;
        }
        ShareLoginStat.GetShareListStat.upload();
    }

    public void validateBdussCookie(Context context) {
        String cookieBduss = SapiUtils.getCookieBduss();
        String cookieBdussBfess = SapiUtils.getCookieBdussBfess();
        if (TextUtils.isEmpty(cookieBduss) && !TextUtils.isEmpty(cookieBdussBfess)) {
            SapiUtils.webLogout(context);
        }
        if (!TextUtils.isEmpty(cookieBduss) && TextUtils.isEmpty(cookieBdussBfess)) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str : SapiUtils.getAuthorizedDomains()) {
                    arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str, SapiUtils.buildBDUSSBFESSCookie(str, cookieBduss)));
                }
                SapiUtils.syncCookies(context, arrayList);
            } catch (Throwable th) {
                Log.e(th.getMessage(), new Object[0]);
            }
        }
    }
}
