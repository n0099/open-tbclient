package com.baidu.adp.lib.a.b.a.d;
/* loaded from: classes.dex */
public class a implements h {
    private Object rO;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.rO = obj;
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        if (this.rO != null) {
            return com.baidu.adp.lib.a.b.a.e.b.a(this.rO, cVar);
        }
        return null;
    }
}
