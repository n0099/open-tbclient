package com.baidu.android.pushservice.p;

import android.content.Context;
/* loaded from: classes.dex */
public class l {

    /* loaded from: classes.dex */
    public enum a {
        MODEL_O(1),
        MODEL_C(2),
        MODEL_HW(3),
        MODEL_XM(4),
        MODEL_MZ(5),
        MODEL_OP(6),
        MODEL_VI(7),
        MODEL_HN(8);
        
        public int a;

        a(int i) {
            this.a = i;
        }

        public final int a() {
            return this.a;
        }
    }

    public static int a(Context context) {
        a aVar;
        int a2 = a.MODEL_O.a();
        int b = com.baidu.android.pushservice.l.d.i(context).b();
        if (!com.baidu.android.pushservice.l.d.m(context)) {
            if (com.baidu.android.pushservice.l.d.B(context)) {
                aVar = a.MODEL_XM;
            } else if (com.baidu.android.pushservice.l.d.p(context)) {
                aVar = a.MODEL_OP;
            } else if (com.baidu.android.pushservice.l.d.A(context)) {
                aVar = a.MODEL_VI;
            } else if (com.baidu.android.pushservice.l.d.n(context)) {
                aVar = a.MODEL_MZ;
            } else if (b == 2 || b == 4 || b == 3) {
                aVar = a.MODEL_C;
            } else if (!com.baidu.android.pushservice.l.d.t(context)) {
                return a2;
            } else {
                if (com.baidu.android.pushservice.l.d.l(context)) {
                    aVar = a.MODEL_HN;
                }
            }
            return aVar.a();
        }
        aVar = a.MODEL_HW;
        return aVar.a();
    }
}
