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
        k axo = axo();
        if (axo != null) {
            axo.a(webSocketTask);
        }
    }

    public final void kT(String str) {
        q.j(str, "taskId");
        k axo = axo();
        if (axo != null) {
            axo.kT(str);
        }
    }

    public final boolean ahi() {
        k axo = axo();
        if (axo != null) {
            return axo.ahi();
        }
        return false;
    }

    private final k axo() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM != null) {
            return akM.ala();
        }
        return null;
    }
}
