package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.common.SharedPreferencesUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
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
/* loaded from: classes5.dex */
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
    public SharedPreferences storage;

    public SapiContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = context;
        this.storage = context.getSharedPreferences(SharedPreferencesUtil.f44197c, 0);
    }

    private String getCancelNuomiAddrCountKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
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

    public static SapiContext getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (SapiContext.class) {
                if (instance == null) {
                    instance = new SapiContext(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
                }
            }
            return instance;
        }
        return (SapiContext) invokeV.objValue;
    }

    private SapiOptions.PkgSigns getPkgSigns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
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

    private void setLoginAccounts(List<SapiAccount> list) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list) == null) || (jSONArray = SapiAccount.toJSONArray(list)) == null) {
            return;
        }
        put(KEY_ENCRYPTED_LOGIN_ACCOUNTS, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), getAccountEncryptKey()));
    }

    public void addLoginAccount(SapiAccount sapiAccount) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) || sapiAccount == null) {
            return;
        }
        List<SapiAccount> loginAccounts = getLoginAccounts();
        Collections.reverse(loginAccounts);
        if (!loginAccounts.contains(sapiAccount)) {
            if (loginAccounts.size() < 5) {
                loginAccounts.add(sapiAccount);
            } else {
                int size = loginAccounts.size();
                int i4 = 0;
                while (true) {
                    i3 = size - 1;
                    if (i4 >= i3) {
                        break;
                    }
                    int i5 = i4 + 1;
                    loginAccounts.set(i4, loginAccounts.get(i5));
                    i4 = i5;
                }
                loginAccounts.set(i3, sapiAccount);
            }
        } else {
            int indexOf = loginAccounts.indexOf(sapiAccount);
            int size2 = loginAccounts.size();
            while (true) {
                i2 = size2 - 1;
                if (indexOf >= i2) {
                    break;
                }
                int i6 = indexOf + 1;
                loginAccounts.set(indexOf, loginAccounts.get(i6));
                indexOf = i6;
            }
            loginAccounts.set(i2, sapiAccount);
        }
        setLoginAccounts(loginAccounts);
    }

    public void addTouchidAccounts(SapiAccount sapiAccount) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiAccount) == null) || sapiAccount == null) {
            return;
        }
        List<SapiAccount> touchidAccounts = getTouchidAccounts();
        Iterator<SapiAccount> it = touchidAccounts.iterator();
        while (it.hasNext()) {
            if (sapiAccount.equals(it.next())) {
                it.remove();
            }
        }
        touchidAccounts.add(sapiAccount);
        put(KEY_TOUCHID_ACCOUNTS, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), getAccountEncryptKey()));
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

    public String getAccountActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getString("account_type") : (String) invokeV.objValue;
    }

    public String getAccountEncryptKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(encryptKey)) {
                try {
                    encryptKey = SecurityUtil.md5((this.context.getPackageName() + SapiUtils.getPackageSign(this.context, this.context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
                } catch (UnsupportedEncodingException e2) {
                    Log.e(e2);
                }
            }
            return encryptKey;
        }
        return (String) invokeV.objValue;
    }

    public SapiAccount getAccountFromBduss(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                return null;
            }
            SapiAccount currentAccount = getCurrentAccount();
            if (currentAccount == null || !str.equals(currentAccount.bduss)) {
                for (SapiAccount sapiAccount : getLoginAccounts()) {
                    if (str.equals(sapiAccount.bduss)) {
                        return sapiAccount;
                    }
                }
                return null;
            }
            return currentAccount;
        }
        return (SapiAccount) invokeL.objValue;
    }

    public boolean getAddressUseWeb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getSapiOptions().getAddressUseWeb() : invokeV.booleanValue;
    }

    public boolean getAsyncCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getSapiOptions().getHttpAsyncCookie() : invokeV.booleanValue;
    }

    public List<String> getAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getSapiOptions().getAuthorizedDomains() : (List) invokeV.objValue;
    }

    public List<String> getAuthorizedDomainsForPtoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getSapiOptions().getAuthorizedDomainsForPtoken() : (List) invokeV.objValue;
    }

    public Map<String, String> getAuthorizedPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getPkgSigns().getAuthorizedPackages() : (Map) invokeV.objValue;
    }

    public List<String> getAuthorizedPackagesForUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getSapiOptions().getAuthorizedPackagesForUA() : (List) invokeV.objValue;
    }

    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) ? this.storage.getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public int getCancelNuomiAddrCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getInt(getCancelNuomiAddrCountKey(), 0) : invokeV.intValue;
    }

    public String getContactsVersionByUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(getString(KEY_CONTACTS_UID_VERSION), getAccountEncryptKey());
            SapiAccount currentAccount = getCurrentAccount();
            String str = currentAccount != null ? currentAccount.uid : "";
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                try {
                    jSONObject = new JSONObject(decryptAccountInfo);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            return jSONObject.optString(str);
        }
        return (String) invokeV.objValue;
    }

    public List<String> getCuidAuthorizedDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getSapiOptions().getCuidAuthorizedDomains() : (List) invokeV.objValue;
    }

    public synchronized SapiAccount getCurrentAccount() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(getString(KEY_ENCRYPTED_CURRENT_ACCOUNT))) {
                    str = SapiDataEncryptor.decryptAccountInfo(getString(KEY_ENCRYPTED_CURRENT_ACCOUNT), getAccountEncryptKey());
                } else if (TextUtils.isEmpty(getString(KEY_CURRENT_ACCOUNT))) {
                    str = null;
                } else {
                    str = getString(KEY_CURRENT_ACCOUNT);
                    String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, getAccountEncryptKey());
                    if (!TextUtils.isEmpty(encryptAccountInfo)) {
                        put(KEY_ENCRYPTED_CURRENT_ACCOUNT, encryptAccountInfo);
                        put(KEY_CURRENT_ACCOUNT, "");
                    }
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

    public String getDecryptStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? SapiDataEncryptor.decryptAccountInfo(getString(str), getAccountEncryptKey()) : (String) invokeL.objValue;
    }

    public boolean getDefaultHttpsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? getSapiOptions().getDefaultHttpsEnabled() : invokeV.booleanValue;
    }

    public String[] getDeleteFaceLoginList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            String string = getString(KEY_FACE_LOGIN_DELETE_LIST);
            return TextUtils.isEmpty(string) ? new String[0] : string.split(",");
        }
        return (String[]) invokeV.objValue;
    }

    public String getDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            List<String> loginCookieDiKeys = getSapiOptions().getLoginCookieDiKeys();
            if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
                return SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
            }
            return SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
        }
        return (String) invokeV.objValue;
    }

    public long getDeviceInfoReadTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            long j2 = getLong(KEY_DEVICE_INFO_READ_TIMES, 0L) + 1;
            put(KEY_DEVICE_INFO_READ_TIMES, j2);
            return j2;
        }
        return invokeV.longValue;
    }

    public List<Integer> getDiExceptIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? getSapiOptions().diExceptIndex : (List) invokeV.objValue;
    }

    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, str, i2)) == null) ? this.storage.getInt(str, i2) : invokeLI.intValue;
    }

    public boolean getIsAlreadyShowExplainCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getBoolean(KEY_IS_ALREADY_SHOW_EXPLAIN_CAMERA, false) : invokeV.booleanValue;
    }

    public String getJoinQrLoginPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? getSapiOptions().joinQrLoginPrompt : (String) invokeV.objValue;
    }

    public List<SapiAccount> getLoginAccounts() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (!TextUtils.isEmpty(getString(KEY_ENCRYPTED_LOGIN_ACCOUNTS))) {
                str = SapiDataEncryptor.decryptAccountInfo(getString(KEY_ENCRYPTED_LOGIN_ACCOUNTS), getAccountEncryptKey());
            } else if (TextUtils.isEmpty(getString(KEY_LOGIN_ACCOUNTS))) {
                str = null;
            } else {
                String string = getString(KEY_LOGIN_ACCOUNTS);
                String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(string, getAccountEncryptKey());
                if (!TextUtils.isEmpty(encryptAccountInfo)) {
                    put(KEY_ENCRYPTED_LOGIN_ACCOUNTS, encryptAccountInfo);
                    put(KEY_LOGIN_ACCOUNTS, "");
                }
                str = string;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    List<SapiAccount> fromJSONArray = SapiAccount.fromJSONArray(new JSONArray(str));
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

    public int getLoginStatExtraLimitLen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? getSapiOptions().loginStatExtraLimitLen : invokeV.intValue;
    }

    public long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048604, this, str, j2)) == null) ? this.storage.getLong(str, j2) : invokeLJ.longValue;
    }

    public boolean getModifiedDirExecPer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? getBoolean(KEY_MODIFIED_DIR_EXEC_PER, false) : invokeV.booleanValue;
    }

    public String getOneKeyLoginJsCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? getString(KEY_ONE_KEY_LOGIN_JS_CODE) : (String) invokeV.objValue;
    }

    public String getOnekeyLoginJsMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? getString(KEY_ONE_KEY_LOGIN_JS_MD5) : (String) invokeV.objValue;
    }

    public List<String> getOpenBdussDomains() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? getSapiOptions().getOpenBdussDomains() : (List) invokeV.objValue;
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? getSapiOptions().getOrderAuthorizedPackages() : (Map) invokeV.objValue;
    }

    public String getPackageDirExecutePer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? getString(KEY_PACKAGE_DIR_EXECUTE_PER) : (String) invokeV.objValue;
    }

    public boolean getResetFileExecPer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? getSapiOptions().resetFileExecPer : invokeV.booleanValue;
    }

    public String getRootStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? getString(KEY_ROOT_STATUS) : (String) invokeV.objValue;
    }

    public Map<String, String> getSCAuthorizedPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? getPkgSigns().getSCAuthorizedPackages() : (Map) invokeV.objValue;
    }

    public SapiOptions getSapiOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? getString("sid") : (String) invokeV.objValue;
    }

    public boolean getShareCommonStorageEnabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? getSapiOptions().shareCommonStorageEnable : invokeV.booleanValue;
    }

    public int getShareInternalGray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? getSapiOptions().shareInterGray : invokeV.intValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) ? this.storage.getString(str, "") : (String) invokeL.objValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? getSapiOptions().tid : (String) invokeV.objValue;
    }

    public List<SapiAccount> getTouchidAccounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            String decryptAccountInfo = !TextUtils.isEmpty(getString(KEY_TOUCHID_ACCOUNTS)) ? SapiDataEncryptor.decryptAccountInfo(getString(KEY_TOUCHID_ACCOUNTS), getAccountEncryptKey()) : null;
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                try {
                    return SapiAccount.fromJSONArray(new JSONArray(decryptAccountInfo));
                } catch (Throwable unused) {
                    return new ArrayList();
                }
            }
            return new ArrayList();
        }
        return (List) invokeV.objValue;
    }

    public List<String> getTouchidLoginRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? getString(KEY_V2_FACE_LIVINGUNAMES) : (String) invokeV.objValue;
    }

    public JSONObject getV2FaceLoginCheckResults() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            String decryptStr = getDecryptStr(KEY_V2_FACE_LOGIN_CHECK_RESULTS);
            if (TextUtils.isEmpty(decryptStr)) {
                return new JSONObject();
            }
            try {
                JSONObject jSONObject = new JSONObject(decryptStr);
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                String[] deleteFaceLoginList = getDeleteFaceLoginList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    for (String str : deleteFaceLoginList) {
                        if (str.equals(optJSONArray.getJSONObject(i2).optString("livinguname"))) {
                            optJSONArray.remove(i2);
                        }
                    }
                }
                jSONObject.put("list", optJSONArray);
                return jSONObject;
            } catch (Exception e2) {
                Log.e(e2);
                return new JSONObject();
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean isFirstLaunch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (getBoolean(KEY_FIRST_INSTALL, true)) {
                put(KEY_FIRST_INSTALL, false);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHostsHijacked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? getBoolean(KEY_HOSTS_HIJACKED, false) : invokeV.booleanValue;
    }

    public boolean isMeetOneKeyLoginGray(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
            return getSapiOptions().gray.getGrayModuleByFunName(i2 != 1 ? i2 != 2 ? i2 != 3 ? "unkown" : SapiOptions.Gray.FUN_NAME_CHINA_TELECOM_OAUTH : SapiOptions.Gray.FUN_NAME_CHINA_UNICOM_OAUTH : SapiOptions.Gray.FUN_NAME_CHINA_MOBILE_OAUTH).meetGray;
        }
        return invokeI.booleanValue;
    }

    public void markAsDeleteFaceLogin(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, jSONArray) == null) {
            String[] deleteFaceLoginList = getDeleteFaceLoginList();
            StringBuilder sb = new StringBuilder();
            for (int length = deleteFaceLoginList.length + jSONArray.length() > 10 ? (deleteFaceLoginList.length + jSONArray.length()) - 10 : 0; length < deleteFaceLoginList.length; length++) {
                sb.append(deleteFaceLoginList[length]);
                sb.append(",");
            }
            int length2 = jSONArray.length();
            for (int i2 = 0; i2 < length2; i2++) {
                sb.append(URLDecoder.decode(jSONArray.optString(i2)));
                sb.append(",");
            }
            put(KEY_FACE_LOGIN_DELETE_LIST, sb.toString().substring(0, sb.toString().length() - 1));
        }
    }

    public void put(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, str, str2) == null) {
            this.storage.edit().putString(str, str2).apply();
        }
    }

    public void putEncryptStr(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, str, str2) == null) {
            put(str, SapiDataEncryptor.encryptAccountInfo(str2, getAccountEncryptKey()));
        }
    }

    public void refershPortraitByUid(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048633, this, str, str2) == null) || str == null) {
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

    public void removeLoginAccount(SapiAccount sapiAccount) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, sapiAccount) == null) || sapiAccount == null) {
            return;
        }
        SapiAccount currentAccount = getCurrentAccount();
        if (currentAccount != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(currentAccount.uid)) {
            setCurrentAccount(null);
        }
        List<SapiAccount> loginAccounts = getLoginAccounts();
        if (loginAccounts.contains(sapiAccount)) {
            loginAccounts.remove(sapiAccount);
            setLoginAccounts(loginAccounts);
        }
    }

    public void removeTouchidAccountByPortrait(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<SapiAccount> touchidAccounts = getTouchidAccounts();
        Iterator<SapiAccount> it = touchidAccounts.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().email)) {
                it.remove();
            }
        }
        put(KEY_TOUCHID_ACCOUNTS, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), getAccountEncryptKey()));
    }

    public void setAccountActionType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            put("account_type", str);
        }
    }

    public void setCancelNuomiAddrCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            put(getCancelNuomiAddrCountKey(), i2);
        }
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, sapiAccount) == null) {
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
        }
    }

    public void setHostsHijacked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            put(KEY_HOSTS_HIJACKED, z);
        }
    }

    public void setIsAlreadyShowExplainCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            put(KEY_IS_ALREADY_SHOW_EXPLAIN_CAMERA, z);
        }
    }

    public void setModifiedDirExecPer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            put(KEY_MODIFIED_DIR_EXEC_PER, z);
        }
    }

    public void setOneKeyLoginJSCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            put(KEY_ONE_KEY_LOGIN_JS_CODE, str);
        }
    }

    public void setOnekeyLoginJsMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            put(KEY_ONE_KEY_LOGIN_JS_MD5, str);
        }
    }

    public void setPackageDirExecutePer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            put(KEY_PACKAGE_DIR_EXECUTE_PER, str);
        }
    }

    public void setPkgSigns(SapiOptions.PkgSigns pkgSigns) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048645, this, pkgSigns) == null) || pkgSigns == null) {
            return;
        }
        put(KEY_SAPI_OPTIONS_PKG_SING, pkgSigns.toJSON());
    }

    public void setRootStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            put(KEY_ROOT_STATUS, str);
        }
    }

    public void setSapiOptions(SapiOptions sapiOptions) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048647, this, sapiOptions) == null) || sapiOptions == null) {
            return;
        }
        put(KEY_SAPI_OPTIONS, sapiOptions.toJSON());
    }

    public void setSearchBoxSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            put("sid", str);
        }
    }

    public void setShareStorage(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, jSONArray) == null) {
            if (jSONArray == null) {
                put(KEY_SHARE_STORAGE, "");
            } else {
                put(KEY_SHARE_STORAGE, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), getAccountEncryptKey()));
            }
        }
    }

    public void setV2FaceLivingunames(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            put(KEY_V2_FACE_LIVINGUNAMES, str);
        }
    }

    public void setV2FaceLoginCheckResults(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, str) == null) {
            putEncryptStr(KEY_V2_FACE_LOGIN_CHECK_RESULTS, str);
        }
    }

    public boolean shareLivingunameEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? getSapiOptions().shareLivingunameEnabled : invokeV.booleanValue;
    }

    public void updateContactsVersionWithUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(getString(KEY_CONTACTS_UID_VERSION), getAccountEncryptKey());
            String str2 = getCurrentAccount().uid;
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(decryptAccountInfo)) {
                    jSONObject = new JSONObject(decryptAccountInfo);
                }
                jSONObject.put(str2, str);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            put(KEY_CONTACTS_UID_VERSION, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), getAccountEncryptKey()));
        }
    }

    public void put(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048628, this, str, i2) == null) {
            this.storage.edit().putInt(str, i2).apply();
        }
    }

    public void put(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048629, this, str, j2) == null) {
            this.storage.edit().putLong(str, j2).apply();
        }
    }

    public void put(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, str, z) == null) {
            this.storage.edit().putBoolean(str, z).apply();
        }
    }
}
