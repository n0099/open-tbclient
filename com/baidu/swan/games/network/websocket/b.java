package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes8.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        q.m(webSocketTask, "task");
        k aOJ = aOJ();
        if (aOJ != null) {
            aOJ.a(webSocketTask);
        }
    }

    public final void oN(String str) {
        q.m(str, "taskId");
        k aOJ = aOJ();
        if (aOJ != null) {
            aOJ.oN(str);
        }
    }

    public final boolean auV() {
        k aOJ = aOJ();
        if (aOJ != null) {
            return aOJ.auV();
        }
        return false;
    }

    private final k aOJ() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null) {
            return azI.azY();
        }
        return null;
    }
}
