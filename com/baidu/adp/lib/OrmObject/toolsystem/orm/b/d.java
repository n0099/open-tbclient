package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a zK;

    public d(Intent intent) {
        this.zK = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.zK.getKeys();
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void d(String str, Object obj) {
        this.zK.d(str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        return this.zK.b(str, type);
    }
}
