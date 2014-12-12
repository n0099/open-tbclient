package com.baidu.tbadk.aladin.b;

import java.util.Locale;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.aladin.a.a AB;

    public d(com.baidu.tbadk.aladin.a.a aVar) {
        this.AB = aVar;
    }

    public com.baidu.tbadk.aladin.a.a la() {
        if (this.AB == null || this.AB.getMethod() == null || this.AB.kV() == null || this.AB.getUrl() == null || !this.AB.getMethod().equalsIgnoreCase("GET") || !this.AB.kV().toLowerCase(Locale.getDefault()).startsWith("http")) {
            return null;
        }
        return this.AB;
    }
}
