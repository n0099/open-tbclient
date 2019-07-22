package com.baidu.swan.games.inspector;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.inspector.a;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint bil = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a bhC;
    private InspectorNativeChannel biC;
    private String bio;
    private String bip;
    private a.C0200a bis;
    private Runnable biu;
    private Throwable bix;
    private int biy;
    private WebSocketTask biz;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bin = new LinkedBlockingQueue<>();
    private boolean biq = false;
    private boolean bir = false;
    private boolean bit = false;
    private ConnectionState biv = ConnectionState.CLOSED;
    private ConnectionState biw = ConnectionState.CLOSED;
    private int biA = 0;
    private long biB = 0;
    private String bim = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes2.dex */
    private static class a {
        private String biD;
        private JSONObject biE;

        public a(String str) {
            this.biD = str;
        }

        public boolean St() {
            return "Debugger.enable".equals(as(Sv()));
        }

        public boolean Su() {
            String as = as(Sv());
            return as != null && as.indexOf("Debugger.") == 0;
        }

        private JSONObject Sv() {
            if (this.biE == null) {
                this.biE = jC(this.biD);
            }
            return this.biE;
        }

        private JSONObject jC(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String as(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return jSONObject.getString("method");
            } catch (JSONException e) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.biz.send(str);
            } catch (Exception e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Inspector WS send error", e);
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            if (SwanInspectorEndpoint.DEBUG) {
                Log.d("SwanInspector", "getInspectorMessage");
            }
            try {
                SwanInspectorEndpoint.this.bit = true;
                return (String) SwanInspectorEndpoint.this.bin.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements IWebSocketListener {
        private int biG;

        public c(int i) {
            this.biG = -1;
            this.biG = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.biG == SwanInspectorEndpoint.this.biA) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.bip);
                }
                SwanInspectorEndpoint.this.biv = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.biG == SwanInspectorEndpoint.this.biA) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.bip);
                }
                SwanInspectorEndpoint.this.biv = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.ak(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.biG == SwanInspectorEndpoint.this.biA) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.biw != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.bir || !aVar.Su()) {
                    SwanInspectorEndpoint.this.bin.offer(str);
                    SwanInspectorEndpoint.this.bhC.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.bit = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bin.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bin.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.biu != null && aVar.St()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.biu;
                        SwanInspectorEndpoint.this.biu = null;
                        SwanInspectorEndpoint.this.bhC.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SwanInspectorEndpoint.DEBUG) {
                                    Log.i("SwanInspector", "breakOnStart: scheduleBreak and run main JS.");
                                }
                                SwanInspectorEndpoint.this.mInspectorNativeClient.scheduleBreak();
                                runnable.run();
                            }
                        });
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            if (SwanInspectorEndpoint.DEBUG) {
                Log.d("SwanInspector", "onMessag with array buffer is not supported.");
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            if (this.biG == SwanInspectorEndpoint.this.biA) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.bix = th;
            }
        }
    }

    public static SwanInspectorEndpoint Ss() {
        return bil;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0200a c0200a, Runnable runnable) {
        ak(false);
        a(c0200a);
        try {
            x(aVar2);
            if (aVar.Sn()) {
                this.biu = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            ak(true);
        }
    }

    public void a(a.C0200a c0200a) {
        this.bis = c0200a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.biv = ConnectionState.CONNECTING;
        this.bio = aVar.So();
        this.bir = aVar.Sp();
        this.biq = aVar.Sn();
        this.bip = "ws://" + this.bio + "/inspect/inspectorTarget/" + this.bim;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.bip);
        }
        this.biB = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.bip);
        int i = this.biA + 1;
        this.biA = i;
        this.biz = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void x(com.baidu.swan.games.e.a aVar) throws Exception {
        this.biw = ConnectionState.CONNECTING;
        if (this.biy == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.bhC = aVar;
        this.biy = this.bhC.hashCode();
        this.biC = new b();
        this.mInspectorNativeClient = this.bhC.initInspector(this.biC);
        this.biw = ConnectionState.OPEN;
    }

    public String b(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0200a c0200a = this.bis;
        if (c0200a == null) {
            c0200a = a.C0200a.Sq();
        }
        sb.append(c0200a.Sr()).append("\n");
        if (!c0200a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.biv == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.bix != null || (this.biv == ConnectionState.CONNECTING && currentTimeMillis - this.biB > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.biv == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.bio).append("\n");
        if (this.biv == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.biu != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.bit) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.biq) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(boolean z) {
        if (this.biz != null && this.biv != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.bip);
            }
            try {
                this.biz.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.biz = null;
        this.biB = 0L;
        this.biv = ConnectionState.CLOSED;
        this.bhC = null;
        this.biC = null;
        this.mInspectorNativeClient = null;
        this.biw = ConnectionState.CLOSED;
        this.biu = null;
        this.bin.clear();
        if (!z) {
            this.bit = false;
            this.bix = null;
            this.bio = null;
            this.bip = null;
            this.biq = false;
            this.bir = false;
            this.bis = null;
        }
    }

    public void close() {
        ak(false);
    }
}
