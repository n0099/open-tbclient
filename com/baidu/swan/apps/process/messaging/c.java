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
    private final Message bJq;
    private final Set<SwanAppProcessInfo> bJr;
    private final Set<String> bJs;
    private boolean bJt;
    private boolean bJu;
    private long bJv;

    @NonNull
    public Message aaS() {
        if (this.bJq.obj == null) {
            L(new Bundle());
        }
        return this.bJq;
    }

    public c(Message message) {
        this.bJr = new HashSet();
        this.bJs = new HashSet();
        this.bJt = false;
        this.bJu = false;
        this.bJv = 0L;
        this.bJq = message == null ? Message.obtain() : message;
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

    public c ds(boolean z) {
        this.bJu = z;
        return this;
    }

    public boolean isSticky() {
        return this.bJu;
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
        this.bJr.addAll(Arrays.asList(swanAppProcessInfoArr));
        return this;
    }

    public c u(String... strArr) {
        this.bJs.addAll(Arrays.asList(strArr));
        return this;
    }

    public c e(int... iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            a(SwanAppProcessInfo.indexOf(iArr[i]));
        }
        return this;
    }

    public c aaT() {
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

    public c dt(boolean z) {
        this.bJt = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aaU() {
        return new HashSet(this.bJr);
    }

    public Set<String> aaV() {
        return new HashSet(this.bJs);
    }

    public boolean aaW() {
        return this.bJt;
    }

    public c L(Object obj) {
        this.bJq.obj = obj;
        return this;
    }

    public c av(long j) {
        if (j < 0) {
            j = 0;
        }
        this.bJv = j;
        return this;
    }

    public long aaX() {
        if (this.bJv < 0) {
            return 0L;
        }
        return this.bJv;
    }
}
