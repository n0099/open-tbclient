package com.baidu.ar.pose;

import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.k;
import com.baidu.ar.c;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.ar.libloader.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class PoseAR extends c {
    public static final String MDL_MAGIC_FILTER_CUTOFFSLOPE = "cutoffSlope";
    public static final String MDL_MAGIC_FILTER_MIN_CUTOFFFREQ = "min_cutofffreq";
    public static final String MDL_START_POSE_FUN_EVENT_TYPE_KEY = "event_type";
    private e mg;
    private int ny = 320;
    private int nz = 180;
    private PoseDetector sZ;

    private void b(Bundle bundle, HashMap<String, Object> hashMap) {
        float[] fArr;
        bundle.putString(MDL_START_POSE_FUN_EVENT_TYPE_KEY, (String) hashMap.get(MDL_START_POSE_FUN_EVENT_TYPE_KEY));
        HashMap hashMap2 = (HashMap) hashMap.get("algo_map");
        if (hashMap2 != null) {
            r1 = hashMap2.containsKey(MDL_MAGIC_FILTER_CUTOFFSLOPE) ? ((Float) hashMap2.get(MDL_MAGIC_FILTER_CUTOFFSLOPE)).floatValue() : 1.0f;
            if (hashMap2.containsKey(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ)) {
                String[] split = ((String) hashMap2.get(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ)).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                float[] fArr2 = new float[split.length];
                for (int i = 0; i < split.length; i++) {
                    fArr2[i] = Float.parseFloat(split[i]);
                }
                fArr = fArr2;
                bundle.putFloat(MDL_MAGIC_FILTER_CUTOFFSLOPE, r1);
                bundle.putFloatArray(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ, fArr);
            }
        }
        fArr = null;
        bundle.putFloat(MDL_MAGIC_FILTER_CUTOFFSLOPE, r1);
        bundle.putFloatArray(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ, fArr);
    }

    /* renamed from: do  reason: not valid java name */
    private void m19do() {
        int i = 180;
        int i2 = 320;
        int i3 = this.R;
        int i4 = this.S;
        if (Float.compare((i3 * 1.0f) / i4, 1.7777778f) != 0) {
            if (i3 > i4) {
                i2 = (int) ((180.0f / i4) * i3);
            } else {
                i2 = 180;
                i = (int) ((180.0f / i3) * i4);
            }
        }
        this.ny = i2;
        this.nz = i;
    }

    private float dr() {
        if (this.R == 0 || this.S == 0) {
            return 56.144978f;
        }
        int i = this.T;
        return (float) (((Math.atan2(((i == 90 || i == 270) ? this.R : this.S) * 0.5f, 0.94375f * Math.max(this.R, this.S)) * 2.0d) * 180.0d) / 3.141592653589793d);
    }

    private void fr() {
        String str = Build.HARDWARE;
        if (!TextUtils.isEmpty(str) && str.matches("qcom")) {
            try {
                b.as("SNPE_G");
                b.as("snpe_engine");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap m(float[] fArr) {
        int i = 0;
        HashMap hashMap = new HashMap();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "body_tracking_data");
        k r = r();
        if (r == null) {
            return hashMap;
        }
        boolean z = this.U;
        if (fArr != null && fArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int i2 = i;
                if (i2 >= 18) {
                    break;
                }
                PointF pointF = new PointF(fArr[i2 * 3], fArr[(i2 * 3) + 1]);
                r.a(pointF, z);
                arrayList2.add(this.U ? new Vector3f(pointF.x, pointF.y, fArr[(i2 * 3) + 2]) : new Vector3f(pointF.y, pointF.x, fArr[(i2 * 3) + 2]));
                i = i2 + 1;
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
        if (this.sZ != null) {
            this.sZ.au();
            a(this.sZ);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        fr();
        this.sZ = new PoseDetector();
        m19do();
        this.sZ.i(this.ny, this.nz);
        this.sZ.K(this.U);
        this.mg = new e() { // from class: com.baidu.ar.pose.PoseAR.1
            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.b bVar) {
                PoseAR.this.d(PoseAR.this.m(((a) bVar).fs()));
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        };
        a(this.sZ, this.mg);
        com.baidu.ar.b.a.ar().a(getContext(), getMdlConfigs());
        Bundle bundle = new Bundle();
        b(bundle, hashMap);
        this.sZ.b(bundle);
        k r = r();
        if (r != null) {
            r.n(true);
            r.a(dr());
        }
    }
}
