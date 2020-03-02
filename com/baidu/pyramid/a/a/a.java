package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes7.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> aVC;
    public com.baidu.pyramid.a.a<List<T>> aVD;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.aVC != null) {
            this.list = this.aVC.get();
            return this.list;
        } else if (this.aVD != null) {
            return this.aVD.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.aVC = aVar;
        this.list = null;
    }

    public static a EP() {
        return new a();
    }
}
