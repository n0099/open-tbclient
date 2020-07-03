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
    private static final String TAG = SegAR.class.getSimpleName();
    private static final float[] tW = {0.0f, -1.0f, 1.0f, 0.0f};
    private static final float[] tX = {0.0f, 1.0f, -1.0f, 0.0f};
    private static final float[] tY = {1.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] tZ = {-1.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] ua = {0.0f, 1.0f, 1.0f, 0.0f};
    private static final float[] ub = {0.0f, -1.0f, -1.0f, 0.0f};
    private static final float[] uc = {-1.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] ud = {1.0f, 0.0f, 0.0f, 1.0f};
    private LuaMsgListener ci;
    private e ly;
    private a tG;
    private com.baidu.ar.b.a.c tH;
    private String tJ;
    private int cS = 2;
    private String bJ = "ability_image_segmentation";
    private boolean tI = true;
    private boolean nZ = true;
    private int mDeviceOrientation = 0;
    private Vector4f tK = new Vector4f();
    private float tL = 0.0f;
    private float tM = 0.0f;
    private int tN = 0;
    private float tO = 0.0f;
    private float tP = 0.0f;
    private float tQ = 0.0f;
    private float tR = 0.0f;
    private float tS = 0.0f;
    private float tT = 0.0f;
    private float tU = 0.0f;
    private float tV = 1.0f;
    private int ue = 0;
    private int uf = 0;
    private byte[] iA = null;
    private long ug = 0;
    private AlgoHandleController ch = null;
    private int uh = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(b bVar) {
        if (this.cS != 4) {
            if (this.cS == 2) {
                getImgSegOrientation(bVar.getOrientation());
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("u_maskRotate", this.tK);
                return hashMap;
            } else if (this.cS == 5) {
                getSkySegOrientation(bVar.getOrientation());
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("u_maskRotate", this.tK);
                return hashMap2;
            } else {
                return null;
            }
        }
        getHairSegOrientation(bVar.getOrientation());
        b(bVar.eO(), bVar.getWidth(), bVar.getHeight());
        HashMap<String, Object> hashMap3 = new HashMap<>();
        hashMap3.put("enableSeq", Float.valueOf(1.0f));
        hashMap3.put("cameraFront", Integer.valueOf(this.nZ ? 1 : 0));
        hashMap3.put("deviceOrientation", Integer.valueOf(this.mDeviceOrientation));
        hashMap3.put("u_maskRotate", this.tK);
        hashMap3.put("hairBlendType", Integer.valueOf(this.tN));
        hashMap3.put("hairThreshold", Float.valueOf(this.tL));
        hashMap3.put("hairBlendAlpha", Float.valueOf(this.tM));
        hashMap3.put("hairTopPos", Float.valueOf(this.tU));
        hashMap3.put("hairBottomPos", Float.valueOf(this.tV));
        hashMap3.put("hairTop", new Vector4f(this.tR, this.tS, this.tT, 1.0f));
        hashMap3.put("hairBottom", new Vector4f(this.tO, this.tP, this.tQ, 1.0f));
        return hashMap3;
    }

    private void a(PixelRotation pixelRotation) {
        float[] fArr;
        switch (pixelRotation) {
            case RotateRight:
                fArr = tW;
                break;
            case RotateLeft:
                fArr = tX;
                break;
            case FlipVertical:
                fArr = tY;
                break;
            case FlipHorizontal:
                fArr = tZ;
                break;
            case RotateRightFlipVertical:
                fArr = ua;
                break;
            case RotateRightFlipHorizontal:
                fArr = ub;
                break;
            case Rotate180:
                fArr = uc;
                break;
            default:
                fArr = ud;
                break;
        }
        this.tK.setXYZW(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    private void aj() {
        if (this.ci == null) {
            this.ci = new LuaMsgListener() { // from class: com.baidu.ar.seg.SegAR.2
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
        a(this.ci);
    }

    private void b(long j) {
        if (this.ch == null || j <= 0) {
            return;
        }
        long handleType = this.ch.getHandleType(j);
        if (this.tG == null || handleType != this.uh) {
            return;
        }
        this.tG.b(j);
    }

    private void b(byte[] bArr, int i, int i2) {
        if (bArr == null || i <= 0 || i2 <= 0 || bArr.length < i * i2) {
            return;
        }
        this.tU = c(bArr, i, i2);
        this.tV = d(bArr, i, i2);
        if (this.mDeviceOrientation == 1 || this.mDeviceOrientation == 3) {
            this.tU -= 16.0f / i2;
            this.tV += 12.0f / i2;
        }
    }

    private float c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            for (int i4 = 0; i4 < i; i4++) {
                if ((bArr[(i3 * i) + i4] & 255) > ((int) (255.0f * this.tL))) {
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
                if ((bArr[(i3 * i) + i4] & 255) > ((int) (255.0f * this.tL))) {
                    return (i3 + 3 > i2 + (-1) ? i2 - 1 : i3 + 3) / i2;
                }
            }
        }
        return 1.0f;
    }

    private void n(HashMap<String, Object> hashMap) {
        if (com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1) == 5011) {
            StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
            this.cS = 2;
            this.uh = 11;
            this.bJ = "ability_image_segmentation";
            this.tH.h(2);
            String a = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
            if (TextUtils.isEmpty(a)) {
                return;
            }
            this.tJ = a;
            return;
        }
        String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get(LuaMessageHelper.KEY_EVENT_NAME), (String) null);
        if (a2 != null) {
            if (a2.equals("start_hair_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_HAIR_SEG_OPEN);
                o(hashMap);
                this.cS = 4;
                this.bJ = "ability_hair_segmentation";
                this.tH.h(4);
            } else if (a2.equals("start_sky_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_SKY_SEG_OPEN);
                String a3 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a3)) {
                    this.tJ = a3;
                }
                this.cS = 5;
                this.bJ = "ability_sky_segmentation";
                this.tH.h(5);
            } else if (a2.equals("start_image_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
                String a4 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a4)) {
                    this.tJ = a4;
                }
                this.cS = 2;
                this.bJ = "ability_image_segmentation";
                this.tH.h(2);
            } else {
                this.cS = -10;
            }
            switch (this.cS) {
                case 4:
                    this.uh = 13;
                    return;
                case 5:
                    this.uh = 12;
                    return;
                default:
                    this.uh = 11;
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(HashMap<String, Object> hashMap) {
        String a = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
        this.tL = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_threshold"), 0.0f);
        this.tM = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_alpha"), 0.0f);
        this.tN = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_type"), 0);
        this.tO = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_r"), 0.0f);
        this.tP = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_g"), 0.0f);
        this.tQ = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_b"), 0.0f);
        this.tR = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_r"), 0.0f);
        this.tS = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_g"), 0.0f);
        this.tT = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_b"), 0.0f);
        if (!TextUtils.isEmpty(a)) {
            this.tJ = a;
        }
        if (this.tG != null) {
            this.tG.g(this.tL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.ch == null || this.ch.getHandleType(j) != this.uh) {
            return;
        }
        b(j);
    }

    public void getHairSegOrientation(int i) {
        switch (i) {
            case 0:
                if (this.nZ) {
                }
                this.mDeviceOrientation = 1;
                a(this.nZ ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 90:
                this.mDeviceOrientation = this.nZ ? 2 : 0;
                a(this.nZ ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 180:
                if (this.nZ) {
                }
                this.mDeviceOrientation = 3;
                a(this.nZ ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.mDeviceOrientation = this.nZ ? 0 : 2;
                a(this.nZ ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    public void getImgSegOrientation(int i) {
        switch (i) {
            case 0:
                this.mDeviceOrientation = this.nZ ? 1 : 3;
                a(this.nZ ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 90:
                this.mDeviceOrientation = this.nZ ? 2 : 0;
                a(this.nZ ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 180:
                this.mDeviceOrientation = this.nZ ? 3 : 1;
                a(this.nZ ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.mDeviceOrientation = this.nZ ? 0 : 2;
                a(this.nZ ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    public void getSkySegOrientation(int i) {
        switch (i) {
            case 0:
                this.mDeviceOrientation = this.nZ ? 1 : 3;
                a(this.nZ ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 1:
                this.mDeviceOrientation = this.nZ ? 2 : 0;
                a(this.nZ ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 2:
                this.mDeviceOrientation = this.nZ ? 3 : 1;
                a(this.nZ ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.mDeviceOrientation = this.nZ ? 0 : 2;
                a(this.nZ ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        com.baidu.ar.f.b.i(TAG, "enableSyncRender false");
        if (this.tG != null) {
            this.tG.T(false);
        }
        b(this.ci);
        if (this.tG != null) {
            this.tG.a((AlgoHandleController) null);
            this.tG.aw();
            a(this.tG);
        }
        if (this.ch != null) {
            this.ch.release();
            this.ch = null;
        }
        j r = r();
        if (r != null) {
            r.r(this.uh);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        com.baidu.ar.f.b.i(TAG, "setup(luaParams):" + hashMap.toString());
        if (this.ch == null) {
            this.ch = new AlgoHandleController();
        }
        this.tH = new com.baidu.ar.b.a.c(i.SEG);
        this.tG = new a();
        this.tG.a(this.ch);
        n(hashMap);
        if (this.cS < -1) {
            com.baidu.ar.f.b.b(TAG, "无法解析能力类型 mMdlType:" + this.cS);
            return;
        }
        this.ly = new e() { // from class: com.baidu.ar.seg.SegAR.1
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                if (!(bVar instanceof c) || ((c) bVar).eP() == null) {
                    return;
                }
                if (SegAR.this.tI) {
                    SegAR.this.tI = false;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(LuaMessageHelper.KEY_EVENT_NAME, "first_bgseg_detect");
                    SegAR.this.d(hashMap2);
                }
                j r = SegAR.this.r();
                long cF = bVar.cF();
                if (cF > 0 && r != null) {
                    r.a(cF, SegAR.this.bJ);
                    SegAR.this.a(cF);
                }
                b eP = ((c) bVar).eP();
                if (eP != null) {
                    SegAR.this.nZ = eP.isFrontCamera();
                    int width = eP.getWidth();
                    int height = eP.getHeight();
                    if (eP.getOrientation() == 0 || eP.getOrientation() == 180 || eP.getOrientation() == 2) {
                        eP.setWidth(height);
                        eP.setHeight(width);
                    }
                    if (r != null) {
                        SegAR.this.ue = eP.getWidth();
                        SegAR.this.uf = eP.getHeight();
                        SegAR.this.iA = eP.eO();
                        SegAR.this.ug = bVar.getTimestamp();
                        if (SegAR.this.ue <= 0 || SegAR.this.uf <= 0 || SegAR.this.iA == null) {
                            return;
                        }
                        com.baidu.ar.arrender.i iVar = new com.baidu.ar.arrender.i();
                        iVar.o(SegAR.this.bJ);
                        iVar.M(SegAR.this.tJ);
                        iVar.i(SegAR.this.a(eP));
                        r.a(iVar);
                        if (bVar.cE() instanceof m) {
                            r.a((m) bVar.cE(), true);
                        }
                    }
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                com.baidu.ar.f.b.i(SegAR.TAG, "SegDetector onSetup result:" + (lVar != null ? lVar.cD() + Constants.ACCEPT_TIME_SEPARATOR_SP + lVar.cL() : null));
                j r = SegAR.this.r();
                if (r == null || SegAR.this.tG == null || lVar == null) {
                    return;
                }
                r.a(lVar.cL(), SegAR.this.tG.cK());
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                com.baidu.ar.f.b.i(SegAR.TAG, "SegDetector onRelease aogoTyope = " + lVar.cL());
            }
        };
        b(true);
        com.baidu.ar.f.b.i(TAG, "enableSyncRender true");
        if (this.tG != null) {
            this.tG.T(true);
            this.tG.a(this.tH);
        }
        a(this.tG, this.ly);
        com.baidu.ar.b.a.aq().a(getContext(), getMdlConfigs());
        if (this.tG != null) {
            this.tG.c((Bundle) null);
        }
        aj();
    }
}
