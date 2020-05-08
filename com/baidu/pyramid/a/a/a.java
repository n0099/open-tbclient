package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes7.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> bup;
    public com.baidu.pyramid.a.a<List<T>> buq;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.bup != null) {
            this.list = this.bup.get();
            return this.list;
        } else if (this.buq != null) {
            return this.buq.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.bup = aVar;
        this.list = null;
    }

    public static a MD() {
        return new a();
    }
}
