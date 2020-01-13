package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.q;
/* loaded from: classes10.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        q.j(webSocketTask, "task");
        k amJ = amJ();
        if (amJ != null) {
            amJ.a(webSocketTask);
        }
    }

    public final void js(String str) {
        q.j(str, "taskId");
        k amJ = amJ();
        if (amJ != null) {
            amJ.js(str);
        }
    }

    public final boolean WK() {
        k amJ = amJ();
        if (amJ != null) {
            return amJ.WK();
        }
        return false;
    }

    private final k amJ() {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap != null) {
            return aap.aaD();
        }
        return null;
    }
}
