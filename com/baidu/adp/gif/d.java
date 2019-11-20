package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.a R(String str) {
        NSGif S = NSGif.S(str);
        if (S == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(S);
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.a d(byte[] bArr, int i, int i2) {
        NSGif e = NSGif.e(bArr, i, i2);
        if (e == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(e);
    }
}
