package com.baidu.adp.lib.a.b.a.d;
/* loaded from: classes.dex */
public class a implements h {
    private Object ei;

    public a(Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            this.ei = obj;
        }
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        if (this.ei != null) {
            return com.baidu.adp.lib.a.b.a.e.b.a(this.ei, cVar);
        }
        return null;
    }
}
