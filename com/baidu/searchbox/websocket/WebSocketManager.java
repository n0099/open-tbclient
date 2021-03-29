package com.baidu.searchbox.websocket;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0018R2\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u0019j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r`\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketManager;", "", "taskId", "", "code", "reason", "", IntentConfig.CLOSE, "(Ljava/lang/String;ILjava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "request", "Lcom/baidu/searchbox/websocket/IWebSocketListener;", "listener", "Lcom/baidu/searchbox/websocket/WebSocketTask;", "connect", "(Lcom/baidu/searchbox/websocket/WebSocketRequest;Lcom/baidu/searchbox/websocket/IWebSocketListener;)Lcom/baidu/searchbox/websocket/WebSocketTask;", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "createWebSocketClientImpl", "()Lcom/baidu/searchbox/websocket/IWebSocketClient;", "Ljava/nio/ByteBuffer;", "data", "send", "(Ljava/lang/String;Ljava/nio/ByteBuffer;)V", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mTasks", "Ljava/util/HashMap;", "<init>", "()V", "lib-websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class WebSocketManager {
    public static final WebSocketManager INSTANCE = new WebSocketManager();
    public static HashMap<String, WebSocketTask> mTasks = new HashMap<>();

    private final IWebSocketClient createWebSocketClientImpl() {
        return new JavaWebSockeClientImpl();
    }

    public final void close(String str, int i, String str2) {
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

    public final WebSocketTask connect(WebSocketRequest webSocketRequest, final IWebSocketListener iWebSocketListener) {
        final WebSocketTask webSocketTask = new WebSocketTask(createWebSocketClientImpl());
        webSocketTask.connect(webSocketRequest, new IWebSocketListener(webSocketTask) { // from class: com.baidu.searchbox.websocket.WebSocketManager$connect$1
            public final /* synthetic */ IWebSocketListener $$delegate_0;
            public final /* synthetic */ WebSocketTask $task;

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
                IWebSocketListener.this.onError(th, jSONObject);
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                hashMap = WebSocketManager.mTasks;
                hashMap.remove(this.$task.getTaskId());
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
        mTasks.put(webSocketTask.getTaskId(), webSocketTask);
        return webSocketTask;
    }

    public final void send(String str, String str2) {
        WebSocketTask webSocketTask = mTasks.get(str);
        if (webSocketTask != null) {
            webSocketTask.send(str2);
            return;
        }
        throw new IllegalStateException("The specified Task was not found, taskId = " + str);
    }

    public final void send(String str, ByteBuffer byteBuffer) {
        WebSocketTask webSocketTask = mTasks.get(str);
        if (webSocketTask != null) {
            webSocketTask.send(byteBuffer);
            return;
        }
        throw new IllegalStateException("The specified Task was not found, taskId = " + str);
    }
}
