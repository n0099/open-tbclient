package com.baidu.l;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c bGB;

    public static synchronized c Ux() {
        c cVar;
        synchronized (c.class) {
            if (bGB == null) {
                synchronized (c.class) {
                    if (bGB == null) {
                        bGB = new c();
                    }
                }
            }
            cVar = bGB;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.l.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Uw().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.l.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Uw().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.Uw().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.Uw().g(context, jSONObject);
        return true;
    }

    public boolean a(Activity activity, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.Uw().b(activity, jSONObject, aVar);
        return true;
    }
}
