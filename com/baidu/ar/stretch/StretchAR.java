package com.baidu.ar.stretch;

import android.os.Bundle;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.c;
import com.baidu.ar.d.b;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class StretchAR extends c {
    public e mv;
    public StretchDetector xO;

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap l(float[] fArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_name", "body_tracking_data");
        if (fArr != null && fArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 18; i++) {
                int i2 = i * 3;
                arrayList2.add(new Vector3f(fArr[i2], fArr[i2 + 1], fArr[i2 + 2]));
            }
            arrayList.add(arrayList2);
            hashMap.put("event_data", arrayList);
        }
        return hashMap;
    }

    @Override // com.baidu.ar.c
    public void release() {
        StretchDetector stretchDetector = this.xO;
        if (stretchDetector != null) {
            stretchDetector.av();
            a(this.xO);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.xO = new StretchDetector();
        e eVar = new e() { // from class: com.baidu.ar.stretch.StretchAR.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                StretchAR stretchAR = StretchAR.this;
                stretchAR.d(stretchAR.l(((a) bVar).fr()));
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
            }
        };
        this.mv = eVar;
        a(this.xO, eVar);
        com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
        this.xO.b((Bundle) null);
    }
}
