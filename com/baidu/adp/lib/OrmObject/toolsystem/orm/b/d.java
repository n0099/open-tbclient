package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a sT;

    public d(Intent intent) {
        this.sT = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> ei() {
        return this.sT.ei();
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void j(String str, Object obj) {
        this.sT.j(str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        return this.sT.b(str, type);
    }
}
