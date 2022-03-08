package c.a.p0.e.a.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Method a;

    /* renamed from: b  reason: collision with root package name */
    public Object f9758b;

    public b(Class<?> cls) {
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
        if (cls == null) {
            return;
        }
        try {
            this.f9758b = c.a.p0.k.a.a.c.a.m(cls);
            Method i4 = c.a.p0.k.a.a.c.a.i(cls, "perfEvent", Integer.TYPE, String.class, int[].class);
            this.a = i4;
            if (i4 != null) {
                i4.setAccessible(true);
            }
        } catch (Throwable unused) {
        }
    }

    public static b a(@NonNull Context context) {
        Class<?> cls;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                cls = c.a.p0.k.a.a.c.a.b("com.hisi.perfhub.PerfHub", true);
            } catch (Throwable unused) {
                cls = null;
            }
            return new b(cls);
        }
        return (b) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f9758b == null || this.a == null) ? false : true : invokeV.booleanValue;
    }

    public int c(int i2, String str, int... iArr) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, iArr)) == null) {
            if (b()) {
                try {
                    Object invoke = this.a.invoke(this.f9758b, Integer.valueOf(i2), str, iArr);
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
