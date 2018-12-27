package com.baidu.searchbox.ng.ai.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class AiAppWebSocket {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_SOCKET_NUM = 2;
    private Set<String> tasks;

    public final Set<String> getTasks() {
        return this.tasks;
    }

    public final void setTasks(Set<String> set) {
        this.tasks = set;
    }

    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public final void attachTask(WebSocketTask webSocketTask) {
        p.j(webSocketTask, WebSocketAction.PARAM_KEY_TASK);
        if (this.tasks == null) {
            this.tasks = new LinkedHashSet();
        }
        Set<String> set = this.tasks;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final void detachTask(String str) {
        p.j(str, "taskId");
        Set<String> set = this.tasks;
        if (set != null) {
            set.remove(str);
        }
    }

    public final void release() {
        Set<String> set = this.tasks;
        if (set == null) {
            return;
        }
        for (String str : set) {
            try {
                WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
            } catch (Exception e) {
                e.printStackTrace();
            }
            detachTask(str);
        }
    }

    public final boolean allowConnectNewSocket() {
        Set<String> set = this.tasks;
        return (set != null ? set.size() : 0) < 2;
    }
}
