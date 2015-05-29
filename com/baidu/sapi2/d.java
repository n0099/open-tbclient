package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.share.e;
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
public final class d {
    private static final int a = 5;
    private static final String b = "app_version_code";
    private static final String c = "sapi_version";
    private static final String d = "login_share_strategy";
    private static final String e = "current_account";
    private static final String f = "share_accounts";
    private static final String g = "login_accounts";
    private static final String h = "first_install";
    private static final String i = "login_status_changed";
    private static final String j = "voluntary_share_version";
    private static final String k = "sapi_options";
    private static final String l = "relogin_credentials";
    private static final String m = "cuidtoken";
    private static final String n = "device_token";
    private static final String o = "device_login_available";
    private static final String p = "hosts_hijacked";
    private static final String q = "stat_items";
    private static final String r = "sync_token";
    private static final String s = "sync_token_expired";
    private static final String t = "time_offset_seconds";
    private static final String u = "device_info_read_times";
    private static d x;
    private SharedPreferences v;
    private Context w;

    public static d a(Context context) {
        synchronized (d.class) {
            if (x == null) {
                x = new d(context.getApplicationContext());
            }
        }
        return x;
    }

    private d(Context context) {
        this.w = context;
        this.v = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.v.edit().putString(str, str2).apply();
        } else {
            this.v.edit().putString(str, str2).commit();
        }
    }

    private void a(String str, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.v.edit().putInt(str, i2).apply();
        } else {
            this.v.edit().putInt(str, i2).commit();
        }
    }

    private void a(String str, long j2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.v.edit().putLong(str, j2).apply();
        } else {
            this.v.edit().putLong(str, j2).commit();
        }
    }

    private void a(String str, boolean z) {
        if (Build.VERSION.SDK_INT > 8) {
            this.v.edit().putBoolean(str, z).apply();
        } else {
            this.v.edit().putBoolean(str, z).commit();
        }
    }

    private String g(String str) {
        return this.v.getString(str, "");
    }

    private boolean b(String str, boolean z) {
        return this.v.getBoolean(str, z);
    }

    private int b(String str, int i2) {
        return this.v.getInt(str, i2);
    }

    private long b(String str, long j2) {
        return this.v.getLong(str, j2);
    }

    public String a() {
        return g(n);
    }

    public void a(String str) {
        a(n, str);
    }

    public boolean b() {
        return b(o, false);
    }

    public void a(boolean z) {
        a(o, z);
    }

    public boolean c() {
        return b(p, false);
    }

    public void b(boolean z) {
        a(p, z);
    }

    public void b(String str) {
        a(c, str);
    }

    public void a(LoginShareStrategy loginShareStrategy) {
        if (loginShareStrategy != null) {
            a(d, loginShareStrategy.getStrValue());
        }
    }

    public void a(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            a(e, "");
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            a(e, jSONObject.toString());
            if (!h()) {
                B();
            }
        }
    }

    public SapiAccount d() {
        if (TextUtils.isEmpty(g(e))) {
            return null;
        }
        try {
            return SapiAccount.fromJSONObject(new JSONObject(g(e)));
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
                e2.remove(e2.indexOf(sapiAccount));
                e2.add(sapiAccount);
            }
            a(a(e2, 5));
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
                a((SapiAccount) null);
                com.baidu.sapi2.share.b.a().b(sapiAccount);
            }
            List<SapiAccount> f2 = f();
            if (f2.contains(sapiAccount)) {
                f2.remove(sapiAccount);
                b(f2);
            }
        }
    }

    public List<SapiAccount> e() {
        if (!TextUtils.isEmpty(g(f))) {
            try {
                return a(SapiAccount.fromJSONArray(new JSONArray(g(f))), 5);
            } catch (Throwable th) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public List<SapiAccount> f() {
        if (!TextUtils.isEmpty(g(g))) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(g(g)));
            } catch (Exception e2) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public boolean g() {
        if (b(h, true)) {
            a(h, false);
            return true;
        }
        return false;
    }

    public boolean h() {
        return b(i, false);
    }

    private void B() {
        a(i, true);
    }

    public void i() {
        a(i, false);
    }

    public int j() {
        return b(j, 0);
    }

    public void a(int i2) {
        a(j, i2);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(f, jSONArray.toString());
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(g, jSONArray.toString());
        }
    }

    public b k() {
        String g2 = g(k);
        if (!TextUtils.isEmpty(g2)) {
            try {
                return b.a(new JSONObject(g2));
            } catch (JSONException e2) {
            }
        }
        return new b();
    }

    public void a(b bVar) {
        if (bVar != null) {
            a(k, bVar.i());
        }
    }

    public Map<String, String> l() {
        return k().f();
    }

    public List<String> m() {
        return k().g();
    }

    public String n() {
        return k().a();
    }

    public Map<String, Integer> o() {
        return k().c();
    }

    public void a(String str, SapiAccount.ReloginCredentials reloginCredentials) {
        if (!TextUtils.isEmpty(str) && reloginCredentials != null && !TextUtils.isEmpty(reloginCredentials.account) && !TextUtils.isEmpty(reloginCredentials.password) && !TextUtils.isEmpty(reloginCredentials.ubi) && !TextUtils.isEmpty(reloginCredentials.accountType)) {
            d(reloginCredentials.ubi);
            JSONObject p2 = p();
            if (p2 == null) {
                p2 = new JSONObject();
            }
            try {
                p2.put(str, reloginCredentials.toJSONObject());
                a(l, p2.toString());
            } catch (JSONException e2) {
                L.e(e2);
            }
        }
    }

    public SapiAccount.ReloginCredentials c(String str) {
        JSONObject optJSONObject;
        JSONObject p2 = p();
        if (p2 == null || (optJSONObject = p2.optJSONObject(str)) == null) {
            return new SapiAccount.ReloginCredentials();
        }
        SapiAccount.ReloginCredentials fromJSONObject = SapiAccount.ReloginCredentials.fromJSONObject(optJSONObject);
        fromJSONObject.ubi = q();
        return fromJSONObject;
    }

    public JSONObject p() {
        String g2 = g(l);
        if (!TextUtils.isEmpty(g2)) {
            try {
                return new JSONObject(g2);
            } catch (JSONException e2) {
            }
        }
        return null;
    }

    void d(String str) {
        a(m, str);
    }

    String q() {
        return g(m);
    }

    public void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            try {
                Map<String, Map<String, String>> r2 = r();
                r2.put(str, map);
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Map<String, String>> entry : r2.entrySet()) {
                    jSONObject.put(entry.getKey(), new JSONObject(entry.getValue()));
                }
                a(q, jSONObject.toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Map<String, Map<String, String>> r2 = r();
                if (r2.containsKey(str)) {
                    r2.remove(str);
                }
                a(q, new JSONObject(r2).toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public Map<String, Map<String, String>> r() {
        HashMap hashMap = new HashMap();
        String g2 = g(q);
        if (!TextUtils.isEmpty(g2)) {
            try {
                JSONObject jSONObject = new JSONObject(g2);
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

    public void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            a(r, e.a(this.w, str));
        }
    }

    public JSONObject s() {
        String g2 = g(r);
        if (!TextUtils.isEmpty(g2)) {
            try {
                return new JSONObject(e.b(this.w, g2));
            } catch (Throwable th) {
                L.e(th);
            }
        }
        return null;
    }

    public String t() {
        if (s() != null) {
            return s().optString("sn");
        }
        return null;
    }

    public String u() {
        if (s() != null) {
            return s().optString("seed");
        }
        return null;
    }

    public String v() {
        if (s() != null) {
            return s().optString("pubkey");
        }
        return null;
    }

    public void c(boolean z) {
        a(s, z);
    }

    public boolean w() {
        return b(s, false);
    }

    public void b(int i2) {
        a(t, i2);
    }

    public int x() {
        return b(t, 0);
    }

    public long y() {
        return (System.currentTimeMillis() / 1000) + x();
    }

    public int z() {
        return b(b, 0);
    }

    public void c(int i2) {
        a(b, i2);
    }

    public long A() {
        long b2 = b(u, 0L) + 1;
        a(u, b2);
        return b2;
    }

    <T> List<T> a(List<T> list, int i2) {
        return (list == null || i2 < 0 || i2 >= list.size()) ? list : list.subList(list.size() - i2, list.size());
    }
}
