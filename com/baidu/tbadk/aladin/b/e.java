package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.aladin.a.a Ng;

    public e(com.baidu.tbadk.aladin.a.a aVar) {
        this.Ng = aVar;
    }

    public com.baidu.tbadk.aladin.a.a oM() {
        String url;
        String substring;
        int indexOf;
        if (this.Ng == null || (url = this.Ng.getUrl()) == null || !url.startsWith("/") || (indexOf = (substring = url.substring(1)).indexOf("?")) < 0 || indexOf + 1 >= substring.length() || !"sendintent".equalsIgnoreCase(substring.substring(0, indexOf))) {
            return null;
        }
        this.Ng.setUrl(substring.substring(indexOf + 1));
        return this.Ng;
    }
}
