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
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65537, null, z, strArr)) == null) {
            if (z) {
                str = "m=audio ";
            } else {
                str = "m=video ";
            }
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
            if (matcher.find()) {
                return matcher.group(1);
            }
            return "";
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
                    if (handleCandidate == null) {
                        return "";
                    }
                    return handleCandidate;
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
                if (i < split.length) {
                    Matcher matcher = compile.matcher(split[i]);
                    if (matcher.matches()) {
                        str3 = matcher.group(1);
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    str3 = null;
                    break;
                }
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
                if (i2 < split.length) {
                    if (compile2.matcher(split[i2]).matches()) {
                        Log.d(TAG, "Found " + str + " " + split[i2]);
                        split[i2] = setAudioFmptParam(split[i2], audioSdpAttribute, false);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Update remote SDP line: ");
                        sb2.append(split[i2]);
                        Log.d(TAG, sb2.toString());
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    z = false;
                    break;
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
        String str2;
        char c;
        String str3;
        String str4;
        char c2;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, audioSdpAttribute, z)) == null) {
            boolean z3 = false;
            String str7 = "";
            if (audioSdpAttribute.maxplaybackrate > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (z) {
                    str6 = "";
                } else {
                    str6 = "; ";
                }
                sb.append(str6);
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
                if (z2 && z) {
                    str5 = "";
                } else {
                    str5 = "; ";
                }
                sb2.append(str5);
                sb2.append(AUDIO_MAX_CAPTURER_RATE);
                sb2.append("=");
                sb2.append(audioSdpAttribute.maxplaybackrate);
                str = sb2.toString();
                z2 = false;
            }
            char c3 = '1';
            if (audioSdpAttribute.cbr) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                if (z2 && z) {
                    str4 = "";
                } else {
                    str4 = "; ";
                }
                sb3.append(str4);
                sb3.append(CBR);
                sb3.append("=");
                if (audioSdpAttribute.cbr) {
                    c2 = '1';
                } else {
                    c2 = '0';
                }
                sb3.append(c2);
                str = sb3.toString();
                z2 = false;
            }
            if (audioSdpAttribute.maxaveragebitrate > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                if (z2 && z) {
                    str3 = "";
                } else {
                    str3 = "; ";
                }
                sb4.append(str3);
                sb4.append(AUDIO_CODEC_PARAM_BITRATE);
                sb4.append("=");
                sb4.append(audioSdpAttribute.maxaveragebitrate * 1000);
                str = sb4.toString();
                z2 = false;
            }
            if (audioSdpAttribute.usedtx) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                if (z2 && z) {
                    str2 = "";
                } else {
                    str2 = "; ";
                }
                sb5.append(str2);
                sb5.append(AUDIO_USE_DTX);
                sb5.append("=");
                if (audioSdpAttribute.usedtx) {
                    c = '1';
                } else {
                    c = '0';
                }
                sb5.append(c);
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
                if (!audioSdpAttribute.stereo) {
                    c3 = '0';
                }
                sb6.append(c3);
                return sb6.toString();
            }
            return str;
        }
        return (String) invokeLLZ.objValue;
    }
}
