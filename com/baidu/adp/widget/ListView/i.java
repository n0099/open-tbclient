package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.aa.a;
/* loaded from: classes.dex */
public class i<V extends aa.a> extends a<h, V> {
    private a<o, V> UQ;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.aa$a] */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.baidu.adp.widget.ListView.aa$a */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, h hVar, aa.a aVar) {
        return a2(i, view, viewGroup, hVar, (h) aVar);
    }

    public i(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    public void a(a aVar) {
        this.UQ = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V b(ViewGroup viewGroup) {
        if (this.UQ == null) {
            return null;
        }
        if (this.TK == this.UQ.oO()) {
            return this.UQ.c(viewGroup);
        }
        if (this.TK == this.UQ.oP()) {
            return this.UQ.d(viewGroup);
        }
        if (this.TK == this.UQ.oQ()) {
            return this.UQ.e(viewGroup);
        }
        if (this.TK == this.UQ.oR()) {
            return this.UQ.f(viewGroup);
        }
        return this.UQ.b(viewGroup);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, h hVar, V v) {
        if (this.UQ == null) {
            return null;
        }
        if (this.TK == this.UQ.oO()) {
            return this.UQ.b(i, view, viewGroup, hVar.oX(), v);
        }
        if (this.TK == this.UQ.oP()) {
            return this.UQ.c(i, view, viewGroup, hVar.oX(), v);
        }
        if (this.TK == this.UQ.oQ()) {
            return this.UQ.d(i, view, viewGroup, hVar.oX(), v);
        }
        if (this.TK == this.UQ.oR()) {
            return this.UQ.e(i, view, viewGroup, hVar.oX(), v);
        }
        return this.UQ.a(i, view, viewGroup, hVar.oX(), v);
    }
}
