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
    private static final BLMAudioSampleRate ayV = BLMAudioSampleRate.BLM_AUDIO_SAMPLE_RATE_48000HZ;
    public b ayW;
    public BLMAudioSampleRate ayX;
    public int ayY;
    public BLMLiveTransferMode ayZ;
    public String aza;
    public boolean azb = true;
    public String azc;
    public b azd;
    public List<c> aze;
    public List<com.baidu.live.alablmsdk.config.a.a> azf;
    public String azg;
    public int fps;

    public String AD() {
        StringBuilder sb = new StringBuilder();
        sb.append("custom_layout").append("-v:").append(a(this.ayW)).append("-b:").append(AE()).append("-f:").append(AF()).append("-ar:").append(AG());
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(this.azf)) {
            sb.append("-bgp:").append(AI()).append("-wd:").append("{").append(AJ()).append("}");
        } else {
            sb.append("-wp:").append("{").append(AH()).append("}");
        }
        String sb2 = sb.toString();
        com.baidu.live.alablmsdk.a.b.ag(" template " + sb2, "");
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

    private int AE() {
        return this.ayY > 0 ? this.ayY : FeatureCodes.ADVANCE_BEAUTY;
    }

    private int AF() {
        if (this.fps != 0) {
            return this.fps;
        }
        return 20;
    }

    private int AG() {
        return this.ayX != null ? this.ayX.getSampleRate() : ayV.getSampleRate();
    }

    private String AH() {
        if (com.baidu.live.alablmsdk.a.a.isEmpty(this.aze)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i = 0; i < this.aze.size(); i++) {
            c cVar = this.aze.get(i);
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
        if (this.azd == null || this.ayW == null) {
            return cVar.AL();
        }
        float width = (this.ayW.getWidth() * 1.0f) / this.azd.getWidth();
        return new c(com.baidu.live.alablmsdk.a.c.r(cVar.x * width), com.baidu.live.alablmsdk.a.c.r(cVar.y * width), com.baidu.live.alablmsdk.a.c.r(cVar.width * width), com.baidu.live.alablmsdk.a.c.r(width * cVar.height)).AL();
    }

    private String AI() {
        return !TextUtils.isEmpty(this.azg) ? this.azg : "meg_public_show_2x.png";
    }

    public String AJ() {
        if (com.baidu.live.alablmsdk.a.a.isEmpty(this.azf)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        float a2 = a(this.ayW, this.azd);
        boolean z = true;
        for (int i = 0; i < this.azf.size(); i++) {
            com.baidu.live.alablmsdk.config.a.a aVar = this.azf.get(i);
            if (aVar != null) {
                if (!z) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(aVar.tag).append(":s:").append(aVar.azh.getShapeType()).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(aVar.s(a2));
                z = false;
            }
        }
        return sb.toString();
    }

    private float a(b bVar, b bVar2) {
        if (bVar == null || bVar.AK() || bVar2 == null || bVar2.AK()) {
            return 1.0f;
        }
        if ((bVar.getWidth() * 1.0f) / bVar.getHeight() < (bVar2.getWidth() * 1.0f) / bVar2.getHeight()) {
            return (1.0f * bVar.getWidth()) / bVar2.getWidth();
        }
        return (1.0f * bVar.getHeight()) / bVar2.getHeight();
    }
}
