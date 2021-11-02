package b.a.w.b.g.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29254a;

    /* renamed from: b  reason: collision with root package name */
    public int f29255b;

    /* renamed from: c  reason: collision with root package name */
    public int f29256c;

    /* renamed from: d  reason: collision with root package name */
    public int f29257d;

    /* renamed from: e  reason: collision with root package name */
    public int f29258e;

    /* renamed from: f  reason: collision with root package name */
    public int f29259f;

    /* renamed from: g  reason: collision with root package name */
    public int f29260g;

    /* renamed from: h  reason: collision with root package name */
    public int f29261h;

    /* renamed from: i  reason: collision with root package name */
    public float f29262i;
    public float j;
    public int k;
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

    /* renamed from: b.a.w.b.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1412a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f29263a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-54581378, "Lb/a/w/b/g/b/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-54581378, "Lb/a/w/b/g/b/a$a;");
                    return;
                }
            }
            f29263a = new a();
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
                w = C1412a.f29263a;
            }
            return w;
        }
        return (a) invokeV.objValue;
    }

    public void b(int i2, int i3, int i4, int i5, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f29258e = i2;
            this.f29259f = i3;
            this.f29260g = i4;
            this.f29261h = i5;
            this.f29262i = f2;
            this.j = f3;
        }
    }

    public void c(int i2, int i3, int i4, int i5, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.k = i2;
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
            this.f29254a = i2;
            this.f29255b = i3;
            this.f29256c = i4;
            this.f29257d = i5;
        }
    }
}
