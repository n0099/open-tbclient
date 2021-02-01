package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bs(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a implements a {
        private static a JO;
        private int JP;
        private final d JQ = new d();

        public C0013a() {
            this.JP = 0;
            if (NSGif.JS) {
                this.JP = 0;
            } else {
                this.JP = 1;
            }
        }

        public static synchronized a ld() {
            a aVar;
            synchronized (C0013a.class) {
                if (JO == null) {
                    JO = new C0013a();
                }
                aVar = JO;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bs(String str) {
            if (this.JP != 0) {
                return null;
            }
            try {
                return this.JQ.bs(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.JP != 0) {
                return null;
            }
            try {
                return this.JQ.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
