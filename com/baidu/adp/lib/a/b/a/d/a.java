package com.baidu.adp.lib.a.b.a.d;
/* loaded from: classes.dex */
public class a implements h {
    private Object rR;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.rR = obj;
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        if (this.rR != null) {
            return com.baidu.adp.lib.a.b.a.e.b.a(this.rR, cVar);
        }
        return null;
    }
}
