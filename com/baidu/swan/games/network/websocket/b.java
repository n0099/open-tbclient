package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.o(webSocketTask, "task");
        k aXH = aXH();
        if (aXH != null) {
            aXH.a(webSocketTask);
        }
    }

    public final void qb(String str) {
        p.o(str, "taskId");
        k aXH = aXH();
        if (aXH != null) {
            aXH.qb(str);
        }
    }

    public final boolean aDh() {
        k aXH = aXH();
        if (aXH != null) {
            return aXH.aDh();
        }
        return false;
    }

    private final k aXH() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null) {
            return aIK.aJa();
        }
        return null;
    }
}
