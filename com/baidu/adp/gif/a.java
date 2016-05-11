package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a implements a {
        private static a gV;
        private int gW;
        private final f gX = new f();

        public C0004a() {
            this.gW = 0;
            if (NSGif.gY) {
                this.gW = 0;
            } else {
                this.gW = 1;
            }
        }

        public static synchronized a bB() {
            a aVar;
            synchronized (C0004a.class) {
                if (gV == null) {
                    gV = new C0004a();
                }
                aVar = gV;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2) {
            if (this.gW != 0) {
                return null;
            }
            try {
                return this.gX.d(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
