package com.baidu.swan.apps.view.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cyN;
    public boolean cyO;
    public boolean cyP;
    public boolean cyQ;
    public boolean cyR;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.cyR = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0355a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean cyQ = false;
        private boolean cyR = true;

        public static C0355a apC() {
            return new C0355a();
        }

        public C0355a ho(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0355a hp(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0355a fa(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0355a fb(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0355a fc(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0355a fd(boolean z) {
            this.cyQ = z;
            return this;
        }

        public C0355a fe(boolean z) {
            this.cyR = z;
            return this;
        }

        public a apD() {
            a aVar = new a();
            aVar.cyN = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.cyP = this.isShowStatBar;
            aVar.cyO = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.cyQ = this.cyQ;
            aVar.cyR = this.cyR;
            return aVar;
        }
    }
}
