package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes5.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> aRc;
    public com.baidu.pyramid.a.a<List<T>> aRd;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.aRc != null) {
            this.list = this.aRc.get();
            return this.list;
        } else if (this.aRd != null) {
            return this.aRd.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.aRc = aVar;
        this.list = null;
    }

    public static a Cr() {
        return new a();
    }
}
