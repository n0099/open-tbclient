package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        q.j(webSocketTask, "task");
        k apb = apb();
        if (apb != null) {
            apb.a(webSocketTask);
        }
    }

    public final void jG(String str) {
        q.j(str, "taskId");
        k apb = apb();
        if (apb != null) {
            apb.jG(str);
        }
    }

    public final boolean Zd() {
        k apb = apb();
        if (apb != null) {
            return apb.Zd();
        }
        return false;
    }

    private final k apb() {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null) {
            return acI.acW();
        }
        return null;
    }
}
