package com.baidu.m;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c cgh;

    public static synchronized c adm() {
        c cVar;
        synchronized (c.class) {
            if (cgh == null) {
                synchronized (c.class) {
                    if (cgh == null) {
                        cgh = new c();
                    }
                }
            }
            cVar = cgh;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.m.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.adl().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.m.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.adl().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.m.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.adl().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.adl().g(context, jSONObject);
        return true;
    }

    public boolean a(Activity activity, JSONObject jSONObject, com.baidu.m.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.adl().b(activity, jSONObject, aVar);
        return true;
    }
}
