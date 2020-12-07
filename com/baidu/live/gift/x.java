package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class x {
    private Set<String> aXS;

    public static x Ig() {
        return a.aXT;
    }

    public boolean hf(String str) {
        if (TextUtils.isEmpty(str) || this.aXS == null || this.aXS.isEmpty()) {
            return false;
        }
        return this.aXS.contains(str);
    }

    public void hg(String str) {
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

    /* loaded from: classes4.dex */
    private static class a {
        private static x aXT = new x();
    }
}
