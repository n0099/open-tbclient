package com.baidu.swan.apps.view.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bau;
    public boolean bav;
    public boolean baw;
    public boolean bax;
    public boolean bay;
    public int statusBarColor;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0188a {
        private int baz;
        private int statusBarColor;
        private boolean bav = true;
        private boolean baA = true;
        private boolean baB = true;
        private boolean bay = false;

        public static C0188a Pe() {
            return new C0188a();
        }

        public C0188a eB(int i) {
            this.statusBarColor = i;
            return this;
        }

        public C0188a eC(int i) {
            this.baz = i;
            return this;
        }

        public C0188a cD(boolean z) {
            this.bav = z;
            return this;
        }

        public C0188a cE(boolean z) {
            this.baA = z;
            return this;
        }

        public C0188a cF(boolean z) {
            this.baB = z;
            return this;
        }

        public C0188a cG(boolean z) {
            this.bay = z;
            return this;
        }

        public a Pf() {
            a aVar = new a();
            aVar.bau = this.baz;
            aVar.bav = this.bav;
            aVar.bax = this.baB;
            aVar.baw = this.baA;
            aVar.statusBarColor = this.statusBarColor;
            aVar.bay = this.bay;
            return aVar;
        }
    }
}
