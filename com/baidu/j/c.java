package com.baidu.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c aKy;

    public static synchronized c BA() {
        c cVar;
        synchronized (c.class) {
            if (aKy == null) {
                synchronized (c.class) {
                    if (aKy == null) {
                        aKy = new c();
                    }
                }
            }
            cVar = aKy;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Bz().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Bz().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.j.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.Bz().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.Bz().g(context, jSONObject);
        return true;
    }
}
