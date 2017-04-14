package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object sa;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.sa = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.sa != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.sa, cVar);
        }
        return null;
    }
}
