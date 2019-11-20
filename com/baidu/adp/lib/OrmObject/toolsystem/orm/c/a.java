package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object mA;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.mA = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.mA != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.mA, cVar);
        }
        return null;
    }
}
