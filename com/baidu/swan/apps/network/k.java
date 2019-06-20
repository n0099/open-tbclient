package com.baidu.swan.apps.network;

import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class k {
    public static final a aEA = new a(null);
    private Set<String> aEz;

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
        if (this.aEz == null) {
            this.aEz = new LinkedHashSet();
        }
        Set<String> set = this.aEz;
        if (set != null) {
            set.add(webSocketTask.getTaskId());
        }
    }

    public final void fH(String str) {
        p.k(str, "taskId");
        Set<String> set = this.aEz;
        if (set != null) {
            set.remove(str);
        }
    }

    public final void release() {
        try {
            try {
                Set<String> set = this.aEz;
                if (set != null) {
                    for (String str : set) {
                        try {
                            WebSocketManager.INSTANCE.close(str, 1001, "aiapp terminate");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    Set<String> set2 = this.aEz;
                    if (set2 != null) {
                        set2.clear();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } finally {
            try {
                Set<String> set3 = this.aEz;
                if (set3 != null) {
                    set3.clear();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final boolean Hh() {
        Set<String> set = this.aEz;
        return (set != null ? set.size() : 0) < 5;
    }
}
