package com.baidu.sofire.l;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Object f11503a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f11504b;

    /* renamed from: c  reason: collision with root package name */
    public Method f11505c;

    /* renamed from: d  reason: collision with root package name */
    public Method f11506d;

    /* renamed from: e  reason: collision with root package name */
    public Method f11507e;

    /* renamed from: f  reason: collision with root package name */
    public String f11508f;

    public final String a(Context context, Method method) {
        Object obj = this.f11503a;
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
