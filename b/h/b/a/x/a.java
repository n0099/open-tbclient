package b.h.b.a.x;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.view.InputDeviceCompat;
import b.h.b.a.i0.l;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.nio.ByteBuffer;
import org.apache.commons.codec.digest4util.PureJavaCrc32C;
import org.apache.http.HttpStatus;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f33654a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f33655b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f33656c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f33657d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f33658e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f33659f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.h.b.a.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C1537a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f33660a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33661b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33662c;

        /* renamed from: d  reason: collision with root package name */
        public final int f33663d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33664e;

        public /* synthetic */ b(String str, int i2, int i3, int i4, int i5, int i6, C1537a c1537a) {
            this(str, i2, i3, i4, i5, i6);
        }

        public b(String str, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33660a = str;
            this.f33662c = i3;
            this.f33661b = i4;
            this.f33663d = i5;
            this.f33664e = i6;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1340727284, "Lb/h/b/a/x/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1340727284, "Lb/h/b/a/x/a;");
                return;
            }
        }
        f33654a = new int[]{1, 2, 3, 6};
        f33655b = new int[]{MediaEncodeParams.AUDIO_SAMPLE_RATE, 44100, 32000};
        f33656c = new int[]{24000, 22050, 16000};
        f33657d = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
        f33658e = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 384, FileUtils.S_IRWXU, 512, 576, 640};
        f33659f = new int[]{69, 87, 104, 121, 139, 174, 208, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, 278, 348, HttpStatus.SC_EXPECTATION_FAILED, 487, 557, 696, SDKLogTypeConstants.TYPE_OAID_STATUS, 975, 1114, 1253, 1393};
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? PureJavaCrc32C.T8_6_start : invokeV.intValue;
    }

    public static int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            int i4 = i3 / 2;
            if (i2 >= 0) {
                int[] iArr = f33655b;
                if (i2 >= iArr.length || i3 < 0) {
                    return -1;
                }
                int[] iArr2 = f33659f;
                if (i4 >= iArr2.length) {
                    return -1;
                }
                int i5 = iArr[i2];
                if (i5 == 44100) {
                    return (iArr2[i4] + (i3 % 2)) * 2;
                }
                int i6 = f33658e[i4];
                return i5 == 32000 ? i6 * 6 : i6 * 4;
            }
            return -1;
        }
        return invokeII.intValue;
    }

    public static Format c(l lVar, String str, String str2, DrmInitData drmInitData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, lVar, str, str2, drmInitData)) == null) {
            int i2 = f33655b[(lVar.x() & 192) >> 6];
            int x = lVar.x();
            int i3 = f33657d[(x & 56) >> 3];
            if ((x & 4) != 0) {
                i3++;
            }
            return Format.createAudioSampleFormat(str, "audio/ac3", null, -1, -1, i3, i2, null, drmInitData, 0, str2);
        }
        return (Format) invokeLLLL.objValue;
    }

    public static b d(b.h.b.a.i0.k kVar) {
        InterceptResult invokeL;
        int i2;
        int i3;
        int i4;
        String str;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, kVar)) == null) {
            int e2 = kVar.e();
            kVar.n(40);
            boolean z = kVar.g(5) == 16;
            kVar.l(e2);
            int i8 = 6;
            if (z) {
                kVar.n(16);
                int g2 = kVar.g(2);
                kVar.n(3);
                int g3 = (kVar.g(11) + 1) * 2;
                int g4 = kVar.g(2);
                if (g4 == 3) {
                    i7 = f33656c[kVar.g(2)];
                } else {
                    i8 = f33654a[kVar.g(2)];
                    i7 = f33655b[g4];
                }
                i4 = kVar.g(3);
                i5 = g2;
                i3 = g3;
                i2 = i7;
                i6 = i8 * 256;
                str = "audio/eac3";
            } else {
                kVar.n(32);
                int g5 = kVar.g(2);
                int b2 = b(g5, kVar.g(6));
                kVar.n(8);
                int g6 = kVar.g(3);
                if ((g6 & 1) != 0 && g6 != 1) {
                    kVar.n(2);
                }
                if ((g6 & 4) != 0) {
                    kVar.n(2);
                }
                if (g6 == 2) {
                    kVar.n(2);
                }
                i2 = f33655b[g5];
                i3 = b2;
                i4 = g6;
                str = "audio/ac3";
                i5 = -1;
                i6 = PureJavaCrc32C.T8_6_start;
            }
            return new b(str, i5, f33657d[i4] + (kVar.f() ? 1 : 0), i2, i3, i6, null);
        }
        return (b) invokeL.objValue;
    }

    public static int e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            if (bArr.length < 5) {
                return -1;
            }
            return b((bArr[4] & 192) >> 6, bArr[4] & 63);
        }
        return invokeL.intValue;
    }

    public static Format f(l lVar, String str, String str2, DrmInitData drmInitData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, lVar, str, str2, drmInitData)) == null) {
            lVar.K(2);
            int i2 = f33655b[(lVar.x() & 192) >> 6];
            int x = lVar.x();
            int i3 = f33657d[(x & 14) >> 1];
            if ((x & 1) != 0) {
                i3++;
            }
            if (((lVar.x() & 30) >> 1) > 0 && (2 & lVar.x()) != 0) {
                i3 += 2;
            }
            return Format.createAudioSampleFormat(str, "audio/eac3", null, -1, -1, i3, i2, null, drmInitData, 0, str2);
        }
        return (Format) invokeLLLL.objValue;
    }

    public static int g(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, byteBuffer)) == null) {
            return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? f33654a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
        }
        return invokeL.intValue;
    }
}
