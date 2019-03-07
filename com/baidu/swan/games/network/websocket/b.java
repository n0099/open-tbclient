package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.k(webSocketTask, "task");
        k OJ = OJ();
        if (OJ != null) {
            OJ.a(webSocketTask);
        }
    }

    public final void ft(String str) {
        p.k(str, "taskId");
        k OJ = OJ();
        if (OJ != null) {
            OJ.ft(str);
        }
    }

    public final boolean Fe() {
        k OJ = OJ();
        if (OJ != null) {
            return OJ.Fe();
        }
        return false;
    }

    private final k OJ() {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            return IX.Jf();
        }
        return null;
    }
}
