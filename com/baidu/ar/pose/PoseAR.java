package com.baidu.ar.pose;

import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.j;
import com.baidu.ar.c;
import com.baidu.ar.c.e;
import com.baidu.ar.c.l;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PoseAR extends c {
    public static final String MDL_MAGIC_FILTER_CUTOFFSLOPE = "cutoffSlope";
    public static final String MDL_MAGIC_FILTER_MIN_CUTOFFFREQ = "min_cutofffreq";
    public static final String MDL_START_POSE_FUN_EVENT_TYPE_KEY = "event_type";
    private e lb;
    private a rV;

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

    private void dP() {
        String str = Build.HARDWARE;
        if (!TextUtils.isEmpty(str) && str.matches("qcom")) {
            try {
                com.baidu.ar.libloader.b.an("SNPE_G");
                com.baidu.ar.libloader.b.an("snpe_engine");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap l(float[] fArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "body_tracking_data");
        j r = r();
        if (r != null && fArr != null && fArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 18; i++) {
                PointF pointF = new PointF(fArr[i * 3], fArr[(i * 3) + 1]);
                r.a(pointF, true);
                arrayList2.add(new Vector3f(pointF.x, pointF.y, fArr[(i * 3) + 2]));
            }
            arrayList.add(arrayList2);
            hashMap.put("event_data", arrayList);
        }
        return hashMap;
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.rV != null) {
            this.rV.ai();
            a(this.rV);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        dP();
        this.rV = new a();
        this.lb = new e() { // from class: com.baidu.ar.pose.PoseAR.1
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                PoseAR.this.d(PoseAR.this.l(((b) bVar).dQ()));
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        };
        a(this.rV, this.lb);
        com.baidu.ar.b.a.ac().a(getContext(), getMdlConfigs());
        Bundle bundle = new Bundle();
        b(bundle, hashMap);
        this.rV.c(bundle);
    }
}
