package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes7.dex */
public class d {
    private c bdV;

    public static d Li() {
        return a.bdW;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a Lj() {
        if (this.bdV == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bdV.Lh();
    }

    /* loaded from: classes7.dex */
    public static class a {
        private static final d bdW = new d();
    }
}
