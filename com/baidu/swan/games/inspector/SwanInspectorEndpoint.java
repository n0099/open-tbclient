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
    private static SwanInspectorEndpoint ehJ = new SwanInspectorEndpoint();
    private String ehL;
    private String ehM;
    private a.C0515a ehP;
    private Runnable ehR;
    private Throwable ehU;
    private int ehV;
    private WebSocketTask ehW;
    private InspectorNativeChannel ehZ;
    private com.baidu.swan.games.f.a ehl;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cOm = new LinkedBlockingQueue<>();
    private boolean ehN = false;
    private boolean ehO = false;
    private boolean ehQ = false;
    private ConnectionState ehS = ConnectionState.CLOSED;
    private ConnectionState ehT = ConnectionState.CLOSED;
    private int ehX = 0;
    private long ehY = 0;
    private String ehK = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes9.dex */
    private static class a {
        private String eia;
        private JSONObject eib;

        public a(String str) {
            this.eia = str;
        }

        public boolean aXl() {
            return "Debugger.enable".equals(cx(aXn()));
        }

        public boolean aXm() {
            String cx = cx(aXn());
            return cx != null && cx.indexOf("Debugger.") == 0;
        }

        private JSONObject aXn() {
            if (this.eib == null) {
                this.eib = wO(this.eia);
            }
            return this.eib;
        }

        private JSONObject wO(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cx(JSONObject jSONObject) {
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
                SwanInspectorEndpoint.this.ehW.send(str);
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
                SwanInspectorEndpoint.this.ehQ = true;
                return (String) SwanInspectorEndpoint.this.cOm.take();
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
        private int eid;

        public c(int i) {
            this.eid = -1;
            this.eid = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.eid == SwanInspectorEndpoint.this.ehX) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.ehM);
                }
                SwanInspectorEndpoint.this.ehS = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.eid == SwanInspectorEndpoint.this.ehX) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.ehM);
                }
                SwanInspectorEndpoint.this.ehS = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.au(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.eid == SwanInspectorEndpoint.this.ehX) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.ehT != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.ehO || !aVar.aXm()) {
                    SwanInspectorEndpoint.this.cOm.offer(str);
                    SwanInspectorEndpoint.this.ehl.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.ehQ = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cOm.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cOm.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.ehR != null && aVar.aXl()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.ehR;
                        SwanInspectorEndpoint.this.ehR = null;
                        SwanInspectorEndpoint.this.ehl.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.eid == SwanInspectorEndpoint.this.ehX) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.ehU = th;
            }
        }
    }

    public static SwanInspectorEndpoint aXk() {
        return ehJ;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0515a c0515a, Runnable runnable) {
        au(false);
        a(c0515a);
        try {
            u(aVar2);
            if (aVar.aXf()) {
                this.ehR = runnable;
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

    public void a(a.C0515a c0515a) {
        this.ehP = c0515a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.ehS = ConnectionState.CONNECTING;
        this.ehL = aVar.aXg();
        this.ehO = aVar.aXh();
        this.ehN = aVar.aXf();
        this.ehM = "ws://" + this.ehL + "/inspect/inspectorTarget/" + this.ehK;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.ehM);
        }
        this.ehY = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.ehM);
        int i = this.ehX + 1;
        this.ehX = i;
        this.ehW = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.ehT = ConnectionState.CONNECTING;
        if (this.ehV == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.ehl = aVar;
        this.ehV = this.ehl.hashCode();
        this.ehZ = new b();
        this.mInspectorNativeClient = this.ehl.initInspector(this.ehZ);
        this.ehT = ConnectionState.OPEN;
    }

    public String g(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0515a c0515a = this.ehP;
        if (c0515a == null) {
            c0515a = a.C0515a.aXi();
        }
        sb.append(c0515a.aXj()).append("\n");
        if (!c0515a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.ehS == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.ehU != null || (this.ehS == ConnectionState.CONNECTING && currentTimeMillis - this.ehY > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.ehS == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.ehL).append("\n");
        if (this.ehS == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.ehR != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.ehQ) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.ehN) {
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
        if (this.ehW != null && this.ehS != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.ehM);
            }
            try {
                this.ehW.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.ehW = null;
        this.ehY = 0L;
        this.ehS = ConnectionState.CLOSED;
        this.ehl = null;
        this.ehZ = null;
        this.mInspectorNativeClient = null;
        this.ehT = ConnectionState.CLOSED;
        this.ehR = null;
        this.cOm.clear();
        if (!z) {
            this.ehQ = false;
            this.ehU = null;
            this.ehL = null;
            this.ehM = null;
            this.ehN = false;
            this.ehO = false;
            this.ehP = null;
        }
    }

    public void close() {
        au(false);
    }
}
