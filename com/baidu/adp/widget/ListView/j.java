package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
/* loaded from: classes.dex */
public class j<V extends af.a> extends a<i, V> {
    private a<q, V> Wz;

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
        this.Wz = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V c(ViewGroup viewGroup) {
        if (this.Wz == null) {
            return null;
        }
        if (this.Vv == this.Wz.qJ()) {
            return this.Wz.d(viewGroup);
        }
        if (this.Vv == this.Wz.qK()) {
            return this.Wz.e(viewGroup);
        }
        if (this.Vv == this.Wz.qL()) {
            return this.Wz.f(viewGroup);
        }
        if (this.Vv == this.Wz.qM()) {
            return this.Wz.g(viewGroup);
        }
        return this.Wz.c(viewGroup);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, i iVar, V v) {
        if (this.Wz == null) {
            return null;
        }
        if (this.Vv == this.Wz.qJ()) {
            return this.Wz.b(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vv == this.Wz.qK()) {
            return this.Wz.c(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vv == this.Wz.qL()) {
            return this.Wz.d(i, view, viewGroup, iVar.qT(), v);
        }
        if (this.Vv == this.Wz.qM()) {
            return this.Wz.e(i, view, viewGroup, iVar.qT(), v);
        }
        return this.Wz.a(i, view, viewGroup, iVar.qT(), v);
    }
}
