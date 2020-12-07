package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes25.dex */
public final class c {
    private boolean dqQ;
    private final Message drb;
    private final Set<SwanAppProcessInfo> drc;
    private final Set<String> drd;
    private boolean dre;
    private long drf;

    @NonNull
    public Message aHI() {
        if (this.drb.obj == null) {
            X(new Bundle());
        }
        return this.drb;
    }

    public c(Message message) {
        this.drc = new HashSet();
        this.drd = new HashSet();
        this.dqQ = false;
        this.dre = false;
        this.drf = 0L;
        this.drb = message == null ? Message.obtain() : message;
    }

    public c(int i, Object obj) {
        this(Message.obtain(null, i, obj));
    }

    public c(int i) {
        this(Message.obtain((Handler) null, i));
    }

    public c() {
        this(Message.obtain());
    }

    public c gx(boolean z) {
        this.dre = z;
        return this;
    }

    public boolean isSticky() {
        return this.dre;
    }

    private boolean a(int[] iArr, int i) {
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public c a(SwanAppProcessInfo... swanAppProcessInfoArr) {
        if (swanAppProcessInfoArr != null) {
            this.drc.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c w(String... strArr) {
        if (strArr != null) {
            this.drd.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public c f(int... iArr) {
        if (iArr != null) {
            for (int i : iArr) {
                if (SwanAppProcessInfo.checkProcessId(i)) {
                    a(SwanAppProcessInfo.indexOf(i));
                }
            }
        }
        return this;
    }

    public c aHJ() {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess()) {
                a(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c g(int... iArr) {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess() && !a(iArr, swanAppProcessInfo.index)) {
                a(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c gy(boolean z) {
        this.dqQ = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aHK() {
        return new HashSet(this.drc);
    }

    public Set<String> aHL() {
        return new HashSet(this.drd);
    }

    public boolean aHM() {
        return this.dqQ;
    }

    public c X(Object obj) {
        this.drb.obj = obj;
        return this;
    }

    public c cI(long j) {
        if (j < 0) {
            j = 0;
        }
        this.drf = j;
        return this;
    }

    public long aHN() {
        if (this.drf < 0) {
            return 0L;
        }
        return this.drf;
    }
}
