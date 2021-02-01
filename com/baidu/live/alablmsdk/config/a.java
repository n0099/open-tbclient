package com.baidu.live.alablmsdk.config;

import android.text.TextUtils;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.alablmsdk.config.a.d;
import com.baidu.live.alablmsdk.config.enums.BLMAudioSampleRate;
import com.baidu.live.alablmsdk.config.enums.BLMLiveTransferMode;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.yy.mediaframework.base.VideoEncoderConfig;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static final BLMAudioSampleRate axk = BLMAudioSampleRate.BLM_AUDIO_SAMPLE_RATE_48000HZ;
    private final String axb = "360p";
    private final String axc = "480p";
    private final String axd = "540p";
    private final String axe = "544p";
    private final String axf = "720p";
    private final String axg = "4_3";
    private final String axh = "16_9";
    private final String axi = "3_4";
    private final String axj = "9_16";
    public C0161a axl;
    public C0161a axm;
    public BLMLiveTransferMode axn;

    /* renamed from: com.baidu.live.alablmsdk.config.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0161a {
        public com.baidu.live.alablmsdk.config.a.b axo;
        public String axr;
        public com.baidu.live.alablmsdk.config.a.b axt;
        public List<com.baidu.live.alablmsdk.config.a.a> axu;
        public List<com.baidu.live.alablmsdk.config.a.a> axv;
        public String axw;
        public String axx;
        public int fps = 15;
        public BLMAudioSampleRate axp = a.axk;
        public int axq = FeatureCodes.ADVANCE_BEAUTY;
        public boolean axs = true;

        public boolean xM() {
            return !TextUtils.isEmpty(this.axr);
        }
    }

    public String a(C0161a c0161a) {
        if (c0161a == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("custom_layout").append("-v:").append(a(c0161a.axo)).append("-b:").append(ce(c0161a.axq)).append("-f:").append(cf(c0161a.fps)).append("-ar:").append(a(c0161a.axp));
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(c0161a.axv)) {
            sb.append("-bgp:").append(eI(c0161a.axw)).append("-wd:").append("{").append(b(c0161a.axo, c0161a.axt, c0161a.axv)).append("}");
        } else {
            sb.append("-wp:").append("{").append(a(c0161a.axo, c0161a.axt, c0161a.axu)).append("}");
        }
        String sb2 = sb.toString();
        com.baidu.live.alablmsdk.a.b.a.ag(" template " + sb2, "");
        return sb2;
    }

    private String a(com.baidu.live.alablmsdk.config.a.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(b(bVar)).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(c(bVar));
        return sb.toString();
    }

    private String b(com.baidu.live.alablmsdk.config.a.b bVar) {
        int min = Math.min(bVar.getWidth(), bVar.getHeight());
        if (min - 360 >= 5.0f) {
            if (min - 480 < 5.0f) {
                return "480p";
            }
            if (min != 544) {
                if (min - 540 >= 5.0f) {
                    if (min - 720 < 5.0f) {
                        return "720p";
                    }
                    return "720p";
                }
                return "540p";
            }
            return "544p";
        }
        return "360p";
    }

    private String c(com.baidu.live.alablmsdk.config.a.b bVar) {
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

    private com.baidu.live.alablmsdk.config.a.c d(com.baidu.live.alablmsdk.config.a.b bVar) {
        String b2 = b(bVar);
        String c = c(bVar);
        com.baidu.live.alablmsdk.config.a.c cVar = new com.baidu.live.alablmsdk.config.a.c();
        boolean z = "4_3".equals(c) || "3_4".equals(c);
        if ("360p".equals(b2)) {
            cVar.min = EncoderTextureDrawer.X264_WIDTH;
            if (z) {
                cVar.max = 480;
            } else {
                cVar.max = 640;
            }
        } else if ("480p".equals(b2)) {
            cVar.min = 480;
            if (z) {
                cVar.max = 640;
            } else {
                cVar.max = 854;
            }
        } else if ("540p".equals(b2)) {
            cVar.min = 540;
            if (z) {
                cVar.max = 720;
            } else {
                cVar.max = 960;
            }
        } else if ("544p".equals(b2)) {
            cVar.min = VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH;
            if (z) {
                cVar.max = 720;
            } else {
                cVar.max = 960;
            }
        } else if ("720p".equals(b2)) {
            cVar.min = 720;
            if (z) {
                cVar.max = 960;
            } else {
                cVar.max = 1280;
            }
        }
        return cVar;
    }

    private int ce(int i) {
        return i > 0 ? i : FeatureCodes.ADVANCE_BEAUTY;
    }

    private int cf(int i) {
        if (i != 0) {
            return i;
        }
        return 15;
    }

    private int a(BLMAudioSampleRate bLMAudioSampleRate) {
        return bLMAudioSampleRate != null ? bLMAudioSampleRate.getSampleRate() : axk.getSampleRate();
    }

    private String a(com.baidu.live.alablmsdk.config.a.b bVar, com.baidu.live.alablmsdk.config.a.b bVar2, List<com.baidu.live.alablmsdk.config.a.a> list) {
        if (com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i = 0; i < list.size(); i++) {
            com.baidu.live.alablmsdk.config.a.a aVar = list.get(i);
            if (aVar != null) {
                d dVar = aVar.axE;
                int i2 = i + 1;
                if (dVar != null) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append(i2).append(":").append(a(bVar, bVar2, dVar));
                    z = false;
                }
            }
        }
        return sb.toString();
    }

    private String a(com.baidu.live.alablmsdk.config.a.b bVar, com.baidu.live.alablmsdk.config.a.b bVar2, d dVar) {
        d b2 = b(bVar, bVar2, dVar);
        return b2 == null ? "" : b2.xR();
    }

    public d b(com.baidu.live.alablmsdk.config.a.b bVar, com.baidu.live.alablmsdk.config.a.b bVar2, d dVar) {
        int i;
        int i2;
        if (dVar == null || bVar2 == null || bVar == null) {
            return null;
        }
        float width = (bVar.getWidth() * 1.0f) / bVar2.getWidth();
        int q = com.baidu.live.alablmsdk.a.b.q(dVar.x * width);
        int q2 = com.baidu.live.alablmsdk.a.b.q(dVar.y * width);
        int q3 = com.baidu.live.alablmsdk.a.b.q(dVar.width * width);
        int q4 = com.baidu.live.alablmsdk.a.b.q(width * dVar.height);
        com.baidu.live.alablmsdk.config.a.c d = d(bVar);
        if (bVar.getWidth() >= bVar.getHeight() || d == null || d.min == 0 || d.max == 0) {
            i = q3;
        } else {
            if (q + q3 <= d.min || (i = d.min - q) <= 0) {
                i = q3;
            }
            if (q2 + q4 > d.max && (i2 = d.max - q2) > 0) {
                q4 = i2;
            }
        }
        return new d(q, q2, i, q4);
    }

    private String eI(String str) {
        return !TextUtils.isEmpty(str) ? str : "meg_public_show_2x.png";
    }

    public String b(com.baidu.live.alablmsdk.config.a.b bVar, com.baidu.live.alablmsdk.config.a.b bVar2, List<com.baidu.live.alablmsdk.config.a.a> list) {
        if (com.baidu.live.alablmsdk.a.a.isEmpty(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        float a2 = a(bVar, bVar2);
        boolean z = true;
        for (int i = 0; i < list.size(); i++) {
            com.baidu.live.alablmsdk.config.a.a aVar = list.get(i);
            if (aVar != null) {
                if (!z) {
                    sb.append(",");
                }
                sb.append(aVar.tag).append(":s:").append(aVar.axC.getShapeType()).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(aVar.r(a2));
                z = false;
            }
        }
        return sb.toString();
    }

    private float a(com.baidu.live.alablmsdk.config.a.b bVar, com.baidu.live.alablmsdk.config.a.b bVar2) {
        if (bVar == null || bVar.xQ() || bVar2 == null || bVar2.xQ()) {
            return 1.0f;
        }
        if ((bVar.getWidth() * 1.0f) / bVar.getHeight() < (bVar2.getWidth() * 1.0f) / bVar2.getHeight()) {
            return (1.0f * bVar.getWidth()) / bVar2.getWidth();
        }
        return (1.0f * bVar.getHeight()) / bVar2.getHeight();
    }
}
