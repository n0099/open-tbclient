package com.baidu.adp.gif;
/* loaded from: classes.dex */
public class b implements a {
    private static a qU;
    private int qV;
    private final g qW = new g();

    public b() {
        this.qV = 0;
        if (NSGif.qX) {
            this.qV = 0;
        } else {
            this.qV = 1;
        }
    }

    public static synchronized a fk() {
        a aVar;
        synchronized (b.class) {
            if (qU == null) {
                qU = new b();
            }
            aVar = qU;
        }
        return aVar;
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a L(String str) {
        if (this.qV != 0) {
            return null;
        }
        try {
            return this.qW.L(str);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2) {
        if (this.qV != 0) {
            return null;
        }
        try {
            return this.qW.d(bArr, i, i2);
        } catch (Exception e) {
            return null;
        }
    }
}
