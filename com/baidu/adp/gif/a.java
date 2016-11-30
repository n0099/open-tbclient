package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a implements a {
        private static a jQ;
        private int jR;
        private final f jS = new f();

        public C0004a() {
            this.jR = 0;
            if (NSGif.jT) {
                this.jR = 0;
            } else {
                this.jR = 1;
            }
        }

        public static synchronized a cw() {
            a aVar;
            synchronized (C0004a.class) {
                if (jQ == null) {
                    jQ = new C0004a();
                }
                aVar = jQ;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2) {
            if (this.jR != 0) {
                return null;
            }
            try {
                return this.jS.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
