package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object qs;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.qs = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.qs != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.qs, cVar);
        }
        return null;
    }
}
