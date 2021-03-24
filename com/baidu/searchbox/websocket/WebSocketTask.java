package com.baidu.searchbox.websocket;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketTask;", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "", "code", "", "reason", "", IntentConfig.CLOSE, "(ILjava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "request", "Lcom/baidu/searchbox/websocket/IWebSocketListener;", "listener", "connect", "(Lcom/baidu/searchbox/websocket/WebSocketRequest;Lcom/baidu/searchbox/websocket/IWebSocketListener;)V", "Ljava/nio/ByteBuffer;", "data", "send", "(Ljava/nio/ByteBuffer;)V", "message", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "toJSON", "()Lorg/json/JSONObject;", "taskId", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "webSocketClient", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "<init>", "(Lcom/baidu/searchbox/websocket/IWebSocketClient;)V", "lib-websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class WebSocketTask implements IWebSocketClient {
    public final String taskId = "WebSocketTask-" + System.currentTimeMillis();
    public final IWebSocketClient webSocketClient;

    public WebSocketTask(IWebSocketClient iWebSocketClient) {
        this.webSocketClient = iWebSocketClient;
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void close(int i, String str) {
        this.webSocketClient.close(i, str);
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void connect(WebSocketRequest webSocketRequest, final IWebSocketListener iWebSocketListener) {
        this.webSocketClient.connect(webSocketRequest, new IWebSocketListener(iWebSocketListener) { // from class: com.baidu.searchbox.websocket.WebSocketTask$connect$1
            public final /* synthetic */ IWebSocketListener $$delegate_0;
            public final /* synthetic */ IWebSocketListener $listener;

            {
                this.$listener = iWebSocketListener;
                this.$$delegate_0 = iWebSocketListener;
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onClose(JSONObject jSONObject) {
                IWebSocketListener iWebSocketListener2 = this.$listener;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                iWebSocketListener2.onClose(jSONObject.put("taskID", WebSocketTask.this.getTaskId()));
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onError(Throwable th, JSONObject jSONObject) {
                IWebSocketListener iWebSocketListener2 = this.$listener;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                iWebSocketListener2.onError(th, jSONObject.put("taskID", WebSocketTask.this.getTaskId()));
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onMessage(String str) {
                this.$$delegate_0.onMessage(str);
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onMessage(ByteBuffer byteBuffer) {
                this.$$delegate_0.onMessage(byteBuffer);
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onOpen(Map<String, String> map) {
                this.$$delegate_0.onOpen(map);
            }
        });
    }

    public final String getTaskId() {
        return this.taskId;
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(String str) {
        this.webSocketClient.send(str);
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(ByteBuffer byteBuffer) {
        this.webSocketClient.send(byteBuffer);
    }

    public final JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.taskId);
        return jSONObject;
    }
}
