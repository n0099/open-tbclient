package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class k {
    public static final a dqI = new a(null);
    private volatile Set<String> dqH;

    @kotlin.e
    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public final synchronized void a(WebSocketTask webSocketTask) {
        p.p(webSocketTask, "task");
        if (this.dqH == null) {
            this.dqH = new LinkedHashSet();
        }
        Set<String> set = this.dqH;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void qi(String str) {
        p.p(str, "taskId");
        Set<String> set = this.dqH;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.dqH;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.dqH;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean aDk() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.dqH;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
