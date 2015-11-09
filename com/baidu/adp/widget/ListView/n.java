package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdListView HW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.HW = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        e eVar2;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        AdapterView.OnItemLongClickListener onItemLongClickListener2;
        eVar = this.HW.Hx;
        int headersCount = eVar.getHeadersCount();
        if (i < headersCount) {
            return true;
        }
        int i2 = i - headersCount;
        eVar2 = this.HW.Hx;
        ListAdapter wrappedAdapter = eVar2.getWrappedAdapter();
        if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
            return true;
        }
        onItemLongClickListener = this.HW.Hz;
        if (onItemLongClickListener != null) {
            onItemLongClickListener2 = this.HW.Hz;
            return onItemLongClickListener2.onItemLongClick(adapterView, view, i2, j);
        }
        return false;
    }
}
