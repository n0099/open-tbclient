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
/* loaded from: classes11.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint cZa = new SwanInspectorEndpoint();
    private com.baidu.swan.games.f.a cYC;
    private String cZc;
    private String cZd;
    private a.C0427a cZg;
    private Runnable cZi;
    private Throwable cZl;
    private int cZm;
    private WebSocketTask cZn;
    private InspectorNativeChannel cZq;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bSz = new LinkedBlockingQueue<>();
    private boolean cZe = false;
    private boolean cZf = false;
    private boolean cZh = false;
    private ConnectionState cZj = ConnectionState.CLOSED;
    private ConnectionState cZk = ConnectionState.CLOSED;
    private int cZo = 0;
    private long cZp = 0;
    private String cZb = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes11.dex */
    private static class a {
        private String cZr;
        private JSONObject cZs;

        public a(String str) {
            this.cZr = str;
        }

        public boolean aAL() {
            return "Debugger.enable".equals(bK(aAN()));
        }

        public boolean aAM() {
            String bK = bK(aAN());
            return bK != null && bK.indexOf("Debugger.") == 0;
        }

        private JSONObject aAN() {
            if (this.cZs == null) {
                this.cZs = rV(this.cZr);
            }
            return this.cZs;
        }

        private JSONObject rV(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String bK(JSONObject jSONObject) {
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
    /* loaded from: classes11.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.cZn.send(str);
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
                SwanInspectorEndpoint.this.cZh = true;
                return (String) SwanInspectorEndpoint.this.bSz.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c implements IWebSocketListener {
        private int cZu;

        public c(int i) {
            this.cZu = -1;
            this.cZu = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.cZu == SwanInspectorEndpoint.this.cZo) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.cZd);
                }
                SwanInspectorEndpoint.this.cZj = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.cZu == SwanInspectorEndpoint.this.cZo) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.cZd);
                }
                SwanInspectorEndpoint.this.cZj = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.au(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.cZu == SwanInspectorEndpoint.this.cZo) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.cZk != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.cZf || !aVar.aAM()) {
                    SwanInspectorEndpoint.this.bSz.offer(str);
                    SwanInspectorEndpoint.this.cYC.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.cZh = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bSz.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bSz.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.cZi != null && aVar.aAL()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.cZi;
                        SwanInspectorEndpoint.this.cZi = null;
                        SwanInspectorEndpoint.this.cYC.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.cZu == SwanInspectorEndpoint.this.cZo) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.cZl = th;
            }
        }
    }

    public static SwanInspectorEndpoint aAK() {
        return cZa;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0427a c0427a, Runnable runnable) {
        au(false);
        a(c0427a);
        try {
            u(aVar2);
            if (aVar.aAF()) {
                this.cZi = runnable;
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

    public void a(a.C0427a c0427a) {
        this.cZg = c0427a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.cZj = ConnectionState.CONNECTING;
        this.cZc = aVar.aAG();
        this.cZf = aVar.aAH();
        this.cZe = aVar.aAF();
        this.cZd = "ws://" + this.cZc + "/inspect/inspectorTarget/" + this.cZb;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.cZd);
        }
        this.cZp = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.cZd);
        int i = this.cZo + 1;
        this.cZo = i;
        this.cZn = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.cZk = ConnectionState.CONNECTING;
        if (this.cZm == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.cYC = aVar;
        this.cZm = this.cYC.hashCode();
        this.cZq = new b();
        this.mInspectorNativeClient = this.cYC.initInspector(this.cZq);
        this.cZk = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0427a c0427a = this.cZg;
        if (c0427a == null) {
            c0427a = a.C0427a.aAI();
        }
        sb.append(c0427a.aAJ()).append("\n");
        if (!c0427a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.cZj == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.cZl != null || (this.cZj == ConnectionState.CONNECTING && currentTimeMillis - this.cZp > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.cZj == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.cZc).append("\n");
        if (this.cZj == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.cZi != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.cZh) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.cZe) {
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
        if (this.cZn != null && this.cZj != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.cZd);
            }
            try {
                this.cZn.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.cZn = null;
        this.cZp = 0L;
        this.cZj = ConnectionState.CLOSED;
        this.cYC = null;
        this.cZq = null;
        this.mInspectorNativeClient = null;
        this.cZk = ConnectionState.CLOSED;
        this.cZi = null;
        this.bSz.clear();
        if (!z) {
            this.cZh = false;
            this.cZl = null;
            this.cZc = null;
            this.cZd = null;
            this.cZe = false;
            this.cZf = false;
            this.cZg = null;
        }
    }

    public void close() {
        au(false);
    }
}
