package com.baidu.ar.seg;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.arrender.j;
import com.baidu.ar.arrender.m;
import com.baidu.ar.c.e;
import com.baidu.ar.c.i;
import com.baidu.ar.c.l;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SegAR extends com.baidu.ar.c {
    private LuaMsgListener bV;
    private e lb;
    private a tg;
    private com.baidu.ar.b.a.c th;
    private String tj;
    private static final String TAG = SegAR.class.getSimpleName();
    private static final float[] tw = {0.0f, -1.0f, 1.0f, 0.0f};
    private static final float[] tx = {0.0f, 1.0f, -1.0f, 0.0f};
    private static final float[] ty = {1.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] tz = {-1.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] tA = {0.0f, 1.0f, 1.0f, 0.0f};
    private static final float[] tB = {0.0f, -1.0f, -1.0f, 0.0f};
    private static final float[] tC = {-1.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] tD = {1.0f, 0.0f, 0.0f, 1.0f};
    private int cF = 2;
    private String bx = "ability_image_segmentation";
    private boolean ti = true;
    private boolean nC = true;
    private int mDeviceOrientation = 0;
    private Vector4f tk = new Vector4f();
    private float tl = 0.0f;
    private float tm = 0.0f;
    private int tn = 0;
    private float to = 0.0f;
    private float tp = 0.0f;
    private float tq = 0.0f;
    private float tr = 0.0f;
    private float ts = 0.0f;
    private float tt = 0.0f;
    private float tu = 0.0f;

    /* renamed from: tv  reason: collision with root package name */
    private float f987tv = 1.0f;
    private int tE = 0;
    private int tF = 0;
    private byte[] il = null;
    private long tG = 0;
    private AlgoHandleController bU = null;
    private int tH = -1;

    private void V() {
        if (this.bV == null) {
            this.bV = new LuaMsgListener() { // from class: com.baidu.ar.seg.SegAR.2
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(LuaMessageHelper.KEY_EVENT_NAME);
                    return arrayList;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if ("adjust_hair_segmentation".equals((String) hashMap.get(LuaMessageHelper.KEY_EVENT_NAME))) {
                        SegAR.this.o(hashMap);
                    }
                }
            };
        }
        a(this.bV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(b bVar) {
        if (this.cF != 4) {
            if (this.cF == 2) {
                getImgSegOrientation(bVar.getOrientation());
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("u_maskRotate", this.tk);
                return hashMap;
            } else if (this.cF == 5) {
                getSkySegOrientation(bVar.getOrientation());
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("u_maskRotate", this.tk);
                return hashMap2;
            } else {
                return null;
            }
        }
        getHairSegOrientation(bVar.getOrientation());
        b(bVar.ey(), bVar.getWidth(), bVar.getHeight());
        HashMap<String, Object> hashMap3 = new HashMap<>();
        hashMap3.put("enableSeq", Float.valueOf(1.0f));
        hashMap3.put("cameraFront", Integer.valueOf(this.nC ? 1 : 0));
        hashMap3.put("deviceOrientation", Integer.valueOf(this.mDeviceOrientation));
        hashMap3.put("u_maskRotate", this.tk);
        hashMap3.put("hairBlendType", Integer.valueOf(this.tn));
        hashMap3.put("hairThreshold", Float.valueOf(this.tl));
        hashMap3.put("hairBlendAlpha", Float.valueOf(this.tm));
        hashMap3.put("hairTopPos", Float.valueOf(this.tu));
        hashMap3.put("hairBottomPos", Float.valueOf(this.f987tv));
        hashMap3.put("hairTop", new Vector4f(this.tr, this.ts, this.tt, 1.0f));
        hashMap3.put("hairBottom", new Vector4f(this.to, this.tp, this.tq, 1.0f));
        return hashMap3;
    }

    private void a(PixelRotation pixelRotation) {
        float[] fArr;
        switch (pixelRotation) {
            case RotateRight:
                fArr = tw;
                break;
            case RotateLeft:
                fArr = tx;
                break;
            case FlipVertical:
                fArr = ty;
                break;
            case FlipHorizontal:
                fArr = tz;
                break;
            case RotateRightFlipVertical:
                fArr = tA;
                break;
            case RotateRightFlipHorizontal:
                fArr = tB;
                break;
            case Rotate180:
                fArr = tC;
                break;
            default:
                fArr = tD;
                break;
        }
        this.tk.setXYZW(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    private void b(long j) {
        if (this.bU == null || j <= 0) {
            return;
        }
        long handleType = this.bU.getHandleType(j);
        if (this.tg == null || handleType != this.tH) {
            return;
        }
        this.tg.b(j);
    }

    private void b(byte[] bArr, int i, int i2) {
        if (bArr == null || i <= 0 || i2 <= 0 || bArr.length < i * i2) {
            return;
        }
        this.tu = c(bArr, i, i2);
        this.f987tv = d(bArr, i, i2);
        if (this.mDeviceOrientation == 1 || this.mDeviceOrientation == 3) {
            this.tu -= 16.0f / i2;
            this.f987tv += 12.0f / i2;
        }
    }

    private float c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            for (int i4 = 0; i4 < i; i4++) {
                if ((bArr[(i3 * i) + i4] & 255) > ((int) (255.0f * this.tl))) {
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
                if ((bArr[(i3 * i) + i4] & 255) > ((int) (255.0f * this.tl))) {
                    return (i3 + 3 > i2 + (-1) ? i2 - 1 : i3 + 3) / i2;
                }
            }
        }
        return 1.0f;
    }

    private void n(HashMap<String, Object> hashMap) {
        if (com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1) == 5011) {
            StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
            this.cF = 2;
            this.tH = 11;
            this.bx = "ability_image_segmentation";
            this.th.g(2);
            String a = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
            if (TextUtils.isEmpty(a)) {
                return;
            }
            this.tj = a;
            return;
        }
        String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get(LuaMessageHelper.KEY_EVENT_NAME), (String) null);
        if (a2 != null) {
            if (a2.equals("start_hair_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_HAIR_SEG_OPEN);
                o(hashMap);
                this.cF = 4;
                this.bx = "ability_hair_segmentation";
                this.th.g(4);
            } else if (a2.equals("start_sky_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_SKY_SEG_OPEN);
                String a3 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a3)) {
                    this.tj = a3;
                }
                this.cF = 5;
                this.bx = "ability_sky_segmentation";
                this.th.g(5);
            } else if (a2.equals("start_image_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
                String a4 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a4)) {
                    this.tj = a4;
                }
                this.cF = 2;
                this.bx = "ability_image_segmentation";
                this.th.g(2);
            } else {
                this.cF = -10;
            }
            switch (this.cF) {
                case 4:
                    this.tH = 13;
                    return;
                case 5:
                    this.tH = 12;
                    return;
                default:
                    this.tH = 11;
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(HashMap<String, Object> hashMap) {
        String a = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
        this.tl = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_threshold"), 0.0f);
        this.tm = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_alpha"), 0.0f);
        this.tn = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_type"), 0);
        this.to = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_r"), 0.0f);
        this.tp = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_g"), 0.0f);
        this.tq = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_b"), 0.0f);
        this.tr = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_r"), 0.0f);
        this.ts = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_g"), 0.0f);
        this.tt = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_b"), 0.0f);
        if (!TextUtils.isEmpty(a)) {
            this.tj = a;
        }
        if (this.tg != null) {
            this.tg.e(this.tl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bU == null || this.bU.getHandleType(j) != this.tH) {
            return;
        }
        b(j);
    }

    public void getHairSegOrientation(int i) {
        switch (i) {
            case 0:
                if (this.nC) {
                }
                this.mDeviceOrientation = 1;
                a(this.nC ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 90:
                this.mDeviceOrientation = this.nC ? 2 : 0;
                a(this.nC ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 180:
                if (this.nC) {
                }
                this.mDeviceOrientation = 3;
                a(this.nC ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.mDeviceOrientation = this.nC ? 0 : 2;
                a(this.nC ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    public void getImgSegOrientation(int i) {
        switch (i) {
            case 0:
                this.mDeviceOrientation = this.nC ? 1 : 3;
                a(this.nC ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 90:
                this.mDeviceOrientation = this.nC ? 2 : 0;
                a(this.nC ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 180:
                this.mDeviceOrientation = this.nC ? 3 : 1;
                a(this.nC ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.mDeviceOrientation = this.nC ? 0 : 2;
                a(this.nC ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    public void getSkySegOrientation(int i) {
        switch (i) {
            case 0:
                this.mDeviceOrientation = this.nC ? 1 : 3;
                a(this.nC ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 1:
                this.mDeviceOrientation = this.nC ? 2 : 0;
                a(this.nC ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 2:
                this.mDeviceOrientation = this.nC ? 3 : 1;
                a(this.nC ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.mDeviceOrientation = this.nC ? 0 : 2;
                a(this.nC ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        com.baidu.ar.f.b.i(TAG, "enableSyncRender false");
        if (this.tg != null) {
            this.tg.S(false);
        }
        b(this.bV);
        if (this.tg != null) {
            this.tg.a((AlgoHandleController) null);
            this.tg.ai();
            a(this.tg);
        }
        if (this.bU != null) {
            this.bU.release();
            this.bU = null;
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        com.baidu.ar.f.b.i(TAG, "setup(luaParams):" + hashMap.toString());
        if (this.bU == null) {
            this.bU = new AlgoHandleController();
        }
        this.th = new com.baidu.ar.b.a.c(i.SEG);
        this.tg = new a();
        this.tg.a(this.bU);
        n(hashMap);
        if (this.cF < -1) {
            com.baidu.ar.f.b.b(TAG, "无法解析能力类型 mMdlType:" + this.cF);
            return;
        }
        this.lb = new e() { // from class: com.baidu.ar.seg.SegAR.1
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                com.baidu.ar.f.b.c(SegAR.TAG, "SegDetector onDetected");
                if (!(bVar instanceof c) || ((c) bVar).ez() == null) {
                    return;
                }
                if (SegAR.this.ti) {
                    SegAR.this.ti = false;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(LuaMessageHelper.KEY_EVENT_NAME, "first_bgseg_detect");
                    SegAR.this.d(hashMap2);
                }
                j r = SegAR.this.r();
                long cn = bVar.cn();
                if (cn > 0 && r != null) {
                    r.a(cn, SegAR.this.bx);
                }
                b ez = ((c) bVar).ez();
                if (ez != null) {
                    SegAR.this.nC = ez.isFrontCamera();
                    int width = ez.getWidth();
                    int height = ez.getHeight();
                    if (ez.getOrientation() == 0 || ez.getOrientation() == 180 || ez.getOrientation() == 2) {
                        ez.setWidth(height);
                        ez.setHeight(width);
                    }
                    if (r != null) {
                        SegAR.this.tE = ez.getWidth();
                        SegAR.this.tF = ez.getHeight();
                        SegAR.this.il = ez.ey();
                        SegAR.this.tG = bVar.getTimestamp();
                        if (SegAR.this.tE <= 0 || SegAR.this.tF <= 0 || SegAR.this.il == null) {
                            return;
                        }
                        com.baidu.ar.arrender.i iVar = new com.baidu.ar.arrender.i();
                        iVar.o(SegAR.this.bx);
                        iVar.M(SegAR.this.tj);
                        iVar.i(SegAR.this.a(ez));
                        r.a(iVar);
                        if (bVar.cm() instanceof m) {
                            r.a((m) bVar.cm(), true);
                        }
                    }
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                com.baidu.ar.f.b.i(SegAR.TAG, "SegDetector onSetup result:" + (lVar != null ? lVar.cl() + Constants.ACCEPT_TIME_SEPARATOR_SP + lVar.isSuccess() : null));
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                com.baidu.ar.f.b.i(SegAR.TAG, "SegDetector onRelease result:" + lVar);
            }
        };
        b(true);
        com.baidu.ar.f.b.i(TAG, "enableSyncRender true");
        if (this.tg != null) {
            this.tg.S(true);
            this.tg.a(this.th);
        }
        a(this.tg, this.lb);
        com.baidu.ar.b.a.ac().a(getContext(), getMdlConfigs());
        if (this.tg != null) {
            this.tg.c((Bundle) null);
        }
        V();
    }
}
