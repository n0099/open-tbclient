package c.i.b.a.a0.s;

import c.i.b.a.a0.e;
import c.i.b.a.a0.f;
import c.i.b.a.a0.g;
import c.i.b.a.a0.k;
import c.i.b.a.a0.l;
import c.i.b.a.a0.m;
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
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class a implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f29625i;
    public transient /* synthetic */ FieldHolder $fh;
    public final Format a;

    /* renamed from: b  reason: collision with root package name */
    public final l f29626b;

    /* renamed from: c  reason: collision with root package name */
    public m f29627c;

    /* renamed from: d  reason: collision with root package name */
    public int f29628d;

    /* renamed from: e  reason: collision with root package name */
    public int f29629e;

    /* renamed from: f  reason: collision with root package name */
    public long f29630f;

    /* renamed from: g  reason: collision with root package name */
    public int f29631g;

    /* renamed from: h  reason: collision with root package name */
    public int f29632h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445061891, "Lc/i/b/a/a0/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445061891, "Lc/i/b/a/a0/s/a;");
                return;
            }
        }
        f29625i = v.q("RCC\u0001");
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
        this.a = format;
        this.f29626b = new l(9);
        this.f29628d = 0;
    }

    @Override // c.i.b.a.a0.e
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f29628d = 0;
        }
    }

    public final boolean b(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            this.f29626b.F();
            if (fVar.a(this.f29626b.a, 0, 8, true)) {
                if (this.f29626b.i() == f29625i) {
                    this.f29629e = this.f29626b.x();
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
            while (this.f29631g > 0) {
                this.f29626b.F();
                fVar.readFully(this.f29626b.a, 0, 3);
                this.f29627c.a(this.f29626b, 3);
                this.f29632h += 3;
                this.f29631g--;
            }
            int i2 = this.f29632h;
            if (i2 > 0) {
                this.f29627c.c(this.f29630f, 1, i2, 0, null);
            }
        }
    }

    @Override // c.i.b.a.a0.e
    public boolean d(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f29626b.F();
            fVar.c(this.f29626b.a, 0, 8);
            return this.f29626b.i() == f29625i;
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public int e(f fVar, k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.f29628d;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        c(fVar);
                        this.f29628d = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (g(fVar)) {
                    this.f29628d = 2;
                } else {
                    this.f29628d = 0;
                    return -1;
                }
            } else if (!b(fVar)) {
                return -1;
            } else {
                this.f29628d = 1;
            }
        }
    }

    @Override // c.i.b.a.a0.e
    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            gVar.p(new l.a(-9223372036854775807L));
            this.f29627c = gVar.a(0, 3);
            gVar.j();
            this.f29627c.b(this.a);
        }
    }

    public final boolean g(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
            this.f29626b.F();
            int i2 = this.f29629e;
            if (i2 == 0) {
                if (!fVar.a(this.f29626b.a, 0, 5, true)) {
                    return false;
                }
                this.f29630f = (this.f29626b.z() * 1000) / 45;
            } else if (i2 == 1) {
                if (!fVar.a(this.f29626b.a, 0, 9, true)) {
                    return false;
                }
                this.f29630f = this.f29626b.q();
            } else {
                throw new ParserException("Unsupported version number: " + this.f29629e);
            }
            this.f29631g = this.f29626b.x();
            this.f29632h = 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
