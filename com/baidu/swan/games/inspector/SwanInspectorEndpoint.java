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
    private static SwanInspectorEndpoint coT = new SwanInspectorEndpoint();
    private String coV;
    private String coW;
    private a.C0337a coZ;
    private com.baidu.swan.games.e.a cov;
    private Runnable cpb;
    private Throwable cpe;
    private int cpf;
    private WebSocketTask cpg;
    private InspectorNativeChannel cpj;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> blb = new LinkedBlockingQueue<>();
    private boolean coX = false;
    private boolean coY = false;
    private boolean cpa = false;
    private ConnectionState cpc = ConnectionState.CLOSED;
    private ConnectionState cpd = ConnectionState.CLOSED;
    private int cph = 0;
    private long cpi = 0;
    private String coU = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes11.dex */
    private static class a {
        private String cpk;
        private JSONObject cpl;

        public a(String str) {
            this.cpk = str;
        }

        public boolean aoE() {
            return "Debugger.enable".equals(by(aoG()));
        }

        public boolean aoF() {
            String by = by(aoG());
            return by != null && by.indexOf("Debugger.") == 0;
        }

        private JSONObject aoG() {
            if (this.cpl == null) {
                this.cpl = pg(this.cpk);
            }
            return this.cpl;
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
                SwanInspectorEndpoint.this.cpg.send(str);
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
                SwanInspectorEndpoint.this.cpa = true;
                return (String) SwanInspectorEndpoint.this.blb.take();
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
        private int cpn;

        public c(int i) {
            this.cpn = -1;
            this.cpn = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.cpn == SwanInspectorEndpoint.this.cph) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.coW);
                }
                SwanInspectorEndpoint.this.cpc = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.cpn == SwanInspectorEndpoint.this.cph) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.coW);
                }
                SwanInspectorEndpoint.this.cpc = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.T(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.cpn == SwanInspectorEndpoint.this.cph) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.cpd != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.coY || !aVar.aoF()) {
                    SwanInspectorEndpoint.this.blb.offer(str);
                    SwanInspectorEndpoint.this.cov.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.cpa = false;
                            String str2 = (String) SwanInspectorEndpoint.this.blb.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.blb.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.cpb != null && aVar.aoE()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.cpb;
                        SwanInspectorEndpoint.this.cpb = null;
                        SwanInspectorEndpoint.this.cov.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.cpn == SwanInspectorEndpoint.this.cph) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.cpe = th;
            }
        }
    }

    public static SwanInspectorEndpoint aoD() {
        return coT;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0337a c0337a, Runnable runnable) {
        T(false);
        a(c0337a);
        try {
            u(aVar2);
            if (aVar.aoy()) {
                this.cpb = runnable;
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
        this.coZ = c0337a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.cpc = ConnectionState.CONNECTING;
        this.coV = aVar.aoz();
        this.coY = aVar.aoA();
        this.coX = aVar.aoy();
        this.coW = "ws://" + this.coV + "/inspect/inspectorTarget/" + this.coU;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.coW);
        }
        this.cpi = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.coW);
        int i = this.cph + 1;
        this.cph = i;
        this.cpg = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.e.a aVar) throws Exception {
        this.cpd = ConnectionState.CONNECTING;
        if (this.cpf == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.cov = aVar;
        this.cpf = this.cov.hashCode();
        this.cpj = new b();
        this.mInspectorNativeClient = this.cov.initInspector(this.cpj);
        this.cpd = ConnectionState.OPEN;
    }

    public String c(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0337a c0337a = this.coZ;
        if (c0337a == null) {
            c0337a = a.C0337a.aoB();
        }
        sb.append(c0337a.aoC()).append("\n");
        if (!c0337a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.cpc == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.cpe != null || (this.cpc == ConnectionState.CONNECTING && currentTimeMillis - this.cpi > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.cpc == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.coV).append("\n");
        if (this.cpc == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.cpb != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.cpa) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.coX) {
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
        if (this.cpg != null && this.cpc != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.coW);
            }
            try {
                this.cpg.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.cpg = null;
        this.cpi = 0L;
        this.cpc = ConnectionState.CLOSED;
        this.cov = null;
        this.cpj = null;
        this.mInspectorNativeClient = null;
        this.cpd = ConnectionState.CLOSED;
        this.cpb = null;
        this.blb.clear();
        if (!z) {
            this.cpa = false;
            this.cpe = null;
            this.coV = null;
            this.coW = null;
            this.coX = false;
            this.coY = false;
            this.coZ = null;
        }
    }

    public void close() {
        T(false);
    }
}
