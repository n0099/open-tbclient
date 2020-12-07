package com.baidu.swan.apps.view.a;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dKN;
    public boolean dKO;
    public boolean dKP;
    public boolean dKQ;
    public boolean dKR;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.dKR = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0504a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean dKQ = false;
        private boolean dKR = true;

        public static C0504a aPW() {
            return new C0504a();
        }

        public C0504a lO(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0504a lP(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0504a hl(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0504a hm(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0504a hn(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0504a ho(boolean z) {
            this.dKQ = z;
            return this;
        }

        public C0504a hp(boolean z) {
            this.dKR = z;
            return this;
        }

        public a aPX() {
            a aVar = new a();
            aVar.dKN = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.dKP = this.isShowStatBar;
            aVar.dKO = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.dKQ = this.dKQ;
            aVar.dKR = this.dKR;
            return aVar;
        }
    }
}
