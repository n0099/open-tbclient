package com.baidu.pyramid.a.a;
/* loaded from: classes4.dex */
public class a<T> implements c<T> {
    public com.baidu.pyramid.a.a<T> cuf;
    public com.baidu.pyramid.a.a<T> cug;
    public T t;

    @Override // com.baidu.pyramid.a.a.c
    public T get() {
        if (this.t != null) {
            return this.t;
        }
        if (this.cuf != null) {
            this.t = this.cuf.get();
            return this.t;
        } else if (this.cug != null) {
            return this.cug.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.c
    public void a(com.baidu.pyramid.a.a<T> aVar) {
        this.cuf = aVar;
        this.t = null;
    }

    public static a aea() {
        return new a();
    }
}
