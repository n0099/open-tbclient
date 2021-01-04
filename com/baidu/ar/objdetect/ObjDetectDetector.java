package com.baidu.ar.objdetect;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes6.dex */
public class ObjDetectDetector extends com.baidu.ar.b.a.a {
    private static final String TAG = ObjDetectDetector.class.getSimpleName();
    private int oU = 6;

    public ObjDetectDetector() {
        c.cd().a(this);
        this.nk = new PixelReadParams(PixelType.BGR);
        this.nk.setOutputWidth(640);
        this.nk.setOutputHeight(EncoderTextureDrawer.X264_WIDTH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i, boolean z) {
        switch (i) {
            case -90:
                return z ? 2 : 0;
            case 90:
                return !z ? 2 : 0;
            case 180:
                return z ? 1 : 3;
            default:
                return z ? 3 : 1;
        }
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        return new b(this.oU) { // from class: com.baidu.ar.objdetect.ObjDetectDetector.1
            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.tw;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                return aVar.f1486tv ? ARMdlInterfaceJNI.initObjDetectFromAsset(strArr[0], strArr[1]) : ARMdlInterfaceJNI.initObjDetect(strArr[0], strArr[1]);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return MapBundleKey.MapObjKey.OBJ_SL_OBJ;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        super.aq();
        c.cd().b(this);
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        return new com.baidu.ar.b.b.a(this.oU) { // from class: com.baidu.ar.objdetect.ObjDetectDetector.2
            @Override // com.baidu.ar.b.b.a
            public int ax() {
                return ARMdlInterfaceJNI.releaseObjDetect();
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return MapBundleKey.MapObjKey.OBJ_SL_OBJ;
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    protected int au() {
        return this.oU;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oU, framePixels) { // from class: com.baidu.ar.objdetect.ObjDetectDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return MapBundleKey.MapObjKey.OBJ_SL_OBJ;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: i */
            public a e(FramePixels framePixels2) {
                int d = ObjDetectDetector.this.d(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera());
                long timestamp = framePixels2.getTimestamp();
                float[] fArr = new float[36];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictObjDetect(framePixels2.getPixelsAddress(), framePixels2.getWidth(), framePixels2.getHeight(), d, framePixels2.isFrontCamera(), fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("obj_detect", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                return new a(ObjDetectDetector.this.getName(), fArr, timestamp);
            }
        };
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return TAG;
    }

    @CallBack
    public void onMdlResult(a aVar) {
        if (this.mv != null) {
            this.mv.a(aVar);
        }
    }
}
