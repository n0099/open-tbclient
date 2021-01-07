package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes6.dex */
public class b<T> implements d<T> {
    public com.baidu.pyramid.a.a<List<T>> cvF;
    public com.baidu.pyramid.a.a<List<T>> cvG;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.d
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.cvF != null) {
            this.list = this.cvF.get();
            return this.list;
        } else if (this.cvG != null) {
            return this.cvG.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.d
    public void b(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.cvF = aVar;
        this.list = null;
    }

    public static b ahB() {
        return new b();
    }
}
