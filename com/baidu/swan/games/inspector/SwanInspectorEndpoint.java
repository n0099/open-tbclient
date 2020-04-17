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
/* loaded from: classes11.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint cOd = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a cNF;
    private String cOf;
    private String cOg;
    private a.C0367a cOj;
    private Runnable cOl;
    private Throwable cOo;
    private int cOp;
    private WebSocketTask cOq;
    private InspectorNativeChannel cOt;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bJy = new LinkedBlockingQueue<>();
    private boolean cOh = false;
    private boolean cOi = false;
    private boolean cOk = false;
    private ConnectionState cOm = ConnectionState.CLOSED;
    private ConnectionState cOn = ConnectionState.CLOSED;
    private int cOr = 0;
    private long cOs = 0;
    private String cOe = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes11.dex */
    private static class a {
        private String cOu;
        private JSONObject cOv;

        public a(String str) {
            this.cOu = str;
        }

        public boolean awW() {
            return "Debugger.enable".equals(bJ(awY()));
        }

        public boolean awX() {
            String bJ = bJ(awY());
            return bJ != null && bJ.indexOf("Debugger.") == 0;
        }

        private JSONObject awY() {
            if (this.cOv == null) {
                this.cOv = qs(this.cOu);
            }
            return this.cOv;
        }

        private JSONObject qs(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String bJ(JSONObject jSONObject) {
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
    /* loaded from: classes11.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.cOq.send(str);
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
                SwanInspectorEndpoint.this.cOk = true;
                return (String) SwanInspectorEndpoint.this.bJy.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c implements IWebSocketListener {
        private int cOx;

        public c(int i) {
            this.cOx = -1;
            this.cOx = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.cOx == SwanInspectorEndpoint.this.cOr) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.cOg);
                }
                SwanInspectorEndpoint.this.cOm = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.cOx == SwanInspectorEndpoint.this.cOr) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.cOg);
                }
                SwanInspectorEndpoint.this.cOm = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.as(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.cOx == SwanInspectorEndpoint.this.cOr) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.cOn != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.cOi || !aVar.awX()) {
                    SwanInspectorEndpoint.this.bJy.offer(str);
                    SwanInspectorEndpoint.this.cNF.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.cOk = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bJy.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bJy.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.cOl != null && aVar.awW()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.cOl;
                        SwanInspectorEndpoint.this.cOl = null;
                        SwanInspectorEndpoint.this.cNF.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.cOx == SwanInspectorEndpoint.this.cOr) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.cOo = th;
            }
        }
    }

    public static SwanInspectorEndpoint awV() {
        return cOd;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0367a c0367a, Runnable runnable) {
        as(false);
        a(c0367a);
        try {
            u(aVar2);
            if (aVar.awQ()) {
                this.cOl = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            as(true);
        }
    }

    public void a(a.C0367a c0367a) {
        this.cOj = c0367a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.cOm = ConnectionState.CONNECTING;
        this.cOf = aVar.awR();
        this.cOi = aVar.awS();
        this.cOh = aVar.awQ();
        this.cOg = "ws://" + this.cOf + "/inspect/inspectorTarget/" + this.cOe;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.cOg);
        }
        this.cOs = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.cOg);
        int i = this.cOr + 1;
        this.cOr = i;
        this.cOq = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.e.a aVar) throws Exception {
        this.cOn = ConnectionState.CONNECTING;
        if (this.cOp == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.cNF = aVar;
        this.cOp = this.cNF.hashCode();
        this.cOt = new b();
        this.mInspectorNativeClient = this.cNF.initInspector(this.cOt);
        this.cOn = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0367a c0367a = this.cOj;
        if (c0367a == null) {
            c0367a = a.C0367a.awT();
        }
        sb.append(c0367a.awU()).append("\n");
        if (!c0367a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.cOm == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.cOo != null || (this.cOm == ConnectionState.CONNECTING && currentTimeMillis - this.cOs > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.cOm == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.cOf).append("\n");
        if (this.cOm == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.cOl != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.cOk) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.cOh) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(boolean z) {
        if (this.cOq != null && this.cOm != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.cOg);
            }
            try {
                this.cOq.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.cOq = null;
        this.cOs = 0L;
        this.cOm = ConnectionState.CLOSED;
        this.cNF = null;
        this.cOt = null;
        this.mInspectorNativeClient = null;
        this.cOn = ConnectionState.CLOSED;
        this.cOl = null;
        this.bJy.clear();
        if (!z) {
            this.cOk = false;
            this.cOo = null;
            this.cOf = null;
            this.cOg = null;
            this.cOh = false;
            this.cOi = false;
            this.cOj = null;
        }
    }

    public void close() {
        as(false);
    }
}
