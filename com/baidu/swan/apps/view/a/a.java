package com.baidu.swan.apps.view.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int buC;
    public int buD;
    public boolean buE;
    public boolean buF;
    public boolean buG;
    public boolean buH;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0231a {
        private int buC;
        private int buI;
        private boolean buE = true;
        private boolean buJ = true;
        private boolean buK = true;
        private boolean buH = false;

        public static C0231a UP() {
            return new C0231a();
        }

        public C0231a fA(int i) {
            this.buC = i;
            return this;
        }

        public C0231a fB(int i) {
            this.buI = i;
            return this;
        }

        public C0231a cX(boolean z) {
            this.buE = z;
            return this;
        }

        public C0231a cY(boolean z) {
            this.buJ = z;
            return this;
        }

        public C0231a cZ(boolean z) {
            this.buK = z;
            return this;
        }

        public C0231a da(boolean z) {
            this.buH = z;
            return this;
        }

        public a UQ() {
            a aVar = new a();
            aVar.buD = this.buI;
            aVar.buE = this.buE;
            aVar.buG = this.buK;
            aVar.buF = this.buJ;
            aVar.buC = this.buC;
            aVar.buH = this.buH;
            return aVar;
        }
    }
}
