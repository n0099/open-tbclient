package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes4.dex */
public class d {
    private c bqP;

    public static d Ps() {
        return a.bqQ;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a Pt() {
        if (this.bqP == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bqP.Pr();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final d bqQ = new d();
    }
}
