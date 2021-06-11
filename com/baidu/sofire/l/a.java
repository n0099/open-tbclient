package com.baidu.sofire.l;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Object f10358a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f10359b;

    /* renamed from: c  reason: collision with root package name */
    public Method f10360c;

    /* renamed from: d  reason: collision with root package name */
    public Method f10361d;

    /* renamed from: e  reason: collision with root package name */
    public Method f10362e;

    /* renamed from: f  reason: collision with root package name */
    public String f10363f;

    public final String a(Context context, Method method) {
        Object obj = this.f10358a;
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
