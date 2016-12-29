package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a implements a {
        private static a jP;
        private int jQ;
        private final f jR = new f();

        public C0004a() {
            this.jQ = 0;
            if (NSGif.jS) {
                this.jQ = 0;
            } else {
                this.jQ = 1;
            }
        }

        public static synchronized a cw() {
            a aVar;
            synchronized (C0004a.class) {
                if (jP == null) {
                    jP = new C0004a();
                }
                aVar = jP;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2) {
            if (this.jQ != 0) {
                return null;
            }
            try {
                return this.jR.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
