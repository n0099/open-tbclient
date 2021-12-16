package c.i.b.a.a0;

import c.i.b.a.a0.t.q;
import c.i.b.a.a0.t.v;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
/* loaded from: classes9.dex */
public final class c implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final Constructor<? extends e> f29373g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f29374b;

    /* renamed from: c  reason: collision with root package name */
    public int f29375c;

    /* renamed from: d  reason: collision with root package name */
    public int f29376d;

    /* renamed from: e  reason: collision with root package name */
    public int f29377e;

    /* renamed from: f  reason: collision with root package name */
    public int f29378f;

    static {
        Constructor<? extends e> constructor;
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-724485153, "Lc/i/b/a/a0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-724485153, "Lc/i/b/a/a0/c;");
                return;
            }
        }
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        f29373g = constructor;
    }

    public c() {
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
        this.f29377e = 1;
    }

    @Override // c.i.b.a.a0.h
    public synchronized e[] a() {
        InterceptResult invokeV;
        e[] eVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                eVarArr = new e[f29373g == null ? 11 : 12];
                eVarArr[0] = new c.i.b.a.a0.o.d(this.a);
                eVarArr[1] = new c.i.b.a.a0.q.e(this.f29375c);
                eVarArr[2] = new c.i.b.a.a0.q.g(this.f29374b);
                eVarArr[3] = new c.i.b.a.a0.p.b(this.f29376d);
                eVarArr[4] = new c.i.b.a.a0.t.c();
                eVarArr[5] = new c.i.b.a.a0.t.a();
                eVarArr[6] = new v(this.f29377e, this.f29378f);
                eVarArr[7] = new c.i.b.a.a0.n.b();
                eVarArr[8] = new c.i.b.a.a0.r.c();
                eVarArr[9] = new q();
                eVarArr[10] = new c.i.b.a.a0.u.a();
                if (f29373g != null) {
                    try {
                        eVarArr[11] = f29373g.newInstance(new Object[0]);
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                }
            }
            return eVarArr;
        }
        return (e[]) invokeV.objValue;
    }
}
