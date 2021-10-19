package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class s implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final r f32942a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.l f32943b;

    /* renamed from: c  reason: collision with root package name */
    public int f32944c;

    /* renamed from: d  reason: collision with root package name */
    public int f32945d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32946e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32947f;

    public s(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32942a = rVar;
        this.f32943b = new c.i.b.a.i0.l(32);
    }

    @Override // c.i.b.a.a0.t.w
    public void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f32942a.a(sVar, gVar, dVar);
            this.f32947f = true;
        }
    }

    @Override // c.i.b.a.a0.t.w
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32947f = true;
        }
    }

    @Override // c.i.b.a.a0.t.w
    public void c(c.i.b.a.i0.l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, z) == null) {
            int c2 = z ? lVar.c() + lVar.x() : -1;
            if (this.f32947f) {
                if (!z) {
                    return;
                }
                this.f32947f = false;
                lVar.J(c2);
                this.f32945d = 0;
            }
            while (lVar.a() > 0) {
                int i2 = this.f32945d;
                if (i2 < 3) {
                    if (i2 == 0) {
                        int x = lVar.x();
                        lVar.J(lVar.c() - 1);
                        if (x == 255) {
                            this.f32947f = true;
                            return;
                        }
                    }
                    int min = Math.min(lVar.a(), 3 - this.f32945d);
                    lVar.g(this.f32943b.f33839a, this.f32945d, min);
                    int i3 = this.f32945d + min;
                    this.f32945d = i3;
                    if (i3 == 3) {
                        this.f32943b.G(3);
                        this.f32943b.K(1);
                        int x2 = this.f32943b.x();
                        int x3 = this.f32943b.x();
                        this.f32946e = (x2 & 128) != 0;
                        this.f32944c = (((x2 & 15) << 8) | x3) + 3;
                        int b2 = this.f32943b.b();
                        int i4 = this.f32944c;
                        if (b2 < i4) {
                            c.i.b.a.i0.l lVar2 = this.f32943b;
                            byte[] bArr = lVar2.f33839a;
                            lVar2.G(Math.min(4098, Math.max(i4, bArr.length * 2)));
                            System.arraycopy(bArr, 0, this.f32943b.f33839a, 0, 3);
                        }
                    }
                } else {
                    int min2 = Math.min(lVar.a(), this.f32944c - this.f32945d);
                    lVar.g(this.f32943b.f33839a, this.f32945d, min2);
                    int i5 = this.f32945d + min2;
                    this.f32945d = i5;
                    int i6 = this.f32944c;
                    if (i5 != i6) {
                        continue;
                    } else {
                        if (this.f32946e) {
                            if (c.i.b.a.i0.v.m(this.f32943b.f33839a, 0, i6, -1) != 0) {
                                this.f32947f = true;
                                return;
                            }
                            this.f32943b.G(this.f32944c - 4);
                        } else {
                            this.f32943b.G(i6);
                        }
                        this.f32942a.c(this.f32943b);
                        this.f32945d = 0;
                    }
                }
            }
        }
    }
}
