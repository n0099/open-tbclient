package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.common.SharedPreferencesUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
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
    public static SapiContext A = null;
    public static final String CHINA_TELECOM_EXPIRED_TIME = "china_telecom_expired_time";
    public static final String CHINA_UNICOM_EXPIRED_TIME = "china_unicom_expired_time";
    public static final String KEY_CONFIG_FILE_ETAG = "config_file_etag";
    public static final String KEY_CONTACTS_UID_VERSION = "contacts_uid_version";
    public static final String KEY_LAST_LOGIN_PHONE = "last_login_phone";
    public static final String KEY_LAST_LOGIN_UID = "last_login_uid";
    public static final String KEY_LAST_LOGIN_USER_PORTRAIT = "last_login_user_portrait";
    public static final String KEY_MODIFIED_DIR_EXEC_PER = "modified_dir_exec_per";
    public static final String KEY_OPEN_BDUSS_INFO = "open_bduss_info";
    public static final String KEY_PACKAGE_DIR_EXECUTE_PER = "package_dir_execute_per";
    public static final String KEY_PRE_LOGIN_TYPE = "pre_login_type";
    public static final String KEY_SHARE_DELETE_LIST = "share_delete_list";
    public static final String KEY_SHARE_INTERNAL_GRAY = "share_internal";
    public static final String KEY_SHARE_MODELS_FROM_CLOUD_CACHE = "key_share_models_cloud_cache";
    public static long KEY_SHARE_MODELS_FROM_CLOUD_TIME_SECOND = 0;
    public static final String KEY_SHARE_STORAGE = "share_storage";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10647c = "current_account";

    /* renamed from: d  reason: collision with root package name */
    public static final String f10648d = "login_accounts";

    /* renamed from: e  reason: collision with root package name */
    public static final String f10649e = "first_install";

    /* renamed from: f  reason: collision with root package name */
    public static final String f10650f = "sapi_options";

    /* renamed from: g  reason: collision with root package name */
    public static final String f10651g = "pkg_signs";

    /* renamed from: h  reason: collision with root package name */
    public static final String f10652h = "hosts_hijacked";
    public static final String i = "device_info_read_times";
    public static final String j = "root_status";
    public static final String k = "en_current_account";
    public static final String l = "en_login_accounts";
    public static final String m = "account_type";
    public static final String n = "face_livingunames";
    public static final String o = "v2_face_login_check_result";
    public static final String p = "face_login_delete_list";
    public static final String q = "touchid_accounts";
    public static final String r = "touchid_login_record";
    public static final String s = "one_key_login_js_code";
    public static final String t = "one_key_login_js_md5";
    public static final String u = "sid";
    public static final String v = "is_already_show_explain_camera";
    public static final String w = "current_baidu_app_list";
    public static final String x = "key_cancel_nuomi_addr_count";
    public static final int y = 5;
    public static String z;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f10653a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10654b;

    public SapiContext(Context context) {
        this.f10654b = context;
        this.f10653a = context.getSharedPreferences(SharedPreferencesUtil.f9734c, 0);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            put(l, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), getAccountEncryptKey()));
        }
    }

    private SapiOptions.c b() {
        String string = getString(f10651g);
        if (!TextUtils.isEmpty(string)) {
            try {
                return SapiOptions.c.a(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return new SapiOptions.c();
    }

    public static SapiContext getInstance() {
        synchronized (SapiContext.class) {
            if (A == null) {
                A = new SapiContext(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
            }
        }
        return A;
    }

    public void addLoginAccount(SapiAccount sapiAccount) {
        int i2;
        int i3;
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
        put(q, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), getAccountEncryptKey()));
    }

    public void addTouchidLoginRecord(String str) {
        String string = getString(r);
        if (TextUtils.isEmpty(string)) {
            put(r, str);
        } else if (string.contains(str)) {
        } else {
            put(r, string + "," + str);
        }
    }

    public String getAccountActionType() {
        return getString("account_type");
    }

    public String getAccountEncryptKey() {
        if (TextUtils.isEmpty(z)) {
            try {
                z = SecurityUtil.md5((this.f10654b.getPackageName() + SapiUtils.getPackageSign(this.f10654b, this.f10654b.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return z;
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
            return null;
        }
        return currentAccount;
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
        return getSapiOptions().a();
    }

    public Map<String, String> getAuthorizedPackages() {
        return b().a();
    }

    public List<String> getAuthorizedPackagesForUA() {
        return getSapiOptions().c();
    }

    public String getBaiduAppPkgList() {
        return getString(w);
    }

    public boolean getBoolean(String str, boolean z2) {
        return this.f10653a.getBoolean(str, z2);
    }

    public int getCancelNuomiAddrCount() {
        return getInt(a(), 0);
    }

    public String getContactsVersionByUid() {
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

    public List<String> getCuidAuthorizedDomains() {
        return getSapiOptions().getCuidAuthorizedDomains();
    }

    public synchronized SapiAccount getCurrentAccount() {
        String str;
        if (!TextUtils.isEmpty(getString(k))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(k), getAccountEncryptKey());
        } else if (TextUtils.isEmpty(getString(f10647c))) {
            str = null;
        } else {
            str = getString(f10647c);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, getAccountEncryptKey());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(k, encryptAccountInfo);
                put(f10647c, "");
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

    public String getDecryptStr(String str) {
        return SapiDataEncryptor.decryptAccountInfo(getString(str), getAccountEncryptKey());
    }

    public boolean getDefaultHttpsEnabled() {
        return getSapiOptions().getDefaultHttpsEnabled();
    }

    public String[] getDeleteFaceLoginList() {
        String string = getString(p);
        return TextUtils.isEmpty(string) ? new String[0] : string.split(",");
    }

    public String getDeviceInfo() {
        List<String> loginCookieDiKeys = getSapiOptions().getLoginCookieDiKeys();
        if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
            return SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        }
        return SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
    }

    public long getDeviceInfoReadTimes() {
        long j2 = getLong(i, 0L) + 1;
        put(i, j2);
        return j2;
    }

    public List<Integer> getDiExceptIndex() {
        return getSapiOptions().diExceptIndex;
    }

    public int getInt(String str, int i2) {
        return this.f10653a.getInt(str, i2);
    }

    public boolean getIsAlreadyShowExplainCamera() {
        return getBoolean(v, false);
    }

    public String getJoinQrLoginPrompt() {
        return getSapiOptions().joinQrLoginPrompt;
    }

    public List<SapiAccount> getLoginAccounts() {
        String str;
        if (!TextUtils.isEmpty(getString(l))) {
            str = SapiDataEncryptor.decryptAccountInfo(getString(l), getAccountEncryptKey());
        } else if (TextUtils.isEmpty(getString(f10648d))) {
            str = null;
        } else {
            String string = getString(f10648d);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(string, getAccountEncryptKey());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                put(l, encryptAccountInfo);
                put(f10648d, "");
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

    public int getLoginStatExtraLimitLen() {
        return getSapiOptions().loginStatExtraLimitLen;
    }

    public long getLong(String str, long j2) {
        return this.f10653a.getLong(str, j2);
    }

    public boolean getModifiedDirExecPer() {
        return getBoolean(KEY_MODIFIED_DIR_EXEC_PER, false);
    }

    public String getOneKeyLoginJsCode() {
        return getString(s);
    }

    public String getOnekeyLoginJsMd5() {
        return getString(t);
    }

    public List<String> getOpenBdussDomains() {
        return getSapiOptions().getOpenBdussDomains();
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        return getSapiOptions().d();
    }

    public String getPackageDirExecutePer() {
        return getString(KEY_PACKAGE_DIR_EXECUTE_PER);
    }

    public boolean getResetFileExecPer() {
        return getSapiOptions().resetFileExecPer;
    }

    public String getRootStatus() {
        return getString(j);
    }

    public Map<String, String> getSCAuthorizedPackages() {
        return b().d();
    }

    public SapiOptions getSapiOptions() {
        String string = getString(f10650f);
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

    public String getString(String str) {
        return this.f10653a.getString(str, "");
    }

    public String getTid() {
        return getSapiOptions().tid;
    }

    public List<SapiAccount> getTouchidAccounts() {
        String decryptAccountInfo = !TextUtils.isEmpty(getString(q)) ? SapiDataEncryptor.decryptAccountInfo(getString(q), getAccountEncryptKey()) : null;
        if (!TextUtils.isEmpty(decryptAccountInfo)) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(decryptAccountInfo));
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public List<String> getTouchidLoginRecord() {
        String string = getString(r);
        if (TextUtils.isEmpty(string)) {
            return new ArrayList(0);
        }
        return Arrays.asList(string.split(","));
    }

    public String getV2FaceLivingUnames() {
        return getString(n);
    }

    public JSONObject getV2FaceLoginCheckResults() {
        String decryptStr = getDecryptStr(o);
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

    public boolean isFirstLaunch() {
        if (getBoolean(f10649e, true)) {
            put(f10649e, false);
            return true;
        }
        return false;
    }

    public boolean isHostsHijacked() {
        return getBoolean(f10652h, false);
    }

    public boolean isMeetOneKeyLoginGray(int i2) {
        return getSapiOptions().gray.getGrayModuleByFunName(i2 != 1 ? i2 != 2 ? i2 != 3 ? "unkown" : SapiOptions.Gray.FUN_NAME_CHINA_TELECOM_OAUTH : SapiOptions.Gray.FUN_NAME_CHINA_UNICOM_OAUTH : SapiOptions.Gray.FUN_NAME_CHINA_MOBILE_OAUTH).f10806c;
    }

    public void markAsDeleteFaceLogin(JSONArray jSONArray) {
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
        put(p, sb.toString().substring(0, sb.toString().length() - 1));
    }

    public void put(String str, String str2) {
        this.f10653a.edit().putString(str, str2).apply();
    }

    public void putEncryptStr(String str, String str2) {
        put(str, SapiDataEncryptor.encryptAccountInfo(str2, getAccountEncryptKey()));
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
                a(loginAccounts);
                return;
            }
        }
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
            a(loginAccounts);
        }
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
        put(q, SapiDataEncryptor.encryptAccountInfo(SapiAccount.toJSONArray(touchidAccounts).toString(), getAccountEncryptKey()));
    }

    public void setAccountActionType(String str) {
        put("account_type", str);
    }

    public void setBaiduAppPkgList(String str) {
        put(w, str);
    }

    public void setCancelNuomiAddrCount(int i2) {
        put(a(), i2);
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            put(k, "");
            SapiUtils.webLogout(this.f10654b);
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            put(k, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), getAccountEncryptKey()));
            SapiUtils.webLogin(this.f10654b, sapiAccount.bduss, sapiAccount.ptoken);
        }
    }

    public void setHostsHijacked(boolean z2) {
        put(f10652h, z2);
    }

    public void setIsAlreadyShowExplainCamera(boolean z2) {
        put(v, z2);
    }

    public void setModifiedDirExecPer(boolean z2) {
        put(KEY_MODIFIED_DIR_EXEC_PER, z2);
    }

    public void setOneKeyLoginJSCode(String str) {
        put(s, str);
    }

    public void setOnekeyLoginJsMd5(String str) {
        put(t, str);
    }

    public void setPackageDirExecutePer(String str) {
        put(KEY_PACKAGE_DIR_EXECUTE_PER, str);
    }

    public void setPkgSigns(SapiOptions.c cVar) {
        if (cVar != null) {
            put(f10651g, cVar.e());
        }
    }

    public void setRootStatus(String str) {
        put(j, str);
    }

    public void setSapiOptions(SapiOptions sapiOptions) {
        if (sapiOptions != null) {
            put(f10650f, sapiOptions.toJSON());
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
        put(n, str);
    }

    public void setV2FaceLoginCheckResults(String str) {
        putEncryptStr(o, str);
    }

    public boolean shareLivingunameEnable() {
        return getSapiOptions().shareLivingunameEnabled;
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
        } catch (JSONException e2) {
            Log.e(e2);
        }
        put(KEY_CONTACTS_UID_VERSION, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), getAccountEncryptKey()));
    }

    public void put(String str, int i2) {
        this.f10653a.edit().putInt(str, i2).apply();
    }

    public void put(String str, long j2) {
        this.f10653a.edit().putLong(str, j2).apply();
    }

    public void put(String str, boolean z2) {
        this.f10653a.edit().putBoolean(str, z2).apply();
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        SapiAccount currentAccount = getCurrentAccount();
        if (currentAccount != null) {
            sb.append("_");
            sb.append(currentAccount.uid);
        }
        return sb.toString();
    }
}
