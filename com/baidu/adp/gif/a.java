package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a W(String str);

    com.baidu.adp.widget.ImageView.a d(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a implements a {
        private static a ow;
        private final d oA = new d();
        private int oz;

        public C0014a() {
            this.oz = 0;
            if (NSGif.oC) {
                this.oz = 0;
            } else {
                this.oz = 1;
            }
        }

        public static synchronized a fg() {
            a aVar;
            synchronized (C0014a.class) {
                if (ow == null) {
                    ow = new C0014a();
                }
                aVar = ow;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a W(String str) {
            if (this.oz != 0) {
                return null;
            }
            try {
                return this.oA.W(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a d(byte[] bArr, int i, int i2) {
            if (this.oz != 0) {
                return null;
            }
            try {
                return this.oA.d(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
