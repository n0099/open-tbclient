package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class k {
    public static final a drK = new a(null);
    private volatile Set<String> drJ;

    @kotlin.e
    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public final synchronized void a(WebSocketTask webSocketTask) {
        p.o(webSocketTask, "task");
        if (this.drJ == null) {
            this.drJ = new LinkedHashSet();
        }
        Set<String> set = this.drJ;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void qU(String str) {
        p.o(str, "taskId");
        Set<String> set = this.drJ;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.drJ;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.drJ;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean aGE() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.drJ;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
