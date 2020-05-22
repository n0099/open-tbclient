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
    private final Message ctK;
    private final Set<SwanAppProcessInfo> ctL;
    private final Set<String> ctM;
    private boolean ctN;
    private long ctO;
    private boolean ctz;

    @NonNull
    public Message amK() {
        if (this.ctK.obj == null) {
            Q(new Bundle());
        }
        return this.ctK;
    }

    public c(Message message) {
        this.ctL = new HashSet();
        this.ctM = new HashSet();
        this.ctz = false;
        this.ctN = false;
        this.ctO = 0L;
        this.ctK = message == null ? Message.obtain() : message;
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

    public c eH(boolean z) {
        this.ctN = z;
        return this;
    }

    public boolean isSticky() {
        return this.ctN;
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
            this.ctL.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c u(String... strArr) {
        if (strArr != null) {
            this.ctM.addAll(Arrays.asList(strArr));
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

    public c amL() {
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

    public c eI(boolean z) {
        this.ctz = z;
        return this;
    }

    public Set<SwanAppProcessInfo> amM() {
        return new HashSet(this.ctL);
    }

    public Set<String> amN() {
        return new HashSet(this.ctM);
    }

    public boolean amO() {
        return this.ctz;
    }

    public c Q(Object obj) {
        this.ctK.obj = obj;
        return this;
    }

    public c bk(long j) {
        if (j < 0) {
            j = 0;
        }
        this.ctO = j;
        return this;
    }

    public long amP() {
        if (this.ctO < 0) {
            return 0L;
        }
        return this.ctO;
    }
}
