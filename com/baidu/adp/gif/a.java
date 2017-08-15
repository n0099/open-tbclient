package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a K(String str);

    com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a implements a {
        private static a sR;
        private int sS;
        private final d sT = new d();

        public C0002a() {
            this.sS = 0;
            if (NSGif.sU) {
                this.sS = 0;
            } else {
                this.sS = 1;
            }
        }

        public static synchronized a dN() {
            a aVar;
            synchronized (C0002a.class) {
                if (sR == null) {
                    sR = new C0002a();
                }
                aVar = sR;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a K(String str) {
            if (this.sS != 0) {
                return null;
            }
            try {
                return this.sT.K(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
            if (this.sS != 0) {
                return null;
            }
            try {
                return this.sT.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
