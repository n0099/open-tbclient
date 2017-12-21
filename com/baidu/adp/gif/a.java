package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a E(String str);

    com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a implements a {
        private static a qI;
        private int qJ;
        private final d qK = new d();

        public C0002a() {
            this.qJ = 0;
            if (NSGif.qL) {
                this.qJ = 0;
            } else {
                this.qJ = 1;
            }
        }

        public static synchronized a dD() {
            a aVar;
            synchronized (C0002a.class) {
                if (qI == null) {
                    qI = new C0002a();
                }
                aVar = qI;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a E(String str) {
            if (this.qJ != 0) {
                return null;
            }
            try {
                return this.qK.E(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
            if (this.qJ != 0) {
                return null;
            }
            try {
                return this.qK.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
