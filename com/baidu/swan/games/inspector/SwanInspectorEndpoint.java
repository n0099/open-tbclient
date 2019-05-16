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
    private static SwanInspectorEndpoint bhw = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a bgP;
    private String bhA;
    private a.C0203a bhD;
    private Runnable bhF;
    private Throwable bhI;
    private int bhJ;
    private WebSocketTask bhK;
    private InspectorNativeChannel bhN;
    private String bhz;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bhy = new LinkedBlockingQueue<>();
    private boolean bhB = false;
    private boolean bhC = false;
    private boolean bhE = false;
    private ConnectionState bhG = ConnectionState.CLOSED;
    private ConnectionState bhH = ConnectionState.CLOSED;
    private int bhL = 0;
    private long bhM = 0;
    private String bhx = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    /* loaded from: classes2.dex */
    private static class a {
        private String bhO;
        private JSONObject bhP;

        public a(String str) {
            this.bhO = str;
        }

        public boolean RA() {
            return "Debugger.enable".equals(as(RC()));
        }

        public boolean RB() {
            String as = as(RC());
            return as != null && as.indexOf("Debugger.") == 0;
        }

        private JSONObject RC() {
            if (this.bhP == null) {
                this.bhP = jv(this.bhO);
            }
            return this.bhP;
        }

        private JSONObject jv(String str) {
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
                SwanInspectorEndpoint.this.bhK.send(str);
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
                SwanInspectorEndpoint.this.bhE = true;
                return (String) SwanInspectorEndpoint.this.bhy.take();
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
        private int bhR;

        public c(int i) {
            this.bhR = -1;
            this.bhR = i;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map map) {
            if (this.bhR == SwanInspectorEndpoint.this.bhL) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onOpened: " + SwanInspectorEndpoint.this.bhA);
                }
                SwanInspectorEndpoint.this.bhG = ConnectionState.OPEN;
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            if (this.bhR == SwanInspectorEndpoint.this.bhL) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.i("SwanInspector", "WebSocket connect onClose: " + SwanInspectorEndpoint.this.bhA);
                }
                SwanInspectorEndpoint.this.bhG = ConnectionState.CLOSED;
                SwanInspectorEndpoint.this.clear(true);
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            if (this.bhR == SwanInspectorEndpoint.this.bhL) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.d("SwanInspector", "WebSocket onMessage: " + str);
                }
                if (SwanInspectorEndpoint.this.bhH != ConnectionState.OPEN) {
                    if (SwanInspectorEndpoint.DEBUG) {
                        Log.e("SwanInspector", str, new Exception("Illegal state: " + ConnectionState.OPEN));
                        return;
                    }
                    return;
                }
                a aVar = new a(str);
                if (!SwanInspectorEndpoint.this.bhC || !aVar.RB()) {
                    SwanInspectorEndpoint.this.bhy.offer(str);
                    SwanInspectorEndpoint.this.bgP.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanInspectorEndpoint.this.bhE = false;
                            String str2 = (String) SwanInspectorEndpoint.this.bhy.poll();
                            while (str2 != null) {
                                SwanInspectorEndpoint.this.mInspectorNativeClient.dispatchProtocolMessage(str2);
                                str2 = (String) SwanInspectorEndpoint.this.bhy.poll();
                            }
                        }
                    });
                    if (SwanInspectorEndpoint.this.bhF != null && aVar.RA()) {
                        final Runnable runnable = SwanInspectorEndpoint.this.bhF;
                        SwanInspectorEndpoint.this.bhF = null;
                        SwanInspectorEndpoint.this.bgP.postOnJSThread(new Runnable() { // from class: com.baidu.swan.games.inspector.SwanInspectorEndpoint.c.2
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
            if (this.bhR == SwanInspectorEndpoint.this.bhL) {
                if (SwanInspectorEndpoint.DEBUG) {
                    Log.e("SwanInspector", "WebSocket connect onError.", th);
                }
                SwanInspectorEndpoint.this.bhI = th;
            }
        }
    }

    public static SwanInspectorEndpoint Rz() {
        return bhw;
    }

    private SwanInspectorEndpoint() {
    }

    public void a(com.baidu.swan.games.inspector.a aVar, com.baidu.swan.games.e.a aVar2, a.C0203a c0203a, Runnable runnable) {
        clear(false);
        a(c0203a);
        try {
            x(aVar2);
            if (aVar.Ru()) {
                this.bhF = runnable;
                b(aVar);
            } else {
                b(aVar);
                runnable.run();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanInspector", "Init fail", e);
            }
            clear(true);
        }
    }

    public void a(a.C0203a c0203a) {
        this.bhD = c0203a;
    }

    private void b(com.baidu.swan.games.inspector.a aVar) {
        this.bhG = ConnectionState.CONNECTING;
        this.bhz = aVar.Rv();
        this.bhC = aVar.Rw();
        this.bhB = aVar.Ru();
        this.bhA = "ws://" + this.bhz + "/inspect/inspectorTarget/" + this.bhx;
        if (DEBUG) {
            Log.i("SwanInspector", "Starting inspector to " + this.bhA);
        }
        this.bhM = System.currentTimeMillis();
        WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
        WebSocketRequest webSocketRequest = new WebSocketRequest(this.bhA);
        int i = this.bhL + 1;
        this.bhL = i;
        this.bhK = webSocketManager.connect(webSocketRequest, new c(i));
    }

    private void x(com.baidu.swan.games.e.a aVar) throws Exception {
        this.bhH = ConnectionState.CONNECTING;
        if (this.bhJ == aVar.hashCode()) {
            throw new Exception("Can not use the previous connected v8Engine.");
        }
        this.bgP = aVar;
        this.bhJ = this.bgP.hashCode();
        this.bhN = new b();
        this.mInspectorNativeClient = this.bgP.initInspector(this.bhN);
        this.bhH = ConnectionState.OPEN;
    }

    public String b(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0203a c0203a = this.bhD;
        if (c0203a == null) {
            c0203a = a.C0203a.Rx();
        }
        sb.append(c0203a.Ry()).append("\n");
        if (!c0203a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.bhG == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.bhI != null || (this.bhG == ConnectionState.CONNECTING && currentTimeMillis - this.bhM > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.bhG == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.bhz).append("\n");
        if (this.bhG == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.bhF != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.bhE) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.bhB) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear(boolean z) {
        if (this.bhK != null && this.bhG != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.bhA);
            }
            try {
                this.bhK.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.bhK = null;
        this.bhM = 0L;
        this.bhG = ConnectionState.CLOSED;
        this.bgP = null;
        this.bhN = null;
        this.mInspectorNativeClient = null;
        this.bhH = ConnectionState.CLOSED;
        this.bhF = null;
        this.bhy.clear();
        if (!z) {
            this.bhE = false;
            this.bhI = null;
            this.bhz = null;
            this.bhA = null;
            this.bhB = false;
            this.bhC = false;
            this.bhD = null;
        }
    }

    public void close() {
        clear(false);
    }
}
