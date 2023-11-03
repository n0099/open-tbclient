package com.baidu.android.pushservice.w;

import android.content.Context;
/* loaded from: classes.dex */
public class a {
    public Context a;

    /* renamed from: com.baidu.android.pushservice.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0039a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.values().length];
            a = iArr;
            try {
                iArr[h.MSG_ID_HANDSHAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.MSG_ID_HEARTBEAT_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.MSG_ID_TINY_HEARTBEAT_SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.MSG_ID_HEARTBEAT_CLIENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[h.MSG_ID_TINY_HEARTBEAT_CLIENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[h.MSG_ID_PUSH_MSG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public a(Context context) {
        this.a = context;
    }

    public c a(h hVar) {
        int i = C0039a.a[hVar.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                return new l(this.a);
            }
            if (i != 6) {
                return null;
            }
            return new j(this.a);
        }
        return new b(this.a);
    }
}
