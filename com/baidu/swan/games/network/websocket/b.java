package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.p(webSocketTask, "task");
        k aXK = aXK();
        if (aXK != null) {
            aXK.a(webSocketTask);
        }
    }

    public final void qi(String str) {
        p.p(str, "taskId");
        k aXK = aXK();
        if (aXK != null) {
            aXK.qi(str);
        }
    }

    public final boolean aDk() {
        k aXK = aXK();
        if (aXK != null) {
            return aXK.aDk();
        }
        return false;
    }

    private final k aXK() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN != null) {
            return aIN.aJd();
        }
        return null;
    }
}
