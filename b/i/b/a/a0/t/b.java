package b.i.b.a.a0.t;

import b.i.b.a.a0.t.w;
import b.i.b.a.x.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class b implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.i.b.a.i0.k f31644a;

    /* renamed from: b  reason: collision with root package name */
    public final b.i.b.a.i0.l f31645b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31646c;

    /* renamed from: d  reason: collision with root package name */
    public String f31647d;

    /* renamed from: e  reason: collision with root package name */
    public b.i.b.a.a0.m f31648e;

    /* renamed from: f  reason: collision with root package name */
    public int f31649f;

    /* renamed from: g  reason: collision with root package name */
    public int f31650g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31651h;

    /* renamed from: i  reason: collision with root package name */
    public long f31652i;
    public Format j;
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

    public final boolean a(b.i.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f31650g);
            lVar.g(bArr, this.f31650g, min);
            int i3 = this.f31650g + min;
            this.f31650g = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // b.i.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31649f = 0;
            this.f31650g = 0;
            this.f31651h = false;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void c(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f31649f;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.k - this.f31650g);
                            this.f31648e.a(lVar, min);
                            int i3 = this.f31650g + min;
                            this.f31650g = i3;
                            int i4 = this.k;
                            if (i3 == i4) {
                                this.f31648e.c(this.l, 1, i4, 0, null);
                                this.l += this.f31652i;
                                this.f31649f = 0;
                            }
                        }
                    } else if (a(lVar, this.f31645b.f32635a, 8)) {
                        g();
                        this.f31645b.J(0);
                        this.f31648e.a(this.f31645b, 8);
                        this.f31649f = 2;
                    }
                } else if (h(lVar)) {
                    this.f31649f = 1;
                    byte[] bArr = this.f31645b.f32635a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.f31650g = 2;
                }
            }
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.l = j;
        }
    }

    @Override // b.i.b.a.a0.t.h
    public void f(b.i.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f31647d = dVar.b();
            this.f31648e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f31644a.l(0);
            a.b d2 = b.i.b.a.x.a.d(this.f31644a);
            Format format = this.j;
            if (format == null || d2.f32804c != format.channelCount || d2.f32803b != format.sampleRate || d2.f32802a != format.sampleMimeType) {
                Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f31647d, d2.f32802a, null, -1, -1, d2.f32804c, d2.f32803b, null, null, 0, this.f31646c);
                this.j = createAudioSampleFormat;
                this.f31648e.b(createAudioSampleFormat);
            }
            this.k = d2.f32805d;
            this.f31652i = (d2.f32806e * 1000000) / this.j.sampleRate;
        }
    }

    public final boolean h(b.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, lVar)) != null) {
            return invokeL.booleanValue;
        }
        while (true) {
            if (lVar.a() <= 0) {
                return false;
            }
            if (!this.f31651h) {
                this.f31651h = lVar.x() == 11;
            } else {
                int x = lVar.x();
                if (x == 119) {
                    this.f31651h = false;
                    return true;
                }
                this.f31651h = x == 11;
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
        b.i.b.a.i0.k kVar = new b.i.b.a.i0.k(new byte[8]);
        this.f31644a = kVar;
        this.f31645b = new b.i.b.a.i0.l(kVar.f32631a);
        this.f31649f = 0;
        this.f31646c = str;
    }
}
