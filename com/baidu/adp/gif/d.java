package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.a bm(String str) {
        NSGif bn = NSGif.bn(str);
        if (bn == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(bn);
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.a f(byte[] bArr, int i, int i2) {
        NSGif g = NSGif.g(bArr, i, i2);
        if (g == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(g);
    }
}
