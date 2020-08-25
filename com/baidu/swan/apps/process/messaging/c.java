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
    private boolean cIV;
    private final Message cJg;
    private final Set<SwanAppProcessInfo> cJh;
    private final Set<String> cJi;
    private boolean cJj;
    private long cJk;

    @NonNull
    public Message axw() {
        if (this.cJg.obj == null) {
            T(new Bundle());
        }
        return this.cJg;
    }

    public c(Message message) {
        this.cJh = new HashSet();
        this.cJi = new HashSet();
        this.cIV = false;
        this.cJj = false;
        this.cJk = 0L;
        this.cJg = message == null ? Message.obtain() : message;
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

    public c fo(boolean z) {
        this.cJj = z;
        return this;
    }

    public boolean isSticky() {
        return this.cJj;
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
            this.cJh.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c u(String... strArr) {
        if (strArr != null) {
            this.cJi.addAll(Arrays.asList(strArr));
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

    public c fp(boolean z) {
        this.cIV = z;
        return this;
    }

    public Set<SwanAppProcessInfo> axy() {
        return new HashSet(this.cJh);
    }

    public Set<String> axz() {
        return new HashSet(this.cJi);
    }

    public boolean axA() {
        return this.cIV;
    }

    public c T(Object obj) {
        this.cJg.obj = obj;
        return this;
    }

    public c bC(long j) {
        if (j < 0) {
            j = 0;
        }
        this.cJk = j;
        return this;
    }

    public long axB() {
        if (this.cJk < 0) {
            return 0L;
        }
        return this.cJk;
    }
}
