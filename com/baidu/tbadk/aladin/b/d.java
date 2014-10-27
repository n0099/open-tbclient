package com.baidu.tbadk.aladin.b;

import java.util.Locale;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.aladin.a.a xp;

    public d(com.baidu.tbadk.aladin.a.a aVar) {
        this.xp = aVar;
    }

    public com.baidu.tbadk.aladin.a.a iO() {
        if (this.xp == null || this.xp.getMethod() == null || this.xp.iJ() == null || this.xp.getUrl() == null || !this.xp.getMethod().equalsIgnoreCase("GET") || !this.xp.iJ().toLowerCase(Locale.getDefault()).startsWith("http")) {
            return null;
        }
        return this.xp;
    }
}
