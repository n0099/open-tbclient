package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a KA;

    public d(Intent intent) {
        this.KA = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.KA.getKeys();
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void e(String str, Object obj) {
        this.KA.e(str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        return this.KA.b(str, type);
    }
}
