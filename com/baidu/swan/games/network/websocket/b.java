package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        q.j(webSocketTask, "task");
        k aoW = aoW();
        if (aoW != null) {
            aoW.a(webSocketTask);
        }
    }

    public final void jH(String str) {
        q.j(str, "taskId");
        k aoW = aoW();
        if (aoW != null) {
            aoW.jH(str);
        }
    }

    public final boolean YY() {
        k aoW = aoW();
        if (aoW != null) {
            return aoW.YY();
        }
        return false;
    }

    private final k aoW() {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD != null) {
            return acD.acR();
        }
        return null;
    }
}
