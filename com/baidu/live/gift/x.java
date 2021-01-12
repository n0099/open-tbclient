package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class x {
    private Set<String> aUK;

    public static x DM() {
        return a.aUL;
    }

    public boolean fE(String str) {
        if (TextUtils.isEmpty(str) || this.aUK == null || this.aUK.isEmpty()) {
            return false;
        }
        return this.aUK.contains(str);
    }

    public void fF(String str) {
        if (this.aUK == null) {
            this.aUK = new HashSet();
        }
        this.aUK.add(str);
    }

    public void release() {
        if (this.aUK != null) {
            this.aUK.clear();
        }
    }

    private x() {
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static x aUL = new x();
    }
}
