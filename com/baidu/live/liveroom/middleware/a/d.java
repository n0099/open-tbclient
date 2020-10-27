package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes4.dex */
public class d {
    private c blZ;

    public static d Nj() {
        return a.bma;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a Nk() {
        if (this.blZ == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.blZ.Ni();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final d bma = new d();
    }
}
