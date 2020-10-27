package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes16.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> cdR;
    public com.baidu.pyramid.a.a<List<T>> cdS;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.cdR != null) {
            this.list = this.cdR.get();
            return this.list;
        } else if (this.cdS != null) {
            return this.cdS.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.cdR = aVar;
        this.list = null;
    }

    public static a aaF() {
        return new a();
    }
}
