package com.baidu.adp.gif;
/* loaded from: classes.dex */
public interface a {
    com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2);

    /* renamed from: com.baidu.adp.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a implements a {
        private static a qY;
        private int qZ;
        private final f ra = new f();

        public C0003a() {
            this.qZ = 0;
            if (NSGif.rb) {
                this.qZ = 0;
            } else {
                this.qZ = 1;
            }
        }

        public static synchronized a fm() {
            a aVar;
            synchronized (C0003a.class) {
                if (qY == null) {
                    qY = new C0003a();
                }
                aVar = qY;
            }
            return aVar;
        }

        @Override // com.baidu.adp.gif.a
        public com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2) {
            if (this.qZ != 0) {
                return null;
            }
            try {
                return this.ra.d(bArr, i, i2);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
