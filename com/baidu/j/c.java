package com.baidu.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c aQf;

    public static synchronized c EB() {
        c cVar;
        synchronized (c.class) {
            if (aQf == null) {
                synchronized (c.class) {
                    if (aQf == null) {
                        aQf = new c();
                    }
                }
            }
            cVar = aQf;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.EA().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.EA().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.j.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.EA().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.EA().g(context, jSONObject);
        return true;
    }
}
