package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.a bs(String str) {
        NSGif bt = NSGif.bt(str);
        if (bt == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(bt);
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
