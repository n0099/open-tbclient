package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a implements a {
        private static a jJ;
        private int jK;
        private final f jL = new f();

        public C0003a() {
            this.jK = 0;
            if (NSGif.jM) {
                this.jK = 0;
            } else {
                this.jK = 1;
            }
        }

        public static synchronized a cu() {
            a aVar;
            synchronized (C0003a.class) {
                if (jJ == null) {
                    jJ = new C0003a();
                }
                aVar = jJ;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2) {
            if (this.jK != 0) {
                return null;
            }
            try {
                return this.jL.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
