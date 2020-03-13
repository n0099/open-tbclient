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
    private static SwanInspectorEndpoint coV = new SwanInspectorEndpoint();
    private String coX;
    private String coY;
    private com.baidu.swan.games.e.a cox;
    private a.C0337a cpb;
    private Runnable cpd;
    private Throwable cpg;
    private int cph;
    private WebSocketTask cpi;
    private InspectorNativeChannel cpl;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bld = new LinkedBlockingQueue<>();
    private boolean coZ = false;
    private boolean cpa = false;
    private boolean cpc = false;
    private ConnectionState cpe = ConnectionState.CLOSED;
    private ConnectionState cpf = ConnectionState.CLOSED;
    private int cpj = 0;
    private long cpk = 0;
    private String coW = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes11.dex */
    private static class a {
        private String cpm;
        private JSONObject cpn;

        public a(String str) {
            this.cpm = str;
        }

        public boolean aoG() {
            return "Debugger.enable".equals(by(aoI()));
        }

        public boolean aoH() {
            String by = by(aoI());
            return by != null && by.indexOf("Debugger.") == 0;
        }

        private JSONObject aoI() {
            if (this.cpn == null) {
                this.cpn = pg(this.cpm);
            }
            return this.cpn;
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
                SwanInspectorEndpoint.this.cpi.send(str);
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
                SwanInspectorEndpoint.this.cpc = true;
                return (String) SwanInspectorEndpoint.this.bld.take();
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
        private int cpp;

        public c(int i) {
            this.cpp = -1;
            this.cpp = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.cpp == SwanInspectorEndpoint.this.cpj) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.coY);
                }
                SwanInspectorEndpoint.this.cpe = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.cpp == SwanInspectorEndpoint.this.cpj) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.coY);
                }
                SwanInspectorEndpoint.this.cpe = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.T(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.cpp == SwanInspectorEndpoint.this.cpj) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.cpf != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.cpa || !aVar.aoH()) {
                    SwanInspectorEndpoint.this.bld.offer(str);
                    SwanInspectorEndpoint.this.cox.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.cpc = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bld.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bld.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.cpd != null && aVar.aoG()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.cpd;
                        SwanInspectorEndpoint.this.cpd = null;
                        SwanInspectorEndpoint.this.cox.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.cpp == SwanInspectorEndpoint.this.cpj) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.cpg = th;
            }
        }
    }

    public static SwanInspectorEndpoint aoF() {
        return coV;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0337a c0337a, Runnable runnable) {
        T(false);
        a(c0337a);
        try {
            u(aVar2);
            if (aVar.aoA()) {
                this.cpd = runnable;
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
        this.cpb = c0337a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.cpe = ConnectionState.CONNECTING;
        this.coX = aVar.aoB();
        this.cpa = aVar.aoC();
        this.coZ = aVar.aoA();
        this.coY = "ws://" + this.coX + "/inspect/inspectorTarget/" + this.coW;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.coY);
        }
        this.cpk = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.coY);
        int i = this.cpj + 1;
        this.cpj = i;
        this.cpi = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.e.a aVar) throws Exception {
        this.cpf = ConnectionState.CONNECTING;
        if (this.cph == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.cox = aVar;
        this.cph = this.cox.hashCode();
        this.cpl = new b();
        this.mInspectorNativeClient = this.cox.initInspector(this.cpl);
        this.cpf = ConnectionState.OPEN;
    }

    public String c(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0337a c0337a = this.cpb;
        if (c0337a == null) {
            c0337a = a.C0337a.aoD();
        }
        sb.append(c0337a.aoE()).append("\n");
        if (!c0337a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.cpe == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.cpg != null || (this.cpe == ConnectionState.CONNECTING && currentTimeMillis - this.cpk > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.cpe == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.coX).append("\n");
        if (this.cpe == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.cpd != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.cpc) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.coZ) {
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
        if (this.cpi != null && this.cpe != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.coY);
            }
            try {
                this.cpi.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.cpi = null;
        this.cpk = 0L;
        this.cpe = ConnectionState.CLOSED;
        this.cox = null;
        this.cpl = null;
        this.mInspectorNativeClient = null;
        this.cpf = ConnectionState.CLOSED;
        this.cpd = null;
        this.bld.clear();
        if (!z) {
            this.cpc = false;
            this.cpg = null;
            this.coX = null;
            this.coY = null;
            this.coZ = false;
            this.cpa = false;
            this.cpb = null;
        }
    }

    public void close() {
        T(false);
    }
}
