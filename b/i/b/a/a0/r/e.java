package b.i.b.a.a0.r;

import b.i.b.a.i0.l;
import b.i.b.a.i0.v;
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
    public static final int f31595i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f31596a;

    /* renamed from: b  reason: collision with root package name */
    public int f31597b;

    /* renamed from: c  reason: collision with root package name */
    public long f31598c;

    /* renamed from: d  reason: collision with root package name */
    public int f31599d;

    /* renamed from: e  reason: collision with root package name */
    public int f31600e;

    /* renamed from: f  reason: collision with root package name */
    public int f31601f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f31602g;

    /* renamed from: h  reason: collision with root package name */
    public final l f31603h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1952643367, "Lb/i/b/a/a0/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1952643367, "Lb/i/b/a/a0/r/e;");
                return;
            }
        }
        f31595i = v.q("OggS");
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
        this.f31602g = new int[255];
        this.f31603h = new l(255);
    }

    public boolean a(b.i.b.a.a0.f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, fVar, z)) == null) {
            this.f31603h.F();
            b();
            if ((fVar.getLength() == -1 || fVar.getLength() - fVar.f() >= 27) && fVar.d(this.f31603h.f32635a, 0, 27, true)) {
                if (this.f31603h.z() != f31595i) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("expected OggS capture pattern at begin of page");
                } else {
                    int x = this.f31603h.x();
                    this.f31596a = x;
                    if (x != 0) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("unsupported bit stream revision");
                    }
                    this.f31597b = this.f31603h.x();
                    this.f31598c = this.f31603h.m();
                    this.f31603h.n();
                    this.f31603h.n();
                    this.f31603h.n();
                    int x2 = this.f31603h.x();
                    this.f31599d = x2;
                    this.f31600e = x2 + 27;
                    this.f31603h.F();
                    fVar.c(this.f31603h.f32635a, 0, this.f31599d);
                    for (int i2 = 0; i2 < this.f31599d; i2++) {
                        this.f31602g[i2] = this.f31603h.x();
                        this.f31601f += this.f31602g[i2];
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
            this.f31596a = 0;
            this.f31597b = 0;
            this.f31598c = 0L;
            this.f31599d = 0;
            this.f31600e = 0;
            this.f31601f = 0;
        }
    }
}
