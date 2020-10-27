package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        q.n(webSocketTask, "task");
        k aTX = aTX();
        if (aTX != null) {
            aTX.a(webSocketTask);
        }
    }

    public final void ql(String str) {
        q.n(str, "taskId");
        k aTX = aTX();
        if (aTX != null) {
            aTX.ql(str);
        }
    }

    public final boolean aAj() {
        k aTX = aTX();
        if (aTX != null) {
            return aTX.aAj();
        }
        return false;
    }

    private final k aTX() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null) {
            return aEU.aFk();
        }
        return null;
    }
}
