package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public final class c {
    private final Message bEn;
    private final Set<SwanAppProcessInfo> bEo;
    private final Set<String> bEp;
    private boolean bEq;
    private boolean bEr;
    private long bEs;

    @NonNull
    public Message Yc() {
        if (this.bEn.obj == null) {
            J(new Bundle());
        }
        return this.bEn;
    }

    public c(Message message) {
        this.bEo = new HashSet();
        this.bEp = new HashSet();
        this.bEq = false;
        this.bEr = false;
        this.bEs = 0L;
        this.bEn = message == null ? Message.obtain() : message;
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

    public c df(boolean z) {
        this.bEr = z;
        return this;
    }

    public boolean isSticky() {
        return this.bEr;
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
        this.bEo.addAll(Arrays.asList(swanAppProcessInfoArr));
        return this;
    }

    public c q(String... strArr) {
        this.bEp.addAll(Arrays.asList(strArr));
        return this;
    }

    public c e(int... iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            a(SwanAppProcessInfo.indexOf(iArr[i]));
        }
        return this;
    }

    public c Yd() {
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

    public c dg(boolean z) {
        this.bEq = z;
        return this;
    }

    public Set<SwanAppProcessInfo> Ye() {
        return new HashSet(this.bEo);
    }

    public Set<String> Yf() {
        return new HashSet(this.bEp);
    }

    public boolean Yg() {
        return this.bEq;
    }

    public c J(Object obj) {
        this.bEn.obj = obj;
        return this;
    }

    public c ao(long j) {
        if (j < 0) {
            j = 0;
        }
        this.bEs = j;
        return this;
    }

    public long Yh() {
        if (this.bEs < 0) {
            return 0L;
        }
        return this.bEs;
    }
}
