package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a W(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a implements a {
        private static a wt;
        private int wu;
        private final d wv = new d();

        public C0013a() {
            this.wu = 0;
            if (NSGif.wx) {
                this.wu = 0;
            } else {
                this.wu = 1;
            }
        }

        public static synchronized a gp() {
            a aVar;
            synchronized (C0013a.class) {
                if (wt == null) {
                    wt = new C0013a();
                }
                aVar = wt;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a W(String str) {
            if (this.wu != 0) {
                return null;
            }
            try {
                return this.wv.W(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.wu != 0) {
                return null;
            }
            try {
                return this.wv.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
