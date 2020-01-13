package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a W(String str);

    com.baidu.adp.widget.ImageView.a d(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a implements a {
        private static a ot;
        private int ou;
        private final d ov = new d();

        public C0014a() {
            this.ou = 0;
            if (NSGif.oz) {
                this.ou = 0;
            } else {
                this.ou = 1;
            }
        }

        public static synchronized a fg() {
            a aVar;
            synchronized (C0014a.class) {
                if (ot == null) {
                    ot = new C0014a();
                }
                aVar = ot;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a W(String str) {
            if (this.ou != 0) {
                return null;
            }
            try {
                return this.ov.W(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a d(byte[] bArr, int i, int i2) {
            if (this.ou != 0) {
                return null;
            }
            try {
                return this.ov.d(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
