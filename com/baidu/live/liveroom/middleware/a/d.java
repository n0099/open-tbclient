package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes10.dex */
public class d {
    private c bnX;

    public static d Ll() {
        return a.bnY;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a Lm() {
        if (this.bnX == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bnX.Lk();
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static final d bnY = new d();
    }
}
