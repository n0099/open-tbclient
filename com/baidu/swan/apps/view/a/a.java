package com.baidu.swan.apps.view.a;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean dFA;
    public int dFw;
    public boolean dFx;
    public boolean dFy;
    public boolean dFz;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.dFA = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0494a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean dFz = false;
        private boolean dFA = true;

        public static C0494a aNy() {
            return new C0494a();
        }

        public C0494a lu(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0494a lv(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0494a gT(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0494a gU(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0494a gV(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0494a gW(boolean z) {
            this.dFz = z;
            return this;
        }

        public C0494a gX(boolean z) {
            this.dFA = z;
            return this;
        }

        public a aNz() {
            a aVar = new a();
            aVar.dFw = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.dFy = this.isShowStatBar;
            aVar.dFx = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.dFz = this.dFz;
            aVar.dFA = this.dFA;
            return aVar;
        }
    }
}
