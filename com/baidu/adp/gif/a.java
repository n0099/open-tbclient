package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a V(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0012a implements a {
        private static a vL;
        private int vM;
        private final d vN = new d();

        public C0012a() {
            this.vM = 0;
            if (NSGif.vP) {
                this.vM = 0;
            } else {
                this.vM = 1;
            }
        }

        public static synchronized a ga() {
            a aVar;
            synchronized (C0012a.class) {
                if (vL == null) {
                    vL = new C0012a();
                }
                aVar = vL;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a V(String str) {
            if (this.vM != 0) {
                return null;
            }
            try {
                return this.vN.V(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.vM != 0) {
                return null;
            }
            try {
                return this.vN.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
