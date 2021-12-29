package c.a.r0.e.a.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Method f10520b;

    /* renamed from: c  reason: collision with root package name */
    public Object f10521c;

    public d(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 4099;
        if (cls == null) {
            return;
        }
        try {
            Object k2 = c.a.r0.k.a.a.c.a.k(cls, "getInstance", new Object[0]);
            this.f10521c = k2;
            if (k2 != null) {
                Object h2 = c.a.r0.k.a.a.c.a.h(k2, "UNIPERF_EVENT_APP_START");
                this.a = h2 == null ? this.a : ((Integer) h2).intValue();
            }
            Method i4 = c.a.r0.k.a.a.c.a.i(cls, "uniPerfEvent", Integer.TYPE, String.class, int[].class);
            this.f10520b = i4;
            if (i4 != null) {
                i4.setAccessible(true);
            }
        } catch (Throwable unused) {
        }
    }

    public static d b(@NonNull Context context) {
        Class<?> cls;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                cls = c.a.r0.k.a.a.c.a.b("android.iawareperf.UniPerf", true);
            } catch (Throwable unused) {
                cls = null;
            }
            return new d(cls);
        }
        return (d) invokeL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f10521c == null || this.f10520b == null) ? false : true : invokeV.booleanValue;
    }

    public int d(int i2, String str, int... iArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, iArr)) == null) {
            if (c()) {
                try {
                    Object invoke = this.f10520b.invoke(this.f10521c, Integer.valueOf(i2), str, iArr);
                    if (invoke == null) {
                        return -1;
                    }
                    return ((Integer) invoke).intValue();
                } catch (Throwable unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeILL.intValue;
    }
}
