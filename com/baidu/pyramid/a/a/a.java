package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes17.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> bOJ;
    public com.baidu.pyramid.a.a<List<T>> bOK;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.bOJ != null) {
            this.list = this.bOJ.get();
            return this.list;
        } else if (this.bOK != null) {
            return this.bOK.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.bOJ = aVar;
        this.list = null;
    }

    public static a WP() {
        return new a();
    }
}
