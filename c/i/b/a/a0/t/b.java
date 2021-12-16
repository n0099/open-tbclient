package c.i.b.a.a0.t;

import c.i.b.a.a0.t.w;
import c.i.b.a.x.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes9.dex */
public final class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.i.b.a.i0.k a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.l f29637b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29638c;

    /* renamed from: d  reason: collision with root package name */
    public String f29639d;

    /* renamed from: e  reason: collision with root package name */
    public c.i.b.a.a0.m f29640e;

    /* renamed from: f  reason: collision with root package name */
    public int f29641f;

    /* renamed from: g  reason: collision with root package name */
    public int f29642g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29643h;

    /* renamed from: i  reason: collision with root package name */
    public long f29644i;

    /* renamed from: j  reason: collision with root package name */
    public Format f29645j;

    /* renamed from: k  reason: collision with root package name */
    public int f29646k;
    public long l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean a(c.i.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f29642g);
            lVar.g(bArr, this.f29642g, min);
            int i3 = this.f29642g + min;
            this.f29642g = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29641f = 0;
            this.f29642g = 0;
            this.f29643h = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f29641f;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.f29646k - this.f29642g);
                            this.f29640e.a(lVar, min);
                            int i3 = this.f29642g + min;
                            this.f29642g = i3;
                            int i4 = this.f29646k;
                            if (i3 == i4) {
                                this.f29640e.c(this.l, 1, i4, 0, null);
                                this.l += this.f29644i;
                                this.f29641f = 0;
                            }
                        }
                    } else if (a(lVar, this.f29637b.a, 8)) {
                        g();
                        this.f29637b.J(0);
                        this.f29640e.a(this.f29637b, 8);
                        this.f29641f = 2;
                    }
                } else if (h(lVar)) {
                    this.f29641f = 1;
                    byte[] bArr = this.f29637b.a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.f29642g = 2;
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
            this.l = j2;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void f(c.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f29639d = dVar.b();
            this.f29640e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.l(0);
            a.b d2 = c.i.b.a.x.a.d(this.a);
            Format format = this.f29645j;
            if (format == null || d2.f30754c != format.channelCount || d2.f30753b != format.sampleRate || d2.a != format.sampleMimeType) {
                Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f29639d, d2.a, null, -1, -1, d2.f30754c, d2.f30753b, null, null, 0, this.f29638c);
                this.f29645j = createAudioSampleFormat;
                this.f29640e.b(createAudioSampleFormat);
            }
            this.f29646k = d2.f30755d;
            this.f29644i = (d2.f30756e * 1000000) / this.f29645j.sampleRate;
        }
    }

    public final boolean h(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, lVar)) != null) {
            return invokeL.booleanValue;
        }
        while (true) {
            if (lVar.a() <= 0) {
                return false;
            }
            if (!this.f29643h) {
                this.f29643h = lVar.x() == 11;
            } else {
                int x = lVar.x();
                if (x == 119) {
                    this.f29643h = false;
                    return true;
                }
                this.f29643h = x == 11;
            }
        }
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.k kVar = new c.i.b.a.i0.k(new byte[8]);
        this.a = kVar;
        this.f29637b = new c.i.b.a.i0.l(kVar.a);
        this.f29641f = 0;
        this.f29638c = str;
    }
}
