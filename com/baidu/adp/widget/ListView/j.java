package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
/* loaded from: classes.dex */
public class j<V extends af.a> extends a<i, V> {
    private a<q, V> VQ;

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
        this.VQ = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public V b(ViewGroup viewGroup) {
        if (this.VQ == null) {
            return null;
        }
        if (this.UM == this.VQ.qE()) {
            return this.VQ.c(viewGroup);
        }
        if (this.UM == this.VQ.qF()) {
            return this.VQ.d(viewGroup);
        }
        if (this.UM == this.VQ.qG()) {
            return this.VQ.e(viewGroup);
        }
        if (this.UM == this.VQ.qH()) {
            return this.VQ.f(viewGroup);
        }
        return this.VQ.b(viewGroup);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public View a2(int i, View view, ViewGroup viewGroup, i iVar, V v) {
        if (this.VQ == null) {
            return null;
        }
        if (this.UM == this.VQ.qE()) {
            return this.VQ.b(i, view, viewGroup, iVar.qO(), v);
        }
        if (this.UM == this.VQ.qF()) {
            return this.VQ.c(i, view, viewGroup, iVar.qO(), v);
        }
        if (this.UM == this.VQ.qG()) {
            return this.VQ.d(i, view, viewGroup, iVar.qO(), v);
        }
        if (this.UM == this.VQ.qH()) {
            return this.VQ.e(i, view, viewGroup, iVar.qO(), v);
        }
        return this.VQ.a(i, view, viewGroup, iVar.qO(), v);
    }
}
