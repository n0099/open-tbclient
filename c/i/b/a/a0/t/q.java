package c.i.b.a.a0.t;

import android.util.SparseArray;
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
import com.google.android.exoplayer2.ParserException;
import com.kuaishou.weapon.un.w0;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class q implements c.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.i.b.a.i0.s a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f29171b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.l f29172c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29173d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29174e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29175f;

    /* renamed from: g  reason: collision with root package name */
    public c.i.b.a.a0.g f29176g;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final h a;

        /* renamed from: b  reason: collision with root package name */
        public final c.i.b.a.i0.s f29177b;

        /* renamed from: c  reason: collision with root package name */
        public final c.i.b.a.i0.k f29178c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f29179d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f29180e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29181f;

        /* renamed from: g  reason: collision with root package name */
        public int f29182g;

        /* renamed from: h  reason: collision with root package name */
        public long f29183h;

        public a(h hVar, c.i.b.a.i0.s sVar) {
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
            this.a = hVar;
            this.f29177b = sVar;
            this.f29178c = new c.i.b.a.i0.k(new byte[64]);
        }

        public void a(c.i.b.a.i0.l lVar) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
                lVar.g(this.f29178c.a, 0, 3);
                this.f29178c.l(0);
                b();
                lVar.g(this.f29178c.a, 0, this.f29182g);
                this.f29178c.l(0);
                c();
                this.a.e(this.f29183h, true);
                this.a.c(lVar);
                this.a.d();
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f29178c.n(8);
                this.f29179d = this.f29178c.f();
                this.f29180e = this.f29178c.f();
                this.f29178c.n(6);
                this.f29182g = this.f29178c.g(8);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f29183h = 0L;
                if (this.f29179d) {
                    this.f29178c.n(4);
                    this.f29178c.n(1);
                    this.f29178c.n(1);
                    long g2 = (this.f29178c.g(3) << 30) | (this.f29178c.g(15) << 15) | this.f29178c.g(15);
                    this.f29178c.n(1);
                    if (!this.f29181f && this.f29180e) {
                        this.f29178c.n(4);
                        this.f29178c.n(1);
                        this.f29178c.n(1);
                        this.f29178c.n(1);
                        this.f29177b.b((this.f29178c.g(3) << 30) | (this.f29178c.g(15) << 15) | this.f29178c.g(15));
                        this.f29181f = true;
                    }
                    this.f29183h = this.f29177b.b(g2);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f29181f = false;
                this.a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-445031604, "Lc/i/b/a/a0/t/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-445031604, "Lc/i/b/a/a0/t/q;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q() {
        this(new c.i.b.a.i0.s(0L));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((c.i.b.a.i0.s) newInitContext.callArgs[0]);
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
            this.a.g();
            for (int i2 = 0; i2 < this.f29171b.size(); i2++) {
                this.f29171b.valueAt(i2).d();
            }
        }
    }

    @Override // c.i.b.a.a0.e
    public boolean d(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
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

    @Override // c.i.b.a.a0.e
    public int e(c.i.b.a.a0.f fVar, c.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, kVar)) == null) {
            if (fVar.d(this.f29172c.a, 0, 4, true)) {
                this.f29172c.J(0);
                int i2 = this.f29172c.i();
                if (i2 == 441) {
                    return -1;
                }
                if (i2 == 442) {
                    fVar.c(this.f29172c.a, 0, 10);
                    this.f29172c.J(9);
                    fVar.h((this.f29172c.x() & 7) + 14);
                    return 0;
                } else if (i2 == 443) {
                    fVar.c(this.f29172c.a, 0, 2);
                    this.f29172c.J(0);
                    fVar.h(this.f29172c.D() + 6);
                    return 0;
                } else if (((i2 & (-256)) >> 8) != 1) {
                    fVar.h(1);
                    return 0;
                } else {
                    int i3 = i2 & 255;
                    a aVar = this.f29171b.get(i3);
                    if (!this.f29173d) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.f29174e && i3 == 189) {
                                hVar = new b();
                                this.f29174e = true;
                            } else if (!this.f29174e && (i3 & w0.Q) == 192) {
                                hVar = new n();
                                this.f29174e = true;
                            } else if (!this.f29175f && (i3 & 240) == 224) {
                                hVar = new i();
                                this.f29175f = true;
                            }
                            if (hVar != null) {
                                hVar.f(this.f29176g, new w.d(i3, 256));
                                aVar = new a(hVar, this.a);
                                this.f29171b.put(i3, aVar);
                            }
                        }
                        if ((this.f29174e && this.f29175f) || fVar.getPosition() > 1048576) {
                            this.f29173d = true;
                            this.f29176g.j();
                        }
                    }
                    fVar.c(this.f29172c.a, 0, 2);
                    this.f29172c.J(0);
                    int D = this.f29172c.D() + 6;
                    if (aVar == null) {
                        fVar.h(D);
                    } else {
                        this.f29172c.G(D);
                        fVar.readFully(this.f29172c.a, 0, D);
                        this.f29172c.J(6);
                        aVar.a(this.f29172c);
                        c.i.b.a.i0.l lVar = this.f29172c;
                        lVar.I(lVar.b());
                    }
                    return 0;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // c.i.b.a.a0.e
    public void f(c.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.f29176g = gVar;
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // c.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public q(c.i.b.a.i0.s sVar) {
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
        this.a = sVar;
        this.f29172c = new c.i.b.a.i0.l(4096);
        this.f29171b = new SparseArray<>();
    }
}
