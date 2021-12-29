package c.i.b.a.a0.r;

import c.i.b.a.i0.l;
import c.i.b.a.i0.v;
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
/* loaded from: classes9.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f29673i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f29674b;

    /* renamed from: c  reason: collision with root package name */
    public long f29675c;

    /* renamed from: d  reason: collision with root package name */
    public int f29676d;

    /* renamed from: e  reason: collision with root package name */
    public int f29677e;

    /* renamed from: f  reason: collision with root package name */
    public int f29678f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f29679g;

    /* renamed from: h  reason: collision with root package name */
    public final l f29680h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445091558, "Lc/i/b/a/a0/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445091558, "Lc/i/b/a/a0/r/e;");
                return;
            }
        }
        f29673i = v.q("OggS");
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
        this.f29679g = new int[255];
        this.f29680h = new l(255);
    }

    public boolean a(c.i.b.a.a0.f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, fVar, z)) == null) {
            this.f29680h.F();
            b();
            if ((fVar.getLength() == -1 || fVar.getLength() - fVar.f() >= 27) && fVar.d(this.f29680h.a, 0, 27, true)) {
                if (this.f29680h.z() != f29673i) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("expected OggS capture pattern at begin of page");
                } else {
                    int x = this.f29680h.x();
                    this.a = x;
                    if (x != 0) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("unsupported bit stream revision");
                    }
                    this.f29674b = this.f29680h.x();
                    this.f29675c = this.f29680h.m();
                    this.f29680h.n();
                    this.f29680h.n();
                    this.f29680h.n();
                    int x2 = this.f29680h.x();
                    this.f29676d = x2;
                    this.f29677e = x2 + 27;
                    this.f29680h.F();
                    fVar.c(this.f29680h.a, 0, this.f29676d);
                    for (int i2 = 0; i2 < this.f29676d; i2++) {
                        this.f29679g[i2] = this.f29680h.x();
                        this.f29678f += this.f29679g[i2];
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
            this.a = 0;
            this.f29674b = 0;
            this.f29675c = 0L;
            this.f29676d = 0;
            this.f29677e = 0;
            this.f29678f = 0;
        }
    }
}
