package com.baidu.swan.games.inspector;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.inspector.a;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SwanInspectorEndpoint bdo = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a bcL;
    private Throwable bdA;
    private WebSocketTask bdB;
    private InspectorNativeChannel bdE;
    private String bdr;
    private String bds;
    private a.C0193a bdv;
    private Runnable bdx;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bdq = new LinkedBlockingQueue<>();
    private boolean bdt = false;
    private boolean bdu = false;
    private boolean bdw = false;
    private ConnectionState bdy = ConnectionState.CLOSED;
    private ConnectionState bdz = ConnectionState.CLOSED;
    private int bdC = 0;
    private long bdD = 0;
    private String bdp = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    public static SwanInspectorEndpoint Ox() {
        return bdo;
    }

    private SwanInspectorEndpoint() {
    }

    public String b(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0193a c0193a = this.bdv;
        if (c0193a == null) {
            c0193a = a.C0193a.Ov();
        }
        sb.append(c0193a.Ow()).append("\n");
        if (!c0193a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.bdy == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.bdA != null || (this.bdy == ConnectionState.CONNECTING && currentTimeMillis - this.bdD > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.bdy == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.bdr).append("\n");
        if (this.bdy == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.bdx != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.bdw) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.bdt) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    private void clear(boolean z) {
        if (this.bdB != null && this.bdy != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.bds);
            }
            try {
                this.bdB.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.bdB = null;
        this.bdD = 0L;
        this.bdy = ConnectionState.CLOSED;
        this.bcL = null;
        this.bdE = null;
        this.mInspectorNativeClient = null;
        this.bdz = ConnectionState.CLOSED;
        this.bdx = null;
        this.bdq.clear();
        if (!z) {
            this.bdw = false;
            this.bdA = null;
            this.bdr = null;
            this.bds = null;
            this.bdt = false;
            this.bdu = false;
            this.bdv = null;
        }
    }

    public void close() {
        clear(false);
    }
}
