package com.baidu.android.pushservice.message;

import android.content.Context;
/* loaded from: classes2.dex */
public class a {
    private static final String a = a.class.getSimpleName();
    private Context b;

    public a(Context context) {
        this.b = context;
    }

    public c a(h hVar) {
        switch (hVar) {
            case MSG_ID_HANDSHAKE:
                return new b(this.b);
            case MSG_ID_HEARTBEAT_SERVER:
            case MSG_ID_TINY_HEARTBEAT_SERVER:
                return new l(this.b);
            case MSG_ID_HEARTBEAT_CLIENT:
                com.baidu.android.pushservice.g.a.b(a, "handleMessage MSG_ID_HEARTBEAT_CLIENT");
                return null;
            case MSG_ID_TINY_HEARTBEAT_CLIENT:
                com.baidu.android.pushservice.g.a.b(a, "handleMessage MSG_ID_TIMY_HEARTBEAT_CLIENT");
                return null;
            case MSG_ID_PUSH_MSG:
                return new j(this.b);
            default:
                com.baidu.android.pushservice.g.a.e(a, "handleMessage invalid messageType");
                return null;
        }
    }
}
