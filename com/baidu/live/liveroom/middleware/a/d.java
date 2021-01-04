package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes11.dex */
public class d {
    private c bsJ;

    public static d Pg() {
        return a.bsK;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a Ph() {
        if (this.bsJ == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bsJ.Pf();
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final d bsK = new d();
    }
}
