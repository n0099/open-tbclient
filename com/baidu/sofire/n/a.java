package com.baidu.sofire.n;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes20.dex */
public final class a {
    Object a;
    Class<?> b;
    Method c;
    Method d;
    Method e;
    String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(Context context, Method method) {
        if (this.a != null && method != null) {
            try {
                Object invoke = method.invoke(this.a, context);
                if (invoke != null) {
                    return (String) invoke;
                }
            } catch (Exception e) {
                Log.d("IdentifierManager", "invoke exception!", e);
            }
        }
        return null;
    }
}
