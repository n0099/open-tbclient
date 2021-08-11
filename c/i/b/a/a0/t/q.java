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
import java.io.IOException;
/* loaded from: classes4.dex */
public final class q implements c.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.i0.s f32685a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f32686b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.l f32687c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32688d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32689e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32690f;

    /* renamed from: g  reason: collision with root package name */
    public c.i.b.a.a0.g f32691g;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final h f32692a;

        /* renamed from: b  reason: collision with root package name */
        public final c.i.b.a.i0.s f32693b;

        /* renamed from: c  reason: collision with root package name */
        public final c.i.b.a.i0.k f32694c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f32695d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32696e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f32697f;

        /* renamed from: g  reason: collision with root package name */
        public int f32698g;

        /* renamed from: h  reason: collision with root package name */
        public long f32699h;

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
            this.f32692a = hVar;
            this.f32693b = sVar;
            this.f32694c = new c.i.b.a.i0.k(new byte[64]);
        }

        public void a(c.i.b.a.i0.l lVar) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
                lVar.g(this.f32694c.f33593a, 0, 3);
                this.f32694c.l(0);
                b();
                lVar.g(this.f32694c.f33593a, 0, this.f32698g);
                this.f32694c.l(0);
                c();
                this.f32692a.e(this.f32699h, true);
                this.f32692a.c(lVar);
                this.f32692a.d();
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f32694c.n(8);
                this.f32695d = this.f32694c.f();
                this.f32696e = this.f32694c.f();
                this.f32694c.n(6);
                this.f32698g = this.f32694c.g(8);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f32699h = 0L;
                if (this.f32695d) {
                    this.f32694c.n(4);
                    this.f32694c.n(1);
                    this.f32694c.n(1);
                    long g2 = (this.f32694c.g(3) << 30) | (this.f32694c.g(15) << 15) | this.f32694c.g(15);
                    this.f32694c.n(1);
                    if (!this.f32697f && this.f32696e) {
                        this.f32694c.n(4);
                        this.f32694c.n(1);
                        this.f32694c.n(1);
                        this.f32694c.n(1);
                        this.f32693b.b((this.f32694c.g(3) << 30) | (this.f32694c.g(15) << 15) | this.f32694c.g(15));
                        this.f32697f = true;
                    }
                    this.f32699h = this.f32693b.b(g2);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f32697f = false;
                this.f32692a.b();
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
            this.f32685a.g();
            for (int i2 = 0; i2 < this.f32686b.size(); i2++) {
                this.f32686b.valueAt(i2).d();
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
            if (fVar.d(this.f32687c.f33597a, 0, 4, true)) {
                this.f32687c.J(0);
                int i2 = this.f32687c.i();
                if (i2 == 441) {
                    return -1;
                }
                if (i2 == 442) {
                    fVar.c(this.f32687c.f33597a, 0, 10);
                    this.f32687c.J(9);
                    fVar.h((this.f32687c.x() & 7) + 14);
                    return 0;
                } else if (i2 == 443) {
                    fVar.c(this.f32687c.f33597a, 0, 2);
                    this.f32687c.J(0);
                    fVar.h(this.f32687c.D() + 6);
                    return 0;
                } else if (((i2 & (-256)) >> 8) != 1) {
                    fVar.h(1);
                    return 0;
                } else {
                    int i3 = i2 & 255;
                    a aVar = this.f32686b.get(i3);
                    if (!this.f32688d) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.f32689e && i3 == 189) {
                                hVar = new b();
                                this.f32689e = true;
                            } else if (!this.f32689e && (i3 & 224) == 192) {
                                hVar = new n();
                                this.f32689e = true;
                            } else if (!this.f32690f && (i3 & 240) == 224) {
                                hVar = new i();
                                this.f32690f = true;
                            }
                            if (hVar != null) {
                                hVar.f(this.f32691g, new w.d(i3, 256));
                                aVar = new a(hVar, this.f32685a);
                                this.f32686b.put(i3, aVar);
                            }
                        }
                        if ((this.f32689e && this.f32690f) || fVar.getPosition() > 1048576) {
                            this.f32688d = true;
                            this.f32691g.j();
                        }
                    }
                    fVar.c(this.f32687c.f33597a, 0, 2);
                    this.f32687c.J(0);
                    int D = this.f32687c.D() + 6;
                    if (aVar == null) {
                        fVar.h(D);
                    } else {
                        this.f32687c.G(D);
                        fVar.readFully(this.f32687c.f33597a, 0, D);
                        this.f32687c.J(6);
                        aVar.a(this.f32687c);
                        c.i.b.a.i0.l lVar = this.f32687c;
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
            this.f32691g = gVar;
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
        this.f32685a = sVar;
        this.f32687c = new c.i.b.a.i0.l(4096);
        this.f32686b = new SparseArray<>();
    }
}
