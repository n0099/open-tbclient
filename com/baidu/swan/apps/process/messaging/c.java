package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class c {
    private boolean cXc;
    private final Message cXn;
    private final Set<SwanAppProcessInfo> cXo;
    private final Set<String> cXp;
    private boolean cXq;
    private long cXr;

    @NonNull
    public Message aAO() {
        if (this.cXn.obj == null) {
            X(new Bundle());
        }
        return this.cXn;
    }

    public c(Message message) {
        this.cXo = new HashSet();
        this.cXp = new HashSet();
        this.cXc = false;
        this.cXq = false;
        this.cXr = 0L;
        this.cXn = message == null ? Message.obtain() : message;
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

    public c fJ(boolean z) {
        this.cXq = z;
        return this;
    }

    public boolean isSticky() {
        return this.cXq;
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
            this.cXo.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c v(String... strArr) {
        if (strArr != null) {
            this.cXp.addAll(Arrays.asList(strArr));
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

    public c aAP() {
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

    public c fK(boolean z) {
        this.cXc = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aAQ() {
        return new HashSet(this.cXo);
    }

    public Set<String> aAR() {
        return new HashSet(this.cXp);
    }

    public boolean aAS() {
        return this.cXc;
    }

    public c X(Object obj) {
        this.cXn.obj = obj;
        return this;
    }

    public c bL(long j) {
        if (j < 0) {
            j = 0;
        }
        this.cXr = j;
        return this;
    }

    public long aAT() {
        if (this.cXr < 0) {
            return 0L;
        }
        return this.cXr;
    }
}
