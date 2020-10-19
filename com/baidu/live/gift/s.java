package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class s {
    private Set<String> aTU;

    public static s Ge() {
        return a.aTV;
    }

    public boolean gC(String str) {
        if (TextUtils.isEmpty(str) || this.aTU == null || this.aTU.isEmpty()) {
            return false;
        }
        return this.aTU.contains(str);
    }

    public void gD(String str) {
        if (this.aTU == null) {
            this.aTU = new HashSet();
        }
        this.aTU.add(str);
    }

    public void release() {
        if (this.aTU != null) {
            this.aTU.clear();
        }
    }

    private s() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static s aTV = new s();
    }
}
