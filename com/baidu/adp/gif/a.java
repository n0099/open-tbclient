package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a L(String str);

    com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a implements a {
        private static a sS;
        private int sT;
        private final d sU = new d();

        public C0002a() {
            this.sT = 0;
            if (NSGif.sV) {
                this.sT = 0;
            } else {
                this.sT = 1;
            }
        }

        public static synchronized a dN() {
            a aVar;
            synchronized (C0002a.class) {
                if (sS == null) {
                    sS = new C0002a();
                }
                aVar = sS;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a L(String str) {
            if (this.sT != 0) {
                return null;
            }
            try {
                return this.sU.L(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
            if (this.sT != 0) {
                return null;
            }
            try {
                return this.sU.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
