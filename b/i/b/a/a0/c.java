package b.i.b.a.a0;

import b.i.b.a.a0.t.q;
import b.i.b.a.a0.t.v;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public final class c implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final Constructor<? extends e> f31353g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f31354a;

    /* renamed from: b  reason: collision with root package name */
    public int f31355b;

    /* renamed from: c  reason: collision with root package name */
    public int f31356c;

    /* renamed from: d  reason: collision with root package name */
    public int f31357d;

    /* renamed from: e  reason: collision with root package name */
    public int f31358e;

    /* renamed from: f  reason: collision with root package name */
    public int f31359f;

    static {
        Constructor<? extends e> constructor;
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-431082146, "Lb/i/b/a/a0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-431082146, "Lb/i/b/a/a0/c;");
                return;
            }
        }
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        f31353g = constructor;
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
        this.f31358e = 1;
    }

    @Override // b.i.b.a.a0.h
    public synchronized e[] a() {
        InterceptResult invokeV;
        e[] eVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                eVarArr = new e[f31353g == null ? 11 : 12];
                eVarArr[0] = new b.i.b.a.a0.o.d(this.f31354a);
                eVarArr[1] = new b.i.b.a.a0.q.e(this.f31356c);
                eVarArr[2] = new b.i.b.a.a0.q.g(this.f31355b);
                eVarArr[3] = new b.i.b.a.a0.p.b(this.f31357d);
                eVarArr[4] = new b.i.b.a.a0.t.c();
                eVarArr[5] = new b.i.b.a.a0.t.a();
                eVarArr[6] = new v(this.f31358e, this.f31359f);
                eVarArr[7] = new b.i.b.a.a0.n.b();
                eVarArr[8] = new b.i.b.a.a0.r.c();
                eVarArr[9] = new q();
                eVarArr[10] = new b.i.b.a.a0.u.a();
                if (f31353g != null) {
                    try {
                        eVarArr[11] = f31353g.newInstance(new Object[0]);
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
