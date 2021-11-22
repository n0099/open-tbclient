package b.h.b.a.a0.r;

import b.h.b.a.i0.l;
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f32453i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f32454a;

    /* renamed from: b  reason: collision with root package name */
    public int f32455b;

    /* renamed from: c  reason: collision with root package name */
    public long f32456c;

    /* renamed from: d  reason: collision with root package name */
    public int f32457d;

    /* renamed from: e  reason: collision with root package name */
    public int f32458e;

    /* renamed from: f  reason: collision with root package name */
    public int f32459f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f32460g;

    /* renamed from: h  reason: collision with root package name */
    public final l f32461h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1659240360, "Lb/h/b/a/a0/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1659240360, "Lb/h/b/a/a0/r/e;");
                return;
            }
        }
        f32453i = v.q("OggS");
    }

    public e() {
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
        this.f32460g = new int[255];
        this.f32461h = new l(255);
    }

    public boolean a(b.h.b.a.a0.f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, fVar, z)) == null) {
            this.f32461h.F();
            b();
            if ((fVar.getLength() == -1 || fVar.getLength() - fVar.f() >= 27) && fVar.d(this.f32461h.f33493a, 0, 27, true)) {
                if (this.f32461h.z() != f32453i) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("expected OggS capture pattern at begin of page");
                } else {
                    int x = this.f32461h.x();
                    this.f32454a = x;
                    if (x != 0) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("unsupported bit stream revision");
                    }
                    this.f32455b = this.f32461h.x();
                    this.f32456c = this.f32461h.m();
                    this.f32461h.n();
                    this.f32461h.n();
                    this.f32461h.n();
                    int x2 = this.f32461h.x();
                    this.f32457d = x2;
                    this.f32458e = x2 + 27;
                    this.f32461h.F();
                    fVar.c(this.f32461h.f33493a, 0, this.f32457d);
                    for (int i2 = 0; i2 < this.f32457d; i2++) {
                        this.f32460g[i2] = this.f32461h.x();
                        this.f32459f += this.f32460g[i2];
                    }
                    return true;
                }
            }
            if (z) {
                return false;
            }
            throw new EOFException();
        }
        return invokeLZ.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32454a = 0;
            this.f32455b = 0;
            this.f32456c = 0L;
            this.f32457d = 0;
            this.f32458e = 0;
            this.f32459f = 0;
        }
    }
}
