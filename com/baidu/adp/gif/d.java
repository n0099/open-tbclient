package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.a an(String str) {
        NSGif ao = NSGif.ao(str);
        if (ao == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(ao);
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
