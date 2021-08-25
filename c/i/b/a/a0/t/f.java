package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes4.dex */
public final class f implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.i0.l f32669a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32670b;

    /* renamed from: c  reason: collision with root package name */
    public String f32671c;

    /* renamed from: d  reason: collision with root package name */
    public c.i.b.a.a0.m f32672d;

    /* renamed from: e  reason: collision with root package name */
    public int f32673e;

    /* renamed from: f  reason: collision with root package name */
    public int f32674f;

    /* renamed from: g  reason: collision with root package name */
    public int f32675g;

    /* renamed from: h  reason: collision with root package name */
    public long f32676h;

    /* renamed from: i  reason: collision with root package name */
    public Format f32677i;

    /* renamed from: j  reason: collision with root package name */
    public int f32678j;
    public long k;

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(new byte[15]);
        this.f32669a = lVar;
        byte[] bArr = lVar.f33703a;
        bArr[0] = ByteCompanionObject.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = ByteCompanionObject.MIN_VALUE;
        bArr[3] = 1;
        this.f32673e = 0;
        this.f32670b = str;
    }

    public final boolean a(c.i.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f32674f);
            lVar.g(bArr, this.f32674f, min);
            int i3 = this.f32674f + min;
            this.f32674f = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32673e = 0;
            this.f32674f = 0;
            this.f32675g = 0;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32673e;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.f32678j - this.f32674f);
                            this.f32672d.a(lVar, min);
                            int i3 = this.f32674f + min;
                            this.f32674f = i3;
                            int i4 = this.f32678j;
                            if (i3 == i4) {
                                this.f32672d.c(this.k, 1, i4, 0, null);
                                this.k += this.f32676h;
                                this.f32673e = 0;
                            }
                        }
                    } else if (a(lVar, this.f32669a.f33703a, 15)) {
                        g();
                        this.f32669a.J(0);
                        this.f32672d.a(this.f32669a, 15);
                        this.f32673e = 2;
                    }
                } else if (h(lVar)) {
                    this.f32674f = 4;
                    this.f32673e = 1;
                }
            }
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void e(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            this.k = j2;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void f(c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f32671c = dVar.b();
            this.f32672d = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            byte[] bArr = this.f32669a.f33703a;
            if (this.f32677i == null) {
                Format d2 = c.i.b.a.x.f.d(bArr, this.f32671c, this.f32670b, null);
                this.f32677i = d2;
                this.f32672d.b(d2);
            }
            this.f32678j = c.i.b.a.x.f.a(bArr);
            this.f32676h = (int) ((c.i.b.a.x.f.c(bArr) * 1000000) / this.f32677i.sampleRate);
        }
    }

    public final boolean h(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lVar)) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32675g << 8;
                this.f32675g = i2;
                int x = i2 | lVar.x();
                this.f32675g = x;
                if (x == 2147385345) {
                    this.f32675g = 0;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
