package com.baidu.swan.apps.view.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bZA;
    public boolean bZB;
    public int bZx;
    public boolean bZy;
    public boolean bZz;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.bZB = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0304a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean bZA = false;
        private boolean bZB = true;

        public static C0304a ahs() {
            return new C0304a();
        }

        public C0304a hh(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0304a hi(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0304a ed(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0304a ee(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0304a ef(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0304a eg(boolean z) {
            this.bZA = z;
            return this;
        }

        public C0304a eh(boolean z) {
            this.bZB = z;
            return this;
        }

        public a aht() {
            a aVar = new a();
            aVar.bZx = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.bZz = this.isShowStatBar;
            aVar.bZy = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.bZA = this.bZA;
            aVar.bZB = this.bZB;
            return aVar;
        }
    }
}
