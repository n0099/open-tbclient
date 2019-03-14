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
    private static SwanInspectorEndpoint bdl = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a bcI;
    private InspectorNativeChannel bdB;
    private String bdo;
    private String bdp;
    private a.C0193a bds;
    private Runnable bdu;
    private Throwable bdx;
    private WebSocketTask bdy;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bdn = new LinkedBlockingQueue<>();
    private boolean bdq = false;
    private boolean bdr = false;
    private boolean bdt = false;
    private ConnectionState bdv = ConnectionState.CLOSED;
    private ConnectionState bdw = ConnectionState.CLOSED;
    private int bdz = 0;
    private long bdA = 0;
    private String bdm = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    public static SwanInspectorEndpoint Oz() {
        return bdl;
    }

    private SwanInspectorEndpoint() {
    }

    public String b(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0193a c0193a = this.bds;
        if (c0193a == null) {
            c0193a = a.C0193a.Ox();
        }
        sb.append(c0193a.Oy()).append("\n");
        if (!c0193a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.bdv == ConnectionState.OPEN) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.bdx != null || (this.bdv == ConnectionState.CONNECTING && currentTimeMillis - this.bdA > 5000)) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(a.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.bdv == ConnectionState.CONNECTING) {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(a.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_addr)).append(this.bdo).append("\n");
        if (this.bdv == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_program_state));
            if (this.bdu != null) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.bdt) {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(a.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(a.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.bdq) {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(a.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    private void clear(boolean z) {
        if (this.bdy != null && this.bdv != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.bdp);
            }
            try {
                this.bdy.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.bdy = null;
        this.bdA = 0L;
        this.bdv = ConnectionState.CLOSED;
        this.bcI = null;
        this.bdB = null;
        this.mInspectorNativeClient = null;
        this.bdw = ConnectionState.CLOSED;
        this.bdu = null;
        this.bdn.clear();
        if (!z) {
            this.bdt = false;
            this.bdx = null;
            this.bdo = null;
            this.bdp = null;
            this.bdq = false;
            this.bdr = false;
            this.bds = null;
        }
    }

    public void close() {
        clear(false);
    }
}
