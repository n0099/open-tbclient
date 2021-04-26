package com.baidu.rtc;

import android.util.Log;
import com.android.internal.http.multipart.Part;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class SdpPrefer {
    public static final String AUDIO_CODEC_PARAM_BITRATE = "maxaveragebitrate";
    public static final String AUDIO_MAX_CAPTURER_RATE = "sprop-maxcapturerate";
    public static final String AUDIO_MAX_PLAYBACK_RATE = "maxplaybackrate";
    public static final String AUDIO_STEREO = "stereo";
    public static final String AUDIO_USE_DTX = "usedtx";
    public static final String CBR = "cbr";
    public static final String TAG = "SdpPrefer";

    /* loaded from: classes2.dex */
    public static class AudioSdpAttribute {
        public boolean cbr = false;
        public boolean useinbandfec = true;
        public int maxplaybackrate = -1;
        public int sprop_maxcapturerate = -1;
        public int maxaveragebitrate = -1;
        public boolean usedtx = false;
        public boolean stereo = false;
    }

    public static int findMediaDescriptionLine(boolean z, String[] strArr) {
        String str = z ? "m=audio " : "m=video ";
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2].startsWith(str)) {
                return i2;
            }
        }
        return -1;
    }

    public static String handleCandidate(String str) {
        Matcher matcher = Pattern.compile("([0-9]{1,3}(\\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})").matcher(str);
        return matcher.find() ? matcher.group(1) : "";
    }

    public static String parseRemoteMediaIp(String str) {
        String[] split = str.split(Part.CRLF);
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].contains("a=candidate:")) {
                String handleCandidate = handleCandidate(split[i2]);
                return handleCandidate == null ? "" : handleCandidate;
            }
        }
        return "";
    }

    public static String setAudioAttributes(String str, String str2, AudioSdpAttribute audioSdpAttribute) {
        String str3;
        boolean z;
        String[] split = str2.split(Part.CRLF);
        Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + str + "(/\\d+)+[\r]?$");
        int i2 = 0;
        while (true) {
            if (i2 >= split.length) {
                i2 = -1;
                str3 = null;
                break;
            }
            Matcher matcher = compile.matcher(split[i2]);
            if (matcher.matches()) {
                str3 = matcher.group(1);
                break;
            }
            i2++;
        }
        if (str3 == null) {
            Log.w(TAG, "No rtpmap for " + str + " codec");
            return str2;
        }
        Log.d(TAG, "Found " + str + " rtpmap " + str3 + " at " + split[i2]);
        StringBuilder sb = new StringBuilder();
        sb.append("^a=fmtp:");
        sb.append(str3);
        sb.append(" \\w+=\\d+.*[\r]?$");
        Pattern compile2 = Pattern.compile(sb.toString());
        int i3 = 0;
        while (true) {
            if (i3 >= split.length) {
                z = false;
                break;
            } else if (compile2.matcher(split[i3]).matches()) {
                Log.d(TAG, "Found " + str + " " + split[i3]);
                split[i3] = setAudioFmptParam(split[i3], audioSdpAttribute, false);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Update remote SDP line: ");
                sb2.append(split[i3]);
                Log.d(TAG, sb2.toString());
                z = true;
                break;
            } else {
                i3++;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        for (int i4 = 0; i4 < split.length; i4++) {
            sb3.append(split[i4]);
            sb3.append(Part.CRLF);
            if (!z && i4 == i2) {
                String audioFmptParam = setAudioFmptParam("a=fmtp:" + str3 + " ", audioSdpAttribute, true);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Add local SDP line: ");
                sb4.append(audioFmptParam);
                Log.d(TAG, sb4.toString());
                sb3.append(audioFmptParam);
                sb3.append(Part.CRLF);
            }
        }
        return sb3.toString();
    }

    public static String setAudioFmptParam(String str, AudioSdpAttribute audioSdpAttribute, boolean z) {
        boolean z2;
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
}
