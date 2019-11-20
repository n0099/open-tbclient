package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a R(String str);

    com.baidu.adp.widget.ImageView.a d(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a implements a {
        private static a lZ;
        private int ma;
        private final d mb = new d();

        public C0013a() {
            this.ma = 0;
            if (NSGif.md) {
                this.ma = 0;
            } else {
                this.ma = 1;
            }
        }

        public static synchronized a eM() {
            a aVar;
            synchronized (C0013a.class) {
                if (lZ == null) {
                    lZ = new C0013a();
                }
                aVar = lZ;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a R(String str) {
            if (this.ma != 0) {
                return null;
            }
            try {
                return this.mb.R(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a d(byte[] bArr, int i, int i2) {
            if (this.ma != 0) {
                return null;
            }
            try {
                return this.mb.d(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
