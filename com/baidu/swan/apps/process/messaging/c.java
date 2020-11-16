package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public final class c {
    private boolean djR;
    private final Message dkc;
    private final Set<SwanAppProcessInfo> dkd;
    private final Set<String> dke;
    private boolean dkf;
    private long dkg;

    @NonNull
    public Message aEA() {
        if (this.dkc.obj == null) {
            X(new Bundle());
        }
        return this.dkc;
    }

    public c(Message message) {
        this.dkd = new HashSet();
        this.dke = new HashSet();
        this.djR = false;
        this.dkf = false;
        this.dkg = 0L;
        this.dkc = message == null ? Message.obtain() : message;
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

    public c gi(boolean z) {
        this.dkf = z;
        return this;
    }

    public boolean isSticky() {
        return this.dkf;
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
            this.dkd.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c w(String... strArr) {
        if (strArr != null) {
            this.dke.addAll(Arrays.asList(strArr));
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

    public c aEB() {
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

    public c gj(boolean z) {
        this.djR = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aEC() {
        return new HashSet(this.dkd);
    }

    public Set<String> aED() {
        return new HashSet(this.dke);
    }

    public boolean aEE() {
        return this.djR;
    }

    public c X(Object obj) {
        this.dkc.obj = obj;
        return this;
    }

    public c cj(long j) {
        if (j < 0) {
            j = 0;
        }
        this.dkg = j;
        return this;
    }

    public long aEF() {
        if (this.dkg < 0) {
            return 0L;
        }
        return this.dkg;
    }
}
