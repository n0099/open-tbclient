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
    private static final String j = "sapi_options";
    private static final String k = "relogin_credentials";
    private static final String l = "cuidtoken";
    private static final String m = "device_token";
    private static final String n = "device_login_available";
    private static final String o = "hosts_hijacked";
    private static final String p = "stat_items";
    private static final String q = "sync_token";
    private static final String r = "sync_token_expired";
    private static final String s = "time_offset_seconds";
    private static final String t = "device_info_read_times";
    private static d w;
    private SharedPreferences u;
    private Context v;

    public static d a(Context context) {
        synchronized (d.class) {
            if (w == null) {
                w = new d(context.getApplicationContext());
            }
        }
        return w;
    }

    private d(Context context) {
        this.v = context;
        this.u = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.u.edit().putString(str, str2).apply();
        } else {
            this.u.edit().putString(str, str2).commit();
        }
    }

    private void a(String str, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.u.edit().putInt(str, i2).apply();
        } else {
            this.u.edit().putInt(str, i2).commit();
        }
    }

    private void a(String str, long j2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.u.edit().putLong(str, j2).apply();
        } else {
            this.u.edit().putLong(str, j2).commit();
        }
    }

    private void a(String str, boolean z) {
        if (Build.VERSION.SDK_INT > 8) {
            this.u.edit().putBoolean(str, z).apply();
        } else {
            this.u.edit().putBoolean(str, z).commit();
        }
    }

    private String g(String str) {
        return this.u.getString(str, "");
    }

    private boolean b(String str, boolean z) {
        return this.u.getBoolean(str, z);
    }

    private int b(String str, int i2) {
        return this.u.getInt(str, i2);
    }

    private long b(String str, long j2) {
        return this.u.getLong(str, j2);
    }

    public String a() {
        return g(m);
    }

    public void a(String str) {
        a(m, str);
    }

    public boolean b() {
        return b(n, false);
    }

    public void a(boolean z) {
        a(n, z);
    }

    public boolean c() {
        return b(o, false);
    }

    public void b(boolean z) {
        a(o, z);
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
                z();
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

    private void z() {
        a(i, true);
    }

    public void i() {
        a(i, false);
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

    public c j() {
        String g2 = g(j);
        if (!TextUtils.isEmpty(g2)) {
            try {
                return c.a(new JSONObject(g2));
            } catch (JSONException e2) {
            }
        }
        return new c();
    }

    public void a(c cVar) {
        if (cVar != null) {
            a(j, cVar.h());
        }
    }

    public Map<String, String> k() {
        return j().e();
    }

    public List<String> l() {
        return j().f();
    }

    public String m() {
        return j().a();
    }

    public void a(String str, SapiAccount.ReloginCredentials reloginCredentials) {
        if (!TextUtils.isEmpty(str) && reloginCredentials != null && !TextUtils.isEmpty(reloginCredentials.account) && !TextUtils.isEmpty(reloginCredentials.password) && !TextUtils.isEmpty(reloginCredentials.ubi) && !TextUtils.isEmpty(reloginCredentials.accountType)) {
            d(reloginCredentials.ubi);
            JSONObject n2 = n();
            if (n2 == null) {
                n2 = new JSONObject();
            }
            try {
                n2.put(str, reloginCredentials.toJSONObject());
                a(k, n2.toString());
            } catch (JSONException e2) {
                L.e(e2);
            }
        }
    }

    public SapiAccount.ReloginCredentials c(String str) {
        JSONObject optJSONObject;
        JSONObject n2 = n();
        if (n2 == null || (optJSONObject = n2.optJSONObject(str)) == null) {
            return new SapiAccount.ReloginCredentials();
        }
        SapiAccount.ReloginCredentials fromJSONObject = SapiAccount.ReloginCredentials.fromJSONObject(optJSONObject);
        fromJSONObject.ubi = o();
        return fromJSONObject;
    }

    public JSONObject n() {
        String g2 = g(k);
        if (!TextUtils.isEmpty(g2)) {
            try {
                return new JSONObject(g2);
            } catch (JSONException e2) {
            }
        }
        return null;
    }

    void d(String str) {
        a(l, str);
    }

    String o() {
        return g(l);
    }

    public void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            try {
                Map<String, Map<String, String>> p2 = p();
                p2.put(str, map);
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Map<String, String>> entry : p2.entrySet()) {
                    jSONObject.put(entry.getKey(), new JSONObject(entry.getValue()));
                }
                a(p, jSONObject.toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Map<String, Map<String, String>> p2 = p();
                if (p2.containsKey(str)) {
                    p2.remove(str);
                }
                a(p, new JSONObject(p2).toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public Map<String, Map<String, String>> p() {
        HashMap hashMap = new HashMap();
        String g2 = g(p);
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
            a(q, e.a(this.v, str));
        }
    }

    public JSONObject q() {
        String g2 = g(q);
        if (!TextUtils.isEmpty(g2)) {
            try {
                return new JSONObject(e.b(this.v, g2));
            } catch (Throwable th) {
                L.e(th);
            }
        }
        return null;
    }

    public String r() {
        if (q() != null) {
            return q().optString("sn");
        }
        return null;
    }

    public String s() {
        if (q() != null) {
            return q().optString("seed");
        }
        return null;
    }

    public String t() {
        if (q() != null) {
            return q().optString("pubkey");
        }
        return null;
    }

    public void c(boolean z) {
        a(r, z);
    }

    public boolean u() {
        return b(r, false);
    }

    public void a(int i2) {
        a(s, i2);
    }

    public int v() {
        return b(s, 0);
    }

    public long w() {
        return (System.currentTimeMillis() / 1000) + v();
    }

    public int x() {
        return b(b, 0);
    }

    public void b(int i2) {
        a(b, i2);
    }

    public long y() {
        long b2 = b(t, 0L) + 1;
        a(t, b2);
        return b2;
    }

    <T> List<T> a(List<T> list, int i2) {
        return (list == null || i2 < 0 || i2 >= list.size()) ? list : list.subList(list.size() - i2, list.size());
    }
}
