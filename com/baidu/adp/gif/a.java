package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a an(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a implements a {
        private static a yM;
        private int yN;
        private final d yO = new d();

        public C0015a() {
            this.yN = 0;
            if (NSGif.yQ) {
                this.yN = 0;
            } else {
                this.yN = 1;
            }
        }

        public static synchronized a hx() {
            a aVar;
            synchronized (C0015a.class) {
                if (yM == null) {
                    yM = new C0015a();
                }
                aVar = yM;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a an(String str) {
            if (this.yN != 0) {
                return null;
            }
            try {
                return this.yO.an(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.yN != 0) {
                return null;
            }
            try {
                return this.yO.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
