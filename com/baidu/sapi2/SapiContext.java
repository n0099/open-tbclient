package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.utils.EncodeUtils;
import com.baidu.sapi2.passhost.framework.b;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiContext {
    private static final String A = "v2_face_check_result_type";
    private static final String B = "v2_last_check_suc_time";
    private static final String C = "share_storage";
    private static String F = null;
    private static SapiContext G = null;
    public static final String KEY_INIT_SHARE_LOGIN_GRAY = "init_share_login_gray";
    public static final String KEY_LAST_LOGIN_PHONE = "last_login_phone";
    public static final String KEY_LAST_LOGIN_USER_PORTRAIT = "last_login_user_portrait";
    public static final String KEY_LOGIN_PAGE_IS_CACHED = "login_page_is_cached";
    public static final String KEY_MODIFIED_DIR_EXEC_PER = "modified_dir_exec_per";
    public static final String KEY_OPENID_UID_LIST = "openid_uid_list";
    public static final String KEY_PACKAGE_DIR_EXECUTE_PER = "package_dir_execute_per";
    public static final String KEY_PRE_LOGIN_TYPE = "pre_login_type";
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
    private static final String h = "relogin_credentials";
    private static final String i = "cuidtoken";
    private static final String j = "device_token";
    private static final String k = "hosts_hijacked";
    private static final String l = "time_offset_seconds";
    private static final String m = "device_info_read_times";
    private static final String n = "root_status";
    private static final String o = "en_current_account";
    private static final String p = "en_share_accounts";
    private static final String q = "en_login_accounts";
    private static final String r = "en_relogin_credentials";
    private static final String s = "pi_g_p";
    private static final String t = "en_sofire_zid_inited";
    private static final String u = "account_type";
    private static final String v = "iqiyi_token";
    private static final String w = "face_login_uid";
    private static final String x = "face_login_hash_json";
    private static final String y = "face_livingunames";
    private static final String z = "v2_face_login_check_result";
    private SharedPreferences D;
    private Context E;

    public static SapiContext getInstance(Context context) {
        synchronized (SapiContext.class) {
            if (G == null) {
                G = new SapiContext(context.getApplicationContext());
            }
        }
        return G;
    }

    private SapiContext(Context context) {
        this.E = context;
        this.D = context.getSharedPreferences("sapi_system", 0);
    }

    public void put(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.D.edit().putString(str, str2).apply();
        } else {
            this.D.edit().putString(str, str2).commit();
        }
    }

    public void put(String str, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.D.edit().putInt(str, i2).apply();
        } else {
            this.D.edit().putInt(str, i2).commit();
        }
    }

    private void a(String str, long j2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.D.edit().putLong(str, j2).apply();
        } else {
            this.D.edit().putLong(str, j2).commit();
        }
    }

    public void put(String str, boolean z2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.D.edit().putBoolean(str, z2).apply();
        } else {
            this.D.edit().putBoolean(str, z2).commit();
        }
    }

    public void putEncryptStr(String str, String str2) {
        put(str, SapiDataEncryptor.encryptAccountInfo(str2, c()));
    }

    public String getDecryptStr(String str) {
        return SapiDataEncryptor.decryptAccountInfo(getString(str), c());
    }

    public String getString(String str) {
        return this.D.getString(str, "");
    }

    public boolean getBoolean(String str, boolean z2) {
        return this.D.getBoolean(str, z2);
    }

    public int getInt(String str, int i2) {
        return this.D.getInt(str, i2);
    }

    private long b(String str, long j2) {
        return this.D.getLong(str, j2);
    }

    public boolean isHostsHijacked() {
        return getBoolean(k, false);
    }

    public void setHostsHijacked(boolean z2) {
        put(k, z2);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.D.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.D.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            put(o, "");
            SapiUtils.webLogout(this.E);
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            put(o, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), c()));
            SapiUtils.webLogin(this.E, sapiAccount.bduss, sapiAccount.ptoken);
            if (!isLoginStatusChanged()) {
                b();
            }
        }
    }

    public synchronized SapiAccount getCurrentAccount() {
        String str;
        SapiAccount sapiAccount = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(getString(o))) {
                str = SapiDataEncryptor.decryptAccountInfo(getString(o), c());
            } else if (TextUtils.isEmpty(getString(b))) {
                str = null;
            } else {
                str = getString(b);
                String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
                if (!TextUtils.isEmpty(encryptAccountInfo)) {
                    put(o, encryptAccountInfo);
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
        if (!TextUtils.isEmpty(getString(p))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(p), c());
        } else if (!TextUtils.isEmpty(getString(c))) {
            str = getString(c);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(p, encryptAccountInfo);
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
        if (!TextUtils.isEmpty(getString(q))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(q), c());
        } else if (!TextUtils.isEmpty(getString(d))) {
            str = getString(d);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(q, encryptAccountInfo);
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

    public List<b.a> getGrayPlugins() {
        if (!TextUtils.isEmpty(getString(s))) {
            String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(getString(s), c());
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                try {
                    return b.a.a(new JSONArray(decryptAccountInfo));
                } catch (JSONException e2) {
                    return new ArrayList();
                }
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

    SapiAccount a(String str) {
        if (str == null) {
            return null;
        }
        SapiAccount currentAccount = getCurrentAccount();
        if (currentAccount == null || !str.equals(currentAccount.getReloginCredentials().ubi)) {
            for (SapiAccount sapiAccount : getLoginAccounts()) {
                if (str.equals(sapiAccount.getReloginCredentials().ubi)) {
                    return sapiAccount;
                }
            }
            for (SapiAccount sapiAccount2 : getShareAccounts()) {
                if (str.equals(sapiAccount2.getReloginCredentials().ubi)) {
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

    private void b() {
        put(f, true);
    }

    public void resetSilentShareStatus() {
        put(f, false);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(p, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), c()));
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(q, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), c()));
        }
    }

    public void setGrayPlugin(List<b.a> list) {
        JSONArray a2 = b.a.a(list);
        if (a2 != null) {
            put(s, SapiDataEncryptor.encryptAccountInfo(a2.toString(), c()));
        }
    }

    public void setSofireZidInited(boolean z2) {
        put(t, z2);
    }

    public boolean getSofireZidInited() {
        return getBoolean(t, false);
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

    public Map<String, String> getPluginsSuffix() {
        return getSapiOptions().getPluginsSuffix();
    }

    public Map<String, String> getAuthorizedPackages() {
        return getSapiOptions().getAuthorizedPackages();
    }

    public Map<String, String> getSCAuthorizedPackages() {
        return getSapiOptions().getSCAuthorizedPackages();
    }

    public List<String> getAuthorizedDomains() {
        return getSapiOptions().getAuthorizedDomains();
    }

    public List<String> getCuidAuthorizedDomains() {
        return getSapiOptions().getCuidAuthorizedDomains();
    }

    public Map<String, String> getVehicleSystemPackages() {
        return getSapiOptions().getVehicleSystemPackages();
    }

    public List<String> getAuthorizedDomainsForPtoken() {
        return getSapiOptions().g();
    }

    public List<String> getAuthorizedPackagesForUA() {
        return getSapiOptions().e();
    }

    public String getFastRegChannel() {
        return getSapiOptions().getFastRegSmsNum();
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        return getSapiOptions().d();
    }

    public boolean getDefaultHttpsEnabled() {
        return getSapiOptions().getDefaultHttpsEnabled();
    }

    public boolean getSofireSdkEnabled() {
        return getSapiOptions().getSofireSdkEnabled();
    }

    public boolean getPluginEnabled() {
        return getSapiOptions().getPluginsEnabled();
    }

    public void addReloginCredentials(String str, SapiAccount.ReloginCredentials reloginCredentials) {
        if (!TextUtils.isEmpty(str) && reloginCredentials != null && !TextUtils.isEmpty(reloginCredentials.account) && !TextUtils.isEmpty(reloginCredentials.password) && !TextUtils.isEmpty(reloginCredentials.ubi) && !TextUtils.isEmpty(reloginCredentials.accountType)) {
            b(reloginCredentials.ubi);
            JSONObject reloginCredentials2 = getReloginCredentials();
            if (reloginCredentials2 == null) {
                reloginCredentials2 = new JSONObject();
            }
            try {
                reloginCredentials2.put(str, reloginCredentials.toJSONObject());
                put(r, SapiDataEncryptor.encryptAccountInfo(reloginCredentials2.toString(), c()));
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
    }

    public SapiAccount.ReloginCredentials getReloginCredentials(String str) {
        JSONObject optJSONObject;
        JSONObject reloginCredentials = getReloginCredentials();
        if (reloginCredentials == null || (optJSONObject = reloginCredentials.optJSONObject(str)) == null) {
            return new SapiAccount.ReloginCredentials();
        }
        SapiAccount.ReloginCredentials fromJSONObject = SapiAccount.ReloginCredentials.fromJSONObject(optJSONObject);
        fromJSONObject.ubi = a();
        return fromJSONObject;
    }

    public JSONObject getReloginCredentials() {
        String str;
        if (!TextUtils.isEmpty(getString(r))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(r), c());
        } else if (TextUtils.isEmpty(getString(h))) {
            str = null;
        } else {
            str = getString(h);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(r, encryptAccountInfo);
                put(h, "");
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            Log.e(e2);
            return null;
        }
    }

    public void setAccountActionType(String str) {
        put("account_type", str);
    }

    public String getAccountActionType() {
        return getString("account_type");
    }

    public void setIqiyiAccesstoken(String str) {
        if (TextUtils.isEmpty(str)) {
            put(v, "");
        } else {
            put(v, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public String getIqiyiAccesstoken() {
        if (TextUtils.isEmpty(getString(v))) {
            return "";
        }
        return SapiDataEncryptor.decryptAccountInfo(getString(v), c());
    }

    void b(String str) {
        put(i, str);
    }

    String a() {
        return getString(i);
    }

    public int getTimeOffsetSeconds() {
        return getInt(l, 0);
    }

    public int getAppVersionCode() {
        return getInt("app_version_code", 0);
    }

    public void setAppVersionCode(int i2) {
        put("app_version_code", i2);
    }

    public long getDeviceInfoReadTimes() {
        long b2 = b(m, 0L) + 1;
        a(m, b2);
        return b2;
    }

    private String c() {
        if (TextUtils.isEmpty(F)) {
            try {
                F = EncodeUtils.toMd5((this.E.getPackageName() + SapiUtils.getPackageSign(this.E, this.E.getPackageName())).getBytes("UTF-8")).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return F;
    }

    public void setRootStatus(String str) {
        put(n, str);
    }

    public String getRootStatus() {
        return getString(n);
    }

    <T> List<T> a(List<T> list, int i2) {
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return list;
        }
        return list.subList(list.size() - i2, list.size());
    }

    public String getFaceLoginModel() {
        if (TextUtils.isEmpty(getString(x))) {
            return "";
        }
        return SapiDataEncryptor.decryptAccountInfo(getString(x), c());
    }

    public void setFaceLoginModel(String str) {
        if (TextUtils.isEmpty(str)) {
            put(x, "");
        } else {
            put(x, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public void setUidSupFaceLoginType(String str) {
        put(A, str);
    }

    public String geSupFaceLoginType() {
        return getString(A);
    }

    public void setV2FaceLoginCheckResults(String str) {
        if (TextUtils.isEmpty(str)) {
            put(z, "");
        } else {
            put(z, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public String getV2FaceLoginCheckResults() {
        String string = getString(z);
        return TextUtils.isEmpty(string) ? "" : SapiDataEncryptor.decryptAccountInfo(string, c());
    }

    public String getFaceLoginUid() {
        if (TextUtils.isEmpty(getString(w))) {
            return "";
        }
        return SapiDataEncryptor.decryptAccountInfo(getString(w), c());
    }

    public void setFaceLoginUid(String str) {
        setFaceLoginModel("");
        if (TextUtils.isEmpty(str)) {
            put(w, "");
        } else {
            put(w, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public void setV2LastFaceLoginCheckTime(long j2) {
        a(B, j2);
    }

    public long getLastFaceLoginCheckTime() {
        return b(B, 0L);
    }

    public void setV2FaceLivingunames(String str) {
        put(y, str);
    }

    public String getV2FaceLivingUnames() {
        return getString(y);
    }

    public boolean shareLivingunameEnable() {
        return getSapiOptions().shareLivingunameEnabled;
    }

    public boolean smsFaceLoginEnable() {
        return getSapiOptions().smsFaceLoginEnable;
    }

    public List<Integer> getDiExceptIndex() {
        return getSapiOptions().diExceptIndex;
    }

    public int getShareAccountGray() {
        return getSapiOptions().shareAccountGray;
    }

    public int getFaceLoginCheckFreq() {
        return getSapiOptions().faceLoginCheckFreq;
    }

    public boolean getShareFaceLoginEnable() {
        return getSapiOptions().shareFaceLoginEnable;
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
            put(C, "");
        } else {
            put(C, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), c()));
        }
    }

    public JSONArray getShareStorage() {
        if (TextUtils.isEmpty(getString(C))) {
            return null;
        }
        try {
            return new JSONArray(SapiDataEncryptor.decryptAccountInfo(getString(C), c()));
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
}
