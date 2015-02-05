package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.aladin.a.a Ay;

    public e(com.baidu.tbadk.aladin.a.a aVar) {
        this.Ay = aVar;
    }

    public com.baidu.tbadk.aladin.a.a kT() {
        String url;
        String substring;
        int indexOf;
        if (this.Ay == null || (url = this.Ay.getUrl()) == null || !url.startsWith("/") || (indexOf = (substring = url.substring(1)).indexOf("?")) < 0 || indexOf + 1 >= substring.length() || !"sendintent".equalsIgnoreCase(substring.substring(0, indexOf))) {
            return null;
        }
        this.Ay.setUrl(substring.substring(indexOf + 1));
        return this.Ay;
    }
}
