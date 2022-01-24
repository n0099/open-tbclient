package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class s implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.l f28978b;

    /* renamed from: c  reason: collision with root package name */
    public int f28979c;

    /* renamed from: d  reason: collision with root package name */
    public int f28980d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28981e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28982f;

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
        this.a = rVar;
        this.f28978b = new c.i.b.a.i0.l(32);
    }

    @Override // c.i.b.a.a0.t.w
    public void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.a.a(sVar, gVar, dVar);
            this.f28982f = true;
        }
    }

    @Override // c.i.b.a.a0.t.w
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28982f = true;
        }
    }

    @Override // c.i.b.a.a0.t.w
    public void c(c.i.b.a.i0.l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, z) == null) {
            int c2 = z ? lVar.c() + lVar.x() : -1;
            if (this.f28982f) {
                if (!z) {
                    return;
                }
                this.f28982f = false;
                lVar.J(c2);
                this.f28980d = 0;
            }
            while (lVar.a() > 0) {
                int i2 = this.f28980d;
                if (i2 < 3) {
                    if (i2 == 0) {
                        int x = lVar.x();
                        lVar.J(lVar.c() - 1);
                        if (x == 255) {
                            this.f28982f = true;
                            return;
                        }
                    }
                    int min = Math.min(lVar.a(), 3 - this.f28980d);
                    lVar.g(this.f28978b.a, this.f28980d, min);
                    int i3 = this.f28980d + min;
                    this.f28980d = i3;
                    if (i3 == 3) {
                        this.f28978b.G(3);
                        this.f28978b.K(1);
                        int x2 = this.f28978b.x();
                        int x3 = this.f28978b.x();
                        this.f28981e = (x2 & 128) != 0;
                        this.f28979c = (((x2 & 15) << 8) | x3) + 3;
                        int b2 = this.f28978b.b();
                        int i4 = this.f28979c;
                        if (b2 < i4) {
                            c.i.b.a.i0.l lVar2 = this.f28978b;
                            byte[] bArr = lVar2.a;
                            lVar2.G(Math.min(4098, Math.max(i4, bArr.length * 2)));
                            System.arraycopy(bArr, 0, this.f28978b.a, 0, 3);
                        }
                    }
                } else {
                    int min2 = Math.min(lVar.a(), this.f28979c - this.f28980d);
                    lVar.g(this.f28978b.a, this.f28980d, min2);
                    int i5 = this.f28980d + min2;
                    this.f28980d = i5;
                    int i6 = this.f28979c;
                    if (i5 != i6) {
                        continue;
                    } else {
                        if (this.f28981e) {
                            if (c.i.b.a.i0.v.m(this.f28978b.a, 0, i6, -1) != 0) {
                                this.f28982f = true;
                                return;
                            }
                            this.f28978b.G(this.f28979c - 4);
                        } else {
                            this.f28978b.G(i6);
                        }
                        this.a.c(this.f28978b);
                        this.f28980d = 0;
                    }
                }
            }
        }
    }
}
