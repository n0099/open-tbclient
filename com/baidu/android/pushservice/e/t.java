package com.baidu.android.pushservice.e;

import android.content.Context;
/* loaded from: classes3.dex */
public class t {

    /* loaded from: classes3.dex */
    public enum a {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context) {
        int a2 = a.MODEL_O.a();
        int b = com.baidu.android.pushservice.c.e.a(context).b();
        return com.baidu.android.pushservice.c.e.e(context) ? a.MODEL_HW.a() : com.baidu.android.pushservice.c.e.d(context) ? a.MODEL_XM.a() : com.baidu.android.pushservice.c.e.c(context) ? a.MODEL_MZ.a() : com.baidu.android.pushservice.c.e.f(context) ? a.MODEL_OP.a() : (b == 2 || b == 4 || b == 3) ? a.MODEL_C.a() : a2;
    }
}
