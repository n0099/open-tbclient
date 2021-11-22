package b.h.b.a.a0.t;

import b.h.b.a.a0.t.w;
import b.h.b.a.x.a;
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
    public final b.h.b.a.i0.k f32502a;

    /* renamed from: b  reason: collision with root package name */
    public final b.h.b.a.i0.l f32503b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32504c;

    /* renamed from: d  reason: collision with root package name */
    public String f32505d;

    /* renamed from: e  reason: collision with root package name */
    public b.h.b.a.a0.m f32506e;

    /* renamed from: f  reason: collision with root package name */
    public int f32507f;

    /* renamed from: g  reason: collision with root package name */
    public int f32508g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32509h;

    /* renamed from: i  reason: collision with root package name */
    public long f32510i;
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

    public final boolean a(b.h.b.a.i0.l lVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, lVar, bArr, i2)) == null) {
            int min = Math.min(lVar.a(), i2 - this.f32508g);
            lVar.g(bArr, this.f32508g, min);
            int i3 = this.f32508g + min;
            this.f32508g = i3;
            return i3 == i2;
        }
        return invokeLLI.booleanValue;
    }

    @Override // b.h.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32507f = 0;
            this.f32508g = 0;
            this.f32509h = false;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void c(b.h.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            while (lVar.a() > 0) {
                int i2 = this.f32507f;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            int min = Math.min(lVar.a(), this.k - this.f32508g);
                            this.f32506e.a(lVar, min);
                            int i3 = this.f32508g + min;
                            this.f32508g = i3;
                            int i4 = this.k;
                            if (i3 == i4) {
                                this.f32506e.c(this.l, 1, i4, 0, null);
                                this.l += this.f32510i;
                                this.f32507f = 0;
                            }
                        }
                    } else if (a(lVar, this.f32503b.f33493a, 8)) {
                        g();
                        this.f32503b.J(0);
                        this.f32506e.a(this.f32503b, 8);
                        this.f32507f = 2;
                    }
                } else if (h(lVar)) {
                    this.f32507f = 1;
                    byte[] bArr = this.f32503b.f33493a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.f32508g = 2;
                }
            }
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.l = j;
        }
    }

    @Override // b.h.b.a.a0.t.h
    public void f(b.h.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f32505d = dVar.b();
            this.f32506e = gVar.a(dVar.c(), 1);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f32502a.l(0);
            a.b d2 = b.h.b.a.x.a.d(this.f32502a);
            Format format = this.j;
            if (format == null || d2.f33662c != format.channelCount || d2.f33661b != format.sampleRate || d2.f33660a != format.sampleMimeType) {
                Format createAudioSampleFormat = Format.createAudioSampleFormat(this.f32505d, d2.f33660a, null, -1, -1, d2.f33662c, d2.f33661b, null, null, 0, this.f32504c);
                this.j = createAudioSampleFormat;
                this.f32506e.b(createAudioSampleFormat);
            }
            this.k = d2.f33663d;
            this.f32510i = (d2.f33664e * 1000000) / this.j.sampleRate;
        }
    }

    public final boolean h(b.h.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, lVar)) != null) {
            return invokeL.booleanValue;
        }
        while (true) {
            if (lVar.a() <= 0) {
                return false;
            }
            if (!this.f32509h) {
                this.f32509h = lVar.x() == 11;
            } else {
                int x = lVar.x();
                if (x == 119) {
                    this.f32509h = false;
                    return true;
                }
                this.f32509h = x == 11;
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
        b.h.b.a.i0.k kVar = new b.h.b.a.i0.k(new byte[8]);
        this.f32502a = kVar;
        this.f32503b = new b.h.b.a.i0.l(kVar.f33489a);
        this.f32507f = 0;
        this.f32504c = str;
    }
}
