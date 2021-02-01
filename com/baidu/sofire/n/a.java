package com.baidu.sofire.n;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    Object f5314a;

    /* renamed from: b  reason: collision with root package name */
    Class<?> f5315b;
    Method c;
    Method d;
    Method e;
    String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(Context context, Method method) {
        if (this.f5314a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f5314a, context);
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
