package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes4.dex */
public class d {
    private c blI;

    public static d Na() {
        return a.blJ;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a Nb() {
        if (this.blI == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.blI.MZ();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final d blJ = new d();
    }
}
