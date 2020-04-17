package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bm(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016a implements a {
        private static a HD;
        private int HE;
        private final d HF = new d();

        public C0016a() {
            this.HE = 0;
            if (NSGif.HH) {
                this.HE = 0;
            } else {
                this.HE = 1;
            }
        }

        public static synchronized a jM() {
            a aVar;
            synchronized (C0016a.class) {
                if (HD == null) {
                    HD = new C0016a();
                }
                aVar = HD;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bm(String str) {
            if (this.HE != 0) {
                return null;
            }
            try {
                return this.HF.bm(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.HE != 0) {
                return null;
            }
            try {
                return this.HF.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
