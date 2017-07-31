package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a K(String str);

    com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a implements a {
        private static a sP;
        private int sQ;
        private final d sR = new d();

        public C0003a() {
            this.sQ = 0;
            if (NSGif.sS) {
                this.sQ = 0;
            } else {
                this.sQ = 1;
            }
        }

        public static synchronized a dN() {
            a aVar;
            synchronized (C0003a.class) {
                if (sP == null) {
                    sP = new C0003a();
                }
                aVar = sP;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a K(String str) {
            if (this.sQ != 0) {
                return null;
            }
            try {
                return this.sR.K(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
            if (this.sQ != 0) {
                return null;
            }
            try {
                return this.sR.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
