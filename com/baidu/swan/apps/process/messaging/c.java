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
    private boolean cAM;
    private final Message cAX;
    private final Set<SwanAppProcessInfo> cAY;
    private final Set<String> cAZ;
    private boolean cBa;
    private long cBb;

    @NonNull
    public Message apA() {
        if (this.cAX.obj == null) {
            Q(new Bundle());
        }
        return this.cAX;
    }

    public c(Message message) {
        this.cAY = new HashSet();
        this.cAZ = new HashSet();
        this.cAM = false;
        this.cBa = false;
        this.cBb = 0L;
        this.cAX = message == null ? Message.obtain() : message;
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

    public c eV(boolean z) {
        this.cBa = z;
        return this;
    }

    public boolean isSticky() {
        return this.cBa;
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
            this.cAY.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c t(String... strArr) {
        if (strArr != null) {
            this.cAZ.addAll(Arrays.asList(strArr));
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

    public c apB() {
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

    public c eW(boolean z) {
        this.cAM = z;
        return this;
    }

    public Set<SwanAppProcessInfo> apC() {
        return new HashSet(this.cAY);
    }

    public Set<String> apD() {
        return new HashSet(this.cAZ);
    }

    public boolean apE() {
        return this.cAM;
    }

    public c Q(Object obj) {
        this.cAX.obj = obj;
        return this;
    }

    public c bv(long j) {
        if (j < 0) {
            j = 0;
        }
        this.cBb = j;
        return this;
    }

    public long apF() {
        if (this.cBb < 0) {
            return 0L;
        }
        return this.cBb;
    }
}
