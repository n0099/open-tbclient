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
        k aWx = aWx();
        if (aWx != null) {
            aWx.a(webSocketTask);
        }
    }

    public final void qz(String str) {
        q.n(str, "taskId");
        k aWx = aWx();
        if (aWx != null) {
            aWx.qz(str);
        }
    }

    public final boolean aCJ() {
        k aWx = aWx();
        if (aWx != null) {
            return aWx.aCJ();
        }
        return false;
    }

    private final k aWx() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null) {
            return aHu.aHK();
        }
        return null;
    }
}
