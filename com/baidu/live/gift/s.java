package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class s {
    private Set<String> aQJ;

    public static s Fi() {
        return a.aQK;
    }

    public boolean gn(String str) {
        if (TextUtils.isEmpty(str) || this.aQJ == null || this.aQJ.isEmpty()) {
            return false;
        }
        return this.aQJ.contains(str);
    }

    public void go(String str) {
        if (this.aQJ == null) {
            this.aQJ = new HashSet();
        }
        this.aQJ.add(str);
    }

    public void release() {
        if (this.aQJ != null) {
            this.aQJ.clear();
        }
    }

    private s() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static s aQK = new s();
    }
}
