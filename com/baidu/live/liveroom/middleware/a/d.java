package com.baidu.live.liveroom.middleware.a;
/* loaded from: classes11.dex */
public class d {
    private c bry;

    public static d MJ() {
        return a.brz;
    }

    private d() {
    }

    public com.baidu.live.liveroom.middleware.a.a MK() {
        if (this.bry == null) {
            throw new RuntimeException("IMasterEndViewControllerBuilder must not be null! should invoke MasterEndViewControllerManager.init() first~");
        }
        return this.bry.MI();
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final d brz = new d();
    }
}
