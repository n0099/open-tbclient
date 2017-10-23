package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a E(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a implements a {
        private static a qH;
        private int qI;
        private final d qJ = new d();

        public C0002a() {
            this.qI = 0;
            if (NSGif.qK) {
                this.qI = 0;
            } else {
                this.qI = 1;
            }
        }

        public static synchronized a dD() {
            a aVar;
            synchronized (C0002a.class) {
                if (qH == null) {
                    qH = new C0002a();
                }
                aVar = qH;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a E(String str) {
            if (this.qI != 0) {
                return null;
            }
            try {
                return this.qJ.E(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.qI != 0) {
                return null;
            }
            try {
                return this.qJ.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
