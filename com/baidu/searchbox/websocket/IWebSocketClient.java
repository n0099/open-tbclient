package com.baidu.searchbox.websocket;

import java.nio.ByteBuffer;
import kotlin.e;
@e
/* loaded from: classes4.dex */
public interface IWebSocketClient {
    void close(int i, String str);

    void connect(WebSocketRequest webSocketRequest, IWebSocketListener iWebSocketListener);

    void send(String str);

    void send(ByteBuffer byteBuffer);
}
