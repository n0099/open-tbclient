package com.baidu.l;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c bVH;

    public static synchronized c Yo() {
        c cVar;
        synchronized (c.class) {
            if (bVH == null) {
                synchronized (c.class) {
                    if (bVH == null) {
                        bVH = new c();
                    }
                }
            }
            cVar = bVH;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.l.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Yn().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.l.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.Yn().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.Yn().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.Yn().g(context, jSONObject);
        return true;
    }

    public boolean a(Activity activity, JSONObject jSONObject, com.baidu.l.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.Yn().b(activity, jSONObject, aVar);
        return true;
    }
}
