package com.baidu.pyramid.a.a;
/* loaded from: classes14.dex */
public class a<T> implements c<T> {
    public com.baidu.pyramid.a.a<T> coA;
    public com.baidu.pyramid.a.a<T> coz;
    public T t;

    @Override // com.baidu.pyramid.a.a.c
    public T get() {
        if (this.t != null) {
            return this.t;
        }
        if (this.coz != null) {
            this.t = this.coz.get();
            return this.t;
        } else if (this.coA != null) {
            return this.coA.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.c
    public void a(com.baidu.pyramid.a.a<T> aVar) {
        this.coz = aVar;
        this.t = null;
    }

    public static a afD() {
        return new a();
    }
}
