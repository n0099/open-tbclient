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
    private static SwanInspectorEndpoint ckP = new SwanInspectorEndpoint();
    private String ckR;
    private String ckS;
    private a.C0327a ckV;
    private Runnable ckX;
    private com.baidu.swan.games.e.a ckr;
    private Throwable cla;
    private int clb;
    private WebSocketTask clc;
    private InspectorNativeChannel clf;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bgP = new LinkedBlockingQueue<>();
    private boolean ckT = false;
    private boolean ckU = false;
    private boolean ckW = false;
    private ConnectionState ckY = ConnectionState.CLOSED;
    private ConnectionState ckZ = ConnectionState.CLOSED;
    private int cld = 0;
    private long cle = 0;
    private String ckQ = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes10.dex */
    private static class a {
        private String clg;
        private JSONObject clh;

        public a(String str) {
            this.clg = str;
        }

        public boolean amr() {
            return "Debugger.enable".equals(by(amt()));
        }

        public boolean ams() {
            String by = by(amt());
            return by != null && by.indexOf("Debugger.") == 0;
        }

        private JSONObject amt() {
            if (this.clh == null) {
                this.clh = oR(this.clg);
            }
            return this.clh;
        }

        private JSONObject oR(String str) {
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
    /* loaded from: classes10.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.clc.send(str);
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
                SwanInspectorEndpoint.this.ckW = true;
                return (String) SwanInspectorEndpoint.this.bgP.take();
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
        private int clj;

        public c(int i) {
            this.clj = -1;
            this.clj = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.clj == SwanInspectorEndpoint.this.cld) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.ckS);
                }
                SwanInspectorEndpoint.this.ckY = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.clj == SwanInspectorEndpoint.this.cld) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.ckS);
                }
                SwanInspectorEndpoint.this.ckY = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.Q(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.clj == SwanInspectorEndpoint.this.cld) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.ckZ != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.ckU || !aVar.ams()) {
                    SwanInspectorEndpoint.this.bgP.offer(str);
                    SwanInspectorEndpoint.this.ckr.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.ckW = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bgP.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bgP.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.ckX != null && aVar.amr()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.ckX;
                        SwanInspectorEndpoint.this.ckX = null;
                        SwanInspectorEndpoint.this.ckr.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.clj == SwanInspectorEndpoint.this.cld) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.cla = th;
            }
        }
    }

    public static SwanInspectorEndpoint amq() {
        return ckP;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0327a c0327a, Runnable runnable) {
        Q(false);
        a(c0327a);
        try {
            u(aVar2);
            if (aVar.aml()) {
                this.ckX = runnable;
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

    public void a(a.C0327a c0327a) {
        this.ckV = c0327a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.ckY = ConnectionState.CONNECTING;
        this.ckR = aVar.amm();
        this.ckU = aVar.amn();
        this.ckT = aVar.aml();
        this.ckS = "ws://" + this.ckR + "/inspect/inspectorTarget/" + this.ckQ;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.ckS);
        }
        this.cle = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.ckS);
        int i = this.cld + 1;
        this.cld = i;
        this.clc = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.e.a aVar) throws Exception {
        this.ckZ = ConnectionState.CONNECTING;
        if (this.clb == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.ckr = aVar;
        this.clb = this.ckr.hashCode();
        this.clf = new b();
        this.mInspectorNativeClient = this.ckr.initInspector(this.clf);
        this.ckZ = ConnectionState.OPEN;
    }

    public String c(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0327a c0327a = this.ckV;
        if (c0327a == null) {
            c0327a = a.C0327a.amo();
        }
        sb.append(c0327a.amp()).append("\n");
        if (!c0327a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.ckY == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.cla != null || (this.ckY == ConnectionState.CONNECTING && currentTimeMillis - this.cle > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.ckY == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.ckR).append("\n");
        if (this.ckY == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.ckX != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.ckW) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.ckT) {
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
        if (this.clc != null && this.ckY != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.ckS);
            }
            try {
                this.clc.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.clc = null;
        this.cle = 0L;
        this.ckY = ConnectionState.CLOSED;
        this.ckr = null;
        this.clf = null;
        this.mInspectorNativeClient = null;
        this.ckZ = ConnectionState.CLOSED;
        this.ckX = null;
        this.bgP.clear();
        if (!z) {
            this.ckW = false;
            this.cla = null;
            this.ckR = null;
            this.ckS = null;
            this.ckT = false;
            this.ckU = false;
            this.ckV = null;
        }
    }

    public void close() {
        Q(false);
    }
}
