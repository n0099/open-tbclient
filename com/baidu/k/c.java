package com.baidu.k;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static volatile c ciw;

    public static synchronized c abq() {
        c cVar;
        synchronized (c.class) {
            if (ciw == null) {
                synchronized (c.class) {
                    if (ciw == null) {
                        ciw = new c();
                    }
                }
            }
            cVar = ciw;
        }
        return cVar;
    }

    private c() {
    }

    public boolean c(Activity activity, String str, com.baidu.k.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.abp().e(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, com.baidu.k.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.abp().f(activity, str, aVar);
        return true;
    }

    public boolean a(Context context, JSONObject jSONObject, com.baidu.k.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.abp().b(context, jSONObject, aVar);
        return true;
    }

    public boolean e(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.abp().f(context, jSONObject);
        return true;
    }

    public boolean a(Activity activity, JSONObject jSONObject, com.baidu.k.a.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.abp().b(activity, jSONObject, aVar);
        return true;
    }
}
