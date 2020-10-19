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
/* loaded from: classes10.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint dHM = new SwanInspectorEndpoint();
    private String dHO;
    private String dHP;
    private a.C0506a dHS;
    private Runnable dHU;
    private Throwable dHX;
    private int dHY;
    private WebSocketTask dHZ;
    private com.baidu.swan.games.f.a dHo;
    private InspectorNativeChannel dIc;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> csm = new LinkedBlockingQueue<>();
    private boolean dHQ = false;
    private boolean dHR = false;
    private boolean dHT = false;
    private ConnectionState dHV = ConnectionState.CLOSED;
    private ConnectionState dHW = ConnectionState.CLOSED;
    private int dIa = 0;
    private long dIb = 0;
    private String dHN = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes10.dex */
    private static class a {
        private String dId;
        private JSONObject dIe;

        public a(String str) {
            this.dId = str;
        }

        public boolean aRH() {
            return "Debugger.enable".equals(cn(aRJ()));
        }

        public boolean aRI() {
            String cn2 = cn(aRJ());
            return cn2 != null && cn2.indexOf("Debugger.") == 0;
        }

        private JSONObject aRJ() {
            if (this.dIe == null) {
                this.dIe = wy(this.dId);
            }
            return this.dIe;
        }

        private JSONObject wy(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cn(JSONObject jSONObject) {
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
    /* loaded from: classes10.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.dHZ.send(str);
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
                SwanInspectorEndpoint.this.dHT = true;
                return (String) SwanInspectorEndpoint.this.csm.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c implements IWebSocketListener {
        private int dIg;

        public c(int i) {
            this.dIg = -1;
            this.dIg = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.dIg == SwanInspectorEndpoint.this.dIa) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.dHP);
                }
                SwanInspectorEndpoint.this.dHV = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.dIg == SwanInspectorEndpoint.this.dIa) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.dHP);
                }
                SwanInspectorEndpoint.this.dHV = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.aw(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.dIg == SwanInspectorEndpoint.this.dIa) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.dHW != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.dHR || !aVar.aRI()) {
                    SwanInspectorEndpoint.this.csm.offer(str);
                    SwanInspectorEndpoint.this.dHo.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.dHT = false;
                            String str2 = (String) SwanInspectorEndpoint.this.csm.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.csm.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.dHU != null && aVar.aRH()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.dHU;
                        SwanInspectorEndpoint.this.dHU = null;
                        SwanInspectorEndpoint.this.dHo.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.dIg == SwanInspectorEndpoint.this.dIa) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.dHX = th;
            }
        }
    }

    public static SwanInspectorEndpoint aRG() {
        return dHM;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0506a c0506a, Runnable runnable) {
        aw(false);
        a(c0506a);
        try {
            u(aVar2);
            if (aVar.aRB()) {
                this.dHU = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            aw(true);
        }
    }

    public void a(a.C0506a c0506a) {
        this.dHS = c0506a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.dHV = ConnectionState.CONNECTING;
        this.dHO = aVar.aRC();
        this.dHR = aVar.aRD();
        this.dHQ = aVar.aRB();
        this.dHP = "ws://" + this.dHO + "/inspect/inspectorTarget/" + this.dHN;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.dHP);
        }
        this.dIb = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.dHP);
        int i = this.dIa + 1;
        this.dIa = i;
        this.dHZ = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.dHW = ConnectionState.CONNECTING;
        if (this.dHY == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.dHo = aVar;
        this.dHY = this.dHo.hashCode();
        this.dIc = new b();
        this.mInspectorNativeClient = this.dHo.initInspector(this.dIc);
        this.dHW = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0506a c0506a = this.dHS;
        if (c0506a == null) {
            c0506a = a.C0506a.aRE();
        }
        sb.append(c0506a.aRF()).append("\n");
        if (!c0506a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.dHV == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.dHX != null || (this.dHV == ConnectionState.CONNECTING && currentTimeMillis - this.dIb > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.dHV == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.dHO).append("\n");
        if (this.dHV == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.dHU != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.dHT) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.dHQ) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(boolean z) {
        if (this.dHZ != null && this.dHV != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.dHP);
            }
            try {
                this.dHZ.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.dHZ = null;
        this.dIb = 0L;
        this.dHV = ConnectionState.CLOSED;
        this.dHo = null;
        this.dIc = null;
        this.mInspectorNativeClient = null;
        this.dHW = ConnectionState.CLOSED;
        this.dHU = null;
        this.csm.clear();
        if (!z) {
            this.dHT = false;
            this.dHX = null;
            this.dHO = null;
            this.dHP = null;
            this.dHQ = false;
            this.dHR = false;
            this.dHS = null;
        }
    }

    public void close() {
        aw(false);
    }
}
