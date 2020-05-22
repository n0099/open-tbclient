package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bn(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018a implements a {
        private static a HR;
        private int HS;
        private final d HU = new d();

        public C0018a() {
            this.HS = 0;
            if (NSGif.HW) {
                this.HS = 0;
            } else {
                this.HS = 1;
            }
        }

        public static synchronized a jO() {
            a aVar;
            synchronized (C0018a.class) {
                if (HR == null) {
                    HR = new C0018a();
                }
                aVar = HR;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bn(String str) {
            if (this.HS != 0) {
                return null;
            }
            try {
                return this.HU.bn(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.HS != 0) {
                return null;
            }
            try {
                return this.HU.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
