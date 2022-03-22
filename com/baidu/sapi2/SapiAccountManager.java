package com.baidu.sapi2;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.l0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.ShareModelResultCallback;
import com.baidu.sapi2.callback.ShareModelWithCheckCallback;
import com.baidu.sapi2.callback.TidConvertSidCallback;
import com.baidu.sapi2.callback.UbcUploadImplCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.loginhistory.AccountLoginAction;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.outsdk.PassBiometricCall;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SapiAccountManager implements ISAccountManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final String TAG = "SapiAccountManager";
    public static final int VERSION_CODE = 250;
    public static final String VERSION_NAME = "9.5.5";
    public static CheckUrlIsAvailableListener checkUrlIsAvailablelister;
    public static GlobalCallback globalCallback;
    public static SapiAccountManager instance;
    public static SapiAccountService sapiAccountService;
    public static SapiConfiguration sapiConfiguration;
    public static ServiceManager serviceManager;
    public static final List<String> sessionKeys;
    public static TidConvertSidCallback tidConvertSidCallback;
    public transient /* synthetic */ FieldHolder $fh;
    public char isUseOpenBdussTpl;
    public UbcUploadImplCallback ubcUploadImplCallback;

    /* loaded from: classes4.dex */
    public interface CheckUrlIsAvailableListener {
        void handleWebPageUrl(String str);

        boolean onCheckUrlIsAvailable(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1635182462, "Lcom/baidu/sapi2/SapiAccountManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1635182462, "Lcom/baidu/sapi2/SapiAccountManager;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        sessionKeys = arrayList;
        arrayList.add("uid");
        sessionKeys.add("displayname");
        sessionKeys.add("bduss");
    }

    public SapiAccountManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isUseOpenBdussTpl = (char) 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIntegratedEnviroment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
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
    }

    private String getAppProcessName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
            } catch (Throwable th) {
                Log.e(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static CheckUrlIsAvailableListener getCheckUrlIsAvailablelister() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? checkUrlIsAvailablelister : (CheckUrlIsAvailableListener) invokeV.objValue;
    }

    public static GlobalCallback getGlobalCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            GlobalCallback globalCallback2 = globalCallback;
            return globalCallback2 == null ? new GlobalCallback() { // from class: com.baidu.sapi2.SapiAccountManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.sapi2.callback.GlobalCallback
                public void onLoginStatusChange() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.GlobalCallback
                public void onNeedInitPassSdk() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }
            } : globalCallback2;
        }
        return (GlobalCallback) invokeV.objValue;
    }

    public static synchronized SapiAccountManager getInstance() {
        InterceptResult invokeV;
        SapiAccountManager sapiAccountManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (SapiAccountManager.class) {
                if (instance == null) {
                    instance = new SapiAccountManager();
                }
                sapiAccountManager = instance;
            }
            return sapiAccountManager;
        }
        return (SapiAccountManager) invokeV.objValue;
    }

    public static TidConvertSidCallback getTidConvertSidCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? tidConvertSidCallback : (TidConvertSidCallback) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSofireSDK(SapiConfiguration sapiConfiguration2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, sapiConfiguration2) == null) {
            if (sapiConfiguration2.supportFaceLogin) {
                FH.setFaceLicenseId("pass_auth_id_01");
            }
            FH.init(sapiConfiguration2.context, sapiConfiguration2.sofireAppKey, sapiConfiguration2.sofireSecKey, 1);
        }
    }

    private boolean isAppProcess(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, context)) == null) {
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
        return invokeL.booleanValue;
    }

    private void loadHistoryActionLogin(LoginHistoryModel loginHistoryModel, LoginHistoryCallback loginHistoryCallback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65550, this, loginHistoryModel, loginHistoryCallback, z) == null) {
            List<AccountLoginAction> loadHistoryAccounts = LoginHistoryLoginModel.loadHistoryAccounts();
            if (loadHistoryAccounts != null && loadHistoryAccounts.size() != 0) {
                int size = loadHistoryAccounts.size();
                for (int i = 0; i < size; i++) {
                    AccountLoginAction accountLoginAction = loadHistoryAccounts.get(i);
                    if (TextUtils.equals(SecurityUtil.md5(accountLoginAction.sapiAccount.bduss.getBytes(), false), loginHistoryModel.bduss)) {
                        statLoginHistoryLogin(z, true);
                        validate(accountLoginAction.sapiAccount);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAvailableHistory(List<LoginHistoryItem> list, JSONArray jSONArray, LoginHistoryCallback loginHistoryCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, this, list, jSONArray, loginHistoryCallback) == null) {
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
                } catch (JSONException e2) {
                    e2.printStackTrace();
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
    }

    public static void registerCheckUrlIsAvailableListener(CheckUrlIsAvailableListener checkUrlIsAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, checkUrlIsAvailableListener) == null) {
            checkUrlIsAvailablelister = checkUrlIsAvailableListener;
        }
    }

    public static void setGlobalCallback(GlobalCallback globalCallback2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, globalCallback2) == null) {
            globalCallback = globalCallback2;
        }
    }

    public static void setTidConvertSidCallback(TidConvertSidCallback tidConvertSidCallback2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, tidConvertSidCallback2) == null) {
            tidConvertSidCallback = tidConvertSidCallback2;
        }
    }

    private void statLoginHistoryLogin(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("show_count", "1");
            hashMap.put("success_count", z2 ? "1" : "0");
            hashMap.put("f", z ? "na" : DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB);
            StatService.onEventAutoStat("na_history_login", hashMap);
        }
    }

    public static void unregisterCheckUrlIsAvailableListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            checkUrlIsAvailablelister = null;
        }
    }

    public void checkAvailableLoginHistory(LoginHistoryCallback loginHistoryCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, loginHistoryCallback) == null) {
            List<LoginHistoryItem> availableLoginHistoryItems = LoginHistoryLoginModel.getAvailableLoginHistoryItems();
            JSONArray jSONArray = LoginHistoryItem.toJSONArray(availableLoginHistoryItems);
            String jSONArray2 = jSONArray == null ? null : jSONArray.toString();
            if (availableLoginHistoryItems != null) {
                HistoryLoginStat.HistoryShowStat.statExtMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_HISTORY_COUNT, Integer.valueOf(availableLoginHistoryItems.size()));
            } else {
                HistoryLoginStat.HistoryShowStat.statExtMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_HISTORY_COUNT, 0);
            }
            if (TextUtils.isEmpty(jSONArray2)) {
                HashMap hashMap = new HashMap();
                hashMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_HISTORY_COUNT, "0");
                hashMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_AVAILABLE_COUNT, "0");
                StatService.onEventAutoStat("na_history_show", hashMap);
                loginHistoryCallback.onFailure();
                return;
            }
            getInstance().getAccountService().checkAvailableLoginHistory(jSONArray2, new LoginHistoryCallback(this, availableLoginHistoryItems, loginHistoryCallback) { // from class: com.baidu.sapi2.SapiAccountManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountManager this$0;
                public final /* synthetic */ LoginHistoryCallback val$callback;
                public final /* synthetic */ List val$historyItems;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, availableLoginHistoryItems, loginHistoryCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$historyItems = availableLoginHistoryItems;
                    this.val$callback = loginHistoryCallback;
                }

                @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                public void onFailure() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        HistoryLoginStat.HistoryShowStat.statExtMap.put(HistoryLoginStat.HistoryShowStat.KEY_EXT_AVAILABLE_COUNT, 0);
                        HistoryLoginStat.HistoryShowStat.upload();
                        this.val$callback.onFailure();
                    }
                }

                @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                public void onResult(JSONArray jSONArray3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray3) == null) {
                        this.this$0.processAvailableHistory(this.val$historyItems, jSONArray3, this.val$callback);
                    }
                }
            });
        }
    }

    public void checkInitialization() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
    }

    public SapiAccountService getAccountService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            checkInitialization();
            return sapiAccountService;
        }
        return (SapiAccountService) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiConfiguration getConfignation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? sapiConfiguration : (SapiConfiguration) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getCurrentZid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? SapiSafeFacade.getInstance().getCurrentZid(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public ISAccountService getIsAccountService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getAccountService() : (ISAccountService) invokeV.objValue;
    }

    public List<SapiAccount> getLoginAccounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            checkInitialization();
            return SapiContext.getInstance().getLoginAccounts();
        }
        return (List) invokeV.objValue;
    }

    public void getOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, oneKeyLoginCallback) == null) {
            GetOneKeyLoginStateDTO getOneKeyLoginStateDTO = new GetOneKeyLoginStateDTO();
            getOneKeyLoginStateDTO.connectTimeout = 15000;
            sapiAccountService.getOneKeyLoginIsAvailable(getOneKeyLoginStateDTO, oneKeyLoginCallback);
        }
    }

    public SapiSafeFacade getSafeFacade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            checkInitialization();
            return SapiSafeFacade.getInstance();
        }
        return (SapiSafeFacade) invokeV.objValue;
    }

    public SapiConfiguration getSapiConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            checkInitialization();
            return sapiConfiguration;
        }
        return (SapiConfiguration) invokeV.objValue;
    }

    public String getSession(String str, String str2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            checkInitialization();
            SapiAccount session = getSession();
            return (!isValidSessionKey(str) || !isLogin() || session == null || (jSONObject = session.toJSONObject()) == null) ? str2 : jSONObject.optString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public void getShareModels(long j, ShareModelCallback shareModelCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048589, this, j, shareModelCallback) == null) {
            checkInitialization();
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_API_NAME, ShareLoginStat.GetShareListStat.VALUE_API_NAME_NEW);
            ShareLoginModel.getInstance().getShareModels(j, new ShareModelWithCheckCallback(this, shareModelCallback) { // from class: com.baidu.sapi2.SapiAccountManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountManager this$0;
                public final /* synthetic */ ShareModelCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, shareModelCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = shareModelCallback;
                }

                public void compatibilityOld(List<ShareStorage.StorageModel> list, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, list, str) == null) {
                        this.this$0.onShareEvent(list, str);
                        this.val$callback.onReceiveShareModels(list);
                    }
                }

                @Override // com.baidu.sapi2.callback.ShareModelWithCheckCallback
                public void onFailure(int i, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2) == null) {
                        compatibilityOld(new ArrayList(), str2);
                    }
                }

                @Override // com.baidu.sapi2.callback.ShareModelWithCheckCallback
                public void onSuccess(List<ShareStorage.StorageModel> list, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, str) == null) {
                        compatibilityOld(list, str);
                    }
                }
            });
        }
    }

    public int getSmsCodeLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? EnhancedService.getInstance(sapiConfiguration, "9.5.5").getSmsCodeLength() : invokeV.intValue;
    }

    public String getTpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SapiConfiguration sapiConfiguration2 = sapiConfiguration;
            return sapiConfiguration2 == null ? "" : sapiConfiguration2.tpl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public UbcUploadImplCallback getUbcUploadImplCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            UbcUploadImplCallback ubcUploadImplCallback = this.ubcUploadImplCallback;
            return ubcUploadImplCallback == null ? new UbcUploadImplCallback(this) { // from class: com.baidu.sapi2.SapiAccountManager.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.sapi2.callback.UbcUploadImplCallback
                public void onEvent(String str, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, jSONObject) == null) {
                    }
                }
            } : ubcUploadImplCallback;
        }
        return (UbcUploadImplCallback) invokeV.objValue;
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? getV2ShareModelList("") : (List) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? "9.5.5" : (String) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public String getZidAndCheckSafe(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048597, this, context, str, i)) == null) ? SapiSafeFacade.getInstance().getZidAndCheckSafe(context, str, i) : (String) invokeLLI.objValue;
    }

    public synchronized void init(SapiConfiguration sapiConfiguration2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, sapiConfiguration2) == null) {
            synchronized (this) {
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
                            ThreadPoolService.getInstance().run(new TPRunnable(new Runnable(this, sapiConfiguration2) { // from class: com.baidu.sapi2.SapiAccountManager.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ SapiAccountManager this$0;
                                public final /* synthetic */ SapiConfiguration val$configuration;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, sapiConfiguration2};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$configuration = sapiConfiguration2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    boolean z;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        try {
                                            this.this$0.checkIntegratedEnviroment();
                                        } catch (RuntimeException e2) {
                                            new Handler(Looper.getMainLooper()).post(new Runnable(this, e2) { // from class: com.baidu.sapi2.SapiAccountManager.1.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass1 this$1;
                                                public final /* synthetic */ RuntimeException val$e;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this, e2};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i = newInitContext.flag;
                                                        if ((i & 1) != 0) {
                                                            int i2 = i & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$1 = this;
                                                    this.val$e = e2;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                        throw this.val$e;
                                                    }
                                                }
                                            });
                                        }
                                        SapiContext sapiContext = SapiContext.getInstance();
                                        sapiContext.setShareStorage(null);
                                        new ShareCallPacking().syncMarkLoginState((!sapiContext.isFirstLaunch() || SapiAccountManager.sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) ? 0 : 4);
                                        this.val$configuration.clientIp = SapiUtils.getLocalIpAddress();
                                        List<String> initialCachePackagesWhiteList = SapiOptions.getInitialCachePackagesWhiteList();
                                        String packageName = this.val$configuration.context.getPackageName();
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
                                            new SapiCache().init(this.val$configuration.context);
                                        }
                                        sapiContext.setHostsHijacked(SapiDeviceUtils.checkHosts(this.val$configuration.context));
                                        if (this.val$configuration.supportFaceLogin) {
                                            new PassBiometricCall().initPassBioSDK(SapiAccountManager.sapiConfiguration);
                                        }
                                        if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_NEW_INIT_SOFIRE).meetGray) {
                                            Log.e("SDK_INIT", "old sofire init run");
                                            this.this$0.initSofireSDK(this.val$configuration);
                                        }
                                        if (TextUtils.isEmpty(SapiUtils.getCookieBduss()) || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
                                            SapiAccountManager.getInstance().getAccountService().webLogin(this.val$configuration.context);
                                        }
                                        Log.d("SDK_INIT", "end time=" + System.currentTimeMillis());
                                        LoginHistoryLoginModel.updateLoginHistoryInfo();
                                    }
                                }
                            }));
                            if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_NEW_INIT_SOFIRE).meetGray) {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this, sapiConfiguration2) { // from class: com.baidu.sapi2.SapiAccountManager.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ SapiAccountManager this$0;
                                    public final /* synthetic */ SapiConfiguration val$configuration;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, sapiConfiguration2};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$configuration = sapiConfiguration2;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            try {
                                                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(this) { // from class: com.baidu.sapi2.SapiAccountManager.2.1
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;
                                                    public final /* synthetic */ AnonymousClass2 this$1;

                                                    {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 != null) {
                                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                                            newInitContext.initArgs = r2;
                                                            Object[] objArr = {this};
                                                            interceptable3.invokeUnInit(65536, newInitContext);
                                                            int i = newInitContext.flag;
                                                            if ((i & 1) != 0) {
                                                                int i2 = i & 2;
                                                                newInitContext.thisArg = this;
                                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                                return;
                                                            }
                                                        }
                                                        this.this$1 = this;
                                                    }

                                                    @Override // android.os.MessageQueue.IdleHandler
                                                    public boolean queueIdle() {
                                                        InterceptResult invokeV;
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) {
                                                            Log.e("SDK_INIT", "new sofire init run");
                                                            AnonymousClass2 anonymousClass2 = this.this$1;
                                                            anonymousClass2.this$0.initSofireSDK(anonymousClass2.val$configuration);
                                                            return false;
                                                        }
                                                        return invokeV.booleanValue;
                                                    }
                                                });
                                            } catch (Exception e2) {
                                                this.this$0.initSofireSDK(this.val$configuration);
                                                Log.e(e2);
                                            }
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
        }
    }

    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            checkInitialization();
            return SapiAccount.isValidAccount(SapiContext.getInstance().getCurrentAccount());
        }
        return invokeV.booleanValue;
    }

    public boolean isValidSessionKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? !TextUtils.isEmpty(str) && sessionKeys.contains(str) : invokeL.booleanValue;
    }

    public void loadHistoryActionLoginFromNa(LoginHistoryModel loginHistoryModel, LoginHistoryCallback loginHistoryCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, loginHistoryModel, loginHistoryCallback) == null) {
            loadHistoryActionLogin(loginHistoryModel, loginHistoryCallback, true);
            HistoryLoginStat.HistoryClickLoginStat.sValueSence = "out";
        }
    }

    public void loadHistoryActionLoginFromWap(LoginHistoryModel loginHistoryModel, LoginHistoryCallback loginHistoryCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, loginHistoryModel, loginHistoryCallback) == null) {
            loadHistoryActionLogin(loginHistoryModel, loginHistoryCallback, false);
            HistoryLoginStat.HistoryClickLoginStat.sValueSence = "in";
        }
    }

    public void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            StatService.onEvent("logout", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo("sdk_api_logout")));
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            removeLoginAccount(currentAccount);
            if (currentAccount != null) {
                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_UID, currentAccount.uid);
            }
        }
    }

    public void onShareEvent(List<ShareStorage.StorageModel> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, list, str) == null) {
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
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, sapiAccount) == null) {
            checkInitialization();
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            SapiContext.getInstance().removeLoginAccount(sapiAccount);
            new ShareCallPacking().asyncMarkLoginState(3);
            if (currentAccount == null || TextUtils.isEmpty(sapiAccount.uid) || !sapiAccount.uid.equals(currentAccount.uid)) {
                return;
            }
            getGlobalCallback().onLogoutSuccess(sapiAccount);
        }
    }

    public void setAgreeDangerousProtocol(boolean z) {
        SapiConfiguration sapiConfiguration2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (sapiConfiguration2 = getSapiConfiguration()) == null) {
            return;
        }
        sapiConfiguration2.setAgreeDangerousProtocol(z);
        a.c().h(sapiConfiguration2.context, sapiConfiguration2.isAgreeDangerousProtocol());
        sapiConfiguration2.clientIp = SapiUtils.getLocalIpAddress();
        if (sapiConfiguration2.supportFaceLogin) {
            new PassBiometricCall().setFaceModuleAgreeDangerousProtocol(z);
        }
    }

    public void setSid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
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
    }

    public void setUbcUploadImplCallback(UbcUploadImplCallback ubcUploadImplCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, ubcUploadImplCallback) == null) {
            this.ubcUploadImplCallback = ubcUploadImplCallback;
        }
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public boolean validate(SapiAccount sapiAccount) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, sapiAccount)) == null) {
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
        return invokeL.booleanValue;
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            checkInitialization();
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_API_NAME, ShareLoginStat.GetShareListStat.VALUE_API_NAME_V2);
            List<ShareStorage.StorageModel> v2ShareModelList = ShareLoginModel.getInstance().getV2ShareModelList(str);
            ShareLoginStat.GetShareListStat.upload();
            return v2ShareModelList;
        }
        return (List) invokeL.objValue;
    }

    public void getShareModels(long j, ShareModelResultCallback shareModelResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048590, this, j, shareModelResultCallback) == null) {
            checkInitialization();
            ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_API_NAME, ShareLoginStat.GetShareListStat.VALUE_API_NAME_NEW);
            ShareLoginModel.getInstance().getShareModels(j, new ShareModelWithCheckCallback(this, shareModelResultCallback) { // from class: com.baidu.sapi2.SapiAccountManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountManager this$0;
                public final /* synthetic */ ShareModelResultCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, shareModelResultCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = shareModelResultCallback;
                }

                @Override // com.baidu.sapi2.callback.ShareModelWithCheckCallback
                public void onFailure(int i, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                        this.this$0.onShareEvent(new ArrayList(), str2);
                        ShareModelResultCallback shareModelResultCallback2 = this.val$callback;
                        if (shareModelResultCallback2 != null) {
                            shareModelResultCallback2.onFailure(i, str);
                        }
                    }
                }

                @Override // com.baidu.sapi2.callback.ShareModelWithCheckCallback
                public void onSuccess(List<ShareStorage.StorageModel> list, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
                        this.val$callback.onSuccess(list);
                    }
                }
            });
        }
    }

    public String getSession(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            checkInitialization();
            return getSession(str, null);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountManager
    public SapiAccount getSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
        return (SapiAccount) invokeV.objValue;
    }
}
