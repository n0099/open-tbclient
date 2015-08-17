package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView HU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.HU = bdListView;
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
        eVar = this.HU.Hv;
        int headersCount = eVar.getHeadersCount();
        if (i < headersCount) {
            cVar4 = this.HU.HJ;
            if (cVar4 != null) {
                cVar5 = this.HU.HJ;
                if (view == cVar5.getView()) {
                    cVar6 = this.HU.HJ;
                    cVar6.onClick();
                    return;
                }
            }
            bVar = this.HU.Hz;
            if (bVar != null) {
                bVar2 = this.HU.Hz;
                bVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        eVar2 = this.HU.Hv;
        ListAdapter wrappedAdapter = eVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.HU.Hw;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.HU.Hw;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        cVar = this.HU.HK;
        if (cVar != null) {
            cVar2 = this.HU.HK;
            if (view == cVar2.getView()) {
                cVar3 = this.HU.HK;
                cVar3.onClick();
                return;
            }
        }
        aVar = this.HU.HA;
        if (aVar != null) {
            aVar2 = this.HU.HA;
            aVar2.onClick(view);
        }
    }
}
