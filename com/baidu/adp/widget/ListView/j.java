package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
/* loaded from: classes.dex */
public class j<V extends af.a> extends a<i, V> {
    private a<q, V> WE;

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
        this.WE = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V c(ViewGroup viewGroup) {
        return a(viewGroup, new i());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public V a(ViewGroup viewGroup, i iVar) {
        V c;
        if (this.WE == null) {
            return null;
        }
        if (this.Vx == this.WE.qJ()) {
            c = this.WE.b(viewGroup, iVar.qT());
        } else if (this.Vx == this.WE.qK()) {
            c = this.WE.c(viewGroup, iVar.qT());
        } else if (this.Vx == this.WE.qL()) {
            c = this.WE.d(viewGroup, iVar.qT());
        } else if (this.Vx == this.WE.qM()) {
            c = this.WE.e(viewGroup, iVar.qT());
        } else {
            c = this.WE.c(viewGroup);
        }
        if (c == null) {
            throw new NullPointerException("Order error or holder created is NullPointerException");
        }
        a(this.WE.qN());
        return c;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, i iVar, V v) {
        if (this.WE == null) {
            return null;
        }
        if (this.Vx == this.WE.qJ()) {
            return this.WE.b(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vx == this.WE.qK()) {
            return this.WE.c(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vx == this.WE.qL()) {
            return this.WE.d(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vx == this.WE.qM()) {
            return this.WE.e(i, view, viewGroup, iVar.qT(), v);
        }
        return this.WE.a(i, view, viewGroup, iVar.qT(), v);
    }
}
