package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.aladin.a.a Sc;

    public e(com.baidu.tbadk.aladin.a.a aVar) {
        this.Sc = aVar;
    }

    public com.baidu.tbadk.aladin.a.a qk() {
        String url;
        String substring;
        int indexOf;
        if (this.Sc == null || (url = this.Sc.getUrl()) == null || !url.startsWith("/") || (indexOf = (substring = url.substring(1)).indexOf("?")) < 0 || indexOf + 1 >= substring.length() || !"sendintent".equalsIgnoreCase(substring.substring(0, indexOf))) {
            return null;
        }
        this.Sc.setUrl(substring.substring(indexOf + 1));
        return this.Sc;
    }
}
