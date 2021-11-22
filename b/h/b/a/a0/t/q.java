package b.h.b.a.a0.t;

import android.util.SparseArray;
import b.h.b.a.a0.l;
import b.h.b.a.a0.t.w;
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
public final class q implements b.h.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.h.b.a.i0.s f32639a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f32640b;

    /* renamed from: c  reason: collision with root package name */
    public final b.h.b.a.i0.l f32641c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32642d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32643e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32644f;

    /* renamed from: g  reason: collision with root package name */
    public b.h.b.a.a0.g f32645g;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final h f32646a;

        /* renamed from: b  reason: collision with root package name */
        public final b.h.b.a.i0.s f32647b;

        /* renamed from: c  reason: collision with root package name */
        public final b.h.b.a.i0.k f32648c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f32649d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32650e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f32651f;

        /* renamed from: g  reason: collision with root package name */
        public int f32652g;

        /* renamed from: h  reason: collision with root package name */
        public long f32653h;

        public a(h hVar, b.h.b.a.i0.s sVar) {
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
            this.f32646a = hVar;
            this.f32647b = sVar;
            this.f32648c = new b.h.b.a.i0.k(new byte[64]);
        }

        public void a(b.h.b.a.i0.l lVar) throws ParserException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
                lVar.g(this.f32648c.f33489a, 0, 3);
                this.f32648c.l(0);
                b();
                lVar.g(this.f32648c.f33489a, 0, this.f32652g);
                this.f32648c.l(0);
                c();
                this.f32646a.e(this.f32653h, true);
                this.f32646a.c(lVar);
                this.f32646a.d();
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f32648c.n(8);
                this.f32649d = this.f32648c.f();
                this.f32650e = this.f32648c.f();
                this.f32648c.n(6);
                this.f32652g = this.f32648c.g(8);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f32653h = 0L;
                if (this.f32649d) {
                    this.f32648c.n(4);
                    this.f32648c.n(1);
                    this.f32648c.n(1);
                    long g2 = (this.f32648c.g(3) << 30) | (this.f32648c.g(15) << 15) | this.f32648c.g(15);
                    this.f32648c.n(1);
                    if (!this.f32651f && this.f32650e) {
                        this.f32648c.n(4);
                        this.f32648c.n(1);
                        this.f32648c.n(1);
                        this.f32648c.n(1);
                        this.f32647b.b((this.f32648c.g(3) << 30) | (this.f32648c.g(15) << 15) | this.f32648c.g(15));
                        this.f32651f = true;
                    }
                    this.f32653h = this.f32647b.b(g2);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f32651f = false;
                this.f32646a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1659180406, "Lb/h/b/a/a0/t/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1659180406, "Lb/h/b/a/a0/t/q;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q() {
        this(new b.h.b.a.i0.s(0L));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((b.h.b.a.i0.s) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.h.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f32639a.g();
            for (int i2 = 0; i2 < this.f32640b.size(); i2++) {
                this.f32640b.valueAt(i2).d();
            }
        }
    }

    @Override // b.h.b.a.a0.e
    public boolean d(b.h.b.a.a0.f fVar) throws IOException, InterruptedException {
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

    @Override // b.h.b.a.a0.e
    public int e(b.h.b.a.a0.f fVar, b.h.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, kVar)) == null) {
            if (fVar.d(this.f32641c.f33493a, 0, 4, true)) {
                this.f32641c.J(0);
                int i2 = this.f32641c.i();
                if (i2 == 441) {
                    return -1;
                }
                if (i2 == 442) {
                    fVar.c(this.f32641c.f33493a, 0, 10);
                    this.f32641c.J(9);
                    fVar.h((this.f32641c.x() & 7) + 14);
                    return 0;
                } else if (i2 == 443) {
                    fVar.c(this.f32641c.f33493a, 0, 2);
                    this.f32641c.J(0);
                    fVar.h(this.f32641c.D() + 6);
                    return 0;
                } else if (((i2 & (-256)) >> 8) != 1) {
                    fVar.h(1);
                    return 0;
                } else {
                    int i3 = i2 & 255;
                    a aVar = this.f32640b.get(i3);
                    if (!this.f32642d) {
                        if (aVar == null) {
                            h hVar = null;
                            if (!this.f32643e && i3 == 189) {
                                hVar = new b();
                                this.f32643e = true;
                            } else if (!this.f32643e && (i3 & 224) == 192) {
                                hVar = new n();
                                this.f32643e = true;
                            } else if (!this.f32644f && (i3 & 240) == 224) {
                                hVar = new i();
                                this.f32644f = true;
                            }
                            if (hVar != null) {
                                hVar.f(this.f32645g, new w.d(i3, 256));
                                aVar = new a(hVar, this.f32639a);
                                this.f32640b.put(i3, aVar);
                            }
                        }
                        if ((this.f32643e && this.f32644f) || fVar.getPosition() > 1048576) {
                            this.f32642d = true;
                            this.f32645g.j();
                        }
                    }
                    fVar.c(this.f32641c.f33493a, 0, 2);
                    this.f32641c.J(0);
                    int D = this.f32641c.D() + 6;
                    if (aVar == null) {
                        fVar.h(D);
                    } else {
                        this.f32641c.G(D);
                        fVar.readFully(this.f32641c.f33493a, 0, D);
                        this.f32641c.J(6);
                        aVar.a(this.f32641c);
                        b.h.b.a.i0.l lVar = this.f32641c;
                        lVar.I(lVar.b());
                    }
                    return 0;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // b.h.b.a.a0.e
    public void f(b.h.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.f32645g = gVar;
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // b.h.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public q(b.h.b.a.i0.s sVar) {
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
        this.f32639a = sVar;
        this.f32641c = new b.h.b.a.i0.l(4096);
        this.f32640b = new SparseArray<>();
    }
}
