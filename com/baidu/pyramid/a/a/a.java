package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes7.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> bBS;
    public com.baidu.pyramid.a.a<List<T>> bBT;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.bBS != null) {
            this.list = this.bBS.get();
            return this.list;
        } else if (this.bBT != null) {
            return this.bBT.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.bBS = aVar;
        this.list = null;
    }

    public static a OQ() {
        return new a();
    }
}
