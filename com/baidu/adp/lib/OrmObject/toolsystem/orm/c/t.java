package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class t implements h {
    private SparseArray<Object> agc;

    public t(SparseArray<Object> sparseArray) {
        this.agc = sparseArray;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.agc, cVar);
    }
}
