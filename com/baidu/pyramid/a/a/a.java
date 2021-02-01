package com.baidu.pyramid.a.a;
/* loaded from: classes5.dex */
public class a<T> implements c<T> {
    public com.baidu.pyramid.a.a<T> csC;
    public com.baidu.pyramid.a.a<T> csD;
    public T t;

    @Override // com.baidu.pyramid.a.a.c
    public T get() {
        if (this.t != null) {
            return this.t;
        }
        if (this.csC != null) {
            this.t = this.csC.get();
            return this.t;
        } else if (this.csD != null) {
            return this.csD.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.c
    public void a(com.baidu.pyramid.a.a<T> aVar) {
        this.csC = aVar;
        this.t = null;
    }

    public static a adX() {
        return new a();
    }
}
