package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a M(String str);

    com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a implements a {
        private static a afa;
        private int afb;
        private final d afc = new d();

        public C0015a() {
            this.afb = 0;
            if (NSGif.afe) {
                this.afb = 0;
            } else {
                this.afb = 1;
            }
        }

        public static synchronized a lh() {
            a aVar;
            synchronized (C0015a.class) {
                if (afa == null) {
                    afa = new C0015a();
                }
                aVar = afa;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a M(String str) {
            if (this.afb != 0) {
                return null;
            }
            try {
                return this.afc.M(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
            if (this.afb != 0) {
                return null;
            }
            try {
                return this.afc.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
