package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.common.SharedPreferencesUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SapiContext implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHINA_TELECOM_EXPIRED_TIME = "china_telecom_expired_time";
    public static final String CHINA_UNICOM_EXPIRED_TIME = "china_unicom_expired_time";
    public static final String KEY_ACCOUNT_ACTION_TYPE = "account_type";
    public static final String KEY_CANCEL_NUOMI_ADDR_COUNT = "key_cancel_nuomi_addr_count";
    public static final String KEY_CONFIG_FILE_ETAG = "config_file_etag";
    public static final String KEY_CONTACTS_UID_VERSION = "contacts_uid_version";
    public static final String KEY_CURRENT_ACCOUNT = "current_account";
    public static final String KEY_CURRENT_BAIDU_APP_LIST = "current_baidu_app_list";
    public static final String KEY_DEVICE_INFO_READ_TIMES = "device_info_read_times";
    public static final String KEY_ENCRYPTED_CURRENT_ACCOUNT = "en_current_account";
    public static final String KEY_ENCRYPTED_LOGIN_ACCOUNTS = "en_login_accounts";
    public static final String KEY_FACE_LOGIN_DELETE_LIST = "face_login_delete_list";
    public static final String KEY_FIRST_INSTALL = "first_install";
    public static final String KEY_HOSTS_HIJACKED = "hosts_hijacked";
    public static final String KEY_IS_ALREADY_SHOW_EXPLAIN_CAMERA = "is_already_show_explain_camera";
    public static final String KEY_LAST_LOGIN_PHONE = "last_login_phone";
    public static final String KEY_LAST_LOGIN_UID = "last_login_uid";
    public static final String KEY_LAST_LOGIN_USER_PORTRAIT = "last_login_user_portrait";
    public static final String KEY_LOGIN_ACCOUNTS = "login_accounts";
    public static final String KEY_LOGIN_HISTORY_USER_INFO = "key_login_history_user_info";
    public static final String KEY_MODIFIED_DIR_EXEC_PER = "modified_dir_exec_per";
    public static final String KEY_ONE_KEY_LOGIN_JS_CODE = "one_key_login_js_code";
    public static final String KEY_ONE_KEY_LOGIN_JS_MD5 = "one_key_login_js_md5";
    public static final String KEY_OPEN_BDUSS_INFO = "open_bduss_info";
    public static final String KEY_PACKAGE_DIR_EXECUTE_PER = "package_dir_execute_per";
    public static final String KEY_PRE_LOGIN_TYPE = "pre_login_type";
    public static final String KEY_ROOT_STATUS = "root_status";
    public static final String KEY_SAPI_OPTIONS = "sapi_options";
    public static final String KEY_SAPI_OPTIONS_PKG_SING = "pkg_signs";
    public static final String KEY_SEARCH_BOX_SID = "sid";
    public static final String KEY_SHARE_DELETE_LIST = "share_delete_list";
    public static final String KEY_SHARE_INTERNAL_GRAY = "share_internal";
    public static final String KEY_SHARE_MODELS_FROM_CLOUD_CACHE = "key_share_models_cloud_cache";
    public static long KEY_SHARE_MODELS_FROM_CLOUD_TIME_SECOND = 0;
    public static final String KEY_SHARE_STORAGE = "share_storage";
    public static final String KEY_TOUCHID_ACCOUNTS = "touchid_accounts";
    public static final String KEY_TOUCHID_LOGIN_RECORD = "touchid_login_record";
    public static final String KEY_V2_FACE_LIVINGUNAMES = "face_livingunames";
    public static final String KEY_V2_FACE_LOGIN_CHECK_RESULTS = "v2_face_login_check_result";
    public static final int MAX_LOGIN_ACCOUNTS = 5;
    public static String encryptKey;
    public static SapiContext instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public Enums.LastLoginType mLastLoginType;
    public SharedPreferences storage;

    public SapiContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = context;
        this.storage = context.getSharedPreferences(SharedPreferencesUtil.c, 0);
    }

    public void addTouchidLoginRecord(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            String string = getString(KEY_TOUCHID_LOGIN_RECORD);
            if (TextUtils.isEmpty(string)) {
                put(KEY_TOUCHID_LOGIN_RECORD, str);
            } else if (string.contains(str)) {
            } else {
                put(KEY_TOUCHID_LOGIN_RECORD, string + "," + str);
            }
        }
    }

    public SapiAccount getAccountFromBduss(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                return null;
            }
            SapiAccount currentAccount = getCurrentAccount();
            if (currentAccount != null && str.equals(currentAccount.bduss)) {
                return currentAccount;
            }
            for (SapiAccount sapiAccount : getLoginAccounts()) {
                if (str.equals(sapiAccount.bduss)) {
                    return sapiAccount;
                }
            }
            return null;
        }
        return (SapiAccount) invokeL.objValue;
    }

    public boolean isMeetOneKeyLoginGray(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        str = "unkown";
                    } else {
                        str = SapiOptions.Gray.FUN_NAME_CHINA_TELECOM_OAUTH;
                    }
                } else {
                    str = SapiOptions.Gray.FUN_NAME_CHINA_UNICOM_OAUTH;
                }
            } else {
                str = SapiOptions.Gray.FUN_NAME_CHINA_MOBILE_OAUTH;
            }
            if (getSapiOptions().gray.getGrayModuleByFunName(str).meetGray) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048636, this, sapiAccount) != null) || sapiAccount == null) {
            return;
        }
        SapiAccount currentAccount = getCurrentAccount();
        if (currentAccount != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(currentAccount.uid)) {
            setCurrentAccount(null);
        }
        List loginAccounts = getLoginAccounts();
        if (loginAccounts.contains(sapiAccount)) {
            loginAccounts.remove(sapiAccount);
            setLoginAccounts(loginAccounts);
        }
    }

    private void setLoginAccounts(List list) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, list) == null) && (jSONArray = SapiAccount.toJSONArray(list)) != null) {
            put(KEY_ENCRYPTED_LOGIN_ACCOUNTS, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), getAccountEncryptKey()));
        }
    }

    public String getDecryptStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            return SapiDataEncryptor.decryptAccountInfo(getString(str), getAccountEncryptKey());
        }
        return (String) invokeL.objValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            return this.storage.getString(str, "");
        }
        return (String) invokeL.objValue;
    }

    public void setAccountActionType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            put("account_type", str);
        }
    }

    public void setCancelNuomiAddrCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            put(getCancelNuomiAddrCountKey(), i);
        }
    }

    public void setHostsHijacked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            put(KEY_HOSTS_HIJACKED, z);
        }
    }

    public void setIsAlreadyShowExplainCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            put(KEY_IS_ALREADY_SHOW_EXPLAIN_CAMERA, z);
        }
    }

    public void setLoginHistoryUserInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            put(KEY_LOGIN_HISTORY_USER_INFO, str);
        }
    }

    public void setModifiedDirExecPer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            put(KEY_MODIFIED_DIR_EXEC_PER, z);
        }
    }

    public void setOneKeyLoginJSCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            put(KEY_ONE_KEY_LOGIN_JS_CODE, str);
        }
    }

    public void setOnekeyLoginJsMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            put(KEY_ONE_KEY_LOGIN_JS_MD5, str);
        }
    }

    public void setPackageDirExecutePer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            put(KEY_PACKAGE_DIR_EXECUTE_PER, str);
        }
    }

    public void setPkgSigns(SapiOptions.PkgSigns pkgSigns) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048648, this, pkgSigns) == null) && pkgSigns != null) {
            put(KEY_SAPI_OPTIONS_PKG_SING, pkgSigns.toJSON());
        }
    }

    public void setPreLoginType(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048649, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        put(KEY_PRE_LOGIN_TYPE, str);
        this.mLastLoginType = null;
    }

    public void setRootStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            put(KEY_ROOT_STATUS, str);
        }
    }

    public void setSapiOptions(SapiOptions sapiOptions) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048651, this, sapiOptions) == null) && sapiOptions != null) {
            put(KEY_SAPI_OPTIONS, sapiOptions.toJSON());
        }
    }

    public void setSearchBoxSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            put("sid", str);
        }
    }

    public void setShareStorage(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, jSONArray) == null) {
            if (jSONArray == null) {
                put(KEY_SHARE_STORAGE, "");
            } else {
                put(KEY_SHARE_STORAGE, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), getAccountEncryptKey()));
            }
        }
    }

    public void setV2FaceLivingunames(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            put(KEY_V2_FACE_LIVINGUNAMES, str);
        }
    }

    public void setV2FaceLoginCheckResults(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            putEncryptStr(KEY_V2_FACE_LOGIN_CHECK_RESULTS, str);
        }
    }

    private String getCancelNuomiAddrCountKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(KEY_CANCEL_NUOMI_ADDR_COUNT);
            SapiAccount currentAccount = getCurrentAccount();
            if (currentAccount != null) {
                sb.append("_");
                sb.append(currentAccount.uid);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private SapiOptions.PkgSigns getPkgSigns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            String string = getString(KEY_SAPI_OPTIONS_PKG_SING);
            if (!TextUtils.isEmpty(string)) {
                try {
                    return SapiOptions.PkgSigns.fromJSON(new JSONObject(string));
                } catch (JSONException unused) {
                }
            }
            return new SapiOptions.PkgSigns();
        }
        return (SapiOptions.PkgSigns) invokeV.objValue;
    }

    public String getAccountActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getString("account_type");
        }
        return (String) invokeV.objValue;
    }

    public boolean getAddressUseWeb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getSapiOptions().getAddressUseWeb();
        }
        return invokeV.booleanValue;
    }

    public boolean getAsyncCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return getSapiOptions().getHttpAsyncCookie();
        }
        return invokeV.booleanValue;
    }

    public List getAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return getSapiOptions().getAuthorizedDomains();
        }
        return (List) invokeV.objValue;
    }

    public List getAuthorizedDomainsForPtoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return getSapiOptions().getAuthorizedDomainsForPtoken();
        }
        return (List) invokeV.objValue;
    }

    public Map getAuthorizedPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return getPkgSigns().getAuthorizedPackages();
        }
        return (Map) invokeV.objValue;
    }

    public List getAuthorizedPackagesForUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return getSapiOptions().getAuthorizedPackagesForUA();
        }
        return (List) invokeV.objValue;
    }

    public int getCancelNuomiAddrCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return getInt(getCancelNuomiAddrCountKey(), 0);
        }
        return invokeV.intValue;
    }

    public List getCuidAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return getSapiOptions().getCuidAuthorizedDomains();
        }
        return (List) invokeV.objValue;
    }

    public boolean getDefaultHttpsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return getSapiOptions().getDefaultHttpsEnabled();
        }
        return invokeV.booleanValue;
    }

    public String[] getDeleteFaceLoginList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            String string = getString(KEY_FACE_LOGIN_DELETE_LIST);
            if (TextUtils.isEmpty(string)) {
                return new String[0];
            }
            return string.split(",");
        }
        return (String[]) invokeV.objValue;
    }

    public long getDeviceInfoReadTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            long j = getLong(KEY_DEVICE_INFO_READ_TIMES, 0L) + 1;
            put(KEY_DEVICE_INFO_READ_TIMES, j);
            return j;
        }
        return invokeV.longValue;
    }

    public List getDiExceptIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return getSapiOptions().diExceptIndex;
        }
        return (List) invokeV.objValue;
    }

    public boolean getIsAlreadyShowExplainCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return getBoolean(KEY_IS_ALREADY_SHOW_EXPLAIN_CAMERA, false);
        }
        return invokeV.booleanValue;
    }

    public String getJoinQrLoginPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return getSapiOptions().joinQrLoginPrompt;
        }
        return (String) invokeV.objValue;
    }

    public String getLoginHistoryUserInfoJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return getString(KEY_LOGIN_HISTORY_USER_INFO);
        }
        return (String) invokeV.objValue;
    }

    public int getLoginStatExtraLimitLen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return getSapiOptions().loginStatExtraLimitLen;
        }
        return invokeV.intValue;
    }

    public boolean getModifiedDirExecPer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return getBoolean(KEY_MODIFIED_DIR_EXEC_PER, false);
        }
        return invokeV.booleanValue;
    }

    public String getOneKeyLoginJsCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return getString(KEY_ONE_KEY_LOGIN_JS_CODE);
        }
        return (String) invokeV.objValue;
    }

    public String getOnekeyLoginJsMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return getString(KEY_ONE_KEY_LOGIN_JS_MD5);
        }
        return (String) invokeV.objValue;
    }

    public List getOpenBdussDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return getSapiOptions().getOpenBdussDomains();
        }
        return (List) invokeV.objValue;
    }

    public Map getOrderAuthorizedPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return getSapiOptions().getOrderAuthorizedPackages();
        }
        return (Map) invokeV.objValue;
    }

    public String getPackageDirExecutePer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return getString(KEY_PACKAGE_DIR_EXECUTE_PER);
        }
        return (String) invokeV.objValue;
    }

    public boolean getResetFileExecPer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return getSapiOptions().resetFileExecPer;
        }
        return invokeV.booleanValue;
    }

    public String getRootStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return getString(KEY_ROOT_STATUS);
        }
        return (String) invokeV.objValue;
    }

    public Map getSCAuthorizedPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return getPkgSigns().getSCAuthorizedPackages();
        }
        return (Map) invokeV.objValue;
    }

    public SapiOptions getSapiOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            String string = getString(KEY_SAPI_OPTIONS);
            if (!TextUtils.isEmpty(string)) {
                try {
                    return SapiOptions.fromJSON(new JSONObject(string));
                } catch (JSONException unused) {
                }
            }
            return new SapiOptions();
        }
        return (SapiOptions) invokeV.objValue;
    }

    public String getSearchBoxSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return getString("sid");
        }
        return (String) invokeV.objValue;
    }

    public boolean getShareCommonStorageEnabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return getSapiOptions().shareCommonStorageEnable;
        }
        return invokeV.booleanValue;
    }

    public int getShareInternalGray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return getSapiOptions().shareInterGray;
        }
        return invokeV.intValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return getSapiOptions().tid;
        }
        return (String) invokeV.objValue;
    }

    public List getTouchidLoginRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            String string = getString(KEY_TOUCHID_LOGIN_RECORD);
            if (TextUtils.isEmpty(string)) {
                return new ArrayList(0);
            }
            return Arrays.asList(string.split(","));
        }
        return (List) invokeV.objValue;
    }

    public String getV2FaceLivingUnames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return getString(KEY_V2_FACE_LIVINGUNAMES);
        }
        return (String) invokeV.objValue;
    }

    public boolean isFirstLaunch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!getBoolean(KEY_FIRST_INSTALL, true)) {
                return false;
            }
            put(KEY_FIRST_INSTALL, false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isHostsHijacked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return getBoolean(KEY_HOSTS_HIJACKED, false);
        }
        return invokeV.booleanValue;
    }

    public void openBdussLogout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            ThreadPoolService.getInstance().run(new TPRunnable(new Runnable(this) { // from class: com.baidu.sapi2.SapiContext.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiContext this$0;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
                        try {
                            ArrayList arrayList = new ArrayList();
                            for (String str : this.this$0.getOpenBdussDomains()) {
                                arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str, SapiUtils.buildBDUSSCookie(str, "OPENBDUSS", "")));
                            }
                            SapiUtils.syncCookies(this.this$0.context, arrayList);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                    }
                }
            }));
        }
    }

    public boolean shareLivingunameEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return getSapiOptions().shareLivingunameEnabled;
        }
        return invokeV.booleanValue;
    }

    public static SapiContext getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (SapiContext.class) {
                if (instance == null) {
                    instance = new SapiContext(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
                }
            }
            return instance;
        }
        return (SapiContext) invokeV.objValue;
    }

    public String getDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            List loginCookieDiKeys = getSapiOptions().getLoginCookieDiKeys();
            if (loginCookieDiKeys.size() == 1 && ((String) loginCookieDiKeys.get(0)).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
                return SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
            }
            return SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
        }
        return (String) invokeV.objValue;
    }

    public void addLoginAccount(SapiAccount sapiAccount) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, sapiAccount) != null) || sapiAccount == null) {
            return;
        }
        List loginAccounts = getLoginAccounts();
        Collections.reverse(loginAccounts);
        if (!loginAccounts.contains(sapiAccount)) {
            if (loginAccounts.size() < 5) {
                loginAccounts.add(sapiAccount);
            } else {
                int size = loginAccounts.size();
                int i3 = 0;
                while (true) {
                    i2 = size - 1;
                    if (i3 >= i2) {
                        break;
                    }
                    int i4 = i3 + 1;
                    loginAccounts.set(i3, loginAccounts.get(i4));
                    i3 = i4;
                }
                loginAccounts.set(i2, sapiAccount);
            }
        } else {
            int indexOf = loginAccounts.indexOf(sapiAccount);
            int size2 = loginAccounts.size();
            while (true) {
                i = size2 - 1;
                if (indexOf >= i) {
                    break;
                }
                int i5 = indexOf + 1;
                loginAccounts.set(indexOf, loginAccounts.get(i5));
                indexOf = i5;
            }
            loginAccounts.set(i, sapiAccount);
        }
        setLoginAccounts(loginAccounts);
    }

    public void addTouchidAccounts(SapiAccount sapiAccount) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiAccount) != null) || sapiAccount == null) {
            return;
        }
        List touchidAccounts = getTouchidAccounts();
        Iterator it = touchidAccounts.iterator();
        while (it.hasNext()) {
            if (sapiAccount.equals((SapiAccount) it.next())) {
                it.remove();
            }
        }
        touchidAccounts.add(sapiAccount);
        put(KEY_TOUCHID_ACCOUNTS, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), getAccountEncryptKey()));
    }

    public void removeTouchidAccountByPortrait(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048637, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        List touchidAccounts = getTouchidAccounts();
        Iterator it = touchidAccounts.iterator();
        while (it.hasNext()) {
            if (str.equals(((SapiAccount) it.next()).email)) {
                it.remove();
            }
        }
        put(KEY_TOUCHID_ACCOUNTS, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), getAccountEncryptKey()));
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, sapiAccount) == null) {
            try {
                openBdussLogout();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (sapiAccount == null) {
                put(KEY_ENCRYPTED_CURRENT_ACCOUNT, "");
                SapiUtils.webLogout(this.context);
                return;
            }
            JSONObject jSONObject = sapiAccount.toJSONObject();
            if (jSONObject != null) {
                put(KEY_ENCRYPTED_CURRENT_ACCOUNT, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), getAccountEncryptKey()));
                SapiUtils.webLogin(this.context, sapiAccount.bduss, sapiAccount.ptoken);
            }
            LoginHistoryLoginModel.updateLoginHistoryInfo(sapiAccount);
        }
    }

    public void updateContactsVersionWithUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(getString(KEY_CONTACTS_UID_VERSION), getAccountEncryptKey());
            String str2 = getCurrentAccount().uid;
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(decryptAccountInfo)) {
                    jSONObject = new JSONObject(decryptAccountInfo);
                }
                jSONObject.put(str2, str);
            } catch (JSONException e) {
                Log.e(e);
            }
            put(KEY_CONTACTS_UID_VERSION, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), getAccountEncryptKey()));
        }
    }

    public String getAccountEncryptKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(encryptKey)) {
                try {
                    encryptKey = SecurityUtil.md5((this.context.getPackageName() + SapiUtils.getPackageSign(this.context, this.context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
                } catch (UnsupportedEncodingException e) {
                    Log.e(e);
                }
            }
            return encryptKey;
        }
        return (String) invokeV.objValue;
    }

    public String getContactsVersionByUid() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(getString(KEY_CONTACTS_UID_VERSION), getAccountEncryptKey());
            SapiAccount currentAccount = getCurrentAccount();
            if (currentAccount != null) {
                str = currentAccount.uid;
            } else {
                str = "";
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                try {
                    jSONObject = new JSONObject(decryptAccountInfo);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return jSONObject.optString(str);
        }
        return (String) invokeV.objValue;
    }

    public List getTouchidAccounts() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (!TextUtils.isEmpty(getString(KEY_TOUCHID_ACCOUNTS))) {
                str = SapiDataEncryptor.decryptAccountInfo(getString(KEY_TOUCHID_ACCOUNTS), getAccountEncryptKey());
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    return SapiAccount.fromJSONArray(new JSONArray(str));
                } catch (Throwable unused) {
                    return new ArrayList();
                }
            }
            return new ArrayList();
        }
        return (List) invokeV.objValue;
    }

    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            return this.storage.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, str, i)) == null) {
            return this.storage.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048605, this, str, j)) == null) {
            return this.storage.getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    public void put(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048630, this, str, i) == null) {
            this.storage.edit().putInt(str, i).apply();
        }
    }

    public void putEncryptStr(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, str, str2) == null) {
            put(str, SapiDataEncryptor.encryptAccountInfo(str2, getAccountEncryptKey()));
        }
    }

    public synchronized SapiAccount getCurrentAccount() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(getString(KEY_ENCRYPTED_CURRENT_ACCOUNT))) {
                    str = SapiDataEncryptor.decryptAccountInfo(getString(KEY_ENCRYPTED_CURRENT_ACCOUNT), getAccountEncryptKey());
                } else if (!TextUtils.isEmpty(getString(KEY_CURRENT_ACCOUNT))) {
                    str = getString(KEY_CURRENT_ACCOUNT);
                    String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, getAccountEncryptKey());
                    if (!TextUtils.isEmpty(encryptAccountInfo)) {
                        put(KEY_ENCRYPTED_CURRENT_ACCOUNT, encryptAccountInfo);
                        put(KEY_CURRENT_ACCOUNT, "");
                    }
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    return SapiAccount.fromJSONObject(new JSONObject(str));
                } catch (JSONException unused) {
                    return null;
                }
            }
        }
        return (SapiAccount) invokeV.objValue;
    }

    public List getLoginAccounts() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (!TextUtils.isEmpty(getString(KEY_ENCRYPTED_LOGIN_ACCOUNTS))) {
                str = SapiDataEncryptor.decryptAccountInfo(getString(KEY_ENCRYPTED_LOGIN_ACCOUNTS), getAccountEncryptKey());
            } else if (!TextUtils.isEmpty(getString(KEY_LOGIN_ACCOUNTS))) {
                String string = getString(KEY_LOGIN_ACCOUNTS);
                String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(string, getAccountEncryptKey());
                if (!TextUtils.isEmpty(encryptAccountInfo)) {
                    put(KEY_ENCRYPTED_LOGIN_ACCOUNTS, encryptAccountInfo);
                    put(KEY_LOGIN_ACCOUNTS, "");
                }
                str = string;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    List fromJSONArray = SapiAccount.fromJSONArray(new JSONArray(str));
                    Collections.reverse(fromJSONArray);
                    return fromJSONArray;
                } catch (Exception unused) {
                    return new ArrayList();
                }
            }
            return new ArrayList();
        }
        return (List) invokeV.objValue;
    }

    public JSONObject getV2FaceLoginCheckResults() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            String decryptStr = getDecryptStr(KEY_V2_FACE_LOGIN_CHECK_RESULTS);
            if (TextUtils.isEmpty(decryptStr)) {
                return new JSONObject();
            }
            try {
                JSONObject jSONObject = new JSONObject(decryptStr);
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                String[] deleteFaceLoginList = getDeleteFaceLoginList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    for (String str : deleteFaceLoginList) {
                        if (str.equals(optJSONArray.getJSONObject(i).optString("livinguname"))) {
                            optJSONArray.remove(i);
                        }
                    }
                }
                jSONObject.put("list", optJSONArray);
                return jSONObject;
            } catch (Exception e) {
                Log.e(e);
                return new JSONObject();
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public void markAsDeleteFaceLogin(JSONArray jSONArray) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, jSONArray) == null) {
            String[] deleteFaceLoginList = getDeleteFaceLoginList();
            StringBuilder sb = new StringBuilder();
            if (deleteFaceLoginList.length + jSONArray.length() > 10) {
                i = (deleteFaceLoginList.length + jSONArray.length()) - 10;
            } else {
                i = 0;
            }
            while (i < deleteFaceLoginList.length) {
                sb.append(deleteFaceLoginList[i]);
                sb.append(",");
                i++;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(URLDecoder.decode(jSONArray.optString(i2)));
                sb.append(",");
            }
            put(KEY_FACE_LOGIN_DELETE_LIST, sb.toString().substring(0, sb.toString().length() - 1));
        }
    }

    public void put(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048631, this, str, j) == null) {
            this.storage.edit().putLong(str, j).apply();
        }
    }

    public void put(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, str, str2) == null) {
            this.storage.edit().putString(str, str2).apply();
        }
    }

    public void put(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048633, this, str, z) == null) {
            this.storage.edit().putBoolean(str, z).apply();
        }
    }

    public void refershPortraitByUid(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048635, this, str, str2) != null) || str == null) {
            return;
        }
        SapiAccount currentAccount = getCurrentAccount();
        if (currentAccount != null && str.equals(currentAccount.uid)) {
            currentAccount.portrait = str2;
            setCurrentAccount(currentAccount);
        }
        List<SapiAccount> loginAccounts = getLoginAccounts();
        for (SapiAccount sapiAccount : loginAccounts) {
            if (str.equals(sapiAccount.uid)) {
                sapiAccount.portrait = str2;
                setLoginAccounts(loginAccounts);
                return;
            }
        }
    }
}
