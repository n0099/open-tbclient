package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;
/* loaded from: classes.dex */
public class a implements h {
    private Object IW;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.IW = obj;
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        if (this.IW != null) {
            return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.IW, cVar);
        }
        return null;
    }
}
