package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a implements a {
        private static a gU;
        private int gV;
        private final f gW = new f();

        public C0004a() {
            this.gV = 0;
            if (NSGif.gX) {
                this.gV = 0;
            } else {
                this.gV = 1;
            }
        }

        public static synchronized a bC() {
            a aVar;
            synchronized (C0004a.class) {
                if (gU == null) {
                    gU = new C0004a();
                }
                aVar = gU;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2) {
            if (this.gV != 0) {
                return null;
            }
            try {
                return this.gW.d(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
