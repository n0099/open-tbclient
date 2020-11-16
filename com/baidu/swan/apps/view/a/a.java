package com.baidu.swan.apps.view.a;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dDP;
    public boolean dDQ;
    public boolean dDR;
    public boolean dDS;
    public boolean dDT;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.dDT = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0492a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean dDS = false;
        private boolean dDT = true;

        public static C0492a aMQ() {
            return new C0492a();
        }

        public C0492a lq(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0492a lr(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0492a gW(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0492a gX(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0492a gY(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0492a gZ(boolean z) {
            this.dDS = z;
            return this;
        }

        public C0492a ha(boolean z) {
            this.dDT = z;
            return this;
        }

        public a aMR() {
            a aVar = new a();
            aVar.dDP = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.dDR = this.isShowStatBar;
            aVar.dDQ = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.dDS = this.dDS;
            aVar.dDT = this.dDT;
            return aVar;
        }
    }
}
