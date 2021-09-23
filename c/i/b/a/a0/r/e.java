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
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f32724i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f32725a;

    /* renamed from: b  reason: collision with root package name */
    public int f32726b;

    /* renamed from: c  reason: collision with root package name */
    public long f32727c;

    /* renamed from: d  reason: collision with root package name */
    public int f32728d;

    /* renamed from: e  reason: collision with root package name */
    public int f32729e;

    /* renamed from: f  reason: collision with root package name */
    public int f32730f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f32731g;

    /* renamed from: h  reason: collision with root package name */
    public final l f32732h;

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
        f32724i = v.q("OggS");
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
        this.f32731g = new int[255];
        this.f32732h = new l(255);
    }

    public boolean a(c.i.b.a.a0.f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, fVar, z)) == null) {
            this.f32732h.F();
            b();
            if ((fVar.getLength() == -1 || fVar.getLength() - fVar.f() >= 27) && fVar.d(this.f32732h.f33835a, 0, 27, true)) {
                if (this.f32732h.z() != f32724i) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("expected OggS capture pattern at begin of page");
                } else {
                    int x = this.f32732h.x();
                    this.f32725a = x;
                    if (x != 0) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("unsupported bit stream revision");
                    }
                    this.f32726b = this.f32732h.x();
                    this.f32727c = this.f32732h.m();
                    this.f32732h.n();
                    this.f32732h.n();
                    this.f32732h.n();
                    int x2 = this.f32732h.x();
                    this.f32728d = x2;
                    this.f32729e = x2 + 27;
                    this.f32732h.F();
                    fVar.c(this.f32732h.f33835a, 0, this.f32728d);
                    for (int i2 = 0; i2 < this.f32728d; i2++) {
                        this.f32731g[i2] = this.f32732h.x();
                        this.f32730f += this.f32731g[i2];
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
            this.f32725a = 0;
            this.f32726b = 0;
            this.f32727c = 0L;
            this.f32728d = 0;
            this.f32729e = 0;
            this.f32730f = 0;
        }
    }
}
