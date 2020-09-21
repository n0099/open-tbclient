package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bv(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0017a implements a {
        private static a Jj;
        private int Jk;
        private final d Jl = new d();

        public C0017a() {
            this.Jk = 0;
            if (NSGif.Jn) {
                this.Jk = 0;
            } else {
                this.Jk = 1;
            }
        }

        public static synchronized a lH() {
            a aVar;
            synchronized (C0017a.class) {
                if (Jj == null) {
                    Jj = new C0017a();
                }
                aVar = Jj;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bv(String str) {
            if (this.Jk != 0) {
                return null;
            }
            try {
                return this.Jl.bv(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.Jk != 0) {
                return null;
            }
            try {
                return this.Jl.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
