package com.baidu.ar.seg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.arrender.o;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.f;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class SegDetector extends com.baidu.ar.b.a.a {
    public static final String TAG = "SegDetector";
    public boolean mIsFrontCamera;
    public int oU;
    public int vO;
    public int vC = 192;
    public int vD = 192;
    public int vE = 192;
    public int vF = 192;
    public int vG = 256;
    public int vH = Cea708Decoder.COMMAND_SPA;
    public int vI = 128;
    public int vJ = 224;
    public int vK = 192;
    public int vL = 192;
    public int vM = 160;
    public int vN = 160;
    public float qD = 0.0f;
    public boolean oz = true;
    public boolean oK = true;

    public SegDetector(int i) {
        this.oU = 2;
        c.cd().a(this);
        this.oU = i;
        this.nk = new PixelReadParams(PixelType.BGR);
        fY();
    }

    private int dk() {
        int i = this.oU;
        if (i != 4) {
            return i != 5 ? 11 : 12;
        }
        return 13;
    }

    private void fY() {
        PixelReadParams pixelReadParams;
        int i;
        int i2 = this.oU;
        if (i2 == 4) {
            this.nk.setPixelType(PixelType.NV21);
            this.nk.setOutputWidth(this.vG);
            pixelReadParams = this.nk;
            i = this.vH;
        } else if (i2 != 5) {
            this.nk.setPixelType(PixelType.BGR);
            this.nk.setOutputWidth(this.vC);
            pixelReadParams = this.nk;
            i = this.vD;
        } else {
            this.nk.setPixelType(PixelType.NV21);
            this.nk.setOutputWidth(this.vK);
            pixelReadParams = this.nk;
            i = this.vL;
        }
        pixelReadParams.setOutputHeight(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fZ() {
        int i = this.vO;
        if (i != -90) {
            if (i != 90) {
                if (i != 180) {
                    if (this.mIsFrontCamera) {
                        return 3;
                    }
                } else if (!this.mIsFrontCamera) {
                    return 3;
                }
                return 1;
            }
            return 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ga() {
        int i = this.vO;
        if (i != -90) {
            if (i != 90) {
                if (i != 180) {
                    if (this.mIsFrontCamera) {
                        return 3;
                    }
                } else if (!this.mIsFrontCamera) {
                    return 3;
                }
                return 1;
            } else if (!this.mIsFrontCamera) {
                return 2;
            }
        } else if (this.mIsFrontCamera) {
            return 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gb() {
        int i = this.vO;
        if (i != -90) {
            if (i != 90) {
                return (i == 180 ? !this.mIsFrontCamera : this.mIsFrontCamera) ? 270 : 90;
            }
            return 180;
        }
        return 0;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.b a(Bundle bundle) {
        return new com.baidu.ar.b.b.b(this.oU) { // from class: com.baidu.ar.seg.SegDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.tw[0];
                int i = SegDetector.this.oU;
                if (i == 2) {
                    int[] iArr = new int[2];
                    return aVar.f1031tv ? ARMdlInterfaceJNI.initHumanSegFromAssetDir(str, 1, iArr) : ARMdlInterfaceJNI.initHumanSeg(str, 1, iArr);
                } else if (i == 4) {
                    return aVar.f1031tv ? ARMdlInterfaceJNI.initHairSegFromAssetDir(str) : ARMdlInterfaceJNI.initHairSeg(str);
                } else if (i != 5) {
                    return -1;
                } else {
                    return aVar.f1031tv ? ARMdlInterfaceJNI.initSkySegFromAssetDir(str) : ARMdlInterfaceJNI.initSkySeg(str);
                }
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "seg";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(new l(getName(), true, dk()));
        }
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.b(new l(getName(), true, dk()));
        }
        c.cd().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.seg.SegDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                int i = SegDetector.this.oU;
                if (i == 2) {
                    ARMdlInterfaceJNI.releaseHumanSeg();
                    return 0;
                } else if (i == 4) {
                    ARMdlInterfaceJNI.releaseHairSeg();
                    return 0;
                } else if (i != 5) {
                    return 0;
                } else {
                    ARMdlInterfaceJNI.releaseSkySeg();
                    return 0;
                }
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "seg";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
        return this.oU;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oU, framePixels) { // from class: com.baidu.ar.seg.SegDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "seg";
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Not initialized variable reg: 10, insn: 0x0203: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:35:0x0202 */
            /* JADX WARN: Not initialized variable reg: 23, insn: 0x020e: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY]), block:B:40:0x020d */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: k */
            public b e(FramePixels framePixels2) {
                byte[] bArr;
                Exception exc;
                byte[] bArr2;
                byte[] bArr3;
                byte[] bArr4;
                int i;
                int i2;
                int i3;
                Exception exc2;
                byte[] bArr5;
                byte[] bArr6;
                byte[] bArr7;
                int i4;
                int i5;
                int gb;
                byte[] bArr8;
                byte[] bArr9;
                f performanceApi;
                long elapsedRealtime;
                int i6;
                String str;
                byte[] bArr10;
                byte[] bArr11;
                b bVar = new b();
                ByteBuffer pixelsAddress = framePixels2.getPixelsAddress();
                int width = framePixels2.getWidth();
                int height = framePixels2.getHeight();
                long timestamp = framePixels2.getTimestamp();
                boolean isFrontCamera = framePixels2.isFrontCamera();
                int degree = framePixels2.getOrientation().getDegree();
                int value = framePixels2.getSegOrientation().getValue();
                bVar.setTimestamp(timestamp);
                SegDetector segDetector = SegDetector.this;
                segDetector.mIsFrontCamera = isFrontCamera;
                segDetector.vO = degree;
                int i7 = segDetector.oU;
                if (i7 != 2) {
                    try {
                        try {
                            if (i7 == 4) {
                                byte[] bArr12 = new byte[SegDetector.this.vI * SegDetector.this.vJ];
                                i4 = SegDetector.this.vI;
                                i5 = SegDetector.this.vJ;
                                gb = SegDetector.this.gb();
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (SegDetector.this.oK) {
                                    bArr8 = bArr12;
                                    if (SegDetector.this.cb != null) {
                                        long createHandle = SegDetector.this.cb.createHandle();
                                        SegDetector.this.cb.setHandleInput(createHandle, 13, timestamp, 0, width, height, isFrontCamera, value, SegDetector.this.oz, pixelsAddress);
                                        SegDetector.this.cb.setUsingHandle(createHandle);
                                        SegDetector.this.cb.setHandleMaskThreshold(createHandle, SegDetector.this.qD);
                                        ARMdlInterfaceJNI.predictHairSeg(null, width, height, SegDetector.this.vI, SegDetector.this.vJ, 1, gb, false, null, createHandle);
                                        if (SegDetector.this.cb != null) {
                                            SegDetector.this.cb.setUsingHandle(0L);
                                            bArr9 = SegDetector.this.cb.getHandleMaskData(createHandle);
                                            bVar.n(createHandle);
                                        } else {
                                            AlgoHandleAdapter.destroyHandle(createHandle);
                                            bArr9 = bArr8;
                                        }
                                        bArr6 = bArr9;
                                        performanceApi = StatisticApi.getPerformanceApi();
                                        elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                        i6 = 0;
                                        str = "hair_seg";
                                    }
                                } else {
                                    bArr8 = bArr12;
                                    ARMdlInterfaceJNI.predictHairSeg(pixelsAddress, width, height, SegDetector.this.vI, SegDetector.this.vJ, 1, gb, false, bArr8, 0L);
                                }
                                bArr6 = bArr8;
                                performanceApi = StatisticApi.getPerformanceApi();
                                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                i6 = 0;
                                str = "hair_seg";
                            } else if (i7 != 5) {
                                bArr4 = null;
                                i3 = degree;
                                i = 0;
                                i2 = 0;
                            } else {
                                byte[] bArr13 = new byte[SegDetector.this.vM * SegDetector.this.vN];
                                i4 = SegDetector.this.vM;
                                i5 = SegDetector.this.vN;
                                gb = SegDetector.this.ga();
                                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                if (SegDetector.this.oK) {
                                    bArr10 = bArr13;
                                    if (SegDetector.this.cb != null) {
                                        long createHandle2 = SegDetector.this.cb.createHandle();
                                        SegDetector.this.cb.setHandleInput(createHandle2, 12, timestamp, 0, width, height, isFrontCamera, value, SegDetector.this.oz, pixelsAddress);
                                        SegDetector.this.cb.setUsingHandle(createHandle2);
                                        ARMdlInterfaceJNI.predictSkySeg(null, width, height, SegDetector.this.vM, SegDetector.this.vN, 1, gb, false, null, createHandle2);
                                        if (SegDetector.this.cb != null) {
                                            SegDetector.this.cb.setUsingHandle(0L);
                                            bArr11 = SegDetector.this.cb.getHandleMaskData(createHandle2);
                                            bVar.n(createHandle2);
                                        } else {
                                            AlgoHandleAdapter.destroyHandle(createHandle2);
                                            bArr11 = bArr10;
                                        }
                                        bArr6 = bArr11;
                                        performanceApi = StatisticApi.getPerformanceApi();
                                        elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime3;
                                        i6 = 0;
                                        str = "sky_seg";
                                    }
                                } else {
                                    bArr10 = bArr13;
                                    ARMdlInterfaceJNI.predictSkySeg(pixelsAddress, width, height, SegDetector.this.vM, SegDetector.this.vN, 1, gb, false, bArr10, 0L);
                                }
                                bArr6 = bArr10;
                                performanceApi = StatisticApi.getPerformanceApi();
                                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime3;
                                i6 = 0;
                                str = "sky_seg";
                            }
                            performanceApi.recordAlgoTimeCost(str, "predict", elapsedRealtime, i6);
                        } catch (Exception e) {
                            exc2 = e;
                            bArr6 = bArr7;
                            exc2.printStackTrace();
                            bArr4 = bArr6;
                            i = i4;
                            i2 = i5;
                            i3 = gb;
                            bVar.b(new a(bArr4, i, i2, i3, framePixels2.isFrontCamera()));
                            bVar.W(SegDetector.this.getName());
                            return bVar;
                        }
                    } catch (Exception e2) {
                        exc2 = e2;
                        bArr6 = bArr5;
                        exc2.printStackTrace();
                        bArr4 = bArr6;
                        i = i4;
                        i2 = i5;
                        i3 = gb;
                        bVar.b(new a(bArr4, i, i2, i3, framePixels2.isFrontCamera()));
                        bVar.W(SegDetector.this.getName());
                        return bVar;
                    }
                    bArr4 = bArr6;
                    i = i4;
                    i2 = i5;
                    i3 = gb;
                } else {
                    int[] iArr = new int[2];
                    byte[] bArr14 = new byte[SegDetector.this.vE * SegDetector.this.vF];
                    int i8 = SegDetector.this.vE;
                    int i9 = SegDetector.this.vF;
                    int fZ = SegDetector.this.fZ();
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    if (SegDetector.this.oK) {
                        bArr = bArr14;
                        if (SegDetector.this.cb != null) {
                            try {
                                long createHandle3 = SegDetector.this.cb.createHandle();
                                SegDetector.this.cb.setHandleInput(createHandle3, 11, timestamp, 2, width, height, isFrontCamera, value, SegDetector.this.oz, pixelsAddress);
                                SegDetector.this.cb.setUsingHandle(createHandle3);
                                ARMdlInterfaceJNI.predictHumanSeg(null, width, height, fZ, isFrontCamera, null, iArr, createHandle3);
                                if (SegDetector.this.cb != null) {
                                    SegDetector.this.cb.setUsingHandle(0L);
                                    ReserveHandleData reserveHandleData = new ReserveHandleData();
                                    SegDetector.this.cb.getHandleReserveData(createHandle3, reserveHandleData);
                                    bArr3 = (reserveHandleData.getByteArrayListData() == null || reserveHandleData.getByteArrayListData().size() <= 0) ? bArr : reserveHandleData.getByteArrayListData().get(0);
                                    try {
                                        bVar.n(createHandle3);
                                    } catch (Exception e3) {
                                        exc = e3;
                                        bArr2 = bArr3;
                                        exc.printStackTrace();
                                        bArr4 = bArr2;
                                        i = i8;
                                        i2 = i9;
                                        i3 = fZ;
                                        bVar.b(new a(bArr4, i, i2, i3, framePixels2.isFrontCamera()));
                                        bVar.W(SegDetector.this.getName());
                                        return bVar;
                                    }
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle3);
                                    bArr3 = bArr;
                                }
                                bArr2 = bArr3;
                                StatisticApi.getPerformanceApi().recordAlgoTimeCost("bg_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime4, 0);
                            } catch (Exception e4) {
                                exc = e4;
                                bArr2 = bArr;
                            }
                            bArr4 = bArr2;
                            i = i8;
                            i2 = i9;
                            i3 = fZ;
                        }
                    } else {
                        bArr = bArr14;
                        ARMdlInterfaceJNI.predictHumanSeg(pixelsAddress, width, height, fZ, isFrontCamera, bArr, iArr, 0L);
                    }
                    bArr2 = bArr;
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("bg_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime4, 0);
                    bArr4 = bArr2;
                    i = i8;
                    i2 = i9;
                    i3 = fZ;
                }
                bVar.b(new a(bArr4, i, i2, i3, framePixels2.isFrontCamera()));
                bVar.W(SegDetector.this.getName());
                return bVar;
            }
        };
    }

    public void f(float f) {
        this.qD = f;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return TAG;
    }

    @CallBack
    public void onMdlResult(b bVar) {
        int width = bVar.gd().getWidth();
        int height = bVar.gd().getHeight();
        byte[] gc = bVar.gd().gc();
        int orientation = bVar.gd().getOrientation();
        if (width > 0 && height > 0 && gc != null && gc.length > 0) {
            int i = this.oU;
            String str = i != 4 ? i != 5 ? "ability_image_segmentation" : "ability_sky_segmentation" : "ability_hair_segmentation";
            if (orientation == 0 || orientation == 180 || orientation == 2) {
                height = width;
                width = height;
            }
            o oVar = new o();
            oVar.r(str);
            oVar.setWidth(width);
            oVar.setHeight(height);
            oVar.a(gc);
            bVar.g(oVar);
        }
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(bVar);
        }
    }

    public void y(boolean z) {
        this.oz = z;
    }
}
