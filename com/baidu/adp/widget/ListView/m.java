package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView Cf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.Cf = bdListView;
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
        eVar = this.Cf.BG;
        int headersCount = eVar.getHeadersCount();
        if (i < headersCount) {
            cVar4 = this.Cf.BU;
            if (cVar4 != null) {
                cVar5 = this.Cf.BU;
                if (view == cVar5.getView()) {
                    cVar6 = this.Cf.BU;
                    cVar6.onClick();
                    return;
                }
            }
            bVar = this.Cf.BK;
            if (bVar != null) {
                bVar2 = this.Cf.BK;
                bVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        eVar2 = this.Cf.BG;
        ListAdapter wrappedAdapter = eVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.Cf.BH;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.Cf.BH;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        cVar = this.Cf.BV;
        if (cVar != null) {
            cVar2 = this.Cf.BV;
            if (view == cVar2.getView()) {
                cVar3 = this.Cf.BV;
                cVar3.onClick();
                return;
            }
        }
        aVar = this.Cf.BL;
        if (aVar != null) {
            aVar2 = this.Cf.BL;
            aVar2.onClick(view);
        }
    }
}
