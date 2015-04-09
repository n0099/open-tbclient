package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView Id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BdListView bdListView) {
        this.Id = bdListView;
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
        gVar = this.Id.HE;
        int headersCount = gVar.getHeadersCount();
        if (i < headersCount) {
            eVar4 = this.Id.HS;
            if (eVar4 != null) {
                eVar5 = this.Id.HS;
                if (view == eVar5.getView()) {
                    eVar6 = this.Id.HS;
                    eVar6.onClick();
                    return;
                }
            }
            uVar = this.Id.HI;
            if (uVar != null) {
                uVar2 = this.Id.HI;
                uVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        gVar2 = this.Id.HE;
        ListAdapter wrappedAdapter = gVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.Id.HF;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.Id.HF;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        eVar = this.Id.HT;
        if (eVar != null) {
            eVar2 = this.Id.HT;
            if (view == eVar2.getView()) {
                eVar3 = this.Id.HT;
                eVar3.onClick();
                return;
            }
        }
        tVar = this.Id.HJ;
        if (tVar != null) {
            tVar2 = this.Id.HJ;
            tVar2.onClick(view);
        }
    }
}
