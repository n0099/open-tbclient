package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes5.dex */
public class b<T> implements d<T> {
    public com.baidu.pyramid.a.a<List<T>> csC;
    public com.baidu.pyramid.a.a<List<T>> csD;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.d
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.csC != null) {
            this.list = this.csC.get();
            return this.list;
        } else if (this.csD != null) {
            return this.csD.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.d
    public void b(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.csC = aVar;
        this.list = null;
    }

    public static b adY() {
        return new b();
    }
}
