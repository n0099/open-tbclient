package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public Context f3517a;

    /* renamed from: com.baidu.android.pushservice.message.a.k$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3518a;

        static {
            int[] iArr = new int[l.values().length];
            f3518a = iArr;
            try {
                iArr[l.MSG_TYPE_SINGLE_PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3518a[l.MSG_TYPE_MULTI_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3518a[l.MSG_TYPE_PRIVATE_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3518a[l.MSG_TYPE_SINGLE_PUBLIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3518a[l.MSG_TYPE_MULTI_PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3518a[l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3518a[l.MSG_TYPE_CLEAR_MESSAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3518a[l.MSG_TYPE_CROSS_PUSH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3518a[l.MSG_TYPE_APP_PRIORITY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public k(Context context) {
        this.f3517a = context;
    }

    public d a(l lVar) {
        switch (AnonymousClass1.f3518a[lVar.ordinal()]) {
            case 1:
            case 2:
                return new g(this.f3517a);
            case 3:
                return new h(this.f3517a);
            case 4:
            case 5:
                return new i(this.f3517a);
            case 6:
                return new e(this.f3517a);
            case 7:
                return new b(this.f3517a);
            case 8:
                return new c(this.f3517a);
            case 9:
                return new a(this.f3517a);
            default:
                m.a(">>> Unknown msg_type : " + lVar, this.f3517a);
                return null;
        }
    }
}
