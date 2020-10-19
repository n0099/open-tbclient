package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes16.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> bVs;
    public com.baidu.pyramid.a.a<List<T>> bVt;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.bVs != null) {
            this.list = this.bVs.get();
            return this.list;
        } else if (this.bVt != null) {
            return this.bVt.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.bVs = aVar;
        this.list = null;
    }

    public static a YM() {
        return new a();
    }
}
