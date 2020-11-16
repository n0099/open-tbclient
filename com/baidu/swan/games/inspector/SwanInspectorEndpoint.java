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
/* loaded from: classes7.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint dUt = new SwanInspectorEndpoint();
    private com.baidu.swan.games.f.a dTV;
    private Runnable dUB;
    private Throwable dUE;
    private int dUF;
    private WebSocketTask dUG;
    private InspectorNativeChannel dUJ;
    private String dUv;
    private String dUw;
    private a.C0530a dUz;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cEV = new LinkedBlockingQueue<>();
    private boolean dUx = false;
    private boolean dUy = false;
    private boolean dUA = false;
    private ConnectionState dUC = ConnectionState.CLOSED;
    private ConnectionState dUD = ConnectionState.CLOSED;
    private int dUH = 0;
    private long dUI = 0;
    private String dUu = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes7.dex */
    private static class a {
        private String dUK;
        private JSONObject dUL;

        public a(String str) {
            this.dUK = str;
        }

        public boolean aVt() {
            return "Debugger.enable".equals(cq(aVv()));
        }

        public boolean aVu() {
            String cq = cq(aVv());
            return cq != null && cq.indexOf("Debugger.") == 0;
        }

        private JSONObject aVv() {
            if (this.dUL == null) {
                this.dUL = xa(this.dUK);
            }
            return this.dUL;
        }

        private JSONObject xa(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cq(JSONObject jSONObject) {
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
    /* loaded from: classes7.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.dUG.send(str);
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
                SwanInspectorEndpoint.this.dUA = true;
                return (String) SwanInspectorEndpoint.this.cEV.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c implements IWebSocketListener {
        private int dUN;

        public c(int i) {
            this.dUN = -1;
            this.dUN = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.dUN == SwanInspectorEndpoint.this.dUH) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.dUw);
                }
                SwanInspectorEndpoint.this.dUC = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.dUN == SwanInspectorEndpoint.this.dUH) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.dUw);
                }
                SwanInspectorEndpoint.this.dUC = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.aw(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.dUN == SwanInspectorEndpoint.this.dUH) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.dUD != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.dUy || !aVar.aVu()) {
                    SwanInspectorEndpoint.this.cEV.offer(str);
                    SwanInspectorEndpoint.this.dTV.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.dUA = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cEV.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cEV.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.dUB != null && aVar.aVt()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.dUB;
                        SwanInspectorEndpoint.this.dUB = null;
                        SwanInspectorEndpoint.this.dTV.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.dUN == SwanInspectorEndpoint.this.dUH) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.dUE = th;
            }
        }
    }

    public static SwanInspectorEndpoint aVs() {
        return dUt;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0530a c0530a, Runnable runnable) {
        aw(false);
        a(c0530a);
        try {
            u(aVar2);
            if (aVar.aVn()) {
                this.dUB = runnable;
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

    public void a(a.C0530a c0530a) {
        this.dUz = c0530a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.dUC = ConnectionState.CONNECTING;
        this.dUv = aVar.aVo();
        this.dUy = aVar.aVp();
        this.dUx = aVar.aVn();
        this.dUw = "ws://" + this.dUv + "/inspect/inspectorTarget/" + this.dUu;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.dUw);
        }
        this.dUI = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.dUw);
        int i = this.dUH + 1;
        this.dUH = i;
        this.dUG = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.dUD = ConnectionState.CONNECTING;
        if (this.dUF == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.dTV = aVar;
        this.dUF = this.dTV.hashCode();
        this.dUJ = new b();
        this.mInspectorNativeClient = this.dTV.initInspector(this.dUJ);
        this.dUD = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0530a c0530a = this.dUz;
        if (c0530a == null) {
            c0530a = a.C0530a.aVq();
        }
        sb.append(c0530a.aVr()).append("\n");
        if (!c0530a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.dUC == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.dUE != null || (this.dUC == ConnectionState.CONNECTING && currentTimeMillis - this.dUI > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.dUC == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.dUv).append("\n");
        if (this.dUC == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.dUB != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.dUA) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.dUx) {
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
        if (this.dUG != null && this.dUC != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.dUw);
            }
            try {
                this.dUG.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.dUG = null;
        this.dUI = 0L;
        this.dUC = ConnectionState.CLOSED;
        this.dTV = null;
        this.dUJ = null;
        this.mInspectorNativeClient = null;
        this.dUD = ConnectionState.CLOSED;
        this.dUB = null;
        this.cEV.clear();
        if (!z) {
            this.dUA = false;
            this.dUE = null;
            this.dUv = null;
            this.dUw = null;
            this.dUx = false;
            this.dUy = false;
            this.dUz = null;
        }
    }

    public void close() {
        aw(false);
    }
}
