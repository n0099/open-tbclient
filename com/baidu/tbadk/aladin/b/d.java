package com.baidu.tbadk.aladin.b;

import java.util.Locale;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.aladin.a.a Nu;

    public d(com.baidu.tbadk.aladin.a.a aVar) {
        this.Nu = aVar;
    }

    public com.baidu.tbadk.aladin.a.a pm() {
        if (this.Nu == null || this.Nu.getMethod() == null || this.Nu.ph() == null || this.Nu.getUrl() == null || !this.Nu.getMethod().equalsIgnoreCase("GET") || !this.Nu.ph().toLowerCase(Locale.getDefault()).startsWith("http")) {
            return null;
        }
        return this.Nu;
    }
}
