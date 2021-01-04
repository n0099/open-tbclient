package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bs(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a implements a {
        private static a JR;
        private int JS;
        private final d JT = new d();

        public C0013a() {
            this.JS = 0;
            if (NSGif.JV) {
                this.JS = 0;
            } else {
                this.JS = 1;
            }
        }

        public static synchronized a le() {
            a aVar;
            synchronized (C0013a.class) {
                if (JR == null) {
                    JR = new C0013a();
                }
                aVar = JR;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bs(String str) {
            if (this.JS != 0) {
                return null;
            }
            try {
                return this.JT.bs(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.JS != 0) {
                return null;
            }
            try {
                return this.JT.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
