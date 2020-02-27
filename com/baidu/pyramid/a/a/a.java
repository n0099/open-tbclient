package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes7.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> aVB;
    public com.baidu.pyramid.a.a<List<T>> aVC;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.aVB != null) {
            this.list = this.aVB.get();
            return this.list;
        } else if (this.aVC != null) {
            return this.aVC.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.aVB = aVar;
        this.list = null;
    }

    public static a EN() {
        return new a();
    }
}
