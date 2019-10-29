package com.baidu.live.entereffect.b;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private List<com.baidu.live.im.data.a> Wc;
    private com.baidu.live.im.data.a Wd;

    public static d oO() {
        return a.We;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.Wc == null) {
            this.Wc = new ArrayList();
        }
        this.Wc.add(aVar);
    }

    public boolean hasMsg() {
        return (this.Wc == null || this.Wc.isEmpty()) ? false : true;
    }

    public boolean oP() {
        return this.Wd != null;
    }

    public com.baidu.live.im.data.a oQ() {
        if (hasMsg()) {
            this.Wd = this.Wc.remove(0);
        } else {
            this.Wd = null;
        }
        return this.Wd;
    }

    public com.baidu.live.im.data.a oR() {
        return this.Wd;
    }

    public void release() {
        this.Wd = null;
        if (this.Wc != null) {
            this.Wc.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final d We = new d();
    }
}
