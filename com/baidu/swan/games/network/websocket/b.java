package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        q.m(webSocketTask, "task");
        k aCl = aCl();
        if (aCl != null) {
            aCl.a(webSocketTask);
        }
    }

    public final void mp(String str) {
        q.m(str, "taskId");
        k aCl = aCl();
        if (aCl != null) {
            aCl.mp(str);
        }
    }

    public final boolean alI() {
        k aCl = aCl();
        if (aCl != null) {
            return aCl.alI();
        }
        return false;
    }

    private final k aCl() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null) {
            return apM.aqc();
        }
        return null;
    }
}
