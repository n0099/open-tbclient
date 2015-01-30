package com.baidu.adp.gif;
/* loaded from: classes.dex */
public class b implements a {
    private static a fw;
    private int fx;
    private final g fy = new g();

    public b() {
        this.fx = 0;
        if (NSGif.fz) {
            this.fx = 0;
        } else {
            this.fx = 1;
        }
    }

    public static synchronized a bH() {
        a aVar;
        synchronized (b.class) {
            if (fw == null) {
                fw = new b();
            }
            aVar = fw;
        }
        return aVar;
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a B(String str) {
        if (this.fx != 0) {
            return null;
        }
        try {
            return this.fy.B(str);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2) {
        if (this.fx != 0) {
            return null;
        }
        try {
            return this.fy.d(bArr, i, i2);
        } catch (Exception e) {
            return null;
        }
    }
}
