package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a bo(String str);

    com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019a implements a {
        private static a Is;
        private int It;
        private final d Iu = new d();

        public C0019a() {
            this.It = 0;
            if (NSGif.Iw) {
                this.It = 0;
            } else {
                this.It = 1;
            }
        }

        public static synchronized a ke() {
            a aVar;
            synchronized (C0019a.class) {
                if (Is == null) {
                    Is = new C0019a();
                }
                aVar = Is;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a bo(String str) {
            if (this.It != 0) {
                return null;
            }
            try {
                return this.Iu.bo(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
            if (this.It != 0) {
                return null;
            }
            try {
                return this.Iu.f(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
