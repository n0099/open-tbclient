package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class x {
    private Set<String> aZx;

    public static x HH() {
        return a.aZy;
    }

    public boolean gQ(String str) {
        if (TextUtils.isEmpty(str) || this.aZx == null || this.aZx.isEmpty()) {
            return false;
        }
        return this.aZx.contains(str);
    }

    public void gR(String str) {
        if (this.aZx == null) {
            this.aZx = new HashSet();
        }
        this.aZx.add(str);
    }

    public void release() {
        if (this.aZx != null) {
            this.aZx.clear();
        }
    }

    private x() {
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static x aZy = new x();
    }
}
