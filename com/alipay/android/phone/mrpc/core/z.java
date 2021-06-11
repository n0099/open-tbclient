package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<Object> f1688a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<Map<String, Object>> f1689b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public byte f1690c = 0;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f1691d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public x f1692e;

    public z(x xVar) {
        this.f1692e = xVar;
    }

    public final Object a(Method method, Object[] objArr) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        boolean z = method.getAnnotation(ResetCookie.class) != null;
        Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        f1688a.set(null);
        f1689b.set(null);
        if (operationType != null) {
            String value = operationType.value();
            int incrementAndGet = this.f1691d.incrementAndGet();
            try {
                if (this.f1690c == 0) {
                    com.alipay.android.phone.mrpc.core.a.e eVar = new com.alipay.android.phone.mrpc.core.a.e(incrementAndGet, value, objArr);
                    if (f1689b.get() != null) {
                        eVar.a(f1689b.get());
                    }
                    byte[] a2 = eVar.a();
                    f1689b.set(null);
                    Object a3 = new com.alipay.android.phone.mrpc.core.a.d(genericReturnType, (byte[]) new j(this.f1692e.a(), method, incrementAndGet, value, a2, z).a()).a();
                    if (genericReturnType != Void.TYPE) {
                        f1688a.set(a3);
                    }
                }
                return f1688a.get();
            } catch (RpcException e2) {
                e2.setOperationType(value);
                throw e2;
            }
        }
        throw new IllegalStateException("OperationType must be set.");
    }
}
