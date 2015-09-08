package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a K(String str);

    com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a implements a {
        private static a qP;
        private int qQ;
        private final f qR = new f();

        public C0002a() {
            this.qQ = 0;
            if (NSGif.qS) {
                this.qQ = 0;
            } else {
                this.qQ = 1;
            }
        }

        public static synchronized a fe() {
            a aVar;
            synchronized (C0002a.class) {
                if (qP == null) {
                    qP = new C0002a();
                }
                aVar = qP;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a K(String str) {
            if (this.qQ != 0) {
                return null;
            }
            try {
                return this.qR.K(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2) {
            if (this.qQ != 0) {
                return null;
            }
            try {
                return this.qR.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
