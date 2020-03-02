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
    private static SwanInspectorEndpoint coU = new SwanInspectorEndpoint();
    private String coW;
    private String coX;
    private com.baidu.swan.games.e.a cow;
    private a.C0337a cpa;
    private Runnable cpc;
    private Throwable cpf;
    private int cpg;
    private WebSocketTask cph;
    private InspectorNativeChannel cpk;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> blc = new LinkedBlockingQueue<>();
    private boolean coY = false;
    private boolean coZ = false;
    private boolean cpb = false;
    private ConnectionState cpd = ConnectionState.CLOSED;
    private ConnectionState cpe = ConnectionState.CLOSED;
    private int cpi = 0;
    private long cpj = 0;
    private String coV = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes11.dex */
    private static class a {
        private String cpl;
        private JSONObject cpm;

        public a(String str) {
            this.cpl = str;
        }

        public boolean aoG() {
            return "Debugger.enable".equals(by(aoI()));
        }

        public boolean aoH() {
            String by = by(aoI());
            return by != null && by.indexOf("Debugger.") == 0;
        }

        private JSONObject aoI() {
            if (this.cpm == null) {
                this.cpm = pg(this.cpl);
            }
            return this.cpm;
        }

        private JSONObject pg(String str) {
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
    /* loaded from: classes11.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.cph.send(str);
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
                SwanInspectorEndpoint.this.cpb = true;
                return (String) SwanInspectorEndpoint.this.blc.take();
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
        private int cpo;

        public c(int i) {
            this.cpo = -1;
            this.cpo = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.cpo == SwanInspectorEndpoint.this.cpi) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.coX);
                }
                SwanInspectorEndpoint.this.cpd = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.cpo == SwanInspectorEndpoint.this.cpi) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.coX);
                }
                SwanInspectorEndpoint.this.cpd = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.T(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.cpo == SwanInspectorEndpoint.this.cpi) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.cpe != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.coZ || !aVar.aoH()) {
                    SwanInspectorEndpoint.this.blc.offer(str);
                    SwanInspectorEndpoint.this.cow.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.cpb = false;
                            String str2 = (String) SwanInspectorEndpoint.this.blc.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.blc.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.cpc != null && aVar.aoG()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.cpc;
                        SwanInspectorEndpoint.this.cpc = null;
                        SwanInspectorEndpoint.this.cow.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.cpo == SwanInspectorEndpoint.this.cpi) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.cpf = th;
            }
        }
    }

    public static SwanInspectorEndpoint aoF() {
        return coU;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0337a c0337a, Runnable runnable) {
        T(false);
        a(c0337a);
        try {
            u(aVar2);
            if (aVar.aoA()) {
                this.cpc = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            T(true);
        }
    }

    public void a(a.C0337a c0337a) {
        this.cpa = c0337a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.cpd = ConnectionState.CONNECTING;
        this.coW = aVar.aoB();
        this.coZ = aVar.aoC();
        this.coY = aVar.aoA();
        this.coX = "ws://" + this.coW + "/inspect/inspectorTarget/" + this.coV;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.coX);
        }
        this.cpj = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.coX);
        int i = this.cpi + 1;
        this.cpi = i;
        this.cph = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.e.a aVar) throws Exception {
        this.cpe = ConnectionState.CONNECTING;
        if (this.cpg == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.cow = aVar;
        this.cpg = this.cow.hashCode();
        this.cpk = new b();
        this.mInspectorNativeClient = this.cow.initInspector(this.cpk);
        this.cpe = ConnectionState.OPEN;
    }

    public String c(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0337a c0337a = this.cpa;
        if (c0337a == null) {
            c0337a = a.C0337a.aoD();
        }
        sb.append(c0337a.aoE()).append("\n");
        if (!c0337a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.cpd == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.cpf != null || (this.cpd == ConnectionState.CONNECTING && currentTimeMillis - this.cpj > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.cpd == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.coW).append("\n");
        if (this.cpd == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.cpc != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.cpb) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.coY) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(boolean z) {
        if (this.cph != null && this.cpd != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.coX);
            }
            try {
                this.cph.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.cph = null;
        this.cpj = 0L;
        this.cpd = ConnectionState.CLOSED;
        this.cow = null;
        this.cpk = null;
        this.mInspectorNativeClient = null;
        this.cpe = ConnectionState.CLOSED;
        this.cpc = null;
        this.blc.clear();
        if (!z) {
            this.cpb = false;
            this.cpf = null;
            this.coW = null;
            this.coX = null;
            this.coY = false;
            this.coZ = false;
            this.cpa = null;
        }
    }

    public void close() {
        T(false);
    }
}
