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
/* loaded from: classes2.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint biJ = new SwanInspectorEndpoint();
    private String biM;
    private String biN;
    private a.C0214a biQ;
    private Runnable biS;
    private Throwable biV;
    private int biW;
    private WebSocketTask biX;
    private com.baidu.swan.games.e.a bia;
    private InspectorNativeChannel bja;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> biL = new LinkedBlockingQueue<>();
    private boolean biO = false;
    private boolean biP = false;
    private boolean biR = false;
    private ConnectionState biT = ConnectionState.CLOSED;
    private ConnectionState biU = ConnectionState.CLOSED;
    private int biY = 0;
    private long biZ = 0;
    private String biK = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes2.dex */
    private static class a {
        private String bjb;
        private JSONObject bjc;

        public a(String str) {
            this.bjb = str;
        }

        public boolean Sx() {
            return "Debugger.enable".equals(as(Sz()));
        }

        public boolean Sy() {
            String as = as(Sz());
            return as != null && as.indexOf("Debugger.") == 0;
        }

        private JSONObject Sz() {
            if (this.bjc == null) {
                this.bjc = jE(this.bjb);
            }
            return this.bjc;
        }

        private JSONObject jE(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String as(JSONObject jSONObject) {
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
    /* loaded from: classes2.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.biX.send(str);
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
                SwanInspectorEndpoint.this.biR = true;
                return (String) SwanInspectorEndpoint.this.biL.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements IWebSocketListener {
        private int bje;

        public c(int i) {
            this.bje = -1;
            this.bje = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.bje == SwanInspectorEndpoint.this.biY) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.biN);
                }
                SwanInspectorEndpoint.this.biT = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.bje == SwanInspectorEndpoint.this.biY) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.biN);
                }
                SwanInspectorEndpoint.this.biT = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.ak(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.bje == SwanInspectorEndpoint.this.biY) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.biU != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.biP || !aVar.Sy()) {
                    SwanInspectorEndpoint.this.biL.offer(str);
                    SwanInspectorEndpoint.this.bia.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.biR = false;
                            String str2 = (String) SwanInspectorEndpoint.this.biL.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.biL.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.biS != null && aVar.Sx()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.biS;
                        SwanInspectorEndpoint.this.biS = null;
                        SwanInspectorEndpoint.this.bia.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.bje == SwanInspectorEndpoint.this.biY) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.biV = th;
            }
        }
    }

    public static SwanInspectorEndpoint Sw() {
        return biJ;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0214a c0214a, Runnable runnable) {
        ak(false);
        a(c0214a);
        try {
            x(aVar2);
            if (aVar.Sr()) {
                this.biS = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            ak(true);
        }
    }

    public void a(a.C0214a c0214a) {
        this.biQ = c0214a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.biT = ConnectionState.CONNECTING;
        this.biM = aVar.Ss();
        this.biP = aVar.St();
        this.biO = aVar.Sr();
        this.biN = "ws://" + this.biM + "/inspect/inspectorTarget/" + this.biK;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.biN);
        }
        this.biZ = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.biN);
        int i = this.biY + 1;
        this.biY = i;
        this.biX = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void x(com.baidu.swan.games.e.a aVar) throws Exception {
        this.biU = ConnectionState.CONNECTING;
        if (this.biW == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.bia = aVar;
        this.biW = this.bia.hashCode();
        this.bja = new b();
        this.mInspectorNativeClient = this.bia.initInspector(this.bja);
        this.biU = ConnectionState.OPEN;
    }

    public String b(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0214a c0214a = this.biQ;
        if (c0214a == null) {
            c0214a = a.C0214a.Su();
        }
        sb.append(c0214a.Sv()).append("\n");
        if (!c0214a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.biT == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.biV != null || (this.biT == ConnectionState.CONNECTING && currentTimeMillis - this.biZ > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.biT == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.biM).append("\n");
        if (this.biT == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.biS != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.biR) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.biO) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(boolean z) {
        if (this.biX != null && this.biT != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.biN);
            }
            try {
                this.biX.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.biX = null;
        this.biZ = 0L;
        this.biT = ConnectionState.CLOSED;
        this.bia = null;
        this.bja = null;
        this.mInspectorNativeClient = null;
        this.biU = ConnectionState.CLOSED;
        this.biS = null;
        this.biL.clear();
        if (!z) {
            this.biR = false;
            this.biV = null;
            this.biM = null;
            this.biN = null;
            this.biO = false;
            this.biP = false;
            this.biQ = null;
        }
    }

    public void close() {
        ak(false);
    }
}
