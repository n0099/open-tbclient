package com.baidu.android.pushservice.message;

import android.content.Context;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f3427a;

    /* renamed from: com.baidu.android.pushservice.message.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3428a;

        static {
            int[] iArr = new int[h.values().length];
            f3428a = iArr;
            try {
                iArr[h.MSG_ID_HANDSHAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3428a[h.MSG_ID_HEARTBEAT_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3428a[h.MSG_ID_TINY_HEARTBEAT_SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3428a[h.MSG_ID_HEARTBEAT_CLIENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3428a[h.MSG_ID_TINY_HEARTBEAT_CLIENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3428a[h.MSG_ID_PUSH_MSG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public a(Context context) {
        this.f3427a = context;
    }

    public c a(h hVar) {
        int i = AnonymousClass1.f3428a[hVar.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                return new l(this.f3427a);
            }
            if (i != 6) {
                return null;
            }
            return new j(this.f3427a);
        }
        return new b(this.f3427a);
    }
}
