package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class t implements h {
    private SparseArray<Object> agi;

    public t(SparseArray<Object> sparseArray) {
        this.agi = sparseArray;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.agi, cVar);
    }
}
