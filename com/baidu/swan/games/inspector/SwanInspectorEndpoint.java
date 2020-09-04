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
    private static SwanInspectorEndpoint dtK = new SwanInspectorEndpoint();
    private String dtM;
    private String dtN;
    private a.C0494a dtQ;
    private Runnable dtS;
    private Throwable dtV;
    private int dtW;
    private WebSocketTask dtX;
    private com.baidu.swan.games.f.a dtl;
    private InspectorNativeChannel dua;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cdU = new LinkedBlockingQueue<>();
    private boolean dtO = false;
    private boolean dtP = false;
    private boolean dtR = false;
    private ConnectionState dtT = ConnectionState.CLOSED;
    private ConnectionState dtU = ConnectionState.CLOSED;
    private int dtY = 0;
    private long dtZ = 0;
    private String dtL = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes8.dex */
    private static class a {
        private String dub;
        private JSONObject duc;

        public a(String str) {
            this.dub = str;
        }

        public boolean aOn() {
            return "Debugger.enable".equals(cd(aOp()));
        }

        public boolean aOo() {
            String cd = cd(aOp());
            return cd != null && cd.indexOf("Debugger.") == 0;
        }

        private JSONObject aOp() {
            if (this.duc == null) {
                this.duc = vt(this.dub);
            }
            return this.duc;
        }

        private JSONObject vt(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cd(JSONObject jSONObject) {
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
                SwanInspectorEndpoint.this.dtX.send(str);
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
                SwanInspectorEndpoint.this.dtR = true;
                return (String) SwanInspectorEndpoint.this.cdU.take();
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
        private int due;

        public c(int i) {
            this.due = -1;
            this.due = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.due == SwanInspectorEndpoint.this.dtY) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.dtN);
                }
                SwanInspectorEndpoint.this.dtT = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.due == SwanInspectorEndpoint.this.dtY) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.dtN);
                }
                SwanInspectorEndpoint.this.dtT = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.aw(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.due == SwanInspectorEndpoint.this.dtY) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.dtU != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.dtP || !aVar.aOo()) {
                    SwanInspectorEndpoint.this.cdU.offer(str);
                    SwanInspectorEndpoint.this.dtl.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.dtR = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cdU.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cdU.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.dtS != null && aVar.aOn()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.dtS;
                        SwanInspectorEndpoint.this.dtS = null;
                        SwanInspectorEndpoint.this.dtl.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.due == SwanInspectorEndpoint.this.dtY) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.dtV = th;
            }
        }
    }

    public static SwanInspectorEndpoint aOm() {
        return dtK;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0494a c0494a, Runnable runnable) {
        aw(false);
        a(c0494a);
        try {
            u(aVar2);
            if (aVar.aOh()) {
                this.dtS = runnable;
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

    public void a(a.C0494a c0494a) {
        this.dtQ = c0494a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.dtT = ConnectionState.CONNECTING;
        this.dtM = aVar.aOi();
        this.dtP = aVar.aOj();
        this.dtO = aVar.aOh();
        this.dtN = "ws://" + this.dtM + "/inspect/inspectorTarget/" + this.dtL;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.dtN);
        }
        this.dtZ = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.dtN);
        int i = this.dtY + 1;
        this.dtY = i;
        this.dtX = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.dtU = ConnectionState.CONNECTING;
        if (this.dtW == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.dtl = aVar;
        this.dtW = this.dtl.hashCode();
        this.dua = new b();
        this.mInspectorNativeClient = this.dtl.initInspector(this.dua);
        this.dtU = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0494a c0494a = this.dtQ;
        if (c0494a == null) {
            c0494a = a.C0494a.aOk();
        }
        sb.append(c0494a.aOl()).append("\n");
        if (!c0494a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.dtT == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.dtV != null || (this.dtT == ConnectionState.CONNECTING && currentTimeMillis - this.dtZ > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.dtT == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.dtM).append("\n");
        if (this.dtT == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.dtS != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.dtR) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.dtO) {
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
        if (this.dtX != null && this.dtT != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.dtN);
            }
            try {
                this.dtX.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.dtX = null;
        this.dtZ = 0L;
        this.dtT = ConnectionState.CLOSED;
        this.dtl = null;
        this.dua = null;
        this.mInspectorNativeClient = null;
        this.dtU = ConnectionState.CLOSED;
        this.dtS = null;
        this.cdU.clear();
        if (!z) {
            this.dtR = false;
            this.dtV = null;
            this.dtM = null;
            this.dtN = null;
            this.dtO = false;
            this.dtP = false;
            this.dtQ = null;
        }
    }

    public void close() {
        aw(false);
    }
}
