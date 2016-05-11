package com.baidu.adp.lib.a.b.a.c;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a ik;

    public d(Intent intent) {
        this.ik = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> cg() {
        return this.ik.cg();
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void d(String str, Object obj) {
        this.ik.d(str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        return this.ik.a(str, type);
    }
}
