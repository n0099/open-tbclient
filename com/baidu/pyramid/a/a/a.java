package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes4.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> aQk;
    public com.baidu.pyramid.a.a<List<T>> aQl;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.aQk != null) {
            this.list = this.aQk.get();
            return this.list;
        } else if (this.aQl != null) {
            return this.aQl.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.aQk = aVar;
        this.list = null;
    }

    public static a BV() {
        return new a();
    }
}
