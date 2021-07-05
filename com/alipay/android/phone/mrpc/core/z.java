package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<Object> f1691a;

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<Map<String, Object>> f1692b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public byte f1693c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f1694d;

    /* renamed from: e  reason: collision with root package name */
    public x f1695e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-834062746, "Lcom/alipay/android/phone/mrpc/core/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-834062746, "Lcom/alipay/android/phone/mrpc/core/z;");
                return;
            }
        }
        f1691a = new ThreadLocal<>();
        f1692b = new ThreadLocal<>();
    }

    public z(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1693c = (byte) 0;
        this.f1695e = xVar;
        this.f1694d = new AtomicInteger();
    }

    public final Object a(Method method, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, method, objArr)) == null) {
            if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalThreadStateException("can't in main thread call rpc .");
            }
            OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
            boolean z = method.getAnnotation(ResetCookie.class) != null;
            Type genericReturnType = method.getGenericReturnType();
            method.getAnnotations();
            f1691a.set(null);
            f1692b.set(null);
            if (operationType != null) {
                String value = operationType.value();
                int incrementAndGet = this.f1694d.incrementAndGet();
                try {
                    if (this.f1693c == 0) {
                        com.alipay.android.phone.mrpc.core.a.e eVar = new com.alipay.android.phone.mrpc.core.a.e(incrementAndGet, value, objArr);
                        if (f1692b.get() != null) {
                            eVar.a(f1692b.get());
                        }
                        byte[] a2 = eVar.a();
                        f1692b.set(null);
                        Object a3 = new com.alipay.android.phone.mrpc.core.a.d(genericReturnType, (byte[]) new j(this.f1695e.a(), method, incrementAndGet, value, a2, z).a()).a();
                        if (genericReturnType != Void.TYPE) {
                            f1691a.set(a3);
                        }
                    }
                    return f1691a.get();
                } catch (RpcException e2) {
                    e2.setOperationType(value);
                    throw e2;
                }
            }
            throw new IllegalStateException("OperationType must be set.");
        }
        return invokeLL.objValue;
    }
}
