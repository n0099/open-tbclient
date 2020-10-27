package com.baidu.live.alablmsdk.config;

import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.alablmsdk.a.c;
import com.baidu.live.alablmsdk.config.a.b;
import com.baidu.live.alablmsdk.config.enums.BLMAudioBitDepth;
import com.baidu.live.alablmsdk.config.enums.BLMAudioBitRate;
import com.baidu.live.alablmsdk.config.enums.BLMAudioSampleRate;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static final BLMAudioSampleRate aAy = BLMAudioSampleRate.BLM_AUDIO_SAMPLE_RATE_48000HZ;
    public int aAA;
    private BLMAudioSampleRate aAB;
    public String aAE;
    public String aAG;
    public com.baidu.live.alablmsdk.config.a.a aAH;
    public List<b> aAI;
    public com.baidu.live.alablmsdk.config.a.a aAz;
    public int fps;
    private BLMAudioBitDepth aAC = BLMAudioBitDepth.BLM_AUDIO_BIT_DEPTH_UINT16;
    private BLMAudioBitRate aAD = BLMAudioBitRate.BLM_AUDIO_BIT_RATE_128KBPS;
    public boolean aAF = true;

    public String Bk() {
        StringBuilder sb = new StringBuilder();
        sb.append("custom_layout").append("-v:").append(a(this.aAz)).append("-b:").append(Bl()).append("-f:").append(Bm()).append("-ar:").append(Bn()).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append("wp:").append("{").append(Bo()).append("}");
        String sb2 = sb.toString();
        c.d(" template " + sb2);
        c.fJ(" template " + sb2);
        return sb2;
    }

    private String a(com.baidu.live.alablmsdk.config.a.a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(b(aVar)).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(c(aVar));
        return sb.toString();
    }

    public String b(com.baidu.live.alablmsdk.config.a.a aVar) {
        int min = Math.min(aVar.width, aVar.height);
        if (min - 360 >= 5.0f) {
            if (min - 480 >= 5.0f) {
                if (min - 540 >= 5.0f) {
                    if (min - 720 < 5.0f) {
                        return "720p";
                    }
                    return "720p";
                }
                return "540p";
            }
            return "480p";
        }
        return "360p";
    }

    public String c(com.baidu.live.alablmsdk.config.a.a aVar) {
        int i = aVar.width;
        int i2 = aVar.height;
        if (i > i2) {
            if (i / i2 < ((1.7777778f - 1.3333334f) * 0.5d) + 1.3333334f) {
                return "4_3";
            }
            return "16_9";
        }
        if (i / i2 > ((0.5625f - 0.75f) * 0.5d) + 0.75f) {
            return "3_4";
        }
        return "9_16";
    }

    private int Bl() {
        return this.aAA > 0 ? this.aAA : FeatureCodes.ADVANCE_BEAUTY;
    }

    private int Bm() {
        if (this.fps != 0) {
            return this.fps;
        }
        return 20;
    }

    private int Bn() {
        return this.aAB != null ? this.aAB.getSampleRate() : aAy.getSampleRate();
    }

    private String Bo() {
        if (com.baidu.live.alablmsdk.a.a.isEmpty(this.aAI)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i = 0; i < this.aAI.size(); i++) {
            b bVar = this.aAI.get(i);
            int i2 = i + 1;
            if (bVar != null) {
                if (!z) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(i2).append(":").append(a(bVar));
                z = false;
            }
        }
        return sb.toString();
    }

    private String a(b bVar) {
        if (bVar == null) {
            return "";
        }
        if (this.aAH == null || this.aAz == null) {
            return bVar.Bp();
        }
        float f = (this.aAz.width * 1.0f) / this.aAH.width;
        return new b(s(bVar.x * f), s(bVar.y * f), s(bVar.width * f), s(f * bVar.height)).Bp();
    }

    private int s(float f) {
        int ceil = (int) Math.ceil(f);
        if (ceil % 2 == 1) {
            return ceil - 1;
        }
        return ceil;
    }
}
