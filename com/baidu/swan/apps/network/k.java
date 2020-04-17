package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class k {
    public static final a cfs = new a(null);
    private volatile Set<String> cfr;

    @kotlin.h
    /* loaded from: classes11.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public final synchronized void a(WebSocketTask webSocketTask) {
        q.j(webSocketTask, "task");
        if (this.cfr == null) {
            this.cfr = new LinkedHashSet();
        }
        Set<String> set = this.cfr;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void kT(String str) {
        q.j(str, "taskId");
        Set<String> set = this.cfr;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.cfr;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.cfr;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean ahj() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.cfr;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
