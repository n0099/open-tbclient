package c.a.r.h.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.common.cc.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public b f5040d;

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
        public Method f5041b;

        /* renamed from: c  reason: collision with root package name */
        public Method f5042c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public final long b(Object obj) throws n.a {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                try {
                    return ((Long) this.f5042c.invoke(obj, new Object[0])).longValue();
                } catch (Exception unused) {
                    throw new n.a("");
                }
            }
            return invokeL.longValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.a = Class.forName(n.a(h.a()), true, Object.class.getClassLoader());
                    this.f5041b = n.b(this.a, n.a(h.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                    this.f5042c = n.b(this.a, n.a(h.c()), null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public final void f(Object obj, byte[] bArr, int i2, int i3) throws n.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, obj, bArr, i2, i3) == null) {
                try {
                    this.f5041b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
                } catch (Exception unused) {
                    throw new n.a("");
                }
            }
        }

        public final Object g() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.newInstance() : invokeV.objValue;
        }
    }

    public e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 32;
        this.f5038b = i2;
        this.f5039c = i3;
        this.f5040d = new b(null);
    }

    @Override // c.a.r.h.a.d
    public com.baidu.helios.common.cc.a b(byte[] bArr, int i2, int i3) {
        long j2;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            try {
                Object g2 = this.f5040d.g();
                this.f5040d.f(g2, bArr, i2, i3);
                j2 = this.f5040d.b(g2);
            } catch (Exception unused) {
                j2 = 4294967295L;
            }
            return com.baidu.helios.common.cc.a.a(new long[]{j2});
        }
        return (com.baidu.helios.common.cc.a) invokeLII.objValue;
    }
}
