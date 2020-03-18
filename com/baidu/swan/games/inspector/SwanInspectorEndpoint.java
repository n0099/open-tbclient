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
    private static SwanInspectorEndpoint cpg = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a coI;
    private String cpi;
    private String cpj;
    private a.C0337a cpm;
    private Runnable cpo;
    private Throwable cpr;
    private int cps;
    private WebSocketTask cpt;
    private InspectorNativeChannel cpx;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> blq = new LinkedBlockingQueue<>();
    private boolean cpk = false;
    private boolean cpl = false;
    private boolean cpn = false;
    private ConnectionState cpp = ConnectionState.CLOSED;
    private ConnectionState cpq = ConnectionState.CLOSED;
    private int cpv = 0;
    private long cpw = 0;
    private String cph = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes11.dex */
    private static class a {
        private String cpy;
        private JSONObject cpz;

        public a(String str) {
            this.cpy = str;
        }

        public boolean aoJ() {
            return "Debugger.enable".equals(by(aoL()));
        }

        public boolean aoK() {
            String by = by(aoL());
            return by != null && by.indexOf("Debugger.") == 0;
        }

        private JSONObject aoL() {
            if (this.cpz == null) {
                this.cpz = pf(this.cpy);
            }
            return this.cpz;
        }

        private JSONObject pf(String str) {
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
                SwanInspectorEndpoint.this.cpt.send(str);
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
                SwanInspectorEndpoint.this.cpn = true;
                return (String) SwanInspectorEndpoint.this.blq.take();
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
        private int cpB;

        public c(int i) {
            this.cpB = -1;
            this.cpB = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.cpB == SwanInspectorEndpoint.this.cpv) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.cpj);
                }
                SwanInspectorEndpoint.this.cpp = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.cpB == SwanInspectorEndpoint.this.cpv) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.cpj);
                }
                SwanInspectorEndpoint.this.cpp = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.T(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.cpB == SwanInspectorEndpoint.this.cpv) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.cpq != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.cpl || !aVar.aoK()) {
                    SwanInspectorEndpoint.this.blq.offer(str);
                    SwanInspectorEndpoint.this.coI.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.cpn = false;
                            String str2 = (String) SwanInspectorEndpoint.this.blq.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.blq.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.cpo != null && aVar.aoJ()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.cpo;
                        SwanInspectorEndpoint.this.cpo = null;
                        SwanInspectorEndpoint.this.coI.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.cpB == SwanInspectorEndpoint.this.cpv) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.cpr = th;
            }
        }
    }

    public static SwanInspectorEndpoint aoI() {
        return cpg;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0337a c0337a, Runnable runnable) {
        T(false);
        a(c0337a);
        try {
            u(aVar2);
            if (aVar.aoD()) {
                this.cpo = runnable;
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
        this.cpm = c0337a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.cpp = ConnectionState.CONNECTING;
        this.cpi = aVar.aoE();
        this.cpl = aVar.aoF();
        this.cpk = aVar.aoD();
        this.cpj = "ws://" + this.cpi + "/inspect/inspectorTarget/" + this.cph;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.cpj);
        }
        this.cpw = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.cpj);
        int i = this.cpv + 1;
        this.cpv = i;
        this.cpt = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.e.a aVar) throws Exception {
        this.cpq = ConnectionState.CONNECTING;
        if (this.cps == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.coI = aVar;
        this.cps = this.coI.hashCode();
        this.cpx = new b();
        this.mInspectorNativeClient = this.coI.initInspector(this.cpx);
        this.cpq = ConnectionState.OPEN;
    }

    public String c(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0337a c0337a = this.cpm;
        if (c0337a == null) {
            c0337a = a.C0337a.aoG();
        }
        sb.append(c0337a.aoH()).append("\n");
        if (!c0337a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.cpp == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.cpr != null || (this.cpp == ConnectionState.CONNECTING && currentTimeMillis - this.cpw > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.cpp == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.cpi).append("\n");
        if (this.cpp == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.cpo != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.cpn) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.cpk) {
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
        if (this.cpt != null && this.cpp != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.cpj);
            }
            try {
                this.cpt.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.cpt = null;
        this.cpw = 0L;
        this.cpp = ConnectionState.CLOSED;
        this.coI = null;
        this.cpx = null;
        this.mInspectorNativeClient = null;
        this.cpq = ConnectionState.CLOSED;
        this.cpo = null;
        this.blq.clear();
        if (!z) {
            this.cpn = false;
            this.cpr = null;
            this.cpi = null;
            this.cpj = null;
            this.cpk = false;
            this.cpl = false;
            this.cpm = null;
        }
    }

    public void close() {
        T(false);
    }
}
