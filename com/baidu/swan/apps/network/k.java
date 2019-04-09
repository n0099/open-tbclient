package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class k {
    public static final a aCO = new a(null);
    private Set<String> aCN;

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
        if (this.aCN == null) {
            this.aCN = new LinkedHashSet();
        }
        Set<String> set = this.aCN;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final void fu(String str) {
        p.k(str, "taskId");
        Set<String> set = this.aCN;
        if (set != null) {
            set.remove(str);
        }
    }

    public final void release() {
        Set<String> set = this.aCN;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.aCN;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final boolean Fc() {
        Set<String> set = this.aCN;
        return (set != null ? set.size() : 0) < 5;
    }
}
