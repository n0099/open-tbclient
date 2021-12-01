package com.baidu.livesdk.api.im;
/* loaded from: classes8.dex */
public interface ConnectListener {

    /* loaded from: classes8.dex */
    public interface ConnectCode {
        public static final int CODE_CONNECT_DISCONNECT = 1;
        public static final int CODE_CONNECT_SUCCESS = 0;
    }

    void onResult(int i2);
}
