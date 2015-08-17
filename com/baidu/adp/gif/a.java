package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a K(String str);

    com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a implements a {
        private static a qR;
        private int qS;
        private final f qT = new f();

        public C0002a() {
            this.qS = 0;
            if (NSGif.qU) {
                this.qS = 0;
            } else {
                this.qS = 1;
            }
        }

        public static synchronized a fh() {
            a aVar;
            synchronized (C0002a.class) {
                if (qR == null) {
                    qR = new C0002a();
                }
                aVar = qR;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a K(String str) {
            if (this.qS != 0) {
                return null;
            }
            try {
                return this.qT.K(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2) {
            if (this.qS != 0) {
                return null;
            }
            try {
                return this.qT.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
