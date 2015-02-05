package com.baidu.tbadk.aladin.b;

import java.util.Locale;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.aladin.a.a Ay;

    public d(com.baidu.tbadk.aladin.a.a aVar) {
        this.Ay = aVar;
    }

    public com.baidu.tbadk.aladin.a.a kT() {
        if (this.Ay == null || this.Ay.getMethod() == null || this.Ay.kO() == null || this.Ay.getUrl() == null || !this.Ay.getMethod().equalsIgnoreCase("GET") || !this.Ay.kO().toLowerCase(Locale.getDefault()).startsWith("http")) {
            return null;
        }
        return this.Ay;
    }
}
