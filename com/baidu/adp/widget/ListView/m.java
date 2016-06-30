package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdListView zo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.zo = bdListView;
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
        eVar = this.zo.yP;
        int headersCount = eVar.getHeadersCount();
        if (i < headersCount) {
            cVar4 = this.zo.zd;
            if (cVar4 != null) {
                cVar5 = this.zo.zd;
                if (view == cVar5.getView()) {
                    cVar6 = this.zo.zd;
                    cVar6.onClick();
                    return;
                }
            }
            bVar = this.zo.yT;
            if (bVar != null) {
                bVar2 = this.zo.yT;
                bVar2.onClick(view);
                return;
            }
            return;
        }
        int i2 = i - headersCount;
        eVar2 = this.zo.yP;
        ListAdapter wrappedAdapter = eVar2.getWrappedAdapter();
        if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
            onItemClickListener = this.zo.yQ;
            if (onItemClickListener != null) {
                onItemClickListener2 = this.zo.yQ;
                onItemClickListener2.onItemClick(adapterView, view, i2, j);
                return;
            }
            return;
        }
        cVar = this.zo.ze;
        if (cVar != null) {
            cVar2 = this.zo.ze;
            if (view == cVar2.getView()) {
                cVar3 = this.zo.ze;
                cVar3.onClick();
                return;
            }
        }
        aVar = this.zo.yU;
        if (aVar != null) {
            aVar2 = this.zo.yU;
            aVar2.onClick(view);
        }
    }
}
