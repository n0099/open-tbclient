package com.baidu.swan.games.inspector;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.c;
import com.baidu.swan.games.inspector.a;
import com.baidu.tbadk.TbConfig;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class SwanInspectorEndpoint {
    private static final boolean DEBUG = c.DEBUG;
    private static SwanInspectorEndpoint bdk = new SwanInspectorEndpoint();
    private com.baidu.swan.games.e.a bcH;
    private InspectorNativeChannel bdA;
    private String bdn;
    private String bdo;
    private a.C0164a bdr;
    private Runnable bdt;
    private Throwable bdw;
    private WebSocketTask bdx;
    private InspectorNativeClient mInspectorNativeClient;
    private LinkedBlockingQueue<String> bdm = new LinkedBlockingQueue<>();
    private boolean bdp = false;
    private boolean bdq = false;
    private boolean bds = false;
    private ConnectionState bdu = ConnectionState.CLOSED;
    private ConnectionState bdv = ConnectionState.CLOSED;
    private int bdy = 0;
    private long bdz = 0;
    private String bdl = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        CLOSED,
        CONNECTING,
        OPEN
    }

    public static SwanInspectorEndpoint Oz() {
        return bdk;
    }

    private SwanInspectorEndpoint() {
    }

    public String b(Resources resources) {
        String string;
        String string2;
        String string3;
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        a.C0164a c0164a = this.bdr;
        if (c0164a == null) {
            c0164a = a.C0164a.Ox();
        }
        sb.append(c0164a.Oy()).append("\n");
        if (!c0164a.isEnabled()) {
            return sb.toString();
        }
        String str = null;
        if (this.bdu == ConnectionState.OPEN) {
            string = resources.getString(b.h.aiapps_swan_inspector_connection_state_open);
        } else if (this.bdw != null || (this.bdu == ConnectionState.CONNECTING && currentTimeMillis - this.bdz > TbConfig.NOTIFY_SOUND_INTERVAL)) {
            string = resources.getString(b.h.aiapps_swan_inspector_connection_state_error);
            str = resources.getString(b.h.aiapps_swan_inspector_connection_error_hint);
        } else if (this.bdu == ConnectionState.CONNECTING) {
            string = resources.getString(b.h.aiapps_swan_inspector_connection_state_connecting);
        } else {
            string = resources.getString(b.h.aiapps_swan_inspector_connection_state_close);
        }
        sb.append(resources.getString(b.h.aiapps_swan_inspector_info_label_connection_state)).append(string).append("\n");
        if (str != null) {
            sb.append(str).append("\n");
        }
        sb.append(resources.getString(b.h.aiapps_swan_inspector_info_label_addr)).append(this.bdn).append("\n");
        if (this.bdu == ConnectionState.OPEN) {
            StringBuilder append = sb.append(resources.getString(b.h.aiapps_swan_inspector_info_label_program_state));
            if (this.bdt != null) {
                string2 = resources.getString(b.h.aiapps_swan_inspector_program_state_pause_at_start);
            } else if (this.bds) {
                string2 = resources.getString(b.h.aiapps_swan_inspector_program_state_pause_at_breakpoint);
            } else {
                string2 = resources.getString(b.h.aiapps_swan_inspector_program_state_running);
            }
            append.append(string2).append("\n");
            StringBuilder append2 = sb.append(resources.getString(b.h.aiapps_swan_inspector_info_label_pause_at_start_set));
            if (this.bdp) {
                string3 = resources.getString(b.h.aiapps_swan_inspector_text_yes);
            } else {
                string3 = resources.getString(b.h.aiapps_swan_inspector_text_no);
            }
            append2.append(string3).append("\n");
        }
        return sb.toString();
    }

    private void clear(boolean z) {
        if (this.bdx != null && this.bdu != ConnectionState.CLOSED) {
            if (DEBUG) {
                Log.i("SwanInspector", "WebSocket connect onClosed: " + this.bdo);
            }
            try {
                this.bdx.close(0, "Inspector close");
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SwanInspector", "close error", e);
                }
            }
        }
        this.bdx = null;
        this.bdz = 0L;
        this.bdu = ConnectionState.CLOSED;
        this.bcH = null;
        this.bdA = null;
        this.mInspectorNativeClient = null;
        this.bdv = ConnectionState.CLOSED;
        this.bdt = null;
        this.bdm.clear();
        if (!z) {
            this.bds = false;
            this.bdw = null;
            this.bdn = null;
            this.bdo = null;
            this.bdp = false;
            this.bdq = false;
            this.bdr = null;
        }
    }

    public void close() {
        clear(false);
    }
}
