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
        k aSd = aSd();
        if (aSd != null) {
            aSd.a(webSocketTask);
        }
    }

    public final void pS(String str) {
        q.n(str, "taskId");
        k aSd = aSd();
        if (aSd != null) {
            aSd.pS(str);
        }
    }

    public final boolean ayp() {
        k aSd = aSd();
        if (aSd != null) {
            return aSd.ayp();
        }
        return false;
    }

    private final k aSd() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null) {
            return aDa.aDq();
        }
        return null;
    }
}
