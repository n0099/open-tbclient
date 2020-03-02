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
        k aoY = aoY();
        if (aoY != null) {
            aoY.a(webSocketTask);
        }
    }

    public final void jH(String str) {
        q.j(str, "taskId");
        k aoY = aoY();
        if (aoY != null) {
            aoY.jH(str);
        }
    }

    public final boolean Za() {
        k aoY = aoY();
        if (aoY != null) {
            return aoY.Za();
        }
        return false;
    }

    private final k aoY() {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null) {
            return acF.acT();
        }
        return null;
    }
}
