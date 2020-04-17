package com.baidu.ar.seg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.arrender.m;
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
    protected int tW;
    private int tK = 192;
    private int tL = 192;
    private int tM = 192;
    private int tN = 192;
    private int tO = 256;
    private int tP = 144;
    private int tQ = 128;
    private int tR = 224;
    private int tS = 192;
    private int tT = 192;
    private int tU = 160;
    private int tV = 160;
    private int cF = 2;
    private float pi = 0.0f;
    private boolean mn = true;
    private boolean nm = true;

    public a() {
        this.lP = new PixelReadParams(PixelType.BGR);
        this.lP.setOutputWidth(this.tK);
        this.lP.setOutputHeight(this.tL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ev() {
        switch (this.tW) {
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
    public int ew() {
        switch (this.tW) {
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
    public int ex() {
        switch (this.tW) {
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

    public void S(boolean z) {
        this.mn = z;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, final int i3, final int i4) {
        return new com.baidu.ar.b.b.b(this.cC.af()) { // from class: com.baidu.ar.seg.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap am() {
                byte[] bArr;
                byte[] bArr2 = null;
                int i5 = 0;
                int i6 = 0;
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                a.this.mIsFrontCamera = z;
                a.this.tW = i3;
                int i7 = i3;
                switch (af()) {
                    case 2:
                        int[] iArr = new int[2];
                        byte[] bArr3 = new byte[a.this.tM * a.this.tN];
                        int i8 = a.this.tM;
                        int i9 = a.this.tN;
                        int ev = a.this.ev();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!a.this.nm) {
                            ARMdlInterfaceJNI.predictHumanSeg(byteBuffer, i, i2, ev, z, bArr3, iArr, 0L);
                            bArr = bArr3;
                        } else if (a.this.bU != null) {
                            try {
                                long createHandle = a.this.bU.createHandle();
                                a.this.bU.setHandleInput(createHandle, 11, j, 2, i, i2, z, i4, a.this.mn, byteBuffer);
                                a.this.bU.setUsingHandle(createHandle);
                                ARMdlInterfaceJNI.predictHumanSeg(null, i, i2, ev, z, null, iArr, createHandle);
                                if (a.this.bU != null) {
                                    a.this.bU.setUsingHandle(0L);
                                    ReserveHandleData reserveHandleData = new ReserveHandleData();
                                    a.this.bU.getHandleReserveData(createHandle, reserveHandleData);
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
                                i7 = ev;
                                i6 = i9;
                                i5 = i8;
                                break;
                            }
                        } else {
                            bArr = bArr3;
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("bg_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                        i7 = ev;
                        i5 = i8;
                        bArr2 = bArr;
                        i6 = i9;
                        break;
                    case 4:
                        bArr2 = new byte[a.this.tQ * a.this.tR];
                        int i10 = a.this.tQ;
                        i6 = a.this.tR;
                        i7 = a.this.ex();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        if (!a.this.nm) {
                            ARMdlInterfaceJNI.predictHairSeg(byteBuffer, i, i2, a.this.tQ, a.this.tR, 1, i7, false, bArr2, 0L);
                        } else if (a.this.bU != null) {
                            try {
                                long createHandle2 = a.this.bU.createHandle();
                                a.this.bU.setHandleInput(createHandle2, 13, j, 0, i, i2, z, i4, a.this.mn, byteBuffer);
                                a.this.bU.setUsingHandle(createHandle2);
                                a.this.bU.setHandleMaskThreshold(createHandle2, a.this.pi);
                                ARMdlInterfaceJNI.predictHairSeg(null, i, i2, a.this.tQ, a.this.tR, 1, i7, false, null, createHandle2);
                                if (a.this.bU != null) {
                                    a.this.bU.setUsingHandle(0L);
                                    bArr2 = a.this.bU.getHandleMaskData(createHandle2);
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
                        bArr2 = new byte[a.this.tU * a.this.tV];
                        int i11 = a.this.tU;
                        i6 = a.this.tV;
                        i7 = a.this.ew();
                        long elapsedRealtime3 = SystemClock.elapsedRealtime();
                        if (!a.this.nm) {
                            ARMdlInterfaceJNI.predictSkySeg(byteBuffer, i, i2, a.this.tU, a.this.tV, 1, i7, false, bArr2, 0L);
                        } else if (a.this.bU != null) {
                            try {
                                long createHandle3 = a.this.bU.createHandle();
                                a.this.bU.setHandleInput(createHandle3, 12, j, 0, i, i2, z, i4, a.this.mn, byteBuffer);
                                a.this.bU.setUsingHandle(createHandle3);
                                ARMdlInterfaceJNI.predictSkySeg(null, i, i2, a.this.tU, a.this.tV, 1, i7, false, null, createHandle3);
                                if (a.this.bU != null) {
                                    a.this.bU.setUsingHandle(0L);
                                    bArr2 = a.this.bU.getHandleMaskData(createHandle3);
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
            this.cF = cVar.af();
            switch (this.cF) {
                case 4:
                    this.lP.setPixelType(PixelType.NV21);
                    this.lP.setOutputWidth(this.tO);
                    this.lP.setOutputHeight(this.tP);
                    return;
                case 5:
                    this.lP.setPixelType(PixelType.NV21);
                    this.lP.setOutputWidth(this.tS);
                    this.lP.setOutputHeight(this.tT);
                    return;
                default:
                    this.lP.setPixelType(PixelType.BGR);
                    this.lP.setOutputWidth(this.tK);
                    this.lP.setOutputHeight(this.tL);
                    return;
            }
        }
    }

    @Override // com.baidu.ar.b.a.a
    public void ad() {
    }

    @Override // com.baidu.ar.b.a.a
    public void ae() {
    }

    @Override // com.baidu.ar.b.a.b
    protected int af() {
        return this.cF;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.a ah() {
        return new com.baidu.ar.b.b.a(this.cC.af()) { // from class: com.baidu.ar.seg.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean al() {
                switch (af()) {
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
        return new com.baidu.ar.b.b.c(this.cC.af()) { // from class: com.baidu.ar.seg.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.rF[0];
                switch (af()) {
                    case 2:
                        int[] iArr = new int[2];
                        return aVar.rE ? ARMdlInterfaceJNI.initHumanSegFromAssetDir(str, 1, iArr) : ARMdlInterfaceJNI.initHumanSeg(str, 1, iArr);
                    case 3:
                    default:
                        return -1;
                    case 4:
                        return aVar.rE ? ARMdlInterfaceJNI.initHairSegFromAssetDir(str) : ARMdlInterfaceJNI.initHairSeg(str);
                    case 5:
                        return aVar.rE ? ARMdlInterfaceJNI.initSkySegFromAssetDir(str) : ARMdlInterfaceJNI.initSkySeg(str);
                }
            }
        };
    }

    public void e(float f) {
        this.pi = f;
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
            switch (this.cF) {
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
        if (this.lb != null) {
            this.lb.a(cVar);
        }
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
