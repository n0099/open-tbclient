package com.baidu.android.pushservice.message.a;

import android.content.Context;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public Context f3536a;

    /* renamed from: com.baidu.android.pushservice.message.a.k$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3537a;

        static {
            int[] iArr = new int[l.values().length];
            f3537a = iArr;
            try {
                iArr[l.MSG_TYPE_SINGLE_PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3537a[l.MSG_TYPE_MULTI_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3537a[l.MSG_TYPE_PRIVATE_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3537a[l.MSG_TYPE_SINGLE_PUBLIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3537a[l.MSG_TYPE_MULTI_PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3537a[l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3537a[l.MSG_TYPE_CLEAR_MESSAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3537a[l.MSG_TYPE_CROSS_PUSH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3537a[l.MSG_TYPE_APP_PRIORITY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public k(Context context) {
        this.f3536a = context;
    }

    public d a(l lVar) {
        switch (AnonymousClass1.f3537a[lVar.ordinal()]) {
            case 1:
            case 2:
                return new g(this.f3536a);
            case 3:
                return new h(this.f3536a);
            case 4:
            case 5:
                return new i(this.f3536a);
            case 6:
                return new e(this.f3536a);
            case 7:
                return new b(this.f3536a);
            case 8:
                return new c(this.f3536a);
            case 9:
                return new a(this.f3536a);
            default:
                m.a(">>> Unknown msg_type : " + lVar, this.f3536a);
                return null;
        }
    }
}
