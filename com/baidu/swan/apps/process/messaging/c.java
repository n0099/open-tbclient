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
    private final Message dlJ;
    private final Set<SwanAppProcessInfo> dlK;
    private final Set<String> dlL;
    private boolean dlM;
    private long dlN;
    private boolean dly;

    @NonNull
    public Message aFi() {
        if (this.dlJ.obj == null) {
            X(new Bundle());
        }
        return this.dlJ;
    }

    public c(Message message) {
        this.dlK = new HashSet();
        this.dlL = new HashSet();
        this.dly = false;
        this.dlM = false;
        this.dlN = 0L;
        this.dlJ = message == null ? Message.obtain() : message;
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

    public c gf(boolean z) {
        this.dlM = z;
        return this;
    }

    public boolean isSticky() {
        return this.dlM;
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
            this.dlK.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c w(String... strArr) {
        if (strArr != null) {
            this.dlL.addAll(Arrays.asList(strArr));
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

    public c aFj() {
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

    public c gg(boolean z) {
        this.dly = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aFk() {
        return new HashSet(this.dlK);
    }

    public Set<String> aFl() {
        return new HashSet(this.dlL);
    }

    public boolean aFm() {
        return this.dly;
    }

    public c X(Object obj) {
        this.dlJ.obj = obj;
        return this;
    }

    public c cj(long j) {
        if (j < 0) {
            j = 0;
        }
        this.dlN = j;
        return this;
    }

    public long aFn() {
        if (this.dlN < 0) {
            return 0L;
        }
        return this.dlN;
    }
}
