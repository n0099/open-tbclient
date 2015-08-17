package com.baidu.tbadk.aladin.b;

import java.util.Locale;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.aladin.a.a Se;

    public d(com.baidu.tbadk.aladin.a.a aVar) {
        this.Se = aVar;
    }

    public com.baidu.tbadk.aladin.a.a qn() {
        if (this.Se == null || this.Se.getMethod() == null || this.Se.qh() == null || this.Se.getUrl() == null || !this.Se.getMethod().equalsIgnoreCase("GET") || !this.Se.qh().toLowerCase(Locale.getDefault()).startsWith("http")) {
            return null;
        }
        return this.Se;
    }
}
