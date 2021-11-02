package b.i.b.a.a0.r;

import b.i.b.a.a0.m;
import b.i.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
/* loaded from: classes6.dex */
public class c implements b.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.i.b.a.a0.g f31587a;

    /* renamed from: b  reason: collision with root package name */
    public h f31588b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31589c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1952643429, "Lb/i/b/a/a0/r/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1952643429, "Lb/i/b/a/a0/r/c;");
        }
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
            }
        }
    }

    public static l b(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) {
            lVar.J(0);
            return lVar;
        }
        return (l) invokeL.objValue;
    }

    @Override // b.i.b.a.a0.e
    public void a(long j, long j2) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (hVar = this.f31588b) == null) {
            return;
        }
        hVar.k(j, j2);
    }

    public final boolean c(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            e eVar = new e();
            if (eVar.a(fVar, true) && (eVar.f31597b & 2) == 2) {
                int min = Math.min(eVar.f31601f, 8);
                l lVar = new l(min);
                fVar.c(lVar.f32635a, 0, min);
                b(lVar);
                if (b.o(lVar)) {
                    this.f31588b = new b();
                } else {
                    b(lVar);
                    if (j.p(lVar)) {
                        this.f31588b = new j();
                    } else {
                        b(lVar);
                        if (g.n(lVar)) {
                            this.f31588b = new g();
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.i.b.a.a0.e
    public boolean d(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            try {
                return c(fVar);
            } catch (ParserException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // b.i.b.a.a0.e
    public int e(b.i.b.a.a0.f fVar, b.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fVar, kVar)) == null) {
            if (this.f31588b == null) {
                if (c(fVar)) {
                    fVar.e();
                } else {
                    throw new ParserException("Failed to determine bitstream type");
                }
            }
            if (!this.f31589c) {
                m a2 = this.f31587a.a(0, 1);
                this.f31587a.j();
                this.f31588b.c(this.f31587a, a2);
                this.f31589c = true;
            }
            return this.f31588b.f(fVar, kVar);
        }
        return invokeLL.intValue;
    }

    @Override // b.i.b.a.a0.e
    public void f(b.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.f31587a = gVar;
        }
    }

    @Override // b.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }
}
