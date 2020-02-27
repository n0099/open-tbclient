package com.baidu.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c aPP;

    public static synchronized c Es() {
        c cVar;
        synchronized (c.class) {
            if (aPP == null) {
                synchronized (c.class) {
                    if (aPP == null) {
                        aPP = new c();
                    }
                }
            }
            cVar = aPP;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Er().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Er().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.j.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.Er().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.Er().g(context, jSONObject);
        return true;
    }
}
