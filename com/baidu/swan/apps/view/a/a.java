package com.baidu.swan.apps.view.a;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public int btK;
    public int btL;
    public boolean btM;
    public boolean btN;
    public boolean btO;
    public boolean btP;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0231a {
        private int btK;
        private int btQ;
        private boolean btM = true;
        private boolean btR = true;
        private boolean btS = true;
        private boolean btP = false;

        public static C0231a UN() {
            return new C0231a();
        }

        public C0231a fz(int i) {
            this.btK = i;
            return this;
        }

        public C0231a fA(int i) {
            this.btQ = i;
            return this;
        }

        public C0231a cX(boolean z) {
            this.btM = z;
            return this;
        }

        public C0231a cY(boolean z) {
            this.btR = z;
            return this;
        }

        public C0231a cZ(boolean z) {
            this.btS = z;
            return this;
        }

        public C0231a da(boolean z) {
            this.btP = z;
            return this;
        }

        public a UO() {
            a aVar = new a();
            aVar.btL = this.btQ;
            aVar.btM = this.btM;
            aVar.btO = this.btS;
            aVar.btN = this.btR;
            aVar.btK = this.btK;
            aVar.btP = this.btP;
            return aVar;
        }
    }
}
