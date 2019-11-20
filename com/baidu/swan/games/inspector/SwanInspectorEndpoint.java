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
    private static SwanInspectorEndpoint bAG = new SwanInspectorEndpoint();
    private String bAJ;
    private String bAK;
    private a.C0246a bAN;
    private Runnable bAP;
    private Throwable bAS;
    private int bAT;
    private WebSocketTask bAU;
    private InspectorNativeChannel bAX;
    private com.baidu.swan.games.e.a bzZ;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bAI = new LinkedBlockingQueue<>();
    private boolean bAL = false;
    private boolean bAM = false;
    private boolean bAO = false;
    private ConnectionState bAQ = ConnectionState.CLOSED;
    private ConnectionState bAR = ConnectionState.CLOSED;
    private int bAV = 0;
    private long bAW = 0;
    private String bAH = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes2.dex */
    private static class a {
        private String bAY;
        private JSONObject bAZ;

        public a(String str) {
            this.bAY = str;
        }

        public boolean Xm() {
            return "Debugger.enable".equals(aR(Xo()));
        }

        public boolean Xn() {
            String aR = aR(Xo());
            return aR != null && aR.indexOf("Debugger.") == 0;
        }

        private JSONObject Xo() {
            if (this.bAZ == null) {
                this.bAZ = kg(this.bAY);
            }
            return this.bAZ;
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

        private String aR(JSONObject jSONObject) {
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
                SwanInspectorEndpoint.this.bAU.send(str);
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
                SwanInspectorEndpoint.this.bAO = true;
                return (String) SwanInspectorEndpoint.this.bAI.take();
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
        private int bBb;

        public c(int i) {
            this.bBb = -1;
            this.bBb = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.bBb == SwanInspectorEndpoint.this.bAV) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.bAK);
                }
                SwanInspectorEndpoint.this.bAQ = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.bBb == SwanInspectorEndpoint.this.bAV) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.bAK);
                }
                SwanInspectorEndpoint.this.bAQ = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.L(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.bBb == SwanInspectorEndpoint.this.bAV) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.bAR != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.bAM || !aVar.Xn()) {
                    SwanInspectorEndpoint.this.bAI.offer(str);
                    SwanInspectorEndpoint.this.bzZ.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.bAO = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bAI.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bAI.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.bAP != null && aVar.Xm()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.bAP;
                        SwanInspectorEndpoint.this.bAP = null;
                        SwanInspectorEndpoint.this.bzZ.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.bBb == SwanInspectorEndpoint.this.bAV) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.bAS = th;
            }
        }
    }

    public static SwanInspectorEndpoint Xl() {
        return bAG;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0246a c0246a, Runnable runnable) {
        L(false);
        a(c0246a);
        try {
            x(aVar2);
            if (aVar.Xg()) {
                this.bAP = runnable;
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
        this.bAN = c0246a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.bAQ = ConnectionState.CONNECTING;
        this.bAJ = aVar.Xh();
        this.bAM = aVar.Xi();
        this.bAL = aVar.Xg();
        this.bAK = "ws://" + this.bAJ + "/inspect/inspectorTarget/" + this.bAH;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.bAK);
        }
        this.bAW = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.bAK);
        int i = this.bAV + 1;
        this.bAV = i;
        this.bAU = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void x(com.baidu.swan.games.e.a aVar) throws Exception {
        this.bAR = ConnectionState.CONNECTING;
        if (this.bAT == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.bzZ = aVar;
        this.bAT = this.bzZ.hashCode();
        this.bAX = new b();
        this.mInspectorNativeClient = this.bzZ.initInspector(this.bAX);
        this.bAR = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0246a c0246a = this.bAN;
        if (c0246a == null) {
            c0246a = a.C0246a.Xj();
        }
        sb.append(c0246a.Xk()).append("\n");
        if (!c0246a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.bAQ == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.bAS != null || (this.bAQ == ConnectionState.CONNECTING && currentTimeMillis - this.bAW > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.bAQ == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.bAJ).append("\n");
        if (this.bAQ == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.bAP != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.bAO) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.bAL) {
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
        if (this.bAU != null && this.bAQ != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.bAK);
            }
            try {
                this.bAU.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.bAU = null;
        this.bAW = 0L;
        this.bAQ = ConnectionState.CLOSED;
        this.bzZ = null;
        this.bAX = null;
        this.mInspectorNativeClient = null;
        this.bAR = ConnectionState.CLOSED;
        this.bAP = null;
        this.bAI.clear();
        if (!z) {
            this.bAO = false;
            this.bAS = null;
            this.bAJ = null;
            this.bAK = null;
            this.bAL = false;
            this.bAM = false;
            this.bAN = null;
        }
    }

    public void close() {
        L(false);
    }
}
