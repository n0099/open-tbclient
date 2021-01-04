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
    private static SwanInspectorEndpoint eko = new SwanInspectorEndpoint();
    private com.baidu.swan.games.f.a ejQ;
    private int ekA;
    private WebSocketTask ekB;
    private InspectorNativeChannel ekE;
    private String ekq;
    private String ekr;
    private a.C0535a eku;
    private Runnable ekw;
    private Throwable ekz;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cQK = new LinkedBlockingQueue<>();
    private boolean eks = false;
    private boolean ekt = false;
    private boolean ekv = false;
    private ConnectionState ekx = ConnectionState.CLOSED;
    private ConnectionState eky = ConnectionState.CLOSED;
    private int ekC = 0;
    private long ekD = 0;
    private String ekp = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes9.dex */
    private static class a {
        private String ekF;
        private JSONObject ekG;

        public a(String str) {
            this.ekF = str;
        }

        public boolean baS() {
            return "Debugger.enable".equals(cA(baU()));
        }

        public boolean baT() {
            String cA = cA(baU());
            return cA != null && cA.indexOf("Debugger.") == 0;
        }

        private JSONObject baU() {
            if (this.ekG == null) {
                this.ekG = xG(this.ekF);
            }
            return this.ekG;
        }

        private JSONObject xG(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cA(JSONObject jSONObject) {
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
                SwanInspectorEndpoint.this.ekB.send(str);
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
                SwanInspectorEndpoint.this.ekv = true;
                return (String) SwanInspectorEndpoint.this.cQK.take();
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
        private int ekI;

        public c(int i) {
            this.ekI = -1;
            this.ekI = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.ekI == SwanInspectorEndpoint.this.ekC) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.ekr);
                }
                SwanInspectorEndpoint.this.ekx = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.ekI == SwanInspectorEndpoint.this.ekC) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.ekr);
                }
                SwanInspectorEndpoint.this.ekx = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.au(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.ekI == SwanInspectorEndpoint.this.ekC) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.eky != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.ekt || !aVar.baT()) {
                    SwanInspectorEndpoint.this.cQK.offer(str);
                    SwanInspectorEndpoint.this.ejQ.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.ekv = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cQK.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cQK.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.ekw != null && aVar.baS()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.ekw;
                        SwanInspectorEndpoint.this.ekw = null;
                        SwanInspectorEndpoint.this.ejQ.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.ekI == SwanInspectorEndpoint.this.ekC) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.ekz = th;
            }
        }
    }

    public static SwanInspectorEndpoint baR() {
        return eko;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0535a c0535a, Runnable runnable) {
        au(false);
        a(c0535a);
        try {
            u(aVar2);
            if (aVar.baM()) {
                this.ekw = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            au(true);
        }
    }

    public void a(a.C0535a c0535a) {
        this.eku = c0535a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.ekx = ConnectionState.CONNECTING;
        this.ekq = aVar.baN();
        this.ekt = aVar.baO();
        this.eks = aVar.baM();
        this.ekr = "ws://" + this.ekq + "/inspect/inspectorTarget/" + this.ekp;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.ekr);
        }
        this.ekD = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.ekr);
        int i = this.ekC + 1;
        this.ekC = i;
        this.ekB = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.eky = ConnectionState.CONNECTING;
        if (this.ekA == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.ejQ = aVar;
        this.ekA = this.ejQ.hashCode();
        this.ekE = new b();
        this.mInspectorNativeClient = this.ejQ.initInspector(this.ekE);
        this.eky = ConnectionState.OPEN;
    }

    public String g(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0535a c0535a = this.eku;
        if (c0535a == null) {
            c0535a = a.C0535a.baP();
        }
        sb.append(c0535a.baQ()).append("\n");
        if (!c0535a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.ekx == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.ekz != null || (this.ekx == ConnectionState.CONNECTING && currentTimeMillis - this.ekD > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.ekx == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.ekq).append("\n");
        if (this.ekx == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.ekw != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.ekv) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.eks) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(boolean z) {
        if (this.ekB != null && this.ekx != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.ekr);
            }
            try {
                this.ekB.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.ekB = null;
        this.ekD = 0L;
        this.ekx = ConnectionState.CLOSED;
        this.ejQ = null;
        this.ekE = null;
        this.mInspectorNativeClient = null;
        this.eky = ConnectionState.CLOSED;
        this.ekw = null;
        this.cQK.clear();
        if (!z) {
            this.ekv = false;
            this.ekz = null;
            this.ekq = null;
            this.ekr = null;
            this.eks = false;
            this.ekt = false;
            this.eku = null;
        }
    }

    public void close() {
        au(false);
    }
}
