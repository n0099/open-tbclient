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
/* loaded from: classes4.dex */
public final class a implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f32522i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Format f32523a;

    /* renamed from: b  reason: collision with root package name */
    public final l f32524b;

    /* renamed from: c  reason: collision with root package name */
    public m f32525c;

    /* renamed from: d  reason: collision with root package name */
    public int f32526d;

    /* renamed from: e  reason: collision with root package name */
    public int f32527e;

    /* renamed from: f  reason: collision with root package name */
    public long f32528f;

    /* renamed from: g  reason: collision with root package name */
    public int f32529g;

    /* renamed from: h  reason: collision with root package name */
    public int f32530h;

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
        f32522i = v.q("RCC\u0001");
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
        this.f32523a = format;
        this.f32524b = new l(9);
        this.f32526d = 0;
    }

    @Override // c.i.b.a.a0.e
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f32526d = 0;
        }
    }

    public final boolean b(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            this.f32524b.F();
            if (fVar.a(this.f32524b.f33597a, 0, 8, true)) {
                if (this.f32524b.i() == f32522i) {
                    this.f32527e = this.f32524b.x();
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
            while (this.f32529g > 0) {
                this.f32524b.F();
                fVar.readFully(this.f32524b.f33597a, 0, 3);
                this.f32525c.a(this.f32524b, 3);
                this.f32530h += 3;
                this.f32529g--;
            }
            int i2 = this.f32530h;
            if (i2 > 0) {
                this.f32525c.c(this.f32528f, 1, i2, 0, null);
            }
        }
    }

    @Override // c.i.b.a.a0.e
    public boolean d(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f32524b.F();
            fVar.c(this.f32524b.f33597a, 0, 8);
            return this.f32524b.i() == f32522i;
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
            int i2 = this.f32526d;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        c(fVar);
                        this.f32526d = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (g(fVar)) {
                    this.f32526d = 2;
                } else {
                    this.f32526d = 0;
                    return -1;
                }
            } else if (!b(fVar)) {
                return -1;
            } else {
                this.f32526d = 1;
            }
        }
    }

    @Override // c.i.b.a.a0.e
    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            gVar.p(new l.a(-9223372036854775807L));
            this.f32525c = gVar.a(0, 3);
            gVar.j();
            this.f32525c.b(this.f32523a);
        }
    }

    public final boolean g(f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
            this.f32524b.F();
            int i2 = this.f32527e;
            if (i2 == 0) {
                if (!fVar.a(this.f32524b.f33597a, 0, 5, true)) {
                    return false;
                }
                this.f32528f = (this.f32524b.z() * 1000) / 45;
            } else if (i2 == 1) {
                if (!fVar.a(this.f32524b.f33597a, 0, 9, true)) {
                    return false;
                }
                this.f32528f = this.f32524b.q();
            } else {
                throw new ParserException("Unsupported version number: " + this.f32527e);
            }
            this.f32529g = this.f32524b.x();
            this.f32530h = 0;
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
