package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes4.dex */
public class d {
    private c bkE;

    public static d MP() {
        return a.bkF;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a MQ() {
        if (this.bkE == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bkE.MO();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final d bkF = new d();
    }
}
