package com.baidu.ar.stretch;

import android.os.Bundle;
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.c;
import com.baidu.ar.c.e;
import com.baidu.ar.c.l;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class StretchAR extends c {
    private e lb;
    private a vX;

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap l(float[] fArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(LuaMessageHelper.KEY_EVENT_NAME, "body_tracking_data");
        if (fArr != null && fArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 18; i++) {
                arrayList2.add(new Vector3f(fArr[i * 3], fArr[(i * 3) + 1], fArr[(i * 3) + 2]));
            }
            arrayList.add(arrayList2);
            hashMap.put("event_data", arrayList);
        }
        return hashMap;
    }

    @Override // com.baidu.ar.c
    public void release() {
        if (this.vX != null) {
            this.vX.ai();
            a(this.vX);
        }
        super.release();
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.vX = new a();
        this.lb = new e() { // from class: com.baidu.ar.stretch.StretchAR.1
            @Override // com.baidu.ar.c.e
            public void a(com.baidu.ar.c.b bVar) {
                StretchAR.this.d(StretchAR.this.l(((b) bVar).dQ()));
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
            }
        };
        a(this.vX, this.lb);
        com.baidu.ar.b.a.ac().a(getContext(), getMdlConfigs());
        this.vX.c((Bundle) null);
    }
}
