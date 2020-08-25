package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class k {
    public static final a cES = new a(null);
    private volatile Set<String> cER;

    @kotlin.h
    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public final synchronized void a(WebSocketTask webSocketTask) {
        q.m(webSocketTask, "task");
        if (this.cER == null) {
            this.cER = new LinkedHashSet();
        }
        Set<String> set = this.cER;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void oM(String str) {
        q.m(str, "taskId");
        Set<String> set = this.cER;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.cER;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.cER;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean auV() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.cER;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
