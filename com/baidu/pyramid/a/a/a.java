package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes7.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> aVD;
    public com.baidu.pyramid.a.a<List<T>> aVE;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.aVD != null) {
            this.list = this.aVD.get();
            return this.list;
        } else if (this.aVE != null) {
            return this.aVE.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.aVD = aVar;
        this.list = null;
    }

    public static a EP() {
        return new a();
    }
}
