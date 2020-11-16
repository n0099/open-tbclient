package com.baidu.ar.seg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.arrender.n;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public class SegDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = SegDetector.class.getSimpleName();
    protected boolean mIsFrontCamera;
    private int oE;
    protected int va;
    private int uO = 192;
    private int uP = 192;
    private int uQ = 192;
    private int uR = 192;
    private int uS = 256;
    private int uT = 144;
    private int uU = 128;
    private int uV = 224;
    private int uW = 192;
    private int uX = 192;
    private int uY = 160;
    private int uZ = 160;
    private float qn = 0.0f;
    private boolean oj = true;
    private boolean ou = true;

    public SegDetector(int i) {
        this.oE = 2;
        c.ce().a(this);
        this.oE = i;
        this.mU = new PixelReadParams(PixelType.BGR);
        fX();
    }

    private int dl() {
        switch (this.oE) {
            case 4:
                return 13;
            case 5:
                return 12;
            default:
                return 11;
        }
    }

    private void fX() {
        switch (this.oE) {
            case 4:
                this.mU.setPixelType(PixelType.NV21);
                this.mU.setOutputWidth(this.uS);
                this.mU.setOutputHeight(this.uT);
                return;
            case 5:
                this.mU.setPixelType(PixelType.NV21);
                this.mU.setOutputWidth(this.uW);
                this.mU.setOutputHeight(this.uX);
                return;
            default:
                this.mU.setPixelType(PixelType.BGR);
                this.mU.setOutputWidth(this.uO);
                this.mU.setOutputHeight(this.uP);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fY() {
        switch (this.va) {
            case -90:
                return 0;
            case 0:
                return !this.mIsFrontCamera ? 1 : 3;
            case 90:
                return 2;
            case 180:
                return this.mIsFrontCamera ? 1 : 3;
            default:
                return this.mIsFrontCamera ? 3 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fZ() {
        switch (this.va) {
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
    public int ga() {
        switch (this.va) {
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
        switch (this.va) {
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

    public void A(boolean z) {
        this.oj = z;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.b a(Bundle bundle) {
        return new com.baidu.ar.b.b.b(this.oE) { // from class: com.baidu.ar.seg.SegDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String str = aVar.sJ[0];
                switch (SegDetector.this.oE) {
                    case 2:
                        int[] iArr = new int[2];
                        return aVar.sI ? ARMdlInterfaceJNI.initHumanSegFromAssetDir(str, 1, iArr) : ARMdlInterfaceJNI.initHumanSeg(str, 1, iArr);
                    case 3:
                    default:
                        return -1;
                    case 4:
                        return aVar.sI ? ARMdlInterfaceJNI.initHairSegFromAssetDir(str) : ARMdlInterfaceJNI.initHairSeg(str);
                    case 5:
                        return aVar.sI ? ARMdlInterfaceJNI.initSkySegFromAssetDir(str) : ARMdlInterfaceJNI.initSkySeg(str);
                }
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "seg";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    protected void am() {
        if (this.mg != null) {
            this.mg.a(new l(getName(), true, dl()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        if (this.mg != null) {
            this.mg.b(new l(getName(), true, dl()));
        }
        c.ce().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a as() {
        return new com.baidu.ar.b.b.a(this.oE) { // from class: com.baidu.ar.seg.SegDetector.2
            @Override // com.baidu.ar.b.b.a
            public int aw() {
                switch (SegDetector.this.oE) {
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
    protected int at() {
        return this.oE;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c e(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oE, framePixels) { // from class: com.baidu.ar.seg.SegDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "seg";
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: l */
            public b f(FramePixels framePixels2) {
                int i;
                int i2;
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
                SegDetector.this.va = degree;
                switch (SegDetector.this.oE) {
                    case 2:
                        int[] iArr = new int[2];
                        byte[] bArr3 = new byte[SegDetector.this.uQ * SegDetector.this.uR];
                        int i3 = SegDetector.this.uQ;
                        int i4 = SegDetector.this.uR;
                        int fY = SegDetector.this.fY();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!SegDetector.this.ou) {
                            ARMdlInterfaceJNI.predictHumanSeg(pixelsAddress, width, height, fY, isFrontCamera, bArr3, iArr, 0L);
                            bArr2 = bArr3;
                        } else if (SegDetector.this.bY != null) {
                            try {
                                long createHandle = SegDetector.this.bY.createHandle();
                                SegDetector.this.bY.setHandleInput(createHandle, 11, timestamp, 2, width, height, isFrontCamera, value, SegDetector.this.oj, pixelsAddress);
                                SegDetector.this.bY.setUsingHandle(createHandle);
                                ARMdlInterfaceJNI.predictHumanSeg(null, width, height, fY, isFrontCamera, null, iArr, createHandle);
                                if (SegDetector.this.bY != null) {
                                    SegDetector.this.bY.setUsingHandle(0L);
                                    ReserveHandleData reserveHandleData = new ReserveHandleData();
                                    SegDetector.this.bY.getHandleReserveData(createHandle, reserveHandleData);
                                    if (reserveHandleData.getByteArrayListData() != null && reserveHandleData.getByteArrayListData().size() > 0) {
                                        bArr3 = reserveHandleData.getByteArrayListData().get(0);
                                    }
                                    bVar.p(createHandle);
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle);
                                }
                                bArr2 = bArr3;
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = i4;
                                i2 = i3;
                                bArr = bArr3;
                                break;
                            }
                        } else {
                            bArr2 = bArr3;
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("bg_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                        i = i4;
                        i2 = i3;
                        bArr = bArr2;
                        break;
                    case 3:
                    default:
                        i = 0;
                        i2 = 0;
                        bArr = null;
                        break;
                    case 4:
                        byte[] bArr4 = new byte[SegDetector.this.uU * SegDetector.this.uV];
                        int i5 = SegDetector.this.uU;
                        int i6 = SegDetector.this.uV;
                        int gb = SegDetector.this.gb();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        if (!SegDetector.this.ou) {
                            ARMdlInterfaceJNI.predictHairSeg(pixelsAddress, width, height, SegDetector.this.uU, SegDetector.this.uV, 1, gb, false, bArr4, 0L);
                        } else if (SegDetector.this.bY != null) {
                            try {
                                long createHandle2 = SegDetector.this.bY.createHandle();
                                SegDetector.this.bY.setHandleInput(createHandle2, 13, timestamp, 0, width, height, isFrontCamera, value, SegDetector.this.oj, pixelsAddress);
                                SegDetector.this.bY.setUsingHandle(createHandle2);
                                SegDetector.this.bY.setHandleMaskThreshold(createHandle2, SegDetector.this.qn);
                                ARMdlInterfaceJNI.predictHairSeg(null, width, height, SegDetector.this.uU, SegDetector.this.uV, 1, gb, false, null, createHandle2);
                                if (SegDetector.this.bY != null) {
                                    SegDetector.this.bY.setUsingHandle(0L);
                                    bArr4 = SegDetector.this.bY.getHandleMaskData(createHandle2);
                                    bVar.p(createHandle2);
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle2);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                i = i6;
                                i2 = i5;
                                bArr = bArr4;
                                break;
                            }
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("hair_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime2, 0);
                        i = i6;
                        i2 = i5;
                        bArr = bArr4;
                        break;
                    case 5:
                        byte[] bArr5 = new byte[SegDetector.this.uY * SegDetector.this.uZ];
                        int i7 = SegDetector.this.uY;
                        int i8 = SegDetector.this.uZ;
                        int ga = SegDetector.this.ga();
                        long elapsedRealtime3 = SystemClock.elapsedRealtime();
                        if (!SegDetector.this.ou) {
                            ARMdlInterfaceJNI.predictSkySeg(pixelsAddress, width, height, SegDetector.this.uY, SegDetector.this.uZ, 1, ga, false, bArr5, 0L);
                        } else if (SegDetector.this.bY != null) {
                            try {
                                long createHandle3 = SegDetector.this.bY.createHandle();
                                SegDetector.this.bY.setHandleInput(createHandle3, 12, timestamp, 0, width, height, isFrontCamera, value, SegDetector.this.oj, pixelsAddress);
                                SegDetector.this.bY.setUsingHandle(createHandle3);
                                ARMdlInterfaceJNI.predictSkySeg(null, width, height, SegDetector.this.uY, SegDetector.this.uZ, 1, ga, false, null, createHandle3);
                                if (SegDetector.this.bY != null) {
                                    SegDetector.this.bY.setUsingHandle(0L);
                                    bArr5 = SegDetector.this.bY.getHandleMaskData(createHandle3);
                                    bVar.p(createHandle3);
                                } else {
                                    AlgoHandleAdapter.destroyHandle(createHandle3);
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                i = i8;
                                i2 = i7;
                                bArr = bArr5;
                                break;
                            }
                        }
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("sky_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime3, 0);
                        i = i8;
                        i2 = i7;
                        bArr = bArr5;
                        break;
                }
                bVar.b(new a(bArr, i2, i, SegDetector.this.fZ(), framePixels2.isFrontCamera()));
                bVar.T(SegDetector.this.getName());
                return bVar;
            }
        };
    }

    public void g(float f) {
        this.qn = f;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return TAG;
    }

    @CallBack
    public void onMdlResult(b bVar) {
        String str;
        int width = bVar.gd().getWidth();
        int height = bVar.gd().getHeight();
        byte[] gc = bVar.gd().gc();
        int orientation = bVar.gd().getOrientation();
        if (width > 0 && height > 0 && gc != null && gc.length > 0) {
            switch (this.oE) {
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
                width = height;
                height = width;
            }
            n nVar = new n();
            nVar.p(str);
            nVar.setWidth(width);
            nVar.setHeight(height);
            nVar.a(gc);
            bVar.g(nVar);
        }
        if (this.mg != null) {
            this.mg.a(bVar);
        }
    }
}
