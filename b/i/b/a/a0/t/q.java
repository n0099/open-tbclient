package b.i.b.a.a0.t;

import android.util.SparseArray;
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
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class q implements b.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.i.b.a.i0.s f31781a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f31782b;

    /* renamed from: c  reason: collision with root package name */
    public final b.i.b.a.i0.l f31783c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31784d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31785e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31786f;

    /* renamed from: g  reason: collision with root package name */
    public b.i.b.a.a0.g f31787g;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final h f31788a;

        /* renamed from: b  reason: collision with root package name */
        public final b.i.b.a.i0.s f31789b;

        /* renamed from: c  reason: collision with root package name */
        public final b.i.b.a.i0.k f31790c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31791d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f31792e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31793f;

        /* renamed from: g  reason: collision with root package name */
        public int f31794g;

        /* renamed from: h  reason: collision with root package name */
        public long f31795h;

        public a(h hVar, b.i.b.a.i0.s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31788a = hVar;
            this.f31789b = sVar;
            this.f31790c = new b.i.b.a.i0.k(new byte[64]);
        }

        public void a(b.i.b.a.i0.l lVar) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
                lVar.g(this.f31790c.f32631a, 0, 3);
                this.f31790c.l(0);
                b();
                lVar.g(this.f31790c.f32631a, 0, this.f31794g);
                this.f31790c.l(0);
                c();
                this.f31788a.e(this.f31795h, true);
                this.f31788a.c(lVar);
                this.f31788a.d();
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f31790c.n(8);
                this.f31791d = this.f31790c.f();
                this.f31792e = this.f31790c.f();
                this.f31790c.n(6);
                this.f31794g = this.f31790c.g(8);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f31795h = 0L;
                if (this.f31791d) {
                    this.f31790c.n(4);
                    this.f31790c.n(1);
                    this.f31790c.n(1);
                    long g2 = (this.f31790c.g(3) << 30) | (this.f31790c.g(15) << 15) | this.f31790c.g(15);
                    this.f31790c.n(1);
                    if (!this.f31793f && this.f31792e) {
                        this.f31790c.n(4);
                        this.f31790c.n(1);
                        this.f31790c.n(1);
                        this.f31790c.n(1);
                        this.f31789b.b((this.f31790c.g(3) << 30) | (this.f31790c.g(15) << 15) | this.f31790c.g(15));
                        this.f31793f = true;
                    }
                    this.f31795h = this.f31789b.b(g2);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f31793f = false;
                this.f31788a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1952583413, "Lb/i/b/a/a0/t/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1952583413, "Lb/i/b/a/a0/t/q;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q() {
        this(new b.i.b.a.i0.s(0L));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((b.i.b.a.i0.s) newInitContext.callArgs[0]);
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
            this.f31781a.g();
            for (int i2 = 0; i2 < this.f31782b.size(); i2++) {
                this.f31782b.valueAt(i2).d();
            }
        }
    }

    @Override // b.i.b.a.a0.e
    public boolean d(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            byte[] bArr = new byte[14];
            fVar.c(bArr, 0, 14);
            if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
                fVar.g(bArr[13] & 7);
                fVar.c(bArr, 0, 3);
                return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.i.b.a.a0.e
    public int e(b.i.b.a.a0.f fVar, b.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, kVar)) == null) {
            if (fVar.d(this.f31783c.f32635a, 0, 4, true)) {
                this.f31783c.J(0);
                int i2 = this.f31783c.i();
                if (i2 == 441) {
                    return -1;
                }
                if (i2 == 442) {
                    fVar.c(this.f31783c.f32635a, 0, 10);
                    this.f31783c.J(9);
                    fVar.h((this.f31783c.x() & 7) + 14);
                    return 0;
                } else if (i2 == 443) {
                    fVar.c(this.f31783c.f32635a, 0, 2);
                    this.f31783c.J(0);
                    fVar.h(this.f31783c.D() + 6);
                    return 0;
                } else if (((i2 & (-256)) >> 8) != 1) {
                    fVar.h(1);
                    return 0;
                } else {
                    int i3 = i2 & 255;
                    a aVar = this.f31782b.get(i3);
                    if (!this.f31784d) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.f31785e && i3 == 189) {
                                hVar = new b();
                                this.f31785e = true;
                            } else if (!this.f31785e && (i3 & 224) == 192) {
                                hVar = new n();
                                this.f31785e = true;
                            } else if (!this.f31786f && (i3 & 240) == 224) {
                                hVar = new i();
                                this.f31786f = true;
                            }
                            if (hVar != null) {
                                hVar.f(this.f31787g, new w.d(i3, 256));
                                aVar = new a(hVar, this.f31781a);
                                this.f31782b.put(i3, aVar);
                            }
                        }
                        if ((this.f31785e && this.f31786f) || fVar.getPosition() > 1048576) {
                            this.f31784d = true;
                            this.f31787g.j();
                        }
                    }
                    fVar.c(this.f31783c.f32635a, 0, 2);
                    this.f31783c.J(0);
                    int D = this.f31783c.D() + 6;
                    if (aVar == null) {
                        fVar.h(D);
                    } else {
                        this.f31783c.G(D);
                        fVar.readFully(this.f31783c.f32635a, 0, D);
                        this.f31783c.J(6);
                        aVar.a(this.f31783c);
                        b.i.b.a.i0.l lVar = this.f31783c;
                        lVar.I(lVar.b());
                    }
                    return 0;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // b.i.b.a.a0.e
    public void f(b.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.f31787g = gVar;
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // b.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public q(b.i.b.a.i0.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f31781a = sVar;
        this.f31783c = new b.i.b.a.i0.l(4096);
        this.f31782b = new SparseArray<>();
    }
}
