package com.baidu.android.pushservice.message;

import android.content.Context;
/* loaded from: classes3.dex */
public class a {
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    public c a(h hVar) {
        switch (hVar) {
            case MSG_ID_HANDSHAKE:
                return new b(this.a);
            case MSG_ID_HEARTBEAT_SERVER:
            case MSG_ID_TINY_HEARTBEAT_SERVER:
                return new l(this.a);
            case MSG_ID_HEARTBEAT_CLIENT:
            case MSG_ID_TINY_HEARTBEAT_CLIENT:
            default:
                return null;
            case MSG_ID_PUSH_MSG:
                return new j(this.a);
        }
    }
}
