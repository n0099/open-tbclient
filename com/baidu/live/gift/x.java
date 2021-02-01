package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class x {
    private Set<String> aXS;

    public static x Fc() {
        return a.aXT;
    }

    public boolean fZ(String str) {
        if (TextUtils.isEmpty(str) || this.aXS == null || this.aXS.isEmpty()) {
            return false;
        }
        return this.aXS.contains(str);
    }

    public void ga(String str) {
        if (this.aXS == null) {
            this.aXS = new HashSet();
        }
        this.aXS.add(str);
    }

    public void release() {
        if (this.aXS != null) {
            this.aXS.clear();
        }
    }

    private x() {
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static x aXT = new x();
    }
}
