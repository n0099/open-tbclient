package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes6.dex */
public class b<T> implements d<T> {
    public com.baidu.pyramid.a.a<List<T>> cqN;
    public com.baidu.pyramid.a.a<List<T>> cqO;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.d
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.cqN != null) {
            this.list = this.cqN.get();
            return this.list;
        } else if (this.cqO != null) {
            return this.cqO.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.d
    public void b(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.cqN = aVar;
        this.list = null;
    }

    public static b adH() {
        return new b();
    }
}
