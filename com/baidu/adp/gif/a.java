package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bw(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019a implements a {
        private static a Lh;
        private int Li;
        private final d Lj = new d();

        public C0019a() {
            this.Li = 0;
            if (NSGif.Ll) {
                this.Li = 0;
            } else {
                this.Li = 1;
            }
        }

        public static synchronized a ld() {
            a aVar;
            synchronized (C0019a.class) {
                if (Lh == null) {
                    Lh = new C0019a();
                }
                aVar = Lh;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bw(String str) {
            if (this.Li != 0) {
                return null;
            }
            try {
                return this.Lj.bw(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.Li != 0) {
                return null;
            }
            try {
                return this.Lj.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
