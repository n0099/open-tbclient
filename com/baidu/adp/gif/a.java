package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a an(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a implements a {
        private static a yJ;
        private int yK;
        private final d yL = new d();

        public C0015a() {
            this.yK = 0;
            if (NSGif.yN) {
                this.yK = 0;
            } else {
                this.yK = 1;
            }
        }

        public static synchronized a hy() {
            a aVar;
            synchronized (C0015a.class) {
                if (yJ == null) {
                    yJ = new C0015a();
                }
                aVar = yJ;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a an(String str) {
            if (this.yK != 0) {
                return null;
            }
            try {
                return this.yL.an(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.yK != 0) {
                return null;
            }
            try {
                return this.yL.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
