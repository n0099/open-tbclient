package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes18.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> chQ;
    public com.baidu.pyramid.a.a<List<T>> chR;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.chQ != null) {
            this.list = this.chQ.get();
            return this.list;
        } else if (this.chR != null) {
            return this.chR.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.chQ = aVar;
        this.list = null;
    }

    public static a acv() {
        return new a();
    }
}
