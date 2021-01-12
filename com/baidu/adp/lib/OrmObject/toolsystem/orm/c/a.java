package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object Ko;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.Ko = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.Ko != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.Ko, cVar);
        }
        return null;
    }
}
