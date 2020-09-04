package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes7.dex */
public class d {
    private c bdX;

    public static d Li() {
        return a.bdY;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a Lj() {
        if (this.bdX == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bdX.Lh();
    }

    /* loaded from: classes7.dex */
    public static class a {
        private static final d bdY = new d();
    }
}
