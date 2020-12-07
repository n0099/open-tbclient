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
/* loaded from: classes25.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint ebr = new SwanInspectorEndpoint();
    private com.baidu.swan.games.f.a eaT;
    private Throwable ebC;
    private int ebD;
    private WebSocketTask ebE;
    private InspectorNativeChannel ebH;
    private String ebt;
    private String ebu;
    private a.C0542a ebx;
    private Runnable ebz;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cLP = new LinkedBlockingQueue<>();
    private boolean ebv = false;
    private boolean ebw = false;
    private boolean eby = false;
    private ConnectionState ebA = ConnectionState.CLOSED;
    private ConnectionState ebB = ConnectionState.CLOSED;
    private int ebF = 0;
    private long ebG = 0;
    private String ebs = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes25.dex */
    private static class a {
        private String ebI;
        private JSONObject ebJ;

        public a(String str) {
            this.ebI = str;
        }

        public boolean aYy() {
            return "Debugger.enable".equals(cs(aYA()));
        }

        public boolean aYz() {
            String cs = cs(aYA());
            return cs != null && cs.indexOf("Debugger.") == 0;
        }

        private JSONObject aYA() {
            if (this.ebJ == null) {
                this.ebJ = xH(this.ebI);
            }
            return this.ebJ;
        }

        private JSONObject xH(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cs(JSONObject jSONObject) {
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
    /* loaded from: classes25.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.ebE.send(str);
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
                SwanInspectorEndpoint.this.eby = true;
                return (String) SwanInspectorEndpoint.this.cLP.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class c implements IWebSocketListener {
        private int ebL;

        public c(int i) {
            this.ebL = -1;
            this.ebL = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.ebL == SwanInspectorEndpoint.this.ebF) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.ebu);
                }
                SwanInspectorEndpoint.this.ebA = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.ebL == SwanInspectorEndpoint.this.ebF) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.ebu);
                }
                SwanInspectorEndpoint.this.ebA = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.av(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.ebL == SwanInspectorEndpoint.this.ebF) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.ebB != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.ebw || !aVar.aYz()) {
                    SwanInspectorEndpoint.this.cLP.offer(str);
                    SwanInspectorEndpoint.this.eaT.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.eby = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cLP.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cLP.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.ebz != null && aVar.aYy()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.ebz;
                        SwanInspectorEndpoint.this.ebz = null;
                        SwanInspectorEndpoint.this.eaT.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.ebL == SwanInspectorEndpoint.this.ebF) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.ebC = th;
            }
        }
    }

    public static SwanInspectorEndpoint aYx() {
        return ebr;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0542a c0542a, Runnable runnable) {
        av(false);
        a(c0542a);
        try {
            u(aVar2);
            if (aVar.aYs()) {
                this.ebz = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            av(true);
        }
    }

    public void a(a.C0542a c0542a) {
        this.ebx = c0542a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.ebA = ConnectionState.CONNECTING;
        this.ebt = aVar.aYt();
        this.ebw = aVar.aYu();
        this.ebv = aVar.aYs();
        this.ebu = "ws://" + this.ebt + "/inspect/inspectorTarget/" + this.ebs;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.ebu);
        }
        this.ebG = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.ebu);
        int i = this.ebF + 1;
        this.ebF = i;
        this.ebE = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.ebB = ConnectionState.CONNECTING;
        if (this.ebD == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.eaT = aVar;
        this.ebD = this.eaT.hashCode();
        this.ebH = new b();
        this.mInspectorNativeClient = this.eaT.initInspector(this.ebH);
        this.ebB = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0542a c0542a = this.ebx;
        if (c0542a == null) {
            c0542a = a.C0542a.aYv();
        }
        sb.append(c0542a.aYw()).append("\n");
        if (!c0542a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.ebA == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.ebC != null || (this.ebA == ConnectionState.CONNECTING && currentTimeMillis - this.ebG > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.ebA == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.ebt).append("\n");
        if (this.ebA == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.ebz != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.eby) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.ebv) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z) {
        if (this.ebE != null && this.ebA != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.ebu);
            }
            try {
                this.ebE.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.ebE = null;
        this.ebG = 0L;
        this.ebA = ConnectionState.CLOSED;
        this.eaT = null;
        this.ebH = null;
        this.mInspectorNativeClient = null;
        this.ebB = ConnectionState.CLOSED;
        this.ebz = null;
        this.cLP.clear();
        if (!z) {
            this.eby = false;
            this.ebC = null;
            this.ebt = null;
            this.ebu = null;
            this.ebv = false;
            this.ebw = false;
            this.ebx = null;
        }
    }

    public void close() {
        av(false);
    }
}
