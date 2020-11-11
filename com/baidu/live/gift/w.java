package com.baidu.live.gift;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class w {
    private Set<String> aWw;

    public static w Ha() {
        return a.aWx;
    }

    public boolean gQ(String str) {
        if (TextUtils.isEmpty(str) || this.aWw == null || this.aWw.isEmpty()) {
            return false;
        }
        return this.aWw.contains(str);
    }

    public void gR(String str) {
        if (this.aWw == null) {
            this.aWw = new HashSet();
        }
        this.aWw.add(str);
    }

    public void release() {
        if (this.aWw != null) {
            this.aWw.clear();
        }
    }

    private w() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static w aWx = new w();
    }
}
