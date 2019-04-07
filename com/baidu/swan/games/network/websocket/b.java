package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.k(webSocketTask, "task");
        k OH = OH();
        if (OH != null) {
            OH.a(webSocketTask);
        }
    }

    public final void fu(String str) {
        p.k(str, "taskId");
        k OH = OH();
        if (OH != null) {
            OH.fu(str);
        }
    }

    public final boolean Fc() {
        k OH = OH();
        if (OH != null) {
            return OH.Fc();
        }
        return false;
    }

    private final k OH() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            return IV.Jd();
        }
        return null;
    }
}
