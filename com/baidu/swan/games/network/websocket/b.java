package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.i(webSocketTask, "task");
        k Xy = Xy();
        if (Xy != null) {
            Xy.a(webSocketTask);
        }
    }

    public final void gt(String str) {
        p.i(str, "taskId");
        k Xy = Xy();
        if (Xy != null) {
            Xy.gt(str);
        }
    }

    public final boolean MR() {
        k Xy = Xy();
        if (Xy != null) {
            return Xy.MR();
        }
        return false;
    }

    private final k Xy() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            return Ra.Rj();
        }
        return null;
    }
}
