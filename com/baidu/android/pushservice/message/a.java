package com.baidu.android.pushservice.message;

import android.content.Context;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f1234a;

    public a(Context context) {
        this.f1234a = context;
    }

    public c a(h hVar) {
        switch (hVar) {
            case MSG_ID_HANDSHAKE:
                return new b(this.f1234a);
            case MSG_ID_HEARTBEAT_SERVER:
            case MSG_ID_TINY_HEARTBEAT_SERVER:
                return new l(this.f1234a);
            case MSG_ID_HEARTBEAT_CLIENT:
            case MSG_ID_TINY_HEARTBEAT_CLIENT:
            default:
                return null;
            case MSG_ID_PUSH_MSG:
                return new j(this.f1234a);
        }
    }
}
