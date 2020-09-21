package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes3.dex */
public final class k {
    public static final a cGW = new a(null);
    private volatile Set<String> cGV;

    @kotlin.h
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public final synchronized void a(WebSocketTask webSocketTask) {
        q.m(webSocketTask, "task");
        if (this.cGV == null) {
            this.cGV = new LinkedHashSet();
        }
        Set<String> set = this.cGV;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void pg(String str) {
        q.m(str, "taskId");
        Set<String> set = this.cGV;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.cGV;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.cGV;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean avE() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.cGV;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
