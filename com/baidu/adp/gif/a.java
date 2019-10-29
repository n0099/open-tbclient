package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a R(String str);

    com.baidu.adp.widget.ImageView.a e(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a implements a {
        private static a mD;
        private int mE;
        private final d mF = new d();

        public C0013a() {
            this.mE = 0;
            if (NSGif.mH) {
                this.mE = 0;
            } else {
                this.mE = 1;
            }
        }

        public static synchronized a eM() {
            a aVar;
            synchronized (C0013a.class) {
                if (mD == null) {
                    mD = new C0013a();
                }
                aVar = mD;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a R(String str) {
            if (this.mE != 0) {
                return null;
            }
            try {
                return this.mF.R(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a e(byte[] bArr, int i, int i2) {
            if (this.mE != 0) {
                return null;
            }
            try {
                return this.mF.e(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
