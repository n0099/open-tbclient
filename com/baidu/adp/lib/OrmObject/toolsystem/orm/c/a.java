package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object Jz;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.Jz = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.Jz != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.Jz, cVar);
        }
        return null;
    }
}
