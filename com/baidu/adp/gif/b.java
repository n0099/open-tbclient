package com.baidu.adp.gif;
/* loaded from: classes.dex */
public class b implements a {
    private static a fu;
    private int fv;
    private final g fw = new g();

    public b() {
        this.fv = 0;
        if (NSGif.fx) {
            this.fv = 0;
        } else {
            this.fv = 1;
        }
    }

    public static synchronized a bJ() {
        a aVar;
        synchronized (b.class) {
            if (fu == null) {
                fu = new b();
            }
            aVar = fu;
        }
        return aVar;
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a B(String str) {
        if (this.fv != 0) {
            return null;
        }
        try {
            return this.fw.B(str);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2) {
        if (this.fv != 0) {
            return null;
        }
        try {
            return this.fw.d(bArr, i, i2);
        } catch (Exception e) {
            return null;
        }
    }
}
