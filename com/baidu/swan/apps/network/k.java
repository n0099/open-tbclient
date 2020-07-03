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
    public static final a cuW = new a(null);
    private volatile Set<String> cuV;

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
        q.m(webSocketTask, "task");
        if (this.cuV == null) {
            this.cuV = new LinkedHashSet();
        }
        Set<String> set = this.cuV;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void mp(String str) {
        q.m(str, "taskId");
        Set<String> set = this.cuV;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.cuV;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.cuV;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean alI() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.cuV;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
