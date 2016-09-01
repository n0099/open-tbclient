package com.baidu.adp.lib.a.b.a.c;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a le;

    public d(Intent intent) {
        this.le = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> db() {
        return this.le.db();
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void j(String str, Object obj) {
        this.le.j(str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object b(String str, Type type) {
        return this.le.b(str, type);
    }
}
