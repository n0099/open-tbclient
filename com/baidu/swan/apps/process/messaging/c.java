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
    private final Message bJe;
    private final Set<SwanAppProcessInfo> bJf;
    private final Set<String> bJg;
    private boolean bJh;
    private boolean bJi;
    private long bJj;

    @NonNull
    public Message aaP() {
        if (this.bJe.obj == null) {
            L(new Bundle());
        }
        return this.bJe;
    }

    public c(Message message) {
        this.bJf = new HashSet();
        this.bJg = new HashSet();
        this.bJh = false;
        this.bJi = false;
        this.bJj = 0L;
        this.bJe = message == null ? Message.obtain() : message;
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
        this.bJi = z;
        return this;
    }

    public boolean isSticky() {
        return this.bJi;
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
        this.bJf.addAll(Arrays.asList(swanAppProcessInfoArr));
        return this;
    }

    public c u(String... strArr) {
        this.bJg.addAll(Arrays.asList(strArr));
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
        this.bJh = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aaR() {
        return new HashSet(this.bJf);
    }

    public Set<String> aaS() {
        return new HashSet(this.bJg);
    }

    public boolean aaT() {
        return this.bJh;
    }

    public c L(Object obj) {
        this.bJe.obj = obj;
        return this;
    }

    public c av(long j) {
        if (j < 0) {
            j = 0;
        }
        this.bJj = j;
        return this;
    }

    public long aaU() {
        if (this.bJj < 0) {
            return 0L;
        }
        return this.bJj;
    }
}
