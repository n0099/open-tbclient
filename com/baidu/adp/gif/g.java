package com.baidu.adp.gif;
/* loaded from: classes.dex */
class g implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a B(String str) {
        NSGif C = NSGif.C(str);
        if (C == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(C);
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a d(byte[] bArr, int i, int i2) {
        NSGif e = NSGif.e(bArr, i, i2);
        if (e == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(e);
    }
}
