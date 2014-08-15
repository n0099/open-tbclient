package com.baidu.tbadk.aladin.b;
/* loaded from: classes.dex */
public class e {
    private com.baidu.tbadk.aladin.a.a a;

    public e(com.baidu.tbadk.aladin.a.a aVar) {
        this.a = aVar;
    }

    public com.baidu.tbadk.aladin.a.a a() {
        String b;
        String substring;
        int indexOf;
        if (this.a == null || (b = this.a.b()) == null || !b.startsWith("/") || (indexOf = (substring = b.substring(1)).indexOf("?")) < 0 || indexOf + 1 >= substring.length() || !"sendintent".equalsIgnoreCase(substring.substring(0, indexOf))) {
            return null;
        }
        this.a.a(substring.substring(indexOf + 1));
        return this.a;
    }
}
