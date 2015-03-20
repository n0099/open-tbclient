package com.baidu.adp.gif;
/* loaded from: classes.dex */
class g implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a J(String str) {
        NSGif K = NSGif.K(str);
        if (K == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(K);
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
