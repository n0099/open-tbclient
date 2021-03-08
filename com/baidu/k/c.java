package com.baidu.k;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();

    /* renamed from: com  reason: collision with root package name */
    private static volatile c f1870com;

    public static synchronized c adh() {
        c cVar;
        synchronized (c.class) {
            if (f1870com == null) {
                synchronized (c.class) {
                    if (f1870com == null) {
                        f1870com = new c();
                    }
                }
            }
            cVar = f1870com;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.k.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.adg().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.k.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.adg().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.k.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.adg().b(context, jSONObject, aVar);
        return true;
    }

    public boolean e(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.adg().f(context, jSONObject);
        return true;
    }

    public boolean a(Activity activity, JSONObject jSONObject, com.baidu.k.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.adg().b(activity, jSONObject, aVar);
        return true;
    }
}
