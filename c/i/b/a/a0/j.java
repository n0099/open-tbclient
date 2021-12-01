package c.i.b.a.a0;

import android.support.v4.media.session.MediaSessionCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes7.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f29012h;

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f29013i;

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f29014j;

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f29015k;
    public static final int[] l;
    public static final int[] m;
    public static final int[] n;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f29016b;

    /* renamed from: c  reason: collision with root package name */
    public int f29017c;

    /* renamed from: d  reason: collision with root package name */
    public int f29018d;

    /* renamed from: e  reason: collision with root package name */
    public int f29019e;

    /* renamed from: f  reason: collision with root package name */
    public int f29020f;

    /* renamed from: g  reason: collision with root package name */
    public int f29021g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-724484936, "Lc/i/b/a/a0/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-724484936, "Lc/i/b/a/a0/j;");
                return;
            }
        }
        f29012h = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
        f29013i = new int[]{44100, MediaEncodeParams.AUDIO_SAMPLE_RATE, 32000};
        f29014j = new int[]{32, 64, 96, 128, 160, 192, w0.Q, 256, 288, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 352, 384, 416, FileUtils.S_IRWXU};
        f29015k = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 144, 160, Opcodes.ARETURN, 192, w0.Q, 256};
        l = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, 192, w0.Q, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 384};
        m = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, w0.Q, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP};
        n = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
                return -1;
            }
            int i8 = f29013i[i6];
            if (i3 == 2) {
                i8 /= 2;
            } else if (i3 == 0) {
                i8 /= 4;
            }
            int i9 = (i2 >>> 9) & 1;
            if (i4 == 3) {
                return ((((i3 == 3 ? f29014j[i5 - 1] : f29015k[i5 - 1]) * w0.X3) / i8) + i9) * 4;
            }
            if (i3 == 3) {
                i7 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
            } else {
                i7 = n[i5 - 1];
            }
            if (i3 == 3) {
                return ((i7 * 144000) / i8) + i9;
            }
            return (((i4 == 1 ? 72000 : 144000) * i7) / i8) + i9;
        }
        return invokeI.intValue;
    }

    public static boolean b(int i2, j jVar) {
        InterceptResult invokeIL;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, jVar)) == null) {
            if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
                return false;
            }
            int i10 = f29013i[i6];
            if (i3 == 2) {
                i10 /= 2;
            } else if (i3 == 0) {
                i10 /= 4;
            }
            int i11 = i10;
            int i12 = (i2 >>> 9) & 1;
            int i13 = MP3TrackImpl.SAMPLES_PER_FRAME;
            if (i4 == 3) {
                i7 = i3 == 3 ? f29014j[i5 - 1] : f29015k[i5 - 1];
                i8 = (((i7 * w0.X3) / i11) + i12) * 4;
                i9 = 384;
            } else {
                if (i3 == 3) {
                    i7 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
                    i8 = ((144000 * i7) / i11) + i12;
                    i9 = MP3TrackImpl.SAMPLES_PER_FRAME;
                } else {
                    i7 = n[i5 - 1];
                    if (i4 == 1) {
                        i13 = 576;
                    }
                    i8 = (((i4 == 1 ? 72000 : 144000) * i7) / i11) + i12;
                    i9 = i13;
                }
            }
            jVar.c(i3, f29012h[3 - i4], i8, i11, ((i2 >> 6) & 3) == 3 ? 1 : 2, i7 * 1000, i9);
            return true;
        }
        return invokeIL.booleanValue;
    }

    public final void c(int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.a = i2;
            this.f29016b = str;
            this.f29017c = i3;
            this.f29018d = i4;
            this.f29019e = i5;
            this.f29020f = i6;
            this.f29021g = i7;
        }
    }
}
