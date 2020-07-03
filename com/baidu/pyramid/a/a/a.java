package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes7.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> bGG;
    public com.baidu.pyramid.a.a<List<T>> bGH;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.bGG != null) {
            this.list = this.bGG.get();
            return this.list;
        } else if (this.bGH != null) {
            return this.bGH.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.bGG = aVar;
        this.list = null;
    }

    public static a PW() {
        return new a();
    }
}
