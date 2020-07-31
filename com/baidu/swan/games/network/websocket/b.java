package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        q.m(webSocketTask, "task");
        k aFS = aFS();
        if (aFS != null) {
            aFS.a(webSocketTask);
        }
    }

    public final void mN(String str) {
        q.m(str, "taskId");
        k aFS = aFS();
        if (aFS != null) {
            aFS.mN(str);
        }
    }

    public final boolean amY() {
        k aFS = aFS();
        if (aFS != null) {
            return aFS.amY();
        }
        return false;
    }

    private final k aFS() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null) {
            return arv.arL();
        }
        return null;
    }
}
