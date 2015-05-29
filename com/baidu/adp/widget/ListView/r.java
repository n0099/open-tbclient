package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdListView HT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(BdListView bdListView) {
        this.HT = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        AdapterView.OnItemLongClickListener onItemLongClickListener2;
        gVar = this.HT.Hu;
        int headersCount = gVar.getHeadersCount();
        if (i < headersCount) {
            return true;
        }
        int i2 = i - headersCount;
        gVar2 = this.HT.Hu;
        ListAdapter wrappedAdapter = gVar2.getWrappedAdapter();
        if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
            return true;
        }
        onItemLongClickListener = this.HT.Hw;
        if (onItemLongClickListener != null) {
            onItemLongClickListener2 = this.HT.Hw;
            return onItemLongClickListener2.onItemLongClick(adapterView, view, i2, j);
        }
        return false;
    }
}
