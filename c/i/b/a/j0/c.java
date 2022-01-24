package c.i.b.a.j0;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.i;
import c.i.b.a.i0.t;
import c.i.b.a.i0.v;
import c.i.b.a.j0.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.video.DummySurface;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes9.dex */
public class c extends MediaCodecRenderer {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] O0;
    public transient /* synthetic */ FieldHolder $fh;
    public float A0;
    public int B0;
    public int C0;
    public int D0;
    public float E0;
    public int F0;
    public int G0;
    public int H0;
    public float I0;
    public boolean J0;
    public int K0;
    public C1670c L0;
    public long M0;
    public int N0;
    public final Context Z;
    public final d a0;
    public final e.a b0;
    public final long c0;
    public final int d0;
    public final boolean e0;
    public final long[] f0;
    public Format[] g0;
    public b h0;
    public boolean i0;
    public Surface k0;
    public Surface q0;
    public int r0;
    public boolean s0;
    public boolean t0;
    public long u0;
    public long v0;
    public int w0;
    public int x0;
    public int y0;
    public int z0;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f29799b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29800c;

        public b(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f29799b = i3;
            this.f29800c = i4;
        }
    }

    @TargetApi(23)
    /* renamed from: c.i.b.a.j0.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public final class C1670c implements MediaCodec.OnFrameRenderedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public /* synthetic */ C1670c(c cVar, MediaCodec mediaCodec, a aVar) {
            this(cVar, mediaCodec);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{mediaCodec, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                c cVar = this.a;
                if (this != cVar.L0) {
                    return;
                }
                cVar.F0();
            }
        }

        public C1670c(c cVar, MediaCodec mediaCodec) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, mediaCodec};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-716173464, "Lc/i/b/a/j0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-716173464, "Lc/i/b/a/j0/c;");
                return;
            }
        }
        O0 = new int[]{1920, FeatureCodes.ADVANCE_BEAUTY, 1440, 1280, 960, 854, 640, RecordConstants.DEFAULT_PREVIEW_WIDTH, 480};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, c.i.b.a.b0.b bVar, long j2, @Nullable c.i.b.a.z.a<c.i.b.a.z.c> aVar, boolean z, @Nullable Handler handler, @Nullable e eVar, int i2) {
        super(2, bVar, aVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, bVar, Long.valueOf(j2), aVar, Boolean.valueOf(z), handler, eVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (c.i.b.a.b0.b) objArr2[1], (c.i.b.a.z.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c0 = j2;
        this.d0 = i2;
        this.Z = context.getApplicationContext();
        this.a0 = new d(context);
        this.b0 = new e.a(handler, eVar);
        this.e0 = s0();
        this.f0 = new long[10];
        this.M0 = -9223372036854775807L;
        this.u0 = -9223372036854775807L;
        this.B0 = -1;
        this.C0 = -1;
        this.E0 = -1.0f;
        this.A0 = -1.0f;
        this.r0 = 1;
        p0();
    }

    public static int A0(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, format)) == null) {
            int i2 = format.rotationDegrees;
            if (i2 == -1) {
                return 0;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static boolean B0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) ? j2 < -30000 : invokeJ.booleanValue;
    }

    public static boolean C0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2)) == null) ? j2 < -500000 : invokeJ.booleanValue;
    }

    @TargetApi(23)
    public static void M0(MediaCodec mediaCodec, Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, mediaCodec, surface) == null) {
            mediaCodec.setOutputSurface(surface);
        }
    }

    public static void O0(MediaCodec mediaCodec, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, mediaCodec, i2) == null) {
            mediaCodec.setVideoScalingMode(i2);
        }
    }

    public static boolean n0(boolean z, Format format, Format format2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), format, format2})) == null) ? format.sampleMimeType.equals(format2.sampleMimeType) && A0(format) == A0(format2) && (z || (format.width == format2.width && format.height == format2.height)) : invokeCommon.booleanValue;
    }

    public static boolean q0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? (("deb".equals(v.f29767b) || "flo".equals(v.f29767b)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(v.f29767b) || "SVP-DTV15".equals(v.f29767b) || "BRAVIA_ATV2".equals(v.f29767b)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str)) : invokeL.booleanValue;
    }

    @TargetApi(21)
    public static void r0(MediaFormat mediaFormat, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, mediaFormat, i2) == null) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i2);
        }
    }

    public static boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? v.a <= 22 && "foster".equals(v.f29767b) && "NVIDIA".equals(v.f29768c) : invokeV.booleanValue;
    }

    public static Point u0(c.i.b.a.b0.a aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLL;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, aVar, format)) == null) {
            boolean z = format.height > format.width;
            int i2 = z ? format.height : format.width;
            int i3 = z ? format.width : format.height;
            float f2 = i3 / i2;
            for (int i4 : O0) {
                int i5 = (int) (i4 * f2);
                if (i4 <= i2 || i5 <= i3) {
                    break;
                }
                if (v.a >= 21) {
                    int i6 = z ? i5 : i4;
                    if (!z) {
                        i4 = i5;
                    }
                    Point b2 = aVar.b(i6, i4);
                    if (aVar.n(b2.x, b2.y, format.frameRate)) {
                        return b2;
                    }
                } else {
                    int f3 = v.f(i4, 16) * 16;
                    int f4 = v.f(i5, 16) * 16;
                    if (f3 * f4 <= MediaCodecUtil.l()) {
                        int i7 = z ? f4 : f3;
                        if (!z) {
                            f3 = f4;
                        }
                        return new Point(i7, f3);
                    }
                }
            }
            return null;
        }
        return (Point) invokeLL.objValue;
    }

    public static int w0(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, format)) == null) {
            if (format.maxInputSize != -1) {
                int size = format.initializationData.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += format.initializationData.get(i3).length;
                }
                return format.maxInputSize + i2;
            }
            return x0(format.sampleMimeType, format.width, format.height);
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int x0(String str, int i2, int i3) {
        InterceptResult invokeLII;
        char c2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65549, null, str, i2, i3)) == null) {
            if (i2 == -1 || i3 == -1) {
                return -1;
            }
            int i5 = 4;
            switch (str.hashCode()) {
                case -1664118616:
                    if (str.equals("video/3gpp")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1662541442:
                    if (str.equals("video/hevc")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1187890754:
                    if (str.equals("video/mp4v-es")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1331836730:
                    if (str.equals("video/avc")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1599127256:
                    if (str.equals("video/x-vnd.on2.vp8")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1599127257:
                    if (str.equals("video/x-vnd.on2.vp9")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0 && c2 != 1) {
                if (c2 == 2) {
                    if ("BRAVIA 4K 2015".equals(v.f29769d)) {
                        return -1;
                    }
                    i4 = v.f(i2, 16) * v.f(i3, 16) * 16 * 16;
                    i5 = 2;
                    return (i4 * 3) / (i5 * 2);
                } else if (c2 != 3) {
                    if (c2 == 4 || c2 == 5) {
                        i4 = i2 * i3;
                        return (i4 * 3) / (i5 * 2);
                    }
                    return -1;
                }
            }
            i4 = i2 * i3;
            i5 = 2;
            return (i4 * 3) / (i5 * 2);
        }
        return invokeLII.intValue;
    }

    public static float z0(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, format)) == null) {
            float f2 = format.pixelWidthHeightRatio;
            if (f2 == -1.0f) {
                return 1.0f;
            }
            return f2;
        }
        return invokeL.floatValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c.i.b.a.a
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.u0 = -9223372036854775807L;
            E0();
            super.A();
        }
    }

    @Override // c.i.b.a.a
    public void B(Format[] formatArr, long j2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, formatArr, j2) == null) {
            this.g0 = formatArr;
            if (this.M0 == -9223372036854775807L) {
                this.M0 = j2;
            } else {
                int i2 = this.N0;
                if (i2 == this.f0.length) {
                    String str = "Too many stream changes, so dropping offset: " + this.f0[this.N0 - 1];
                } else {
                    this.N0 = i2 + 1;
                }
                this.f0[this.N0 - 1] = j2;
            }
            super.B(formatArr, j2);
        }
    }

    public boolean D0(MediaCodec mediaCodec, int i2, long j2, long j3) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            int D = D(j3);
            if (D == 0) {
                return false;
            }
            this.X.f29982i++;
            T0(this.y0 + D);
            Q();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.w0 <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.b0.d(this.w0, elapsedRealtime - this.v0);
        this.w0 = 0;
        this.v0 = elapsedRealtime;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean F(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{mediaCodec, Boolean.valueOf(z), format, format2})) == null) {
            if (n0(z, format, format2)) {
                int i2 = format2.width;
                b bVar = this.h0;
                if (i2 <= bVar.a && format2.height <= bVar.f29799b && w0(format2) <= this.h0.f29800c) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.s0) {
            return;
        }
        this.s0 = true;
        this.b0.g(this.k0);
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.B0 == -1 && this.C0 == -1) {
                return;
            }
            if (this.F0 == this.B0 && this.G0 == this.C0 && this.H0 == this.D0 && this.I0 == this.E0) {
                return;
            }
            this.b0.h(this.B0, this.C0, this.D0, this.E0);
            this.F0 = this.B0;
            this.G0 = this.C0;
            this.H0 = this.D0;
            this.I0 = this.E0;
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.s0) {
            this.b0.g(this.k0);
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.F0 == -1 && this.G0 == -1) {
                return;
            }
            this.b0.h(this.F0, this.G0, this.H0, this.I0);
        }
    }

    public void J0(MediaCodec mediaCodec, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            G0();
            t.a("releaseOutputBuffer");
            mediaCodec.releaseOutputBuffer(i2, true);
            t.c();
            this.X.f29978e++;
            this.x0 = 0;
            F0();
        }
    }

    @TargetApi(21)
    public void K0(MediaCodec mediaCodec, int i2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            G0();
            t.a("releaseOutputBuffer");
            mediaCodec.releaseOutputBuffer(i2, j3);
            t.c();
            this.X.f29978e++;
            this.x0 = 0;
            F0();
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.u0 = this.c0 > 0 ? SystemClock.elapsedRealtime() + this.c0 : -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void N(c.i.b.a.b0.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, aVar, mediaCodec, format, mediaCrypto) == null) {
            b v0 = v0(aVar, format, this.g0);
            this.h0 = v0;
            MediaFormat y0 = y0(format, v0, this.e0, this.K0);
            if (this.k0 == null) {
                c.i.b.a.i0.a.f(R0(aVar.f29026d));
                if (this.q0 == null) {
                    this.q0 = DummySurface.newInstanceV17(this.Z, aVar.f29026d);
                }
                this.k0 = this.q0;
            }
            mediaCodec.configure(y0, this.k0, mediaCrypto, 0);
            if (v.a < 23 || !this.J0) {
                return;
            }
            this.L0 = new C1670c(this, mediaCodec, null);
        }
    }

    public final void N0(Surface surface) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surface) == null) {
            if (surface == null) {
                Surface surface2 = this.q0;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    c.i.b.a.b0.a S = S();
                    if (S != null && R0(S.f29026d)) {
                        surface = DummySurface.newInstanceV17(this.Z, S.f29026d);
                        this.q0 = surface;
                    }
                }
            }
            if (this.k0 != surface) {
                this.k0 = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec R = R();
                    if (v.a >= 23 && R != null && surface != null && !this.i0) {
                        M0(R, surface);
                    } else {
                        g0();
                        W();
                    }
                }
                if (surface != null && surface != this.q0) {
                    I0();
                    o0();
                    if (state == 2) {
                        L0();
                        return;
                    }
                    return;
                }
                p0();
                o0();
            } else if (surface == null || surface == this.q0) {
            } else {
                I0();
                H0();
            }
        }
    }

    public boolean P0(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? C0(j2) : invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void Q() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.Q();
            this.y0 = 0;
            this.t0 = false;
        }
    }

    public boolean Q0(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? B0(j2) : invokeCommon.booleanValue;
    }

    public final boolean R0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) ? v.a >= 23 && !this.J0 && (!z || DummySurface.isSecureSupported(this.Z)) : invokeZ.booleanValue;
    }

    public void S0(MediaCodec mediaCodec, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            t.a("skipVideoBuffer");
            mediaCodec.releaseOutputBuffer(i2, false);
            t.c();
            this.X.f29979f++;
        }
    }

    public void T0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            c.i.b.a.y.d dVar = this.X;
            dVar.f29980g += i2;
            this.w0 += i2;
            int i3 = this.x0 + i2;
            this.x0 = i3;
            dVar.f29981h = Math.max(i3, dVar.f29981h);
            if (this.w0 >= this.d0) {
                E0();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void X(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.b0.b(str, j2, j3);
            this.i0 = q0(str);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Y(Format format) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, format) == null) {
            super.Y(format);
            this.b0.f(format);
            this.A0 = z0(format);
            this.z0 = A0(format);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Z(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, mediaCodec, mediaFormat) == null) {
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            if (z) {
                integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            this.B0 = integer;
            if (z) {
                integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            this.C0 = integer2;
            this.E0 = this.A0;
            if (v.a >= 21) {
                int i2 = this.z0;
                if (i2 == 90 || i2 == 270) {
                    int i3 = this.B0;
                    this.B0 = this.C0;
                    this.C0 = i3;
                    this.E0 = 1.0f / this.E0;
                }
            } else {
                this.D0 = this.z0;
            }
            O0(mediaCodec, this.r0);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void a0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            this.y0--;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void b0(c.i.b.a.y.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, eVar) == null) {
            this.y0++;
            if (v.a >= 23 || !this.J0) {
                return;
            }
            F0();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean d0(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        long j5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), mediaCodec, byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j4), Boolean.valueOf(z)})) == null) {
            while (true) {
                int i4 = this.N0;
                if (i4 == 0) {
                    break;
                }
                long[] jArr = this.f0;
                if (j4 < jArr[0]) {
                    break;
                }
                this.M0 = jArr[0];
                int i5 = i4 - 1;
                this.N0 = i5;
                System.arraycopy(jArr, 1, jArr, 0, i5);
            }
            long j6 = j4 - this.M0;
            if (z) {
                S0(mediaCodec, i2, j6);
                return true;
            }
            long j7 = j4 - j2;
            if (this.k0 == this.q0) {
                if (B0(j7)) {
                    this.t0 = false;
                    S0(mediaCodec, i2, j6);
                    return true;
                }
                return false;
            } else if (this.s0 && !this.t0) {
                if (getState() != 2) {
                    return false;
                }
                long elapsedRealtime = j7 - ((SystemClock.elapsedRealtime() * 1000) - j3);
                long nanoTime = System.nanoTime();
                long b2 = this.a0.b(j4, nanoTime + (elapsedRealtime * 1000));
                long j8 = (b2 - nanoTime) / 1000;
                if (!P0(j8, j3)) {
                    j5 = j8;
                } else if (D0(mediaCodec, i2, j6, j2)) {
                    this.t0 = true;
                    return false;
                } else {
                    j5 = j8;
                }
                if (Q0(j5, j3)) {
                    t0(mediaCodec, i2, j6);
                    return true;
                }
                if (v.a >= 21) {
                    if (j5 < 50000) {
                        K0(mediaCodec, i2, j6, b2);
                        return true;
                    }
                } else if (j5 < 30000) {
                    if (j5 > 11000) {
                        try {
                            Thread.sleep((j5 - 10000) / 1000);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    J0(mediaCodec, i2, j6);
                    return true;
                }
                return false;
            } else {
                this.t0 = false;
                if (v.a >= 21) {
                    K0(mediaCodec, i2, j6, System.nanoTime());
                } else {
                    J0(mediaCodec, i2, j6);
                }
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            try {
                super.g0();
            } finally {
                this.y0 = 0;
                this.t0 = false;
                Surface surface = this.q0;
                if (surface != null) {
                    if (this.k0 == surface) {
                        this.k0 = null;
                    }
                    this.q0.release();
                    this.q0 = null;
                }
            }
        }
    }

    @Override // c.i.b.a.a, c.i.b.a.g.a
    public void h(int i2, Object obj) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i2, obj) == null) {
            if (i2 == 1) {
                N0((Surface) obj);
            } else if (i2 == 4) {
                this.r0 = ((Integer) obj).intValue();
                MediaCodec R = R();
                if (R != null) {
                    O0(R, this.r0);
                }
            } else {
                super.h(i2, obj);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean i0(c.i.b.a.b0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, aVar)) == null) ? this.k0 != null || R0(aVar.f29026d) : invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c.i.b.a.r
    public boolean isReady() {
        InterceptResult invokeV;
        Surface surface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (super.isReady() && (this.s0 || (((surface = this.q0) != null && this.k0 == surface) || R() == null || this.J0))) {
                this.u0 = -9223372036854775807L;
                return true;
            } else if (this.u0 == -9223372036854775807L) {
                return false;
            } else {
                if (SystemClock.elapsedRealtime() < this.u0) {
                    return true;
                }
                this.u0 = -9223372036854775807L;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int l0(c.i.b.a.b0.b bVar, c.i.b.a.z.a<c.i.b.a.z.c> aVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLL;
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, bVar, aVar, format)) == null) {
            String str = format.sampleMimeType;
            if (i.i(str)) {
                DrmInitData drmInitData = format.drmInitData;
                if (drmInitData != null) {
                    z = false;
                    for (int i4 = 0; i4 < drmInitData.schemeDataCount; i4++) {
                        z |= drmInitData.get(i4).requiresSecureDecryption;
                    }
                } else {
                    z = false;
                }
                c.i.b.a.b0.a a2 = bVar.a(str, z);
                if (a2 == null) {
                    return (!z || bVar.a(str, false) == null) ? 1 : 2;
                } else if (c.i.b.a.a.E(aVar, drmInitData)) {
                    boolean i5 = a2.i(format.codecs);
                    if (i5 && (i2 = format.width) > 0 && (i3 = format.height) > 0) {
                        if (v.a >= 21) {
                            i5 = a2.n(i2, i3, format.frameRate);
                        } else {
                            boolean z2 = i2 * i3 <= MediaCodecUtil.l();
                            if (!z2) {
                                String str2 = "FalseCheck [legacyFrameSize, " + format.width + "x" + format.height + "] [" + v.f29770e + PreferencesUtil.RIGHT_MOUNT;
                            }
                            i5 = z2;
                        }
                    }
                    return (i5 ? 4 : 3) | (a2.f29024b ? 16 : 8) | (a2.f29025c ? 32 : 0);
                } else {
                    return 2;
                }
            }
            return 0;
        }
        return invokeLLL.intValue;
    }

    public final void o0() {
        MediaCodec R;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.s0 = false;
            if (v.a < 23 || !this.J0 || (R = R()) == null) {
                return;
            }
            this.L0 = new C1670c(this, R, null);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.F0 = -1;
            this.G0 = -1;
            this.I0 = -1.0f;
            this.H0 = -1;
        }
    }

    public void t0(MediaCodec mediaCodec, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{mediaCodec, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            t.a("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i2, false);
            t.c();
            T0(1);
        }
    }

    public b v0(c.i.b.a.b0.a aVar, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, aVar, format, formatArr)) == null) {
            int i2 = format.width;
            int i3 = format.height;
            int w0 = w0(format);
            if (formatArr.length == 1) {
                return new b(i2, i3, w0);
            }
            boolean z = false;
            for (Format format2 : formatArr) {
                if (n0(aVar.f29024b, format, format2)) {
                    z |= format2.width == -1 || format2.height == -1;
                    i2 = Math.max(i2, format2.width);
                    i3 = Math.max(i3, format2.height);
                    w0 = Math.max(w0, w0(format2));
                }
            }
            if (z) {
                String str = "Resolutions unknown. Codec max resolution: " + i2 + "x" + i3;
                Point u0 = u0(aVar, format);
                if (u0 != null) {
                    i2 = Math.max(i2, u0.x);
                    i3 = Math.max(i3, u0.y);
                    w0 = Math.max(w0, x0(format.sampleMimeType, i2, i3));
                    String str2 = "Codec max resolution adjusted to: " + i2 + "x" + i3;
                }
            }
            return new b(i2, i3, w0);
        }
        return (b) invokeLLL.objValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c.i.b.a.a
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.B0 = -1;
            this.C0 = -1;
            this.E0 = -1.0f;
            this.A0 = -1.0f;
            this.M0 = -9223372036854775807L;
            this.N0 = 0;
            p0();
            o0();
            this.a0.d();
            this.L0 = null;
            this.J0 = false;
            try {
                super.w();
            } finally {
                this.X.a();
                this.b0.c(this.X);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c.i.b.a.a
    public void x(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            super.x(z);
            int i2 = t().a;
            this.K0 = i2;
            this.J0 = i2 != 0;
            this.b0.e(this.X);
            this.a0.e();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c.i.b.a.a
    public void y(long j2, boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            super.y(j2, z);
            o0();
            this.x0 = 0;
            int i2 = this.N0;
            if (i2 != 0) {
                this.M0 = this.f0[i2 - 1];
                this.N0 = 0;
            }
            if (z) {
                L0();
            } else {
                this.u0 = -9223372036854775807L;
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat y0(Format format, b bVar, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{format, bVar, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            MediaFormat frameworkMediaFormatV16 = format.getFrameworkMediaFormatV16();
            frameworkMediaFormatV16.setInteger("max-width", bVar.a);
            frameworkMediaFormatV16.setInteger("max-height", bVar.f29799b);
            int i3 = bVar.f29800c;
            if (i3 != -1) {
                frameworkMediaFormatV16.setInteger("max-input-size", i3);
            }
            if (z) {
                frameworkMediaFormatV16.setInteger("auto-frc", 0);
            }
            if (i2 != 0) {
                r0(frameworkMediaFormatV16, i2);
            }
            return frameworkMediaFormatV16;
        }
        return (MediaFormat) invokeCommon.objValue;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, c.i.b.a.a
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.z();
            this.w0 = 0;
            this.v0 = SystemClock.elapsedRealtime();
        }
    }
}
