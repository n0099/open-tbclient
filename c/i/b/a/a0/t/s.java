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
    public final r f32915a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.l f32916b;

    /* renamed from: c  reason: collision with root package name */
    public int f32917c;

    /* renamed from: d  reason: collision with root package name */
    public int f32918d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32919e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32920f;

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
        this.f32915a = rVar;
        this.f32916b = new c.i.b.a.i0.l(32);
    }

    @Override // c.i.b.a.a0.t.w
    public void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            this.f32915a.a(sVar, gVar, dVar);
            this.f32920f = true;
        }
    }

    @Override // c.i.b.a.a0.t.w
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32920f = true;
        }
    }

    @Override // c.i.b.a.a0.t.w
    public void c(c.i.b.a.i0.l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lVar, z) == null) {
            int c2 = z ? lVar.c() + lVar.x() : -1;
            if (this.f32920f) {
                if (!z) {
                    return;
                }
                this.f32920f = false;
                lVar.J(c2);
                this.f32918d = 0;
            }
            while (lVar.a() > 0) {
                int i2 = this.f32918d;
                if (i2 < 3) {
                    if (i2 == 0) {
                        int x = lVar.x();
                        lVar.J(lVar.c() - 1);
                        if (x == 255) {
                            this.f32920f = true;
                            return;
                        }
                    }
                    int min = Math.min(lVar.a(), 3 - this.f32918d);
                    lVar.g(this.f32916b.f33812a, this.f32918d, min);
                    int i3 = this.f32918d + min;
                    this.f32918d = i3;
                    if (i3 == 3) {
                        this.f32916b.G(3);
                        this.f32916b.K(1);
                        int x2 = this.f32916b.x();
                        int x3 = this.f32916b.x();
                        this.f32919e = (x2 & 128) != 0;
                        this.f32917c = (((x2 & 15) << 8) | x3) + 3;
                        int b2 = this.f32916b.b();
                        int i4 = this.f32917c;
                        if (b2 < i4) {
                            c.i.b.a.i0.l lVar2 = this.f32916b;
                            byte[] bArr = lVar2.f33812a;
                            lVar2.G(Math.min(4098, Math.max(i4, bArr.length * 2)));
                            System.arraycopy(bArr, 0, this.f32916b.f33812a, 0, 3);
                        }
                    }
                } else {
                    int min2 = Math.min(lVar.a(), this.f32917c - this.f32918d);
                    lVar.g(this.f32916b.f33812a, this.f32918d, min2);
                    int i5 = this.f32918d + min2;
                    this.f32918d = i5;
                    int i6 = this.f32917c;
                    if (i5 != i6) {
                        continue;
                    } else {
                        if (this.f32919e) {
                            if (c.i.b.a.i0.v.m(this.f32916b.f33812a, 0, i6, -1) != 0) {
                                this.f32920f = true;
                                return;
                            }
                            this.f32916b.G(this.f32917c - 4);
                        } else {
                            this.f32916b.G(i6);
                        }
                        this.f32915a.c(this.f32916b);
                        this.f32918d = 0;
                    }
                }
            }
        }
    }
}
