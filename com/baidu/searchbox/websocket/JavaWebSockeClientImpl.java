package com.baidu.searchbox.websocket;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import g.c.e.a;
import g.c.i.h;
import g.c.j.b;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/websocket/JavaWebSockeClientImpl;", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "", "code", "", "reason", "", IntentConfig.CLOSE, "(ILjava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "request", "Lcom/baidu/searchbox/websocket/IWebSocketListener;", "listener", "connect", "(Lcom/baidu/searchbox/websocket/WebSocketRequest;Lcom/baidu/searchbox/websocket/IWebSocketListener;)V", "Ljava/nio/ByteBuffer;", "data", "send", "(Ljava/nio/ByteBuffer;)V", "message", "(Ljava/lang/String;)V", "Lorg/java_websocket/client/WebSocketClient;", "webSocketClient", "Lorg/java_websocket/client/WebSocketClient;", "<init>", "()V", "lib-websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class JavaWebSockeClientImpl implements IWebSocketClient {
    public a webSocketClient;

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void close(int i, String str) {
        a aVar = this.webSocketClient;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
        }
        aVar.close();
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void connect(final WebSocketRequest webSocketRequest, final IWebSocketListener iWebSocketListener) {
        List listOf;
        final URI create = URI.create(webSocketRequest.getUrl());
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        List<String> protocols = webSocketRequest.getProtocols();
        if (protocols != null) {
            listOf = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(protocols, 10));
            for (String str : protocols) {
                listOf.add(new b(str));
            }
        } else {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new b(""));
        }
        final g.c.f.a aVar = new g.c.f.a(emptyList, listOf);
        final Map<String, String> headers = webSocketRequest.getHeaders();
        this.webSocketClient = new a(create, aVar, headers) { // from class: com.baidu.searchbox.websocket.JavaWebSockeClientImpl$connect$1
            @Override // g.c.e.a
            public void onClose(int i, String str2, boolean z) {
                IWebSocketListener iWebSocketListener2 = IWebSocketListener.this;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", i);
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("reason", str2);
                iWebSocketListener2.onClose(jSONObject);
            }

            @Override // g.c.e.a
            public void onError(Exception exc) {
                IWebSocketListener.this.onError(exc, null);
            }

            @Override // g.c.e.a
            public void onMessage(String str2) {
                IWebSocketListener.this.onMessage(str2);
            }

            @Override // g.c.e.a
            public void onOpen(h hVar) {
                Iterator<String> e2;
                HashMap hashMap = new HashMap();
                if (hVar != null && (e2 = hVar.e()) != null) {
                    while (e2.hasNext()) {
                        String next = e2.next();
                        hashMap.put(next, hVar.i(next));
                    }
                }
                IWebSocketListener.this.onOpen(hashMap);
            }

            @Override // g.c.e.a
            public void onMessage(ByteBuffer byteBuffer) {
                IWebSocketListener.this.onMessage(byteBuffer);
            }
        };
        Integer connectionLostTimeout = webSocketRequest.getConnectionLostTimeout();
        if (connectionLostTimeout != null) {
            int intValue = connectionLostTimeout.intValue();
            a aVar2 = this.webSocketClient;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
            }
            aVar2.setConnectionLostTimeout(intValue);
        }
        a aVar3 = this.webSocketClient;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
        }
        aVar3.connect();
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(String str) {
        a aVar = this.webSocketClient;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
        }
        aVar.send(str);
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(ByteBuffer byteBuffer) {
        a aVar = this.webSocketClient;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
        }
        aVar.send(byteBuffer);
    }
}
