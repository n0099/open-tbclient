package com.baidu.swan.apps.view.a;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int deY;
    public boolean deZ;
    public boolean dfa;
    public boolean dfb;
    public boolean dfc;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.dfc = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0451a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean dfb = false;
        private boolean dfc = true;

        public static C0451a aGv() {
            return new C0451a();
        }

        public C0451a kC(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0451a kD(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0451a gb(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0451a gc(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0451a gd(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0451a ge(boolean z) {
            this.dfb = z;
            return this;
        }

        public C0451a gf(boolean z) {
            this.dfc = z;
            return this;
        }

        public a aGw() {
            a aVar = new a();
            aVar.deY = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.dfa = this.isShowStatBar;
            aVar.deZ = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.dfb = this.dfb;
            aVar.dfc = this.dfc;
            return aVar;
        }
    }
}
