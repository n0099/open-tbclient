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
    public static final int f32486i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f32487a;

    /* renamed from: b  reason: collision with root package name */
    public int f32488b;

    /* renamed from: c  reason: collision with root package name */
    public long f32489c;

    /* renamed from: d  reason: collision with root package name */
    public int f32490d;

    /* renamed from: e  reason: collision with root package name */
    public int f32491e;

    /* renamed from: f  reason: collision with root package name */
    public int f32492f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f32493g;

    /* renamed from: h  reason: collision with root package name */
    public final l f32494h;

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
        f32486i = v.q("OggS");
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
        this.f32493g = new int[255];
        this.f32494h = new l(255);
    }

    public boolean a(c.i.b.a.a0.f fVar, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, fVar, z)) == null) {
            this.f32494h.F();
            b();
            if ((fVar.getLength() == -1 || fVar.getLength() - fVar.f() >= 27) && fVar.d(this.f32494h.f33597a, 0, 27, true)) {
                if (this.f32494h.z() != f32486i) {
                    if (z) {
                        return false;
                    }
                    throw new ParserException("expected OggS capture pattern at begin of page");
                } else {
                    int x = this.f32494h.x();
                    this.f32487a = x;
                    if (x != 0) {
                        if (z) {
                            return false;
                        }
                        throw new ParserException("unsupported bit stream revision");
                    }
                    this.f32488b = this.f32494h.x();
                    this.f32489c = this.f32494h.m();
                    this.f32494h.n();
                    this.f32494h.n();
                    this.f32494h.n();
                    int x2 = this.f32494h.x();
                    this.f32490d = x2;
                    this.f32491e = x2 + 27;
                    this.f32494h.F();
                    fVar.c(this.f32494h.f33597a, 0, this.f32490d);
                    for (int i2 = 0; i2 < this.f32490d; i2++) {
                        this.f32493g[i2] = this.f32494h.x();
                        this.f32492f += this.f32493g[i2];
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
            this.f32487a = 0;
            this.f32488b = 0;
            this.f32489c = 0L;
            this.f32490d = 0;
            this.f32491e = 0;
            this.f32492f = 0;
        }
    }
}
