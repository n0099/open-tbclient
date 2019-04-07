package com.baidu.swan.apps.view.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aWZ;
    public boolean aXa;
    public boolean aXb;
    public boolean aXc;
    public boolean aXd;
    public int statusBarColor;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0180a {
        private int aXe;
        private int statusBarColor;
        private boolean aXa = true;
        private boolean aXf = true;
        private boolean aXg = true;
        private boolean aXd = false;

        public static C0180a Mv() {
            return new C0180a();
        }

        public C0180a ep(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0180a eq(int i) {
            this.aXe = i;
            return this;
        }

        public C0180a co(boolean z) {
            this.aXa = z;
            return this;
        }

        public C0180a cp(boolean z) {
            this.aXf = z;
            return this;
        }

        public C0180a cq(boolean z) {
            this.aXg = z;
            return this;
        }

        public C0180a cr(boolean z) {
            this.aXd = z;
            return this;
        }

        public a Mw() {
            a aVar = new a();
            aVar.aWZ = this.aXe;
            aVar.aXa = this.aXa;
            aVar.aXc = this.aXg;
            aVar.aXb = this.aXf;
            aVar.statusBarColor = this.statusBarColor;
            aVar.aXd = this.aXd;
            return aVar;
        }
    }
}
