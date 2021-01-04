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
    private boolean dvP;
    private final Message dwa;
    private final Set<SwanAppProcessInfo> dwb;
    private final Set<String> dwc;
    private boolean dwd;
    private long dwe;

    @NonNull
    public Message aJb() {
        if (this.dwa.obj == null) {
            X(new Bundle());
        }
        return this.dwa;
    }

    public c(Message message) {
        this.dwb = new HashSet();
        this.dwc = new HashSet();
        this.dvP = false;
        this.dwd = false;
        this.dwe = 0L;
        this.dwa = message == null ? Message.obtain() : message;
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

    public c gG(boolean z) {
        this.dwd = z;
        return this;
    }

    public boolean isSticky() {
        return this.dwd;
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
            this.dwb.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c D(String... strArr) {
        if (strArr != null) {
            this.dwc.addAll(Arrays.asList(strArr));
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

    public c aJc() {
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

    public c gH(boolean z) {
        this.dvP = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aJd() {
        return new HashSet(this.dwb);
    }

    public Set<String> aJe() {
        return new HashSet(this.dwc);
    }

    public boolean aJf() {
        return this.dvP;
    }

    public c X(Object obj) {
        this.dwa.obj = obj;
        return this;
    }

    public c cJ(long j) {
        if (j < 0) {
            j = 0;
        }
        this.dwe = j;
        return this;
    }

    public long aJg() {
        if (this.dwe < 0) {
            return 0L;
        }
        return this.dwe;
    }
}
