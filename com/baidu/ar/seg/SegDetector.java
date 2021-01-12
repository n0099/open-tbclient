package com.baidu.ar.seg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.arrender.o;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class SegDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = SegDetector.class.getSimpleName();
    protected boolean mIsFrontCamera;
    private int oU;
    protected int vO;
    private int vC = 192;
    private int vD = 192;
    private int vE = 192;
    private int vF = 192;
    private int vG = 256;
    private int vH = 144;
    private int vI = 128;
    private int vJ = 224;
    private int vK = 192;
    private int vL = 192;
    private int vM = 160;
    private int vN = 160;
    private float qD = 0.0f;
    private boolean oz = true;
    private boolean oK = true;

    public SegDetector(int i) {
        this.oU = 2;
        c.cd().a(this);
        this.oU = i;
        this.nk = new PixelReadParams(PixelType.BGR);
        fY();
    }

    private int dk() {
        switch (this.oU) {
            case 4:
                return 13;
            case 5:
                return 12;
            default:
                return 11;
        }
    }

    private void fY() {
        switch (this.oU) {
            case 4:
                this.nk.setPixelType(PixelType.NV21);
                this.nk.setOutputWidth(this.vG);
                this.nk.setOutputHeight(this.vH);
                return;
            case 5:
                this.nk.setPixelType(PixelType.NV21);
                this.nk.setOutputWidth(this.vK);
                this.nk.setOutputHeight(this.vL);
                return;
            default:
                this.nk.setPixelType(PixelType.BGR);
                this.nk.setOutputWidth(this.vC);
                this.nk.setOutputHeight(this.vD);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fZ() {
        switch (this.vO) {
            case -90:
                return 0;
            case 90:
                return 2;
            case 180:
                return !this.mIsFrontCamera ? 3 : 1;
            default:
                return this.mIsFrontCamera ? 3 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ga() {
        switch (this.vO) {
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
    public int gb() {
        int i = SubsamplingScaleImageView.ORIENTATION_270;
        switch (this.vO) {
            case -90:
                return 0;
            case 90:
                return 180;
            case 180:
                if (this.mIsFrontCamera) {
                    return 90;
                }
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                if (!this.mIsFrontCamera) {
                    i = 90;
                }
                return i;
        }
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.b a(Bundle bundle) {
        return new com.baidu.ar.b.b.b(this.oU) { // from class: com.baidu.ar.seg.SegDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.tw[0];
                switch (SegDetector.this.oU) {
                    case 2:
                        int[] iArr = new int[2];
                        return aVar.f1493tv ? ARMdlInterfaceJNI.initHumanSegFromAssetDir(str, 1, iArr) : ARMdlInterfaceJNI.initHumanSeg(str, 1, iArr);
                    case 3:
                    default:
                        return -1;
                    case 4:
                        return aVar.f1493tv ? ARMdlInterfaceJNI.initHairSegFromAssetDir(str) : ARMdlInterfaceJNI.initHairSeg(str);
                    case 5:
                        return aVar.f1493tv ? ARMdlInterfaceJNI.initSkySegFromAssetDir(str) : ARMdlInterfaceJNI.initSkySeg(str);
                }
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "seg";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    protected void ao() {
        if (this.mv != null) {
            this.mv.a(new l(getName(), true, dk()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        if (this.mv != null) {
            this.mv.b(new l(getName(), true, dk()));
        }
        c.cd().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.seg.SegDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                switch (SegDetector.this.oU) {
                    case 2:
                        ARMdlInterfaceJNI.releaseHumanSeg();
                        return 0;
                    case 3:
                    default:
                        return 0;
                    case 4:
                        ARMdlInterfaceJNI.releaseHairSeg();
                        return 0;
                    case 5:
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
    protected int au() {
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
            @Override // com.baidu.ar.b.b.c
            /* renamed from: k */
            public b e(FramePixels framePixels2) {
                int i;
                int i2;
                int i3;
                byte[] bArr;
                byte[] bArr2;
                b bVar = new b();
                ByteBuffer pixelsAddress = framePixels2.getPixelsAddress();
                int width = framePixels2.getWidth();
                int height = framePixels2.getHeight();
                long timestamp = framePixels2.getTimestamp();
                boolean isFrontCamera = framePixels2.isFrontCamera();
                int degree = framePixels2.getOrientation().getDegree();
                int value = framePixels2.getSegOrientation().getValue();
                bVar.setTimestamp(timestamp);
                SegDetector.this.mIsFrontCamera = isFrontCamera;
                SegDetector.this.vO = degree;
                switch (SegDetector.this.oU) {
                    case 2:
                        int[] iArr = new int[2];
                        byte[] bArr3 = new byte[SegDetector.this.vE * SegDetector.this.vF];
                        int i4 = SegDetector.this.vE;
                        int i5 = SegDetector.this.vF;
                        i = SegDetector.this.fZ();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!SegDetector.this.oK) {
                            ARMdlInterfaceJNI.predictHumanSeg(pixelsAddress, width, height, i, isFrontCamera, bArr3, iArr, 0L);
                            bArr2 = bArr3;
                        } else if (SegDetector.this.cb != null) {
                            try {
                                long createHandle = SegDetector.this.cb.createHandle();
                                SegDetector.this.cb.setHandleInput(createHandle, 11, timestamp, 2, width, height, isFrontCamera, value, SegDetector.this.oz, pixelsAddress);
                                SegDetector.this.cb.setUsingHandle(createHandle);
                                ARMdlInterfaceJNI.predictHumanSeg(null, width, height, i, isFrontCamera, null, iArr, createHandle);
                                if (SegDetector.this.cb != null) {
                                    SegDetector.this.cb.setUsingHandle(0L);
                                    ReserveHandleData reserveHandleData = new ReserveHandleData();
                                    SegDetector.this.cb.getHandleReserveData(createHandle, reserveHandleData);
                                    if (reserveHandleData.getByteArrayListData() != null && reserveHandleData.getByteArrayListData().size() > 0) {
                                        bArr3 = reserveHandleData.getByteArrayListData().get(0);
                                    }
                                    bVar.n(createHandle);
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle);
                                }
                                bArr2 = bArr3;
                            } catch (Exception e) {
                                e.printStackTrace();
                                i2 = i5;
                                i3 = i4;
                                bArr = bArr3;
                                break;
                            }
                        } else {
                            bArr2 = bArr3;
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("bg_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                        i2 = i5;
                        i3 = i4;
                        bArr = bArr2;
                        break;
                    case 3:
                    default:
                        i = degree;
                        i2 = 0;
                        i3 = 0;
                        bArr = null;
                        break;
                    case 4:
                        byte[] bArr4 = new byte[SegDetector.this.vI * SegDetector.this.vJ];
                        int i6 = SegDetector.this.vI;
                        int i7 = SegDetector.this.vJ;
                        int gb = SegDetector.this.gb();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        if (!SegDetector.this.oK) {
                            ARMdlInterfaceJNI.predictHairSeg(pixelsAddress, width, height, SegDetector.this.vI, SegDetector.this.vJ, 1, gb, false, bArr4, 0L);
                        } else if (SegDetector.this.cb != null) {
                            try {
                                long createHandle2 = SegDetector.this.cb.createHandle();
                                SegDetector.this.cb.setHandleInput(createHandle2, 13, timestamp, 0, width, height, isFrontCamera, value, SegDetector.this.oz, pixelsAddress);
                                SegDetector.this.cb.setUsingHandle(createHandle2);
                                SegDetector.this.cb.setHandleMaskThreshold(createHandle2, SegDetector.this.qD);
                                ARMdlInterfaceJNI.predictHairSeg(null, width, height, SegDetector.this.vI, SegDetector.this.vJ, 1, gb, false, null, createHandle2);
                                if (SegDetector.this.cb != null) {
                                    SegDetector.this.cb.setUsingHandle(0L);
                                    bArr4 = SegDetector.this.cb.getHandleMaskData(createHandle2);
                                    bVar.n(createHandle2);
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle2);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                i = gb;
                                i2 = i7;
                                i3 = i6;
                                bArr = bArr4;
                                break;
                            }
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("hair_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime2, 0);
                        i = gb;
                        i2 = i7;
                        i3 = i6;
                        bArr = bArr4;
                        break;
                    case 5:
                        byte[] bArr5 = new byte[SegDetector.this.vM * SegDetector.this.vN];
                        int i8 = SegDetector.this.vM;
                        int i9 = SegDetector.this.vN;
                        int ga = SegDetector.this.ga();
                        long elapsedRealtime3 = SystemClock.elapsedRealtime();
                        if (!SegDetector.this.oK) {
                            ARMdlInterfaceJNI.predictSkySeg(pixelsAddress, width, height, SegDetector.this.vM, SegDetector.this.vN, 1, ga, false, bArr5, 0L);
                        } else if (SegDetector.this.cb != null) {
                            try {
                                long createHandle3 = SegDetector.this.cb.createHandle();
                                SegDetector.this.cb.setHandleInput(createHandle3, 12, timestamp, 0, width, height, isFrontCamera, value, SegDetector.this.oz, pixelsAddress);
                                SegDetector.this.cb.setUsingHandle(createHandle3);
                                ARMdlInterfaceJNI.predictSkySeg(null, width, height, SegDetector.this.vM, SegDetector.this.vN, 1, ga, false, null, createHandle3);
                                if (SegDetector.this.cb != null) {
                                    SegDetector.this.cb.setUsingHandle(0L);
                                    bArr5 = SegDetector.this.cb.getHandleMaskData(createHandle3);
                                    bVar.n(createHandle3);
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle3);
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                i = ga;
                                i2 = i9;
                                i3 = i8;
                                bArr = bArr5;
                                break;
                            }
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("sky_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime3, 0);
                        i = ga;
                        i2 = i9;
                        i3 = i8;
                        bArr = bArr5;
                        break;
                }
                bVar.b(new a(bArr, i3, i2, i, framePixels2.isFrontCamera()));
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
        String str;
        int i;
        int i2;
        int width = bVar.gd().getWidth();
        int height = bVar.gd().getHeight();
        byte[] gc = bVar.gd().gc();
        int orientation = bVar.gd().getOrientation();
        if (width > 0 && height > 0 && gc != null && gc.length > 0) {
            switch (this.oU) {
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
            if (orientation == 0 || orientation == 180 || orientation == 2) {
                i = width;
                i2 = height;
            } else {
                i = height;
                i2 = width;
            }
            o oVar = new o();
            oVar.r(str);
            oVar.setWidth(i2);
            oVar.setHeight(i);
            oVar.a(gc);
            bVar.g(oVar);
        }
        if (this.mv != null) {
            this.mv.a(bVar);
        }
    }

    public void y(boolean z) {
        this.oz = z;
    }
}
