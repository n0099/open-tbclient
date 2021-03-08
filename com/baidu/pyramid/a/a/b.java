package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes4.dex */
public class b<T> implements d<T> {
    public com.baidu.pyramid.a.a<List<T>> cuf;
    public com.baidu.pyramid.a.a<List<T>> cug;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.d
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.cuf != null) {
            this.list = this.cuf.get();
            return this.list;
        } else if (this.cug != null) {
            return this.cug.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.d
    public void b(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.cuf = aVar;
        this.list = null;
    }

    public static b aeb() {
        return new b();
    }
}
