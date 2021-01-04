package com.baidu.pyramid.a.a;
/* loaded from: classes6.dex */
public class a<T> implements c<T> {
    public com.baidu.pyramid.a.a<T> cvF;
    public com.baidu.pyramid.a.a<T> cvG;
    public T t;

    @Override // com.baidu.pyramid.a.a.c
    public T get() {
        if (this.t != null) {
            return this.t;
        }
        if (this.cvF != null) {
            this.t = this.cvF.get();
            return this.t;
        } else if (this.cvG != null) {
            return this.cvG.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.c
    public void a(com.baidu.pyramid.a.a<T> aVar) {
        this.cvF = aVar;
        this.t = null;
    }

    public static a ahz() {
        return new a();
    }
}
