package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes7.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> buk;
    public com.baidu.pyramid.a.a<List<T>> bul;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.buk != null) {
            this.list = this.buk.get();
            return this.list;
        } else if (this.bul != null) {
            return this.bul.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.buk = aVar;
        this.list = null;
    }

    public static a ME() {
        return new a();
    }
}
