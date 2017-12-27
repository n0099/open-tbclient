package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a M(String str);

    com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a implements a {
        private static a afi;
        private int afj;
        private final d afk = new d();

        public C0015a() {
            this.afj = 0;
            if (NSGif.afl) {
                this.afj = 0;
            } else {
                this.afj = 1;
            }
        }

        public static synchronized a lh() {
            a aVar;
            synchronized (C0015a.class) {
                if (afi == null) {
                    afi = new C0015a();
                }
                aVar = afi;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a M(String str) {
            if (this.afj != 0) {
                return null;
            }
            try {
                return this.afk.M(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
            if (this.afj != 0) {
                return null;
            }
            try {
                return this.afk.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
