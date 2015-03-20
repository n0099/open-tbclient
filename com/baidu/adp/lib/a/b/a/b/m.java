package com.baidu.adp.lib.a.b.a.b;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m implements h {
    private com.baidu.adp.lib.a.b.a.a.i rO;

    public m(com.baidu.adp.lib.a.b.a.a.i iVar) {
        this.rO = iVar;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object a(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return com.baidu.adp.lib.a.b.a.a.i.jsonWithObject(this.rO);
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object b(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Object a = a(cVar);
        if (a == null || !(a instanceof JSONObject)) {
            return null;
        }
        return a.toString();
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object c(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object d(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.rO;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object e(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Object a = a(cVar);
        if (a != null) {
            if (a instanceof JSONObject) {
                return a.toString();
            }
            if (a instanceof JSONArray) {
                return a.toString();
            }
            return a;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object f(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.rO;
    }
}
