package com.baidu.live.alablmsdk.config;

import android.text.TextUtils;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.alablmsdk.config.a.b;
import com.baidu.live.alablmsdk.config.a.c;
import com.baidu.live.alablmsdk.config.enums.BLMAudioSampleRate;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static final BLMAudioSampleRate aBQ = BLMAudioSampleRate.BLM_AUDIO_SAMPLE_RATE_48000HZ;
    public b aBR;
    public BLMAudioSampleRate aBS;
    public int aBT;
    public BLMLiveTransferMode aBU;
    public String aBV;
    public boolean aBW = true;
    public String aBX;
    public b aBY;
    public List<c> aBZ;
    public List<com.baidu.live.alablmsdk.config.a.a> aCa;
    public String aCb;
    public int fps;

    public String BC() {
        StringBuilder sb = new StringBuilder();
        sb.append("custom_layout").append("-v:").append(a(this.aBR)).append("-b:").append(BD()).append("-f:").append(BE()).append("-ar:").append(BF());
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.aCa)) {
            sb.append("-bgp:").append(BH()).append("-wd:").append("{").append(BI()).append("}");
        } else {
            sb.append("-wp:").append("{").append(BG()).append("}");
        }
        String sb2 = sb.toString();
        com.baidu.live.alablmsdk.a.b.a.aj(" template " + sb2, "");
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

    private int BD() {
        return this.aBT > 0 ? this.aBT : FeatureCodes.ADVANCE_BEAUTY;
    }

    private int BE() {
        if (this.fps != 0) {
            return this.fps;
        }
        return 20;
    }

    private int BF() {
        return this.aBS != null ? this.aBS.getSampleRate() : aBQ.getSampleRate();
    }

    private String BG() {
        if (com.baidu.live.alablmsdk.a.a.isEmpty(this.aBZ)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i = 0; i < this.aBZ.size(); i++) {
            c cVar = this.aBZ.get(i);
            int i2 = i + 1;
            if (cVar != null) {
                if (!z) {
                    sb.append(",");
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
        if (this.aBY == null || this.aBR == null) {
            return cVar.BK();
        }
        float width = (this.aBR.getWidth() * 1.0f) / this.aBY.getWidth();
        return new c(com.baidu.live.alablmsdk.a.b.q(cVar.x * width), com.baidu.live.alablmsdk.a.b.q(cVar.y * width), com.baidu.live.alablmsdk.a.b.q(cVar.width * width), com.baidu.live.alablmsdk.a.b.q(width * cVar.height)).BK();
    }

    private String BH() {
        return !TextUtils.isEmpty(this.aCb) ? this.aCb : "meg_public_show_2x.png";
    }

    public String BI() {
        if (com.baidu.live.alablmsdk.a.a.isEmpty(this.aCa)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        float a2 = a(this.aBR, this.aBY);
        boolean z = true;
        for (int i = 0; i < this.aCa.size(); i++) {
            com.baidu.live.alablmsdk.config.a.a aVar = this.aCa.get(i);
            if (aVar != null) {
                if (!z) {
                    sb.append(",");
                }
                sb.append(aVar.tag).append(":s:").append(aVar.aCc.getShapeType()).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(aVar.r(a2));
                z = false;
            }
        }
        return sb.toString();
    }

    private float a(b bVar, b bVar2) {
        if (bVar == null || bVar.BJ() || bVar2 == null || bVar2.BJ()) {
            return 1.0f;
        }
        if ((bVar.getWidth() * 1.0f) / bVar.getHeight() < (bVar2.getWidth() * 1.0f) / bVar2.getHeight()) {
            return (1.0f * bVar.getWidth()) / bVar2.getWidth();
        }
        return (1.0f * bVar.getHeight()) / bVar2.getHeight();
    }
}
