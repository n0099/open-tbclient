package com.baidu.android.pushservice.message;
/* loaded from: classes6.dex */
public enum h {
    TYPE_INVALUE(-1),
    MSG_ID_HANDSHAKE(1),
    MSG_ID_HEARTBEAT_SERVER(2),
    MSG_ID_HEARTBEAT_CLIENT(4),
    MSG_ID_PUSH_MSG(3),
    MSG_ID_TINY_HEARTBEAT_CLIENT(5),
    MSG_ID_TINY_HEARTBEAT_SERVER(6);
    
    private short h;

    h(int i2) {
        this.h = (short) i2;
    }

    public static h a(short s) {
        switch (s) {
            case 1:
                return MSG_ID_HANDSHAKE;
            case 2:
                return MSG_ID_HEARTBEAT_SERVER;
            case 3:
                return MSG_ID_PUSH_MSG;
            case 4:
                return MSG_ID_HEARTBEAT_CLIENT;
            case 5:
                return MSG_ID_TINY_HEARTBEAT_CLIENT;
            case 6:
                return MSG_ID_TINY_HEARTBEAT_SERVER;
            default:
                return TYPE_INVALUE;
        }
    }

    public short a() {
        return this.h;
    }
}
