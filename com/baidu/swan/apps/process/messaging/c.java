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
    private boolean duO;
    private final Message duZ;
    private final Set<SwanAppProcessInfo> dva;
    private final Set<String> dvb;
    private boolean dvc;
    private long dvd;

    @NonNull
    public Message aFG() {
        if (this.duZ.obj == null) {
            Z(new Bundle());
        }
        return this.duZ;
    }

    public c(Message message) {
        this.dva = new HashSet();
        this.dvb = new HashSet();
        this.duO = false;
        this.dvc = false;
        this.dvd = 0L;
        this.duZ = message == null ? Message.obtain() : message;
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
        this.dvc = z;
        return this;
    }

    public boolean isSticky() {
        return this.dvc;
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
            this.dva.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c D(String... strArr) {
        if (strArr != null) {
            this.dvb.addAll(Arrays.asList(strArr));
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

    public c aFH() {
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
        this.duO = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aFI() {
        return new HashSet(this.dva);
    }

    public Set<String> aFJ() {
        return new HashSet(this.dvb);
    }

    public boolean aFK() {
        return this.duO;
    }

    public c Z(Object obj) {
        this.duZ.obj = obj;
        return this;
    }

    public c cP(long j) {
        if (j < 0) {
            j = 0;
        }
        this.dvd = j;
        return this;
    }

    public long aFL() {
        if (this.dvd < 0) {
            return 0L;
        }
        return this.dvd;
    }
}
