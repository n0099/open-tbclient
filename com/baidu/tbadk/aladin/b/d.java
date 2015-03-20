package com.baidu.tbadk.aladin.b;

import java.util.Locale;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.aladin.a.a Ne;

    public d(com.baidu.tbadk.aladin.a.a aVar) {
        this.Ne = aVar;
    }

    public com.baidu.tbadk.aladin.a.a oM() {
        if (this.Ne == null || this.Ne.getMethod() == null || this.Ne.oH() == null || this.Ne.getUrl() == null || !this.Ne.getMethod().equalsIgnoreCase("GET") || !this.Ne.oH().toLowerCase(Locale.getDefault()).startsWith("http")) {
            return null;
        }
        return this.Ne;
    }
}
