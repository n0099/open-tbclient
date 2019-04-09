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
    private static SwanInspectorEndpoint bdp = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a bcM;
    private Throwable bdB;
    private WebSocketTask bdC;
    private InspectorNativeChannel bdF;
    private String bds;
    private String bdt;
    private a.C0193a bdw;
    private Runnable bdy;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bdr = new LinkedBlockingQueue<>();
    private boolean bdu = false;
    private boolean bdv = false;
    private boolean bdx = false;
    private ConnectionState bdz = ConnectionState.CLOSED;
    private ConnectionState bdA = ConnectionState.CLOSED;
    private int bdD = 0;
    private long bdE = 0;
    private String bdq = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    public static SwanInspectorEndpoint Ox() {
        return bdp;
    }

    private SwanInspectorEndpoint() {
    }

    public String b(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0193a c0193a = this.bdw;
        if (c0193a == null) {
            c0193a = a.C0193a.Ov();
        }
        sb.append(c0193a.Ow()).append("\n");
        if (!c0193a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.bdz == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.bdB != null || (this.bdz == ConnectionState.CONNECTING && currentTimeMillis - this.bdE > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.bdz == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.bds).append("\n");
        if (this.bdz == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.bdy != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.bdx) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.bdu) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    private void clear(boolean z) {
        if (this.bdC != null && this.bdz != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.bdt);
            }
            try {
                this.bdC.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.bdC = null;
        this.bdE = 0L;
        this.bdz = ConnectionState.CLOSED;
        this.bcM = null;
        this.bdF = null;
        this.mInspectorNativeClient = null;
        this.bdA = ConnectionState.CLOSED;
        this.bdy = null;
        this.bdr.clear();
        if (!z) {
            this.bdx = false;
            this.bdB = null;
            this.bds = null;
            this.bdt = null;
            this.bdu = false;
            this.bdv = false;
            this.bdw = null;
        }
    }

    public void close() {
        clear(false);
    }
}
