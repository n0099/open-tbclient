package com.baidu.swan.apps.view.a;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dOM;
    public int dON;
    public boolean dOO;
    public boolean dOP;
    public boolean dOQ;
    public boolean dOR;
    public boolean dOS;

    private a() {
        this.dOS = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0480a {
        private int dOM;
        private int dOT;
        private boolean dOO = true;
        private boolean dOU = true;
        private boolean dOV = true;
        private boolean dOR = false;
        private boolean dOS = true;

        public static C0480a aOw() {
            return new C0480a();
        }

        public C0480a kn(int i) {
            this.dOM = i;
            return this;
        }

        public C0480a ko(int i) {
            this.dOT = i;
            return this;
        }

        public C0480a hz(boolean z) {
            this.dOO = z;
            return this;
        }

        public C0480a hA(boolean z) {
            this.dOU = z;
            return this;
        }

        public C0480a hB(boolean z) {
            this.dOV = z;
            return this;
        }

        public C0480a hC(boolean z) {
            this.dOR = z;
            return this;
        }

        public C0480a hD(boolean z) {
            this.dOS = z;
            return this;
        }

        public a aOx() {
            a aVar = new a();
            aVar.dON = this.dOT;
            aVar.dOO = this.dOO;
            aVar.dOQ = this.dOV;
            aVar.dOP = this.dOU;
            aVar.dOM = this.dOM;
            aVar.dOR = this.dOR;
            aVar.dOS = this.dOS;
            return aVar;
        }
    }
}
