package com.baidu.m;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c cnj;

    public static synchronized c afj() {
        c cVar;
        synchronized (c.class) {
            if (cnj == null) {
                synchronized (c.class) {
                    if (cnj == null) {
                        cnj = new c();
                    }
                }
            }
            cVar = cnj;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.m.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.afi().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.m.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.afi().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.m.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.afi().b(context, jSONObject, aVar);
        return true;
    }

    public boolean e(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.afi().f(context, jSONObject);
        return true;
    }

    public boolean a(Activity activity, JSONObject jSONObject, com.baidu.m.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.afi().b(activity, jSONObject, aVar);
        return true;
    }
}
