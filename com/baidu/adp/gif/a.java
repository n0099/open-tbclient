package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bt(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016a implements a {
        private static a Jb;
        private int Jc;
        private final d Jd = new d();

        public C0016a() {
            this.Jc = 0;
            if (NSGif.Jf) {
                this.Jc = 0;
            } else {
                this.Jc = 1;
            }
        }

        public static synchronized a lD() {
            a aVar;
            synchronized (C0016a.class) {
                if (Jb == null) {
                    Jb = new C0016a();
                }
                aVar = Jb;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bt(String str) {
            if (this.Jc != 0) {
                return null;
            }
            try {
                return this.Jd.bt(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.Jc != 0) {
                return null;
            }
            try {
                return this.Jd.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
