package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        e eVar;
        q qVar;
        q qVar2;
        e eVar2;
        e eVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        AdapterView.OnItemClickListener onItemClickListener2;
        e eVar4;
        r rVar;
        r rVar2;
        e eVar5;
        e eVar6;
        gVar = this.a.b;
        int c = gVar.c();
        if (i < c) {
            eVar4 = this.a.o;
            if (eVar4 != null) {
                eVar5 = this.a.o;
                if (view == eVar5.b()) {
                    eVar6 = this.a.o;
                    eVar6.onClick();
                    return;
                }
            }
            rVar = this.a.f;
            if (rVar != null) {
                rVar2 = this.a.f;
                rVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - c;
        gVar2 = this.a.b;
        ListAdapter b = gVar2.b();
        if (b != null && i2 < b.getCount()) {
            onItemClickListener = this.a.c;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.a.c;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        eVar = this.a.p;
        if (eVar != null) {
            eVar2 = this.a.p;
            if (view == eVar2.b()) {
                eVar3 = this.a.p;
                eVar3.onClick();
                return;
            }
        }
        qVar = this.a.g;
        if (qVar != null) {
            qVar2 = this.a.g;
            qVar2.onClick(view);
        }
    }
}
