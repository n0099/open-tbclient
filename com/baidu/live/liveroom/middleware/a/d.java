package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes3.dex */
public class d {
    private c awf;

    public static d yH() {
        return a.awg;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a yI() {
        if (this.awf == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.awf.yG();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static final d awg = new d();
    }
}
