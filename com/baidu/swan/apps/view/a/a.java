package com.baidu.swan.apps.view.a;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cTR;
    public boolean cTS;
    public boolean cTT;
    public boolean cTU;
    public boolean cTV;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.cTV = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0410a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean cTU = false;
        private boolean cTV = true;

        public static C0410a axD() {
            return new C0410a();
        }

        public C0410a ij(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0410a ik(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0410a fJ(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0410a fK(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0410a fL(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0410a fM(boolean z) {
            this.cTU = z;
            return this;
        }

        public C0410a fN(boolean z) {
            this.cTV = z;
            return this;
        }

        public a axE() {
            a aVar = new a();
            aVar.cTR = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.cTT = this.isShowStatBar;
            aVar.cTS = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.cTU = this.cTU;
            aVar.cTV = this.cTV;
            return aVar;
        }
    }
}
