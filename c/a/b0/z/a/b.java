package c.a.b0.z.a;

import c.a.b0.c0.j;
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
    public static final c.a.b0.c0.b A;
    public static final c.a.b0.c0.b B;
    public static final c.a.b0.c0.b[] C;
    public static final c.a.b0.c0.b[] D;
    public static final c.a.b0.c0.b p;
    public static final c.a.b0.c0.b q;
    public static final c.a.b0.c0.b r;
    public static final c.a.b0.c0.b s;
    public static final c.a.b0.c0.b t;
    public static final c.a.b0.c0.b u;
    public static final c.a.b0.c0.b v;
    public static final c.a.b0.c0.b w;
    public static final c.a.b0.c0.b x;
    public static final c.a.b0.c0.b y;
    public static final c.a.b0.c0.b z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final StringColumn f2276b;

    /* renamed from: c  reason: collision with root package name */
    public final IntegerColumn f2277c;

    /* renamed from: d  reason: collision with root package name */
    public final IntegerColumn f2278d;

    /* renamed from: e  reason: collision with root package name */
    public final StringColumn f2279e;

    /* renamed from: f  reason: collision with root package name */
    public final StringColumn f2280f;

    /* renamed from: g  reason: collision with root package name */
    public final StringColumn f2281g;

    /* renamed from: h  reason: collision with root package name */
    public final IntegerColumn f2282h;

    /* renamed from: i  reason: collision with root package name */
    public final IntegerColumn f2283i;

    /* renamed from: j  reason: collision with root package name */
    public final LongColumn f2284j;
    public final LongColumn k;
    public final StringColumn l;
    public final StringColumn m;
    public final StringColumn n;
    public final Column[] o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1108974217, "Lc/a/b0/z/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1108974217, "Lc/a/b0/z/a/b;");
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
        c.a.b0.c0.b a = j.a(4, "extra", "         extra          ", 12);
        B = a;
        c.a.b0.c0.b bVar = p;
        C = new c.a.b0.c0.b[]{bVar, q, r, s, t, u, v, w, x, y, z, A, a};
        D = new c.a.b0.c0.b[]{bVar};
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
        this.f2276b = new StringColumn(p);
        this.f2277c = new IntegerColumn(q);
        this.f2278d = new IntegerColumn(r);
        this.f2279e = new StringColumn(s);
        this.f2280f = new StringColumn(t);
        this.f2281g = new StringColumn(u);
        this.f2282h = new IntegerColumn(v);
        this.f2283i = new IntegerColumn(w);
        this.f2284j = new LongColumn(x);
        this.k = new LongColumn(y);
        this.l = new StringColumn(z);
        this.m = new StringColumn(A);
        StringColumn stringColumn = new StringColumn(B);
        this.n = stringColumn;
        this.o = new Column[]{this.f2276b, this.f2277c, this.f2278d, this.f2279e, this.f2280f, this.f2281g, this.f2282h, this.f2283i, this.f2284j, this.k, this.l, this.m, stringColumn};
    }

    @Override // c.a.b0.c0.j
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (Column[]) invokeV.objValue;
    }

    @Override // c.a.b0.c0.j
    public c.a.b0.c0.b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? C : (c.a.b0.c0.b[]) invokeV.objValue;
    }

    @Override // c.a.b0.c0.j
    public c.a.b0.c0.b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? D : (c.a.b0.c0.b[]) invokeV.objValue;
    }

    @Override // c.a.b0.c0.j
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "t_apk_info" : (String) invokeV.objValue;
    }
}
