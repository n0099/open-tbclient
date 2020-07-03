package com.baidu.swan.apps.view.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int cQq;
    public boolean cQr;
    public boolean cQs;
    public boolean cQt;
    public boolean cQu;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.cQu = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0404a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean cQt = false;
        private boolean cQu = true;

        public static C0404a avp() {
            return new C0404a();
        }

        public C0404a hY(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0404a hZ(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0404a fA(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0404a fB(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0404a fC(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0404a fD(boolean z) {
            this.cQt = z;
            return this;
        }

        public C0404a fE(boolean z) {
            this.cQu = z;
            return this;
        }

        public a avq() {
            a aVar = new a();
            aVar.cQq = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.cQs = this.isShowStatBar;
            aVar.cQr = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.cQt = this.cQt;
            aVar.cQu = this.cQu;
            return aVar;
        }
    }
}
