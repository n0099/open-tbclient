package c.a.r0.m0.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final a f19942f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public float f19943b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19944c;

    /* renamed from: d  reason: collision with root package name */
    public float f19945d;

    /* renamed from: e  reason: collision with root package name */
    public long f19946e;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.nanoTime() : invokeV.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1831131586, "Lc/a/r0/m0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1831131586, "Lc/a/r0/m0/k/b;");
                return;
            }
        }
        f19942f = new a(null);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19943b = 1.0f;
        this.f19944c = true;
    }

    public static /* synthetic */ void f(b bVar, long j2, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = bVar.a();
        }
        if ((i2 & 2) != 0) {
            f2 = bVar.f19943b;
        }
        bVar.e(j2, f2);
    }

    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19946e / 1000000 : invokeV.longValue;
    }

    public final float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19945d : invokeV.floatValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19944c : invokeV.booleanValue;
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f19944c = z;
        }
    }

    public final void e(long j2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Float.valueOf(f2)}) == null) {
            this.f19944c = false;
            this.f19946e = j2 * 1000000;
            this.f19943b = f2;
            this.a = f19942f.b();
        }
    }

    public final void g(Float f2) {
        long longValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, f2) == null) {
            long b2 = f19942f.b();
            if (this.f19944c) {
                longValue = 0;
            } else {
                Long valueOf = f2 == null ? null : Long.valueOf(f2.floatValue() * 1000000000);
                longValue = valueOf == null ? b2 - this.a : valueOf.longValue();
            }
            long j2 = ((float) longValue) * this.f19943b;
            this.f19946e += j2;
            this.f19945d = ((float) j2) / 1.0E9f;
            this.a = b2;
        }
    }
}
