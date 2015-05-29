package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.aladin.a.a Nu;

    public e(com.baidu.tbadk.aladin.a.a aVar) {
        this.Nu = aVar;
    }

    public com.baidu.tbadk.aladin.a.a pm() {
        String url;
        String substring;
        int indexOf;
        if (this.Nu == null || (url = this.Nu.getUrl()) == null || !url.startsWith("/") || (indexOf = (substring = url.substring(1)).indexOf("?")) < 0 || indexOf + 1 >= substring.length() || !"sendintent".equalsIgnoreCase(substring.substring(0, indexOf))) {
            return null;
        }
        this.Nu.setUrl(substring.substring(indexOf + 1));
        return this.Nu;
    }
}
