package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        e eVar;
        t tVar;
        t tVar2;
        e eVar2;
        e eVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        AdapterView.OnItemClickListener onItemClickListener2;
        e eVar4;
        u uVar;
        u uVar2;
        e eVar5;
        e eVar6;
        gVar = this.Ib.HC;
        int headersCount = gVar.getHeadersCount();
        if (i < headersCount) {
            eVar4 = this.Ib.HQ;
            if (eVar4 != null) {
                eVar5 = this.Ib.HQ;
                if (view == eVar5.getView()) {
                    eVar6 = this.Ib.HQ;
                    eVar6.onClick();
                    return;
                }
            }
            uVar = this.Ib.HG;
            if (uVar != null) {
                uVar2 = this.Ib.HG;
                uVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        gVar2 = this.Ib.HC;
        ListAdapter wrappedAdapter = gVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.Ib.HD;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.Ib.HD;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        eVar = this.Ib.HR;
        if (eVar != null) {
            eVar2 = this.Ib.HR;
            if (view == eVar2.getView()) {
                eVar3 = this.Ib.HR;
                eVar3.onClick();
                return;
            }
        }
        tVar = this.Ib.HH;
        if (tVar != null) {
            tVar2 = this.Ib.HH;
            tVar2.onClick(view);
        }
    }
}
