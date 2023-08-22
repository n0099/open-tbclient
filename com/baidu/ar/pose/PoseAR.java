package com.baidu.ar.pose;

import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class PoseAR extends c {
    public static final String MDL_MAGIC_FILTER_CUTOFFSLOPE = "cutoffSlope";
    public static final String MDL_MAGIC_FILTER_MIN_CUTOFFFREQ = "min_cutofffreq";
    public static final String MDL_START_POSE_FUN_EVENT_TYPE_KEY = "event_type";
    public e mv;
    public int nO = 320;
    public int nP = 180;
    public PoseDetector tM;

    private void b(Bundle bundle, HashMap<String, Object> hashMap) {
        bundle.putString(MDL_START_POSE_FUN_EVENT_TYPE_KEY, (String) hashMap.get(MDL_START_POSE_FUN_EVENT_TYPE_KEY));
        HashMap hashMap2 = (HashMap) hashMap.get("algo_map");
        float[] fArr = null;
        if (hashMap2 != null) {
            r3 = hashMap2.containsKey(MDL_MAGIC_FILTER_CUTOFFSLOPE) ? ((Float) hashMap2.get(MDL_MAGIC_FILTER_CUTOFFSLOPE)).floatValue() : 1.0f;
            if (hashMap2.containsKey(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ)) {
                String[] split = ((String) hashMap2.get(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ)).split(",");
                fArr = new float[split.length];
                for (int i = 0; i < split.length; i++) {
                    fArr[i] = Float.parseFloat(split[i]);
                }
            }
        }
        bundle.putFloat(MDL_MAGIC_FILTER_CUTOFFSLOPE, r3);
        bundle.putFloatArray(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ, fArr);
    }

    private void dn() {
        int i;
        int i2 = this.mInputWidth;
        int i3 = this.mInputHeight;
        float f = i2;
        float f2 = i3;
        int i4 = 180;
        if (Float.compare((1.0f * f) / f2, 1.7777778f) == 0) {
            i = 180;
            i4 = 320;
        } else if (i2 > i3) {
            i4 = (int) (f * (180.0f / f2));
            i = 180;
        } else {
            i = (int) (f2 * (180.0f / f));
        }
        this.nO = i4;
        this.nP = i;
    }

    private float dq() {
        int i;
        if (this.mInputWidth == 0 || (i = this.mInputHeight) == 0) {
            return 56.144978f;
        }
        int i2 = this.S;
        if (i2 == 90 || i2 == 270) {
            i = this.mInputWidth;
        }
        return (float) (((Math.atan2(i * 0.5f, Math.max(this.mInputWidth, this.mInputHeight) * 0.94375f) * 2.0d) * 180.0d) / 3.141592653589793d);
    }

    private void fq() {
        String str = Build.HARDWARE;
        if (!TextUtils.isEmpty(str) && str.matches("qcom")) {
            try {
                com.baidu.ar.libloader.a.require("SNPE_G");
                com.baidu.ar.libloader.a.require("snpe_engine");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap l(float[] fArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_name", "body_tracking_data");
        l r = r();
        if (r == null) {
            return hashMap;
        }
        boolean z = this.f1035T;
        if (fArr != null && fArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 18; i++) {
                int i2 = i * 3;
                PointF pointF = new PointF(fArr[i2], fArr[i2 + 1]);
                r.a(pointF, z);
                arrayList2.add(this.f1035T ? new Vector3f(pointF.x, pointF.y, fArr[i2 + 2]) : new Vector3f(pointF.y, pointF.x, fArr[i2 + 2]));
            }
            arrayList.add(arrayList2);
            hashMap.put("event_data", arrayList);
        }
        return hashMap;
    }

    @Override // com.baidu.ar.c, com.baidu.ar.arrender.c.a
    public void onInputSizeChange(int i, int i2) {
        super.onInputSizeChange(i, i2);
    }

    @Override // com.baidu.ar.c
    public void release() {
        PoseDetector poseDetector = this.tM;
        if (poseDetector != null) {
            poseDetector.av();
            a(this.tM);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        fq();
        this.tM = new PoseDetector();
        dn();
        this.tM.i(this.nO, this.nP);
        this.tM.I(this.f1035T);
        e eVar = new e() { // from class: com.baidu.ar.pose.PoseAR.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                PoseAR poseAR = PoseAR.this;
                poseAR.d(poseAR.l(((a) bVar).fr()));
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
            }
        };
        this.mv = eVar;
        a(this.tM, eVar);
        com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
        com.baidu.ar.b.a.as().c(getContext());
        Bundle bundle = new Bundle();
        b(bundle, hashMap);
        this.tM.b(bundle);
        l r = r();
        if (r != null) {
            r.l(true);
            r.setFieldOfView(dq());
        }
    }
}
