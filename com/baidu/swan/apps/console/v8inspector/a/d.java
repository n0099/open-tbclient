package com.baidu.swan.apps.console.v8inspector.a;

import android.util.Log;
import com.baidu.swan.apps.console.v8inspector.a.c;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes8.dex */
public class d {
    public static c.b a(c.a aVar) {
        if (aVar == null || aVar.headers == null || aVar.headers.size() < 1) {
            return null;
        }
        if (com.baidu.swan.apps.console.v8inspector.websocket.a.o(aVar.headers)) {
            aVar.cej = true;
            return new a(aVar);
        }
        aVar.cej = false;
        return new b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b extends c.b {
        private String cel;

        b(c.a aVar) {
            super(aVar);
        }

        @Override // com.baidu.swan.apps.console.v8inspector.a.c.b
        protected Map<String, String> aex() {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json; charset=UTF-8");
            hashMap.put("Accept-Ranges", "bytes");
            hashMap.put(HTTP.CONN_DIRECTIVE, "keep-alive");
            return hashMap;
        }

        @Override // com.baidu.swan.apps.console.v8inspector.a.c.b
        String aey() {
            return "200 OK";
        }

        @Override // com.baidu.swan.apps.console.v8inspector.a.c.b
        protected String getContent() {
            if (this.cel == null) {
                this.cel = new com.baidu.swan.apps.console.v8inspector.b().toString();
            }
            return this.cel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends c.b {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

        a(c.a aVar) {
            super(aVar);
        }

        @Override // com.baidu.swan.apps.console.v8inspector.a.c.b
        Map<String, String> aex() {
            HashMap hashMap = new HashMap();
            hashMap.put("Upgrade", "websocket");
            hashMap.put(HTTP.CONN_DIRECTIVE, "Upgrade");
            try {
                hashMap.put("Sec-WebSocket-Accept", com.baidu.swan.apps.console.v8inspector.websocket.a.kP(this.cek.headers.get("sec-websocket-key")));
            } catch (NoSuchAlgorithmException e) {
                if (DEBUG) {
                    Log.e("HandShakeResponse", "make accept key fail for error invalid algorithm", e);
                }
            }
            return hashMap;
        }

        @Override // com.baidu.swan.apps.console.v8inspector.a.c.b
        String aey() {
            return "101 Switching Protocols";
        }
    }
}
