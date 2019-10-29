package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object nd;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.nd = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.nd != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.nd, cVar);
        }
        return null;
    }
}
