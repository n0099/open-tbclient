package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object oT;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.oT = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.oT != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.oT, cVar);
        }
        return null;
    }
}
