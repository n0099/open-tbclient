package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class c {
    private boolean dra;
    private final Message drl;
    private final Set<SwanAppProcessInfo> drm;
    private final Set<String> drn;
    private boolean dro;
    private long drp;

    @NonNull
    public Message aFi() {
        if (this.drl.obj == null) {
            X(new Bundle());
        }
        return this.drl;
    }

    public c(Message message) {
        this.drm = new HashSet();
        this.drn = new HashSet();
        this.dra = false;
        this.dro = false;
        this.drp = 0L;
        this.drl = message == null ? Message.obtain() : message;
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

    public c gC(boolean z) {
        this.dro = z;
        return this;
    }

    public boolean isSticky() {
        return this.dro;
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
            this.drm.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c D(String... strArr) {
        if (strArr != null) {
            this.drn.addAll(Arrays.asList(strArr));
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

    public c aFj() {
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

    public c gD(boolean z) {
        this.dra = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aFk() {
        return new HashSet(this.drm);
    }

    public Set<String> aFl() {
        return new HashSet(this.drn);
    }

    public boolean aFm() {
        return this.dra;
    }

    public c X(Object obj) {
        this.drl.obj = obj;
        return this;
    }

    public c cJ(long j) {
        if (j < 0) {
            j = 0;
        }
        this.drp = j;
        return this;
    }

    public long aFn() {
        if (this.drp < 0) {
            return 0L;
        }
        return this.drp;
    }
}
