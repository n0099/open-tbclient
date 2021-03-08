package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes.dex */
public class h<V extends TypeAdapter.ViewHolder> extends a<g, V> {
    private a<n, V> YM;

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
        this.YM = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V e(ViewGroup viewGroup) {
        return a(viewGroup, new g());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public V a(ViewGroup viewGroup, g gVar) {
        V e;
        if (this.YM == null) {
            return null;
        }
        if (this.XG == this.YM.ql()) {
            e = this.YM.b(viewGroup, gVar.qv());
        } else if (this.XG == this.YM.qm()) {
            e = this.YM.c(viewGroup, gVar.qv());
        } else if (this.XG == this.YM.qn()) {
            e = this.YM.d(viewGroup, gVar.qv());
        } else if (this.XG == this.YM.qo()) {
            e = this.YM.e(viewGroup, gVar.qv());
        } else {
            e = this.YM.e(viewGroup);
        }
        if (e == null) {
            throw new NullPointerException("Order error or holder created is NullPointerException");
        }
        a(this.YM.qp());
        return e;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, g gVar, V v) {
        if (this.YM == null) {
            return null;
        }
        if (this.XG == this.YM.ql()) {
            return this.YM.b(i, view, viewGroup, gVar.qv(), v);
        }
        if (this.XG == this.YM.qm()) {
            return this.YM.c(i, view, viewGroup, gVar.qv(), v);
        }
        if (this.XG == this.YM.qn()) {
            return this.YM.d(i, view, viewGroup, gVar.qv(), v);
        }
        if (this.XG == this.YM.qo()) {
            return this.YM.e(i, view, viewGroup, gVar.qv(), v);
        }
        return this.YM.a(i, view, viewGroup, gVar.qv(), v);
    }
}
