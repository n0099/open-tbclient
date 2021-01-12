package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bs(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a implements a {
        private static a JP;
        private int JQ;
        private final d JR = new d();

        public C0013a() {
            this.JQ = 0;
            if (NSGif.JT) {
                this.JQ = 0;
            } else {
                this.JQ = 1;
            }
        }

        public static synchronized a le() {
            a aVar;
            synchronized (C0013a.class) {
                if (JP == null) {
                    JP = new C0013a();
                }
                aVar = JP;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bs(String str) {
            if (this.JQ != 0) {
                return null;
            }
            try {
                return this.JR.bs(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.JQ != 0) {
                return null;
            }
            try {
                return this.JR.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
