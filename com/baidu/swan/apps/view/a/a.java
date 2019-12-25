package com.baidu.swan.apps.view.a;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bVf;
    public boolean bVg;
    public boolean bVh;
    public boolean bVi;
    public boolean bVj;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.bVj = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0292a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean bVi = false;
        private boolean bVj = true;

        public static C0292a aeJ() {
            return new C0292a();
        }

        public C0292a gQ(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0292a gR(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0292a dR(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0292a dS(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0292a dT(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0292a dU(boolean z) {
            this.bVi = z;
            return this;
        }

        public C0292a dV(boolean z) {
            this.bVj = z;
            return this;
        }

        public a aeK() {
            a aVar = new a();
            aVar.bVf = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.bVh = this.isShowStatBar;
            aVar.bVg = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.bVi = this.bVi;
            aVar.bVj = this.bVj;
            return aVar;
        }
    }
}
