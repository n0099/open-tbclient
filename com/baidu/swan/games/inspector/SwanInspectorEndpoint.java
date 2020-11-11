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
    private static SwanInspectorEndpoint dWb = new SwanInspectorEndpoint();
    private com.baidu.swan.games.f.a dVD;
    private String dWd;
    private String dWe;
    private a.C0532a dWh;
    private Runnable dWj;
    private Throwable dWm;
    private int dWn;
    private WebSocketTask dWo;
    private InspectorNativeChannel dWr;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cGF = new LinkedBlockingQueue<>();
    private boolean dWf = false;
    private boolean dWg = false;
    private boolean dWi = false;
    private ConnectionState dWk = ConnectionState.CLOSED;
    private ConnectionState dWl = ConnectionState.CLOSED;
    private int dWp = 0;
    private long dWq = 0;
    private String dWc = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes10.dex */
    private static class a {
        private String dWs;
        private JSONObject dWt;

        public a(String str) {
            this.dWs = str;
        }

        public boolean aWb() {
            return "Debugger.enable".equals(cw(aWd()));
        }

        public boolean aWc() {
            String cw = cw(aWd());
            return cw != null && cw.indexOf("Debugger.") == 0;
        }

        private JSONObject aWd() {
            if (this.dWt == null) {
                this.dWt = xf(this.dWs);
            }
            return this.dWt;
        }

        private JSONObject xf(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cw(JSONObject jSONObject) {
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
                SwanInspectorEndpoint.this.dWo.send(str);
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
                SwanInspectorEndpoint.this.dWi = true;
                return (String) SwanInspectorEndpoint.this.cGF.take();
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
        private int dWv;

        public c(int i) {
            this.dWv = -1;
            this.dWv = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.dWv == SwanInspectorEndpoint.this.dWp) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.dWe);
                }
                SwanInspectorEndpoint.this.dWk = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.dWv == SwanInspectorEndpoint.this.dWp) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.dWe);
                }
                SwanInspectorEndpoint.this.dWk = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.aw(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.dWv == SwanInspectorEndpoint.this.dWp) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.dWl != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.dWg || !aVar.aWc()) {
                    SwanInspectorEndpoint.this.cGF.offer(str);
                    SwanInspectorEndpoint.this.dVD.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.dWi = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cGF.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cGF.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.dWj != null && aVar.aWb()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.dWj;
                        SwanInspectorEndpoint.this.dWj = null;
                        SwanInspectorEndpoint.this.dVD.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.dWv == SwanInspectorEndpoint.this.dWp) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.dWm = th;
            }
        }
    }

    public static SwanInspectorEndpoint aWa() {
        return dWb;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0532a c0532a, Runnable runnable) {
        aw(false);
        a(c0532a);
        try {
            u(aVar2);
            if (aVar.aVV()) {
                this.dWj = runnable;
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

    public void a(a.C0532a c0532a) {
        this.dWh = c0532a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.dWk = ConnectionState.CONNECTING;
        this.dWd = aVar.aVW();
        this.dWg = aVar.aVX();
        this.dWf = aVar.aVV();
        this.dWe = "ws://" + this.dWd + "/inspect/inspectorTarget/" + this.dWc;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.dWe);
        }
        this.dWq = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.dWe);
        int i = this.dWp + 1;
        this.dWp = i;
        this.dWo = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.dWl = ConnectionState.CONNECTING;
        if (this.dWn == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.dVD = aVar;
        this.dWn = this.dVD.hashCode();
        this.dWr = new b();
        this.mInspectorNativeClient = this.dVD.initInspector(this.dWr);
        this.dWl = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0532a c0532a = this.dWh;
        if (c0532a == null) {
            c0532a = a.C0532a.aVY();
        }
        sb.append(c0532a.aVZ()).append("\n");
        if (!c0532a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.dWk == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.dWm != null || (this.dWk == ConnectionState.CONNECTING && currentTimeMillis - this.dWq > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.dWk == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.dWd).append("\n");
        if (this.dWk == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.dWj != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.dWi) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.dWf) {
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
        if (this.dWo != null && this.dWk != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.dWe);
            }
            try {
                this.dWo.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.dWo = null;
        this.dWq = 0L;
        this.dWk = ConnectionState.CLOSED;
        this.dVD = null;
        this.dWr = null;
        this.mInspectorNativeClient = null;
        this.dWl = ConnectionState.CLOSED;
        this.dWj = null;
        this.cGF.clear();
        if (!z) {
            this.dWi = false;
            this.dWm = null;
            this.dWd = null;
            this.dWe = null;
            this.dWf = false;
            this.dWg = false;
            this.dWh = null;
        }
    }

    public void close() {
        aw(false);
    }
}
