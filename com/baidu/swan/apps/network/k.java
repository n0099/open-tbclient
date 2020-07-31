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
    public static final a cwX = new a(null);
    private volatile Set<String> cwW;

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
        q.m(webSocketTask, "task");
        if (this.cwW == null) {
            this.cwW = new LinkedHashSet();
        }
        Set<String> set = this.cwW;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final synchronized void mN(String str) {
        q.m(str, "taskId");
        Set<String> set = this.cwW;
        if (set != null) {
            set.remove(str);
        }
    }

    public final synchronized void release() {
        Set<String> set = this.cwW;
        if (set != null) {
            for (String str : set) {
                try {
                    WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Set<String> set2 = this.cwW;
        if (set2 != null) {
            set2.clear();
        }
    }

    public final synchronized boolean amY() {
        boolean z;
        synchronized (this) {
            Set<String> set = this.cwW;
            z = (set != null ? set.size() : 0) < 5;
        }
        return z;
    }
}
