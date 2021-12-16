package c.i.b.a.i0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes9.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str == null) {
                return null;
            }
            for (String str2 : str.split(",")) {
                String b2 = b(str2);
                if (b2 != null && g(b2)) {
                    return b2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return null;
            }
            String trim = str.trim();
            if (trim.startsWith(VisualSampleEntry.TYPE3) || trim.startsWith(VisualSampleEntry.TYPE4)) {
                return "video/avc";
            }
            if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
                return "video/hevc";
            }
            if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
                return "video/x-vnd.on2.vp9";
            }
            if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
                return "video/x-vnd.on2.vp8";
            }
            if (trim.startsWith(AudioSampleEntry.TYPE3)) {
                return "audio/mp4a-latm";
            }
            if (trim.startsWith(AudioSampleEntry.TYPE8) || trim.startsWith(AC3SpecificBox.TYPE)) {
                return "audio/ac3";
            }
            if (trim.startsWith(AudioSampleEntry.TYPE9) || trim.startsWith(EC3SpecificBox.TYPE)) {
                return "audio/eac3";
            }
            if (trim.startsWith("dtsc") || trim.startsWith(AudioSampleEntry.TYPE13)) {
                return "audio/vnd.dts";
            }
            if (trim.startsWith(AudioSampleEntry.TYPE12) || trim.startsWith(AudioSampleEntry.TYPE11)) {
                return "audio/vnd.dts.hd";
            }
            if (trim.startsWith("opus")) {
                return "audio/opus";
            }
            if (trim.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(47);
            if (indexOf != -1) {
                return str.substring(0, indexOf);
            }
            throw new IllegalArgumentException("Invalid mime type: " + str);
        }
        return (String) invokeL.objValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (g(str)) {
                return 1;
            }
            if (i(str)) {
                return 2;
            }
            if (h(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                return 3;
            }
            return ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-camera-motion".equals(str)) ? 4 : -1;
        }
        return invokeL.intValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? d(b(str)) : invokeL.intValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str == null) {
                return null;
            }
            for (String str2 : str.split(",")) {
                String b2 = b(str2);
                if (b2 != null && i(b2)) {
                    return b2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? MediaStreamTrack.AUDIO_TRACK_KIND.equals(c(str)) : invokeL.booleanValue;
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? "text".equals(c(str)) : invokeL.booleanValue;
    }

    public static boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? "video".equals(c(str)) : invokeL.booleanValue;
    }
}
