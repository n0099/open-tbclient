package c.i.b.a.a0.t;

import c.i.b.a.a0.l;
import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class a implements c.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f32746e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f32747a;

    /* renamed from: b  reason: collision with root package name */
    public final b f32748b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.l f32749c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32750d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445032100, "Lc/i/b/a/a0/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445032100, "Lc/i/b/a/a0/t/a;");
                return;
            }
        }
        f32746e = c.i.b.a.i0.v.q("ID3");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
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

    @Override // c.i.b.a.a0.e
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f32750d = false;
            this.f32748b.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
        r8.e();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        if ((r4 - r3) < 8192) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        return false;
     */
    @Override // c.i.b.a.a0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(10);
        int i2 = 0;
        while (true) {
            fVar.c(lVar.f33812a, 0, 10);
            lVar.J(0);
            if (lVar.A() != f32746e) {
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
            while (true) {
                fVar.c(lVar.f33812a, 0, 5);
                lVar.J(0);
                if (lVar.D() != 2935) {
                    break;
                }
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                int e2 = c.i.b.a.x.a.e(lVar.f33812a);
                if (e2 == -1) {
                    return false;
                }
                fVar.g(e2 - 5);
            }
            fVar.g(i3);
        }
    }

    @Override // c.i.b.a.a0.e
    public int e(c.i.b.a.a0.f fVar, c.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, kVar)) == null) {
            int read = fVar.read(this.f32749c.f33812a, 0, 2786);
            if (read == -1) {
                return -1;
            }
            this.f32749c.J(0);
            this.f32749c.I(read);
            if (!this.f32750d) {
                this.f32748b.e(this.f32747a, true);
                this.f32750d = true;
            }
            this.f32748b.c(this.f32749c);
            return 0;
        }
        return invokeLL.intValue;
    }

    @Override // c.i.b.a.a0.e
    public void f(c.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.f32748b.f(gVar, new w.d(0, 1));
            gVar.j();
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // c.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f32747a = j2;
        this.f32748b = new b();
        this.f32749c = new c.i.b.a.i0.l(2786);
    }
}
