package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class k {
    public static final a aCJ = new a(null);
    private Set<String> aCI;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public final void a(WebSocketTask webSocketTask) {
        p.k(webSocketTask, "task");
        if (this.aCI == null) {
            this.aCI = new LinkedHashSet();
        }
        Set<String> set = this.aCI;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final void ft(String str) {
        p.k(str, "taskId");
        Set<String> set = this.aCI;
        if (set != null) {
            set.remove(str);
        }
    }

    public final void release() {
        Set<String> set = this.aCI;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.aCI;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final boolean Fe() {
        Set<String> set = this.aCI;
        return (set != null ? set.size() : 0) < 5;
    }
}
