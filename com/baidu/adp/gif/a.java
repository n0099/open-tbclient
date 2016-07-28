package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a implements a {
        private static a hx;
        private int hy;
        private final f hz = new f();

        public C0004a() {
            this.hy = 0;
            if (NSGif.hA) {
                this.hy = 0;
            } else {
                this.hy = 1;
            }
        }

        public static synchronized a bB() {
            a aVar;
            synchronized (C0004a.class) {
                if (hx == null) {
                    hx = new C0004a();
                }
                aVar = hx;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a e(byte[] bArr, int i, int i2) {
            if (this.hy != 0) {
                return null;
            }
            try {
                return this.hz.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
