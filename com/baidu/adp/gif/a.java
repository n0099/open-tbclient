package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a X(String str);

    com.baidu.adp.widget.ImageView.a d(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a implements a {
        private static a oz;
        private int oA;
        private final d oB = new d();

        public C0014a() {
            this.oA = 0;
            if (NSGif.oD) {
                this.oA = 0;
            } else {
                this.oA = 1;
            }
        }

        public static synchronized a fh() {
            a aVar;
            synchronized (C0014a.class) {
                if (oz == null) {
                    oz = new C0014a();
                }
                aVar = oz;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a X(String str) {
            if (this.oA != 0) {
                return null;
            }
            try {
                return this.oB.X(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a d(byte[] bArr, int i, int i2) {
            if (this.oA != 0) {
                return null;
            }
            try {
                return this.oB.d(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
