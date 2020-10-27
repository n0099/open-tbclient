package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class x {
    private Set<String> aVe;

    public static x Gz() {
        return a.aVf;
    }

    public boolean gL(String str) {
        if (TextUtils.isEmpty(str) || this.aVe == null || this.aVe.isEmpty()) {
            return false;
        }
        return this.aVe.contains(str);
    }

    public void gM(String str) {
        if (this.aVe == null) {
            this.aVe = new HashSet();
        }
        this.aVe.add(str);
    }

    public void release() {
        if (this.aVe != null) {
            this.aVe.clear();
        }
    }

    private x() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static x aVf = new x();
    }
}
