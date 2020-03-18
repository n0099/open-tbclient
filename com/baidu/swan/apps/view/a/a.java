package com.baidu.swan.apps.view.a;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bZI;
    public boolean bZJ;
    public boolean bZK;
    public boolean bZL;
    public boolean bZM;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.bZM = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0304a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean bZL = false;
        private boolean bZM = true;

        public static C0304a ahv() {
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

        public C0304a ee(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0304a ef(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0304a eg(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0304a eh(boolean z) {
            this.bZL = z;
            return this;
        }

        public C0304a ei(boolean z) {
            this.bZM = z;
            return this;
        }

        public a ahw() {
            a aVar = new a();
            aVar.bZI = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.bZK = this.isShowStatBar;
            aVar.bZJ = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.bZL = this.bZL;
            aVar.bZM = this.bZM;
            return aVar;
        }
    }
}
