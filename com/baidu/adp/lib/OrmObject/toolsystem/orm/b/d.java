package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {
    private a sq;

    public d(Intent intent) {
        this.sq = new a(intent.getExtras());
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> eh() {
        return this.sq.eh();
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void j(String str, Object obj) {
        this.sq.j(str, obj);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        return this.sq.b(str, type);
    }
}
