package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes3.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> bMJ;
    public com.baidu.pyramid.a.a<List<T>> bMK;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.bMJ != null) {
            this.list = this.bMJ.get();
            return this.list;
        } else if (this.bMK != null) {
            return this.bMK.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.bMJ = aVar;
        this.list = null;
    }

    public static a Wg() {
        return new a();
    }
}
