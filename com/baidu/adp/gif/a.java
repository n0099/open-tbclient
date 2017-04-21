package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a implements a {
        private static a ri;
        private int rj;
        private final f rk = new f();

        public C0003a() {
            this.rj = 0;
            if (NSGif.rl) {
                this.rj = 0;
            } else {
                this.rj = 1;
            }
        }

        public static synchronized a dD() {
            a aVar;
            synchronized (C0003a.class) {
                if (ri == null) {
                    ri = new C0003a();
                }
                aVar = ri;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2) {
            if (this.rj != 0) {
                return null;
            }
            try {
                return this.rk.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
