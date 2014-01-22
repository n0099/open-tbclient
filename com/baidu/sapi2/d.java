package com.baidu.sapi2;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
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
    private static final String d = "sapi_options";
    private static d f;
    private static SapiConfiguration g;
    private SharedPreferences e;

    public static d a(Context context) {
        synchronized (d.class) {
            if (f == null) {
                f = new d(context);
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiConfiguration sapiConfiguration) {
        g = sapiConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiConfiguration a() {
        return g;
    }

    private d(Context context) {
        this.e = context.getSharedPreferences("sapi_system", 0);
    }

    private void a(String str, String str2) {
        this.e.edit().putString(str, str2).commit();
    }

    private String a(String str) {
        return this.e.getString(str, "");
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

    public SapiAccount b() {
        if (TextUtils.isEmpty(a(a))) {
            return null;
        }
        try {
            return SapiAccount.fromJSONObject(new JSONObject(a(a)));
        } catch (JSONException e) {
            return null;
        }
    }

    public void b(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> d2 = d();
            if (!d2.contains(sapiAccount)) {
                d2.add(sapiAccount);
            } else {
                d2.set(d2.indexOf(sapiAccount), sapiAccount);
            }
            b(d2);
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> c2 = c();
            if (c2.contains(sapiAccount)) {
                c2.remove(sapiAccount);
                a(c2);
            }
        }
    }

    public void d(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            List<SapiAccount> d2 = d();
            if (d2.contains(sapiAccount)) {
                d2.remove(sapiAccount);
                b(d2);
            }
        }
    }

    public List<SapiAccount> c() {
        if (!TextUtils.isEmpty(a(b))) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(a(b)));
            } catch (Exception e) {
                return new ArrayList();
            }
        }
        return new ArrayList();
    }

    public List<SapiAccount> d() {
        if (!TextUtils.isEmpty(a(c))) {
            try {
                return SapiAccount.fromJSONArray(new JSONArray(a(c)));
            } catch (Exception e) {
                return new ArrayList();
            }
        }
        return new ArrayList();
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

    public b e() {
        String a2 = a(d);
        if (!TextUtils.isEmpty(a2)) {
            try {
                return b.a(new JSONObject(a2));
            } catch (JSONException e) {
            }
        }
        return new b();
    }

    public void a(b bVar) {
        if (bVar != null) {
            a(d, bVar.c());
        }
    }
}
