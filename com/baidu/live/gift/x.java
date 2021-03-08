package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class x {
    private Set<String> aZs;

    public static x Ff() {
        return a.aZt;
    }

    public boolean gf(String str) {
        if (TextUtils.isEmpty(str) || this.aZs == null || this.aZs.isEmpty()) {
            return false;
        }
        return this.aZs.contains(str);
    }

    public void gg(String str) {
        if (this.aZs == null) {
            this.aZs = new HashSet();
        }
        this.aZs.add(str);
    }

    public void release() {
        if (this.aZs != null) {
            this.aZs.clear();
        }
    }

    private x() {
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static x aZt = new x();
    }
}
