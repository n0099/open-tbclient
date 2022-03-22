package c.a.v.b.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b E;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public float C;
    public float D;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f21450b;

    /* renamed from: c  reason: collision with root package name */
    public String f21451c;

    /* renamed from: d  reason: collision with root package name */
    public String f21452d;

    /* renamed from: e  reason: collision with root package name */
    public int f21453e;

    /* renamed from: f  reason: collision with root package name */
    public int f21454f;

    /* renamed from: g  reason: collision with root package name */
    public int f21455g;

    /* renamed from: h  reason: collision with root package name */
    public int f21456h;
    public int i;
    public int j;
    public int k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public int r;
    public int s;
    public String t;
    public String u;
    public String v;
    public String w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(205695634, "Lc/a/v/b/e/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(205695634, "Lc/a/v/b/e/b$a;");
                    return;
                }
            }
            a = new b();
        }
    }

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
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (E == null) {
                E = a.a;
            }
            return E;
        }
        return (b) invokeV.objValue;
    }

    public void b(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
            this.l = str;
            this.m = str2;
            this.n = str3;
            this.o = str4;
        }
    }

    public void c(int i, int i2, int i3, int i4, String str, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.x = i;
            this.y = i2;
            this.z = i3;
            this.A = i4;
            this.B = str;
            this.C = f2;
            this.D = f3;
        }
    }

    public void d(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            this.f21453e = i;
            this.f21454f = i2;
            this.f21455g = i3;
            this.f21456h = i4;
            this.i = i5;
            this.j = i6;
            this.k = i7;
        }
    }
}
