package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.a bv(String str) {
        NSGif bw = NSGif.bw(str);
        if (bw == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(bw);
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
