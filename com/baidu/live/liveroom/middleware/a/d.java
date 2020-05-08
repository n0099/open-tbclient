package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes3.dex */
public class d {
    private c aPO;

    public static d DA() {
        return a.aPP;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a DB() {
        if (this.aPO == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.aPO.Dz();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final d aPP = new d();
    }
}
