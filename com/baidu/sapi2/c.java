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
    private static String x;
    private static c y;
    private SharedPreferences v;
    private Context w;

    public static c a(Context context) {
        synchronized (c.class) {
            if (y == null) {
                y = new c(context.getApplicationContext());
            }
        }
        return y;
    }

    private c(Context context) {
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

    private String h(String str) {
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
        return h(j);
    }

    public void a(String str) {
        a(j, str);
    }

    public boolean b() {
        return b(k, false);
    }

    public void a(boolean z) {
        a(k, z);
    }

    public boolean c() {
        return b(l, false);
    }

    public void b(boolean z) {
        a(l, z);
    }

    public void a(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            a(r, "");
            SapiUtils.webLogout(this.w);
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            a(r, SapiDataEncryptor.e(jSONObject.toString(), B()));
            SapiUtils.webLogin(this.w, sapiAccount.bduss, sapiAccount.k);
            if (!i()) {
                A();
            }
        }
        List<String> h2 = a(this.w).k().h();
        if (h2 != null && !h2.isEmpty() && !SapiAccountManager.getInstance().getAccountService().a(sapiAccount, h2)) {
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
            }, sapiAccount.bduss, h2, false);
        }
    }

    public SapiAccount d() {
        String str;
        if (!TextUtils.isEmpty(h(r))) {
            str = SapiDataEncryptor.d(h(r), B());
        } else if (TextUtils.isEmpty(h(b))) {
            str = null;
        } else {
            str = h(b);
            a(b, "");
            a(r, SapiDataEncryptor.e(str, B()));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return SapiAccount.fromJSONObject(new JSONObject(str));
        } catch (JSONException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        SapiAccount d2 = d();
        List<String> h2 = a(this.w).k().h();
        if (d2 != null && h2 != null && !h2.isEmpty() && !SapiAccountManager.getInstance().getAccountService().a(d2, h2)) {
            SapiAccountManager.getInstance().getAccountService().a(new GetTplStokenCallback() { // from class: com.baidu.sapi2.c.2
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
            }, d2.bduss, h2, false);
        }
    }

    public void b(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> f2 = f();
            if (!f2.contains(sapiAccount)) {
                f2.add(sapiAccount);
            } else {
                f2.remove(f2.indexOf(sapiAccount));
                f2.add(sapiAccount);
            }
            a(a(f2, 5));
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> g2 = g();
            if (!g2.contains(sapiAccount)) {
                g2.add(sapiAccount);
            } else {
                g2.set(g2.indexOf(sapiAccount), sapiAccount);
            }
            b(g2);
        }
    }

    public void d(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> f2 = f();
            if (f2.contains(sapiAccount)) {
                f2.remove(sapiAccount);
                a(f2);
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
            List<SapiAccount> g2 = g();
            if (g2.contains(sapiAccount)) {
                g2.remove(sapiAccount);
                b(g2);
            }
        }
    }

    public List<SapiAccount> f() {
        String str = null;
        if (!TextUtils.isEmpty(h(s))) {
            str = SapiDataEncryptor.d(h(s), B());
        } else if (!TextUtils.isEmpty(h(c))) {
            str = h(c);
            a(c, "");
            a(s, SapiDataEncryptor.e(str, B()));
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

    public List<SapiAccount> g() {
        String str = null;
        if (!TextUtils.isEmpty(h(t))) {
            str = SapiDataEncryptor.d(h(t), B());
        } else if (!TextUtils.isEmpty(h(d))) {
            str = h(d);
            a(d, "");
            a(t, SapiDataEncryptor.e(str, B()));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccount b(String str) {
        SapiAccount sapiAccount;
        SapiAccount sapiAccount2 = null;
        if (str == null) {
            return null;
        }
        SapiAccount d2 = d();
        if (d2 != null && str.equals(d2.bduss)) {
            sapiAccount2 = d2;
        }
        Iterator<SapiAccount> it = g().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SapiAccount next = it.next();
            if (str.equals(next.bduss)) {
                sapiAccount2 = next;
                break;
            }
        }
        Iterator<SapiAccount> it2 = f().iterator();
        while (true) {
            if (!it2.hasNext()) {
                sapiAccount = sapiAccount2;
                break;
            }
            sapiAccount = it2.next();
            if (str.equals(sapiAccount.bduss)) {
                break;
            }
        }
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccount c(String str) {
        SapiAccount sapiAccount;
        SapiAccount sapiAccount2 = null;
        if (str == null) {
            return null;
        }
        SapiAccount d2 = d();
        if (d2 != null && str.equals(d2.getReloginCredentials().ubi)) {
            sapiAccount2 = d2;
        }
        Iterator<SapiAccount> it = g().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SapiAccount next = it.next();
            if (str.equals(next.getReloginCredentials().ubi)) {
                sapiAccount2 = next;
                break;
            }
        }
        Iterator<SapiAccount> it2 = f().iterator();
        while (true) {
            if (!it2.hasNext()) {
                sapiAccount = sapiAccount2;
                break;
            }
            sapiAccount = it2.next();
            if (str.equals(sapiAccount.getReloginCredentials().ubi)) {
                break;
            }
        }
        return sapiAccount;
    }

    public boolean h() {
        if (b(e, true)) {
            a(e, false);
            return true;
        }
        return false;
    }

    public boolean i() {
        return b(f, false);
    }

    private void A() {
        a(f, true);
    }

    public void j() {
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

    public d k() {
        String h2 = h(g);
        if (!TextUtils.isEmpty(h2)) {
            try {
                return d.a(new JSONObject(h2));
            } catch (JSONException e2) {
            }
        }
        return new d();
    }

    public void a(d dVar) {
        if (dVar != null) {
            a(g, dVar.j());
        }
    }

    public Map<String, String> l() {
        return k().e();
    }

    public List<String> m() {
        return k().f();
    }

    public List<String> n() {
        return k().n();
    }

    public String o() {
        return k().a();
    }

    public Map<String, Integer> p() {
        return k().l();
    }

    public boolean q() {
        return k().c();
    }

    public void a(String str, SapiAccount.ReloginCredentials reloginCredentials) {
        if (!TextUtils.isEmpty(str) && reloginCredentials != null && !TextUtils.isEmpty(reloginCredentials.account) && !TextUtils.isEmpty(reloginCredentials.password) && !TextUtils.isEmpty(reloginCredentials.ubi) && !TextUtils.isEmpty(reloginCredentials.accountType)) {
            e(reloginCredentials.ubi);
            JSONObject r2 = r();
            if (r2 == null) {
                r2 = new JSONObject();
            }
            try {
                r2.put(str, reloginCredentials.toJSONObject());
                a(u, SapiDataEncryptor.e(r2.toString(), B()));
            } catch (JSONException e2) {
                L.e(e2);
            }
        }
    }

    public SapiAccount.ReloginCredentials d(String str) {
        JSONObject optJSONObject;
        JSONObject r2 = r();
        if (r2 == null || (optJSONObject = r2.optJSONObject(str)) == null) {
            return new SapiAccount.ReloginCredentials();
        }
        SapiAccount.ReloginCredentials fromJSONObject = SapiAccount.ReloginCredentials.fromJSONObject(optJSONObject);
        fromJSONObject.ubi = s();
        return fromJSONObject;
    }

    public JSONObject r() {
        String str;
        if (!TextUtils.isEmpty(h(u))) {
            str = SapiDataEncryptor.d(h(u), B());
        } else if (TextUtils.isEmpty(h(h))) {
            str = null;
        } else {
            str = h(h);
            a(h, "");
            a(u, SapiDataEncryptor.e(str, B()));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            L.e(e2);
            return null;
        }
    }

    void e(String str) {
        a(i, str);
    }

    String s() {
        return h(i);
    }

    public void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            try {
                Map<String, Map<String, String>> t2 = t();
                t2.put(str, map);
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Map<String, String>> entry : t2.entrySet()) {
                    jSONObject.put(entry.getKey(), new JSONObject(entry.getValue()));
                }
                a(m, jSONObject.toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Map<String, Map<String, String>> t2 = t();
                if (t2.containsKey(str)) {
                    t2.remove(str);
                }
                a(m, new JSONObject(t2).toString());
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public Map<String, Map<String, String>> t() {
        HashMap hashMap = new HashMap();
        String h2 = h(m);
        if (!TextUtils.isEmpty(h2)) {
            try {
                JSONObject jSONObject = new JSONObject(h2);
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

    public int u() {
        return b(n, 0);
    }

    public long v() {
        return (System.currentTimeMillis() / 1000) + u();
    }

    public int w() {
        return b(a, 0);
    }

    public void a(int i2) {
        a(a, i2);
    }

    public long x() {
        long b2 = b(o, 0L) + 1;
        a(o, b2);
        return b2;
    }

    public void b(int i2) {
        a(q, i2);
    }

    public int y() {
        int b2 = b(q, 0) + 1;
        a(q, b2);
        return b2;
    }

    private String B() {
        if (TextUtils.isEmpty(x)) {
            try {
                x = SapiUtils.toMd5((this.w.getPackageName() + SapiUtils.getPackageSign(this.w, this.w.getPackageName())).getBytes("UTF-8")).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                L.e(e2);
            }
        }
        return x;
    }

    public void g(String str) {
        a(p, str);
    }

    public String z() {
        return h(p);
    }

    <T> List<T> a(List<T> list, int i2) {
        return (list == null || i2 < 0 || i2 >= list.size()) ? list : list.subList(list.size() - i2, list.size());
    }
}
