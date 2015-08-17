package com.baidu.adp.lib.a.b.a.d;
/* loaded from: classes.dex */
public class a implements h {
    private Object rN;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.rN = obj;
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        if (this.rN != null) {
            return com.baidu.adp.lib.a.b.a.e.b.a(this.rN, cVar);
        }
        return null;
    }
}
