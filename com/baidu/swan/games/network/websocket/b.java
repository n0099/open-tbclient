package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.k(webSocketTask, "task");
        k RM = RM();
        if (RM != null) {
            RM.a(webSocketTask);
        }
    }

    public final void fI(String str) {
        p.k(str, "taskId");
        k RM = RM();
        if (RM != null) {
            RM.fI(str);
        }
    }

    public final boolean Hh() {
        k RM = RM();
        if (RM != null) {
            return RM.Hh();
        }
        return false;
    }

    private final k RM() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            return Lq.Ly();
        }
        return null;
    }
}
