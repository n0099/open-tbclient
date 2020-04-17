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
    private final Message chZ;
    private final Set<SwanAppProcessInfo> cia;
    private final Set<String> cib;
    private boolean cic;
    private boolean cie;
    private long cif;

    @NonNull
    public Message aiX() {
        if (this.chZ.obj == null) {
            M(new Bundle());
        }
        return this.chZ;
    }

    public c(Message message) {
        this.cia = new HashSet();
        this.cib = new HashSet();
        this.cic = false;
        this.cie = false;
        this.cif = 0L;
        this.chZ = message == null ? Message.obtain() : message;
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
        this.cie = z;
        return this;
    }

    public boolean isSticky() {
        return this.cie;
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
        this.cia.addAll(Arrays.asList(swanAppProcessInfoArr));
        return this;
    }

    public c u(String... strArr) {
        this.cib.addAll(Arrays.asList(strArr));
        return this;
    }

    public c e(int... iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            a(SwanAppProcessInfo.indexOf(iArr[i]));
        }
        return this;
    }

    public c aiY() {
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
        this.cic = z;
        return this;
    }

    public Set<SwanAppProcessInfo> aiZ() {
        return new HashSet(this.cia);
    }

    public Set<String> aja() {
        return new HashSet(this.cib);
    }

    public boolean ajb() {
        return this.cic;
    }

    public c M(Object obj) {
        this.chZ.obj = obj;
        return this;
    }

    public c ba(long j) {
        if (j < 0) {
            j = 0;
        }
        this.cif = j;
        return this;
    }

    public long ajc() {
        if (this.cif < 0) {
            return 0L;
        }
        return this.cif;
    }
}
