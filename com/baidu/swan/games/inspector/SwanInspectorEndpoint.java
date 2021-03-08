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
/* loaded from: classes8.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint ejk = new SwanInspectorEndpoint();
    private com.baidu.swan.games.f.a eiM;
    private InspectorNativeChannel ejA;
    private String ejm;
    private String ejn;
    private a.C0521a ejq;
    private Runnable ejs;
    private Throwable ejv;
    private int ejw;
    private WebSocketTask ejx;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cPM = new LinkedBlockingQueue<>();
    private boolean ejo = false;
    private boolean ejp = false;
    private boolean ejr = false;
    private ConnectionState ejt = ConnectionState.CLOSED;
    private ConnectionState eju = ConnectionState.CLOSED;
    private int ejy = 0;
    private long ejz = 0;
    private String ejl = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes8.dex */
    private static class a {
        private String ejB;
        private JSONObject ejC;

        public a(String str) {
            this.ejB = str;
        }

        public boolean aXo() {
            return "Debugger.enable".equals(cz(aXq()));
        }

        public boolean aXp() {
            String cz = cz(aXq());
            return cz != null && cz.indexOf("Debugger.") == 0;
        }

        private JSONObject aXq() {
            if (this.ejC == null) {
                this.ejC = wV(this.ejB);
            }
            return this.ejC;
        }

        private JSONObject wV(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cz(JSONObject jSONObject) {
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
    /* loaded from: classes8.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.ejx.send(str);
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
                SwanInspectorEndpoint.this.ejr = true;
                return (String) SwanInspectorEndpoint.this.cPM.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c implements IWebSocketListener {
        private int ejE;

        public c(int i) {
            this.ejE = -1;
            this.ejE = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.ejE == SwanInspectorEndpoint.this.ejy) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.ejn);
                }
                SwanInspectorEndpoint.this.ejt = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.ejE == SwanInspectorEndpoint.this.ejy) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.ejn);
                }
                SwanInspectorEndpoint.this.ejt = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.au(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.ejE == SwanInspectorEndpoint.this.ejy) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.eju != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.ejp || !aVar.aXp()) {
                    SwanInspectorEndpoint.this.cPM.offer(str);
                    SwanInspectorEndpoint.this.eiM.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.ejr = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cPM.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cPM.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.ejs != null && aVar.aXo()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.ejs;
                        SwanInspectorEndpoint.this.ejs = null;
                        SwanInspectorEndpoint.this.eiM.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.ejE == SwanInspectorEndpoint.this.ejy) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.ejv = th;
            }
        }
    }

    public static SwanInspectorEndpoint aXn() {
        return ejk;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0521a c0521a, Runnable runnable) {
        au(false);
        a(c0521a);
        try {
            u(aVar2);
            if (aVar.aXi()) {
                this.ejs = runnable;
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

    public void a(a.C0521a c0521a) {
        this.ejq = c0521a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.ejt = ConnectionState.CONNECTING;
        this.ejm = aVar.aXj();
        this.ejp = aVar.aXk();
        this.ejo = aVar.aXi();
        this.ejn = "ws://" + this.ejm + "/inspect/inspectorTarget/" + this.ejl;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.ejn);
        }
        this.ejz = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.ejn);
        int i = this.ejy + 1;
        this.ejy = i;
        this.ejx = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.eju = ConnectionState.CONNECTING;
        if (this.ejw == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.eiM = aVar;
        this.ejw = this.eiM.hashCode();
        this.ejA = new b();
        this.mInspectorNativeClient = this.eiM.initInspector(this.ejA);
        this.eju = ConnectionState.OPEN;
    }

    public String g(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0521a c0521a = this.ejq;
        if (c0521a == null) {
            c0521a = a.C0521a.aXl();
        }
        sb.append(c0521a.aXm()).append("\n");
        if (!c0521a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.ejt == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.ejv != null || (this.ejt == ConnectionState.CONNECTING && currentTimeMillis - this.ejz > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.ejt == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.ejm).append("\n");
        if (this.ejt == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.ejs != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.ejr) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.ejo) {
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
        if (this.ejx != null && this.ejt != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.ejn);
            }
            try {
                this.ejx.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.ejx = null;
        this.ejz = 0L;
        this.ejt = ConnectionState.CLOSED;
        this.eiM = null;
        this.ejA = null;
        this.mInspectorNativeClient = null;
        this.eju = ConnectionState.CLOSED;
        this.ejs = null;
        this.cPM.clear();
        if (!z) {
            this.ejr = false;
            this.ejv = null;
            this.ejm = null;
            this.ejn = null;
            this.ejo = false;
            this.ejp = false;
            this.ejq = null;
        }
    }

    public void close() {
        au(false);
    }
}
