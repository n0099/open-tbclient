package c.i.b.a.d0.w;

import android.text.TextUtils;
import c.i.b.a.a0.l;
import c.i.b.a.i0.s;
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
/* loaded from: classes9.dex */
public final class n implements c.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f29340g;

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f29341h;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final s f29342b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.i0.l f29343c;

    /* renamed from: d  reason: collision with root package name */
    public c.i.b.a.a0.g f29344d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f29345e;

    /* renamed from: f  reason: collision with root package name */
    public int f29346f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2077398577, "Lc/i/b/a/d0/w/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2077398577, "Lc/i/b/a/d0/w/n;");
                return;
            }
        }
        f29340g = Pattern.compile("LOCAL:([^,]+)");
        f29341h = Pattern.compile("MPEGTS:(\\d+)");
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
        this.a = str;
        this.f29342b = sVar;
        this.f29343c = new c.i.b.a.i0.l();
        this.f29345e = new byte[1024];
    }

    @Override // c.i.b.a.a0.e
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            throw new IllegalStateException();
        }
    }

    public final c.i.b.a.a0.m b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            c.i.b.a.a0.m a = this.f29344d.a(0, 3);
            a.b(Format.createTextSampleFormat((String) null, "text/vtt", (String) null, -1, 0, this.a, (DrmInitData) null, j2));
            this.f29344d.j();
            return a;
        }
        return (c.i.b.a.a0.m) invokeJ.objValue;
    }

    public final void c() throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(this.f29345e);
        try {
            c.i.b.a.e0.r.h.d(lVar);
            long j2 = 0;
            long j3 = 0;
            while (true) {
                String k = lVar.k();
                if (!TextUtils.isEmpty(k)) {
                    if (k.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = f29340g.matcher(k);
                        if (matcher.find()) {
                            Matcher matcher2 = f29341h.matcher(k);
                            if (matcher2.find()) {
                                j3 = c.i.b.a.e0.r.h.c(matcher.group(1));
                                j2 = s.f(Long.parseLong(matcher2.group(1)));
                            } else {
                                throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + k);
                            }
                        } else {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + k);
                        }
                    }
                } else {
                    Matcher a = c.i.b.a.e0.r.h.a(lVar);
                    if (a == null) {
                        b(0L);
                        return;
                    }
                    long c2 = c.i.b.a.e0.r.h.c(a.group(1));
                    long b2 = this.f29342b.b(s.i((j2 + c2) - j3));
                    c.i.b.a.a0.m b3 = b(b2 - c2);
                    this.f29343c.H(this.f29345e, this.f29346f);
                    b3.a(this.f29343c, this.f29346f);
                    b3.c(b2, 1, this.f29346f, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e2) {
            throw new ParserException(e2);
        }
    }

    @Override // c.i.b.a.a0.e
    public boolean d(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            throw new IllegalStateException();
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.b.a.a0.e
    public int e(c.i.b.a.a0.f fVar, c.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) == null) {
            int length = (int) fVar.getLength();
            int i2 = this.f29346f;
            byte[] bArr = this.f29345e;
            if (i2 == bArr.length) {
                this.f29345e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
            }
            byte[] bArr2 = this.f29345e;
            int i3 = this.f29346f;
            int read = fVar.read(bArr2, i3, bArr2.length - i3);
            if (read != -1) {
                int i4 = this.f29346f + read;
                this.f29346f = i4;
                if (length == -1 || i4 != length) {
                    return 0;
                }
            }
            c();
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // c.i.b.a.a0.e
    public void f(c.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f29344d = gVar;
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // c.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }
}
