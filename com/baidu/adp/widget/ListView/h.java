package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes.dex */
public class h<V extends TypeAdapter.ViewHolder> extends a<g, V> {
    private a<n, V> Xz;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, g gVar, TypeAdapter.ViewHolder viewHolder) {
        return a2(i, view, viewGroup, gVar, (g) viewHolder);
    }

    public h(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    public void a(a aVar) {
        this.Xz = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V e(ViewGroup viewGroup) {
        return a(viewGroup, new g());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public V a(ViewGroup viewGroup, g gVar) {
        V e;
        if (this.Xz == null) {
            return null;
        }
        if (this.Ws == this.Xz.qn()) {
            e = this.Xz.b(viewGroup, gVar.qx());
        } else if (this.Ws == this.Xz.qo()) {
            e = this.Xz.c(viewGroup, gVar.qx());
        } else if (this.Ws == this.Xz.qp()) {
            e = this.Xz.d(viewGroup, gVar.qx());
        } else if (this.Ws == this.Xz.qq()) {
            e = this.Xz.e(viewGroup, gVar.qx());
        } else {
            e = this.Xz.e(viewGroup);
        }
        if (e == null) {
            throw new NullPointerException("Order error or holder created is NullPointerException");
        }
        a(this.Xz.qr());
        return e;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, g gVar, V v) {
        if (this.Xz == null) {
            return null;
        }
        if (this.Ws == this.Xz.qn()) {
            return this.Xz.b(i, view, viewGroup, gVar.qx(), v);
        }
        if (this.Ws == this.Xz.qo()) {
            return this.Xz.c(i, view, viewGroup, gVar.qx(), v);
        }
        if (this.Ws == this.Xz.qp()) {
            return this.Xz.d(i, view, viewGroup, gVar.qx(), v);
        }
        if (this.Ws == this.Xz.qq()) {
            return this.Xz.e(i, view, viewGroup, gVar.qx(), v);
        }
        return this.Xz.a(i, view, viewGroup, gVar.qx(), v);
    }
}
