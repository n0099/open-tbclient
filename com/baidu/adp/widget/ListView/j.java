package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.ad.a;
/* loaded from: classes.dex */
public class j<V extends ad.a> extends a<i, V> {
    private a<q, V> Vu;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.ad$a] */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.baidu.adp.widget.ListView.ad$a */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, i iVar, ad.a aVar) {
        return a2(i, view, viewGroup, iVar, (i) aVar);
    }

    public j(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    public void a(a aVar) {
        this.Vu = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V b(ViewGroup viewGroup) {
        if (this.Vu == null) {
            return null;
        }
        if (this.Un == this.Vu.pe()) {
            return this.Vu.c(viewGroup);
        }
        if (this.Un == this.Vu.pf()) {
            return this.Vu.d(viewGroup);
        }
        if (this.Un == this.Vu.pg()) {
            return this.Vu.e(viewGroup);
        }
        if (this.Un == this.Vu.ph()) {
            return this.Vu.f(viewGroup);
        }
        return this.Vu.b(viewGroup);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, i iVar, V v) {
        if (this.Vu == null) {
            return null;
        }
        if (this.Un == this.Vu.pe()) {
            return this.Vu.b(i, view, viewGroup, iVar.po(), v);
        }
        if (this.Un == this.Vu.pf()) {
            return this.Vu.c(i, view, viewGroup, iVar.po(), v);
        }
        if (this.Un == this.Vu.pg()) {
            return this.Vu.d(i, view, viewGroup, iVar.po(), v);
        }
        if (this.Un == this.Vu.ph()) {
            return this.Vu.e(i, view, viewGroup, iVar.po(), v);
        }
        return this.Vu.a(i, view, viewGroup, iVar.po(), v);
    }
}
