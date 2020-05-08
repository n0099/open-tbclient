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
    private static SwanInspectorEndpoint cOi = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a cNK;
    private String cOk;
    private String cOl;
    private a.C0388a cOo;
    private Runnable cOq;
    private Throwable cOt;
    private int cOu;
    private WebSocketTask cOv;
    private InspectorNativeChannel cOy;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bJD = new LinkedBlockingQueue<>();
    private boolean cOm = false;
    private boolean cOn = false;
    private boolean cOp = false;
    private ConnectionState cOr = ConnectionState.CLOSED;
    private ConnectionState cOs = ConnectionState.CLOSED;
    private int cOw = 0;
    private long cOx = 0;
    private String cOj = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes11.dex */
    private static class a {
        private JSONObject cOA;
        private String cOz;

        public a(String str) {
            this.cOz = str;
        }

        public boolean awW() {
            return "Debugger.enable".equals(bJ(awY()));
        }

        public boolean awX() {
            String bJ = bJ(awY());
            return bJ != null && bJ.indexOf("Debugger.") == 0;
        }

        private JSONObject awY() {
            if (this.cOA == null) {
                this.cOA = qs(this.cOz);
            }
            return this.cOA;
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
                SwanInspectorEndpoint.this.cOv.send(str);
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
                SwanInspectorEndpoint.this.cOp = true;
                return (String) SwanInspectorEndpoint.this.bJD.take();
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
        private int cOC;

        public c(int i) {
            this.cOC = -1;
            this.cOC = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.cOC == SwanInspectorEndpoint.this.cOw) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.cOl);
                }
                SwanInspectorEndpoint.this.cOr = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.cOC == SwanInspectorEndpoint.this.cOw) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.cOl);
                }
                SwanInspectorEndpoint.this.cOr = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.as(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.cOC == SwanInspectorEndpoint.this.cOw) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.cOs != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.cOn || !aVar.awX()) {
                    SwanInspectorEndpoint.this.bJD.offer(str);
                    SwanInspectorEndpoint.this.cNK.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.cOp = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bJD.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bJD.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.cOq != null && aVar.awW()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.cOq;
                        SwanInspectorEndpoint.this.cOq = null;
                        SwanInspectorEndpoint.this.cNK.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.cOC == SwanInspectorEndpoint.this.cOw) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.cOt = th;
            }
        }
    }

    public static SwanInspectorEndpoint awV() {
        return cOi;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0388a c0388a, Runnable runnable) {
        as(false);
        a(c0388a);
        try {
            u(aVar2);
            if (aVar.awQ()) {
                this.cOq = runnable;
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

    public void a(a.C0388a c0388a) {
        this.cOo = c0388a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.cOr = ConnectionState.CONNECTING;
        this.cOk = aVar.awR();
        this.cOn = aVar.awS();
        this.cOm = aVar.awQ();
        this.cOl = "ws://" + this.cOk + "/inspect/inspectorTarget/" + this.cOj;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.cOl);
        }
        this.cOx = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.cOl);
        int i = this.cOw + 1;
        this.cOw = i;
        this.cOv = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.e.a aVar) throws Exception {
        this.cOs = ConnectionState.CONNECTING;
        if (this.cOu == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.cNK = aVar;
        this.cOu = this.cNK.hashCode();
        this.cOy = new b();
        this.mInspectorNativeClient = this.cNK.initInspector(this.cOy);
        this.cOs = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0388a c0388a = this.cOo;
        if (c0388a == null) {
            c0388a = a.C0388a.awT();
        }
        sb.append(c0388a.awU()).append("\n");
        if (!c0388a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.cOr == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.cOt != null || (this.cOr == ConnectionState.CONNECTING && currentTimeMillis - this.cOx > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.cOr == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.cOk).append("\n");
        if (this.cOr == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.cOq != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.cOp) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.cOm) {
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
        if (this.cOv != null && this.cOr != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.cOl);
            }
            try {
                this.cOv.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.cOv = null;
        this.cOx = 0L;
        this.cOr = ConnectionState.CLOSED;
        this.cNK = null;
        this.cOy = null;
        this.mInspectorNativeClient = null;
        this.cOs = ConnectionState.CLOSED;
        this.cOq = null;
        this.bJD.clear();
        if (!z) {
            this.cOp = false;
            this.cOt = null;
            this.cOk = null;
            this.cOl = null;
            this.cOm = false;
            this.cOn = false;
            this.cOo = null;
        }
    }

    public void close() {
        as(false);
    }
}
