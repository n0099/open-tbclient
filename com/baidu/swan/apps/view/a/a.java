package com.baidu.swan.apps.view.a;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bVr;
    public boolean bVs;
    public boolean bVt;
    public boolean bVu;
    public boolean bVv;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.bVv = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0294a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean bVu = false;
        private boolean bVv = true;

        public static C0294a afc() {
            return new C0294a();
        }

        public C0294a gQ(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0294a gR(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0294a dW(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0294a dX(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0294a dY(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0294a dZ(boolean z) {
            this.bVu = z;
            return this;
        }

        public C0294a ea(boolean z) {
            this.bVv = z;
            return this;
        }

        public a afd() {
            a aVar = new a();
            aVar.bVr = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.bVt = this.isShowStatBar;
            aVar.bVs = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.bVu = this.bVu;
            aVar.bVv = this.bVv;
            return aVar;
        }
    }
}
