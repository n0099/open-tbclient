package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes25.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.o(webSocketTask, "task");
        k aYU = aYU();
        if (aYU != null) {
            aYU.a(webSocketTask);
        }
    }

    public final void ra(String str) {
        p.o(str, "taskId");
        k aYU = aYU();
        if (aYU != null) {
            aYU.ra(str);
        }
    }

    public final boolean aFk() {
        k aYU = aYU();
        if (aYU != null) {
            return aYU.aFk();
        }
        return false;
    }

    private final k aYU() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null) {
            return aJU.aKk();
        }
        return null;
    }
}
