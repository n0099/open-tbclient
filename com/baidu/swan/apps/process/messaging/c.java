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
    private final Message bEY;
    private final Set<SwanAppProcessInfo> bEZ;
    private final Set<String> bFa;
    private boolean bFb;
    private boolean bFc;
    private long bFd;

    @NonNull
    public Message Yz() {
        if (this.bEY.obj == null) {
            J(new Bundle());
        }
        return this.bEY;
    }

    public c(Message message) {
        this.bEZ = new HashSet();
        this.bFa = new HashSet();
        this.bFb = false;
        this.bFc = false;
        this.bFd = 0L;
        this.bEY = message == null ? Message.obtain() : message;
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

    public c dk(boolean z) {
        this.bFc = z;
        return this;
    }

    public boolean isSticky() {
        return this.bFc;
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
        this.bEZ.addAll(Arrays.asList(swanAppProcessInfoArr));
        return this;
    }

    public c q(String... strArr) {
        this.bFa.addAll(Arrays.asList(strArr));
        return this;
    }

    public c e(int... iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            a(SwanAppProcessInfo.indexOf(iArr[i]));
        }
        return this;
    }

    public c YA() {
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

    public c dl(boolean z) {
        this.bFb = z;
        return this;
    }

    public Set<SwanAppProcessInfo> YB() {
        return new HashSet(this.bEZ);
    }

    public Set<String> YC() {
        return new HashSet(this.bFa);
    }

    public boolean YD() {
        return this.bFb;
    }

    public c J(Object obj) {
        this.bEY.obj = obj;
        return this;
    }

    public c ar(long j) {
        if (j < 0) {
            j = 0;
        }
        this.bFd = j;
        return this;
    }

    public long YE() {
        if (this.bFd < 0) {
            return 0L;
        }
        return this.bFd;
    }
}
