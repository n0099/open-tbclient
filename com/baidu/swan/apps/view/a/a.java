package com.baidu.swan.apps.view.a;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int dSt;
    public int dSu;
    public boolean dSv;
    public boolean dSw;
    public boolean dSx;
    public boolean dSy;
    public boolean dSz;

    private a() {
        this.dSz = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0483a {
        private int dSA;
        private int dSt;
        private boolean dSv = true;
        private boolean dSB = true;
        private boolean dSC = true;
        private boolean dSy = false;
        private boolean dSz = true;

        public static C0483a aOS() {
            return new C0483a();
        }

        public C0483a kr(int i) {
            this.dSt = i;
            return this;
        }

        public C0483a ks(int i) {
            this.dSA = i;
            return this;
        }

        public C0483a hB(boolean z) {
            this.dSv = z;
            return this;
        }

        public C0483a hC(boolean z) {
            this.dSB = z;
            return this;
        }

        public C0483a hD(boolean z) {
            this.dSC = z;
            return this;
        }

        public C0483a hE(boolean z) {
            this.dSy = z;
            return this;
        }

        public C0483a hF(boolean z) {
            this.dSz = z;
            return this;
        }

        public a aOT() {
            a aVar = new a();
            aVar.dSu = this.dSA;
            aVar.dSv = this.dSv;
            aVar.dSx = this.dSC;
            aVar.dSw = this.dSB;
            aVar.dSt = this.dSt;
            aVar.dSy = this.dSy;
            aVar.dSz = this.dSz;
            return aVar;
        }
    }
}
