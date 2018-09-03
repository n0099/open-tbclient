package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a W(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0012a implements a {
        private static a vE;
        private int vF;
        private final d vG = new d();

        public C0012a() {
            this.vF = 0;
            if (NSGif.vI) {
                this.vF = 0;
            } else {
                this.vF = 1;
            }
        }

        public static synchronized a fZ() {
            a aVar;
            synchronized (C0012a.class) {
                if (vE == null) {
                    vE = new C0012a();
                }
                aVar = vE;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a W(String str) {
            if (this.vF != 0) {
                return null;
            }
            try {
                return this.vG.W(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.vF != 0) {
                return null;
            }
            try {
                return this.vG.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
