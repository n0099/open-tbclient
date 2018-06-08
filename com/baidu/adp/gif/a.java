package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a V(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0012a implements a {
        private static a vN;
        private int vO;
        private final d vP = new d();

        public C0012a() {
            this.vO = 0;
            if (NSGif.vR) {
                this.vO = 0;
            } else {
                this.vO = 1;
            }
        }

        public static synchronized a ga() {
            a aVar;
            synchronized (C0012a.class) {
                if (vN == null) {
                    vN = new C0012a();
                }
                aVar = vN;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a V(String str) {
            if (this.vO != 0) {
                return null;
            }
            try {
                return this.vP.V(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.vO != 0) {
                return null;
            }
            try {
                return this.vP.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
