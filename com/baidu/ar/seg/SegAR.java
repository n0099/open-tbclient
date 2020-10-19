package com.baidu.ar.seg;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.core.engine.pixel.PixelRotation;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.arrender.i;
import com.baidu.ar.arrender.k;
import com.baidu.ar.arrender.n;
import com.baidu.ar.c;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class SegAR extends c {
    private static final String TAG = SegAR.class.getSimpleName();
    private static final float[] uA = {0.0f, -1.0f, 1.0f, 0.0f};
    private static final float[] uB = {0.0f, 1.0f, -1.0f, 0.0f};
    private static final float[] uC = {1.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] uD = {-1.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] uE = {0.0f, 1.0f, 1.0f, 0.0f};
    private static final float[] uF = {0.0f, -1.0f, -1.0f, 0.0f};
    private static final float[] uG = {-1.0f, 0.0f, 0.0f, -1.0f};
    private static final float[] uH = {1.0f, 0.0f, 0.0f, 1.0f};
    private LuaMsgListener bZ;
    private e mg;
    private SegDetector ul;
    private String un;
    private int oE = 2;
    private String bA = "ability_image_segmentation";
    private boolean um = true;
    private boolean pr = true;
    private int mDeviceOrientation = 0;
    private Vector4f uo = new Vector4f();
    private float up = 0.0f;
    private float uq = 0.0f;
    private int ur = 0;
    private float us = 0.0f;
    private float ut = 0.0f;
    private float uu = 0.0f;
    private float uv = 0.0f;
    private float uw = 0.0f;
    private float ux = 0.0f;
    private float uy = 0.0f;
    private float uz = 1.0f;
    private int uI = 0;
    private int uJ = 0;
    private byte[] hY = null;
    private long uK = 0;
    private AlgoHandleController bY = null;
    private int uL = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(a aVar) {
        if (this.oE != 4) {
            if (this.oE == 2) {
                getImgSegOrientation(aVar.getOrientation());
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("u_maskRotate", this.uo);
                return hashMap;
            } else if (this.oE == 5) {
                getSkySegOrientation(aVar.getOrientation());
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("u_maskRotate", this.uo);
                return hashMap2;
            } else {
                return null;
            }
        }
        getHairSegOrientation(aVar.getOrientation());
        b(aVar.gc(), aVar.getWidth(), aVar.getHeight());
        HashMap<String, Object> hashMap3 = new HashMap<>();
        hashMap3.put("enableSeq", Float.valueOf(1.0f));
        hashMap3.put("cameraFront", Integer.valueOf(this.pr ? 1 : 0));
        hashMap3.put("deviceOrientation", Integer.valueOf(this.mDeviceOrientation));
        hashMap3.put("u_maskRotate", this.uo);
        hashMap3.put("hairBlendType", Integer.valueOf(this.ur));
        hashMap3.put("hairThreshold", Float.valueOf(this.up));
        hashMap3.put("hairBlendAlpha", Float.valueOf(this.uq));
        hashMap3.put("hairTopPos", Float.valueOf(this.uy));
        hashMap3.put("hairBottomPos", Float.valueOf(this.uz));
        hashMap3.put("hairTop", new Vector4f(this.uv, this.uw, this.ux, 1.0f));
        hashMap3.put("hairBottom", new Vector4f(this.us, this.ut, this.uu, 1.0f));
        return hashMap3;
    }

    private void a(PixelRotation pixelRotation) {
        float[] fArr;
        switch (pixelRotation) {
            case RotateRight:
                fArr = uA;
                break;
            case RotateLeft:
                fArr = uB;
                break;
            case FlipVertical:
                fArr = uC;
                break;
            case FlipHorizontal:
                fArr = uD;
                break;
            case RotateRightFlipVertical:
                fArr = uE;
                break;
            case RotateRightFlipHorizontal:
                fArr = uF;
                break;
            case Rotate180:
                fArr = uG;
                break;
            default:
                fArr = uH;
                break;
        }
        this.uo.setXYZW(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    private void aj() {
        if (this.bZ == null) {
            this.bZ = new LuaMsgListener() { // from class: com.baidu.ar.seg.SegAR.2
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
        a(this.bZ);
    }

    private void b(long j) {
        if (this.bY == null || j <= 0) {
            return;
        }
        long handleType = this.bY.getHandleType(j);
        if (this.ul == null || handleType != this.uL) {
            return;
        }
        this.ul.b(j);
    }

    private void b(byte[] bArr, int i, int i2) {
        if (bArr == null || i <= 0 || i2 <= 0 || bArr.length < i * i2) {
            return;
        }
        this.uy = c(bArr, i, i2);
        this.uz = d(bArr, i, i2);
        if (this.mDeviceOrientation == 1 || this.mDeviceOrientation == 3) {
            this.uy -= 16.0f / i2;
            this.uz += 12.0f / i2;
        }
    }

    private float c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            for (int i4 = 0; i4 < i; i4++) {
                if ((bArr[(i3 * i) + i4] & 255) > ((int) (255.0f * this.up))) {
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
                if ((bArr[(i3 * i) + i4] & 255) > ((int) (255.0f * this.up))) {
                    return (i3 + 3 > i2 + (-1) ? i2 - 1 : i3 + 3) / i2;
                }
            }
        }
        return 1.0f;
    }

    private void l(HashMap<String, Object> hashMap) {
        if (com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1) == 5011) {
            StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
            this.oE = 2;
            this.uL = 11;
            this.bA = "ability_image_segmentation";
            String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.un = a2;
            return;
        }
        String a3 = com.baidu.ar.arplay.c.c.a(hashMap.get(LuaMessageHelper.KEY_EVENT_NAME), (String) null);
        if (a3 != null) {
            if (a3.equals("start_hair_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_HAIR_SEG_OPEN);
                m(hashMap);
                this.oE = 4;
                this.bA = "ability_hair_segmentation";
            } else if (a3.equals("start_sky_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_SKY_SEG_OPEN);
                String a4 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a4)) {
                    this.un = a4;
                }
                this.oE = 5;
                this.bA = "ability_sky_segmentation";
            } else if (a3.equals("start_image_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
                String a5 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a5)) {
                    this.un = a5;
                }
                this.oE = 2;
                this.bA = "ability_image_segmentation";
            } else {
                this.oE = -10;
            }
            switch (this.oE) {
                case 4:
                    this.uL = 13;
                    return;
                case 5:
                    this.uL = 12;
                    return;
                default:
                    this.uL = 11;
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(HashMap<String, Object> hashMap) {
        String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
        this.up = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_threshold"), 0.0f);
        this.uq = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_alpha"), 0.0f);
        this.ur = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_type"), 0);
        this.us = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_r"), 0.0f);
        this.ut = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_g"), 0.0f);
        this.uu = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_b"), 0.0f);
        this.uv = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_r"), 0.0f);
        this.uw = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_g"), 0.0f);
        this.ux = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_b"), 0.0f);
        if (!TextUtils.isEmpty(a2)) {
            this.un = a2;
        }
        if (this.ul != null) {
            this.ul.g(this.up);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.c
    public void a(long j) {
        super.a(j);
        if (j <= 0 || this.bY == null || this.bY.getHandleType(j) != this.uL) {
            return;
        }
        b(j);
    }

    public void getHairSegOrientation(int i) {
        switch (i) {
            case 0:
                if (this.pr) {
                }
                this.mDeviceOrientation = 1;
                a(this.pr ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 90:
                this.mDeviceOrientation = this.pr ? 2 : 0;
                a(this.pr ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 180:
                if (this.pr) {
                }
                this.mDeviceOrientation = 3;
                a(this.pr ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.mDeviceOrientation = this.pr ? 0 : 2;
                a(this.pr ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    public void getImgSegOrientation(int i) {
        switch (i) {
            case 0:
                this.mDeviceOrientation = this.pr ? 1 : 3;
                a(this.pr ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 90:
                this.mDeviceOrientation = this.pr ? 2 : 0;
                a(this.pr ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 180:
                this.mDeviceOrientation = this.pr ? 3 : 1;
                a(this.pr ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.mDeviceOrientation = this.pr ? 0 : 2;
                a(this.pr ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    public void getSkySegOrientation(int i) {
        switch (i) {
            case 0:
                this.mDeviceOrientation = this.pr ? 1 : 3;
                a(this.pr ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight);
                return;
            case 1:
                this.mDeviceOrientation = this.pr ? 2 : 0;
                a(this.pr ? PixelRotation.FlipVertical : PixelRotation.NoRotation);
                return;
            case 2:
                this.mDeviceOrientation = this.pr ? 3 : 1;
                a(this.pr ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft);
                return;
            default:
                this.mDeviceOrientation = this.pr ? 0 : 2;
                a(this.pr ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180);
                return;
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        b(false);
        com.baidu.ar.g.b.k(TAG, "enableSyncRender false");
        if (this.ul != null) {
            this.ul.A(false);
        }
        b(this.bZ);
        if (this.ul != null) {
            this.ul.a((AlgoHandleController) null);
            this.ul.au();
            a(this.ul);
        }
        if (this.bY != null) {
            this.bY.release();
            this.bY = null;
        }
        k r = r();
        if (r != null) {
            r.o(this.uL);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        com.baidu.ar.g.b.k(TAG, "setup(luaParams):" + hashMap.toString());
        if (this.bY == null) {
            this.bY = new AlgoHandleController();
        }
        l(hashMap);
        if (this.oE < -1) {
            com.baidu.ar.g.b.b(TAG, "无法解析能力类型 mMdlType:" + this.oE);
            return;
        }
        this.ul = new SegDetector(this.oE);
        this.ul.a(this.bY);
        this.mg = new e() { // from class: com.baidu.ar.seg.SegAR.1
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                if (!(bVar instanceof b) || ((b) bVar).gd() == null) {
                    return;
                }
                if (SegAR.this.um) {
                    SegAR.this.um = false;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(LuaMessageHelper.KEY_EVENT_NAME, "first_bgseg_detect");
                    SegAR.this.d(hashMap2);
                }
                k r = SegAR.this.r();
                long df = bVar.df();
                if (df > 0 && r != null) {
                    r.a(df, SegAR.this.bA);
                    SegAR.this.a(df);
                }
                a gd = ((b) bVar).gd();
                if (gd != null) {
                    SegAR.this.pr = gd.isFrontCamera();
                    int width = gd.getWidth();
                    int height = gd.getHeight();
                    if (gd.getOrientation() == 0 || gd.getOrientation() == 180 || gd.getOrientation() == 2) {
                        gd.setWidth(height);
                        gd.setHeight(width);
                    }
                    if (r != null) {
                        SegAR.this.uI = gd.getWidth();
                        SegAR.this.uJ = gd.getHeight();
                        SegAR.this.hY = gd.gc();
                        SegAR.this.uK = bVar.getTimestamp();
                        if (SegAR.this.uI <= 0 || SegAR.this.uJ <= 0 || SegAR.this.hY == null) {
                            return;
                        }
                        i iVar = new i();
                        iVar.p(SegAR.this.bA);
                        iVar.M(SegAR.this.un);
                        iVar.h(SegAR.this.a(gd));
                        r.a(iVar);
                        if (bVar.de() instanceof n) {
                            r.a((n) bVar.de(), true);
                        }
                    }
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                com.baidu.ar.g.b.k(SegAR.TAG, "SegDetector onSetup result:" + (lVar != null ? lVar.dd() + Constants.ACCEPT_TIME_SEPARATOR_SP + lVar.dl() : null));
                k r = SegAR.this.r();
                if (r == null || SegAR.this.ul == null || lVar == null) {
                    return;
                }
                r.b(lVar.dl(), SegAR.this.ul.dk());
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                com.baidu.ar.g.b.k(SegAR.TAG, "SegDetector onRelease aogoTyope = " + lVar.dl());
            }
        };
        b(true);
        com.baidu.ar.g.b.k(TAG, "enableSyncRender true");
        if (this.ul != null) {
            this.ul.A(true);
        }
        a(this.ul, this.mg);
        com.baidu.ar.b.a.ar().a(getContext(), getMdlConfigs());
        if (this.ul != null) {
            this.ul.b((Bundle) null);
        }
        aj();
    }
}
