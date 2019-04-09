package com.baidu.swan.apps.view.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int aXa;
    public boolean aXb;
    public boolean aXc;
    public boolean aXd;
    public boolean aXe;
    public int statusBarColor;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0180a {
        private int aXf;
        private int statusBarColor;
        private boolean aXb = true;
        private boolean aXg = true;
        private boolean aXh = true;
        private boolean aXe = false;

        public static C0180a Mv() {
            return new C0180a();
        }

        public C0180a ep(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0180a eq(int i) {
            this.aXf = i;
            return this;
        }

        public C0180a co(boolean z) {
            this.aXb = z;
            return this;
        }

        public C0180a cp(boolean z) {
            this.aXg = z;
            return this;
        }

        public C0180a cq(boolean z) {
            this.aXh = z;
            return this;
        }

        public C0180a cr(boolean z) {
            this.aXe = z;
            return this;
        }

        public a Mw() {
            a aVar = new a();
            aVar.aXa = this.aXf;
            aVar.aXb = this.aXb;
            aVar.aXd = this.aXh;
            aVar.aXc = this.aXg;
            aVar.statusBarColor = this.statusBarColor;
            aVar.aXe = this.aXe;
            return aVar;
        }
    }
}
