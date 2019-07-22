package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a W(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a implements a {
        private static a wv;
        private int ww;
        private final d wx = new d();

        public C0013a() {
            this.ww = 0;
            if (NSGif.wz) {
                this.ww = 0;
            } else {
                this.ww = 1;
            }
        }

        public static synchronized a gy() {
            a aVar;
            synchronized (C0013a.class) {
                if (wv == null) {
                    wv = new C0013a();
                }
                aVar = wv;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a W(String str) {
            if (this.ww != 0) {
                return null;
            }
            try {
                return this.wx.W(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.ww != 0) {
                return null;
            }
            try {
                return this.wx.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
