package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class k {
    public static final a dfL = new a(null);
    private volatile Set<String> dfK;

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public final synchronized void a(WebSocketTask webSocketTask) {
        q.n(webSocketTask, "task");
        if (this.dfK == null) {
            this.dfK = new LinkedHashSet();
        }
        Set<String> set = this.dfK;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void qt(String str) {
        q.n(str, "taskId");
        Set<String> set = this.dfK;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.dfK;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.dfK;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean aCb() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.dfK;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
