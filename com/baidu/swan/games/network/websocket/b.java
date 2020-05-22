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
        k aBf = aBf();
        if (aBf != null) {
            aBf.a(webSocketTask);
        }
    }

    public final void mh(String str) {
        q.m(str, "taskId");
        k aBf = aBf();
        if (aBf != null) {
            aBf.mh(str);
        }
    }

    public final boolean akC() {
        k aBf = aBf();
        if (aBf != null) {
            return aBf.akC();
        }
        return false;
    }

    private final k aBf() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null) {
            return aoF.aoV();
        }
        return null;
    }
}
