package com.baidu.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c aLq;

    public static synchronized c BW() {
        c cVar;
        synchronized (c.class) {
            if (aLq == null) {
                synchronized (c.class) {
                    if (aLq == null) {
                        aLq = new c();
                    }
                }
            }
            cVar = aLq;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.BV().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.j.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.BV().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.j.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.BV().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.BV().g(context, jSONObject);
        return true;
    }
}
