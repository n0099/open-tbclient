package com.baidu.swan.apps.view.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cLG;
    public boolean cLH;
    public boolean cLI;
    public boolean cLJ;
    public boolean cLK;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.cLK = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0398a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean cLJ = false;
        private boolean cLK = true;

        public static C0398a auj() {
            return new C0398a();
        }

        public C0398a hN(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0398a hO(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0398a fv(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0398a fw(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0398a fx(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0398a fy(boolean z) {
            this.cLJ = z;
            return this;
        }

        public C0398a fz(boolean z) {
            this.cLK = z;
            return this;
        }

        public a auk() {
            a aVar = new a();
            aVar.cLG = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.cLI = this.isShowStatBar;
            aVar.cLH = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.cLJ = this.cLJ;
            aVar.cLK = this.cLK;
            return aVar;
        }
    }
}
