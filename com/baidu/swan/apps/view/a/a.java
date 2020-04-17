package com.baidu.swan.apps.view.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cyH;
    public boolean cyI;
    public boolean cyJ;
    public boolean cyK;
    public boolean cyL;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.cyL = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0334a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean cyK = false;
        private boolean cyL = true;

        public static C0334a apD() {
            return new C0334a();
        }

        public C0334a ho(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0334a hp(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0334a fa(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0334a fb(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0334a fc(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0334a fd(boolean z) {
            this.cyK = z;
            return this;
        }

        public C0334a fe(boolean z) {
            this.cyL = z;
            return this;
        }

        public a apE() {
            a aVar = new a();
            aVar.cyH = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.cyJ = this.isShowStatBar;
            aVar.cyI = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.cyK = this.cyK;
            aVar.cyL = this.cyL;
            return aVar;
        }
    }
}
