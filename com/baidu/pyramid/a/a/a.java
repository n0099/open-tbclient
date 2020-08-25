package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> bMF;
    public com.baidu.pyramid.a.a<List<T>> bMG;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.bMF != null) {
            this.list = this.bMF.get();
            return this.list;
        } else if (this.bMG != null) {
            return this.bMG.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.bMF = aVar;
        this.list = null;
    }

    public static a Wg() {
        return new a();
    }
}
