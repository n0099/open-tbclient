package com.baidu.adp.gif;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.a.a g(byte[] bArr, int i, int i2) {
        NSGif h = NSGif.h(bArr, i, i2);
        if (h == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(h);
    }
}
