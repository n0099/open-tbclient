package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a implements a {
        private static a qS;
        private int qT;
        private final f qU = new f();

        public C0003a() {
            this.qT = 0;
            if (NSGif.qV) {
                this.qT = 0;
            } else {
                this.qT = 1;
            }
        }

        public static synchronized a fe() {
            a aVar;
            synchronized (C0003a.class) {
                if (qS == null) {
                    qS = new C0003a();
                }
                aVar = qS;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2) {
            if (this.qT != 0) {
                return null;
            }
            try {
                return this.qU.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
