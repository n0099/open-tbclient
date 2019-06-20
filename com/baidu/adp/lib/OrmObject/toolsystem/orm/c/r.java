package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.util.Set;
/* loaded from: classes.dex */
public class r implements h {
    private Set<Object> xs;

    public r(Set<Object> set) {
        this.xs = set;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.xs, cVar);
    }
}
