package com.baidu.swan.apps.view.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bbe;
    public int bbf;
    public boolean bbg;
    public boolean bbh;
    public boolean bbi;
    public boolean bbj;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0190a {
        private int bbe;
        private int bbk;
        private boolean bbg = true;
        private boolean bbl = true;
        private boolean bbm = true;
        private boolean bbj = false;

        public static C0190a PV() {
            return new C0190a();
        }

        public C0190a eE(int i) {
            this.bbe = i;
            return this;
        }

        public C0190a eF(int i) {
            this.bbk = i;
            return this;
        }

        public C0190a cG(boolean z) {
            this.bbg = z;
            return this;
        }

        public C0190a cH(boolean z) {
            this.bbl = z;
            return this;
        }

        public C0190a cI(boolean z) {
            this.bbm = z;
            return this;
        }

        public C0190a cJ(boolean z) {
            this.bbj = z;
            return this;
        }

        public a PW() {
            a aVar = new a();
            aVar.bbf = this.bbk;
            aVar.bbg = this.bbg;
            aVar.bbi = this.bbm;
            aVar.bbh = this.bbl;
            aVar.bbe = this.bbe;
            aVar.bbj = this.bbj;
            return aVar;
        }
    }
}
