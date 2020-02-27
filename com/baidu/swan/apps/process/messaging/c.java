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
    private final Message bJd;
    private final Set<SwanAppProcessInfo> bJe;
    private final Set<String> bJf;
    private boolean bJg;
    private boolean bJh;
    private long bJi;

    @NonNull
    public Message aaN() {
        if (this.bJd.obj == null) {
            L(new Bundle());
        }
        return this.bJd;
    }

    public c(Message message) {
        this.bJe = new HashSet();
        this.bJf = new HashSet();
        this.bJg = false;
        this.bJh = false;
        this.bJi = 0L;
        this.bJd = message == null ? Message.obtain() : message;
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
        this.bJh = z;
        return this;
    }

    public boolean isSticky() {
        return this.bJh;
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
        this.bJe.addAll(Arrays.asList(swanAppProcessInfoArr));
        return this;
    }

    public c u(String... strArr) {
        this.bJf.addAll(Arrays.asList(strArr));
        return this;
    }

    public c e(int... iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            a(SwanAppProcessInfo.indexOf(iArr[i]));
        }
        return this;
    }

    public c aaO() {
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
        this.bJg = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aaP() {
        return new HashSet(this.bJe);
    }

    public Set<String> aaQ() {
        return new HashSet(this.bJf);
    }

    public boolean aaR() {
        return this.bJg;
    }

    public c L(Object obj) {
        this.bJd.obj = obj;
        return this;
    }

    public c av(long j) {
        if (j < 0) {
            j = 0;
        }
        this.bJi = j;
        return this;
    }

    public long aaS() {
        if (this.bJi < 0) {
            return 0L;
        }
        return this.bJi;
    }
}
