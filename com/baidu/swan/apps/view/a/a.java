package com.baidu.swan.apps.view.a;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dre;
    public boolean drf;
    public boolean drg;
    public boolean drh;
    public boolean dri;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.dri = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0468a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean drh = false;
        private boolean dri = true;

        public static C0468a aJe() {
            return new C0468a();
        }

        public C0468a kZ(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0468a la(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0468a gx(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0468a gy(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0468a gz(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0468a gA(boolean z) {
            this.drh = z;
            return this;
        }

        public C0468a gB(boolean z) {
            this.dri = z;
            return this;
        }

        public a aJf() {
            a aVar = new a();
            aVar.dre = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.drg = this.isShowStatBar;
            aVar.drf = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.drh = this.drh;
            aVar.dri = this.dri;
            return aVar;
        }
    }
}
