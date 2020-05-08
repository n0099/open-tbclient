package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.X;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes6.dex */
public final class SapiContext implements c {
    private static final String A = "sid";
    private static final int B = 5;
    private static String C = null;
    public static final String CHINA_TELECOM_EXPIRED_TIME = "china_telecom_expired_time";
    public static final String CHINA_UNICOM_EXPIRED_TIME = "china_telecom_expired_time";
    private static SapiContext D = null;
    public static final String KEY_CONFIG_FILE_ETAG = "config_file_etag";
    public static final String KEY_CONTACTS_UID_VERSION = "contacts_uid_version";
    public static final String KEY_LAST_LOGIN_PHONE = "last_login_phone";
    public static final String KEY_LAST_LOGIN_UID = "last_login_uid";
    public static final String KEY_LAST_LOGIN_USER_PORTRAIT = "last_login_user_portrait";
    public static final String KEY_LOGIN_PAGE_IS_CACHED = "login_page_is_cached";
    public static final String KEY_MODIFIED_DIR_EXEC_PER = "modified_dir_exec_per";
    public static final String KEY_OPENID_UID_LIST = "openid_uid_list";
    public static final String KEY_OPEN_BDUSS_INFO = "open_bduss_info";
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
    private static final String h = "pkg_signs";
    private static final String i = "hosts_hijacked";
    private static final String j = "device_info_read_times";
    private static final String k = "root_status";
    private static final String l = "en_current_account";
    private static final String m = "en_share_accounts";
    private static final String n = "en_login_accounts";
    private static final String o = "account_type";
    private static final String p = "iqiyi_token";
    private static final String q = "face_livingunames";
    private static final String r = "v2_face_login_check_result";
    private static final String s = "share_storage";
    private static final String t = "share_delete_list";
    private static final String u = "face_login_delete_list";
    private static final String v = "bio_sdk_enable";
    private static final String w = "touchid_accounts";
    private static final String x = "touchid_login_record";
    private static final String y = "one_key_login_js_code";
    private static final String z = "one_key_login_js_md5";
    private SharedPreferences E;
    private Context F;

    private SapiContext(Context context) {
        this.F = context;
        this.E = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(n, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), a()));
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(m, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), a()));
        }
    }

    private void c() {
        put(f, true);
    }

    public static SapiContext getInstance() {
        synchronized (SapiContext.class) {
            if (D == null) {
                D = new SapiContext(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
            }
        }
        return D;
    }

    public void addTouchidLoginRecord(String str) {
        String string = getString(x);
        if (TextUtils.isEmpty(string)) {
            put(x, str);
        } else if (!string.contains(str)) {
            put(x, string + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
        }
    }

    public String getAccountActionType() {
        return getString("account_type");
    }

    public int getAppVersionCode() {
        return getInt("app_version_code", 0);
    }

    public boolean getAsyncCookie() {
        return getSapiOptions().i();
    }

    public List<String> getAuthorizedDomains() {
        return getSapiOptions().a();
    }

    public List<String> getAuthorizedDomainsForPtoken() {
        return getSapiOptions().b();
    }

    public Map<String, String> getAuthorizedPackages() {
        return b().a();
    }

    public List<String> getAuthorizedPackagesForUA() {
        return getSapiOptions().d();
    }

    public boolean getBoolean(String str, boolean z2) {
        return this.E.getBoolean(str, z2);
    }

    public String getContactsVersionByUid() {
        JSONObject jSONObject;
        String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(getString(KEY_CONTACTS_UID_VERSION), a());
        SapiAccount currentAccount = getCurrentAccount();
        String str = currentAccount != null ? currentAccount.uid : "";
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(decryptAccountInfo)) {
            try {
                jSONObject = new JSONObject(decryptAccountInfo);
            } catch (JSONException e2) {
                Log.e(e2);
            }
            return jSONObject.optString(str);
        }
        jSONObject = jSONObject2;
        return jSONObject.optString(str);
    }

    public List<String> getCuidAuthorizedDomains() {
        return getSapiOptions().f();
    }

    public synchronized SapiAccount getCurrentAccount() {
        String str;
        SapiAccount sapiAccount = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(getString(l))) {
                str = SapiDataEncryptor.decryptAccountInfo(getString(l), a());
            } else if (TextUtils.isEmpty(getString(b))) {
                str = null;
            } else {
                str = getString(b);
                String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, a());
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

    public String getDecryptStr(String str) {
        return SapiDataEncryptor.decryptAccountInfo(getString(str), a());
    }

    public boolean getDefaultHttpsEnabled() {
        return getSapiOptions().g();
    }

    public String[] getDeleteFaceLoginList() {
        String string = getString(u);
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        return string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public String[] getDeleteShareLoginList() {
        String string = getString(t);
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        return string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public String getDeviceInfo() {
        List<String> n2 = getSapiOptions().n();
        return (n2.size() == 1 && n2.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) ? SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt") : SapiDeviceInfo.getDiCookieInfo(n2);
    }

    public long getDeviceInfoReadTimes() {
        long j2 = getLong(j, 0L) + 1;
        put(j, j2);
        return j2;
    }

    public List<Integer> getDiExceptIndex() {
        return getSapiOptions().O;
    }

    public int getInt(String str, int i2) {
        return this.E.getInt(str, i2);
    }

    public String getIqiyiAccesstoken() {
        return TextUtils.isEmpty(getString(p)) ? "" : SapiDataEncryptor.decryptAccountInfo(getString(p), a());
    }

    public String getJoinQrLoginPrompt() {
        return getSapiOptions().Z;
    }

    public List<SapiAccount> getLoginAccounts() {
        String str = null;
        if (!TextUtils.isEmpty(getString(n))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(n), a());
        } else if (!TextUtils.isEmpty(getString(d))) {
            str = getString(d);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, a());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(n, encryptAccountInfo);
                put(d, "");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                List<SapiAccount> fromJSONArray = SapiAccount.fromJSONArray(new JSONArray(str));
                Collections.reverse(fromJSONArray);
                return fromJSONArray;
            } catch (Exception e2) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public int getLoginStatExtraLimitLen() {
        return getSapiOptions().V;
    }

    public long getLong(String str, long j2) {
        return this.E.getLong(str, j2);
    }

    public boolean getModifiedDirExecPer() {
        return getBoolean(KEY_MODIFIED_DIR_EXEC_PER, false);
    }

    public String getOneKeyLoginJsCode() {
        return getString(y);
    }

    public String getOnekeyLoginJsMd5() {
        return getString(z);
    }

    public List<String> getOpenBdussDomains() {
        return getSapiOptions().p();
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        return getSapiOptions().r();
    }

    public String getPackageDirExecutePer() {
        return getString(KEY_PACKAGE_DIR_EXECUTE_PER);
    }

    public boolean getResetFileExecPer() {
        return getSapiOptions().Y;
    }

    public String getRootStatus() {
        return getString(k);
    }

    public Map<String, String> getSCAuthorizedPackages() {
        return b().e();
    }

    public X getSapiOptions() {
        String string = getString(g);
        if (!TextUtils.isEmpty(string)) {
            try {
                return X.a(new JSONObject(string));
            } catch (JSONException e2) {
            }
        }
        return new X();
    }

    public String getSearchBoxSid() {
        return getString("sid");
    }

    public List<SapiAccount> getShareAccounts() {
        String str = null;
        if (!TextUtils.isEmpty(getString(m))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(m), a());
        } else if (!TextUtils.isEmpty(getString(c))) {
            str = getString(c);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, a());
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

    public boolean getShareCommonStorageEnabel() {
        return getSapiOptions().U;
    }

    public int getShareInternalGray() {
        return getSapiOptions().X;
    }

    public JSONArray getShareStorage() {
        if (TextUtils.isEmpty(getString(s))) {
            return null;
        }
        try {
            return new JSONArray(SapiDataEncryptor.decryptAccountInfo(getString(s), a()));
        } catch (Exception e2) {
            return null;
        }
    }

    public String getString(String str) {
        return this.E.getString(str, "");
    }

    public String getTid() {
        return getSapiOptions().ba;
    }

    public List<SapiAccount> getTouchidAccounts() {
        String decryptAccountInfo = TextUtils.isEmpty(getString(w)) ? null : SapiDataEncryptor.decryptAccountInfo(getString(w), a());
        if (!TextUtils.isEmpty(decryptAccountInfo)) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(decryptAccountInfo));
            } catch (Throwable th) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public List<String> getTouchidLoginRecord() {
        String string = getString(x);
        if (TextUtils.isEmpty(string)) {
            return new ArrayList(0);
        }
        return Arrays.asList(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
    }

    public String getV2FaceLivingUnames() {
        return getString(q);
    }

    public JSONObject getV2FaceLoginCheckResults() {
        String decryptStr = getDecryptStr(r);
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

    public Map<String, String> getVehicleSystemPackages() {
        return b().f();
    }

    public boolean isFirstLaunch() {
        if (getBoolean(e, true)) {
            put(e, false);
            return true;
        }
        return false;
    }

    public boolean isHostsHijacked() {
        return getBoolean(i, false);
    }

    public boolean isLoginStatusChanged() {
        return getBoolean(f, false);
    }

    public boolean isMeetOneKeyLoginGray(int i2) {
        String str = "unkown";
        if (i2 == 1) {
            str = X.c.b;
        } else if (i2 == 2) {
            str = X.c.c;
        } else if (i2 == 3) {
            str = X.c.d;
        }
        return getSapiOptions().aa.a(str).c;
    }

    public void markAsDeleteFaceLogin(JSONArray jSONArray) {
        String[] deleteFaceLoginList = getDeleteFaceLoginList();
        StringBuilder sb = new StringBuilder();
        for (int length = deleteFaceLoginList.length + jSONArray.length() > 10 ? (deleteFaceLoginList.length + jSONArray.length()) - 10 : 0; length < deleteFaceLoginList.length; length++) {
            sb.append(deleteFaceLoginList[length]).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        int length2 = jSONArray.length();
        for (int i2 = 0; i2 < length2; i2++) {
            sb.append(URLDecoder.decode(jSONArray.optString(i2))).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        put(u, sb.toString().substring(0, sb.toString().length() - 1));
    }

    public void markAsDeleteShareLogin(String str) {
        String[] deleteShareLoginList = getDeleteShareLoginList();
        StringBuilder sb = new StringBuilder();
        for (int length = deleteShareLoginList.length + 1 > 10 ? (deleteShareLoginList.length + 1) - 10 : 0; length < deleteShareLoginList.length; length++) {
            sb.append(deleteShareLoginList[length]).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        sb.append(str);
        put(t, sb.toString());
    }

    public void put(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.E.edit().putString(str, str2).apply();
        } else {
            this.E.edit().putString(str, str2).commit();
        }
    }

    public void putEncryptStr(String str, String str2) {
        put(str, SapiDataEncryptor.encryptAccountInfo(str2, a()));
    }

    public void removeTouchidAccountByPortrait(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<SapiAccount> touchidAccounts = getTouchidAccounts();
            Iterator<SapiAccount> it = touchidAccounts.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().email)) {
                    it.remove();
                }
            }
            put(w, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), a()));
        }
    }

    public void resetSilentShareStatus() {
        put(f, false);
    }

    public void setAccountActionType(String str) {
        put("account_type", str);
    }

    public void setAppVersionCode(int i2) {
        put("app_version_code", i2);
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            put(l, "");
            SapiUtils.webLogout(this.F);
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            put(l, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), a()));
            SapiUtils.webLogin(this.F, sapiAccount.bduss, sapiAccount.ptoken);
            if (!isLoginStatusChanged()) {
                c();
            }
        }
    }

    public void setHostsHijacked(boolean z2) {
        put(i, z2);
    }

    public void setIqiyiAccesstoken(String str) {
        if (TextUtils.isEmpty(str)) {
            put(p, "");
        } else {
            put(p, SapiDataEncryptor.encryptAccountInfo(str, a()));
        }
    }

    public void setModifiedDirExecPer(boolean z2) {
        put(KEY_MODIFIED_DIR_EXEC_PER, z2);
    }

    public void setOneKeyLoginJSCode(String str) {
        put(y, str);
    }

    public void setOnekeyLoginJsMd5(String str) {
        put(z, str);
    }

    public void setPackageDirExecutePer(String str) {
        put(KEY_PACKAGE_DIR_EXECUTE_PER, str);
    }

    public void setPkgSigns(X.d dVar) {
        if (dVar != null) {
            put(h, dVar.g());
        }
    }

    public void setRootStatus(String str) {
        put(k, str);
    }

    public void setSapiOptions(X x2) {
        if (x2 != null) {
            put(g, x2.u());
        }
    }

    public void setSearchBoxSid(String str) {
        put("sid", str);
    }

    public void setShareStorage(JSONArray jSONArray) {
        if (jSONArray == null) {
            put(s, "");
        } else {
            put(s, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), a()));
        }
    }

    public void setV2FaceLivingunames(String str) {
        put(q, str);
    }

    public void setV2FaceLoginCheckResults(String str) {
        putEncryptStr(r, str);
    }

    public boolean shareLivingunameEnable() {
        return getSapiOptions().T;
    }

    public void updateContactsVersionWithUid(String str) {
        String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(getString(KEY_CONTACTS_UID_VERSION), a());
        String str2 = getCurrentAccount().uid;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(decryptAccountInfo)) {
                jSONObject = new JSONObject(decryptAccountInfo);
            }
        } catch (JSONException e2) {
            e = e2;
        }
        try {
            jSONObject.put(str2, str);
        } catch (JSONException e3) {
            e = e3;
            Log.e(e);
            put(KEY_CONTACTS_UID_VERSION, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), a()));
        }
        put(KEY_CONTACTS_UID_VERSION, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), a()));
    }

    public void put(String str, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.E.edit().putInt(str, i2).apply();
        } else {
            this.E.edit().putInt(str, i2).commit();
        }
    }

    public void removeShareAccount(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> shareAccounts = getShareAccounts();
            if (shareAccounts.contains(sapiAccount)) {
                shareAccounts.remove(sapiAccount);
                b(shareAccounts);
            }
        }
    }

    private String a() {
        if (TextUtils.isEmpty(C)) {
            try {
                C = SecurityUtil.md5((this.F.getPackageName() + SapiUtils.getPackageSign(this.F, this.F.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return C;
    }

    private X.d b() {
        String string = getString(h);
        if (!TextUtils.isEmpty(string)) {
            try {
                return X.d.a(new JSONObject(string));
            } catch (JSONException e2) {
            }
        }
        return new X.d();
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
            b(a(shareAccounts, MAX_SHARE_ACCOUNTS));
        }
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

    public void put(String str, long j2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.E.edit().putLong(str, j2).apply();
        } else {
            this.E.edit().putLong(str, j2).commit();
        }
    }

    public void addTouchidAccounts(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> touchidAccounts = getTouchidAccounts();
            Iterator<SapiAccount> it = touchidAccounts.iterator();
            while (it.hasNext()) {
                if (sapiAccount.equals(it.next())) {
                    it.remove();
                }
            }
            touchidAccounts.add(sapiAccount);
            put(w, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), a()));
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
                a(loginAccounts);
            }
        }
    }

    public void put(String str, boolean z2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.E.edit().putBoolean(str, z2).apply();
        } else {
            this.E.edit().putBoolean(str, z2).commit();
        }
    }

    <T> List<T> a(List<T> list, int i2) {
        return (list == null || i2 < 0 || i2 >= list.size()) ? list : list.subList(list.size() - i2, list.size());
    }

    public void addLoginAccount(SapiAccount sapiAccount) {
        int i2;
        int i3;
        if (sapiAccount != null) {
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
            a(loginAccounts);
        }
    }
}
