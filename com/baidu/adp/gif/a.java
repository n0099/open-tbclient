package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a E(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a implements a {
        private static a qG;
        private int qH;
        private final d qI = new d();

        public C0002a() {
            this.qH = 0;
            if (NSGif.qJ) {
                this.qH = 0;
            } else {
                this.qH = 1;
            }
        }

        public static synchronized a dD() {
            a aVar;
            synchronized (C0002a.class) {
                if (qG == null) {
                    qG = new C0002a();
                }
                aVar = qG;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a E(String str) {
            if (this.qH != 0) {
                return null;
            }
            try {
                return this.qI.E(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.qH != 0) {
                return null;
            }
            try {
                return this.qI.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
