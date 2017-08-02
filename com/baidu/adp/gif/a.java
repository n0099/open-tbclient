package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a E(String str);

    com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a implements a {
        private static a rj;
        private int rk;
        private final d rl = new d();

        public C0003a() {
            this.rk = 0;
            if (NSGif.rm) {
                this.rk = 0;
            } else {
                this.rk = 1;
            }
        }

        public static synchronized a dC() {
            a aVar;
            synchronized (C0003a.class) {
                if (rj == null) {
                    rj = new C0003a();
                }
                aVar = rj;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a E(String str) {
            if (this.rk != 0) {
                return null;
            }
            try {
                return this.rl.E(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
            if (this.rk != 0) {
                return null;
            }
            try {
                return this.rl.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
