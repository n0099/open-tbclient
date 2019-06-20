package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.ImageView.a W(String str);

    com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a implements a {
        private static a ws;
        private int wt;
        private final d wu = new d();

        public C0013a() {
            this.wt = 0;
            if (NSGif.ww) {
                this.wt = 0;
            } else {
                this.wt = 1;
            }
        }

        public static synchronized a gp() {
            a aVar;
            synchronized (C0013a.class) {
                if (ws == null) {
                    ws = new C0013a();
                }
                aVar = ws;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a W(String str) {
            if (this.wt != 0) {
                return null;
            }
            try {
                return this.wu.W(str);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
            if (this.wt != 0) {
                return null;
            }
            try {
                return this.wu.g(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
