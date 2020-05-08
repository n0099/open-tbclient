package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bm(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016a implements a {
        private static a HG;
        private int HH;
        private final d HI = new d();

        public C0016a() {
            this.HH = 0;
            if (NSGif.HK) {
                this.HH = 0;
            } else {
                this.HH = 1;
            }
        }

        public static synchronized a jM() {
            a aVar;
            synchronized (C0016a.class) {
                if (HG == null) {
                    HG = new C0016a();
                }
                aVar = HG;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bm(String str) {
            if (this.HH != 0) {
                return null;
            }
            try {
                return this.HI.bm(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.HH != 0) {
                return null;
            }
            try {
                return this.HI.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
