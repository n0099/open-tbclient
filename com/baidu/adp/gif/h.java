package com.baidu.adp.gif;
/* loaded from: classes.dex */
class h implements a {
    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.d a(String str) {
        NSGif a = NSGif.a(str);
        if (a == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.d(a);
    }
}
