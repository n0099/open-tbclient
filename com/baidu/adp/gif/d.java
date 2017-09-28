package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.a E(String str) {
        NSGif F = NSGif.F(str);
        if (F == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(F);
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.a g(byte[] bArr, int i, int i2) {
        NSGif h = NSGif.h(bArr, i, i2);
        if (h == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(h);
    }
}
