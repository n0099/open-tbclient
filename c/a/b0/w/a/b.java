package c.a.b0.w.a;

import c.a.b0.z.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.nadcore.sweetsqlite.StringColumn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class b extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final c.a.b0.z.b A;
    public static final c.a.b0.z.b B;
    public static final c.a.b0.z.b[] C;
    public static final c.a.b0.z.b[] D;
    public static final c.a.b0.z.b p;
    public static final c.a.b0.z.b q;
    public static final c.a.b0.z.b r;
    public static final c.a.b0.z.b s;
    public static final c.a.b0.z.b t;
    public static final c.a.b0.z.b u;
    public static final c.a.b0.z.b v;
    public static final c.a.b0.z.b w;
    public static final c.a.b0.z.b x;
    public static final c.a.b0.z.b y;
    public static final c.a.b0.z.b z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final StringColumn f2116b;

    /* renamed from: c  reason: collision with root package name */
    public final IntegerColumn f2117c;

    /* renamed from: d  reason: collision with root package name */
    public final IntegerColumn f2118d;

    /* renamed from: e  reason: collision with root package name */
    public final StringColumn f2119e;

    /* renamed from: f  reason: collision with root package name */
    public final StringColumn f2120f;

    /* renamed from: g  reason: collision with root package name */
    public final StringColumn f2121g;

    /* renamed from: h  reason: collision with root package name */
    public final IntegerColumn f2122h;

    /* renamed from: i  reason: collision with root package name */
    public final IntegerColumn f2123i;

    /* renamed from: j  reason: collision with root package name */
    public final LongColumn f2124j;

    /* renamed from: k  reason: collision with root package name */
    public final LongColumn f2125k;
    public final StringColumn l;
    public final StringColumn m;
    public final StringColumn n;
    public final Column[] o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1194861670, "Lc/a/b0/w/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1194861670, "Lc/a/b0/w/a/b;");
                return;
            }
        }
        p = j.b(4, "key", "          key           ", 0, 2);
        q = j.a(2, "task_id", "        task_id         ", 1);
        r = j.a(2, "status", "         status         ", 2);
        s = j.a(4, "package_name", "      package_name      ", 3);
        t = j.a(4, "url", "          url           ", 4);
        u = j.a(4, "file", "          file          ", 5);
        v = j.a(2, "progress", "        progress        ", 6);
        w = j.a(2, "v_progress", "       v_progress       ", 7);
        x = j.a(3, "start_download_time", "  start_download_time   ", 8);
        y = j.a(3, "finished_download_time", " finished_download_time ", 9);
        z = j.a(4, "mt", "           mt           ", 10);
        A = j.a(4, "ctrl", "          ctrl          ", 11);
        c.a.b0.z.b a = j.a(4, "extra", "         extra          ", 12);
        B = a;
        c.a.b0.z.b bVar = p;
        C = new c.a.b0.z.b[]{bVar, q, r, s, t, u, v, w, x, y, z, A, a};
        D = new c.a.b0.z.b[]{bVar};
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
        this.f2116b = new StringColumn(p);
        this.f2117c = new IntegerColumn(q);
        this.f2118d = new IntegerColumn(r);
        this.f2119e = new StringColumn(s);
        this.f2120f = new StringColumn(t);
        this.f2121g = new StringColumn(u);
        this.f2122h = new IntegerColumn(v);
        this.f2123i = new IntegerColumn(w);
        this.f2124j = new LongColumn(x);
        this.f2125k = new LongColumn(y);
        this.l = new StringColumn(z);
        this.m = new StringColumn(A);
        StringColumn stringColumn = new StringColumn(B);
        this.n = stringColumn;
        this.o = new Column[]{this.f2116b, this.f2117c, this.f2118d, this.f2119e, this.f2120f, this.f2121g, this.f2122h, this.f2123i, this.f2124j, this.f2125k, this.l, this.m, stringColumn};
    }

    @Override // c.a.b0.z.j
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (Column[]) invokeV.objValue;
    }

    @Override // c.a.b0.z.j
    public c.a.b0.z.b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? C : (c.a.b0.z.b[]) invokeV.objValue;
    }

    @Override // c.a.b0.z.j
    public c.a.b0.z.b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? D : (c.a.b0.z.b[]) invokeV.objValue;
    }

    @Override // c.a.b0.z.j
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "t_apk_info" : (String) invokeV.objValue;
    }
}
