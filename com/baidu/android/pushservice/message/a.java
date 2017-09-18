package com.baidu.android.pushservice.message;

import android.content.Context;
/* loaded from: classes2.dex */
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
                com.baidu.android.pushservice.g.a.b("ConnectMessageHandlerFactory", "handleMessage MSG_ID_HEARTBEAT_CLIENT");
                return null;
            case MSG_ID_TINY_HEARTBEAT_CLIENT:
                com.baidu.android.pushservice.g.a.b("ConnectMessageHandlerFactory", "handleMessage MSG_ID_TIMY_HEARTBEAT_CLIENT");
                return null;
            case MSG_ID_PUSH_MSG:
                return new j(this.a);
            default:
                com.baidu.android.pushservice.g.a.e("ConnectMessageHandlerFactory", "handleMessage invalid messageType");
                return null;
        }
    }
}
