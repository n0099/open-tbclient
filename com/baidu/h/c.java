package com.baidu.h;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c byP;

    public static synchronized c NU() {
        c cVar;
        synchronized (c.class) {
            if (byP == null) {
                synchronized (c.class) {
                    if (byP == null) {
                        byP = new c();
                    }
                }
            }
            cVar = byP;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.h.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.NT().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.h.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.NT().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.h.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.NT().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.NT().g(context, jSONObject);
        return true;
    }
}
