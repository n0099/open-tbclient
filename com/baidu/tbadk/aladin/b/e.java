package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.aladin.a.a Se;

    public e(com.baidu.tbadk.aladin.a.a aVar) {
        this.Se = aVar;
    }

    public com.baidu.tbadk.aladin.a.a qn() {
        String url;
        String substring;
        int indexOf;
        if (this.Se == null || (url = this.Se.getUrl()) == null || !url.startsWith("/") || (indexOf = (substring = url.substring(1)).indexOf("?")) < 0 || indexOf + 1 >= substring.length() || !"sendintent".equalsIgnoreCase(substring.substring(0, indexOf))) {
            return null;
        }
        this.Se.setUrl(substring.substring(indexOf + 1));
        return this.Se;
    }
}
