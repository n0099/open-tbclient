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
/* loaded from: classes4.dex */
public final class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.i0.k f32774a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.i0.l f32775b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32776c;

    /* renamed from: d  reason: collision with root package name */
    public String f32777d;

    /* renamed from: e  reason: collision with root package name */
    public c.i.b.a.a0.m f32778e;

    /* renamed from: f  reason: collision with root package name */
    public int f32779f;

    /* renamed from: g  reason: collision with root package name */
    public int f32780g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32781h;

    /* renamed from: i  reason: collision with root package name */
    public long f32782i;

    /* renamed from: j  reason: collision with root package name */
    public Format f32783j;
    public int k;
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
            int min = Math.min(lVar.a(), i2 - this.f32780g);
            lVar.g(bArr, this.f32780g, min);
            int i3 = this.f32780g + min;
            this.f32780g = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // c.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32779f = 0;
            this.f32780g = 0;
            this.f32781h = false;
        }
    }

    @Override // c.i.b.a.a0.t.h
    public void c(c.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32779f;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.k - this.f32780g);
                            this.f32778e.a(lVar, min);
                            int i3 = this.f32780g + min;
                            this.f32780g = i3;
                            int i4 = this.k;
                            if (i3 == i4) {
                                this.f32778e.c(this.l, 1, i4, 0, null);
                                this.l += this.f32782i;
                                this.f32779f = 0;
                            }
                        }
                    } else if (a(lVar, this.f32775b.f33835a, 8)) {
                        g();
                        this.f32775b.J(0);
                        this.f32778e.a(this.f32775b, 8);
                        this.f32779f = 2;
                    }
                } else if (h(lVar)) {
                    this.f32779f = 1;
                    byte[] bArr = this.f32775b.f33835a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.f32780g = 2;
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
            this.f32777d = dVar.b();
            this.f32778e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f32774a.l(0);
            a.b d2 = c.i.b.a.x.a.d(this.f32774a);
            Format format = this.f32783j;
            if (format == null || d2.f34011c != format.channelCount || d2.f34010b != format.sampleRate || d2.f34009a != format.sampleMimeType) {
                Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f32777d, d2.f34009a, null, -1, -1, d2.f34011c, d2.f34010b, null, null, 0, this.f32776c);
                this.f32783j = createAudioSampleFormat;
                this.f32778e.b(createAudioSampleFormat);
            }
            this.k = d2.f34012d;
            this.f32782i = (d2.f34013e * 1000000) / this.f32783j.sampleRate;
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
            if (!this.f32781h) {
                this.f32781h = lVar.x() == 11;
            } else {
                int x = lVar.x();
                if (x == 119) {
                    this.f32781h = false;
                    return true;
                }
                this.f32781h = x == 11;
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
        this.f32774a = kVar;
        this.f32775b = new c.i.b.a.i0.l(kVar.f33831a);
        this.f32779f = 0;
        this.f32776c = str;
    }
}
