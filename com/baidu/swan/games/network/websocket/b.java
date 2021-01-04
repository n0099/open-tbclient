package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.o(webSocketTask, "task");
        k bbo = bbo();
        if (bbo != null) {
            bbo.a(webSocketTask);
        }
    }

    public final void qU(String str) {
        p.o(str, "taskId");
        k bbo = bbo();
        if (bbo != null) {
            bbo.qU(str);
        }
    }

    public final boolean aGE() {
        k bbo = bbo();
        if (bbo != null) {
            return bbo.aGE();
        }
        return false;
    }

    private final k bbo() {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk != null) {
            return aMk.aMA();
        }
        return null;
    }
}
