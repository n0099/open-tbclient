package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
/* loaded from: classes9.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.j(webSocketTask, "task");
        k amq = amq();
        if (amq != null) {
            amq.a(webSocketTask);
        }
    }

    public final void jp(String str) {
        p.j(str, "taskId");
        k amq = amq();
        if (amq != null) {
            amq.jp(str);
        }
    }

    public final boolean Wn() {
        k amq = amq();
        if (amq != null) {
            return amq.Wn();
        }
        return false;
    }

    private final k amq() {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS != null) {
            return ZS.aag();
        }
        return null;
    }
}
