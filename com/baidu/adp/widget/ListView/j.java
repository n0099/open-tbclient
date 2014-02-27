package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        e eVar2;
        c cVar;
        n nVar;
        n nVar2;
        c cVar2;
        c cVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        AdapterView.OnItemClickListener onItemClickListener2;
        c cVar4;
        o oVar;
        o oVar2;
        c cVar5;
        c cVar6;
        eVar = this.a.a;
        int c = eVar.c();
        if (i < c) {
            cVar4 = this.a.n;
            if (cVar4 != null) {
                cVar5 = this.a.n;
                if (view == cVar5.b()) {
                    cVar6 = this.a.n;
                    cVar6.onClick();
                    return;
                }
            }
            oVar = this.a.e;
            if (oVar != null) {
                oVar2 = this.a.e;
                oVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - c;
        eVar2 = this.a.a;
        ListAdapter b = eVar2.b();
        if (b != null && i2 < b.getCount()) {
            onItemClickListener = this.a.b;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.a.b;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        cVar = this.a.o;
        if (cVar != null) {
            cVar2 = this.a.o;
            if (view == cVar2.b()) {
                cVar3 = this.a.o;
                cVar3.onClick();
                return;
            }
        }
        nVar = this.a.f;
        if (nVar != null) {
            nVar2 = this.a.f;
            nVar2.onClick(view);
        }
    }
}
