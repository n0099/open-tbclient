package com.baidu.swan.apps.view.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aWW;
    public boolean aWX;
    public boolean aWY;
    public boolean aWZ;
    public boolean aXa;
    public int statusBarColor;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0180a {
        private int aXb;
        private int statusBarColor;
        private boolean aWX = true;
        private boolean aXc = true;
        private boolean aXd = true;
        private boolean aXa = false;

        public static C0180a Mx() {
            return new C0180a();
        }

        public C0180a eq(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0180a er(int i) {
            this.aXb = i;
            return this;
        }

        public C0180a co(boolean z) {
            this.aWX = z;
            return this;
        }

        public C0180a cp(boolean z) {
            this.aXc = z;
            return this;
        }

        public C0180a cq(boolean z) {
            this.aXd = z;
            return this;
        }

        public C0180a cr(boolean z) {
            this.aXa = z;
            return this;
        }

        public a My() {
            a aVar = new a();
            aVar.aWW = this.aXb;
            aVar.aWX = this.aWX;
            aVar.aWZ = this.aXd;
            aVar.aWY = this.aXc;
            aVar.statusBarColor = this.statusBarColor;
            aVar.aXa = this.aXa;
            return aVar;
        }
    }
}
