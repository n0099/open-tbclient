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
    private static SwanInspectorEndpoint dQj = new SwanInspectorEndpoint();
    private com.baidu.swan.games.f.a dPL;
    private String dQl;
    private String dQm;
    private a.C0520a dQp;
    private Runnable dQr;
    private Throwable dQu;
    private int dQv;
    private WebSocketTask dQw;
    private InspectorNativeChannel dQz;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cAM = new LinkedBlockingQueue<>();
    private boolean dQn = false;
    private boolean dQo = false;
    private boolean dQq = false;
    private ConnectionState dQs = ConnectionState.CLOSED;
    private ConnectionState dQt = ConnectionState.CLOSED;
    private int dQx = 0;
    private long dQy = 0;
    private String dQk = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes10.dex */
    private static class a {
        private String dQA;
        private JSONObject dQB;

        public a(String str) {
            this.dQA = str;
        }

        public boolean aTB() {
            return "Debugger.enable".equals(cq(aTD()));
        }

        public boolean aTC() {
            String cq = cq(aTD());
            return cq != null && cq.indexOf("Debugger.") == 0;
        }

        private JSONObject aTD() {
            if (this.dQB == null) {
                this.dQB = wR(this.dQA);
            }
            return this.dQB;
        }

        private JSONObject wR(String str) {
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
    /* loaded from: classes10.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.dQw.send(str);
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
                SwanInspectorEndpoint.this.dQq = true;
                return (String) SwanInspectorEndpoint.this.cAM.take();
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
        private int dQD;

        public c(int i) {
            this.dQD = -1;
            this.dQD = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.dQD == SwanInspectorEndpoint.this.dQx) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.dQm);
                }
                SwanInspectorEndpoint.this.dQs = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.dQD == SwanInspectorEndpoint.this.dQx) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.dQm);
                }
                SwanInspectorEndpoint.this.dQs = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.aw(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.dQD == SwanInspectorEndpoint.this.dQx) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.dQt != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.dQo || !aVar.aTC()) {
                    SwanInspectorEndpoint.this.cAM.offer(str);
                    SwanInspectorEndpoint.this.dPL.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.dQq = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cAM.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cAM.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.dQr != null && aVar.aTB()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.dQr;
                        SwanInspectorEndpoint.this.dQr = null;
                        SwanInspectorEndpoint.this.dPL.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.dQD == SwanInspectorEndpoint.this.dQx) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.dQu = th;
            }
        }
    }

    public static SwanInspectorEndpoint aTA() {
        return dQj;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0520a c0520a, Runnable runnable) {
        aw(false);
        a(c0520a);
        try {
            u(aVar2);
            if (aVar.aTv()) {
                this.dQr = runnable;
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

    public void a(a.C0520a c0520a) {
        this.dQp = c0520a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.dQs = ConnectionState.CONNECTING;
        this.dQl = aVar.aTw();
        this.dQo = aVar.aTx();
        this.dQn = aVar.aTv();
        this.dQm = "ws://" + this.dQl + "/inspect/inspectorTarget/" + this.dQk;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.dQm);
        }
        this.dQy = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.dQm);
        int i = this.dQx + 1;
        this.dQx = i;
        this.dQw = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.dQt = ConnectionState.CONNECTING;
        if (this.dQv == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.dPL = aVar;
        this.dQv = this.dPL.hashCode();
        this.dQz = new b();
        this.mInspectorNativeClient = this.dPL.initInspector(this.dQz);
        this.dQt = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0520a c0520a = this.dQp;
        if (c0520a == null) {
            c0520a = a.C0520a.aTy();
        }
        sb.append(c0520a.aTz()).append("\n");
        if (!c0520a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.dQs == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.dQu != null || (this.dQs == ConnectionState.CONNECTING && currentTimeMillis - this.dQy > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.dQs == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.dQl).append("\n");
        if (this.dQs == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.dQr != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.dQq) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.dQn) {
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
        if (this.dQw != null && this.dQs != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.dQm);
            }
            try {
                this.dQw.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.dQw = null;
        this.dQy = 0L;
        this.dQs = ConnectionState.CLOSED;
        this.dPL = null;
        this.dQz = null;
        this.mInspectorNativeClient = null;
        this.dQt = ConnectionState.CLOSED;
        this.dQr = null;
        this.cAM.clear();
        if (!z) {
            this.dQq = false;
            this.dQu = null;
            this.dQl = null;
            this.dQm = null;
            this.dQn = false;
            this.dQo = false;
            this.dQp = null;
        }
    }

    public void close() {
        aw(false);
    }
}
