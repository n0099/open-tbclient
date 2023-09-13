package com.baidu.ar.objdetect;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.e;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
/* loaded from: classes.dex */
public class ObjDetectDetector extends com.baidu.ar.b.a.a {
    public static final String TAG = "ObjDetectDetector";
    public int oU = 6;

    public ObjDetectDetector() {
        c.cd().a(this);
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.BGR);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(640);
        this.nk.setOutputHeight(360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i, boolean z) {
        if (i != -90) {
            if (i != 90) {
                if (i != 180) {
                    if (z) {
                        return 3;
                    }
                } else if (!z) {
                    return 3;
                }
                return 1;
            } else if (!z) {
                return 2;
            }
        } else if (z) {
            return 2;
        }
        return 0;
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
                return aVar.f1036tv ? ARMdlInterfaceJNI.initObjDetectFromAsset(strArr[0], strArr[1]) : ARMdlInterfaceJNI.initObjDetect(strArr[0], strArr[1]);
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "obj";
            }
        };
    }

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
                return "obj";
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
        return this.oU;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        return new com.baidu.ar.b.b.c(this.oU, framePixels) { // from class: com.baidu.ar.objdetect.ObjDetectDetector.3
            @Override // com.baidu.ar.c.a
            public String getTag() {
                return "obj";
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
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }
}
