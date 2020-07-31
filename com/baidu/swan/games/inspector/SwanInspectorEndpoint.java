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
    private static SwanInspectorEndpoint djy = new SwanInspectorEndpoint();
    private String djA;
    private String djB;
    private a.C0446a djE;
    private Runnable djG;
    private Throwable djJ;
    private int djK;
    private WebSocketTask djL;
    private InspectorNativeChannel djO;
    private com.baidu.swan.games.f.a dja;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bYg = new LinkedBlockingQueue<>();
    private boolean djC = false;
    private boolean djD = false;
    private boolean djF = false;
    private ConnectionState djH = ConnectionState.CLOSED;
    private ConnectionState djI = ConnectionState.CLOSED;
    private int djM = 0;
    private long djN = 0;
    private String djz = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes7.dex */
    private static class a {
        private String djP;
        private JSONObject djQ;

        public a(String str) {
            this.djP = str;
        }

        public boolean aFy() {
            return "Debugger.enable".equals(bX(aFA()));
        }

        public boolean aFz() {
            String bX = bX(aFA());
            return bX != null && bX.indexOf("Debugger.") == 0;
        }

        private JSONObject aFA() {
            if (this.djQ == null) {
                this.djQ = tc(this.djP);
            }
            return this.djQ;
        }

        private JSONObject tc(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String bX(JSONObject jSONObject) {
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
                SwanInspectorEndpoint.this.djL.send(str);
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
                SwanInspectorEndpoint.this.djF = true;
                return (String) SwanInspectorEndpoint.this.bYg.take();
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
        private int djS;

        public c(int i) {
            this.djS = -1;
            this.djS = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.djS == SwanInspectorEndpoint.this.djM) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.djB);
                }
                SwanInspectorEndpoint.this.djH = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.djS == SwanInspectorEndpoint.this.djM) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.djB);
                }
                SwanInspectorEndpoint.this.djH = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.av(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.djS == SwanInspectorEndpoint.this.djM) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.djI != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.djD || !aVar.aFz()) {
                    SwanInspectorEndpoint.this.bYg.offer(str);
                    SwanInspectorEndpoint.this.dja.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.djF = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bYg.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bYg.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.djG != null && aVar.aFy()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.djG;
                        SwanInspectorEndpoint.this.djG = null;
                        SwanInspectorEndpoint.this.dja.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.djS == SwanInspectorEndpoint.this.djM) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.djJ = th;
            }
        }
    }

    public static SwanInspectorEndpoint aFx() {
        return djy;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0446a c0446a, Runnable runnable) {
        av(false);
        a(c0446a);
        try {
            u(aVar2);
            if (aVar.aFs()) {
                this.djG = runnable;
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

    public void a(a.C0446a c0446a) {
        this.djE = c0446a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.djH = ConnectionState.CONNECTING;
        this.djA = aVar.aFt();
        this.djD = aVar.aFu();
        this.djC = aVar.aFs();
        this.djB = "ws://" + this.djA + "/inspect/inspectorTarget/" + this.djz;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.djB);
        }
        this.djN = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.djB);
        int i = this.djM + 1;
        this.djM = i;
        this.djL = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.djI = ConnectionState.CONNECTING;
        if (this.djK == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.dja = aVar;
        this.djK = this.dja.hashCode();
        this.djO = new b();
        this.mInspectorNativeClient = this.dja.initInspector(this.djO);
        this.djI = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0446a c0446a = this.djE;
        if (c0446a == null) {
            c0446a = a.C0446a.aFv();
        }
        sb.append(c0446a.aFw()).append("\n");
        if (!c0446a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.djH == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.djJ != null || (this.djH == ConnectionState.CONNECTING && currentTimeMillis - this.djN > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.djH == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.djA).append("\n");
        if (this.djH == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.djG != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.djF) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.djC) {
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
        if (this.djL != null && this.djH != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.djB);
            }
            try {
                this.djL.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.djL = null;
        this.djN = 0L;
        this.djH = ConnectionState.CLOSED;
        this.dja = null;
        this.djO = null;
        this.mInspectorNativeClient = null;
        this.djI = ConnectionState.CLOSED;
        this.djG = null;
        this.bYg.clear();
        if (!z) {
            this.djF = false;
            this.djJ = null;
            this.djA = null;
            this.djB = null;
            this.djC = false;
            this.djD = false;
            this.djE = null;
        }
    }

    public void close() {
        av(false);
    }
}
