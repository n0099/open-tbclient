package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object agc;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.agc = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.agc != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.agc, cVar);
        }
        return null;
    }
}
