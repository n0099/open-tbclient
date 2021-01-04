package com.baidu.sofire.n;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    Object f5594a;

    /* renamed from: b  reason: collision with root package name */
    Class<?> f5595b;
    Method c;
    Method d;
    Method e;
    String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(Context context, Method method) {
        if (this.f5594a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f5594a, context);
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
