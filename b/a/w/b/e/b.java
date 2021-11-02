package b.a.w.b.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b E;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public float C;
    public float D;

    /* renamed from: a  reason: collision with root package name */
    public String f29230a;

    /* renamed from: b  reason: collision with root package name */
    public String f29231b;

    /* renamed from: c  reason: collision with root package name */
    public String f29232c;

    /* renamed from: d  reason: collision with root package name */
    public String f29233d;

    /* renamed from: e  reason: collision with root package name */
    public int f29234e;

    /* renamed from: f  reason: collision with root package name */
    public int f29235f;

    /* renamed from: g  reason: collision with root package name */
    public int f29236g;

    /* renamed from: h  reason: collision with root package name */
    public int f29237h;

    /* renamed from: i  reason: collision with root package name */
    public int f29238i;
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

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f29239a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(514740754, "Lb/a/w/b/e/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(514740754, "Lb/a/w/b/e/b$a;");
                    return;
                }
            }
            f29239a = new b();
        }
    }

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
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (E == null) {
                E = a.f29239a;
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

    public void c(int i2, int i3, int i4, int i5, String str, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.x = i2;
            this.y = i3;
            this.z = i4;
            this.A = i5;
            this.B = str;
            this.C = f2;
            this.D = f3;
        }
    }

    public void d(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
            this.f29234e = i2;
            this.f29235f = i3;
            this.f29236g = i4;
            this.f29237h = i5;
            this.f29238i = i6;
            this.j = i7;
            this.k = i8;
        }
    }
}
