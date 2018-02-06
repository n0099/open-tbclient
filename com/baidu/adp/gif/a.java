package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a M(String str);

    com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a implements a {
        private static a afg;
        private int afh;
        private final d afi = new d();

        public C0015a() {
            this.afh = 0;
            if (NSGif.afk) {
                this.afh = 0;
            } else {
                this.afh = 1;
            }
        }

        public static synchronized a lh() {
            a aVar;
            synchronized (C0015a.class) {
                if (afg == null) {
                    afg = new C0015a();
                }
                aVar = afg;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a M(String str) {
            if (this.afh != 0) {
                return null;
            }
            try {
                return this.afi.M(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
            if (this.afh != 0) {
                return null;
            }
            try {
                return this.afi.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
