package com.baidu.searchbox.websocket;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.n;
import kotlin.e;
import kotlin.jvm.internal.p;
import org.java_websocket.a.a;
import org.java_websocket.c.h;
import org.java_websocket.d.b;
import org.json.JSONObject;
@e
/* loaded from: classes5.dex */
public final class JavaWebSockeClientImpl implements IWebSocketClient {
    private a webSocketClient;

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void connect(WebSocketRequest webSocketRequest, IWebSocketListener iWebSocketListener) {
        JavaWebSockeClientImpl$connect$1 javaWebSockeClientImpl$connect$1;
        org.java_websocket.drafts.a aVar;
        ArrayList bS;
        org.java_websocket.drafts.a aVar2;
        org.java_websocket.drafts.a aVar3;
        final WebSocketRequest webSocketRequest2;
        final IWebSocketListener iWebSocketListener2;
        a aVar4;
        JavaWebSockeClientImpl$connect$1 javaWebSockeClientImpl$connect$12;
        JavaWebSockeClientImpl javaWebSockeClientImpl;
        p.o(webSocketRequest, "request");
        p.o(iWebSocketListener, "listener");
        final URI create = URI.create(webSocketRequest.getUrl());
        List eLe = n.eLe();
        List<String> protocols = webSocketRequest.getProtocols();
        if (protocols == null) {
            bS = n.bS(new b(""));
            aVar2 = aVar;
            aVar3 = aVar;
            webSocketRequest2 = webSocketRequest;
            iWebSocketListener2 = iWebSocketListener;
            aVar4 = javaWebSockeClientImpl$connect$1;
            javaWebSockeClientImpl$connect$12 = javaWebSockeClientImpl$connect$1;
            javaWebSockeClientImpl = this;
        } else {
            List<String> list = protocols;
            ArrayList arrayList = new ArrayList(n.a(list, 10));
            for (String str : list) {
                arrayList.add(new b(str));
            }
            bS = arrayList;
            aVar2 = aVar;
            aVar3 = aVar;
            webSocketRequest2 = webSocketRequest;
            iWebSocketListener2 = iWebSocketListener;
            aVar4 = javaWebSockeClientImpl$connect$1;
            javaWebSockeClientImpl$connect$12 = javaWebSockeClientImpl$connect$1;
            javaWebSockeClientImpl = this;
        }
        new org.java_websocket.drafts.a(eLe, bS);
        final org.java_websocket.drafts.a aVar5 = aVar3;
        final Map<String, String> headers = webSocketRequest.getHeaders();
        new a(create, aVar5, headers) { // from class: com.baidu.searchbox.websocket.JavaWebSockeClientImpl$connect$1
            @Override // org.java_websocket.a.a
            public void onOpen(h hVar) {
                Iterator<String> eMx;
                HashMap hashMap = new HashMap();
                if (hVar != null && (eMx = hVar.eMx()) != null) {
                    while (eMx.hasNext()) {
                        String next = eMx.next();
                        hashMap.put(next, hVar.acE(next));
                    }
                }
                IWebSocketListener.this.onOpen(hashMap);
            }

            @Override // org.java_websocket.a.a
            public void onClose(int i, String str2, boolean z) {
                IWebSocketListener iWebSocketListener3 = IWebSocketListener.this;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", i);
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put(TiebaInitialize.LogFields.REASON, str2);
                iWebSocketListener3.onClose(jSONObject);
            }

            @Override // org.java_websocket.a.a
            public void onMessage(String str2) {
                p.o(str2, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
                IWebSocketListener.this.onMessage(str2);
            }

            @Override // org.java_websocket.a.a
            public void onMessage(ByteBuffer byteBuffer) {
                p.o(byteBuffer, "bytes");
                IWebSocketListener.this.onMessage(byteBuffer);
            }

            @Override // org.java_websocket.a.a
            public void onError(Exception exc) {
                p.o(exc, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
                IWebSocketListener.this.onError(exc, null);
            }
        };
        javaWebSockeClientImpl.webSocketClient = javaWebSockeClientImpl$connect$12;
        Integer connectionLostTimeout = webSocketRequest.getConnectionLostTimeout();
        if (connectionLostTimeout != null) {
            int intValue = connectionLostTimeout.intValue();
            a aVar6 = this.webSocketClient;
            if (aVar6 == null) {
                p.acs("webSocketClient");
            }
            aVar6.setConnectionLostTimeout(intValue);
        }
        a aVar7 = this.webSocketClient;
        if (aVar7 == null) {
            p.acs("webSocketClient");
        }
        aVar7.connect();
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void close(int i, String str) {
        p.o(str, TiebaInitialize.LogFields.REASON);
        a aVar = this.webSocketClient;
        if (aVar == null) {
            p.acs("webSocketClient");
        }
        aVar.close();
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(String str) {
        p.o(str, "message");
        a aVar = this.webSocketClient;
        if (aVar == null) {
            p.acs("webSocketClient");
        }
        aVar.send(str);
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(ByteBuffer byteBuffer) {
        p.o(byteBuffer, "data");
        a aVar = this.webSocketClient;
        if (aVar == null) {
            p.acs("webSocketClient");
        }
        aVar.send(byteBuffer);
    }
}
