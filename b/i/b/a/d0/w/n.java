package b.i.b.a.d0.w;

import android.text.TextUtils;
import b.i.b.a.a0.l;
import b.i.b.a.i0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class n implements b.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f32187g;

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f32188h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f32189a;

    /* renamed from: b  reason: collision with root package name */
    public final s f32190b;

    /* renamed from: c  reason: collision with root package name */
    public final b.i.b.a.i0.l f32191c;

    /* renamed from: d  reason: collision with root package name */
    public b.i.b.a.a0.g f32192d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f32193e;

    /* renamed from: f  reason: collision with root package name */
    public int f32194f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(710016910, "Lb/i/b/a/d0/w/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(710016910, "Lb/i/b/a/d0/w/n;");
                return;
            }
        }
        f32187g = Pattern.compile("LOCAL:([^,]+)");
        f32188h = Pattern.compile("MPEGTS:(\\d+)");
    }

    public n(String str, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, sVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32189a = str;
        this.f32190b = sVar;
        this.f32191c = new b.i.b.a.i0.l();
        this.f32193e = new byte[1024];
    }

    @Override // b.i.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            throw new IllegalStateException();
        }
    }

    public final b.i.b.a.a0.m b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            b.i.b.a.a0.m a2 = this.f32192d.a(0, 3);
            a2.b(Format.createTextSampleFormat((String) null, "text/vtt", (String) null, -1, 0, this.f32189a, (DrmInitData) null, j));
            this.f32192d.j();
            return a2;
        }
        return (b.i.b.a.a0.m) invokeJ.objValue;
    }

    public final void c() throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        b.i.b.a.i0.l lVar = new b.i.b.a.i0.l(this.f32193e);
        try {
            b.i.b.a.e0.r.h.d(lVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String k = lVar.k();
                if (!TextUtils.isEmpty(k)) {
                    if (k.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = f32187g.matcher(k);
                        if (matcher.find()) {
                            Matcher matcher2 = f32188h.matcher(k);
                            if (matcher2.find()) {
                                j2 = b.i.b.a.e0.r.h.c(matcher.group(1));
                                j = s.f(Long.parseLong(matcher2.group(1)));
                            } else {
                                throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + k);
                            }
                        } else {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + k);
                        }
                    }
                } else {
                    Matcher a2 = b.i.b.a.e0.r.h.a(lVar);
                    if (a2 == null) {
                        b(0L);
                        return;
                    }
                    long c2 = b.i.b.a.e0.r.h.c(a2.group(1));
                    long b2 = this.f32190b.b(s.i((j + c2) - j2));
                    b.i.b.a.a0.m b3 = b(b2 - c2);
                    this.f32191c.H(this.f32193e, this.f32194f);
                    b3.a(this.f32191c, this.f32194f);
                    b3.c(b2, 1, this.f32194f, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e2) {
            throw new ParserException(e2);
        }
    }

    @Override // b.i.b.a.a0.e
    public boolean d(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            throw new IllegalStateException();
        }
        return invokeL.booleanValue;
    }

    @Override // b.i.b.a.a0.e
    public int e(b.i.b.a.a0.f fVar, b.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) == null) {
            int length = (int) fVar.getLength();
            int i2 = this.f32194f;
            byte[] bArr = this.f32193e;
            if (i2 == bArr.length) {
                this.f32193e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
            }
            byte[] bArr2 = this.f32193e;
            int i3 = this.f32194f;
            int read = fVar.read(bArr2, i3, bArr2.length - i3);
            if (read != -1) {
                int i4 = this.f32194f + read;
                this.f32194f = i4;
                if (length == -1 || i4 != length) {
                    return 0;
                }
            }
            c();
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // b.i.b.a.a0.e
    public void f(b.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f32192d = gVar;
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // b.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }
}
