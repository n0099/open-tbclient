package com.baidu.tbadk.aladin.b;

import java.util.Locale;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.aladin.a.a a;

    public d(com.baidu.tbadk.aladin.a.a aVar) {
        this.a = aVar;
    }

    public com.baidu.tbadk.aladin.a.a a() {
        if (this.a == null || this.a.a() == null || this.a.c() == null || this.a.b() == null || !this.a.a().equalsIgnoreCase("GET") || !this.a.c().toLowerCase(Locale.getDefault()).startsWith("http")) {
            return null;
        }
        return this.a;
    }
}
