package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes4.dex */
public class d {
    private c bgO;

    public static d LL() {
        return a.bgP;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a LM() {
        if (this.bgO == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bgO.LK();
    }

    /* loaded from: classes4.dex */
    public static class a {
        private static final d bgP = new d();
    }
}
