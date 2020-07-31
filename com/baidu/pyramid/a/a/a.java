package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes10.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> bHf;
    public com.baidu.pyramid.a.a<List<T>> bHg;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.bHf != null) {
            this.list = this.bHf.get();
            return this.list;
        } else if (this.bHg != null) {
            return this.bHg.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.bHf = aVar;
        this.list = null;
    }

    public static a Ql() {
        return new a();
    }
}
