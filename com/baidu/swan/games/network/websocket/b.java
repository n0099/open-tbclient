package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.o(webSocketTask, "task");
        k aXv = aXv();
        if (aXv != null) {
            aXv.a(webSocketTask);
        }
    }

    public final void pJ(String str) {
        p.o(str, "taskId");
        k aXv = aXv();
        if (aXv != null) {
            aXv.pJ(str);
        }
    }

    public final boolean aCL() {
        k aXv = aXv();
        if (aXv != null) {
            return aXv.aCL();
        }
        return false;
    }

    private final k aXv() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null) {
            return aIr.aIH();
        }
        return null;
    }
}
