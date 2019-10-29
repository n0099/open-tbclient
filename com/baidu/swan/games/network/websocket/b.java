package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.i(webSocketTask, "task");
        k XA = XA();
        if (XA != null) {
            XA.a(webSocketTask);
        }
    }

    public final void gt(String str) {
        p.i(str, "taskId");
        k XA = XA();
        if (XA != null) {
            XA.gt(str);
        }
    }

    public final boolean MQ() {
        k XA = XA();
        if (XA != null) {
            return XA.MQ();
        }
        return false;
    }

    private final k XA() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null) {
            return QZ.Rh();
        }
        return null;
    }
}
