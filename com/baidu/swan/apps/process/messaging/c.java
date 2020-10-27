package com.baidu.swan.apps.process.messaging;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class c {
    private boolean dfD;
    private final Message dfO;
    private final Set<SwanAppProcessInfo> dfP;
    private final Set<String> dfQ;
    private boolean dfR;
    private long dfS;

    @NonNull
    public Message aCI() {
        if (this.dfO.obj == null) {
            X(new Bundle());
        }
        return this.dfO;
    }

    public c(Message message) {
        this.dfP = new HashSet();
        this.dfQ = new HashSet();
        this.dfD = false;
        this.dfR = false;
        this.dfS = 0L;
        this.dfO = message == null ? Message.obtain() : message;
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

    public c fW(boolean z) {
        this.dfR = z;
        return this;
    }

    public boolean isSticky() {
        return this.dfR;
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
            this.dfP.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c w(String... strArr) {
        if (strArr != null) {
            this.dfQ.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public c f(int... iArr) {
        if (iArr != null) {
            for (int i : iArr) {
                if (SwanAppProcessInfo.checkProcessId(i)) {
                    a(SwanAppProcessInfo.indexOf(i));
                }
            }
        }
        return this;
    }

    public c aCJ() {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess()) {
                a(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c g(int... iArr) {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess() && !a(iArr, swanAppProcessInfo.index)) {
                a(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c fX(boolean z) {
        this.dfD = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aCK() {
        return new HashSet(this.dfP);
    }

    public Set<String> aCL() {
        return new HashSet(this.dfQ);
    }

    public boolean aCM() {
        return this.dfD;
    }

    public c X(Object obj) {
        this.dfO.obj = obj;
        return this;
    }

    public c bN(long j) {
        if (j < 0) {
            j = 0;
        }
        this.dfS = j;
        return this;
    }

    public long aCN() {
        if (this.dfS < 0) {
            return 0L;
        }
        return this.dfS;
    }
}
