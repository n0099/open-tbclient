package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.k(webSocketTask, "task");
        k SJ = SJ();
        if (SJ != null) {
            SJ.a(webSocketTask);
        }
    }

    public final void fO(String str) {
        p.k(str, "taskId");
        k SJ = SJ();
        if (SJ != null) {
            SJ.fO(str);
        }
    }

    public final boolean HW() {
        k SJ = SJ();
        if (SJ != null) {
            return SJ.HW();
        }
        return false;
    }

    private final k SJ() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            return Mh.Mp();
        }
        return null;
    }
}
