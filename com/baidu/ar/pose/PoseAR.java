package com.baidu.ar.pose;

import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.yy.videoplayer.decoder.VideoConstant;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class PoseAR extends c {
    public static final String MDL_MAGIC_FILTER_CUTOFFSLOPE = "cutoffSlope";
    public static final String MDL_MAGIC_FILTER_MIN_CUTOFFFREQ = "min_cutofffreq";
    public static final String MDL_START_POSE_FUN_EVENT_TYPE_KEY = "event_type";
    private e mv;
    private int nO = VideoConstant.THUMBNAIL_WIDTH;
    private int nP = 180;
    private PoseDetector tM;

    private void b(Bundle bundle, HashMap<String, Object> hashMap) {
        float[] fArr;
        bundle.putString(MDL_START_POSE_FUN_EVENT_TYPE_KEY, (String) hashMap.get(MDL_START_POSE_FUN_EVENT_TYPE_KEY));
        HashMap hashMap2 = (HashMap) hashMap.get("algo_map");
        if (hashMap2 != null) {
            r1 = hashMap2.containsKey(MDL_MAGIC_FILTER_CUTOFFSLOPE) ? ((Float) hashMap2.get(MDL_MAGIC_FILTER_CUTOFFSLOPE)).floatValue() : 1.0f;
            if (hashMap2.containsKey(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ)) {
                String[] split = ((String) hashMap2.get(MDL_MAGIC_FILTER_MIN_CUTOFFFREQ)).split(",");
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

    private void dn() {
        int i;
        int i2 = VideoConstant.THUMBNAIL_WIDTH;
        int i3 = this.mInputWidth;
        int i4 = this.mInputHeight;
        if (Float.compare((i3 * 1.0f) / i4, 1.7777778f) == 0) {
            i = 180;
        } else if (i3 > i4) {
            i2 = (int) (i3 * (180.0f / i4));
            i = 180;
        } else {
            i = (int) ((180.0f / i3) * i4);
            i2 = 180;
        }
        this.nO = i2;
        this.nP = i;
    }

    private float dq() {
        if (this.mInputWidth == 0 || this.mInputHeight == 0) {
            return 56.144978f;
        }
        int i = this.S;
        return (float) (((Math.atan2(((i == 90 || i == 270) ? this.mInputWidth : this.mInputHeight) * 0.5f, 0.94375f * Math.max(this.mInputWidth, this.mInputHeight)) * 2.0d) * 180.0d) / 3.141592653589793d);
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
        int i = 0;
        HashMap hashMap = new HashMap();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "body_tracking_data");
        l r = r();
        if (r == null) {
            return hashMap;
        }
        boolean z = this.T;
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
                arrayList2.add(this.T ? new Vector3f(pointF.x, pointF.y, fArr[(i2 * 3) + 2]) : new Vector3f(pointF.y, pointF.x, fArr[(i2 * 3) + 2]));
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
        if (this.tM != null) {
            this.tM.av();
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
        this.tM.I(this.T);
        this.mv = new e() { // from class: com.baidu.ar.pose.PoseAR.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                PoseAR.this.d(PoseAR.this.l(((a) bVar).fr()));
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
            }
        };
        a(this.tM, this.mv);
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
