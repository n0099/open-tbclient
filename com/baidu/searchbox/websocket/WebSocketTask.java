package com.baidu.searchbox.websocket;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class WebSocketTask implements IWebSocketClient {
    private final String taskId;
    private final IWebSocketClient webSocketClient;

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void close(int i, String str) {
        p.j(str, TiebaInitialize.LogFields.REASON);
        this.webSocketClient.close(i, str);
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(String str) {
        p.j(str, "message");
        this.webSocketClient.send(str);
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(ByteBuffer byteBuffer) {
        p.j(byteBuffer, "data");
        this.webSocketClient.send(byteBuffer);
    }

    public WebSocketTask(IWebSocketClient iWebSocketClient) {
        p.j(iWebSocketClient, "webSocketClient");
        this.webSocketClient = iWebSocketClient;
        this.taskId = "WebSocketTask-" + System.currentTimeMillis();
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.taskId);
        return jSONObject;
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void connect(WebSocketRequest webSocketRequest, final IWebSocketListener iWebSocketListener) {
        p.j(webSocketRequest, "request");
        p.j(iWebSocketListener, "listener");
        this.webSocketClient.connect(webSocketRequest, new IWebSocketListener(iWebSocketListener) { // from class: com.baidu.searchbox.websocket.WebSocketTask$connect$1
            private final /* synthetic */ IWebSocketListener $$delegate_0;
            final /* synthetic */ IWebSocketListener $listener;

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onMessage(String str) {
                p.j(str, "message");
                this.$$delegate_0.onMessage(str);
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onMessage(ByteBuffer byteBuffer) {
                p.j(byteBuffer, "data");
                this.$$delegate_0.onMessage(byteBuffer);
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onOpen(Map<String, String> map) {
                p.j(map, "headers");
                this.$$delegate_0.onOpen(map);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
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
                p.j(th, "t");
                IWebSocketListener iWebSocketListener2 = this.$listener;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                iWebSocketListener2.onError(th, jSONObject.put("taskID", WebSocketTask.this.getTaskId()));
            }
        });
    }
}
