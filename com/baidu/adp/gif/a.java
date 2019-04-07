package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a an(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a implements a {
        private static a yI;
        private int yJ;
        private final d yK = new d();

        public C0013a() {
            this.yJ = 0;
            if (NSGif.yM) {
                this.yJ = 0;
            } else {
                this.yJ = 1;
            }
        }

        public static synchronized a hv() {
            a aVar;
            synchronized (C0013a.class) {
                if (yI == null) {
                    yI = new C0013a();
                }
                aVar = yI;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a an(String str) {
            if (this.yJ != 0) {
                return null;
            }
            try {
                return this.yK.an(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.yJ != 0) {
                return null;
            }
            try {
                return this.yK.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
