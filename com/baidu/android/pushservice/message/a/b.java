package com.baidu.android.pushservice.message.a;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends d {

    /* renamed from: com.baidu.android.pushservice.message.a.b$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3524a;

        static {
            int[] iArr = new int[com.baidu.android.pushservice.a.c.values().length];
            f3524a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.PUSH_CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.a.d
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        int a2 = kVar.a();
        int i2 = 12;
        if (AnonymousClass1.f3524a[com.baidu.android.pushservice.a.d.a(this.f3526a, kVar.c()).a().ordinal()] != 1) {
            i2 = 7;
        } else {
            if (kVar.g() == l.MSG_TYPE_CLEAR_MESSAGE.b()) {
                if (kVar.a() != 0 && com.baidu.android.pushservice.c.c.a(this.f3526a, a2)) {
                    com.baidu.android.pushservice.j.h.a(this.f3526a, a2);
                    if (com.baidu.android.pushservice.c.c.b(this.f3526a, a2)) {
                        i2 = 10;
                    }
                } else {
                    com.baidu.android.pushservice.j.h.a(this.f3526a);
                }
            }
            i2 = 1;
        }
        gVar.a(i2);
        return gVar;
    }
}
