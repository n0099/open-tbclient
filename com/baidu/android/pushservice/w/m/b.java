package com.baidu.android.pushservice.w.m;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends c {

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.baidu.android.pushservice.k.c.values().length];
            a = iArr;
            try {
                iArr[com.baidu.android.pushservice.k.c.PUSH_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.w.m.c
    public com.baidu.android.pushservice.w.g a(com.baidu.android.pushservice.w.k kVar, byte[] bArr) {
        com.baidu.android.pushservice.w.g gVar = new com.baidu.android.pushservice.w.g();
        int i = kVar.i();
        int i2 = 1;
        if (a.a[com.baidu.android.pushservice.k.d.a(this.a, kVar.a()).a().ordinal()] != 1) {
            i2 = 7;
        } else if (kVar.q() == l.MSG_TYPE_CLEAR_MESSAGE.a()) {
            if (kVar.i() != 0 && com.baidu.android.pushservice.m.d.a(this.a, i)) {
                com.baidu.android.pushservice.a0.h.a(this.a, i);
                if (com.baidu.android.pushservice.m.d.b(this.a, i)) {
                    i2 = 10;
                }
            } else {
                i2 = 12;
                com.baidu.android.pushservice.a0.h.a(this.a);
                com.baidu.android.pushservice.m.d.k(this.a);
            }
        }
        gVar.a(i2);
        return gVar;
    }
}
