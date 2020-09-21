package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
/* loaded from: classes.dex */
public class j<V extends af.a> extends a<i, V> {
    private a<q, V> Wj;

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
        this.Wj = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V c(ViewGroup viewGroup) {
        if (this.Wj == null) {
            return null;
        }
        if (this.Vf == this.Wj.qJ()) {
            return this.Wj.d(viewGroup);
        }
        if (this.Vf == this.Wj.qK()) {
            return this.Wj.e(viewGroup);
        }
        if (this.Vf == this.Wj.qL()) {
            return this.Wj.f(viewGroup);
        }
        if (this.Vf == this.Wj.qM()) {
            return this.Wj.g(viewGroup);
        }
        return this.Wj.c(viewGroup);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, i iVar, V v) {
        if (this.Wj == null) {
            return null;
        }
        if (this.Vf == this.Wj.qJ()) {
            return this.Wj.b(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vf == this.Wj.qK()) {
            return this.Wj.c(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vf == this.Wj.qL()) {
            return this.Wj.d(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vf == this.Wj.qM()) {
            return this.Wj.e(i, view, viewGroup, iVar.qT(), v);
        }
        return this.Wj.a(i, view, viewGroup, iVar.qT(), v);
    }
}
