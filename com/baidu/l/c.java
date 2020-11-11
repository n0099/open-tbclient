package com.baidu.l;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c cbr;

    public static synchronized c aaN() {
        c cVar;
        synchronized (c.class) {
            if (cbr == null) {
                synchronized (c.class) {
                    if (cbr == null) {
                        cbr = new c();
                    }
                }
            }
            cVar = cbr;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.l.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.aaM().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.l.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.aaM().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.aaM().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.aaM().g(context, jSONObject);
        return true;
    }

    public boolean a(Activity activity, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.aaM().b(activity, jSONObject, aVar);
        return true;
    }
}
