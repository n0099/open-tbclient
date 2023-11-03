package com.baidu.android.pushservice.w.m;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public Context a;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.values().length];
            a = iArr;
            try {
                iArr[l.MSG_TYPE_SINGLE_PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.MSG_TYPE_MULTI_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.MSG_TYPE_PRIVATE_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.MSG_TYPE_SINGLE_PUBLIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[l.MSG_TYPE_MULTI_PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[l.MSG_TYPE_CLEAR_MESSAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[l.MSG_TYPE_APP_PRIORITY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[l.MSG_TYPE_LOCAL_PUSH_MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public k(Context context) {
        this.a = context;
    }

    public c a(l lVar) {
        switch (a.a[lVar.ordinal()]) {
            case 1:
            case 2:
                return new g(this.a);
            case 3:
                return new h(this.a);
            case 4:
            case 5:
                return new i(this.a);
            case 6:
                return new e(this.a);
            case 7:
                return new b(this.a);
            case 8:
                return new com.baidu.android.pushservice.w.m.a(this.a);
            case 9:
                return new d(this.a);
            default:
                return null;
        }
    }
}
