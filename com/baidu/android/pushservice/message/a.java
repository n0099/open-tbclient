package com.baidu.android.pushservice.message;

import android.content.Context;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f3498a;

    /* renamed from: com.baidu.android.pushservice.message.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3499a;

        static {
            int[] iArr = new int[h.values().length];
            f3499a = iArr;
            try {
                iArr[h.MSG_ID_HANDSHAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3499a[h.MSG_ID_HEARTBEAT_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3499a[h.MSG_ID_TINY_HEARTBEAT_SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3499a[h.MSG_ID_HEARTBEAT_CLIENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3499a[h.MSG_ID_TINY_HEARTBEAT_CLIENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3499a[h.MSG_ID_PUSH_MSG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public a(Context context) {
        this.f3498a = context;
    }

    public c a(h hVar) {
        int i2 = AnonymousClass1.f3499a[hVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return new l(this.f3498a);
            }
            if (i2 != 6) {
                return null;
            }
            return new j(this.f3498a);
        }
        return new b(this.f3498a);
    }
}
