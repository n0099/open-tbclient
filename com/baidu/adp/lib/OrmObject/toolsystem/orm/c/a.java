package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object afW;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.afW = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.afW != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.afW, cVar);
        }
        return null;
    }
}
