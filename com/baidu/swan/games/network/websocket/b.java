package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        q.n(webSocketTask, "task");
        k aVP = aVP();
        if (aVP != null) {
            aVP.a(webSocketTask);
        }
    }

    public final void qt(String str) {
        q.n(str, "taskId");
        k aVP = aVP();
        if (aVP != null) {
            aVP.qt(str);
        }
    }

    public final boolean aCb() {
        k aVP = aVP();
        if (aVP != null) {
            return aVP.aCb();
        }
        return false;
    }

    private final k aVP() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null) {
            return aGM.aHc();
        }
        return null;
    }
}
