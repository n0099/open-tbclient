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
/* loaded from: classes9.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint ckC = new SwanInspectorEndpoint();
    private String ckE;
    private String ckF;
    private a.C0325a ckI;
    private Runnable ckK;
    private Throwable ckN;
    private int ckO;
    private WebSocketTask ckP;
    private InspectorNativeChannel ckS;
    private com.baidu.swan.games.e.a cke;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bfZ = new LinkedBlockingQueue<>();
    private boolean ckG = false;
    private boolean ckH = false;
    private boolean ckJ = false;
    private ConnectionState ckL = ConnectionState.CLOSED;
    private ConnectionState ckM = ConnectionState.CLOSED;
    private int ckQ = 0;
    private long ckR = 0;
    private String ckD = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes9.dex */
    private static class a {
        private String ckT;
        private JSONObject ckU;

        public a(String str) {
            this.ckT = str;
        }

        public boolean alY() {
            return "Debugger.enable".equals(by(ama()));
        }

        public boolean alZ() {
            String by = by(ama());
            return by != null && by.indexOf("Debugger.") == 0;
        }

        private JSONObject ama() {
            if (this.ckU == null) {
                this.ckU = oO(this.ckT);
            }
            return this.ckU;
        }

        private JSONObject oO(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String by(JSONObject jSONObject) {
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
    /* loaded from: classes9.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.ckP.send(str);
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
                SwanInspectorEndpoint.this.ckJ = true;
                return (String) SwanInspectorEndpoint.this.bfZ.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c implements IWebSocketListener {
        private int ckW;

        public c(int i) {
            this.ckW = -1;
            this.ckW = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.ckW == SwanInspectorEndpoint.this.ckQ) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.ckF);
                }
                SwanInspectorEndpoint.this.ckL = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.ckW == SwanInspectorEndpoint.this.ckQ) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.ckF);
                }
                SwanInspectorEndpoint.this.ckL = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.Q(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.ckW == SwanInspectorEndpoint.this.ckQ) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.ckM != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.ckH || !aVar.alZ()) {
                    SwanInspectorEndpoint.this.bfZ.offer(str);
                    SwanInspectorEndpoint.this.cke.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.ckJ = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bfZ.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bfZ.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.ckK != null && aVar.alY()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.ckK;
                        SwanInspectorEndpoint.this.ckK = null;
                        SwanInspectorEndpoint.this.cke.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.ckW == SwanInspectorEndpoint.this.ckQ) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.ckN = th;
            }
        }
    }

    public static SwanInspectorEndpoint alX() {
        return ckC;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0325a c0325a, Runnable runnable) {
        Q(false);
        a(c0325a);
        try {
            u(aVar2);
            if (aVar.alS()) {
                this.ckK = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            Q(true);
        }
    }

    public void a(a.C0325a c0325a) {
        this.ckI = c0325a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.ckL = ConnectionState.CONNECTING;
        this.ckE = aVar.alT();
        this.ckH = aVar.alU();
        this.ckG = aVar.alS();
        this.ckF = "ws://" + this.ckE + "/inspect/inspectorTarget/" + this.ckD;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.ckF);
        }
        this.ckR = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.ckF);
        int i = this.ckQ + 1;
        this.ckQ = i;
        this.ckP = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.e.a aVar) throws Exception {
        this.ckM = ConnectionState.CONNECTING;
        if (this.ckO == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.cke = aVar;
        this.ckO = this.cke.hashCode();
        this.ckS = new b();
        this.mInspectorNativeClient = this.cke.initInspector(this.ckS);
        this.ckM = ConnectionState.OPEN;
    }

    public String c(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0325a c0325a = this.ckI;
        if (c0325a == null) {
            c0325a = a.C0325a.alV();
        }
        sb.append(c0325a.alW()).append("\n");
        if (!c0325a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.ckL == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.ckN != null || (this.ckL == ConnectionState.CONNECTING && currentTimeMillis - this.ckR > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.ckL == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.ckE).append("\n");
        if (this.ckL == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.ckK != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.ckJ) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.ckG) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z) {
        if (this.ckP != null && this.ckL != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.ckF);
            }
            try {
                this.ckP.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.ckP = null;
        this.ckR = 0L;
        this.ckL = ConnectionState.CLOSED;
        this.cke = null;
        this.ckS = null;
        this.mInspectorNativeClient = null;
        this.ckM = ConnectionState.CLOSED;
        this.ckK = null;
        this.bfZ.clear();
        if (!z) {
            this.ckJ = false;
            this.ckN = null;
            this.ckE = null;
            this.ckF = null;
            this.ckG = false;
            this.ckH = false;
            this.ckI = null;
        }
    }

    public void close() {
        Q(false);
    }
}
