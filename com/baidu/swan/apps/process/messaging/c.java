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
    private final Message bJf;
    private final Set<SwanAppProcessInfo> bJg;
    private final Set<String> bJh;
    private boolean bJi;
    private boolean bJj;
    private long bJk;

    @NonNull
    public Message aaP() {
        if (this.bJf.obj == null) {
            L(new Bundle());
        }
        return this.bJf;
    }

    public c(Message message) {
        this.bJg = new HashSet();
        this.bJh = new HashSet();
        this.bJi = false;
        this.bJj = false;
        this.bJk = 0L;
        this.bJf = message == null ? Message.obtain() : message;
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

    public c dr(boolean z) {
        this.bJj = z;
        return this;
    }

    public boolean isSticky() {
        return this.bJj;
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
        this.bJg.addAll(Arrays.asList(swanAppProcessInfoArr));
        return this;
    }

    public c u(String... strArr) {
        this.bJh.addAll(Arrays.asList(strArr));
        return this;
    }

    public c e(int... iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            a(SwanAppProcessInfo.indexOf(iArr[i]));
        }
        return this;
    }

    public c aaQ() {
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

    public c ds(boolean z) {
        this.bJi = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aaR() {
        return new HashSet(this.bJg);
    }

    public Set<String> aaS() {
        return new HashSet(this.bJh);
    }

    public boolean aaT() {
        return this.bJi;
    }

    public c L(Object obj) {
        this.bJf.obj = obj;
        return this;
    }

    public c av(long j) {
        if (j < 0) {
            j = 0;
        }
        this.bJk = j;
        return this;
    }

    public long aaU() {
        if (this.bJk < 0) {
            return 0L;
        }
        return this.bJk;
    }
}
