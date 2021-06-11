package com.baidu.android.pushservice.d;

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
        MODEL_VI(7);
        

        /* renamed from: h  reason: collision with root package name */
        public int f3052h;

        a(int i2) {
            this.f3052h = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.f3052h;
        }
    }

    public static int a(Context context) {
        a aVar;
        int a2 = a.MODEL_O.a();
        int b2 = com.baidu.android.pushservice.b.d.a(context).b();
        if (com.baidu.android.pushservice.b.d.l(context)) {
            aVar = a.MODEL_HW;
        } else if (com.baidu.android.pushservice.b.d.k(context)) {
            aVar = a.MODEL_XM;
        } else if (com.baidu.android.pushservice.b.d.m(context)) {
            aVar = a.MODEL_OP;
        } else if (com.baidu.android.pushservice.b.d.n(context)) {
            aVar = a.MODEL_VI;
        } else if (com.baidu.android.pushservice.b.d.j(context)) {
            aVar = a.MODEL_MZ;
        } else if (b2 != 2 && b2 != 4 && b2 != 3) {
            return a2;
        } else {
            aVar = a.MODEL_C;
        }
        return aVar.a();
    }
}
