package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f571a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.f571a = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
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
        eVar = this.f571a.f563a;
        int c = eVar.c();
        if (i < c) {
            cVar4 = this.f571a.m;
            if (cVar4 != null) {
                cVar5 = this.f571a.m;
                if (view == cVar5.b()) {
                    cVar6 = this.f571a.m;
                    cVar6.onClick();
                    return;
                }
            }
            oVar = this.f571a.e;
            if (oVar != null) {
                oVar2 = this.f571a.e;
                oVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - c;
        eVar2 = this.f571a.f563a;
        ListAdapter b = eVar2.b();
        if (b == null || i2 >= b.getCount()) {
            cVar = this.f571a.n;
            if (cVar != null) {
                cVar2 = this.f571a.n;
                if (view == cVar2.b()) {
                    cVar3 = this.f571a.n;
                    cVar3.onClick();
                    return;
                }
            }
            nVar = this.f571a.f;
            if (nVar != null) {
                nVar2 = this.f571a.f;
                nVar2.onClick(view);
                return;
            }
            return;
        }
        onItemClickListener = this.f571a.b;
        if (onItemClickListener != null) {
            onItemClickListener2 = this.f571a.b;
            onItemClickListener2.onItemClick(adapterView, view, i2, j);
        }
    }
}
