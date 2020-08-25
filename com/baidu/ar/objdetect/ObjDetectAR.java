package com.baidu.ar.objdetect;

import android.graphics.PointF;
import android.os.Bundle;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arrender.k;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.ar.gesture.GestureAR;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class ObjDetectAR extends c {
    private e mg;
    private ObjDetectDetector sK;

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap l(float[] fArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "object_detect");
        int i = (int) fArr[0];
        ArrayList arrayList = new ArrayList();
        k r = r();
        if (r == null) {
            hashMap.put("event_data", arrayList);
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = (i2 * 7) + 1;
                HashMap hashMap2 = new HashMap();
                PointF pointF = new PointF(fArr[i3 + 3], fArr[i3 + 4]);
                r.a(pointF, true);
                PointF pointF2 = new PointF(fArr[i3 + 5], fArr[i3 + 6]);
                r.a(pointF2, true);
                hashMap2.put("object_id", Float.valueOf(fArr[i3]));
                hashMap2.put("category", 3);
                hashMap2.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, Float.valueOf(fArr[i3 + 2]));
                hashMap2.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1, Float.valueOf(pointF.x));
                hashMap2.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1, Float.valueOf(pointF.y));
                hashMap2.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X2, Float.valueOf(pointF2.x));
                hashMap2.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y2, Float.valueOf(pointF2.y));
                arrayList.add(hashMap2);
            }
            hashMap.put("event_data", arrayList);
        }
        return hashMap;
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.sK != null) {
            this.sK.au();
            a(this.sK);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.sK = new ObjDetectDetector();
        this.mg = new e() { // from class: com.baidu.ar.objdetect.ObjDetectAR.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                ObjDetectAR.this.d(ObjDetectAR.this.l(((a) bVar).fo()));
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        };
        a(this.sK, this.mg);
        com.baidu.ar.b.a.ar().a(getContext(), getMdlConfigs());
        this.sK.b(new Bundle());
    }
}
