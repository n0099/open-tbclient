package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView IS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.IS = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        e eVar2;
        c cVar;
        BdListView.a aVar;
        BdListView.a aVar2;
        c cVar2;
        c cVar3;
        AdapterView.OnItemClickListener onItemClickListener;
        AdapterView.OnItemClickListener onItemClickListener2;
        c cVar4;
        BdListView.b bVar;
        BdListView.b bVar2;
        c cVar5;
        c cVar6;
        eVar = this.IS.Ir;
        int headersCount = eVar.getHeadersCount();
        if (i < headersCount) {
            cVar4 = this.IS.IH;
            if (cVar4 != null) {
                cVar5 = this.IS.IH;
                if (view == cVar5.getView()) {
                    cVar6 = this.IS.IH;
                    cVar6.onClick();
                    return;
                }
            }
            bVar = this.IS.Iv;
            if (bVar != null) {
                bVar2 = this.IS.Iv;
                bVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        eVar2 = this.IS.Ir;
        ListAdapter wrappedAdapter = eVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.IS.Is;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.IS.Is;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        cVar = this.IS.II;
        if (cVar != null) {
            cVar2 = this.IS.II;
            if (view == cVar2.getView()) {
                cVar3 = this.IS.II;
                cVar3.onClick();
                return;
            }
        }
        aVar = this.IS.Iw;
        if (aVar != null) {
            aVar2 = this.IS.Iw;
            aVar2.onClick(view);
        }
    }
}
