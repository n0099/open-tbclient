package com.baidu.swan.apps.view.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bZv;
    public boolean bZw;
    public boolean bZx;
    public boolean bZy;
    public boolean bZz;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.bZz = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0304a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean bZy = false;
        private boolean bZz = true;

        public static C0304a ahq() {
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
            this.bZy = z;
            return this;
        }

        public C0304a eh(boolean z) {
            this.bZz = z;
            return this;
        }

        public a ahr() {
            a aVar = new a();
            aVar.bZv = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.bZx = this.isShowStatBar;
            aVar.bZw = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.bZy = this.bZy;
            aVar.bZz = this.bZz;
            return aVar;
        }
    }
}
