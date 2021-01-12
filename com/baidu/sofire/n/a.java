package com.baidu.sofire.n;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    Object f5312a;

    /* renamed from: b  reason: collision with root package name */
    Class<?> f5313b;
    Method c;
    Method d;
    Method e;
    String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(Context context, Method method) {
        if (this.f5312a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f5312a, context);
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
