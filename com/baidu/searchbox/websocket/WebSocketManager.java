package com.baidu.searchbox.websocket;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import kotlin.h;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
@h
/* loaded from: classes11.dex */
public final class WebSocketManager {
    public static final WebSocketManager INSTANCE = new WebSocketManager();
    private static HashMap<String, WebSocketTask> mTasks = new HashMap<>();

    private WebSocketManager() {
    }

    public final WebSocketTask connect(WebSocketRequest webSocketRequest, final IWebSocketListener iWebSocketListener) {
        q.j(webSocketRequest, "request");
        q.j(iWebSocketListener, "listener");
        final WebSocketTask webSocketTask = new WebSocketTask(createWebSocketClientImpl());
        webSocketTask.connect(webSocketRequest, new IWebSocketListener(webSocketTask) { // from class: com.baidu.searchbox.websocket.WebSocketManager$connect$1
            private final /* synthetic */ IWebSocketListener $$delegate_0;
            final /* synthetic */ WebSocketTask $task;

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onMessage(String str) {
                q.j(str, "message");
                this.$$delegate_0.onMessage(str);
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onMessage(ByteBuffer byteBuffer) {
                q.j(byteBuffer, "data");
                this.$$delegate_0.onMessage(byteBuffer);
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onOpen(Map<String, String> map) {
                q.j(map, "headers");
                this.$$delegate_0.onOpen(map);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$task = webSocketTask;
                this.$$delegate_0 = IWebSocketListener.this;
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onClose(JSONObject jSONObject) {
                HashMap hashMap;
                IWebSocketListener.this.onClose(jSONObject);
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                hashMap = WebSocketManager.mTasks;
                hashMap.remove(this.$task.getTaskId());
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onError(Throwable th, JSONObject jSONObject) {
                HashMap hashMap;
                q.j(th, "t");
                IWebSocketListener.this.onError(th, jSONObject);
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                hashMap = WebSocketManager.mTasks;
                hashMap.remove(this.$task.getTaskId());
            }
        });
        mTasks.put(webSocketTask.getTaskId(), webSocketTask);
        return webSocketTask;
    }

    private final IWebSocketClient createWebSocketClientImpl() {
        return new JavaWebSockeClientImpl();
    }

    public final void send(String str, String str2) {
        q.j(str, "taskId");
        q.j(str2, "message");
        WebSocketTask webSocketTask = mTasks.get(str);
        if (webSocketTask == null) {
            throw new IllegalStateException("The specified Task was not found, taskId = " + str);
        }
        webSocketTask.send(str2);
    }

    public final void send(String str, ByteBuffer byteBuffer) {
        q.j(str, "taskId");
        q.j(byteBuffer, "data");
        WebSocketTask webSocketTask = mTasks.get(str);
        if (webSocketTask == null) {
            throw new IllegalStateException("The specified Task was not found, taskId = " + str);
        }
        webSocketTask.send(byteBuffer);
    }

    public final void close(String str, int i, String str2) {
        q.j(str, "taskId");
        q.j(str2, TiebaInitialize.LogFields.REASON);
        HashMap<String, WebSocketTask> hashMap = mTasks;
        if (hashMap.containsKey(str)) {
            WebSocketTask webSocketTask = hashMap.get(str);
            if (webSocketTask != null) {
                webSocketTask.close(i, str2);
            }
            hashMap.remove(str);
            return;
        }
        throw new IllegalStateException("The specified Task was not found, taskId = " + str);
    }
}
