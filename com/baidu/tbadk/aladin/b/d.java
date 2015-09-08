package com.baidu.tbadk.aladin.b;

import java.util.Locale;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.aladin.a.a Sc;

    public d(com.baidu.tbadk.aladin.a.a aVar) {
        this.Sc = aVar;
    }

    public com.baidu.tbadk.aladin.a.a qk() {
        if (this.Sc == null || this.Sc.getMethod() == null || this.Sc.qe() == null || this.Sc.getUrl() == null || !this.Sc.getMethod().equalsIgnoreCase("GET") || !this.Sc.qe().toLowerCase(Locale.getDefault()).startsWith("http")) {
            return null;
        }
        return this.Sc;
    }
}
