package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes3.dex */
public class d {
    private c aVX;

    public static d EY() {
        return a.aVY;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a EZ() {
        if (this.aVX == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.aVX.EX();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final d aVY = new d();
    }
}
