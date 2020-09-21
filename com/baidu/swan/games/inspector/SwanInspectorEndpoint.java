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
/* loaded from: classes3.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint dvL = new SwanInspectorEndpoint();
    private String dvN;
    private String dvO;
    private a.C0489a dvR;
    private Runnable dvT;
    private Throwable dvW;
    private int dvX;
    private WebSocketTask dvY;
    private com.baidu.swan.games.f.a dvn;
    private InspectorNativeChannel dwb;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> cfV = new LinkedBlockingQueue<>();
    private boolean dvP = false;
    private boolean dvQ = false;
    private boolean dvS = false;
    private ConnectionState dvU = ConnectionState.CLOSED;
    private ConnectionState dvV = ConnectionState.CLOSED;
    private int dvZ = 0;
    private long dwa = 0;
    private String dvM = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes3.dex */
    private static class a {
        private String dwc;
        private JSONObject dwd;

        public a(String str) {
            this.dwc = str;
        }

        public boolean aOY() {
            return "Debugger.enable".equals(cg(aPa()));
        }

        public boolean aOZ() {
            String cg = cg(aPa());
            return cg != null && cg.indexOf("Debugger.") == 0;
        }

        private JSONObject aPa() {
            if (this.dwd == null) {
                this.dwd = vM(this.dwc);
            }
            return this.dwd;
        }

        private JSONObject vM(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String cg(JSONObject jSONObject) {
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
    /* loaded from: classes3.dex */
    public class b extends InspectorNativeChannel {
        private b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                SwanInspectorEndpoint.this.dvY.send(str);
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
                SwanInspectorEndpoint.this.dvS = true;
                return (String) SwanInspectorEndpoint.this.cfV.take();
            } catch (InterruptedException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "awaitMessage on Debugger", e);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c implements IWebSocketListener {
        private int dwf;

        public c(int i) {
            this.dwf = -1;
            this.dwf = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.dwf == SwanInspectorEndpoint.this.dvZ) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.dvO);
                }
                SwanInspectorEndpoint.this.dvU = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.dwf == SwanInspectorEndpoint.this.dvZ) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.dvO);
                }
                SwanInspectorEndpoint.this.dvU = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.aw(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.dwf == SwanInspectorEndpoint.this.dvZ) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.dvV != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.dvQ || !aVar.aOZ()) {
                    SwanInspectorEndpoint.this.cfV.offer(str);
                    SwanInspectorEndpoint.this.dvn.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.dvS = false;
                            String str2 = (String) SwanInspectorEndpoint.this.cfV.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.cfV.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.dvT != null && aVar.aOY()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.dvT;
                        SwanInspectorEndpoint.this.dvT = null;
                        SwanInspectorEndpoint.this.dvn.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.dwf == SwanInspectorEndpoint.this.dvZ) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.dvW = th;
            }
        }
    }

    public static SwanInspectorEndpoint aOX() {
        return dvL;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0489a c0489a, Runnable runnable) {
        aw(false);
        a(c0489a);
        try {
            u(aVar2);
            if (aVar.aOS()) {
                this.dvT = runnable;
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

    public void a(a.C0489a c0489a) {
        this.dvR = c0489a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.dvU = ConnectionState.CONNECTING;
        this.dvN = aVar.aOT();
        this.dvQ = aVar.aOU();
        this.dvP = aVar.aOS();
        this.dvO = "ws://" + this.dvN + "/inspect/inspectorTarget/" + this.dvM;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.dvO);
        }
        this.dwa = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.dvO);
        int i = this.dvZ + 1;
        this.dvZ = i;
        this.dvY = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.dvV = ConnectionState.CONNECTING;
        if (this.dvX == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.dvn = aVar;
        this.dvX = this.dvn.hashCode();
        this.dwb = new b();
        this.mInspectorNativeClient = this.dvn.initInspector(this.dwb);
        this.dvV = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0489a c0489a = this.dvR;
        if (c0489a == null) {
            c0489a = a.C0489a.aOV();
        }
        sb.append(c0489a.aOW()).append("\n");
        if (!c0489a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.dvU == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.dvW != null || (this.dvU == ConnectionState.CONNECTING && currentTimeMillis - this.dwa > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.dvU == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.dvN).append("\n");
        if (this.dvU == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.dvT != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.dvS) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.dvP) {
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
        if (this.dvY != null && this.dvU != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.dvO);
            }
            try {
                this.dvY.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.dvY = null;
        this.dwa = 0L;
        this.dvU = ConnectionState.CLOSED;
        this.dvn = null;
        this.dwb = null;
        this.mInspectorNativeClient = null;
        this.dvV = ConnectionState.CLOSED;
        this.dvT = null;
        this.cfV.clear();
        if (!z) {
            this.dvS = false;
            this.dvW = null;
            this.dvN = null;
            this.dvO = null;
            this.dvP = false;
            this.dvQ = false;
            this.dvR = null;
        }
    }

    public void close() {
        aw(false);
    }
}
