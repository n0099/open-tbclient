package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a an(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0012a implements a {
        private static a xX;
        private int xY;
        private final d xZ = new d();

        public C0012a() {
            this.xY = 0;
            if (NSGif.yb) {
                this.xY = 0;
            } else {
                this.xY = 1;
            }
        }

        public static synchronized a hh() {
            a aVar;
            synchronized (C0012a.class) {
                if (xX == null) {
                    xX = new C0012a();
                }
                aVar = xX;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a an(String str) {
            if (this.xY != 0) {
                return null;
            }
            try {
                return this.xZ.an(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.xY != 0) {
                return null;
            }
            try {
                return this.xZ.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
