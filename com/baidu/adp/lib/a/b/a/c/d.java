package com.baidu.adp.lib.a.b.a.c;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a so;

    public d(Intent intent) {
        this.so = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Set<String> fR() {
        return this.so.fR();
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public void e(String str, Object obj) {
        this.so.e(str, obj);
    }

    @Override // com.baidu.adp.lib.a.b.a.c.c
    public Object a(String str, Type type) {
        return this.so.a(str, type);
    }
}
