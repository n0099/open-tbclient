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
    public static final a dmT = new a(null);
    private volatile Set<String> dmS;

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
        p.o(webSocketTask, "task");
        if (this.dmS == null) {
            this.dmS = new LinkedHashSet();
        }
        Set<String> set = this.dmS;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void pJ(String str) {
        p.o(str, "taskId");
        Set<String> set = this.dmS;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.dmS;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.dmS;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean aCL() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.dmS;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
