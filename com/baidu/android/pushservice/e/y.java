package com.baidu.android.pushservice.e;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class y extends d {

    /* loaded from: classes2.dex */
    private enum a {
        MODEL_O(1),
        MODEL_C(2),
        MODEL_HW(3),
        MODEL_XM(4),
        MODEL_MZ(5),
        MODEL_OP(6);
        
        private int g;

        a(int i) {
            this.g = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.g;
        }
    }

    public y(l lVar, Context context) {
        super(lVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.e.a
    public void a(HashMap<String, String> hashMap) {
        super.a(hashMap);
        hashMap.put("method", "unbind");
        int a2 = a.MODEL_O.a();
        int b = com.baidu.android.pushservice.c.d.a(this.a).b();
        if (com.baidu.android.pushservice.c.d.d(this.a)) {
            a2 = a.MODEL_HW.a();
        } else if (com.baidu.android.pushservice.c.d.c(this.a)) {
            a2 = a.MODEL_XM.a();
        } else if (com.baidu.android.pushservice.c.d.b(this.a)) {
            a2 = a.MODEL_MZ.a();
        } else if (com.baidu.android.pushservice.c.d.e(this.a)) {
            a2 = a.MODEL_OP.a();
        } else if (b == 2 || b == 4 || b == 3) {
            a2 = a.MODEL_C.a();
        }
        hashMap.put("model", a2 + "");
    }
}
