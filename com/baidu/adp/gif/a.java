package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a J(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a implements a {
        private static a py;
        private final d pA = new d();
        private int pz;

        public C0004a() {
            this.pz = 0;
            if (NSGif.pC) {
                this.pz = 0;
            } else {
                this.pz = 1;
            }
        }

        public static synchronized a dl() {
            a aVar;
            synchronized (C0004a.class) {
                if (py == null) {
                    py = new C0004a();
                }
                aVar = py;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a J(String str) {
            if (this.pz != 0) {
                return null;
            }
            try {
                return this.pA.J(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.pz != 0) {
                return null;
            }
            try {
                return this.pA.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
