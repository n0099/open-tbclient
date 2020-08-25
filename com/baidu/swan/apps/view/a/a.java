package com.baidu.swan.apps.view.a;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dcS;
    public boolean dcT;
    public boolean dcU;
    public boolean dcV;
    public boolean dcW;
    public boolean isShowNavBar;
    public int statusBarColor;

    private a() {
        this.dcW = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0456a {
        private int customStatBarViewBg;
        private int statusBarColor;
        private boolean isShowNavBar = true;
        private boolean useLightStatBar = true;
        private boolean isShowStatBar = true;
        private boolean dcV = false;
        private boolean dcW = true;

        public static C0456a aFL() {
            return new C0456a();
        }

        public C0456a kr(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0456a ks(int i) {
            this.customStatBarViewBg = i;
            return this;
        }

        public C0456a gc(boolean z) {
            this.isShowNavBar = z;
            return this;
        }

        public C0456a gd(boolean z) {
            this.useLightStatBar = z;
            return this;
        }

        public C0456a ge(boolean z) {
            this.isShowStatBar = z;
            return this;
        }

        public C0456a gf(boolean z) {
            this.dcV = z;
            return this;
        }

        public C0456a gg(boolean z) {
            this.dcW = z;
            return this;
        }

        public a aFM() {
            a aVar = new a();
            aVar.dcS = this.customStatBarViewBg;
            aVar.isShowNavBar = this.isShowNavBar;
            aVar.dcU = this.isShowStatBar;
            aVar.dcT = this.useLightStatBar;
            aVar.statusBarColor = this.statusBarColor;
            aVar.dcV = this.dcV;
            aVar.dcW = this.dcW;
            return aVar;
        }
    }
}
