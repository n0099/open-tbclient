package com.baidu.ar.seg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.arrender.m;
import com.baidu.ar.c.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a extends com.baidu.ar.b.a.b {
    private static final String TAG = a.class.getSimpleName();
    protected boolean mIsFrontCamera;
    protected int uw;
    private int uk = 192;
    private int ul = 192;
    private int um = 192;
    private int un = 192;
    private int uo = 256;
    private int up = 144;
    private int uq = 128;
    private int ur = 224;
    private int us = 192;
    private int ut = 192;
    private int uu = 160;
    private int uv = 160;
    private int cS = 2;
    private float pH = 0.0f;
    private boolean mK = true;
    private boolean nJ = true;

    public a() {
        this.mm = new PixelReadParams(PixelType.BGR);
        this.mm.setOutputWidth(this.uk);
        this.mm.setOutputHeight(this.ul);
    }

    private int cL() {
        switch (this.cS) {
            case 4:
                return 13;
            case 5:
                return 12;
            default:
                return 11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eL() {
        switch (this.uw) {
            case -90:
                return 0;
            case 0:
                return !this.mIsFrontCamera ? 90 : -90;
            case 90:
                return 180;
            case 180:
                return this.mIsFrontCamera ? 90 : -90;
            default:
                return this.mIsFrontCamera ? -90 : 90;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eM() {
        switch (this.uw) {
            case -90:
                return this.mIsFrontCamera ? 2 : 0;
            case 90:
                return !this.mIsFrontCamera ? 2 : 0;
            case 180:
                return this.mIsFrontCamera ? 1 : 3;
            default:
                return this.mIsFrontCamera ? 3 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eN() {
        switch (this.uw) {
            case -90:
                if (this.mIsFrontCamera) {
                }
                return 0;
            case 90:
                if (this.mIsFrontCamera) {
                }
                return 180;
            case 180:
                return !this.mIsFrontCamera ? 270 : 90;
            default:
                return this.mIsFrontCamera ? 270 : 90;
        }
    }

    public void T(boolean z) {
        this.mK = z;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, final int i3, final int i4) {
        return new com.baidu.ar.b.b.b(this.cP.at()) { // from class: com.baidu.ar.seg.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap aA() {
                byte[] bArr;
                byte[] bArr2 = null;
                int i5 = 0;
                int i6 = 0;
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                a.this.mIsFrontCamera = z;
                a.this.uw = i3;
                int i7 = i3;
                switch (at()) {
                    case 2:
                        int[] iArr = new int[2];
                        byte[] bArr3 = new byte[a.this.um * a.this.un];
                        int i8 = a.this.um;
                        int i9 = a.this.un;
                        int eL = a.this.eL();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!a.this.nJ) {
                            ARMdlInterfaceJNI.predictHumanSeg(byteBuffer, i, i2, eL, z, bArr3, iArr, 0L);
                            bArr = bArr3;
                        } else if (a.this.ch != null) {
                            try {
                                long createHandle = a.this.ch.createHandle();
                                a.this.ch.setHandleInput(createHandle, 11, j, 2, i, i2, z, i4, a.this.mK, byteBuffer);
                                a.this.ch.setUsingHandle(createHandle);
                                ARMdlInterfaceJNI.predictHumanSeg(null, i, i2, eL, z, null, iArr, createHandle);
                                if (a.this.ch != null) {
                                    a.this.ch.setUsingHandle(0L);
                                    ReserveHandleData reserveHandleData = new ReserveHandleData();
                                    a.this.ch.getHandleReserveData(createHandle, reserveHandleData);
                                    if (reserveHandleData.getByteArrayListData() != null && reserveHandleData.getByteArrayListData().size() > 0) {
                                        bArr3 = reserveHandleData.getByteArrayListData().get(0);
                                    }
                                    hashMap.put("handle", Long.valueOf(createHandle));
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle);
                                }
                                bArr = bArr3;
                            } catch (Exception e) {
                                bArr2 = bArr3;
                                e.printStackTrace();
                                i7 = eL;
                                i6 = i9;
                                i5 = i8;
                                break;
                            }
                        } else {
                            bArr = bArr3;
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("bg_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                        i7 = eL;
                        i5 = i8;
                        bArr2 = bArr;
                        i6 = i9;
                        break;
                    case 4:
                        bArr2 = new byte[a.this.uq * a.this.ur];
                        int i10 = a.this.uq;
                        i6 = a.this.ur;
                        i7 = a.this.eN();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        if (!a.this.nJ) {
                            ARMdlInterfaceJNI.predictHairSeg(byteBuffer, i, i2, a.this.uq, a.this.ur, 1, i7, false, bArr2, 0L);
                        } else if (a.this.ch != null) {
                            try {
                                long createHandle2 = a.this.ch.createHandle();
                                a.this.ch.setHandleInput(createHandle2, 13, j, 0, i, i2, z, i4, a.this.mK, byteBuffer);
                                a.this.ch.setUsingHandle(createHandle2);
                                a.this.ch.setHandleMaskThreshold(createHandle2, a.this.pH);
                                ARMdlInterfaceJNI.predictHairSeg(null, i, i2, a.this.uq, a.this.ur, 1, i7, false, null, createHandle2);
                                if (a.this.ch != null) {
                                    a.this.ch.setUsingHandle(0L);
                                    bArr2 = a.this.ch.getHandleMaskData(createHandle2);
                                    hashMap.put("handle", Long.valueOf(createHandle2));
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle2);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                i5 = i10;
                                break;
                            }
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("hair_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime2, 0);
                        i5 = i10;
                        break;
                    case 5:
                        bArr2 = new byte[a.this.uu * a.this.uv];
                        int i11 = a.this.uu;
                        i6 = a.this.uv;
                        i7 = a.this.eM();
                        long elapsedRealtime3 = SystemClock.elapsedRealtime();
                        if (!a.this.nJ) {
                            ARMdlInterfaceJNI.predictSkySeg(byteBuffer, i, i2, a.this.uu, a.this.uv, 1, i7, false, bArr2, 0L);
                        } else if (a.this.ch != null) {
                            try {
                                long createHandle3 = a.this.ch.createHandle();
                                a.this.ch.setHandleInput(createHandle3, 12, j, 0, i, i2, z, i4, a.this.mK, byteBuffer);
                                a.this.ch.setUsingHandle(createHandle3);
                                ARMdlInterfaceJNI.predictSkySeg(null, i, i2, a.this.uu, a.this.uv, 1, i7, false, null, createHandle3);
                                if (a.this.ch != null) {
                                    a.this.ch.setUsingHandle(0L);
                                    bArr2 = a.this.ch.getHandleMaskData(createHandle3);
                                    hashMap.put("handle", Long.valueOf(createHandle3));
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle3);
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                i5 = i11;
                                break;
                            }
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("sky_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime3, 0);
                        i5 = i11;
                        break;
                }
                hashMap.put("orientation", Integer.valueOf(i7));
                hashMap.put("mask", bArr2);
                hashMap.put("width", Integer.valueOf(i5));
                hashMap.put("height", Integer.valueOf(i6));
                hashMap.put("frontCamera", Boolean.valueOf(a.this.mIsFrontCamera));
                return hashMap;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public void a(com.baidu.ar.b.a.c cVar) {
        super.a(cVar);
        if (cVar != null) {
            this.cS = cVar.at();
            switch (this.cS) {
                case 4:
                    this.mm.setPixelType(PixelType.NV21);
                    this.mm.setOutputWidth(this.uo);
                    this.mm.setOutputHeight(this.up);
                    return;
                case 5:
                    this.mm.setPixelType(PixelType.NV21);
                    this.mm.setOutputWidth(this.us);
                    this.mm.setOutputHeight(this.ut);
                    return;
                default:
                    this.mm.setPixelType(PixelType.BGR);
                    this.mm.setOutputWidth(this.uk);
                    this.mm.setOutputHeight(this.ul);
                    return;
            }
        }
    }

    @Override // com.baidu.ar.b.a.b, com.baidu.ar.c.j
    protected void al() {
        if (this.ly != null) {
            this.ly.a(new l(getName(), true, cL()));
        }
    }

    @Override // com.baidu.ar.b.a.b, com.baidu.ar.c.j
    protected void an() {
        if (this.ly != null) {
            this.ly.b(new l(getName(), true, cL()));
        }
    }

    @Override // com.baidu.ar.b.a.a
    public void ar() {
    }

    @Override // com.baidu.ar.b.a.a
    public void as() {
    }

    @Override // com.baidu.ar.b.a.b
    protected int at() {
        return this.cS;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.a av() {
        return new com.baidu.ar.b.b.a(this.cP.at()) { // from class: com.baidu.ar.seg.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean az() {
                switch (at()) {
                    case 2:
                        ARMdlInterfaceJNI.releaseHumanSeg();
                        return true;
                    case 3:
                    default:
                        return true;
                    case 4:
                        ARMdlInterfaceJNI.releaseHairSeg();
                        return true;
                    case 5:
                        ARMdlInterfaceJNI.releaseSkySeg();
                        return true;
                }
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.c b(Bundle bundle) {
        return new com.baidu.ar.b.b.c(this.cP.at()) { // from class: com.baidu.ar.seg.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.se[0];
                switch (at()) {
                    case 2:
                        int[] iArr = new int[2];
                        return aVar.sd ? ARMdlInterfaceJNI.initHumanSegFromAssetDir(str, 1, iArr) : ARMdlInterfaceJNI.initHumanSeg(str, 1, iArr);
                    case 3:
                    default:
                        return -1;
                    case 4:
                        return aVar.sd ? ARMdlInterfaceJNI.initHairSegFromAssetDir(str) : ARMdlInterfaceJNI.initHairSeg(str);
                    case 5:
                        return aVar.sd ? ARMdlInterfaceJNI.initSkySegFromAssetDir(str) : ARMdlInterfaceJNI.initSkySeg(str);
                }
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public void e(HashMap hashMap) {
        String str;
        byte[] bArr = (byte[]) hashMap.get("mask");
        int intValue = ((Integer) hashMap.get("width")).intValue();
        int intValue2 = ((Integer) hashMap.get("height")).intValue();
        int intValue3 = ((Integer) hashMap.get("orientation")).intValue();
        c cVar = new c(getName(), new b(bArr, intValue, intValue2, intValue3, ((Boolean) hashMap.get("frontCamera")).booleanValue()), ((Long) hashMap.get("timestamp")).longValue(), hashMap.get("handle") != null ? ((Long) hashMap.get("handle")).longValue() : 0L);
        if (intValue > 0 && intValue2 > 0 && bArr != null && bArr.length > 0) {
            switch (this.cS) {
                case 4:
                    str = "ability_hair_segmentation";
                    break;
                case 5:
                    str = "ability_sky_segmentation";
                    break;
                default:
                    str = "ability_image_segmentation";
                    break;
            }
            if (intValue3 == 0 || intValue3 == 180 || intValue3 == 2) {
                intValue = intValue2;
                intValue2 = intValue;
            }
            m mVar = new m();
            mVar.o(str);
            mVar.setWidth(intValue);
            mVar.setHeight(intValue2);
            mVar.a(bArr);
            cVar.a(mVar);
        }
        if (this.ly != null) {
            this.ly.a(cVar);
        }
    }

    public void g(float f) {
        this.pH = f;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
