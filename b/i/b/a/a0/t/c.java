package b.i.b.a.a0.t;

import b.i.b.a.a0.l;
import b.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class c implements b.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f31653e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f31654a;

    /* renamed from: b  reason: collision with root package name */
    public final d f31655b;

    /* renamed from: c  reason: collision with root package name */
    public final b.i.b.a.i0.l f31656c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31657d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1952583847, "Lb/i/b/a/a0/t/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1952583847, "Lb/i/b/a/a0/t/c;");
                return;
            }
        }
        f31653e = b.i.b.a.i0.v.q("ID3");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c() {
        this(0L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.i.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f31657d = false;
            this.f31655b.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
        r11.e();
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
        if ((r5 - r4) < 8192) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
        return false;
     */
    @Override // b.i.b.a.a0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        b.i.b.a.i0.l lVar = new b.i.b.a.i0.l(10);
        b.i.b.a.i0.k kVar = new b.i.b.a.i0.k(lVar.f32635a);
        int i2 = 0;
        while (true) {
            fVar.c(lVar.f32635a, 0, 10);
            lVar.J(0);
            if (lVar.A() != f31653e) {
                break;
            }
            lVar.K(3);
            int w = lVar.w();
            i2 += w + 10;
            fVar.g(w);
        }
        fVar.e();
        fVar.g(i2);
        int i3 = i2;
        while (true) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                fVar.c(lVar.f32635a, 0, 2);
                lVar.J(0);
                if ((lVar.D() & 65526) != 65520) {
                    break;
                }
                i4++;
                if (i4 >= 4 && i5 > 188) {
                    return true;
                }
                fVar.c(lVar.f32635a, 0, 4);
                kVar.l(14);
                int g2 = kVar.g(13);
                if (g2 <= 6) {
                    return false;
                }
                fVar.g(g2 - 6);
                i5 += g2;
            }
            fVar.g(i3);
        }
    }

    @Override // b.i.b.a.a0.e
    public int e(b.i.b.a.a0.f fVar, b.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, kVar)) == null) {
            int read = fVar.read(this.f31656c.f32635a, 0, 200);
            if (read == -1) {
                return -1;
            }
            this.f31656c.J(0);
            this.f31656c.I(read);
            if (!this.f31657d) {
                this.f31655b.e(this.f31654a, true);
                this.f31657d = true;
            }
            this.f31655b.c(this.f31656c);
            return 0;
        }
        return invokeLL.intValue;
    }

    @Override // b.i.b.a.a0.e
    public void f(b.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.f31655b.f(gVar, new w.d(0, 1));
            gVar.j();
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // b.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f31654a = j;
        this.f31655b = new d(true);
        this.f31656c = new b.i.b.a.i0.l(200);
    }
}
