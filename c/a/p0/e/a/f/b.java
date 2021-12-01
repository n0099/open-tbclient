package c.a.p0.e.a.f;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;

    /* renamed from: b  reason: collision with root package name */
    public Method f9504b;

    /* renamed from: c  reason: collision with root package name */
    public Method f9505c;

    /* renamed from: d  reason: collision with root package name */
    public Method f9506d;

    /* renamed from: e  reason: collision with root package name */
    public Method f9507e;

    /* renamed from: f  reason: collision with root package name */
    public String f9508f;

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
            Object m = c.a.p0.k.a.a.c.a.m(cls);
            this.a = m;
            if (m != null) {
                Method i4 = c.a.p0.k.a.a.c.a.i(cls, "hypnusSetAction", Integer.TYPE, Integer.TYPE);
                this.f9504b = i4;
                if (i4 != null) {
                    i4.setAccessible(true);
                }
                Method i5 = c.a.p0.k.a.a.c.a.i(cls, "hypnusSetSignatureAction", Integer.TYPE, Integer.TYPE, String.class);
                this.f9505c = i5;
                if (i5 != null) {
                    i5.setAccessible(true);
                }
                Method i6 = c.a.p0.k.a.a.c.a.i(cls, "isHypnusOK", new Class[0]);
                this.f9507e = i6;
                if (i6 != null) {
                    i6.setAccessible(true);
                }
                f();
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
                cls = c.a.p0.k.a.a.c.a.b("com.oppo.hypnus.HypnusManager", true);
            } catch (Throwable unused) {
                cls = null;
            }
            return new b(cls);
        }
        return (b) invokeL.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.f9508f;
            if (str != null) {
                return str;
            }
            Method method = this.f9506d;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f9508f = invoke == null ? "308203633082024ba00302010202040875ec17300d06092a864886f70d01010b05003062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d301e170d3135303130373036343930325a170d3235303130343036343930325a3062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d30820122300d06092a864886f70d01010105000382010f003082010a0282010100a4677dd7cdd8d842b767d4a4" : (String) invoke;
                } catch (Throwable unused) {
                    this.f9508f = "308203633082024ba00302010202040875ec17300d06092a864886f70d01010b05003062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d301e170d3135303130373036343930325a170d3235303130343036343930325a3062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d30820122300d06092a864886f70d01010105000382010f003082010a0282010100a4677dd7cdd8d842b767d4a4";
                }
            }
            return this.f9508f;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f9505c == null || b() == null) ? false : true : invokeV.booleanValue;
    }

    public void d(int i2, int i3) {
        Object obj;
        Method method;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || (obj = this.a) == null || (method = this.f9504b) == null) {
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (Throwable unused) {
        }
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) && this.a != null && this.f9505c != null && b() != null) {
            try {
                this.f9505c.invoke(this.a, Integer.valueOf(i2), Integer.valueOf(i3), this.f9508f);
            } catch (Throwable unused) {
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                Class<?> b2 = c.a.p0.k.a.a.c.a.b("com.oppo.hypnus.Hypnus", true);
                if (b2 != null) {
                    Method i2 = c.a.p0.k.a.a.c.a.i(b2, "getLocalSignature", new Class[0]);
                    this.f9506d = i2;
                    if (i2 != null) {
                        i2.setAccessible(true);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object obj = this.a;
            if (obj == null) {
                return false;
            }
            Method method = this.f9507e;
            if (method == null) {
                return true;
            }
            try {
                Object invoke = method.invoke(obj, new Object[0]);
                if (invoke != null) {
                    return ((Boolean) invoke).booleanValue();
                }
            } catch (Throwable unused) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
