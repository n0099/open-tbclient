package com.baidu.searchbox.fluency.tracer;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/fluency/tracer/DropLevel;", "Ljava/lang/Enum;", "", "index", "I", "getIndex", "()I", "<init>", "(Ljava/lang/String;II)V", "DROPPED_BEST", "DROPPED_NORMAL", "DROPPED_MIDDLE", "DROPPED_HIGH", "DROPPED_FROZEN", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public enum DropLevel {
    DROPPED_BEST(0),
    DROPPED_NORMAL(1),
    DROPPED_MIDDLE(2),
    DROPPED_HIGH(3),
    DROPPED_FROZEN(4);
    
    public final int index;

    DropLevel(int i) {
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }
}
