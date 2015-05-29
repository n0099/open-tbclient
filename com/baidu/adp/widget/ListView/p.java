package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView HT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BdListView bdListView) {
        this.HT = bdListView;
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
        gVar = this.HT.Hu;
        int headersCount = gVar.getHeadersCount();
        if (i < headersCount) {
            eVar4 = this.HT.HI;
            if (eVar4 != null) {
                eVar5 = this.HT.HI;
                if (view == eVar5.getView()) {
                    eVar6 = this.HT.HI;
                    eVar6.onClick();
                    return;
                }
            }
            uVar = this.HT.Hy;
            if (uVar != null) {
                uVar2 = this.HT.Hy;
                uVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        gVar2 = this.HT.Hu;
        ListAdapter wrappedAdapter = gVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.HT.Hv;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.HT.Hv;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        eVar = this.HT.HJ;
        if (eVar != null) {
            eVar2 = this.HT.HJ;
            if (view == eVar2.getView()) {
                eVar3 = this.HT.HJ;
                eVar3.onClick();
                return;
            }
        }
        tVar = this.HT.Hz;
        if (tVar != null) {
            tVar2 = this.HT.Hz;
            tVar2.onClick(view);
        }
    }
}
