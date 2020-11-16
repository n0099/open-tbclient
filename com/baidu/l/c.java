package com.baidu.l;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c bZG;

    public static synchronized c aae() {
        c cVar;
        synchronized (c.class) {
            if (bZG == null) {
                synchronized (c.class) {
                    if (bZG == null) {
                        bZG = new c();
                    }
                }
            }
            cVar = bZG;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.l.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.aad().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.l.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.aad().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.aad().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.aad().g(context, jSONObject);
        return true;
    }

    public boolean a(Activity activity, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.aad().b(activity, jSONObject, aVar);
        return true;
    }
}
