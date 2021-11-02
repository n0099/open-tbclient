package b.i.b.a.a0.s;

import b.i.b.a.a0.e;
import b.i.b.a.a0.f;
import b.i.b.a.a0.g;
import b.i.b.a.a0.k;
import b.i.b.a.a0.l;
import b.i.b.a.a0.m;
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
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class a implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f31630i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Format f31631a;

    /* renamed from: b  reason: collision with root package name */
    public final l f31632b;

    /* renamed from: c  reason: collision with root package name */
    public m f31633c;

    /* renamed from: d  reason: collision with root package name */
    public int f31634d;

    /* renamed from: e  reason: collision with root package name */
    public int f31635e;

    /* renamed from: f  reason: collision with root package name */
    public long f31636f;

    /* renamed from: g  reason: collision with root package name */
    public int f31637g;

    /* renamed from: h  reason: collision with root package name */
    public int f31638h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1952613700, "Lb/i/b/a/a0/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1952613700, "Lb/i/b/a/a0/s/a;");
                return;
            }
        }
        f31630i = v.q("RCC\u0001");
    }

    public a(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {format};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31631a = format;
        this.f31632b = new l(9);
        this.f31634d = 0;
    }

    @Override // b.i.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f31634d = 0;
        }
    }

    public final boolean b(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            this.f31632b.F();
            if (fVar.a(this.f31632b.f32635a, 0, 8, true)) {
                if (this.f31632b.i() == f31630i) {
                    this.f31635e = this.f31632b.x();
                    return true;
                }
                throw new IOException("Input not RawCC");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void c(f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            while (this.f31637g > 0) {
                this.f31632b.F();
                fVar.readFully(this.f31632b.f32635a, 0, 3);
                this.f31633c.a(this.f31632b, 3);
                this.f31638h += 3;
                this.f31637g--;
            }
            int i2 = this.f31638h;
            if (i2 > 0) {
                this.f31633c.c(this.f31636f, 1, i2, 0, null);
            }
        }
    }

    @Override // b.i.b.a.a0.e
    public boolean d(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f31632b.F();
            fVar.c(this.f31632b.f32635a, 0, 8);
            return this.f31632b.i() == f31630i;
        }
        return invokeL.booleanValue;
    }

    @Override // b.i.b.a.a0.e
    public int e(f fVar, k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.f31634d;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        c(fVar);
                        this.f31634d = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (g(fVar)) {
                    this.f31634d = 2;
                } else {
                    this.f31634d = 0;
                    return -1;
                }
            } else if (!b(fVar)) {
                return -1;
            } else {
                this.f31634d = 1;
            }
        }
    }

    @Override // b.i.b.a.a0.e
    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            gVar.p(new l.a(-9223372036854775807L));
            this.f31633c = gVar.a(0, 3);
            gVar.j();
            this.f31633c.b(this.f31631a);
        }
    }

    public final boolean g(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
            this.f31632b.F();
            int i2 = this.f31635e;
            if (i2 == 0) {
                if (!fVar.a(this.f31632b.f32635a, 0, 5, true)) {
                    return false;
                }
                this.f31636f = (this.f31632b.z() * 1000) / 45;
            } else if (i2 == 1) {
                if (!fVar.a(this.f31632b.f32635a, 0, 9, true)) {
                    return false;
                }
                this.f31636f = this.f31632b.q();
            } else {
                throw new ParserException("Unsupported version number: " + this.f31635e);
            }
            this.f31637g = this.f31632b.x();
            this.f31638h = 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // b.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
