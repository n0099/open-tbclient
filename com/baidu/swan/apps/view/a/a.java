package com.baidu.swan.apps.view.a;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dQS;
    public int dQT;
    public boolean dQU;
    public boolean dQV;
    public boolean dQW;
    public boolean dQX;
    public boolean dQY;

    private a() {
        this.dQY = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0477a {
        private int dQS;
        private int dQZ;
        private boolean dQU = true;
        private boolean dRa = true;
        private boolean dRb = true;
        private boolean dQX = false;
        private boolean dQY = true;

        public static C0477a aOP() {
            return new C0477a();
        }

        public C0477a kq(int i) {
            this.dQS = i;
            return this;
        }

        public C0477a kr(int i) {
            this.dQZ = i;
            return this;
        }

        public C0477a hB(boolean z) {
            this.dQU = z;
            return this;
        }

        public C0477a hC(boolean z) {
            this.dRa = z;
            return this;
        }

        public C0477a hD(boolean z) {
            this.dRb = z;
            return this;
        }

        public C0477a hE(boolean z) {
            this.dQX = z;
            return this;
        }

        public C0477a hF(boolean z) {
            this.dQY = z;
            return this;
        }

        public a aOQ() {
            a aVar = new a();
            aVar.dQT = this.dQZ;
            aVar.dQU = this.dQU;
            aVar.dQW = this.dRb;
            aVar.dQV = this.dRa;
            aVar.dQS = this.dQS;
            aVar.dQX = this.dQX;
            aVar.dQY = this.dQY;
            return aVar;
        }
    }
}
