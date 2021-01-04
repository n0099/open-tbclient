package com.baidu.swan.apps.view.a;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean dTA;
    public boolean dTB;
    public boolean dTC;
    public boolean dTD;
    public boolean dTE;
    public int dTy;
    public int dTz;

    private a() {
        this.dTE = true;
    }

    /* renamed from: com.baidu.swan.apps.view.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0497a {
        private int dTF;
        private int dTy;
        private boolean dTA = true;
        private boolean dTG = true;
        private boolean dTH = true;
        private boolean dTD = false;
        private boolean dTE = true;

        public static C0497a aSp() {
            return new C0497a();
        }

        public C0497a lT(int i) {
            this.dTy = i;
            return this;
        }

        public C0497a lU(int i) {
            this.dTF = i;
            return this;
        }

        public C0497a hD(boolean z) {
            this.dTA = z;
            return this;
        }

        public C0497a hE(boolean z) {
            this.dTG = z;
            return this;
        }

        public C0497a hF(boolean z) {
            this.dTH = z;
            return this;
        }

        public C0497a hG(boolean z) {
            this.dTD = z;
            return this;
        }

        public C0497a hH(boolean z) {
            this.dTE = z;
            return this;
        }

        public a aSq() {
            a aVar = new a();
            aVar.dTz = this.dTF;
            aVar.dTA = this.dTA;
            aVar.dTC = this.dTH;
            aVar.dTB = this.dTG;
            aVar.dTy = this.dTy;
            aVar.dTD = this.dTD;
            aVar.dTE = this.dTE;
            return aVar;
        }
    }
}
