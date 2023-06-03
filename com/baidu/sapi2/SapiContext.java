package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.common.SharedPreferencesUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.searchbox.player.model.ClarityUrlList;
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
/* loaded from: classes3.dex */
public final class SapiContext implements NoProguard {
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
    public static final String KEY_SETTING_SHOW_REAL_NAME_GUIDE_CLICK = "key_setting_show_real_name_guide_click";
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
    public Context context;
    public Enums.LastLoginType mLastLoginType;
    public SharedPreferences storage;

    public SapiContext(Context context) {
        this.context = context;
        this.storage = context.getSharedPreferences(SharedPreferencesUtil.c, 0);
    }

    private void setLoginAccounts(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(KEY_ENCRYPTED_LOGIN_ACCOUNTS, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), getAccountEncryptKey()));
        }
    }

    public void addTouchidLoginRecord(String str) {
        String string = getString(KEY_TOUCHID_LOGIN_RECORD);
        if (TextUtils.isEmpty(string)) {
            put(KEY_TOUCHID_LOGIN_RECORD, str);
        } else if (string.contains(str)) {
        } else {
            put(KEY_TOUCHID_LOGIN_RECORD, string + "," + str);
        }
    }

    public SapiAccount getAccountFromBduss(String str) {
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

    public String getClickRealNameTimes(String str) {
        return getDecryptStr("key_setting_show_real_name_guide_click_" + str);
    }

    public String getDecryptStr(String str) {
        return SapiDataEncryptor.decryptAccountInfo(getString(str), getAccountEncryptKey());
    }

    public String getString(String str) {
        return this.storage.getString(str, "");
    }

    public String getUserAttrInfo(String str) {
        return getDecryptStr(str);
    }

    public boolean isMeetOneKeyLoginGray(int i) {
        String str;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    str = ClarityUrlList.UNKNOWN_CLARITY_KEY;
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

    public void removeLoginAccount(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
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

    public void setAccountActionType(String str) {
        put("account_type", str);
    }

    public void setCancelNuomiAddrCount(int i) {
        put(getCancelNuomiAddrCountKey(), i);
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        setCurrentAccount(sapiAccount, true);
    }

    public void setHostsHijacked(boolean z) {
        put(KEY_HOSTS_HIJACKED, z);
    }

    public void setIsAlreadyShowExplainCamera(boolean z) {
        put(KEY_IS_ALREADY_SHOW_EXPLAIN_CAMERA, z);
    }

    public void setLoginHistoryUserInfo(String str) {
        put(KEY_LOGIN_HISTORY_USER_INFO, str);
    }

    public void setModifiedDirExecPer(boolean z) {
        put(KEY_MODIFIED_DIR_EXEC_PER, z);
    }

    public void setOneKeyLoginJSCode(String str) {
        put(KEY_ONE_KEY_LOGIN_JS_CODE, str);
    }

    public void setOnekeyLoginJsMd5(String str) {
        put(KEY_ONE_KEY_LOGIN_JS_MD5, str);
    }

    public void setPackageDirExecutePer(String str) {
        put(KEY_PACKAGE_DIR_EXECUTE_PER, str);
    }

    public void setPkgSigns(SapiOptions.PkgSigns pkgSigns) {
        if (pkgSigns != null) {
            put(KEY_SAPI_OPTIONS_PKG_SING, pkgSigns.toJSON());
        }
    }

    public void setPreLoginType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        put(KEY_PRE_LOGIN_TYPE, str);
        this.mLastLoginType = null;
    }

    public void setRootStatus(String str) {
        put(KEY_ROOT_STATUS, str);
    }

    public void setSapiOptions(SapiOptions sapiOptions) {
        if (sapiOptions != null) {
            put(KEY_SAPI_OPTIONS, sapiOptions.toJSON());
        }
    }

    public void setSearchBoxSid(String str) {
        put("sid", str);
    }

    public void setShareStorage(JSONArray jSONArray) {
        if (jSONArray == null) {
            put(KEY_SHARE_STORAGE, "");
        } else {
            put(KEY_SHARE_STORAGE, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), getAccountEncryptKey()));
        }
    }

    public void setV2FaceLivingunames(String str) {
        put(KEY_V2_FACE_LIVINGUNAMES, str);
    }

    public void setV2FaceLoginCheckResults(String str) {
        putEncryptStr(KEY_V2_FACE_LOGIN_CHECK_RESULTS, str);
    }

    private String getCancelNuomiAddrCountKey() {
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_CANCEL_NUOMI_ADDR_COUNT);
        SapiAccount currentAccount = getCurrentAccount();
        if (currentAccount != null) {
            sb.append("_");
            sb.append(currentAccount.uid);
        }
        return sb.toString();
    }

    private SapiOptions.PkgSigns getPkgSigns() {
        String string = getString(KEY_SAPI_OPTIONS_PKG_SING);
        if (!TextUtils.isEmpty(string)) {
            try {
                return SapiOptions.PkgSigns.fromJSON(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return new SapiOptions.PkgSigns();
    }

    public String getAccountActionType() {
        return getString("account_type");
    }

    public boolean getAddressUseWeb() {
        return getSapiOptions().getAddressUseWeb();
    }

    public boolean getAsyncCookie() {
        return getSapiOptions().getHttpAsyncCookie();
    }

    public List<String> getAuthorizedDomains() {
        return getSapiOptions().getAuthorizedDomains();
    }

    public List<String> getAuthorizedDomainsForPtoken() {
        return getSapiOptions().getAuthorizedDomainsForPtoken();
    }

    public Map<String, String> getAuthorizedPackages() {
        return getPkgSigns().getAuthorizedPackages();
    }

    public List<String> getAuthorizedPackagesForUA() {
        return getSapiOptions().getAuthorizedPackagesForUA();
    }

    public int getCancelNuomiAddrCount() {
        return getInt(getCancelNuomiAddrCountKey(), 0);
    }

    public List<String> getCuidAuthorizedDomains() {
        return getSapiOptions().getCuidAuthorizedDomains();
    }

    public boolean getDefaultHttpsEnabled() {
        return getSapiOptions().getDefaultHttpsEnabled();
    }

    public String[] getDeleteFaceLoginList() {
        String string = getString(KEY_FACE_LOGIN_DELETE_LIST);
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        return string.split(",");
    }

    public String getDeviceInfo() {
        List<String> loginCookieDiKeys = getSapiOptions().getLoginCookieDiKeys();
        if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
            return SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
        }
        return SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
    }

    public long getDeviceInfoReadTimes() {
        long j = getLong(KEY_DEVICE_INFO_READ_TIMES, 0L) + 1;
        put(KEY_DEVICE_INFO_READ_TIMES, j);
        return j;
    }

    public List<Integer> getDiExceptIndex() {
        return getSapiOptions().diExceptIndex;
    }

    public boolean getIsAlreadyShowExplainCamera() {
        return getBoolean(KEY_IS_ALREADY_SHOW_EXPLAIN_CAMERA, false);
    }

    public String getJoinQrLoginPrompt() {
        return getSapiOptions().joinQrLoginPrompt;
    }

    public String getLoginHistoryUserInfoJson() {
        return getString(KEY_LOGIN_HISTORY_USER_INFO);
    }

    public int getLoginStatExtraLimitLen() {
        return getSapiOptions().loginStatExtraLimitLen;
    }

    public boolean getModifiedDirExecPer() {
        return getBoolean(KEY_MODIFIED_DIR_EXEC_PER, false);
    }

    public String getOneKeyLoginJsCode() {
        return getString(KEY_ONE_KEY_LOGIN_JS_CODE);
    }

    public String getOnekeyLoginJsMd5() {
        return getString(KEY_ONE_KEY_LOGIN_JS_MD5);
    }

    public List<String> getOpenBdussDomains() {
        return getSapiOptions().getOpenBdussDomains();
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        return getSapiOptions().getOrderAuthorizedPackages();
    }

    public String getPackageDirExecutePer() {
        return getString(KEY_PACKAGE_DIR_EXECUTE_PER);
    }

    public boolean getResetFileExecPer() {
        return getSapiOptions().resetFileExecPer;
    }

    public String getRootStatus() {
        return getString(KEY_ROOT_STATUS);
    }

    public Map<String, String> getSCAuthorizedPackages() {
        return getPkgSigns().getSCAuthorizedPackages();
    }

    public SapiOptions getSapiOptions() {
        String string = getString(KEY_SAPI_OPTIONS);
        if (!TextUtils.isEmpty(string)) {
            try {
                return SapiOptions.fromJSON(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return new SapiOptions();
    }

    public String getSearchBoxSid() {
        return getString("sid");
    }

    public boolean getShareCommonStorageEnabel() {
        return getSapiOptions().shareCommonStorageEnable;
    }

    public int getShareInternalGray() {
        return getSapiOptions().shareInterGray;
    }

    public String getTid() {
        return getSapiOptions().tid;
    }

    public List<String> getTouchidLoginRecord() {
        String string = getString(KEY_TOUCHID_LOGIN_RECORD);
        if (TextUtils.isEmpty(string)) {
            return new ArrayList(0);
        }
        return Arrays.asList(string.split(","));
    }

    public String getV2FaceLivingUnames() {
        return getString(KEY_V2_FACE_LIVINGUNAMES);
    }

    public boolean isFirstLaunch() {
        if (!getBoolean(KEY_FIRST_INSTALL, true)) {
            return false;
        }
        put(KEY_FIRST_INSTALL, false);
        return true;
    }

    public boolean isHostsHijacked() {
        return getBoolean(KEY_HOSTS_HIJACKED, false);
    }

    public boolean isOpTitle() {
        if (!getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_OB_TITLE).meetGray) {
            return false;
        }
        return true;
    }

    public void openBdussLogout() {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiContext.1
            @Override // java.lang.Runnable
            public void run() {
                SapiContext.this.putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
                try {
                    ArrayList arrayList = new ArrayList();
                    for (String str : SapiContext.this.getOpenBdussDomains()) {
                        arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str, SapiUtils.buildBDUSSCookie(str, "OPENBDUSS", "")));
                    }
                    SapiUtils.syncCookies(SapiContext.this.context, arrayList);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }));
    }

    public boolean shareLivingunameEnable() {
        return getSapiOptions().shareLivingunameEnabled;
    }

    public static SapiContext getInstance() {
        synchronized (SapiContext.class) {
            if (instance == null) {
                ServiceManager serviceManager = ServiceManager.getInstance();
                if (serviceManager != null) {
                    ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                    if (isAccountManager != null) {
                        SapiConfiguration confignation = isAccountManager.getConfignation();
                        if (confignation != null && confignation.context != null) {
                            instance = new SapiContext(confignation.context);
                        } else {
                            throw new IllegalArgumentException("Pass is not init");
                        }
                    } else {
                        throw new IllegalArgumentException("Pass is not init");
                    }
                } else {
                    throw new IllegalArgumentException("Pass is not init");
                }
            }
        }
        return instance;
    }

    public String getAccountEncryptKey() {
        if (TextUtils.isEmpty(encryptKey)) {
            try {
                encryptKey = SecurityUtil.md5((this.context.getPackageName() + SapiUtils.getPackageSign(this.context, this.context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
        }
        return encryptKey;
    }

    public String getContactsVersionByUid() {
        String str;
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

    public List<SapiAccount> getTouchidAccounts() {
        String str;
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

    public void addLoginAccount(SapiAccount sapiAccount) {
        int i;
        int i2;
        if (sapiAccount == null) {
            return;
        }
        List<SapiAccount> loginAccounts = getLoginAccounts();
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

    public void markAsDeleteFaceLogin(JSONArray jSONArray) {
        int i;
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

    public void addTouchidAccounts(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
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

    public void removeTouchidAccountByPortrait(String str) {
        if (TextUtils.isEmpty(str)) {
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

    public void updateContactsVersionWithUid(String str) {
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

    public void updateTouchidAccounts(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            return;
        }
        List<SapiAccount> touchidAccounts = getTouchidAccounts();
        for (SapiAccount sapiAccount2 : touchidAccounts) {
            if (sapiAccount.equals(sapiAccount2)) {
                sapiAccount2.portrait = sapiAccount.portrait;
                sapiAccount2.username = sapiAccount.username;
                sapiAccount2.displayname = sapiAccount.displayname;
            }
        }
        put(KEY_TOUCHID_ACCOUNTS, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), getAccountEncryptKey()));
    }

    public boolean getBoolean(String str, boolean z) {
        return this.storage.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        return this.storage.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.storage.getLong(str, j);
    }

    public void put(String str, int i) {
        this.storage.edit().putInt(str, i).apply();
    }

    public void putEncryptStr(String str, String str2) {
        put(str, SapiDataEncryptor.encryptAccountInfo(str2, getAccountEncryptKey()));
    }

    public void setUserAttrInfo(String str, String str2) {
        putEncryptStr(str, str2);
    }

    public synchronized SapiAccount getCurrentAccount() {
        String str;
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

    public List<SapiAccount> getLoginAccounts() {
        String str;
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
                List<SapiAccount> fromJSONArray = SapiAccount.fromJSONArray(new JSONArray(str));
                Collections.reverse(fromJSONArray);
                return fromJSONArray;
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public JSONObject getV2FaceLoginCheckResults() {
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

    public void put(String str, long j) {
        this.storage.edit().putLong(str, j).apply();
    }

    public void put(String str, String str2) {
        this.storage.edit().putString(str, str2).apply();
    }

    public void put(String str, boolean z) {
        this.storage.edit().putBoolean(str, z).apply();
    }

    public void refershPortraitByUid(String str, String str2) {
        if (str == null) {
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

    public void setCurrentAccount(SapiAccount sapiAccount, boolean z) {
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
        if (z) {
            LoginHistoryLoginModel.updateLoginHistoryInfo(sapiAccount);
        }
    }

    public void setClickRealNameTimes(String str, long j) {
        JSONArray jSONArray;
        String decryptStr = getDecryptStr("key_setting_show_real_name_guide_click_" + str);
        if (TextUtils.isEmpty(decryptStr)) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = new JSONArray(decryptStr);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONArray = new JSONArray();
            }
        }
        jSONArray.put(j);
        if (jSONArray.length() > 10) {
            JSONArray jSONArray2 = new JSONArray();
            for (int length = jSONArray.length() - 10; length < jSONArray.length(); length++) {
                jSONArray2.put(jSONArray.opt(length));
            }
            jSONArray = jSONArray2;
        }
        putEncryptStr("key_setting_show_real_name_guide_click_" + str, jSONArray.toString());
    }
}
