package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object If;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.If = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.If != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.If, cVar);
        }
        return null;
    }
}
