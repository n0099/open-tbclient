package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
/* loaded from: classes.dex */
public class j<V extends af.a> extends a<i, V> {
    private a<q, V> XB;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.baidu.adp.widget.ListView.af$a */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, i iVar, af.a aVar) {
        return a2(i, view, viewGroup, iVar, (i) aVar);
    }

    public j(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(context, bdUniqueId, bdUniqueId2);
    }

    public void a(a aVar) {
        this.XB = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V c(ViewGroup viewGroup) {
        return a(viewGroup, new i());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public V a(ViewGroup viewGroup, i iVar) {
        V c;
        if (this.XB == null) {
            return null;
        }
        if (this.Wv == this.XB.qL()) {
            c = this.XB.b(viewGroup, iVar.qV());
        } else if (this.Wv == this.XB.qM()) {
            c = this.XB.c(viewGroup, iVar.qV());
        } else if (this.Wv == this.XB.qN()) {
            c = this.XB.d(viewGroup, iVar.qV());
        } else if (this.Wv == this.XB.qO()) {
            c = this.XB.e(viewGroup, iVar.qV());
        } else {
            c = this.XB.c(viewGroup);
        }
        if (c == null) {
            throw new NullPointerException("Order error or holder created is NullPointerException");
        }
        a(this.XB.qP());
        return c;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, i iVar, V v) {
        if (this.XB == null) {
            return null;
        }
        if (this.Wv == this.XB.qL()) {
            return this.XB.b(i, view, viewGroup, iVar.qV(), v);
        }
        if (this.Wv == this.XB.qM()) {
            return this.XB.c(i, view, viewGroup, iVar.qV(), v);
        }
        if (this.Wv == this.XB.qN()) {
            return this.XB.d(i, view, viewGroup, iVar.qV(), v);
        }
        if (this.Wv == this.XB.qO()) {
            return this.XB.e(i, view, viewGroup, iVar.qV(), v);
        }
        return this.XB.a(i, view, viewGroup, iVar.qV(), v);
    }
}
