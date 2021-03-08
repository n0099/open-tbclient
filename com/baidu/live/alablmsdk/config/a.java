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
/* loaded from: classes10.dex */
public class a {
    private static final BLMAudioSampleRate ayK = BLMAudioSampleRate.BLM_AUDIO_SAMPLE_RATE_48000HZ;
    private final String ayB = "360p";
    private final String ayC = "480p";
    private final String ayD = "540p";
    private final String ayE = "544p";
    private final String ayF = "720p";
    private final String ayG = "4_3";
    private final String ayH = "16_9";
    private final String ayI = "3_4";
    private final String ayJ = "9_16";
    public C0167a ayL;
    public C0167a ayM;
    public BLMLiveTransferMode ayN;

    /* renamed from: com.baidu.live.alablmsdk.config.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0167a {
        public com.baidu.live.alablmsdk.config.a.b ayO;
        public String ayR;
        public com.baidu.live.alablmsdk.config.a.b ayT;
        public List<com.baidu.live.alablmsdk.config.a.a> ayU;
        public List<com.baidu.live.alablmsdk.config.a.a> ayV;
        public String ayW;
        public String ayX;
        public int fps = 15;
        public BLMAudioSampleRate ayP = a.ayK;
        public int ayQ = FeatureCodes.ADVANCE_BEAUTY;
        public boolean ayS = true;

        public boolean xP() {
            return !TextUtils.isEmpty(this.ayR);
        }
    }

    public String a(C0167a c0167a) {
        if (c0167a == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("custom_layout").append("-v:").append(a(c0167a.ayO)).append("-b:").append(cf(c0167a.ayQ)).append("-f:").append(cg(c0167a.fps)).append("-ar:").append(a(c0167a.ayP));
        if (!com.baidu.live.alablmsdk.a.a.isEmpty(c0167a.ayV)) {
            sb.append("-bgp:").append(eO(c0167a.ayW)).append("-wd:").append("{").append(b(c0167a.ayO, c0167a.ayT, c0167a.ayV)).append("}");
        } else {
            sb.append("-wp:").append("{").append(a(c0167a.ayO, c0167a.ayT, c0167a.ayU)).append("}");
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
        String b = b(bVar);
        String c = c(bVar);
        com.baidu.live.alablmsdk.config.a.c cVar = new com.baidu.live.alablmsdk.config.a.c();
        boolean z = "4_3".equals(c) || "3_4".equals(c);
        if ("360p".equals(b)) {
            cVar.min = EncoderTextureDrawer.X264_WIDTH;
            if (z) {
                cVar.max = 480;
            } else {
                cVar.max = 640;
            }
        } else if ("480p".equals(b)) {
            cVar.min = 480;
            if (z) {
                cVar.max = 640;
            } else {
                cVar.max = 854;
            }
        } else if ("540p".equals(b)) {
            cVar.min = 540;
            if (z) {
                cVar.max = 720;
            } else {
                cVar.max = 960;
            }
        } else if ("544p".equals(b)) {
            cVar.min = VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH;
            if (z) {
                cVar.max = 720;
            } else {
                cVar.max = 960;
            }
        } else if ("720p".equals(b)) {
            cVar.min = 720;
            if (z) {
                cVar.max = 960;
            } else {
                cVar.max = 1280;
            }
        }
        return cVar;
    }

    private int cf(int i) {
        return i > 0 ? i : FeatureCodes.ADVANCE_BEAUTY;
    }

    private int cg(int i) {
        if (i != 0) {
            return i;
        }
        return 15;
    }

    private int a(BLMAudioSampleRate bLMAudioSampleRate) {
        return bLMAudioSampleRate != null ? bLMAudioSampleRate.getSampleRate() : ayK.getSampleRate();
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
                d dVar = aVar.aze;
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
        d b = b(bVar, bVar2, dVar);
        return b == null ? "" : b.xU();
    }

    public d b(com.baidu.live.alablmsdk.config.a.b bVar, com.baidu.live.alablmsdk.config.a.b bVar2, d dVar) {
        int i;
        int i2;
        if (dVar == null || bVar2 == null || bVar == null) {
            return null;
        }
        float width = (bVar.getWidth() * 1.0f) / bVar2.getWidth();
        int u = com.baidu.live.alablmsdk.a.b.u(dVar.x * width);
        int u2 = com.baidu.live.alablmsdk.a.b.u(dVar.y * width);
        int u3 = com.baidu.live.alablmsdk.a.b.u(dVar.width * width);
        int u4 = com.baidu.live.alablmsdk.a.b.u(width * dVar.height);
        com.baidu.live.alablmsdk.config.a.c d = d(bVar);
        if (bVar.getWidth() >= bVar.getHeight() || d == null || d.min == 0 || d.max == 0) {
            i = u3;
        } else {
            if (u + u3 <= d.min || (i = d.min - u) <= 0) {
                i = u3;
            }
            if (u2 + u4 > d.max && (i2 = d.max - u2) > 0) {
                u4 = i2;
            }
        }
        return new d(u, u2, i, u4);
    }

    private String eO(String str) {
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
                sb.append(aVar.tag).append(":s:").append(aVar.azc.getShapeType()).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(aVar.v(a2));
                z = false;
            }
        }
        return sb.toString();
    }

    private float a(com.baidu.live.alablmsdk.config.a.b bVar, com.baidu.live.alablmsdk.config.a.b bVar2) {
        if (bVar == null || bVar.xT() || bVar2 == null || bVar2.xT()) {
            return 1.0f;
        }
        if ((bVar.getWidth() * 1.0f) / bVar.getHeight() < (bVar2.getWidth() * 1.0f) / bVar2.getHeight()) {
            return (1.0f * bVar.getWidth()) / bVar2.getWidth();
        }
        return (1.0f * bVar.getHeight()) / bVar2.getHeight();
    }
}
