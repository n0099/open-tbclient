package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes14.dex */
public class b<T> implements d<T> {
    public com.baidu.pyramid.a.a<List<T>> coA;
    public com.baidu.pyramid.a.a<List<T>> coz;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.d
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.coz != null) {
            this.list = this.coz.get();
            return this.list;
        } else if (this.coA != null) {
            return this.coA.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.d
    public void b(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.coz = aVar;
        this.list = null;
    }

    public static b afE() {
        return new b();
    }
}
