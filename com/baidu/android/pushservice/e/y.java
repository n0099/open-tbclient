package com.baidu.android.pushservice.e;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class y extends d {

    /* loaded from: classes2.dex */
    private enum a {
        MODEL_O(1),
        MODEL_C(2),
        MODEL_HW(3),
        MODEL_XM(4);
        
        private int e;

        a(int i) {
            this.e = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.e;
        }
    }

    public y(l lVar, Context context) {
        super(lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put(PushConstants.EXTRA_METHOD, "unbind");
        int a2 = a.MODEL_O.a();
        int b = com.baidu.android.pushservice.c.d.a(this.a).b();
        if (com.baidu.android.pushservice.c.d.c(this.a)) {
            a2 = a.MODEL_HW.a();
        } else if (com.baidu.android.pushservice.c.d.b(this.a)) {
            a2 = a.MODEL_XM.a();
        } else if (b == com.baidu.android.pushservice.c.d.f || b == com.baidu.android.pushservice.c.d.h || b == com.baidu.android.pushservice.c.d.g) {
            a2 = a.MODEL_C.a();
        }
        hashMap.put("model", a2 + "");
        com.baidu.android.pushservice.g.a.c("Unbind", "UNBIND param -- " + b.a(hashMap));
    }
}
