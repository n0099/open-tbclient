package c.a.m.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cesium.i.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class f extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public b f3743d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Class<?> a;

        /* renamed from: b  reason: collision with root package name */
        public Method f3744b;

        /* renamed from: c  reason: collision with root package name */
        public Method f3745c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            d();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public final long b(Object obj) throws i.a {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                try {
                    return ((Long) this.f3745c.invoke(obj, new Object[0])).longValue();
                } catch (Exception unused) {
                    throw new i.a("");
                }
            }
            return invokeL.longValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.a = Class.forName(i.a(c.b()), true, Object.class.getClassLoader());
                    this.f3744b = i.b(this.a, i.a(c.h()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                    this.f3745c = i.b(this.a, i.a(c.c()), null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void f(Object obj, byte[] bArr, int i, int i2) throws i.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, obj, bArr, i, i2) == null) {
                try {
                    this.f3744b.invoke(obj, bArr, Integer.valueOf(i), Integer.valueOf(i2));
                } catch (Exception unused) {
                    throw new i.a("");
                }
            }
        }

        public final Object g() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.newInstance() : invokeV.objValue;
        }
    }

    public f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 32;
        this.f3741b = i;
        this.f3742c = i2;
        this.f3743d = new b(null);
    }

    @Override // c.a.m.h.e
    public com.baidu.cesium.i.b b(byte[] bArr, int i, int i2) {
        long j;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            try {
                Object g2 = this.f3743d.g();
                this.f3743d.f(g2, bArr, i, i2);
                j = this.f3743d.b(g2);
            } catch (Exception unused) {
                j = 4294967295L;
            }
            return com.baidu.cesium.i.b.a(new long[]{j});
        }
        return (com.baidu.cesium.i.b) invokeLII.objValue;
    }
}
