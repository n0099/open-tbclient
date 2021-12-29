package c.a.x.b.g.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a w;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f27448b;

    /* renamed from: c  reason: collision with root package name */
    public int f27449c;

    /* renamed from: d  reason: collision with root package name */
    public int f27450d;

    /* renamed from: e  reason: collision with root package name */
    public int f27451e;

    /* renamed from: f  reason: collision with root package name */
    public int f27452f;

    /* renamed from: g  reason: collision with root package name */
    public int f27453g;

    /* renamed from: h  reason: collision with root package name */
    public int f27454h;

    /* renamed from: i  reason: collision with root package name */
    public float f27455i;

    /* renamed from: j  reason: collision with root package name */
    public float f27456j;

    /* renamed from: k  reason: collision with root package name */
    public int f27457k;
    public int l;
    public int m;
    public int n;
    public float o;
    public float p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public float v;

    /* renamed from: c.a.x.b.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1579a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-436032836, "Lc/a/x/b/g/b/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-436032836, "Lc/a/x/b/g/b/a$a;");
                    return;
                }
            }
            a = new a();
        }
    }

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

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (w == null) {
                w = C1579a.a;
            }
            return w;
        }
        return (a) invokeV.objValue;
    }

    public void b(int i2, int i3, int i4, int i5, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f27451e = i2;
            this.f27452f = i3;
            this.f27453g = i4;
            this.f27454h = i5;
            this.f27455i = f2;
            this.f27456j = f3;
        }
    }

    public void c(int i2, int i3, int i4, int i5, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f27457k = i2;
            this.l = i3;
            this.m = i4;
            this.n = i5;
            this.o = f2;
            this.p = f3;
        }
    }

    public void d(int i2, int i3, int i4, int i5, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.q = i2;
            this.r = i3;
            this.s = i4;
            this.t = i5;
            this.u = f2;
            this.v = f3;
        }
    }

    public void e(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            this.a = i2;
            this.f27448b = i3;
            this.f27449c = i4;
            this.f27450d = i5;
        }
    }
}
