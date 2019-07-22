package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiContext {
    private static String C = null;
    public static final String CHINA_TELECOM_EXPIRED_TIME = "china_telecom_expired_time";
    private static SapiContext D = null;
    public static final String KEY_CONFIG_FILE_ETAG = "config_file_etag";
    public static final String KEY_LAST_CHECK_PUSH_TIME = "push_last_check_time";
    public static final String KEY_LAST_LOGIN_PHONE = "last_login_phone";
    public static final String KEY_LAST_LOGIN_USER_PORTRAIT = "last_login_user_portrait";
    public static final String KEY_LOGIN_PAGE_IS_CACHED = "login_page_is_cached";
    public static final String KEY_MODIFIED_DIR_EXEC_PER = "modified_dir_exec_per";
    public static final String KEY_OPENID_UID_LIST = "openid_uid_list";
    public static final String KEY_PACKAGE_DIR_EXECUTE_PER = "package_dir_execute_per";
    public static final String KEY_PRE_LOGIN_TYPE = "pre_login_type";
    public static final String KEY_PUSH_INTERNAL_TIME = "push_internal_time";
    public static final String KEY_PUSH_SUC_TIME = "push_suc_time";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SHARE_INTERNAL_GRAY = "share_internal";
    public static int MAX_SHARE_ACCOUNTS = 5;
    private static final String a = "app_version_code";
    private static final String b = "current_account";
    private static final String c = "share_accounts";
    private static final String d = "login_accounts";
    private static final String e = "first_install";
    private static final String f = "login_status_changed";
    private static final String g = "sapi_options";
    private static final String h = "pkg_signs";
    private static final String i = "hosts_hijacked";
    private static final String j = "device_info_read_times";
    private static final String k = "root_status";
    private static final String l = "en_current_account";
    private static final String m = "en_share_accounts";
    private static final String n = "en_login_accounts";
    private static final String o = "account_type";
    private static final String p = "iqiyi_token";
    private static final String q = "face_login_uid";
    private static final String r = "face_login_hash_json";
    private static final String s = "face_livingunames";
    private static final String t = "v2_face_login_check_result";
    private static final String u = "v2_face_check_result_type";
    private static final String v = "v2_last_check_suc_time";
    private static final String w = "share_storage";
    private static final String x = "bio_sdk_enable";
    private static final String y = "cm_oauth_gray";
    private static final String z = "ct_oauth_gray";
    private SharedPreferences A;
    private Context B;

    public static SapiContext getInstance(Context context) {
        synchronized (SapiContext.class) {
            if (D == null) {
                D = new SapiContext(context.getApplicationContext());
            }
        }
        return D;
    }

    private SapiContext(Context context) {
        this.B = context;
        this.A = context.getSharedPreferences("sapi_system", 0);
    }

    public void put(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.A.edit().putString(str, str2).apply();
        } else {
            this.A.edit().putString(str, str2).commit();
        }
    }

    public void put(String str, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.A.edit().putInt(str, i2).apply();
        } else {
            this.A.edit().putInt(str, i2).commit();
        }
    }

    public void put(String str, long j2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.A.edit().putLong(str, j2).apply();
        } else {
            this.A.edit().putLong(str, j2).commit();
        }
    }

    public void put(String str, boolean z2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.A.edit().putBoolean(str, z2).apply();
        } else {
            this.A.edit().putBoolean(str, z2).commit();
        }
    }

    public void putEncryptStr(String str, String str2) {
        put(str, SapiDataEncryptor.encryptAccountInfo(str2, c()));
    }

    public String getDecryptStr(String str) {
        return SapiDataEncryptor.decryptAccountInfo(getString(str), c());
    }

    public String getString(String str) {
        return this.A.getString(str, "");
    }

    public boolean getBoolean(String str, boolean z2) {
        return this.A.getBoolean(str, z2);
    }

    public int getInt(String str, int i2) {
        return this.A.getInt(str, i2);
    }

    public long getLong(String str, long j2) {
        return this.A.getLong(str, j2);
    }

    public boolean isHostsHijacked() {
        return getBoolean(i, false);
    }

    public void setHostsHijacked(boolean z2) {
        put(i, z2);
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            put(l, "");
            SapiUtils.webLogout(this.B);
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            put(l, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), c()));
            SapiUtils.webLogin(this.B, sapiAccount.bduss, sapiAccount.ptoken);
            setPushInternalTime(1L);
            setPushSucTime(0L);
            setLastPushCheckTime(0L);
            if (!isLoginStatusChanged()) {
                a();
            }
        }
    }

    public synchronized SapiAccount getCurrentAccount() {
        String str;
        SapiAccount sapiAccount = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(getString(l))) {
                str = SapiDataEncryptor.decryptAccountInfo(getString(l), c());
            } else if (TextUtils.isEmpty(getString(b))) {
                str = null;
            } else {
                str = getString(b);
                String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
                if (!TextUtils.isEmpty(encryptAccountInfo)) {
                    put(l, encryptAccountInfo);
                    put(b, "");
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    sapiAccount = SapiAccount.fromJSONObject(new JSONObject(str));
                } catch (JSONException e2) {
                }
            }
        }
        return sapiAccount;
    }

    public void addShareAccount(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> shareAccounts = getShareAccounts();
            if (!shareAccounts.contains(sapiAccount)) {
                shareAccounts.add(sapiAccount);
            } else {
                shareAccounts.remove(shareAccounts.indexOf(sapiAccount));
                shareAccounts.add(sapiAccount);
            }
            a(a(shareAccounts, MAX_SHARE_ACCOUNTS));
        }
    }

    public void addLoginAccount(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> loginAccounts = getLoginAccounts();
            if (!loginAccounts.contains(sapiAccount)) {
                loginAccounts.add(sapiAccount);
            } else {
                loginAccounts.set(loginAccounts.indexOf(sapiAccount), sapiAccount);
            }
            b(loginAccounts);
        }
    }

    public void removeShareAccount(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> shareAccounts = getShareAccounts();
            if (shareAccounts.contains(sapiAccount)) {
                shareAccounts.remove(sapiAccount);
                a(shareAccounts);
            }
        }
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            SapiAccount currentAccount = getCurrentAccount();
            if (currentAccount != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(currentAccount.uid)) {
                setCurrentAccount(null);
                ServiceManager.getInstance().getIsAccountManager().invalidate(sapiAccount);
            }
            List<SapiAccount> loginAccounts = getLoginAccounts();
            if (loginAccounts.contains(sapiAccount)) {
                loginAccounts.remove(sapiAccount);
                b(loginAccounts);
            }
        }
    }

    public List<SapiAccount> getShareAccounts() {
        String str = null;
        if (!TextUtils.isEmpty(getString(m))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(m), c());
        } else if (!TextUtils.isEmpty(getString(c))) {
            str = getString(c);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(m, encryptAccountInfo);
                put(c, "");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return a(SapiAccount.fromJSONArray(new JSONArray(str)), MAX_SHARE_ACCOUNTS);
            } catch (Throwable th) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public List<SapiAccount> getLoginAccounts() {
        String str = null;
        if (!TextUtils.isEmpty(getString(n))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(n), c());
        } else if (!TextUtils.isEmpty(getString(d))) {
            str = getString(d);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(n, encryptAccountInfo);
                put(d, "");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(str));
            } catch (Exception e2) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public SapiAccount getAccountFromBduss(String str) {
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
            for (SapiAccount sapiAccount2 : getShareAccounts()) {
                if (str.equals(sapiAccount2.bduss)) {
                    return sapiAccount2;
                }
            }
            return null;
        }
        return currentAccount;
    }

    public boolean isFirstLaunch() {
        if (getBoolean(e, true)) {
            put(e, false);
            return true;
        }
        return false;
    }

    public boolean isLoginStatusChanged() {
        return getBoolean(f, false);
    }

    private void a() {
        put(f, true);
    }

    public void resetSilentShareStatus() {
        put(f, false);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(m, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), c()));
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(n, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), c()));
        }
    }

    public SapiOptions getSapiOptions() {
        String string = getString(g);
        if (!TextUtils.isEmpty(string)) {
            try {
                return SapiOptions.fromJSON(new JSONObject(string));
            } catch (JSONException e2) {
            }
        }
        return new SapiOptions();
    }

    public void setSapiOptions(SapiOptions sapiOptions) {
        if (sapiOptions != null) {
            put(g, sapiOptions.toJSON());
        }
    }

    private SapiOptions.PkgSigns b() {
        String string = getString(h);
        if (!TextUtils.isEmpty(string)) {
            try {
                return SapiOptions.PkgSigns.fromJSON(new JSONObject(string));
            } catch (JSONException e2) {
            }
        }
        return new SapiOptions.PkgSigns();
    }

    public void setPkgSigns(SapiOptions.PkgSigns pkgSigns) {
        if (pkgSigns != null) {
            put(h, pkgSigns.toJSON());
        }
    }

    public Map<String, String> getAuthorizedPackages() {
        return b().getAuthorizedPackages();
    }

    public Map<String, String> getSCAuthorizedPackages() {
        return b().getSCAuthorizedPackages();
    }

    public List<String> getAuthorizedDomains() {
        return getSapiOptions().getAuthorizedDomains();
    }

    public List<String> getCuidAuthorizedDomains() {
        return getSapiOptions().getCuidAuthorizedDomains();
    }

    public Map<String, String> getVehicleSystemPackages() {
        return b().getVehicleSystemPackages();
    }

    public boolean getAsyncCookie() {
        return getSapiOptions().getHttpAsyncCookie();
    }

    public List<String> getAuthorizedDomainsForPtoken() {
        return getSapiOptions().d();
    }

    public List<String> getAuthorizedPackagesForUA() {
        return getSapiOptions().b();
    }

    public String getFastRegChannel() {
        return getSapiOptions().getFastRegSmsNum();
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        return getSapiOptions().a();
    }

    public boolean getDefaultHttpsEnabled() {
        return getSapiOptions().getDefaultHttpsEnabled();
    }

    public void setAccountActionType(String str) {
        put("account_type", str);
    }

    public String getAccountActionType() {
        return getString("account_type");
    }

    public void setIqiyiAccesstoken(String str) {
        if (TextUtils.isEmpty(str)) {
            put(p, "");
        } else {
            put(p, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public String getIqiyiAccesstoken() {
        return TextUtils.isEmpty(getString(p)) ? "" : SapiDataEncryptor.decryptAccountInfo(getString(p), c());
    }

    public int getAppVersionCode() {
        return getInt("app_version_code", 0);
    }

    public void setAppVersionCode(int i2) {
        put("app_version_code", i2);
    }

    public long getDeviceInfoReadTimes() {
        long j2 = getLong(j, 0L) + 1;
        put(j, j2);
        return j2;
    }

    private String c() {
        if (TextUtils.isEmpty(C)) {
            try {
                C = MD5Util.toMd5((this.B.getPackageName() + SapiUtils.getPackageSign(this.B, this.B.getPackageName())).getBytes(HTTP.UTF_8), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return C;
    }

    public void setRootStatus(String str) {
        put(k, str);
    }

    public String getRootStatus() {
        return getString(k);
    }

    <T> List<T> a(List<T> list, int i2) {
        return (list == null || i2 < 0 || i2 >= list.size()) ? list : list.subList(list.size() - i2, list.size());
    }

    public String getFaceLoginModel() {
        return TextUtils.isEmpty(getString(r)) ? "" : SapiDataEncryptor.decryptAccountInfo(getString(r), c());
    }

    public void setFaceLoginModel(String str) {
        if (TextUtils.isEmpty(str)) {
            put(r, "");
        } else {
            put(r, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public void setUidSupFaceLoginType(String str) {
        put(u, str);
    }

    public String geSupFaceLoginType() {
        return getString(u);
    }

    public void setV2FaceLoginCheckResults(String str) {
        if (TextUtils.isEmpty(str)) {
            put(t, "");
        } else {
            put(t, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public String getV2FaceLoginCheckResults() {
        String string = getString(t);
        return TextUtils.isEmpty(string) ? "" : SapiDataEncryptor.decryptAccountInfo(string, c());
    }

    public String getFaceLoginUid() {
        return TextUtils.isEmpty(getString(q)) ? "" : SapiDataEncryptor.decryptAccountInfo(getString(q), c());
    }

    public void setFaceLoginUid(String str) {
        setFaceLoginModel("");
        if (TextUtils.isEmpty(str)) {
            put(q, "");
        } else {
            put(q, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public void setV2LastFaceLoginCheckTime(long j2) {
        put(v, j2);
    }

    public long getLastFaceLoginCheckTime() {
        return getLong(v, 0L);
    }

    public void setV2FaceLivingunames(String str) {
        put(s, str);
    }

    public String getV2FaceLivingUnames() {
        return getString(s);
    }

    public boolean shareLivingunameEnable() {
        return getSapiOptions().shareLivingunameEnabled;
    }

    public List<Integer> getDiExceptIndex() {
        return getSapiOptions().diExceptIndex;
    }

    public int getFaceLoginCheckFreq() {
        return getSapiOptions().faceLoginCheckFreq;
    }

    public boolean getShareCommonStorageEnabel() {
        return getSapiOptions().shareCommonStorageEnable;
    }

    public int getLoginStatExtraLimitLen() {
        return getSapiOptions().loginStatExtraLimitLen;
    }

    public int getShareInternalGray() {
        return getSapiOptions().shareInterGray;
    }

    public boolean getResetFileExecPer() {
        return getSapiOptions().resetFileExecPer;
    }

    public void setShareStorage(JSONArray jSONArray) {
        if (jSONArray == null) {
            put(w, "");
        } else {
            put(w, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), c()));
        }
    }

    public JSONArray getShareStorage() {
        if (TextUtils.isEmpty(getString(w))) {
            return null;
        }
        try {
            return new JSONArray(SapiDataEncryptor.decryptAccountInfo(getString(w), c()));
        } catch (Exception e2) {
            return null;
        }
    }

    public void setPackageDirExecutePer(String str) {
        put(KEY_PACKAGE_DIR_EXECUTE_PER, str);
    }

    public String getPackageDirExecutePer() {
        return getString(KEY_PACKAGE_DIR_EXECUTE_PER);
    }

    public void setModifiedDirExecPer(boolean z2) {
        put(KEY_MODIFIED_DIR_EXEC_PER, z2);
    }

    public boolean getModifiedDirExecPer() {
        return getBoolean(KEY_MODIFIED_DIR_EXEC_PER, false);
    }

    public List<String> getRimBackList() {
        return getSapiOptions().rimBackTplList;
    }

    public List<String> getPhoneRisksList() {
        return getSapiOptions().phoneRisksTpls;
    }

    public void setChinaMobileOauthGray(int i2) {
        put(y, i2);
    }

    public int getChinaMobileOauthGray() {
        return getInt(y, -1);
    }

    public void setChinaTelecomGray(int i2) {
        put(z, i2);
    }

    public int getChinaTelecomGray() {
        return getInt(y, -1);
    }

    public String getJoinQrLoginPrompt() {
        return getSapiOptions().joinQrLoginPrompt;
    }

    public void setPushInternalTime(long j2) {
        put(KEY_PUSH_INTERNAL_TIME, j2);
    }

    public long getPushInternalTime() {
        return getLong(KEY_PUSH_INTERNAL_TIME, 1L);
    }

    public void setPushSucTime(long j2) {
        put(KEY_PUSH_SUC_TIME, j2);
    }

    public long getPushSucTime() {
        return getLong(KEY_PUSH_SUC_TIME, 0L);
    }

    public void setLastPushCheckTime(long j2) {
        put(KEY_LAST_CHECK_PUSH_TIME, j2);
    }

    public long getLastPushCheckTime() {
        return getLong(KEY_LAST_CHECK_PUSH_TIME, 0L);
    }
}
