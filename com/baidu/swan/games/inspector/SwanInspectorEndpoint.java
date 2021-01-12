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
    private static SwanInspectorEndpoint efB = new SwanInspectorEndpoint();
    private String efD;
    private String efE;
    private a.C0518a efH;
    private Runnable efJ;
    private Throwable efM;
    private int efN;
    private WebSocketTask efO;
    private InspectorNativeChannel efR;
    private com.baidu.swan.games.f.a efd;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cLY = new LinkedBlockingQueue<>();
    private boolean efF = false;
    private boolean efG = false;
    private boolean efI = false;
    private ConnectionState efK = ConnectionState.CLOSED;
    private ConnectionState efL = ConnectionState.CLOSED;
    private int efP = 0;
    private long efQ = 0;
    private String efC = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes8.dex */
    private static class a {
        private String efS;
        private JSONObject efT;

        public a(String str) {
            this.efS = str;
        }

        public boolean aWZ() {
            return "Debugger.enable".equals(cA(aXb()));
        }

        public boolean aXa() {
            String cA = cA(aXb());
            return cA != null && cA.indexOf("Debugger.") == 0;
        }

        private JSONObject aXb() {
            if (this.efT == null) {
                this.efT = wv(this.efS);
            }
            return this.efT;
        }

        private JSONObject wv(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cA(JSONObject jSONObject) {
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
                SwanInspectorEndpoint.this.efO.send(str);
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
                SwanInspectorEndpoint.this.efI = true;
                return (String) SwanInspectorEndpoint.this.cLY.take();
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
        private int efV;

        public c(int i) {
            this.efV = -1;
            this.efV = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.efV == SwanInspectorEndpoint.this.efP) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.efE);
                }
                SwanInspectorEndpoint.this.efK = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.efV == SwanInspectorEndpoint.this.efP) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.efE);
                }
                SwanInspectorEndpoint.this.efK = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.au(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.efV == SwanInspectorEndpoint.this.efP) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.efL != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.efG || !aVar.aXa()) {
                    SwanInspectorEndpoint.this.cLY.offer(str);
                    SwanInspectorEndpoint.this.efd.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.efI = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cLY.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cLY.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.efJ != null && aVar.aWZ()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.efJ;
                        SwanInspectorEndpoint.this.efJ = null;
                        SwanInspectorEndpoint.this.efd.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.efV == SwanInspectorEndpoint.this.efP) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.efM = th;
            }
        }
    }

    public static SwanInspectorEndpoint aWY() {
        return efB;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0518a c0518a, Runnable runnable) {
        au(false);
        a(c0518a);
        try {
            u(aVar2);
            if (aVar.aWT()) {
                this.efJ = runnable;
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

    public void a(a.C0518a c0518a) {
        this.efH = c0518a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.efK = ConnectionState.CONNECTING;
        this.efD = aVar.aWU();
        this.efG = aVar.aWV();
        this.efF = aVar.aWT();
        this.efE = "ws://" + this.efD + "/inspect/inspectorTarget/" + this.efC;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.efE);
        }
        this.efQ = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.efE);
        int i = this.efP + 1;
        this.efP = i;
        this.efO = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.efL = ConnectionState.CONNECTING;
        if (this.efN == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.efd = aVar;
        this.efN = this.efd.hashCode();
        this.efR = new b();
        this.mInspectorNativeClient = this.efd.initInspector(this.efR);
        this.efL = ConnectionState.OPEN;
    }

    public String g(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0518a c0518a = this.efH;
        if (c0518a == null) {
            c0518a = a.C0518a.aWW();
        }
        sb.append(c0518a.aWX()).append("\n");
        if (!c0518a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.efK == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.efM != null || (this.efK == ConnectionState.CONNECTING && currentTimeMillis - this.efQ > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.efK == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.efD).append("\n");
        if (this.efK == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.efJ != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.efI) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.efF) {
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
        if (this.efO != null && this.efK != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.efE);
            }
            try {
                this.efO.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.efO = null;
        this.efQ = 0L;
        this.efK = ConnectionState.CLOSED;
        this.efd = null;
        this.efR = null;
        this.mInspectorNativeClient = null;
        this.efL = ConnectionState.CLOSED;
        this.efJ = null;
        this.cLY.clear();
        if (!z) {
            this.efI = false;
            this.efM = null;
            this.efD = null;
            this.efE = null;
            this.efF = false;
            this.efG = false;
            this.efH = null;
        }
    }

    public void close() {
        au(false);
    }
}
