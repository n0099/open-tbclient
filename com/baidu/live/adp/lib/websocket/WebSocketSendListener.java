package com.baidu.live.adp.lib.websocket;
/* loaded from: classes11.dex */
public interface WebSocketSendListener {
    public static final int ERROR_GEN_DATA = 2;
    public static final int ERROR_SEND = 1;

    void onFinishSend();

    void onSendError(int i);

    void onStartSend();
}
