package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a W(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0012a implements a {
        private static a vD;
        private int vE;
        private final d vF = new d();

        public C0012a() {
            this.vE = 0;
            if (NSGif.vH) {
                this.vE = 0;
            } else {
                this.vE = 1;
            }
        }

        public static synchronized a fZ() {
            a aVar;
            synchronized (C0012a.class) {
                if (vD == null) {
                    vD = new C0012a();
                }
                aVar = vD;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a W(String str) {
            if (this.vE != 0) {
                return null;
            }
            try {
                return this.vF.W(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.vE != 0) {
                return null;
            }
            try {
                return this.vF.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
