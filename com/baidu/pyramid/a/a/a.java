package com.baidu.pyramid.a.a;

import java.util.List;
/* loaded from: classes7.dex */
public class a<T> implements b<T> {
    public com.baidu.pyramid.a.a<List<T>> aVQ;
    public com.baidu.pyramid.a.a<List<T>> aVR;
    public List<T> list;

    @Override // com.baidu.pyramid.a.a.b
    public List<T> getList() {
        if (this.list != null) {
            return this.list;
        }
        if (this.aVQ != null) {
            this.list = this.aVQ.get();
            return this.list;
        } else if (this.aVR != null) {
            return this.aVR.get();
        } else {
            return null;
        }
    }

    @Override // com.baidu.pyramid.a.a.b
    public void a(com.baidu.pyramid.a.a<List<T>> aVar) {
        this.aVQ = aVar;
        this.list = null;
    }

    public static a EU() {
        return new a();
    }
}
