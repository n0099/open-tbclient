package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.aladin.a.a AB;

    public e(com.baidu.tbadk.aladin.a.a aVar) {
        this.AB = aVar;
    }

    public com.baidu.tbadk.aladin.a.a la() {
        String url;
        String substring;
        int indexOf;
        if (this.AB == null || (url = this.AB.getUrl()) == null || !url.startsWith("/") || (indexOf = (substring = url.substring(1)).indexOf("?")) < 0 || indexOf + 1 >= substring.length() || !"sendintent".equalsIgnoreCase(substring.substring(0, indexOf))) {
            return null;
        }
        this.AB.setUrl(substring.substring(indexOf + 1));
        return this.AB;
    }
}
