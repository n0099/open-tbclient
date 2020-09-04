package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class c {
    private boolean cIZ;
    private final Message cJk;
    private final Set<SwanAppProcessInfo> cJl;
    private final Set<String> cJm;
    private boolean cJn;
    private long cJo;

    @NonNull
    public Message axw() {
        if (this.cJk.obj == null) {
            T(new Bundle());
        }
        return this.cJk;
    }

    public c(Message message) {
        this.cJl = new HashSet();
        this.cJm = new HashSet();
        this.cIZ = false;
        this.cJn = false;
        this.cJo = 0L;
        this.cJk = message == null ? Message.obtain() : message;
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

    public c fp(boolean z) {
        this.cJn = z;
        return this;
    }

    public boolean isSticky() {
        return this.cJn;
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
            this.cJl.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c u(String... strArr) {
        if (strArr != null) {
            this.cJm.addAll(Arrays.asList(strArr));
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

    public c axx() {
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

    public c fq(boolean z) {
        this.cIZ = z;
        return this;
    }

    public Set<SwanAppProcessInfo> axy() {
        return new HashSet(this.cJl);
    }

    public Set<String> axz() {
        return new HashSet(this.cJm);
    }

    public boolean axA() {
        return this.cIZ;
    }

    public c T(Object obj) {
        this.cJk.obj = obj;
        return this;
    }

    public c bC(long j) {
        if (j < 0) {
            j = 0;
        }
        this.cJo = j;
        return this;
    }

    public long axB() {
        if (this.cJo < 0) {
            return 0L;
        }
        return this.cJo;
    }
}
