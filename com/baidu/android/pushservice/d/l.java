package com.baidu.android.pushservice.d;

import android.content.Context;
/* loaded from: classes9.dex */
public class l {

    /* loaded from: classes9.dex */
    public enum a {
        MODEL_O(1),
        MODEL_C(2),
        MODEL_HW(3),
        MODEL_XM(4),
        MODEL_MZ(5),
        MODEL_OP(6),
        MODEL_VI(7);
        
        private int h;

        a(int i2) {
            this.h = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context) {
        int a2 = a.MODEL_O.a();
        int b = com.baidu.android.pushservice.b.d.a(context).b();
        return com.baidu.android.pushservice.b.d.l(context) ? a.MODEL_HW.a() : com.baidu.android.pushservice.b.d.k(context) ? a.MODEL_XM.a() : com.baidu.android.pushservice.b.d.m(context) ? a.MODEL_OP.a() : com.baidu.android.pushservice.b.d.n(context) ? a.MODEL_VI.a() : com.baidu.android.pushservice.b.d.j(context) ? a.MODEL_MZ.a() : (b == 2 || b == 4 || b == 3) ? a.MODEL_C.a() : a2;
    }
}
