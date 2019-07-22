package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object xq;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.xq = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.xq != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.xq, cVar);
        }
        return null;
    }
}
