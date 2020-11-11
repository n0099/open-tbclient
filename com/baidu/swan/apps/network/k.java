package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class k {
    public static final a dhs = new a(null);
    private volatile Set<String> dhr;

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public final synchronized void a(WebSocketTask webSocketTask) {
        q.n(webSocketTask, "task");
        if (this.dhr == null) {
            this.dhr = new LinkedHashSet();
        }
        Set<String> set = this.dhr;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void qz(String str) {
        q.n(str, "taskId");
        Set<String> set = this.dhr;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.dhr;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.dhr;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean aCJ() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.dhr;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
