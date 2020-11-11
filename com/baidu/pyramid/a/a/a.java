package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes16.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> cjC;
    public com.baidu.pyramid.a.a<List<T>> cjD;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.cjC != null) {
            this.list = this.cjC.get();
            return this.list;
        } else if (this.cjD != null) {
            return this.cjD.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.cjC = aVar;
        this.list = null;
    }

    public static a ade() {
        return new a();
    }
}
