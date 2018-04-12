package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a J(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a implements a {
        private static a pz;
        private int pA;
        private final d pB = new d();

        public C0004a() {
            this.pA = 0;
            if (NSGif.pD) {
                this.pA = 0;
            } else {
                this.pA = 1;
            }
        }

        public static synchronized a dl() {
            a aVar;
            synchronized (C0004a.class) {
                if (pz == null) {
                    pz = new C0004a();
                }
                aVar = pz;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a J(String str) {
            if (this.pA != 0) {
                return null;
            }
            try {
                return this.pB.J(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.pA != 0) {
                return null;
            }
            try {
                return this.pB.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
