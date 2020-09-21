package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.k;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes3.dex */
public final class b {
    public final void a(WebSocketTask webSocketTask) {
        q.m(webSocketTask, "task");
        k aPu = aPu();
        if (aPu != null) {
            aPu.a(webSocketTask);
        }
    }

    public final void pg(String str) {
        q.m(str, "taskId");
        k aPu = aPu();
        if (aPu != null) {
            aPu.pg(str);
        }
    }

    public final boolean avE() {
        k aPu = aPu();
        if (aPu != null) {
            return aPu.avE();
        }
        return false;
    }

    private final k aPu() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null) {
            return aAr.aAH();
        }
        return null;
    }
}
