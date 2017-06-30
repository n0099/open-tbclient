package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.utils.L;
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
public final class c {
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
    private static final String k = "device_login_available";
    private static final String l = "hosts_hijacked";
    private static final String m = "stat_items";
    private static final String n = "time_offset_seconds";
    private static final String o = "device_info_read_times";
    private static final String p = "root_status";
    private static final String q = "config_url_request_failed_times";
    private static final String r = "en_current_account";
    private static final String s = "en_share_accounts";
    private static final String t = "en_login_accounts";
    private static final String u = "en_relogin_credentials";
    private static final String v = "en_sofire_factor";
    private static String y;
    private static c z;
    private SharedPreferences w;
    private Context x;

    public static c a(Context context) {
        synchronized (c.class) {
            if (z == null) {
                z = new c(context.getApplicationContext());
            }
        }
        return z;
    }

    private c(Context context) {
        this.x = context;
        this.w = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.w.edit().putString(str, str2).apply();
        } else {
            this.w.edit().putString(str, str2).commit();
        }
    }

    private void a(String str, int i2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.w.edit().putInt(str, i2).apply();
        } else {
            this.w.edit().putInt(str, i2).commit();
        }
    }

    private void a(String str, long j2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.w.edit().putLong(str, j2).apply();
        } else {
            this.w.edit().putLong(str, j2).commit();
        }
    }

    private void a(String str, boolean z2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.w.edit().putBoolean(str, z2).apply();
        } else {
            this.w.edit().putBoolean(str, z2).commit();
        }
    }

    private String i(String str) {
        return this.w.getString(str, "");
    }

    private boolean b(String str, boolean z2) {
        return this.w.getBoolean(str, z2);
    }

    private int b(String str, int i2) {
        return this.w.getInt(str, i2);
    }

    private long b(String str, long j2) {
        return this.w.getLong(str, j2);
    }

    public String a() {
        return i(j);
    }

    public void a(String str) {
        a(j, str);
    }

    public boolean b() {
        return b(k, false);
    }

    public void a(boolean z2) {
        a(k, z2);
    }

    public boolean c() {
        return b(l, false);
    }

    public void b(boolean z2) {
        a(l, z2);
    }

    public void a(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            a(r, "");
            SapiUtils.webLogout(this.x);
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            a(r, SapiDataEncryptor.e(jSONObject.toString(), B()));
            SapiUtils.webLogin(this.x, sapiAccount.bduss, sapiAccount.k);
            if (!h()) {
                A();
            }
        }
    }

    public synchronized SapiAccount d() {
        String str;
        SapiAccount sapiAccount = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(i(r))) {
                str = SapiDataEncryptor.d(i(r), B());
            } else if (TextUtils.isEmpty(i(b))) {
                str = null;
            } else {
                str = i(b);
                String e2 = SapiDataEncryptor.e(str, B());
                if (!TextUtils.isEmpty(e2)) {
                    a(r, e2);
                    a(b, "");
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    sapiAccount = SapiAccount.fromJSONObject(new JSONObject(str));
                } catch (JSONException e3) {
                }
            }
        }
        return sapiAccount;
    }

    public void a(SapiAccount sapiAccount, boolean z2) {
        List<String> i2 = a(this.x).k().i();
        if (sapiAccount != null && i2 != null && !i2.isEmpty() && !SapiAccountManager.getInstance().getAccountService().a(sapiAccount, i2)) {
            SapiAccountManager.getInstance().getAccountService().a(new GetTplStokenCallback() { // from class: com.baidu.sapi2.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: a */
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            }, sapiAccount.bduss, i2, z2);
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
            SapiAccount d2 = d();
            if (d2 != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(d2.uid)) {
                a((SapiAccount) null);
                com.baidu.sapi2.share.a.a().b(sapiAccount);
                if (SapiAccountManager.getGlobalAuthorizationListener() != null) {
                    try {
                        SapiAccountManager.getGlobalAuthorizationListener().onLogoutSuccess(sapiAccount);
                    } catch (Throwable th) {
                        L.e(th);
                    }
                }
            }
            List<SapiAccount> f2 = f();
            if (f2.contains(sapiAccount)) {
                f2.remove(sapiAccount);
                b(f2);
            }
        }
    }

    public List<SapiAccount> e() {
        String str = null;
        if (!TextUtils.isEmpty(i(s))) {
            str = SapiDataEncryptor.d(i(s), B());
        } else if (!TextUtils.isEmpty(i(c))) {
            str = i(c);
            String e2 = SapiDataEncryptor.e(str, B());
            if (!TextUtils.isEmpty(e2)) {
                a(s, e2);
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

    public List<SapiAccount> f() {
        String str = null;
        if (!TextUtils.isEmpty(i(t))) {
            str = SapiDataEncryptor.d(i(t), B());
        } else if (!TextUtils.isEmpty(i(d))) {
            str = i(d);
            String e2 = SapiDataEncryptor.e(str, B());
            if (!TextUtils.isEmpty(e2)) {
                a(t, e2);
                a(d, "");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(str));
            } catch (Exception e3) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccount b(String str) {
        if (str == null) {
            return null;
        }
        SapiAccount d2 = d();
        if (d2 == null || !str.equals(d2.bduss)) {
            for (SapiAccount sapiAccount : f()) {
                if (str.equals(sapiAccount.bduss)) {
                    return sapiAccount;
                }
            }
            for (SapiAccount sapiAccount2 : e()) {
                if (str.equals(sapiAccount2.bduss)) {
                    return sapiAccount2;
                }
            }
            return null;
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccount c(String str) {
        if (str == null) {
            return null;
        }
        SapiAccount d2 = d();
        if (d2 == null || !str.equals(d2.getReloginCredentials().ubi)) {
            for (SapiAccount sapiAccount : f()) {
                if (str.equals(sapiAccount.getReloginCredentials().ubi)) {
                    return sapiAccount;
                }
            }
            for (SapiAccount sapiAccount2 : e()) {
                if (str.equals(sapiAccount2.getReloginCredentials().ubi)) {
                    return sapiAccount2;
                }
            }
            return null;
        }
        return d2;
    }

    public boolean g() {
        if (b(e, true)) {
            a(e, false);
            return true;
        }
        return false;
    }

    public boolean h() {
        return b(f, false);
    }

    private void A() {
        a(f, true);
    }

    public void i() {
        a(f, false);
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(s, SapiDataEncryptor.e(jSONArray.toString(), B()));
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(t, SapiDataEncryptor.e(jSONArray.toString(), B()));
        }
    }

    public void d(String str) {
        a(v, SapiDataEncryptor.e(str, B()));
    }

    public String j() {
        if (TextUtils.isEmpty(i(v))) {
            return null;
        }
        return SapiDataEncryptor.d(i(v), B());
    }

    public d k() {
        String i2 = i(g);
        if (!TextUtils.isEmpty(i2)) {
            try {
                return d.a(new JSONObject(i2));
            } catch (JSONException e2) {
            }
        }
        return new d();
    }

    public void a(d dVar) {
        if (dVar != null) {
            a(g, dVar.k());
        }
    }

    public Map<String, String> l() {
        return k().f();
    }

    public List<String> m() {
        return k().g();
    }

    public List<String> n() {
        return k().o();
    }

    public String o() {
        return k().a();
    }

    public Map<String, Integer> p() {
        return k().m();
    }

    public boolean q() {
        return k().c();
    }

    public boolean r() {
        return k().d();
    }

    public void a(String str, SapiAccount.ReloginCredentials reloginCredentials) {
        if (!TextUtils.isEmpty(str) && reloginCredentials != null && !TextUtils.isEmpty(reloginCredentials.account) && !TextUtils.isEmpty(reloginCredentials.password) && !TextUtils.isEmpty(reloginCredentials.ubi) && !TextUtils.isEmpty(reloginCredentials.accountType)) {
            f(reloginCredentials.ubi);
            JSONObject s2 = s();
            if (s2 == null) {
                s2 = new JSONObject();
            }
            try {
                s2.put(str, reloginCredentials.toJSONObject());
                a(u, SapiDataEncryptor.e(s2.toString(), B()));
            } catch (JSONException e2) {
                L.e(e2);
            }
        }
    }

    public SapiAccount.ReloginCredentials e(String str) {
        JSONObject optJSONObject;
        JSONObject s2 = s();
        if (s2 == null || (optJSONObject = s2.optJSONObject(str)) == null) {
            return new SapiAccount.ReloginCredentials();
        }
        SapiAccount.ReloginCredentials fromJSONObject = SapiAccount.ReloginCredentials.fromJSONObject(optJSONObject);
        fromJSONObject.ubi = t();
        return fromJSONObject;
    }

    public JSONObject s() {
        String str;
        if (!TextUtils.isEmpty(i(u))) {
            str = SapiDataEncryptor.d(i(u), B());
        } else if (TextUtils.isEmpty(i(h))) {
            str = null;
        } else {
            str = i(h);
            String e2 = SapiDataEncryptor.e(str, B());
            if (!TextUtils.isEmpty(e2)) {
                a(u, e2);
                a(h, "");
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e3) {
            L.e(e3);
            return null;
        }
    }

    void f(String str) {
        a(i, str);
    }

    String t() {
        return i(i);
    }

    public void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            try {
                Map<String, Map<String, String>> u2 = u();
                u2.put(str, map);
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Map<String, String>> entry : u2.entrySet()) {
                    jSONObject.put(entry.getKey(), new JSONObject(entry.getValue()));
                }
                a(m, jSONObject.toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Map<String, Map<String, String>> u2 = u();
                if (u2.containsKey(str)) {
                    u2.remove(str);
                }
                a(m, new JSONObject(u2).toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public Map<String, Map<String, String>> u() {
        HashMap hashMap = new HashMap();
        String i2 = i(m);
        if (!TextUtils.isEmpty(i2)) {
            try {
                JSONObject jSONObject = new JSONObject(i2);
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

    public int v() {
        return b(n, 0);
    }

    public long w() {
        return (System.currentTimeMillis() / 1000) + v();
    }

    public int x() {
        return b("app_version_code", 0);
    }

    public void a(int i2) {
        a("app_version_code", i2);
    }

    public long y() {
        long b2 = b(o, 0L) + 1;
        a(o, b2);
        return b2;
    }

    private String B() {
        if (TextUtils.isEmpty(y)) {
            try {
                y = SapiUtils.toMd5((this.x.getPackageName() + SapiUtils.getPackageSign(this.x, this.x.getPackageName())).getBytes("UTF-8")).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                L.e(e2);
            }
        }
        return y;
    }

    public void h(String str) {
        a(p, str);
    }

    public String z() {
        return i(p);
    }

    <T> List<T> a(List<T> list, int i2) {
        return (list == null || i2 < 0 || i2 >= list.size()) ? list : list.subList(list.size() - i2, list.size());
    }
}
