package com.baidu.ar.gesture;

import android.graphics.PointF;
import android.os.Bundle;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class GestureAR extends c {
    public static final int MDL_GESTURE_STATUS_DETECTED = 5002;
    public static final String SDK_TO_LUA_GESTURE_RESULT_BODY = "gesture_result";
    public static final String SDK_TO_LUA_GESTURE_RESULT_COUNT = "gesture_count";
    public static final String SDK_TO_LUA_GESTURE_RESULT_FTX = "ftx";
    public static final String SDK_TO_LUA_GESTURE_RESULT_FTY = "fty";
    public static final String SDK_TO_LUA_GESTURE_RESULT_JNTX = "jntx";
    public static final String SDK_TO_LUA_GESTURE_RESULT_JNTY = "jnty";
    public static final String SDK_TO_LUA_GESTURE_RESULT_RESERVED = "reserved";
    public static final String SDK_TO_LUA_GESTURE_RESULT_SCORE = "score";
    public static final String SDK_TO_LUA_GESTURE_RESULT_TJNTX = "tjntx";
    public static final String SDK_TO_LUA_GESTURE_RESULT_TJNTY = "tjnty";
    public static final String SDK_TO_LUA_GESTURE_RESULT_TYPE = "type";
    public static final String SDK_TO_LUA_GESTURE_RESULT_X1 = "x1";
    public static final String SDK_TO_LUA_GESTURE_RESULT_X2 = "x2";
    public static final String SDK_TO_LUA_GESTURE_RESULT_Y1 = "y1";
    public static final String SDK_TO_LUA_GESTURE_RESULT_Y2 = "y2";
    private static final String TAG = GestureAR.class.getSimpleName();
    private e mv;
    private GestureDetector qp;

    private void a(Bundle bundle, HashMap<String, Object> hashMap) {
        bundle.putString(HttpConstants.FUNCTION_TYPE, com.baidu.ar.arplay.c.c.a(hashMap.get(HttpConstants.FUNCTION_TYPE), AppFrameworkConstants.VALUE_GESTURE_BACK));
        Map map = (Map) hashMap.get("extra_data");
        if (map == null || map.isEmpty()) {
            return;
        }
        if (map.containsKey("force_ft_pose_flag")) {
            bundle.putInt("force_ft_pose_flag", com.baidu.ar.arplay.c.c.a(map.get("force_ft_pose_flag"), 0));
        }
        if (map.containsKey("det_thresh")) {
            bundle.putFloat("det_thresh", com.baidu.ar.arplay.c.c.a(map.get("det_thresh"), 0.25f));
        }
        if (map.containsKey("first_cls_thresh")) {
            bundle.putFloat("first_cls_thresh", com.baidu.ar.arplay.c.c.a(map.get("first_cls_thresh"), 0.75f));
        }
        if (map.containsKey("second_cls_thresh")) {
            bundle.putFloat("second_cls_thresh", com.baidu.ar.arplay.c.c.a(map.get("second_cls_thresh"), 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap f(float[] fArr) {
        HashMap hashMap = new HashMap();
        int length = fArr.length / 13;
        hashMap.put("id", 5002);
        l r = r();
        if (r == null) {
            hashMap.put(SDK_TO_LUA_GESTURE_RESULT_COUNT, 0);
        } else {
            hashMap.put(SDK_TO_LUA_GESTURE_RESULT_COUNT, Integer.valueOf(length));
            for (int i = 0; i < length; i++) {
                String concat = SDK_TO_LUA_GESTURE_RESULT_BODY.concat("" + (i + 1));
                PointF pointF = new PointF(fArr[(i * 13) + 3], fArr[(i * 13) + 4]);
                r.a(pointF, true);
                PointF pointF2 = new PointF(fArr[(i * 13) + 5], fArr[(i * 13) + 6]);
                r.a(pointF2, true);
                PointF pointF3 = new PointF(fArr[(i * 13) + 7], fArr[(i * 13) + 8]);
                r.a(pointF3, true);
                PointF pointF4 = new PointF(fArr[(i * 13) + 9], fArr[(i * 13) + 10]);
                r.a(pointF4, true);
                PointF pointF5 = new PointF(fArr[(i * 13) + 11], fArr[(i * 13) + 12]);
                r.a(pointF5, true);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_RESERVED, Float.valueOf(fArr[i * 13]));
                hashMap2.put("type", Float.valueOf(fArr[(i * 13) + 1]));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_SCORE, Float.valueOf(fArr[(i * 13) + 2]));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_X1, Float.valueOf(pointF.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_Y1, Float.valueOf(pointF.y));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_X2, Float.valueOf(pointF2.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_Y2, Float.valueOf(pointF2.y));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_FTX, Float.valueOf(pointF3.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_FTY, Float.valueOf(pointF3.y));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_JNTX, Float.valueOf(pointF4.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_JNTY, Float.valueOf(pointF4.y));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_TJNTX, Float.valueOf(pointF5.x));
                hashMap2.put(SDK_TO_LUA_GESTURE_RESULT_TJNTY, Float.valueOf(pointF5.y));
                hashMap.put(concat, hashMap2);
            }
        }
        return hashMap;
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.qp != null) {
            this.qp.av();
            a(this.qp);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.qp = new GestureDetector();
        this.mv = new e() { // from class: com.baidu.ar.gesture.GestureAR.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                GestureAR.this.d(GestureAR.this.f(((a) bVar).eG()));
            }

            @Override // com.baidu.ar.d.e
            public void a(com.baidu.ar.d.l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(com.baidu.ar.d.l lVar) {
            }
        };
        a(this.qp, this.mv);
        com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
        Bundle bundle = new Bundle();
        a(bundle, hashMap);
        this.qp.b(bundle);
        StatisticApi.onEvent(StatisticConstants.MDL_GESTURE_OPEN);
    }
}
