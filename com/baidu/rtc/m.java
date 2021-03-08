package com.baidu.rtc;

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class m {

    /* loaded from: classes9.dex */
    public static class a {
        public boolean cxh = false;
        public boolean cxn = true;
        public int cxj = -1;
        public int cxk = -1;
        public int cxi = -1;
        public boolean cxm = false;
        public boolean cxl = false;
    }

    public static String a(String str, a aVar, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (aVar.cxj > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(z ? "" : "; ");
            sb.append("maxplaybackrate");
            sb.append("=");
            sb.append(aVar.cxj);
            str = sb.toString();
            z2 = false;
        } else {
            z2 = true;
        }
        if (aVar.cxk > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append((z2 && z) ? "" : "; ");
            sb2.append("sprop-maxcapturerate");
            sb2.append("=");
            sb2.append(aVar.cxj);
            str = sb2.toString();
            z2 = false;
        }
        if (aVar.cxh) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append((z2 && z) ? "" : "; ");
            sb3.append("cbr");
            sb3.append("=");
            sb3.append(aVar.cxh ? '1' : '0');
            str = sb3.toString();
            z2 = false;
        }
        if (aVar.cxi > 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append((z2 && z) ? "" : "; ");
            sb4.append("maxaveragebitrate");
            sb4.append("=");
            sb4.append(aVar.cxi * 1000);
            str = sb4.toString();
            z2 = false;
        }
        if (aVar.cxm) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append((z2 && z) ? "" : "; ");
            sb5.append("usedtx");
            sb5.append("=");
            sb5.append(aVar.cxm ? '1' : '0');
            str = sb5.toString();
        } else {
            z3 = z2;
        }
        if (aVar.cxl) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str);
            sb6.append((z3 && z) ? "" : "; ");
            sb6.append("stereo");
            sb6.append("=");
            sb6.append(aVar.cxl ? '1' : '0');
            return sb6.toString();
        }
        return str;
    }

    public static String a(String str, String str2, a aVar) {
        String str3;
        int i;
        boolean z;
        String[] split = str2.split("\r\n");
        Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + str + "(/\\d+)+[\r]?$");
        int i2 = 0;
        while (true) {
            if (i2 >= split.length) {
                str3 = null;
                i = -1;
                break;
            }
            Matcher matcher = compile.matcher(split[i2]);
            if (matcher.matches()) {
                str3 = matcher.group(1);
                i = i2;
                break;
            }
            i2++;
        }
        if (str3 == null) {
            Log.w("SdpPrefer", "No rtpmap for " + str + " codec");
            return str2;
        }
        Log.d("SdpPrefer", "Found " + str + " rtpmap " + str3 + " at " + split[i]);
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
                Log.d("SdpPrefer", "Found " + str + " " + split[i3]);
                split[i3] = a(split[i3], aVar, false);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Update remote SDP line: ");
                sb2.append(split[i3]);
                Log.d("SdpPrefer", sb2.toString());
                z = true;
                break;
            } else {
                i3++;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        for (int i4 = 0; i4 < split.length; i4++) {
            sb3.append(split[i4]);
            sb3.append("\r\n");
            if (!z && i4 == i) {
                String a2 = a("a=fmtp:" + str3 + " ", aVar, true);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Add local SDP line: ");
                sb4.append(a2);
                Log.d("SdpPrefer", sb4.toString());
                sb3.append(a2);
                sb3.append("\r\n");
            }
        }
        return sb3.toString();
    }
}
