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
    private static SwanInspectorEndpoint dtG = new SwanInspectorEndpoint();
    private String dtI;
    private String dtJ;
    private a.C0494a dtM;
    private Runnable dtO;
    private Throwable dtR;
    private int dtS;
    private WebSocketTask dtT;
    private InspectorNativeChannel dtW;
    private com.baidu.swan.games.f.a dth;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cdQ = new LinkedBlockingQueue<>();
    private boolean dtK = false;
    private boolean dtL = false;
    private boolean dtN = false;
    private ConnectionState dtP = ConnectionState.CLOSED;
    private ConnectionState dtQ = ConnectionState.CLOSED;
    private int dtU = 0;
    private long dtV = 0;
    private String dtH = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes8.dex */
    private static class a {
        private String dtX;
        private JSONObject dtY;

        public a(String str) {
            this.dtX = str;
        }

        public boolean aOn() {
            return "Debugger.enable".equals(cd(aOp()));
        }

        public boolean aOo() {
            String cd = cd(aOp());
            return cd != null && cd.indexOf("Debugger.") == 0;
        }

        private JSONObject aOp() {
            if (this.dtY == null) {
                this.dtY = vs(this.dtX);
            }
            return this.dtY;
        }

        private JSONObject vs(String str) {
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
                SwanInspectorEndpoint.this.dtT.send(str);
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
                SwanInspectorEndpoint.this.dtN = true;
                return (String) SwanInspectorEndpoint.this.cdQ.take();
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
        private int dua;

        public c(int i) {
            this.dua = -1;
            this.dua = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.dua == SwanInspectorEndpoint.this.dtU) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.dtJ);
                }
                SwanInspectorEndpoint.this.dtP = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.dua == SwanInspectorEndpoint.this.dtU) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.dtJ);
                }
                SwanInspectorEndpoint.this.dtP = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.aw(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.dua == SwanInspectorEndpoint.this.dtU) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.dtQ != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.dtL || !aVar.aOo()) {
                    SwanInspectorEndpoint.this.cdQ.offer(str);
                    SwanInspectorEndpoint.this.dth.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.dtN = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cdQ.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cdQ.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.dtO != null && aVar.aOn()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.dtO;
                        SwanInspectorEndpoint.this.dtO = null;
                        SwanInspectorEndpoint.this.dth.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.dua == SwanInspectorEndpoint.this.dtU) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.dtR = th;
            }
        }
    }

    public static SwanInspectorEndpoint aOm() {
        return dtG;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0494a c0494a, Runnable runnable) {
        aw(false);
        a(c0494a);
        try {
            u(aVar2);
            if (aVar.aOh()) {
                this.dtO = runnable;
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
        this.dtM = c0494a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.dtP = ConnectionState.CONNECTING;
        this.dtI = aVar.aOi();
        this.dtL = aVar.aOj();
        this.dtK = aVar.aOh();
        this.dtJ = "ws://" + this.dtI + "/inspect/inspectorTarget/" + this.dtH;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.dtJ);
        }
        this.dtV = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.dtJ);
        int i = this.dtU + 1;
        this.dtU = i;
        this.dtT = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.dtQ = ConnectionState.CONNECTING;
        if (this.dtS == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.dth = aVar;
        this.dtS = this.dth.hashCode();
        this.dtW = new b();
        this.mInspectorNativeClient = this.dth.initInspector(this.dtW);
        this.dtQ = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0494a c0494a = this.dtM;
        if (c0494a == null) {
            c0494a = a.C0494a.aOk();
        }
        sb.append(c0494a.aOl()).append("\n");
        if (!c0494a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.dtP == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.dtR != null || (this.dtP == ConnectionState.CONNECTING && currentTimeMillis - this.dtV > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.dtP == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.dtI).append("\n");
        if (this.dtP == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.dtO != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.dtN) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.dtK) {
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
        if (this.dtT != null && this.dtP != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.dtJ);
            }
            try {
                this.dtT.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.dtT = null;
        this.dtV = 0L;
        this.dtP = ConnectionState.CLOSED;
        this.dth = null;
        this.dtW = null;
        this.mInspectorNativeClient = null;
        this.dtQ = ConnectionState.CLOSED;
        this.dtO = null;
        this.cdQ.clear();
        if (!z) {
            this.dtN = false;
            this.dtR = null;
            this.dtI = null;
            this.dtJ = null;
            this.dtK = false;
            this.dtL = false;
            this.dtM = null;
        }
    }

    public void close() {
        aw(false);
    }
}
