package com.baidu.adp.lib.a.b.a.d;
/* loaded from: classes.dex */
public class a implements h {
    private Object rG;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.rG = obj;
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        if (this.rG != null) {
            return com.baidu.adp.lib.a.b.a.e.b.a(this.rG, cVar);
        }
        return null;
    }
}
