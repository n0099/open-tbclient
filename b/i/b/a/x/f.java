package b.i.b.a.x;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.qrcodescanner.beans.QRCodeScannerBeanFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
import java.nio.ByteBuffer;
import org.apache.commons.codec.digest4util.PureJavaCrc32C;
/* loaded from: classes6.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f32844a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f32845b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f32846c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1537240634, "Lb/i/b/a/x/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1537240634, "Lb/i/b/a/x/f;");
                return;
            }
        }
        f32844a = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        f32845b = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, MediaEncodeParams.AUDIO_SAMPLE_RATE, -1, -1};
        f32846c = new int[]{64, 112, 128, 192, 224, 256, 384, FileUtils.S_IRWXU, 512, 640, 768, 896, 1024, MP3TrackImpl.SAMPLES_PER_FRAME, 1280, PureJavaCrc32C.T8_6_start, 1920, 2048, 2304, QRCodeScannerBeanFactory.QRCODE_WHITE_LIST, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    }

    public static int a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? (((bArr[7] & 240) >> 4) | ((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) + 1 : invokeL.intValue;
    }

    public static int b(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, byteBuffer)) == null) {
            int position = byteBuffer.position();
            return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
        }
        return invokeL.intValue;
    }

    public static int c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? ((((bArr[5] & 252) >> 2) | ((bArr[4] & 1) << 6)) + 1) * 32 : invokeL.intValue;
    }

    public static Format d(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, str, str2, drmInitData)) == null) {
            b.i.b.a.i0.k kVar = new b.i.b.a.i0.k(bArr);
            kVar.n(60);
            int i2 = f32844a[kVar.g(6)];
            int i3 = f32845b[kVar.g(4)];
            int g2 = kVar.g(5);
            int[] iArr = f32846c;
            int i4 = g2 >= iArr.length ? -1 : (iArr[g2] * 1000) / 2;
            kVar.n(10);
            return Format.createAudioSampleFormat(str, "audio/vnd.dts", null, i4, -1, i2 + (kVar.g(2) > 0 ? 1 : 0), i3, null, drmInitData, 0, str2);
        }
        return (Format) invokeLLLL.objValue;
    }
}
