package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.L;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    private static final String a = "current_account";
    private static final String b = "share_accounts";
    private static final String c = "login_accounts";
    private static final String d = "first_install";
    private static final String e = "sapi_options";
    private static final String f = "relogin_credentials";
    private static final String g = "cuidtoken";
    private static final String h = "device_token";
    private static final String i = "device_login_available";
    private static final String j = "hosts_hijacked";
    private static d l;
    private SharedPreferences k;

    public static d a(Context context) {
        synchronized (d.class) {
            if (l == null) {
                l = new d(context);
            }
        }
        return l;
    }

    private d(Context context) {
        this.k = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(String str, String str2) {
        this.k.edit().putString(str, str2).commit();
    }

    private String d(String str) {
        return this.k.getString(str, "");
    }

    public String a() {
        return d(h);
    }

    public void a(String str) {
        a(h, str);
    }

    public boolean b() {
        return this.k.getBoolean(i, false);
    }

    public void a(boolean z) {
        this.k.edit().putBoolean(i, z).commit();
    }

    public boolean c() {
        return this.k.getBoolean(j, false);
    }

    public void b(boolean z) {
        this.k.edit().putBoolean(j, z).commit();
    }

    public void a(SapiAccount sapiAccount) {
        if (sapiAccount == null) {
            a(a, "");
            return;
        }
        JSONObject jSONObject = sapiAccount.toJSONObject();
        if (jSONObject != null) {
            a(a, jSONObject.toString());
        }
    }

    public SapiAccount d() {
        if (TextUtils.isEmpty(d(a))) {
            return null;
        }
        try {
            return SapiAccount.fromJSONObject(new JSONObject(d(a)));
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
            List<SapiAccount> f2 = f();
            if (f2.contains(sapiAccount)) {
                f2.remove(sapiAccount);
                b(f2);
            }
        }
    }

    public List<SapiAccount> e() {
        if (!TextUtils.isEmpty(d(b))) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(d(b)));
            } catch (Throwable th) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public List<SapiAccount> f() {
        if (!TextUtils.isEmpty(d(c))) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(d(c)));
            } catch (Exception e2) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public boolean g() {
        if (this.k.getBoolean(d, true)) {
            this.k.edit().putBoolean(d, false).commit();
            return true;
        }
        return false;
    }

    private void a(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(b, jSONArray.toString());
        }
    }

    private void b(List<SapiAccount> list) {
        JSONArray jSONArray = SapiAccount.toJSONArray(list);
        if (jSONArray != null) {
            a(c, jSONArray.toString());
        }
    }

    public b h() {
        String d2 = d(e);
        if (!TextUtils.isEmpty(d2)) {
            try {
                return b.a(new JSONObject(d2));
            } catch (JSONException e2) {
            }
        }
        return new b();
    }

    public void a(b bVar) {
        if (bVar != null) {
            a(e, bVar.d());
        }
    }

    public void a(String str, SapiAccount.ReloginCredentials reloginCredentials) {
        if (!TextUtils.isEmpty(str) && reloginCredentials != null && !TextUtils.isEmpty(reloginCredentials.account) && !TextUtils.isEmpty(reloginCredentials.password) && !TextUtils.isEmpty(reloginCredentials.ubi) && !TextUtils.isEmpty(reloginCredentials.accountType)) {
            c(reloginCredentials.ubi);
            JSONObject i2 = i();
            if (i2 == null) {
                i2 = new JSONObject();
            }
            try {
                i2.put(str, reloginCredentials.toJSONObject());
                a(f, i2.toString());
            } catch (JSONException e2) {
                L.e(e2);
            }
        }
    }

    public SapiAccount.ReloginCredentials b(String str) {
        JSONObject optJSONObject;
        JSONObject i2 = i();
        if (i2 == null || (optJSONObject = i2.optJSONObject(str)) == null) {
            return new SapiAccount.ReloginCredentials();
        }
        SapiAccount.ReloginCredentials fromJSONObject = SapiAccount.ReloginCredentials.fromJSONObject(optJSONObject);
        fromJSONObject.ubi = j();
        return fromJSONObject;
    }

    public JSONObject i() {
        String d2 = d(f);
        if (!TextUtils.isEmpty(d2)) {
            try {
                return new JSONObject(d2);
            } catch (JSONException e2) {
            }
        }
        return null;
    }

    void c(String str) {
        a(g, str);
    }

    String j() {
        return d(g);
    }
}
