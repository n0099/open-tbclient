package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a E(String str);

    com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a implements a {
        private static a qF;
        private int qG;
        private final d qH = new d();

        public C0002a() {
            this.qG = 0;
            if (NSGif.qI) {
                this.qG = 0;
            } else {
                this.qG = 1;
            }
        }

        public static synchronized a dD() {
            a aVar;
            synchronized (C0002a.class) {
                if (qF == null) {
                    qF = new C0002a();
                }
                aVar = qF;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a E(String str) {
            if (this.qG != 0) {
                return null;
            }
            try {
                return this.qH.E(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
            if (this.qG != 0) {
                return null;
            }
            try {
                return this.qH.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
