package com.baidu.tbadk.aladin.b;

import java.util.Locale;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.aladin.a.a Ng;

    public d(com.baidu.tbadk.aladin.a.a aVar) {
        this.Ng = aVar;
    }

    public com.baidu.tbadk.aladin.a.a oM() {
        if (this.Ng == null || this.Ng.getMethod() == null || this.Ng.oH() == null || this.Ng.getUrl() == null || !this.Ng.getMethod().equalsIgnoreCase("GET") || !this.Ng.oH().toLowerCase(Locale.getDefault()).startsWith("http")) {
            return null;
        }
        return this.Ng;
    }
}
