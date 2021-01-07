package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        p.o(webSocketTask, "task");
        k bbp = bbp();
        if (bbp != null) {
            bbp.a(webSocketTask);
        }
    }

    public final void qU(String str) {
        p.o(str, "taskId");
        k bbp = bbp();
        if (bbp != null) {
            bbp.qU(str);
        }
    }

    public final boolean aGF() {
        k bbp = bbp();
        if (bbp != null) {
            return bbp.aGF();
        }
        return false;
    }

    private final k bbp() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl != null) {
            return aMl.aMB();
        }
        return null;
    }
}
