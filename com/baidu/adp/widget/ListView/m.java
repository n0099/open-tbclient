package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView zP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.zP = bdListView;
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
        eVar = this.zP.zq;
        int headersCount = eVar.getHeadersCount();
        if (i < headersCount) {
            cVar4 = this.zP.zE;
            if (cVar4 != null) {
                cVar5 = this.zP.zE;
                if (view == cVar5.getView()) {
                    cVar6 = this.zP.zE;
                    cVar6.onClick();
                    return;
                }
            }
            bVar = this.zP.zu;
            if (bVar != null) {
                bVar2 = this.zP.zu;
                bVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        eVar2 = this.zP.zq;
        ListAdapter wrappedAdapter = eVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.zP.zr;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.zP.zr;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        cVar = this.zP.zF;
        if (cVar != null) {
            cVar2 = this.zP.zF;
            if (view == cVar2.getView()) {
                cVar3 = this.zP.zF;
                cVar3.onClick();
                return;
            }
        }
        aVar = this.zP.zv;
        if (aVar != null) {
            aVar2 = this.zP.zv;
            aVar2.onClick(view);
        }
    }
}
