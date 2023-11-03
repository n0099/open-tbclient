package com.baidu.ar.seg;

import android.os.Bundle;
import android.text.TextUtils;
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
/* loaded from: classes.dex */
public class SegAR extends c {
    public static final String TAG = "SegAR";
    public static final float[] vo = {0.0f, -1.0f, 1.0f, 0.0f};
    public static final float[] vp = {0.0f, 1.0f, -1.0f, 0.0f};
    public static final float[] vq = {1.0f, 0.0f, 0.0f, -1.0f};
    public static final float[] vr = {-1.0f, 0.0f, 0.0f, 1.0f};
    public static final float[] vs = {0.0f, 1.0f, 1.0f, 0.0f};
    public static final float[] vt = {0.0f, -1.0f, -1.0f, 0.0f};
    public static final float[] vu = {-1.0f, 0.0f, 0.0f, -1.0f};
    public static final float[] vv = {1.0f, 0.0f, 0.0f, 1.0f};
    public LuaMsgListener cc;
    public e mv;
    public SegDetector uY;
    public String va;
    public int oU = 2;
    public String bD = "ability_image_segmentation";
    public boolean uZ = true;
    public boolean pH = true;
    public int vb = 0;
    public Vector4f vc = new Vector4f();
    public float vd = 0.0f;
    public float ve = 0.0f;
    public int vf = 0;
    public float vg = 0.0f;
    public float vh = 0.0f;

    /* renamed from: vi  reason: collision with root package name */
    public float f1036vi = 0.0f;
    public float vj = 0.0f;
    public float vk = 0.0f;
    public float vl = 0.0f;
    public float vm = 0.0f;
    public float vn = 1.0f;
    public int vw = 0;
    public int vx = 0;
    public byte[] io = null;
    public long vy = 0;
    public AlgoHandleController cb = null;
    public int vz = -1;

    /* renamed from: com.baidu.ar.seg.SegAR$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] vB;

        static {
            int[] iArr = new int[PixelRotation.values().length];
            vB = iArr;
            try {
                iArr[PixelRotation.RotateRight.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                vB[PixelRotation.RotateLeft.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                vB[PixelRotation.FlipVertical.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                vB[PixelRotation.FlipHorizontal.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                vB[PixelRotation.RotateRightFlipVertical.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                vB[PixelRotation.RotateRightFlipHorizontal.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                vB[PixelRotation.Rotate180.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                vB[PixelRotation.NoRotation.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(a aVar) {
        int i = this.oU;
        if (i != 4) {
            if (i == 2) {
                getImgSegOrientation(aVar.getOrientation());
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("u_maskRotate", this.vc);
                return hashMap;
            } else if (i == 5) {
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
        hashMap3.put("hairBottom", new Vector4f(this.vg, this.vh, this.f1036vi, 1.0f));
        return hashMap3;
    }

    private void a(PixelRotation pixelRotation) {
        float[] fArr;
        switch (AnonymousClass3.vB[pixelRotation.ordinal()]) {
            case 1:
                fArr = vo;
                break;
            case 2:
                fArr = vp;
                break;
            case 3:
                fArr = vq;
                break;
            case 4:
                fArr = vr;
                break;
            case 5:
                fArr = vs;
                break;
            case 6:
                fArr = vt;
                break;
            case 7:
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
                    arrayList.add("event_name");
                    return arrayList;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if ("adjust_hair_segmentation".equals((String) hashMap.get("event_name"))) {
                        SegAR.this.m(hashMap);
                    }
                }
            };
        }
        a(this.cc);
    }

    private void b(long j) {
        AlgoHandleController algoHandleController = this.cb;
        if (algoHandleController == null || j <= 0) {
            return;
        }
        long handleType = algoHandleController.getHandleType(j);
        SegDetector segDetector = this.uY;
        if (segDetector == null || handleType != this.vz) {
            return;
        }
        segDetector.b(j);
    }

    private void b(byte[] bArr, int i, int i2) {
        if (bArr == null || i <= 0 || i2 <= 0 || bArr.length < i * i2) {
            return;
        }
        this.vm = c(bArr, i, i2);
        this.vn = d(bArr, i, i2);
        int i3 = this.vb;
        if (i3 == 1 || i3 == 3) {
            float f = i2;
            this.vm -= 16.0f / f;
            this.vn += 12.0f / f;
        }
    }

    private float c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            for (int i4 = 0; i4 < i; i4++) {
                if ((bArr[(i3 * i) + i4] & 255) > ((int) (this.vd * 255.0f))) {
                    return (i3 >= 3 ? i3 - 3 : 0) / i2;
                }
            }
            i3 += 3;
        }
        return 0.0f;
    }

    private float d(byte[] bArr, int i, int i2) {
        int i3 = i2 - 1;
        for (int i4 = i3; i4 > 0; i4 -= 3) {
            for (int i5 = 0; i5 < i; i5++) {
                if ((bArr[(i4 * i) + i5] & 255) > ((int) (this.vd * 255.0f))) {
                    int i6 = i4 + 3;
                    if (i6 <= i3) {
                        i3 = i6;
                    }
                    return i3 / i2;
                }
            }
        }
        return 1.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l(HashMap<String, Object> hashMap) {
        String str;
        int i;
        int i2;
        if (com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1) == 5011) {
            StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
            this.oU = 2;
            this.vz = 11;
            this.bD = "ability_image_segmentation";
            String a = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
            if (TextUtils.isEmpty(a)) {
                return;
            }
            this.va = a;
            return;
        }
        String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("event_name"), (String) null);
        if (a2 == null) {
            return;
        }
        if (a2.equals("start_hair_segmentation")) {
            StatisticApi.onEvent(StatisticConstants.MDL_HAIR_SEG_OPEN);
            m(hashMap);
            this.oU = 4;
            str = "ability_hair_segmentation";
        } else if (!a2.equals("start_sky_segmentation")) {
            if (a2.equals("start_image_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
                String a3 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a3)) {
                    this.va = a3;
                }
                this.oU = 2;
                this.bD = "ability_image_segmentation";
            } else {
                this.oU = -10;
            }
            i = this.oU;
            if (i != 4) {
                i2 = 13;
            } else if (i != 5) {
                this.vz = 11;
                return;
            } else {
                i2 = 12;
            }
            this.vz = i2;
        } else {
            StatisticApi.onEvent(StatisticConstants.MDL_SKY_SEG_OPEN);
            String a4 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
            if (!TextUtils.isEmpty(a4)) {
                this.va = a4;
            }
            this.oU = 5;
            str = "ability_sky_segmentation";
        }
        this.bD = str;
        i = this.oU;
        if (i != 4) {
        }
        this.vz = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(HashMap<String, Object> hashMap) {
        String a = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
        this.vd = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_threshold"), 0.0f);
        this.ve = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_alpha"), 0.0f);
        this.vf = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_type"), 0);
        this.vg = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_r"), 0.0f);
        this.vh = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_g"), 0.0f);
        this.f1036vi = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_b"), 0.0f);
        this.vj = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_r"), 0.0f);
        this.vk = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_g"), 0.0f);
        this.vl = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_b"), 0.0f);
        if (!TextUtils.isEmpty(a)) {
            this.va = a;
        }
        SegDetector segDetector = this.uY;
        if (segDetector != null) {
            segDetector.f(this.vd);
        }
    }

    @Override // com.baidu.ar.c
    public void a(long j) {
        AlgoHandleController algoHandleController;
        super.a(j);
        if (j <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j) != this.vz) {
            return;
        }
        b(j);
    }

    public void getHairSegOrientation(int i) {
        PixelRotation pixelRotation;
        if (i != 0) {
            if (i == 90) {
                this.vb = this.pH ? 2 : 0;
                pixelRotation = this.pH ? PixelRotation.FlipVertical : PixelRotation.NoRotation;
            } else if (i != 180) {
                this.vb = this.pH ? 0 : 2;
                pixelRotation = this.pH ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180;
            } else {
                this.vb = 3;
                pixelRotation = this.pH ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft;
            }
        } else {
            this.vb = 1;
            pixelRotation = this.pH ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
        }
        a(pixelRotation);
    }

    public void getImgSegOrientation(int i) {
        PixelRotation pixelRotation;
        if (i != 0) {
            if (i == 1) {
                this.vb = this.pH ? 2 : 0;
                pixelRotation = this.pH ? PixelRotation.FlipVertical : PixelRotation.NoRotation;
            } else if (i != 2) {
                this.vb = this.pH ? 0 : 2;
                pixelRotation = this.pH ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180;
            } else {
                this.vb = this.pH ? 3 : 1;
                pixelRotation = this.pH ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft;
            }
        } else {
            this.vb = this.pH ? 1 : 3;
            pixelRotation = this.pH ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
        }
        a(pixelRotation);
    }

    public void getSkySegOrientation(int i) {
        PixelRotation pixelRotation;
        if (i != 0) {
            if (i == 1) {
                this.vb = this.pH ? 2 : 0;
                pixelRotation = this.pH ? PixelRotation.FlipVertical : PixelRotation.NoRotation;
            } else if (i != 2) {
                this.vb = this.pH ? 0 : 2;
                pixelRotation = this.pH ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180;
            } else {
                this.vb = this.pH ? 3 : 1;
                pixelRotation = this.pH ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft;
            }
        } else {
            this.vb = this.pH ? 1 : 3;
            pixelRotation = this.pH ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
        }
        a(pixelRotation);
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        com.baidu.ar.h.b.k(TAG, "enableSyncRender false");
        SegDetector segDetector = this.uY;
        if (segDetector != null) {
            segDetector.y(false);
        }
        b(this.cc);
        SegDetector segDetector2 = this.uY;
        if (segDetector2 != null) {
            segDetector2.a((AlgoHandleController) null);
            this.uY.av();
            a(this.uY);
        }
        AlgoHandleController algoHandleController = this.cb;
        if (algoHandleController != null) {
            algoHandleController.release();
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
        String str = TAG;
        com.baidu.ar.h.b.k(str, "setup(luaParams):" + hashMap.toString());
        if (this.cb == null) {
            this.cb = new AlgoHandleController();
        }
        l(hashMap);
        if (this.oU < -1) {
            String str2 = TAG;
            com.baidu.ar.h.b.b(str2, "无法解析能力类型 mMdlType:" + this.oU);
            return;
        }
        SegDetector segDetector = new SegDetector(this.oU);
        this.uY = segDetector;
        segDetector.a(this.cb);
        this.mv = new e() { // from class: com.baidu.ar.seg.SegAR.1
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (bVar instanceof b) {
                    b bVar2 = (b) bVar;
                    if (bVar2.gd() != null) {
                        if (SegAR.this.uZ) {
                            SegAR.this.uZ = false;
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("event_name", "first_bgseg_detect");
                            SegAR.this.d(hashMap2);
                        }
                        l r = SegAR.this.r();
                        long de = bVar.de();
                        if (de > 0 && r != null) {
                            r.a(de, SegAR.this.bD);
                            SegAR.this.a(de);
                        }
                        a gd = bVar2.gd();
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
                                SegAR.this.io = gd.gc();
                                SegAR.this.vy = bVar.getTimestamp();
                                if (SegAR.this.vw <= 0 || SegAR.this.vx <= 0 || SegAR.this.io == null) {
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
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
                String str3;
                String str4 = SegAR.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("SegDetector onSetup result:");
                if (lVar != null) {
                    str3 = lVar.dc() + "," + lVar.dk();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                com.baidu.ar.h.b.k(str4, sb.toString());
                l r = SegAR.this.r();
                if (r == null || SegAR.this.uY == null || lVar == null) {
                    return;
                }
                r.b(lVar.dk(), SegAR.this.uY.dj());
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
                String str3 = SegAR.TAG;
                com.baidu.ar.h.b.k(str3, "SegDetector onRelease aogoTyope = " + lVar.dk());
            }
        };
        b(true);
        com.baidu.ar.h.b.k(TAG, "enableSyncRender true");
        SegDetector segDetector2 = this.uY;
        if (segDetector2 != null) {
            segDetector2.y(true);
        }
        a(this.uY, this.mv);
        com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
        SegDetector segDetector3 = this.uY;
        if (segDetector3 != null) {
            segDetector3.b((Bundle) null);
        }
        al();
    }
}
