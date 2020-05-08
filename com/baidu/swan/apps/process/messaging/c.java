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
    private final Message cig;
    private final Set<SwanAppProcessInfo> cih;
    private final Set<String> cii;
    private boolean cij;
    private boolean cik;
    private long cil;

    @NonNull
    public Message aiW() {
        if (this.cig.obj == null) {
            N(new Bundle());
        }
        return this.cig;
    }

    public c(Message message) {
        this.cih = new HashSet();
        this.cii = new HashSet();
        this.cij = false;
        this.cik = false;
        this.cil = 0L;
        this.cig = message == null ? Message.obtain() : message;
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

    public c eo(boolean z) {
        this.cik = z;
        return this;
    }

    public boolean isSticky() {
        return this.cik;
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
        this.cih.addAll(Arrays.asList(swanAppProcessInfoArr));
        return this;
    }

    public c u(String... strArr) {
        this.cii.addAll(Arrays.asList(strArr));
        return this;
    }

    public c e(int... iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            a(SwanAppProcessInfo.indexOf(iArr[i]));
        }
        return this;
    }

    public c aiX() {
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

    public c ep(boolean z) {
        this.cij = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aiY() {
        return new HashSet(this.cih);
    }

    public Set<String> aiZ() {
        return new HashSet(this.cii);
    }

    public boolean aja() {
        return this.cij;
    }

    public c N(Object obj) {
        this.cig.obj = obj;
        return this;
    }

    public c ba(long j) {
        if (j < 0) {
            j = 0;
        }
        this.cil = j;
        return this;
    }

    public long ajb() {
        if (this.cil < 0) {
            return 0L;
        }
        return this.cil;
    }
}
