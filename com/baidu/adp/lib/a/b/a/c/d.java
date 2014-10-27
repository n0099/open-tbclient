package com.baidu.adp.lib.a.b.a.c;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a ez;

    public d(Intent intent) {
        this.ez = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> bQ() {
        return this.ez.bQ();
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void a(String str, Object obj) {
        this.ez.a(str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        return this.ez.a(str, type);
    }
}
