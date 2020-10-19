package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bv(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018a implements a {
        private static a Jz;
        private int JA;
        private final d JB = new d();

        public C0018a() {
            this.JA = 0;
            if (NSGif.JD) {
                this.JA = 0;
            } else {
                this.JA = 1;
            }
        }

        public static synchronized a lI() {
            a aVar;
            synchronized (C0018a.class) {
                if (Jz == null) {
                    Jz = new C0018a();
                }
                aVar = Jz;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bv(String str) {
            if (this.JA != 0) {
                return null;
            }
            try {
                return this.JB.bv(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.JA != 0) {
                return null;
            }
            try {
                return this.JB.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
