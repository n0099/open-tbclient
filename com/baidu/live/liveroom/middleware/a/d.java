package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes3.dex */
public class d {
    private c aPI;

    public static d DB() {
        return a.aPJ;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a DC() {
        if (this.aPI == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.aPI.DA();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final d aPJ = new d();
    }
}
