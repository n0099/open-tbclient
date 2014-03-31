package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        e eVar;
        p pVar;
        p pVar2;
        e eVar2;
        e eVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        AdapterView.OnItemClickListener onItemClickListener2;
        e eVar4;
        q qVar;
        q qVar2;
        e eVar5;
        e eVar6;
        gVar = this.a.a;
        int c = gVar.c();
        if (i < c) {
            eVar4 = this.a.n;
            if (eVar4 != null) {
                eVar5 = this.a.n;
                if (view == eVar5.b()) {
                    eVar6 = this.a.n;
                    eVar6.onClick();
                    return;
                }
            }
            qVar = this.a.e;
            if (qVar != null) {
                qVar2 = this.a.e;
                qVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - c;
        gVar2 = this.a.a;
        ListAdapter b = gVar2.b();
        if (b != null && i2 < b.getCount()) {
            onItemClickListener = this.a.b;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.a.b;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        eVar = this.a.o;
        if (eVar != null) {
            eVar2 = this.a.o;
            if (view == eVar2.b()) {
                eVar3 = this.a.o;
                eVar3.onClick();
                return;
            }
        }
        pVar = this.a.f;
        if (pVar != null) {
            pVar2 = this.a.f;
            pVar2.onClick(view);
        }
    }
}
