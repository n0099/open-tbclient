package com.baidu.pyramid.a.a;
/* loaded from: classes6.dex */
public class a<T> implements c<T> {
    public com.baidu.pyramid.a.a<T> cqN;
    public com.baidu.pyramid.a.a<T> cqO;
    public T t;

    @Override // com.baidu.pyramid.a.a.c
    public T get() {
        if (this.t != null) {
            return this.t;
        }
        if (this.cqN != null) {
            this.t = this.cqN.get();
            return this.t;
        } else if (this.cqO != null) {
            return this.cqO.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.c
    public void a(com.baidu.pyramid.a.a<T> aVar) {
        this.cqN = aVar;
        this.t = null;
    }

    public static a adG() {
        return new a();
    }
}
