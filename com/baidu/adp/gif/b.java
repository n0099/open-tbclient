package com.baidu.adp.gif;
/* loaded from: classes.dex */
public class b implements a {
    private static a qP;
    private int qQ;
    private final g qR = new g();

    public b() {
        this.qQ = 0;
        if (NSGif.qS) {
            this.qQ = 0;
        } else {
            this.qQ = 1;
        }
    }

    public static synchronized a ff() {
        a aVar;
        synchronized (b.class) {
            if (qP == null) {
                qP = new b();
            }
            aVar = qP;
        }
        return aVar;
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a J(String str) {
        if (this.qQ != 0) {
            return null;
        }
        try {
            return this.qR.J(str);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2) {
        if (this.qQ != 0) {
            return null;
        }
        try {
            return this.qR.d(bArr, i, i2);
        } catch (Exception e) {
            return null;
        }
    }
}
