package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a by(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018a implements a {
        private static a Kr;
        private int Ks;
        private final d Kt = new d();

        public C0018a() {
            this.Ks = 0;
            if (NSGif.Kv) {
                this.Ks = 0;
            } else {
                this.Ks = 1;
            }
        }

        public static synchronized a lI() {
            a aVar;
            synchronized (C0018a.class) {
                if (Kr == null) {
                    Kr = new C0018a();
                }
                aVar = Kr;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a by(String str) {
            if (this.Ks != 0) {
                return null;
            }
            try {
                return this.Kt.by(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.Ks != 0) {
                return null;
            }
            try {
                return this.Kt.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
