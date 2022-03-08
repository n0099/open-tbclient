package com.baidu.searchbox.websocket;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.tachikoma.core.component.input.ReturnKeyType;
import java.nio.ByteBuffer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/websocket/IWebSocketClient;", "Lkotlin/Any;", "", "code", "", "reason", "", IntentConfig.CLOSE, "(ILjava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "request", "Lcom/baidu/searchbox/websocket/IWebSocketListener;", "listener", "connect", "(Lcom/baidu/searchbox/websocket/WebSocketRequest;Lcom/baidu/searchbox/websocket/IWebSocketListener;)V", "Ljava/nio/ByteBuffer;", "data", ReturnKeyType.SEND, "(Ljava/nio/ByteBuffer;)V", "message", "(Ljava/lang/String;)V", "websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IWebSocketClient {
    void close(int i2, String str);

    void connect(WebSocketRequest webSocketRequest, IWebSocketListener iWebSocketListener);

    void send(String str);

    void send(ByteBuffer byteBuffer);
}
