package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.aladin.a.a xp;

    public e(com.baidu.tbadk.aladin.a.a aVar) {
        this.xp = aVar;
    }

    public com.baidu.tbadk.aladin.a.a iO() {
        String url;
        String substring;
        int indexOf;
        if (this.xp == null || (url = this.xp.getUrl()) == null || !url.startsWith("/") || (indexOf = (substring = url.substring(1)).indexOf("?")) < 0 || indexOf + 1 >= substring.length() || !"sendintent".equalsIgnoreCase(substring.substring(0, indexOf))) {
            return null;
        }
        this.xp.setUrl(substring.substring(indexOf + 1));
        return this.xp;
    }
}
