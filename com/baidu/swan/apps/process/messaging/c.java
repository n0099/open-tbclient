package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public final class c {
    private final Set<String> dtA;
    private boolean dtB;
    private long dtC;
    private boolean dtm;
    private final Message dty;
    private final Set<SwanAppProcessInfo> dtz;

    @NonNull
    public Message aFD() {
        if (this.dty.obj == null) {
            X(new Bundle());
        }
        return this.dty;
    }

    public c(Message message) {
        this.dtz = new HashSet();
        this.dtA = new HashSet();
        this.dtm = false;
        this.dtB = false;
        this.dtC = 0L;
        this.dty = message == null ? Message.obtain() : message;
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

    public c gE(boolean z) {
        this.dtB = z;
        return this;
    }

    public boolean isSticky() {
        return this.dtB;
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
            this.dtz.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c D(String... strArr) {
        if (strArr != null) {
            this.dtA.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public c g(int... iArr) {
        if (iArr != null) {
            for (int i : iArr) {
                if (SwanAppProcessInfo.checkProcessId(i)) {
                    a(SwanAppProcessInfo.indexOf(i));
                }
            }
        }
        return this;
    }

    public c aFE() {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess()) {
                a(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c h(int... iArr) {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess() && !a(iArr, swanAppProcessInfo.index)) {
                a(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c gF(boolean z) {
        this.dtm = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aFF() {
        return new HashSet(this.dtz);
    }

    public Set<String> aFG() {
        return new HashSet(this.dtA);
    }

    public boolean aFH() {
        return this.dtm;
    }

    public c X(Object obj) {
        this.dty.obj = obj;
        return this;
    }

    public c cP(long j) {
        if (j < 0) {
            j = 0;
        }
        this.dtC = j;
        return this;
    }

    public long aFI() {
        if (this.dtC < 0) {
            return 0L;
        }
        return this.dtC;
    }
}
