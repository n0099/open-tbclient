package com.baidu.swan.apps.view.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int bbC;
    public int bbD;
    public boolean bbE;
    public boolean bbF;
    public boolean bbG;
    public boolean bbH;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0199a {
        private int bbC;
        private int bbI;
        private boolean bbE = true;
        private boolean bbJ = true;
        private boolean bbK = true;
        private boolean bbH = false;

        public static C0199a PZ() {
            return new C0199a();
        }

        public C0199a eF(int i) {
            this.bbC = i;
            return this;
        }

        public C0199a eG(int i) {
            this.bbI = i;
            return this;
        }

        public C0199a cG(boolean z) {
            this.bbE = z;
            return this;
        }

        public C0199a cH(boolean z) {
            this.bbJ = z;
            return this;
        }

        public C0199a cI(boolean z) {
            this.bbK = z;
            return this;
        }

        public C0199a cJ(boolean z) {
            this.bbH = z;
            return this;
        }

        public a Qa() {
            a aVar = new a();
            aVar.bbD = this.bbI;
            aVar.bbE = this.bbE;
            aVar.bbG = this.bbK;
            aVar.bbF = this.bbJ;
            aVar.bbC = this.bbC;
            aVar.bbH = this.bbH;
            return aVar;
        }
    }
}
