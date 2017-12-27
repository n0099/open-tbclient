package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.util.Set;
/* loaded from: classes.dex */
public class r implements h {
    private Set<Object> agh;

    public r(Set<Object> set) {
        this.agh = set;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.agh, cVar);
    }
}
