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
    private static SwanInspectorEndpoint bBx = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a bAQ;
    private String bBA;
    private String bBB;
    private a.C0246a bBE;
    private Runnable bBG;
    private Throwable bBJ;
    private int bBK;
    private WebSocketTask bBL;
    private InspectorNativeChannel bBO;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bBz = new LinkedBlockingQueue<>();
    private boolean bBC = false;
    private boolean bBD = false;
    private boolean bBF = false;
    private ConnectionState bBH = ConnectionState.CLOSED;
    private ConnectionState bBI = ConnectionState.CLOSED;
    private int bBM = 0;
    private long bBN = 0;
    private String bBy = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes2.dex */
    private static class a {
        private String bBP;
        private JSONObject bBQ;

        public a(String str) {
            this.bBP = str;
        }

        public boolean Xo() {
            return "Debugger.enable".equals(aQ(Xq()));
        }

        public boolean Xp() {
            String aQ = aQ(Xq());
            return aQ != null && aQ.indexOf("Debugger.") == 0;
        }

        private JSONObject Xq() {
            if (this.bBQ == null) {
                this.bBQ = kg(this.bBP);
            }
            return this.bBQ;
        }

        private JSONObject kg(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String aQ(JSONObject jSONObject) {
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
                SwanInspectorEndpoint.this.bBL.send(str);
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
                SwanInspectorEndpoint.this.bBF = true;
                return (String) SwanInspectorEndpoint.this.bBz.take();
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
        private int bBS;

        public c(int i) {
            this.bBS = -1;
            this.bBS = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.bBS == SwanInspectorEndpoint.this.bBM) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.bBB);
                }
                SwanInspectorEndpoint.this.bBH = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.bBS == SwanInspectorEndpoint.this.bBM) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.bBB);
                }
                SwanInspectorEndpoint.this.bBH = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.L(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.bBS == SwanInspectorEndpoint.this.bBM) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.bBI != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.bBD || !aVar.Xp()) {
                    SwanInspectorEndpoint.this.bBz.offer(str);
                    SwanInspectorEndpoint.this.bAQ.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.bBF = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bBz.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bBz.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.bBG != null && aVar.Xo()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.bBG;
                        SwanInspectorEndpoint.this.bBG = null;
                        SwanInspectorEndpoint.this.bAQ.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.bBS == SwanInspectorEndpoint.this.bBM) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.bBJ = th;
            }
        }
    }

    public static SwanInspectorEndpoint Xn() {
        return bBx;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0246a c0246a, Runnable runnable) {
        L(false);
        a(c0246a);
        try {
            x(aVar2);
            if (aVar.Xi()) {
                this.bBG = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            L(true);
        }
    }

    public void a(a.C0246a c0246a) {
        this.bBE = c0246a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.bBH = ConnectionState.CONNECTING;
        this.bBA = aVar.Xj();
        this.bBD = aVar.Xk();
        this.bBC = aVar.Xi();
        this.bBB = "ws://" + this.bBA + "/inspect/inspectorTarget/" + this.bBy;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.bBB);
        }
        this.bBN = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.bBB);
        int i = this.bBM + 1;
        this.bBM = i;
        this.bBL = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void x(com.baidu.swan.games.e.a aVar) throws Exception {
        this.bBI = ConnectionState.CONNECTING;
        if (this.bBK == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.bAQ = aVar;
        this.bBK = this.bAQ.hashCode();
        this.bBO = new b();
        this.mInspectorNativeClient = this.bAQ.initInspector(this.bBO);
        this.bBI = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0246a c0246a = this.bBE;
        if (c0246a == null) {
            c0246a = a.C0246a.Xl();
        }
        sb.append(c0246a.Xm()).append("\n");
        if (!c0246a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.bBH == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.bBJ != null || (this.bBH == ConnectionState.CONNECTING && currentTimeMillis - this.bBN > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.bBH == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.bBA).append("\n");
        if (this.bBH == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.bBG != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.bBF) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.bBC) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        if (this.bBL != null && this.bBH != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.bBB);
            }
            try {
                this.bBL.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.bBL = null;
        this.bBN = 0L;
        this.bBH = ConnectionState.CLOSED;
        this.bAQ = null;
        this.bBO = null;
        this.mInspectorNativeClient = null;
        this.bBI = ConnectionState.CLOSED;
        this.bBG = null;
        this.bBz.clear();
        if (!z) {
            this.bBF = false;
            this.bBJ = null;
            this.bBA = null;
            this.bBB = null;
            this.bBC = false;
            this.bBD = false;
            this.bBE = null;
        }
    }

    public void close() {
        L(false);
    }
}
