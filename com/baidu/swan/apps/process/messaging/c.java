package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c {
    private boolean cKZ;
    private final Message cLk;
    private final Set<SwanAppProcessInfo> cLl;
    private final Set<String> cLm;
    private boolean cLn;
    private long cLo;

    @NonNull
    public Message ayf() {
        if (this.cLk.obj == null) {
            U(new Bundle());
        }
        return this.cLk;
    }

    public c(Message message) {
        this.cLl = new HashSet();
        this.cLm = new HashSet();
        this.cKZ = false;
        this.cLn = false;
        this.cLo = 0L;
        this.cLk = message == null ? Message.obtain() : message;
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

    public c fn(boolean z) {
        this.cLn = z;
        return this;
    }

    public boolean isSticky() {
        return this.cLn;
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
            this.cLl.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c u(String... strArr) {
        if (strArr != null) {
            this.cLm.addAll(Arrays.asList(strArr));
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

    public c ayg() {
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

    public c fo(boolean z) {
        this.cKZ = z;
        return this;
    }

    public Set<SwanAppProcessInfo> ayh() {
        return new HashSet(this.cLl);
    }

    public Set<String> ayi() {
        return new HashSet(this.cLm);
    }

    public boolean ayj() {
        return this.cKZ;
    }

    public c U(Object obj) {
        this.cLk.obj = obj;
        return this;
    }

    public c bD(long j) {
        if (j < 0) {
            j = 0;
        }
        this.cLo = j;
        return this;
    }

    public long ayk() {
        if (this.cLo < 0) {
            return 0L;
        }
        return this.cLo;
    }
}
