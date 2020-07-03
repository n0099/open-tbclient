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
    private static SwanInspectorEndpoint ddO = new SwanInspectorEndpoint();
    private String ddQ;
    private String ddR;
    private a.C0433a ddU;
    private Runnable ddW;
    private Throwable ddZ;
    private com.baidu.swan.games.f.a ddp;
    private int dea;
    private WebSocketTask deb;
    private InspectorNativeChannel dee;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bXn = new LinkedBlockingQueue<>();
    private boolean ddS = false;
    private boolean ddT = false;
    private boolean ddV = false;
    private ConnectionState ddX = ConnectionState.CLOSED;
    private ConnectionState ddY = ConnectionState.CLOSED;
    private int dec = 0;
    private long ded = 0;
    private String ddP = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes11.dex */
    private static class a {
        private String def;
        private JSONObject deg;

        public a(String str) {
            this.def = str;
        }

        public boolean aBR() {
            return "Debugger.enable".equals(bR(aBT()));
        }

        public boolean aBS() {
            String bR = bR(aBT());
            return bR != null && bR.indexOf("Debugger.") == 0;
        }

        private JSONObject aBT() {
            if (this.deg == null) {
                this.deg = sd(this.def);
            }
            return this.deg;
        }

        private JSONObject sd(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "Illegal inspector message: ", e);
                }
                return null;
            }
        }

        private String bR(JSONObject jSONObject) {
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
                SwanInspectorEndpoint.this.deb.send(str);
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
                SwanInspectorEndpoint.this.ddV = true;
                return (String) SwanInspectorEndpoint.this.bXn.take();
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
        private int dei;

        public c(int i) {
            this.dei = -1;
            this.dei = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.dei == SwanInspectorEndpoint.this.dec) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.ddR);
                }
                SwanInspectorEndpoint.this.ddX = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.dei == SwanInspectorEndpoint.this.dec) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.ddR);
                }
                SwanInspectorEndpoint.this.ddX = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.av(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.dei == SwanInspectorEndpoint.this.dec) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.ddY != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.ddT || !aVar.aBS()) {
                    SwanInspectorEndpoint.this.bXn.offer(str);
                    SwanInspectorEndpoint.this.ddp.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.ddV = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bXn.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bXn.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.ddW != null && aVar.aBR()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.ddW;
                        SwanInspectorEndpoint.this.ddW = null;
                        SwanInspectorEndpoint.this.ddp.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.dei == SwanInspectorEndpoint.this.dec) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.ddZ = th;
            }
        }
    }

    public static SwanInspectorEndpoint aBQ() {
        return ddO;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.f.a aVar2, a.C0433a c0433a, Runnable runnable) {
        av(false);
        a(c0433a);
        try {
            u(aVar2);
            if (aVar.aBL()) {
                this.ddW = runnable;
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

    public void a(a.C0433a c0433a) {
        this.ddU = c0433a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.ddX = ConnectionState.CONNECTING;
        this.ddQ = aVar.aBM();
        this.ddT = aVar.aBN();
        this.ddS = aVar.aBL();
        this.ddR = "ws://" + this.ddQ + "/inspect/inspectorTarget/" + this.ddP;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.ddR);
        }
        this.ded = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.ddR);
        int i = this.dec + 1;
        this.dec = i;
        this.deb = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void u(com.baidu.swan.games.f.a aVar) throws Exception {
        this.ddY = ConnectionState.CONNECTING;
        if (this.dea == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.ddp = aVar;
        this.dea = this.ddp.hashCode();
        this.dee = new b();
        this.mInspectorNativeClient = this.ddp.initInspector(this.dee);
        this.ddY = ConnectionState.OPEN;
    }

    public String a(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0433a c0433a = this.ddU;
        if (c0433a == null) {
            c0433a = a.C0433a.aBO();
        }
        sb.append(c0433a.aBP()).append("\n");
        if (!c0433a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.ddX == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.ddZ != null || (this.ddX == ConnectionState.CONNECTING && currentTimeMillis - this.ded > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.ddX == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.ddQ).append("\n");
        if (this.ddX == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.ddW != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.ddV) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.ddS) {
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
        if (this.deb != null && this.ddX != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.ddR);
            }
            try {
                this.deb.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.deb = null;
        this.ded = 0L;
        this.ddX = ConnectionState.CLOSED;
        this.ddp = null;
        this.dee = null;
        this.mInspectorNativeClient = null;
        this.ddY = ConnectionState.CLOSED;
        this.ddW = null;
        this.bXn.clear();
        if (!z) {
            this.ddV = false;
            this.ddZ = null;
            this.ddQ = null;
            this.ddR = null;
            this.ddS = false;
            this.ddT = false;
            this.ddU = null;
        }
    }

    public void close() {
        av(false);
    }
}
