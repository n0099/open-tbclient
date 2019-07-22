package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.k(webSocketTask, "task");
        k SF = SF();
        if (SF != null) {
            SF.a(webSocketTask);
        }
    }

    public final void fM(String str) {
        p.k(str, "taskId");
        k SF = SF();
        if (SF != null) {
            SF.fM(str);
        }
    }

    public final boolean HS() {
        k SF = SF();
        if (SF != null) {
            return SF.HS();
        }
        return false;
    }

    private final k SF() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            return Md.Ml();
        }
        return null;
    }
}
