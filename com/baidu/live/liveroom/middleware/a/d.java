package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes4.dex */
public class d {
    private c bnt;

    public static d NJ() {
        return a.bnu;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a NK() {
        if (this.bnt == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bnt.NI();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final d bnu = new d();
    }
}
