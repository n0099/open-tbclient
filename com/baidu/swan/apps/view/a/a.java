package com.baidu.swan.apps.view.a;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dzE;
    public boolean dzF;
    public boolean dzG;
    public boolean dzH;
    public boolean dzI;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.dzI = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0482a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean dzH = false;
        private boolean dzI = true;

        public static C0482a aKY() {
            return new C0482a();
        }

        public C0482a lk(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0482a ll(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0482a gK(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0482a gL(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0482a gM(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0482a gN(boolean z) {
            this.dzH = z;
            return this;
        }

        public C0482a gO(boolean z) {
            this.dzI = z;
            return this;
        }

        public a aKZ() {
            a aVar = new a();
            aVar.dzE = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.dzG = this.isShowStatBar;
            aVar.dzF = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.dzH = this.dzH;
            aVar.dzI = this.dzI;
            return aVar;
        }
    }
}
