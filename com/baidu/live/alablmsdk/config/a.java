package com.baidu.live.alablmsdk.config;

import android.text.TextUtils;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.alablmsdk.config.a.b;
import com.baidu.live.alablmsdk.config.a.c;
import com.baidu.live.alablmsdk.config.enums.BLMAudioSampleRate;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static final BLMAudioSampleRate aAG = BLMAudioSampleRate.BLM_AUDIO_SAMPLE_RATE_48000HZ;
    public b aAH;
    public BLMAudioSampleRate aAI;
    public int aAJ;
    public BLMLiveTransferMode aAK;
    public String aAL;
    public boolean aAM = true;
    public String aAN;
    public b aAO;
    public List<c> aAP;
    public List<com.baidu.live.alablmsdk.config.a.a> aAQ;
    public String aAR;
    public int fps;

    public String Bm() {
        StringBuilder sb = new StringBuilder();
        sb.append("custom_layout").append("-v:").append(a(this.aAH)).append("-b:").append(Bn()).append("-f:").append(Bo()).append("-ar:").append(Bp());
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aAQ)) {
            sb.append("-bgp:").append(Br()).append("-wd:").append("{").append(Bs()).append("}");
        } else {
            sb.append("-wp:").append("{").append(Bq()).append("}");
        }
        String sb2 = sb.toString();
        com.baidu.live.alablmsdk.a.b.ah(" template " + sb2, "");
        return sb2;
    }

    private String a(b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(b(bVar)).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(c(bVar));
        return sb.toString();
    }

    private String b(b bVar) {
        int min = Math.min(bVar.getWidth(), bVar.getHeight());
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

    private String c(b bVar) {
        int width = bVar.getWidth();
        int height = bVar.getHeight();
        if (width > height) {
            if (width / height < ((1.7777778f - 1.3333334f) * 0.5d) + 1.3333334f) {
                return "4_3";
            }
            return "16_9";
        }
        if (width / height > ((0.5625f - 0.75f) * 0.5d) + 0.75f) {
            return "3_4";
        }
        return "9_16";
    }

    private int Bn() {
        return this.aAJ > 0 ? this.aAJ : FeatureCodes.ADVANCE_BEAUTY;
    }

    private int Bo() {
        if (this.fps != 0) {
            return this.fps;
        }
        return 20;
    }

    private int Bp() {
        return this.aAI != null ? this.aAI.getSampleRate() : aAG.getSampleRate();
    }

    private String Bq() {
        if (com.baidu.live.alablmsdk.a.a.isEmpty(this.aAP)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i = 0; i < this.aAP.size(); i++) {
            c cVar = this.aAP.get(i);
            int i2 = i + 1;
            if (cVar != null) {
                if (!z) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(i2).append(":").append(a(cVar));
                z = false;
            }
        }
        return sb.toString();
    }

    private String a(c cVar) {
        if (cVar == null) {
            return "";
        }
        if (this.aAO == null || this.aAH == null) {
            return cVar.Bu();
        }
        float width = (this.aAH.getWidth() * 1.0f) / this.aAO.getWidth();
        return new c(com.baidu.live.alablmsdk.a.c.s(cVar.x * width), com.baidu.live.alablmsdk.a.c.s(cVar.y * width), com.baidu.live.alablmsdk.a.c.s(cVar.width * width), com.baidu.live.alablmsdk.a.c.s(width * cVar.height)).Bu();
    }

    private String Br() {
        return !TextUtils.isEmpty(this.aAR) ? this.aAR : "meg_public_show_2x.png";
    }

    public String Bs() {
        if (com.baidu.live.alablmsdk.a.a.isEmpty(this.aAQ)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        float a2 = a(this.aAH, this.aAO);
        boolean z = true;
        for (int i = 0; i < this.aAQ.size(); i++) {
            com.baidu.live.alablmsdk.config.a.a aVar = this.aAQ.get(i);
            if (aVar != null) {
                if (!z) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(aVar.tag).append(":s:").append(aVar.aAS.getShapeType()).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(aVar.t(a2));
                z = false;
            }
        }
        return sb.toString();
    }

    private float a(b bVar, b bVar2) {
        if (bVar == null || bVar.Bt() || bVar2 == null || bVar2.Bt()) {
            return 1.0f;
        }
        if ((bVar.getWidth() * 1.0f) / bVar.getHeight() < (bVar2.getWidth() * 1.0f) / bVar2.getHeight()) {
            return (1.0f * bVar.getWidth()) / bVar2.getWidth();
        }
        return (1.0f * bVar.getHeight()) / bVar2.getHeight();
    }
}
