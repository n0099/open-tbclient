package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.util.List;
/* loaded from: classes.dex */
public class l implements h {
    private List<Object> LM;

    public l(List<Object> list) {
        this.LM = list;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.LM, cVar);
    }
}
