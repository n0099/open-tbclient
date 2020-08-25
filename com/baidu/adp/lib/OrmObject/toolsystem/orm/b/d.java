package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a JJ;

    public d(Intent intent) {
        this.JJ = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.JJ.getKeys();
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void f(String str, Object obj) {
        this.JJ.f(str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        return this.JJ.b(str, type);
    }
}
