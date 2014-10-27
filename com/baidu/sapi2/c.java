package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
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
public final class c {
    private static final String a = "sapi_version";
    private static final String b = "login_share_strategy";
    private static final String c = "current_account";
    private static final String d = "share_accounts";
    private static final String e = "login_accounts";
    private static final String f = "first_install";
    private static final String g = "login_status_changed";
    private static final String h = "voluntary_share_version";
    private static final String i = "sapi_options";
    private static final String j = "relogin_credentials";
    private static final String k = "cuidtoken";
    private static final String l = "device_token";
    private static final String m = "device_login_available";
    private static final String n = "hosts_hijacked";
    private static final String o = "stat_items";
    private static c q;
    private SharedPreferences p;

    public static c a(Context context) {
        synchronized (c.class) {
            if (q == null) {
                q = new c(context.getApplicationContext());
            }
        }
        return q;
    }

    private c(Context context) {
        this.p = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.p.edit().putString(str, str2).apply();
        } else {
            this.p.edit().putString(str, str2).commit();
        }
    }

    private void a(String str, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.p.edit().putInt(str, i2).apply();
        } else {
            this.p.edit().putInt(str, i2).commit();
        }
    }

    private void a(String str, boolean z) {
        if (Build.VERSION.SDK_INT > 8) {
            this.p.edit().putBoolean(str, z).apply();
        } else {
            this.p.edit().putBoolean(str, z).commit();
        }
    }

    private String f(String str) {
        return this.p.getString(str, "");
    }

    private boolean b(String str, boolean z) {
        return this.p.getBoolean(str, z);
    }

    private int b(String str, int i2) {
        return this.p.getInt(str, i2);
    }

    public String a() {
        return f(l);
    }

    public void a(String str) {
        a(l, str);
    }

    public boolean b() {
        return b(m, false);
    }

    public void a(boolean z) {
        a(m, z);
    }

    public boolean c() {
        return b(n, false);
    }

    public void b(boolean z) {
        a(n, z);
    }

    public void b(String str) {
        a(a, str);
    }

    public void a(LoginShareStrategy loginShareStrategy) {
        if (loginShareStrategy != null) {
            a(b, loginShareStrategy.getStrValue());
        }
    }

    public void a(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            a(c, "");
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            a(c, jSONObject.toString());
            if (!h()) {
                n();
            }
        }
    }

    public SapiAccount d() {
        if (TextUtils.isEmpty(f(c))) {
            return null;
        }
        try {
            return SapiAccount.fromJSONObject(new JSONObject(f(c)));
        } catch (JSONException e2) {
            return null;
        }
    }

    public void b(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> e2 = e();
            if (!e2.contains(sapiAccount)) {
                e2.add(sapiAccount);
            } else {
                e2.set(e2.indexOf(sapiAccount), sapiAccount);
            }
            a(e2);
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> f2 = f();
            if (!f2.contains(sapiAccount)) {
                f2.add(sapiAccount);
            } else {
                f2.set(f2.indexOf(sapiAccount), sapiAccount);
            }
            b(f2);
        }
    }

    public void d(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> e2 = e();
            if (e2.contains(sapiAccount)) {
                e2.remove(sapiAccount);
                a(e2);
            }
        }
    }

    public void e(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            if (d() != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(d().uid)) {
                com.baidu.sapi2.share.c.a().b();
            }
            List<SapiAccount> f2 = f();
            if (f2.contains(sapiAccount)) {
                f2.remove(sapiAccount);
                b(f2);
            }
        }
    }

    public List<SapiAccount> e() {
        if (!TextUtils.isEmpty(f(d))) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(f(d)));
            } catch (Throwable th) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public List<SapiAccount> f() {
        if (!TextUtils.isEmpty(f(e))) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(f(e)));
            } catch (Exception e2) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public boolean g() {
        if (b(f, true)) {
            a(f, false);
            return true;
        }
        return false;
    }

    public boolean h() {
        return b(g, false);
    }

    private void n() {
        a(g, true);
    }

    public int i() {
        return b(h, 0);
    }

    public void a(int i2) {
        a(h, i2);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(d, jSONArray.toString());
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(e, jSONArray.toString());
        }
    }

    public b j() {
        String f2 = f(i);
        if (!TextUtils.isEmpty(f2)) {
            try {
                return b.a(new JSONObject(f2));
            } catch (JSONException e2) {
            }
        }
        return new b();
    }

    public void a(b bVar) {
        if (bVar != null) {
            a(i, bVar.i());
        }
    }

    public void a(String str, SapiAccount.ReloginCredentials reloginCredentials) {
        if (!TextUtils.isEmpty(str) && reloginCredentials != null && !TextUtils.isEmpty(reloginCredentials.account) && !TextUtils.isEmpty(reloginCredentials.password) && !TextUtils.isEmpty(reloginCredentials.ubi) && !TextUtils.isEmpty(reloginCredentials.accountType)) {
            d(reloginCredentials.ubi);
            JSONObject k2 = k();
            if (k2 == null) {
                k2 = new JSONObject();
            }
            try {
                k2.put(str, reloginCredentials.toJSONObject());
                a(j, k2.toString());
            } catch (JSONException e2) {
                L.e(e2);
            }
        }
    }

    public SapiAccount.ReloginCredentials c(String str) {
        JSONObject optJSONObject;
        JSONObject k2 = k();
        if (k2 == null || (optJSONObject = k2.optJSONObject(str)) == null) {
            return new SapiAccount.ReloginCredentials();
        }
        SapiAccount.ReloginCredentials fromJSONObject = SapiAccount.ReloginCredentials.fromJSONObject(optJSONObject);
        fromJSONObject.ubi = l();
        return fromJSONObject;
    }

    public JSONObject k() {
        String f2 = f(j);
        if (!TextUtils.isEmpty(f2)) {
            try {
                return new JSONObject(f2);
            } catch (JSONException e2) {
            }
        }
        return null;
    }

    void d(String str) {
        a(k, str);
    }

    String l() {
        return f(k);
    }

    public void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            try {
                Map<String, Map<String, String>> m2 = m();
                m2.put(str, map);
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Map<String, String>> entry : m2.entrySet()) {
                    jSONObject.put(entry.getKey(), new JSONObject(entry.getValue()));
                }
                a(o, jSONObject.toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Map<String, Map<String, String>> m2 = m();
                if (m2.containsKey(str)) {
                    m2.remove(str);
                }
                a(o, new JSONObject(m2).toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public Map<String, Map<String, String>> m() {
        HashMap hashMap = new HashMap();
        String f2 = f(o);
        if (!TextUtils.isEmpty(f2)) {
            try {
                JSONObject jSONObject = new JSONObject(f2);
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
                L.e(th);
            }
        }
        return hashMap;
    }
}
