package com.baidu.adp.lib.a.b.a.c;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a sy;

    public d(Intent intent) {
        this.sy = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fR() {
        return this.sy.fR();
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void d(String str, Object obj) {
        this.sy.d(str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        return this.sy.a(str, type);
    }
}
