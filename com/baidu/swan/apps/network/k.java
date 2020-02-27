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
    public static final a bGw = new a(null);
    private volatile Set<String> bGv;

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
        if (this.bGv == null) {
            this.bGv = new LinkedHashSet();
        }
        Set<String> set = this.bGv;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void jH(String str) {
        q.j(str, "taskId");
        Set<String> set = this.bGv;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.bGv;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.bGv;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean YY() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.bGv;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
