package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes3.dex */
public class d {
    private c aYG;

    public static d FH() {
        return a.aYH;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a FI() {
        if (this.aYG == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.aYG.FG();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final d aYH = new d();
    }
}
