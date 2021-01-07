package com.baidu.ar.seg;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.arrender.j;
import com.baidu.ar.arrender.l;
import com.baidu.ar.arrender.o;
import com.baidu.ar.c;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class SegAR extends c {
    private static final String TAG = SegAR.class.getSimpleName();
    private static final float[] vo = {0.0f, -1.0f, 1.0f, 0.0f};
    private static final float[] vp = {0.0f, 1.0f, -1.0f, 0.0f};
    private static final float[] vq = {1.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] vr = {-1.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] vs = {0.0f, 1.0f, 1.0f, 0.0f};
    private static final float[] vt = {0.0f, -1.0f, -1.0f, 0.0f};
    private static final float[] vu = {-1.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] vv = {1.0f, 0.0f, 0.0f, 1.0f};
    private LuaMsgListener cc;
    private e mv;
    private SegDetector uY;
    private String va;
    private int oU = 2;
    private String bD = "ability_image_segmentation";
    private boolean uZ = true;
    private boolean pH = true;
    private int vb = 0;
    private Vector4f vc = new Vector4f();
    private float vd = 0.0f;
    private float ve = 0.0f;
    private int vf = 0;
    private float vg = 0.0f;
    private float vh = 0.0f;

    /* renamed from: vi  reason: collision with root package name */
    private float f1563vi = 0.0f;
    private float vj = 0.0f;
    private float vk = 0.0f;
    private float vl = 0.0f;
    private float vm = 0.0f;
    private float vn = 1.0f;
    private int vw = 0;
    private int vx = 0;

    /* renamed from: io  reason: collision with root package name */
    private byte[] f1562io = null;
    private long vy = 0;
    private AlgoHandleController cb = null;
    private int vz = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(a aVar) {
        if (this.oU != 4) {
            if (this.oU == 2) {
                getImgSegOrientation(aVar.getOrientation());
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("u_maskRotate", this.vc);
                return hashMap;
            } else if (this.oU == 5) {
                getSkySegOrientation(aVar.getOrientation());
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("u_maskRotate", this.vc);
                return hashMap2;
            } else {
                return null;
            }
        }
        getHairSegOrientation(aVar.getOrientation());
        b(aVar.gc(), aVar.getWidth(), aVar.getHeight());
        HashMap<String, Object> hashMap3 = new HashMap<>();
        hashMap3.put("enableSeq", Float.valueOf(1.0f));
        hashMap3.put("cameraFront", Integer.valueOf(this.pH ? 1 : 0));
        hashMap3.put("deviceOrientation", Integer.valueOf(this.vb));
        hashMap3.put("u_maskRotate", this.vc);
        hashMap3.put("hairBlendType", Integer.valueOf(this.vf));
        hashMap3.put("hairThreshold", Float.valueOf(this.vd));
        hashMap3.put("hairBlendAlpha", Float.valueOf(this.ve));
        hashMap3.put("hairTopPos", Float.valueOf(this.vm));
        hashMap3.put("hairBottomPos", Float.valueOf(this.vn));
        hashMap3.put("hairTop", new Vector4f(this.vj, this.vk, this.vl, 1.0f));
        hashMap3.put("hairBottom", new Vector4f(this.vg, this.vh, this.f1563vi, 1.0f));
        return hashMap3;
    }

    private void a(PixelRotation pixelRotation) {
        float[] fArr;
        switch (pixelRotation) {
            case RotateRight:
                fArr = vo;
                break;
            case RotateLeft:
                fArr = vp;
                break;
            case FlipVertical:
                fArr = vq;
                break;
            case FlipHorizontal:
                fArr = vr;
                break;
            case RotateRightFlipVertical:
                fArr = vs;
                break;
            case RotateRightFlipHorizontal:
                fArr = vt;
                break;
            case Rotate180:
                fArr = vu;
                break;
            default:
                fArr = vv;
                break;
        }
        this.vc.setXYZW(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    private void al() {
        if (this.cc == null) {
            this.cc = new LuaMsgListener() { // from class: com.baidu.ar.seg.SegAR.2
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(LuaMessageHelper.KEY_EVENT_NAME);
                    return arrayList;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if ("adjust_hair_segmentation".equals((String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME))) {
                        SegAR.this.m(hashMap);
                    }
                }
            };
        }
        a(this.cc);
    }

    private void b(long j) {
        if (this.cb == null || j <= 0) {
            return;
        }
        long handleType = this.cb.getHandleType(j);
        if (this.uY == null || handleType != this.vz) {
            return;
        }
        this.uY.b(j);
    }

    private void b(byte[] bArr, int i, int i2) {
        if (bArr == null || i <= 0 || i2 <= 0 || bArr.length < i * i2) {
            return;
        }
        this.vm = c(bArr, i, i2);
        this.vn = d(bArr, i, i2);
        if (this.vb == 1 || this.vb == 3) {
            this.vm -= 16.0f / i2;
            this.vn += 12.0f / i2;
        }
    }

    private float c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            for (int i4 = 0; i4 < i; i4++) {
                if ((bArr[(i3 * i) + i4] & 255) > ((int) (255.0f * this.vd))) {
                    return (i3 >= 3 ? i3 - 3 : 0) / i2;
                }
            }
            i3 += 3;
        }
        return 0.0f;
    }

    private float d(byte[] bArr, int i, int i2) {
        for (int i3 = i2 - 1; i3 > 0; i3 -= 3) {
            for (int i4 = 0; i4 < i; i4++) {
                if ((bArr[(i3 * i) + i4] & 255) > ((int) (255.0f * this.vd))) {
                    return (i3 + 3 > i2 + (-1) ? i2 - 1 : i3 + 3) / i2;
                }
            }
        }
        return 1.0f;
    }

    private void l(HashMap<String, Object> hashMap) {
        if (com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1) == 5011) {
            StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
            this.oU = 2;
            this.vz = 11;
            this.bD = "ability_image_segmentation";
            String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.va = a2;
            return;
        }
        String a3 = com.baidu.ar.arplay.c.c.a(hashMap.get(LuaMessageHelper.KEY_EVENT_NAME), (String) null);
        if (a3 != null) {
            if (a3.equals("start_hair_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_HAIR_SEG_OPEN);
                m(hashMap);
                this.oU = 4;
                this.bD = "ability_hair_segmentation";
            } else if (a3.equals("start_sky_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_SKY_SEG_OPEN);
                String a4 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a4)) {
                    this.va = a4;
                }
                this.oU = 5;
                this.bD = "ability_sky_segmentation";
            } else if (a3.equals("start_image_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
                String a5 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a5)) {
                    this.va = a5;
                }
                this.oU = 2;
                this.bD = "ability_image_segmentation";
            } else {
                this.oU = -10;
            }
            switch (this.oU) {
                case 4:
                    this.vz = 13;
                    return;
                case 5:
                    this.vz = 12;
                    return;
                default:
                    this.vz = 11;
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(HashMap<String, Object> hashMap) {
        String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
        this.vd = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_threshold"), 0.0f);
        this.ve = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_alpha"), 0.0f);
        this.vf = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_type"), 0);
        this.vg = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_r"), 0.0f);
        this.vh = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_g"), 0.0f);
        this.f1563vi = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_b"), 0.0f);
        this.vj = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_r"), 0.0f);
        this.vk = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_g"), 0.0f);
        this.vl = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_b"), 0.0f);
        if (!TextUtils.isEmpty(a2)) {
            this.va = a2;
        }
        if (this.uY != null) {
            this.uY.f(this.vd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.cb == null || this.cb.getHandleType(j) != this.vz) {
            return;
        }
        b(j);
    }

    public void getHairSegOrientation(int i) {
        switch (i) {
            case 0:
                this.vb = 1;
                a(this.pH ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 90:
                this.vb = this.pH ? 2 : 0;
                a(this.pH ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 180:
                this.vb = 3;
                a(this.pH ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.vb = this.pH ? 0 : 2;
                a(this.pH ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    public void getImgSegOrientation(int i) {
        switch (i) {
            case 0:
                this.vb = this.pH ? 1 : 3;
                a(this.pH ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 1:
                this.vb = this.pH ? 2 : 0;
                a(this.pH ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 2:
                this.vb = this.pH ? 3 : 1;
                a(this.pH ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.vb = this.pH ? 0 : 2;
                a(this.pH ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    public void getSkySegOrientation(int i) {
        switch (i) {
            case 0:
                this.vb = this.pH ? 1 : 3;
                a(this.pH ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 1:
                this.vb = this.pH ? 2 : 0;
                a(this.pH ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 2:
                this.vb = this.pH ? 3 : 1;
                a(this.pH ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.vb = this.pH ? 0 : 2;
                a(this.pH ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        com.baidu.ar.h.b.k(TAG, "enableSyncRender false");
        if (this.uY != null) {
            this.uY.y(false);
        }
        b(this.cc);
        if (this.uY != null) {
            this.uY.a((AlgoHandleController) null);
            this.uY.av();
            a(this.uY);
        }
        if (this.cb != null) {
            this.cb.release();
            this.cb = null;
        }
        l r = r();
        if (r != null) {
            r.q(this.vz);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        com.baidu.ar.h.b.k(TAG, "setup(luaParams):" + hashMap.toString());
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        l(hashMap);
        if (this.oU < -1) {
            com.baidu.ar.h.b.b(TAG, "无法解析能力类型 mMdlType:" + this.oU);
            return;
        }
        this.uY = new SegDetector(this.oU);
        this.uY.a(this.cb);
        this.mv = new e() { // from class: com.baidu.ar.seg.SegAR.1
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (!(bVar instanceof b) || ((b) bVar).gd() == null) {
                    return;
                }
                if (SegAR.this.uZ) {
                    SegAR.this.uZ = false;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(LuaMessageHelper.KEY_EVENT_NAME, "first_bgseg_detect");
                    SegAR.this.d(hashMap2);
                }
                l r = SegAR.this.r();
                long de2 = bVar.de();
                if (de2 > 0 && r != null) {
                    r.a(de2, SegAR.this.bD);
                    SegAR.this.a(de2);
                }
                a gd = ((b) bVar).gd();
                if (gd != null) {
                    SegAR.this.pH = gd.isFrontCamera();
                    int width = gd.getWidth();
                    int height = gd.getHeight();
                    if (gd.getOrientation() == 0 || gd.getOrientation() == 180 || gd.getOrientation() == 2) {
                        gd.setWidth(height);
                        gd.setHeight(width);
                    }
                    if (r != null) {
                        SegAR.this.vw = gd.getWidth();
                        SegAR.this.vx = gd.getHeight();
                        SegAR.this.f1562io = gd.gc();
                        SegAR.this.vy = bVar.getTimestamp();
                        if (SegAR.this.vw <= 0 || SegAR.this.vx <= 0 || SegAR.this.f1562io == null) {
                            return;
                        }
                        j jVar = new j();
                        jVar.r(SegAR.this.bD);
                        jVar.P(SegAR.this.va);
                        jVar.h(SegAR.this.a(gd));
                        r.a(jVar);
                        if (bVar.dd() instanceof o) {
                            r.a((o) bVar.dd(), true);
                        }
                    }
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
                com.baidu.ar.h.b.k(SegAR.TAG, "SegDetector onSetup result:" + (lVar != null ? lVar.dc() + "," + lVar.dk() : null));
                l r = SegAR.this.r();
                if (r == null || SegAR.this.uY == null || lVar == null) {
                    return;
                }
                r.b(lVar.dk(), SegAR.this.uY.dj());
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
                com.baidu.ar.h.b.k(SegAR.TAG, "SegDetector onRelease aogoTyope = " + lVar.dk());
            }
        };
        b(true);
        com.baidu.ar.h.b.k(TAG, "enableSyncRender true");
        if (this.uY != null) {
            this.uY.y(true);
        }
        a(this.uY, this.mv);
        com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
        if (this.uY != null) {
            this.uY.b((Bundle) null);
        }
        al();
    }
}
