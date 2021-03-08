package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes10.dex */
public class d {
    private c bsY;

    public static d MM() {
        return a.bsZ;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a MN() {
        if (this.bsY == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bsY.ML();
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static final d bsZ = new d();
    }
}
