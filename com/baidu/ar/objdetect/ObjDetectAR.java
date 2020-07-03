package com.baidu.ar.objdetect;

import android.graphics.PointF;
import android.os.Bundle;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arrender.j;
import com.baidu.ar.c;
import com.baidu.ar.c.e;
import com.baidu.ar.c.l;
import com.baidu.ar.gesture.GestureAR;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ObjDetectAR extends c {
    private e ly;
    private a sf;

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap l(float[] fArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "object_detect");
        int i = (int) fArr[0];
        ArrayList arrayList = new ArrayList();
        j r = r();
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
        if (this.sf != null) {
            this.sf.aw();
            a(this.sf);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.sf = new a();
        this.ly = new e() { // from class: com.baidu.ar.objdetect.ObjDetectAR.1
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                ObjDetectAR.this.d(ObjDetectAR.this.l(((b) bVar).ec()));
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        };
        a(this.sf, this.ly);
        com.baidu.ar.b.a.aq().a(getContext(), getMdlConfigs());
        this.sf.c(new Bundle());
    }
}
