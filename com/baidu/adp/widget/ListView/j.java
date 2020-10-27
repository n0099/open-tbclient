package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
/* loaded from: classes.dex */
public class j<V extends af.a> extends a<i, V> {
    private a<q, V> WA;

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
        this.WA = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V c(ViewGroup viewGroup) {
        if (this.WA == null) {
            return null;
        }
        if (this.Vw == this.WA.qJ()) {
            return this.WA.d(viewGroup);
        }
        if (this.Vw == this.WA.qK()) {
            return this.WA.e(viewGroup);
        }
        if (this.Vw == this.WA.qL()) {
            return this.WA.f(viewGroup);
        }
        if (this.Vw == this.WA.qM()) {
            return this.WA.g(viewGroup);
        }
        return this.WA.c(viewGroup);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, i iVar, V v) {
        if (this.WA == null) {
            return null;
        }
        if (this.Vw == this.WA.qJ()) {
            return this.WA.b(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vw == this.WA.qK()) {
            return this.WA.c(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vw == this.WA.qL()) {
            return this.WA.d(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vw == this.WA.qM()) {
            return this.WA.e(i, view, viewGroup, iVar.qT(), v);
        }
        return this.WA.a(i, view, viewGroup, iVar.qT(), v);
    }
}
