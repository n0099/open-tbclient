package com.baidu.ar.gesture;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.c;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import java.nio.ByteBuffer;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a extends com.baidu.ar.b.a.b {
    private static final String TAG = a.class.getSimpleName();
    private int cS = 1;

    public a() {
        this.mm = new PixelReadParams(PixelType.BGR);
        this.mm.setOutputWidth(320);
        this.mm.setOutputHeight(180);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, boolean z) {
        switch (i) {
            case -90:
                return 0;
            case 0:
                return !z ? 90 : -90;
            case 90:
                return 180;
            case 180:
                return z ? 90 : -90;
            default:
                return z ? -90 : 90;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(Bundle bundle) {
        if (bundle == null) {
            return 1;
        }
        String string = bundle.getString(HttpConstants.FUNCTION_TYPE, "gesture");
        if ("gesture".equals(string)) {
            return 1;
        }
        return "fingertip".equals(string) ? 2 : 0;
    }

    @Override // com.baidu.ar.b.a.b
    public com.baidu.ar.b.b.b a(final ByteBuffer byteBuffer, final int i, final int i2, final long j, final boolean z, final int i3, int i4) {
        com.baidu.ar.b.a.aq().c(this.cS);
        return new com.baidu.ar.b.b.b(this.cS) { // from class: com.baidu.ar.gesture.a.3
            @Override // com.baidu.ar.b.b.b
            public HashMap aA() {
                int b = a.this.b(i3, z);
                HashMap hashMap = new HashMap();
                hashMap.put("timestamp", Long.valueOf(j));
                float[] fArr = new float[13];
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ARMdlInterfaceJNI.predictGesture(byteBuffer, i, i2, b, z, fArr);
                StatisticApi.getPerformanceApi().recordAlgoTimeCost("finger_gesture", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                hashMap.put("gesture", fArr);
                return hashMap;
            }
        };
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
        return new com.baidu.ar.b.b.a(this.cS) { // from class: com.baidu.ar.gesture.a.2
            @Override // com.baidu.ar.b.b.a
            public boolean az() {
                ARMdlInterfaceJNI.releaseGesture();
                return true;
            }
        };
    }

    @Override // com.baidu.ar.b.a.b
    public c b(final Bundle bundle) {
        return new c(this.cS) { // from class: com.baidu.ar.gesture.a.1
            @Override // com.baidu.ar.b.b.c
            public int a(com.baidu.ar.mdl.a aVar) {
                String[] strArr = aVar.se;
                if (strArr == null || strArr.length == 0) {
                    return -1;
                }
                int i = bundle.getInt("force_ft_pose_flag", 0);
                float f = bundle.getFloat("det_thresh", 0.25f);
                float f2 = bundle.getFloat("first_cls_thresh", 0.75f);
                float f3 = bundle.getFloat("second_cls_thresh", 0.5f);
                return aVar.sd ? ARMdlInterfaceJNI.initGestureFromAsset(strArr[0], strArr[1], strArr[2], a.this.d(bundle), i, f, f2, f3, 1) : ARMdlInterfaceJNI.initGesture(strArr[0], strArr[1], strArr[2], a.this.d(bundle), i, f, f2, f3, 1);
            }
        };
    }

    @Override // com.baidu.ar.b.a.a
    public void e(HashMap hashMap) {
        long longValue = ((Long) hashMap.get("timestamp")).longValue();
        b bVar = new b(getName(), (float[]) hashMap.get("gesture"), longValue);
        if (this.ly != null) {
            this.ly.a(bVar);
        }
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
