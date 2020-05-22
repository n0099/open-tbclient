package com.baidu.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c btJ;

    public static synchronized c MF() {
        c cVar;
        synchronized (c.class) {
            if (btJ == null) {
                synchronized (c.class) {
                    if (btJ == null) {
                        btJ = new c();
                    }
                }
            }
            cVar = btJ;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.g.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.ME().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.g.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.ME().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.g.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.ME().b(context, jSONObject, aVar);
        return true;
    }

    public boolean f(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.ME().g(context, jSONObject);
        return true;
    }
}
