package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.aladin.a.a Ne;

    public e(com.baidu.tbadk.aladin.a.a aVar) {
        this.Ne = aVar;
    }

    public com.baidu.tbadk.aladin.a.a oM() {
        String url;
        String substring;
        int indexOf;
        if (this.Ne == null || (url = this.Ne.getUrl()) == null || !url.startsWith("/") || (indexOf = (substring = url.substring(1)).indexOf("?")) < 0 || indexOf + 1 >= substring.length() || !"sendintent".equalsIgnoreCase(substring.substring(0, indexOf))) {
            return null;
        }
        this.Ne.setUrl(substring.substring(indexOf + 1));
        return this.Ne;
    }
}
