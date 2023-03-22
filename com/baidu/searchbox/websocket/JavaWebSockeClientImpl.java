package com.baidu.searchbox.websocket;

import com.baidu.tieba.era;
import com.baidu.tieba.hra;
import com.baidu.tieba.kqa;
import com.baidu.tieba.lqa;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.framework.common.ExceptionCode;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/websocket/JavaWebSockeClientImpl;", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "", "code", "", "reason", "", "close", "(ILjava/lang/String;)V", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "request", "Lcom/baidu/searchbox/websocket/IWebSocketListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, ExceptionCode.CONNECT, "(Lcom/baidu/searchbox/websocket/WebSocketRequest;Lcom/baidu/searchbox/websocket/IWebSocketListener;)V", "Ljava/nio/ByteBuffer;", "data", "send", "(Ljava/nio/ByteBuffer;)V", "message", "(Ljava/lang/String;)V", "Lorg/java_websocket/client/WebSocketClient;", "webSocketClient", "Lorg/java_websocket/client/WebSocketClient;", "<init>", "()V", "websocket_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class JavaWebSockeClientImpl implements IWebSocketClient {
    public kqa webSocketClient;

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void close(int i, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        kqa kqaVar = this.webSocketClient;
        if (kqaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
        }
        kqaVar.close();
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void connect(final WebSocketRequest request, final IWebSocketListener listener) {
        List listOf;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final URI create = URI.create(request.getUrl());
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        List<String> protocols = request.getProtocols();
        if (protocols != null) {
            listOf = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(protocols, 10));
            for (String str : protocols) {
                listOf.add(new hra(str));
            }
        } else {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new hra(""));
        }
        final lqa lqaVar = new lqa(emptyList, listOf);
        final Map<String, String> headers = request.getHeaders();
        this.webSocketClient = new kqa(create, lqaVar, headers) { // from class: com.baidu.searchbox.websocket.JavaWebSockeClientImpl$connect$1
            @Override // com.baidu.tieba.kqa
            public void onClose(int i, String str2, boolean z) {
                IWebSocketListener iWebSocketListener = IWebSocketListener.this;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", i);
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("reason", str2);
                Unit unit = Unit.INSTANCE;
                iWebSocketListener.onClose(jSONObject);
            }

            @Override // com.baidu.tieba.kqa
            public void onError(Exception p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                IWebSocketListener.this.onError(p0, null);
            }

            @Override // com.baidu.tieba.kqa
            public void onMessage(String p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                IWebSocketListener.this.onMessage(p0);
            }

            @Override // com.baidu.tieba.kqa
            public void onOpen(era eraVar) {
                Iterator<String> g;
                HashMap hashMap = new HashMap();
                if (eraVar != null && (g = eraVar.g()) != null) {
                    while (g.hasNext()) {
                        String next = g.next();
                        hashMap.put(next, eraVar.d(next));
                    }
                }
                IWebSocketListener.this.onOpen(hashMap);
            }

            @Override // com.baidu.tieba.kqa
            public void onMessage(ByteBuffer bytes) {
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                IWebSocketListener.this.onMessage(bytes);
            }
        };
        Integer connectionLostTimeout = request.getConnectionLostTimeout();
        if (connectionLostTimeout != null) {
            int intValue = connectionLostTimeout.intValue();
            kqa kqaVar = this.webSocketClient;
            if (kqaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
            }
            kqaVar.setConnectionLostTimeout(intValue);
        }
        kqa kqaVar2 = this.webSocketClient;
        if (kqaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
        }
        kqaVar2.connect();
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        kqa kqaVar = this.webSocketClient;
        if (kqaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
        }
        kqaVar.send(message);
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(ByteBuffer data) {
        Intrinsics.checkNotNullParameter(data, "data");
        kqa kqaVar = this.webSocketClient;
        if (kqaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webSocketClient");
        }
        kqaVar.send(data);
    }
}
