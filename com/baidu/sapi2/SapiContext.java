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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiContext {
    private static String B = null;
    private static SapiContext C = null;
    public static final int MAX_SHARE_ACCOUNTS = 5;
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
    private static final String l = "stat_items";
    private static final String m = "time_offset_seconds";
    private static final String n = "device_info_read_times";
    private static final String o = "root_status";
    private static final String p = "en_current_account";
    private static final String q = "en_share_accounts";
    private static final String r = "en_login_accounts";
    private static final String s = "en_relogin_credentials";
    private static final String t = "pi_g_p";
    private static final String u = "en_sofire_zid_inited";
    private static final String v = "account_type";
    private static final String w = "iqiyi_token";
    private static final String x = "face_login_uid";
    private static final String y = "face_login_hash_json";
    private Context A;
    private SharedPreferences z;

    public static SapiContext getInstance(Context context) {
        synchronized (SapiContext.class) {
            if (C == null) {
                C = new SapiContext(context.getApplicationContext());
            }
        }
        return C;
    }

    private SapiContext(Context context) {
        this.A = context;
        this.z = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.z.edit().putString(str, str2).apply();
        } else {
            this.z.edit().putString(str, str2).commit();
        }
    }

    private void a(String str, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.z.edit().putInt(str, i2).apply();
        } else {
            this.z.edit().putInt(str, i2).commit();
        }
    }

    private void a(String str, long j2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.z.edit().putLong(str, j2).apply();
        } else {
            this.z.edit().putLong(str, j2).commit();
        }
    }

    private void a(String str, boolean z) {
        if (Build.VERSION.SDK_INT > 8) {
            this.z.edit().putBoolean(str, z).apply();
        } else {
            this.z.edit().putBoolean(str, z).commit();
        }
    }

    private String c(String str) {
        return this.z.getString(str, "");
    }

    private boolean b(String str, boolean z) {
        return this.z.getBoolean(str, z);
    }

    private int b(String str, int i2) {
        return this.z.getInt(str, i2);
    }

    private long b(String str, long j2) {
        return this.z.getLong(str, j2);
    }

    public boolean isHostsHijacked() {
        return b(k, false);
    }

    public void setHostsHijacked(boolean z) {
        a(k, z);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.z.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.z.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void setCurrentAccount(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            a(p, "");
            SapiUtils.webLogout(this.A);
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            a(p, SapiDataEncryptor.encryptAccountInfo(jSONObject.toString(), c()));
            SapiUtils.webLogin(this.A, sapiAccount.bduss, sapiAccount.ptoken);
            if (!isLoginStatusChanged()) {
                b();
            }
        }
    }

    public synchronized SapiAccount getCurrentAccount() {
        String str;
        SapiAccount sapiAccount = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(c(p))) {
                str = SapiDataEncryptor.decryptAccountInfo(c(p), c());
            } else if (TextUtils.isEmpty(c(b))) {
                str = null;
            } else {
                str = c(b);
                String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
                if (!TextUtils.isEmpty(encryptAccountInfo)) {
                    a(p, encryptAccountInfo);
                    a(b, "");
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
            a(a(shareAccounts, 5));
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
        if (!TextUtils.isEmpty(c(q))) {
            str = SapiDataEncryptor.decryptAccountInfo(c(q), c());
        } else if (!TextUtils.isEmpty(c(c))) {
            str = c(c);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                a(q, encryptAccountInfo);
                a(c, "");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return a(SapiAccount.fromJSONArray(new JSONArray(str)), 5);
            } catch (Throwable th) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public List<SapiAccount> getLoginAccounts() {
        String str = null;
        if (!TextUtils.isEmpty(c(r))) {
            str = SapiDataEncryptor.decryptAccountInfo(c(r), c());
        } else if (!TextUtils.isEmpty(c(d))) {
            str = c(d);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                a(r, encryptAccountInfo);
                a(d, "");
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
        if (!TextUtils.isEmpty(c(t))) {
            String decryptAccountInfo = SapiDataEncryptor.decryptAccountInfo(c(t), c());
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

    /* JADX INFO: Access modifiers changed from: protected */
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
        if (b(e, true)) {
            a(e, false);
            return true;
        }
        return false;
    }

    public boolean isLoginStatusChanged() {
        return b(f, false);
    }

    private void b() {
        a(f, true);
    }

    public void resetSilentShareStatus() {
        a(f, false);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(q, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), c()));
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(r, SapiDataEncryptor.encryptAccountInfo(jSONArray.toString(), c()));
        }
    }

    public void setGrayPlugin(List<b.a> list) {
        JSONArray a2 = b.a.a(list);
        if (a2 != null) {
            a(t, SapiDataEncryptor.encryptAccountInfo(a2.toString(), c()));
        }
    }

    public void setSofireZidInited(boolean z) {
        a(u, z);
    }

    public boolean getSofireZidInited() {
        return b(u, false);
    }

    public SapiOptions getSapiOptions() {
        String c2 = c(g);
        if (!TextUtils.isEmpty(c2)) {
            try {
                return SapiOptions.fromJSON(new JSONObject(c2));
            } catch (JSONException e2) {
            }
        }
        return new SapiOptions();
    }

    public void setSapiOptions(SapiOptions sapiOptions) {
        if (sapiOptions != null) {
            a(g, sapiOptions.toJSON());
        }
    }

    public Map<String, String> getPluginsSuffix() {
        return getSapiOptions().getPluginsSuffix();
    }

    public Map<String, String> getAuthorizedPackages() {
        return getSapiOptions().getAuthorizedPackages();
    }

    public List<String> getAuthorizedDomains() {
        return getSapiOptions().getAuthorizedDomains();
    }

    public List<String> getAuthorizedDomainsForPtoken() {
        return getSapiOptions().d();
    }

    public String getFastRegChannel() {
        return getSapiOptions().getFastRegSmsNum();
    }

    public Map<String, Integer> getOrderAuthorizedPackages() {
        return getSapiOptions().b();
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
                a(s, SapiDataEncryptor.encryptAccountInfo(reloginCredentials2.toString(), c()));
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
        if (!TextUtils.isEmpty(c(s))) {
            str = SapiDataEncryptor.decryptAccountInfo(c(s), c());
        } else if (TextUtils.isEmpty(c(h))) {
            str = null;
        } else {
            str = c(h);
            String encryptAccountInfo = SapiDataEncryptor.encryptAccountInfo(str, c());
            if (!TextUtils.isEmpty(encryptAccountInfo)) {
                a(s, encryptAccountInfo);
                a(h, "");
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
        a("account_type", str);
    }

    public String getAccountActionType() {
        return c("account_type");
    }

    public void setIqiyiAccesstoken(String str) {
        if (TextUtils.isEmpty(str)) {
            a(w, "");
        } else {
            a(w, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public String getIqiyiAccesstoken() {
        return TextUtils.isEmpty(c(w)) ? "" : SapiDataEncryptor.decryptAccountInfo(c(w), c());
    }

    void b(String str) {
        a(i, str);
    }

    String a() {
        return c(i);
    }

    public void addStatItem(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            try {
                Map<String, Map<String, String>> statItems = getStatItems();
                statItems.put(str, map);
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Map<String, String>> entry : statItems.entrySet()) {
                    jSONObject.put(entry.getKey(), new JSONObject(entry.getValue()));
                }
                a(l, jSONObject.toString());
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public void removeStatItem(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Map<String, Map<String, String>> statItems = getStatItems();
                if (statItems.containsKey(str)) {
                    statItems.remove(str);
                }
                a(l, new JSONObject(statItems).toString());
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public Map<String, Map<String, String>> getStatItems() {
        HashMap hashMap = new HashMap();
        String c2 = c(l);
        if (!TextUtils.isEmpty(c2)) {
            try {
                JSONObject jSONObject = new JSONObject(c2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    HashMap hashMap2 = new HashMap();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null) {
                        Iterator<String> keys2 = optJSONObject.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            String optString = optJSONObject.optString(next2);
                            if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(optString)) {
                                hashMap2.put(next2, optString);
                            }
                        }
                    }
                    hashMap.put(next, hashMap2);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
        return hashMap;
    }

    public int getTimeOffsetSeconds() {
        return b(m, 0);
    }

    public long getSyncTime() {
        return (System.currentTimeMillis() / 1000) + getTimeOffsetSeconds();
    }

    public int getAppVersionCode() {
        return b("app_version_code", 0);
    }

    public void setAppVersionCode(int i2) {
        a("app_version_code", i2);
    }

    public long getDeviceInfoReadTimes() {
        long b2 = b(n, 0L) + 1;
        a(n, b2);
        return b2;
    }

    private String c() {
        if (TextUtils.isEmpty(B)) {
            try {
                B = EncodeUtils.toMd5((this.A.getPackageName() + SapiUtils.getPackageSign(this.A, this.A.getPackageName())).getBytes("UTF-8")).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        return B;
    }

    public void setRootStatus(String str) {
        a(o, str);
    }

    public String getRootStatus() {
        return c(o);
    }

    <T> List<T> a(List<T> list, int i2) {
        return (list == null || i2 < 0 || i2 >= list.size()) ? list : list.subList(list.size() - i2, list.size());
    }

    public String getFaceLoginHash() {
        String faceLoginContainHashJson = getFaceLoginContainHashJson();
        if (TextUtils.isEmpty(faceLoginContainHashJson)) {
            return "";
        }
        try {
            return new JSONObject(faceLoginContainHashJson).optString("type");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getFaceLoginContainHashJson() {
        return TextUtils.isEmpty(c(y)) ? "" : SapiDataEncryptor.decryptAccountInfo(c(y), c());
    }

    public void setFaceLoginContainHashJson(String str) {
        if (TextUtils.isEmpty(str)) {
            a(y, "");
        } else {
            a(y, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
    }

    public String getFaceLoginUid() {
        return TextUtils.isEmpty(c(x)) ? "" : SapiDataEncryptor.decryptAccountInfo(c(x), c());
    }

    public void setFaceLoginUid(String str) {
        setFaceLoginContainHashJson("");
        if (TextUtils.isEmpty(str)) {
            a(x, "");
        } else {
            a(x, SapiDataEncryptor.encryptAccountInfo(str, c()));
        }
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
}
