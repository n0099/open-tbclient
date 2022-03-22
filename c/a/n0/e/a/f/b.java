package c.a.n0.e.a.f;

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
    public Object a;

    /* renamed from: b  reason: collision with root package name */
    public Method f8195b;

    /* renamed from: c  reason: collision with root package name */
    public Method f8196c;

    /* renamed from: d  reason: collision with root package name */
    public Method f8197d;

    /* renamed from: e  reason: collision with root package name */
    public Method f8198e;

    /* renamed from: f  reason: collision with root package name */
    public String f8199f;

    public b(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (cls == null) {
            return;
        }
        try {
            Object m = c.a.n0.k.a.a.c.a.m(cls);
            this.a = m;
            if (m != null) {
                Method i3 = c.a.n0.k.a.a.c.a.i(cls, "hypnusSetAction", Integer.TYPE, Integer.TYPE);
                this.f8195b = i3;
                if (i3 != null) {
                    i3.setAccessible(true);
                }
                Method i4 = c.a.n0.k.a.a.c.a.i(cls, "hypnusSetSignatureAction", Integer.TYPE, Integer.TYPE, String.class);
                this.f8196c = i4;
                if (i4 != null) {
                    i4.setAccessible(true);
                }
                Method i5 = c.a.n0.k.a.a.c.a.i(cls, "isHypnusOK", new Class[0]);
                this.f8198e = i5;
                if (i5 != null) {
                    i5.setAccessible(true);
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
                cls = c.a.n0.k.a.a.c.a.b("com.oppo.hypnus.HypnusManager", true);
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
            String str = this.f8199f;
            if (str != null) {
                return str;
            }
            Method method = this.f8197d;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f8199f = invoke == null ? "308203633082024ba00302010202040875ec17300d06092a864886f70d01010b05003062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d301e170d3135303130373036343930325a170d3235303130343036343930325a3062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d30820122300d06092a864886f70d01010105000382010f003082010a0282010100a4677dd7cdd8d842b767d4a4" : (String) invoke;
                } catch (Throwable unused) {
                    this.f8199f = "308203633082024ba00302010202040875ec17300d06092a864886f70d01010b05003062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d301e170d3135303130373036343930325a170d3235303130343036343930325a3062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d30820122300d06092a864886f70d01010105000382010f003082010a0282010100a4677dd7cdd8d842b767d4a4";
                }
            }
            return this.f8199f;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f8196c == null || b() == null) ? false : true : invokeV.booleanValue;
    }

    public void d(int i, int i2) {
        Object obj;
        Method method;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (obj = this.a) == null || (method = this.f8195b) == null) {
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i), Integer.valueOf(i2));
        } catch (Throwable unused) {
        }
    }

    public void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) && this.a != null && this.f8196c != null && b() != null) {
            try {
                this.f8196c.invoke(this.a, Integer.valueOf(i), Integer.valueOf(i2), this.f8199f);
            } catch (Throwable unused) {
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                Class<?> b2 = c.a.n0.k.a.a.c.a.b("com.oppo.hypnus.Hypnus", true);
                if (b2 != null) {
                    Method i = c.a.n0.k.a.a.c.a.i(b2, "getLocalSignature", new Class[0]);
                    this.f8197d = i;
                    if (i != null) {
                        i.setAccessible(true);
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
            Method method = this.f8198e;
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
