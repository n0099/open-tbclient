package com.baidu.rtc;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class SdpPrefer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUDIO_CODEC_PARAM_BITRATE = "maxaveragebitrate";
    public static final String AUDIO_MAX_CAPTURER_RATE = "sprop-maxcapturerate";
    public static final String AUDIO_MAX_PLAYBACK_RATE = "maxplaybackrate";
    public static final String AUDIO_STEREO = "stereo";
    public static final String AUDIO_USE_DTX = "usedtx";
    public static final String CBR = "cbr";
    public static final String TAG = "SdpPrefer";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class AudioSdpAttribute {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean cbr;
        public int maxaveragebitrate;
        public int maxplaybackrate;
        public int sprop_maxcapturerate;
        public boolean stereo;
        public boolean usedtx;
        public boolean useinbandfec;

        public AudioSdpAttribute() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cbr = false;
            this.useinbandfec = true;
            this.maxplaybackrate = -1;
            this.sprop_maxcapturerate = -1;
            this.maxaveragebitrate = -1;
            this.usedtx = false;
            this.stereo = false;
        }
    }

    public SdpPrefer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int findMediaDescriptionLine(boolean z, String[] strArr) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65537, null, z, strArr)) == null) {
            String str = z ? "m=audio " : "m=video ";
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].startsWith(str)) {
                    return i;
                }
            }
            return -1;
        }
        return invokeZL.intValue;
    }

    public static String handleCandidate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Matcher matcher = Pattern.compile("([0-9]{1,3}(\\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})").matcher(str);
            return matcher.find() ? matcher.group(1) : "";
        }
        return (String) invokeL.objValue;
    }

    public static String parseRemoteMediaIp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String[] split = str.split("\r\n");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains("a=candidate:")) {
                    String handleCandidate = handleCandidate(split[i]);
                    return handleCandidate == null ? "" : handleCandidate;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String setAudioAttributes(String str, String str2, AudioSdpAttribute audioSdpAttribute) {
        InterceptResult invokeLLL;
        String str3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, audioSdpAttribute)) == null) {
            String[] split = str2.split("\r\n");
            Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + str + "(/\\d+)+[\r]?$");
            int i = 0;
            while (true) {
                if (i >= split.length) {
                    i = -1;
                    str3 = null;
                    break;
                }
                Matcher matcher = compile.matcher(split[i]);
                if (matcher.matches()) {
                    str3 = matcher.group(1);
                    break;
                }
                i++;
            }
            if (str3 == null) {
                Log.w(TAG, "No rtpmap for " + str + " codec");
                return str2;
            }
            Log.d(TAG, "Found " + str + " rtpmap " + str3 + " at " + split[i]);
            StringBuilder sb = new StringBuilder();
            sb.append("^a=fmtp:");
            sb.append(str3);
            sb.append(" \\w+=\\d+.*[\r]?$");
            Pattern compile2 = Pattern.compile(sb.toString());
            int i2 = 0;
            while (true) {
                if (i2 >= split.length) {
                    z = false;
                    break;
                } else if (compile2.matcher(split[i2]).matches()) {
                    Log.d(TAG, "Found " + str + " " + split[i2]);
                    split[i2] = setAudioFmptParam(split[i2], audioSdpAttribute, false);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Update remote SDP line: ");
                    sb2.append(split[i2]);
                    Log.d(TAG, sb2.toString());
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            StringBuilder sb3 = new StringBuilder();
            for (int i3 = 0; i3 < split.length; i3++) {
                sb3.append(split[i3]);
                sb3.append("\r\n");
                if (!z && i3 == i) {
                    String audioFmptParam = setAudioFmptParam("a=fmtp:" + str3 + " ", audioSdpAttribute, true);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Add local SDP line: ");
                    sb4.append(audioFmptParam);
                    Log.d(TAG, sb4.toString());
                    sb3.append(audioFmptParam);
                    sb3.append("\r\n");
                }
            }
            return sb3.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static String setAudioFmptParam(String str, AudioSdpAttribute audioSdpAttribute, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, audioSdpAttribute, z)) == null) {
            boolean z3 = false;
            String str2 = "";
            if (audioSdpAttribute.maxplaybackrate > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(z ? "" : "; ");
                sb.append(AUDIO_MAX_PLAYBACK_RATE);
                sb.append("=");
                sb.append(audioSdpAttribute.maxplaybackrate);
                str = sb.toString();
                z2 = false;
            } else {
                z2 = true;
            }
            if (audioSdpAttribute.sprop_maxcapturerate > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append((z2 && z) ? "" : "; ");
                sb2.append(AUDIO_MAX_CAPTURER_RATE);
                sb2.append("=");
                sb2.append(audioSdpAttribute.maxplaybackrate);
                str = sb2.toString();
                z2 = false;
            }
            if (audioSdpAttribute.cbr) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append((z2 && z) ? "" : "; ");
                sb3.append(CBR);
                sb3.append("=");
                sb3.append(audioSdpAttribute.cbr ? '1' : '0');
                str = sb3.toString();
                z2 = false;
            }
            if (audioSdpAttribute.maxaveragebitrate > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append((z2 && z) ? "" : "; ");
                sb4.append(AUDIO_CODEC_PARAM_BITRATE);
                sb4.append("=");
                sb4.append(audioSdpAttribute.maxaveragebitrate * 1000);
                str = sb4.toString();
                z2 = false;
            }
            if (audioSdpAttribute.usedtx) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append((z2 && z) ? "" : "; ");
                sb5.append(AUDIO_USE_DTX);
                sb5.append("=");
                sb5.append(audioSdpAttribute.usedtx ? '1' : '0');
                str = sb5.toString();
            } else {
                z3 = z2;
            }
            if (audioSdpAttribute.stereo) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append((z3 && z) ? "; " : "; ");
                sb6.append(AUDIO_STEREO);
                sb6.append("=");
                sb6.append(audioSdpAttribute.stereo ? '1' : '0');
                return sb6.toString();
            }
            return str;
        }
        return (String) invokeLLZ.objValue;
    }
}
