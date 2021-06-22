package com.baidu.sofire.n;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Object f10380a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f10381b;

    /* renamed from: c  reason: collision with root package name */
    public Method f10382c;

    /* renamed from: d  reason: collision with root package name */
    public Method f10383d;

    /* renamed from: e  reason: collision with root package name */
    public Method f10384e;

    /* renamed from: f  reason: collision with root package name */
    public String f10385f;

    public final String a(Context context, Method method) {
        Object obj = this.f10380a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            Log.d("IdentifierManager", "invoke exception!", e2);
            return null;
        }
    }
}
