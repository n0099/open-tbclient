package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.e;
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
/* loaded from: classes5.dex */
public final class SapiContext implements NoProguard {
    private static final String A = "one_key_login_js_code";
    private static final String B = "one_key_login_js_md5";
    private static final String C = "sid";
    public static final String CHINA_TELECOM_EXPIRED_TIME = "china_telecom_expired_time";
    public static final String CHINA_UNICOM_EXPIRED_TIME = "china_telecom_expired_time";
    private static final String D = "is_already_show_explain_camera";
    private static final String E = "current_baidu_app_list";
    private static final int F = 5;
    private static String G = null;
    private static SapiContext H = null;
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
    private static final String c = "app_version_code";
    private static final String d = "current_account";
    private static final String e = "share_accounts";
    private static final String f = "login_accounts";
    private static final String g = "first_install";
    private static final String h = "login_status_changed";
    private static final String i = "sapi_options";
    private static final String j = "pkg_signs";
    private static final String k = "hosts_hijacked";
    private static final String l = "device_info_read_times";
    private static final String m = "root_status";
    private static final String n = "en_current_account";
    private static final String o = "en_share_accounts";
    private static final String p = "en_login_accounts";
    private static final String q = "account_type";
    private static final String r = "iqiyi_token";
    private static final String s = "face_livingunames";
    private static final String t = "v2_face_login_check_result";
    private static final String u = "share_storage";
    private static final String v = "share_delete_list";
    private static final String w = "face_login_delete_list";
    private static final String x = "bio_sdk_enable";
    private static final String y = "touchid_accounts";
    private static final String z = "touchid_login_record";

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f3233a;
    private Context b;

    private SapiContext(Context context) {
        this.b = context;
        this.f3233a = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(p, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), a()));
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(o, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), a()));
        }
    }

    private void c() {
        put(h, true);
    }

    public static SapiContext getInstance() {
        synchronized (SapiContext.class) {
            if (H == null) {
                H = new SapiContext(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
            }
        }
        return H;
    }

    public void addTouchidLoginRecord(String str) {
        String string = getString(z);
        if (TextUtils.isEmpty(string)) {
            put(z, str);
        } else if (!string.contains(str)) {
            put(z, string + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
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

    public String getBaiduAppPkgList() {
        return getString(E);
    }

    public boolean getBoolean(String str, boolean z2) {
        return this.f3233a.getBoolean(str, z2);
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
            if (!TextUtils.isEmpty(getString(n))) {
                str = SapiDataEncryptor.decryptAccountInfo(getString(n), a());
            } else if (TextUtils.isEmpty(getString(d))) {
                str = null;
            } else {
                str = getString(d);
                String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, a());
                if (!TextUtils.isEmpty(encryptAccountInfo)) {
                    put(n, encryptAccountInfo);
                    put(d, "");
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
        String string = getString(w);
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        return string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public String[] getDeleteShareLoginList() {
        String string = getString(v);
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        return string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public String getDeviceInfo() {
        List<String> j2 = getSapiOptions().j();
        return (j2.size() == 1 && j2.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) ? SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt") : SapiDeviceInfo.getDiCookieInfo(j2);
    }

    public long getDeviceInfoReadTimes() {
        long j2 = getLong(l, 0L) + 1;
        put(l, j2);
        return j2;
    }

    public List<Integer> getDiExceptIndex() {
        return getSapiOptions().i;
    }

    public int getInt(String str, int i2) {
        return this.f3233a.getInt(str, i2);
    }

    public String getIqiyiAccesstoken() {
        return TextUtils.isEmpty(getString(r)) ? "" : SapiDataEncryptor.decryptAccountInfo(getString(r), a());
    }

    public boolean getIsAlreadyShowExplainCamera() {
        return getBoolean(D, false);
    }

    public String getJoinQrLoginPrompt() {
        return getSapiOptions().t;
    }

    public List<SapiAccount> getLoginAccounts() {
        String str = null;
        if (!TextUtils.isEmpty(getString(p))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(p), a());
        } else if (!TextUtils.isEmpty(getString(f))) {
            str = getString(f);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, a());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(p, encryptAccountInfo);
                put(f, "");
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
        return getSapiOptions().p;
    }

    public long getLong(String str, long j2) {
        return this.f3233a.getLong(str, j2);
    }

    public boolean getModifiedDirExecPer() {
        return getBoolean(KEY_MODIFIED_DIR_EXEC_PER, false);
    }

    public String getOneKeyLoginJsCode() {
        return getString(A);
    }

    public String getOnekeyLoginJsMd5() {
        return getString(B);
    }

    public List<String> getOpenBdussDomains() {
        return getSapiOptions().l();
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        return getSapiOptions().n();
    }

    public String getPackageDirExecutePer() {
        return getString(KEY_PACKAGE_DIR_EXECUTE_PER);
    }

    public boolean getResetFileExecPer() {
        return getSapiOptions().s;
    }

    public String getRootStatus() {
        return getString(m);
    }

    public Map<String, String> getSCAuthorizedPackages() {
        return b().e();
    }

    public e getSapiOptions() {
        String string = getString(i);
        if (!TextUtils.isEmpty(string)) {
            try {
                return e.a(new JSONObject(string));
            } catch (JSONException e2) {
            }
        }
        return new e();
    }

    public String getSearchBoxSid() {
        return getString("sid");
    }

    public List<SapiAccount> getShareAccounts() {
        String str = null;
        if (!TextUtils.isEmpty(getString(o))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(o), a());
        } else if (!TextUtils.isEmpty(getString(e))) {
            str = getString(e);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, a());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(o, encryptAccountInfo);
                put(e, "");
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
        return getSapiOptions().o;
    }

    public int getShareInternalGray() {
        return getSapiOptions().r;
    }

    public JSONArray getShareStorage() {
        if (TextUtils.isEmpty(getString(u))) {
            return null;
        }
        try {
            return new JSONArray(SapiDataEncryptor.decryptAccountInfo(getString(u), a()));
        } catch (Exception e2) {
            return null;
        }
    }

    public String getString(String str) {
        return this.f3233a.getString(str, "");
    }

    public String getTid() {
        return getSapiOptions().v;
    }

    public List<SapiAccount> getTouchidAccounts() {
        String decryptAccountInfo = TextUtils.isEmpty(getString(y)) ? null : SapiDataEncryptor.decryptAccountInfo(getString(y), a());
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
        String string = getString(z);
        if (TextUtils.isEmpty(string)) {
            return new ArrayList(0);
        }
        return Arrays.asList(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
    }

    public String getV2FaceLivingUnames() {
        return getString(s);
    }

    public JSONObject getV2FaceLoginCheckResults() {
        String decryptStr = getDecryptStr(t);
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
        if (getBoolean(g, true)) {
            put(g, false);
            return true;
        }
        return false;
    }

    public boolean isHostsHijacked() {
        return getBoolean(k, false);
    }

    public boolean isLoginStatusChanged() {
        return getBoolean(h, false);
    }

    public boolean isMeetOneKeyLoginGray(int i2) {
        String str = "unkown";
        if (i2 == 1) {
            str = e.c.d;
        } else if (i2 == 2) {
            str = e.c.e;
        } else if (i2 == 3) {
            str = e.c.f;
        }
        return getSapiOptions().u.a(str).c;
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
        put(w, sb.toString().substring(0, sb.toString().length() - 1));
    }

    public void markAsDeleteShareLogin(String str) {
        String[] deleteShareLoginList = getDeleteShareLoginList();
        StringBuilder sb = new StringBuilder();
        for (int length = deleteShareLoginList.length + 1 > 10 ? (deleteShareLoginList.length + 1) - 10 : 0; length < deleteShareLoginList.length; length++) {
            sb.append(deleteShareLoginList[length]).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        sb.append(str);
        put(v, sb.toString());
    }

    public void put(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.f3233a.edit().putString(str, str2).apply();
        } else {
            this.f3233a.edit().putString(str, str2).commit();
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
            put(y, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), a()));
        }
    }

    public void resetSilentShareStatus() {
        put(h, false);
    }

    public void setAccountActionType(String str) {
        put("account_type", str);
    }

    public void setAppVersionCode(int i2) {
        put("app_version_code", i2);
    }

    public void setBaiduAppPkgList(String str) {
        put(E, str);
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            put(n, "");
            SapiUtils.webLogout(this.b);
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            put(n, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), a()));
            SapiUtils.webLogin(this.b, sapiAccount.bduss, sapiAccount.ptoken);
            if (!isLoginStatusChanged()) {
                c();
            }
        }
    }

    public void setHostsHijacked(boolean z2) {
        put(k, z2);
    }

    public void setIqiyiAccesstoken(String str) {
        if (TextUtils.isEmpty(str)) {
            put(r, "");
        } else {
            put(r, SapiDataEncryptor.encryptAccountInfo(str, a()));
        }
    }

    public void setIsAlreadyShowExplainCamera(boolean z2) {
        put(D, z2);
    }

    public void setModifiedDirExecPer(boolean z2) {
        put(KEY_MODIFIED_DIR_EXEC_PER, z2);
    }

    public void setOneKeyLoginJSCode(String str) {
        put(A, str);
    }

    public void setOnekeyLoginJsMd5(String str) {
        put(B, str);
    }

    public void setPackageDirExecutePer(String str) {
        put(KEY_PACKAGE_DIR_EXECUTE_PER, str);
    }

    public void setPkgSigns(e.d dVar) {
        if (dVar != null) {
            put(j, dVar.g());
        }
    }

    public void setRootStatus(String str) {
        put(m, str);
    }

    public void setSapiOptions(e eVar) {
        if (eVar != null) {
            put(i, eVar.q());
        }
    }

    public void setSearchBoxSid(String str) {
        put("sid", str);
    }

    public void setShareStorage(JSONArray jSONArray) {
        if (jSONArray == null) {
            put(u, "");
        } else {
            put(u, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), a()));
        }
    }

    public void setV2FaceLivingunames(String str) {
        put(s, str);
    }

    public void setV2FaceLoginCheckResults(String str) {
        putEncryptStr(t, str);
    }

    public boolean shareLivingunameEnable() {
        return getSapiOptions().n;
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

    public void removeShareAccount(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> shareAccounts = getShareAccounts();
            if (shareAccounts.contains(sapiAccount)) {
                shareAccounts.remove(sapiAccount);
                b(shareAccounts);
            }
        }
    }

    public void put(String str, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.f3233a.edit().putInt(str, i2).apply();
        } else {
            this.f3233a.edit().putInt(str, i2).commit();
        }
    }

    private e.d b() {
        String string = getString(j);
        if (!TextUtils.isEmpty(string)) {
            try {
                return e.d.a(new JSONObject(string));
            } catch (JSONException e2) {
            }
        }
        return new e.d();
    }

    private String a() {
        if (TextUtils.isEmpty(G)) {
            try {
                G = SecurityUtil.md5((this.b.getPackageName() + SapiUtils.getPackageSign(this.b, this.b.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return G;
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

    public void put(String str, long j2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.f3233a.edit().putLong(str, j2).apply();
        } else {
            this.f3233a.edit().putLong(str, j2).commit();
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

    public void put(String str, boolean z2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.f3233a.edit().putBoolean(str, z2).apply();
        } else {
            this.f3233a.edit().putBoolean(str, z2).commit();
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
            put(y, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), a()));
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
