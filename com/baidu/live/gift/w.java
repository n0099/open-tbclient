package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class w {
    private Set<String> aUL;

    public static w Gr() {
        return a.aUM;
    }

    public boolean gK(String str) {
        if (TextUtils.isEmpty(str) || this.aUL == null || this.aUL.isEmpty()) {
            return false;
        }
        return this.aUL.contains(str);
    }

    public void gL(String str) {
        if (this.aUL == null) {
            this.aUL = new HashSet();
        }
        this.aUL.add(str);
    }

    public void release() {
        if (this.aUL != null) {
            this.aUL.clear();
        }
    }

    private w() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static w aUM = new w();
    }
}
