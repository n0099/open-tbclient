package com.baidu.searchbox.websocket;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.n;
import kotlin.jvm.internal.p;
import org.java_websocket.a.a;
import org.java_websocket.c.h;
import org.java_websocket.d.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class JavaWebSockeClientImpl implements IWebSocketClient {
    private a webSocketClient;

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void connect(WebSocketRequest webSocketRequest, IWebSocketListener iWebSocketListener) {
        JavaWebSockeClientImpl$connect$1 javaWebSockeClientImpl$connect$1;
        org.java_websocket.drafts.a aVar;
        List list;
        org.java_websocket.drafts.a aVar2;
        a aVar3;
        JavaWebSockeClientImpl$connect$1 javaWebSockeClientImpl$connect$12;
        JavaWebSockeClientImpl javaWebSockeClientImpl;
        final WebSocketRequest webSocketRequest2;
        ArrayList bd;
        final IWebSocketListener iWebSocketListener2;
        final URI uri;
        org.java_websocket.drafts.a aVar4;
        p.i(webSocketRequest, "request");
        p.i(iWebSocketListener, "listener");
        URI create = URI.create(webSocketRequest.getUrl());
        List cMH = n.cMH();
        List<String> protocols = webSocketRequest.getProtocols();
        if (protocols == null) {
            list = cMH;
            aVar2 = aVar;
            aVar3 = javaWebSockeClientImpl$connect$1;
            javaWebSockeClientImpl$connect$12 = javaWebSockeClientImpl$connect$1;
            javaWebSockeClientImpl = this;
            webSocketRequest2 = webSocketRequest;
            bd = n.bd(new b(""));
            iWebSocketListener2 = iWebSocketListener;
            uri = create;
            aVar4 = aVar;
        } else {
            List<String> list2 = protocols;
            ArrayList arrayList = new ArrayList(n.a(list2, 10));
            for (String str : list2) {
                arrayList.add(new b(str));
            }
            list = cMH;
            aVar2 = aVar;
            aVar3 = javaWebSockeClientImpl$connect$1;
            javaWebSockeClientImpl$connect$12 = javaWebSockeClientImpl$connect$1;
            javaWebSockeClientImpl = this;
            webSocketRequest2 = webSocketRequest;
            bd = arrayList;
            iWebSocketListener2 = iWebSocketListener;
            uri = create;
            aVar4 = aVar;
        }
        new org.java_websocket.drafts.a(list, bd);
        final org.java_websocket.drafts.a aVar5 = aVar4;
        final Map<String, String> headers = webSocketRequest.getHeaders();
        new a(uri, aVar5, headers) { // from class: com.baidu.searchbox.websocket.JavaWebSockeClientImpl$connect$1
            @Override // org.java_websocket.a.a
            public void onOpen(h hVar) {
                Iterator<String> cNV;
                HashMap hashMap = new HashMap();
                if (hVar != null && (cNV = hVar.cNV()) != null) {
                    while (cNV.hasNext()) {
                        String next = cNV.next();
                        hashMap.put(next, hVar.Hk(next));
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
                p.i(str2, "p0");
                IWebSocketListener.this.onMessage(str2);
            }

            @Override // org.java_websocket.a.a
            public void onMessage(ByteBuffer byteBuffer) {
                p.i(byteBuffer, "bytes");
                IWebSocketListener.this.onMessage(byteBuffer);
            }

            @Override // org.java_websocket.a.a
            public void onError(Exception exc) {
                p.i(exc, "p0");
                IWebSocketListener.this.onError(exc, null);
            }
        };
        javaWebSockeClientImpl.webSocketClient = javaWebSockeClientImpl$connect$12;
        Integer connectionLostTimeout = webSocketRequest.getConnectionLostTimeout();
        if (connectionLostTimeout != null) {
            int intValue = connectionLostTimeout.intValue();
            a aVar6 = this.webSocketClient;
            if (aVar6 == null) {
                p.GZ("webSocketClient");
            }
            aVar6.setConnectionLostTimeout(intValue);
        }
        a aVar7 = this.webSocketClient;
        if (aVar7 == null) {
            p.GZ("webSocketClient");
        }
        aVar7.connect();
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void close(int i, String str) {
        p.i(str, TiebaInitialize.LogFields.REASON);
        a aVar = this.webSocketClient;
        if (aVar == null) {
            p.GZ("webSocketClient");
        }
        aVar.close();
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(String str) {
        p.i(str, "message");
        a aVar = this.webSocketClient;
        if (aVar == null) {
            p.GZ("webSocketClient");
        }
        aVar.send(str);
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketClient
    public void send(ByteBuffer byteBuffer) {
        p.i(byteBuffer, "data");
        a aVar = this.webSocketClient;
        if (aVar == null) {
            p.GZ("webSocketClient");
        }
        aVar.send(byteBuffer);
    }
}
