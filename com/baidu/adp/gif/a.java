package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a implements a {
        private static a rF;
        private int rG;
        private final f rH = new f();

        public C0003a() {
            this.rG = 0;
            if (NSGif.rI) {
                this.rG = 0;
            } else {
                this.rG = 1;
            }
        }

        public static synchronized a dD() {
            a aVar;
            synchronized (C0003a.class) {
                if (rF == null) {
                    rF = new C0003a();
                }
                aVar = rF;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2) {
            if (this.rG != 0) {
                return null;
            }
            try {
                return this.rH.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
