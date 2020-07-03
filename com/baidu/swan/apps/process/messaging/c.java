package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public final class c {
    private boolean cyA;
    private long cyB;
    private boolean cym;
    private final Message cyx;
    private final Set<SwanAppProcessInfo> cyy;
    private final Set<String> cyz;

    @NonNull
    public Message anQ() {
        if (this.cyx.obj == null) {
            Q(new Bundle());
        }
        return this.cyx;
    }

    public c(Message message) {
        this.cyy = new HashSet();
        this.cyz = new HashSet();
        this.cym = false;
        this.cyA = false;
        this.cyB = 0L;
        this.cyx = message == null ? Message.obtain() : message;
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

    public c eM(boolean z) {
        this.cyA = z;
        return this;
    }

    public boolean isSticky() {
        return this.cyA;
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
            this.cyy.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c t(String... strArr) {
        if (strArr != null) {
            this.cyz.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public c e(int... iArr) {
        if (iArr != null) {
            for (int i : iArr) {
                if (SwanAppProcessInfo.checkProcessId(i)) {
                    a(SwanAppProcessInfo.indexOf(i));
                }
            }
        }
        return this;
    }

    public c anR() {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess()) {
                a(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c f(int... iArr) {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess() && !a(iArr, swanAppProcessInfo.index)) {
                a(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c eN(boolean z) {
        this.cym = z;
        return this;
    }

    public Set<SwanAppProcessInfo> anS() {
        return new HashSet(this.cyy);
    }

    public Set<String> anT() {
        return new HashSet(this.cyz);
    }

    public boolean anU() {
        return this.cym;
    }

    public c Q(Object obj) {
        this.cyx.obj = obj;
        return this;
    }

    public c bk(long j) {
        if (j < 0) {
            j = 0;
        }
        this.cyB = j;
        return this;
    }

    public long anV() {
        if (this.cyB < 0) {
            return 0L;
        }
        return this.cyB;
    }
}
