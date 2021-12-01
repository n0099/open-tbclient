package c.a.x0.t;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static MediaCodec a(MediaFormat mediaFormat) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mediaFormat)) == null) {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(i(mediaFormat));
            createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.start();
            return createDecoderByType;
        }
        return (MediaCodec) invokeL.objValue;
    }

    public static MediaExtractor b(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            return mediaExtractor;
        }
        return (MediaExtractor) invokeL.objValue;
    }

    public static MediaCodec c(MediaFormat mediaFormat, Surface surface) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, mediaFormat, surface)) == null) {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(i(mediaFormat));
            createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            createDecoderByType.start();
            return createDecoderByType;
        }
        return (MediaCodec) invokeLL.objValue;
    }

    public static MediaCodec d(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, mediaCodecInfo, mediaFormat, atomicReference)) == null) {
            MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
            createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            atomicReference.set(createByCodecName.createInputSurface());
            createByCodecName.start();
            return createByCodecName;
        }
        return (MediaCodec) invokeLLL.objValue;
    }

    public static int e(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaExtractor)) == null) {
            for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                if (j(mediaExtractor.getTrackFormat(i2))) {
                    mediaExtractor.selectTrack(i2);
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int f(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, mediaExtractor)) == null) {
            for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                if (k(mediaExtractor.getTrackFormat(i2))) {
                    mediaExtractor.selectTrack(i2);
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String g(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, th)) == null) ? h(th, 5) : (String) invokeL.objValue;
    }

    public static String h(Throwable th, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, th, i2)) == null) {
            if (th == null) {
                return "no exception";
            }
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                if (i2 > stackTrace.length) {
                    i2 = stackTrace.length;
                }
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < i2; i3++) {
                    StackTraceElement stackTraceElement = stackTrace[i3];
                    if (i3 == 0) {
                        sb.append("->");
                        sb.append(th.toString());
                    }
                    sb.append("->");
                    sb.append("at ");
                    sb.append(stackTraceElement.getClassName());
                    sb.append(".");
                    sb.append(stackTraceElement.getMethodName());
                    sb.append("(");
                    sb.append(stackTraceElement.getFileName());
                    sb.append(":");
                    sb.append(stackTraceElement.getLineNumber());
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                }
                return sb.toString();
            }
            return th.toString();
        }
        return (String) invokeLI.objValue;
    }

    @RequiresApi(api = 16)
    public static String i(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, mediaFormat)) == null) ? mediaFormat.getString("mime") : (String) invokeL.objValue;
    }

    @RequiresApi(api = 16)
    public static boolean j(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, mediaFormat)) == null) ? i(mediaFormat).startsWith("audio/") : invokeL.booleanValue;
    }

    public static boolean k(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, mediaFormat)) == null) ? i(mediaFormat).startsWith(FileUtils.VIDEO_FILE_START) : invokeL.booleanValue;
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        c.j(str, str2);
    }

    public static MediaCodecInfo m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    public static void n(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65549, null, mediaFormat, mediaFormat2, str, i2) == null) {
            if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
                i2 = mediaFormat.getInteger(str);
            }
            if (mediaFormat2 != null) {
                mediaFormat2.setInteger(str, i2);
            }
        }
    }
}
