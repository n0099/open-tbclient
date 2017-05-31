package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        e eVar2;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        AdapterView.OnItemLongClickListener onItemLongClickListener2;
        eVar = this.Ib.mBdListAdpter;
        int headersCount = eVar.getHeadersCount();
        if (i < headersCount) {
            return true;
        }
        int i2 = i - headersCount;
        eVar2 = this.Ib.mBdListAdpter;
        ListAdapter wrappedAdapter = eVar2.getWrappedAdapter();
        if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
            return true;
        }
        onItemLongClickListener = this.Ib.mOnItemLongClickListener;
        if (onItemLongClickListener != null) {
            onItemLongClickListener2 = this.Ib.mOnItemLongClickListener;
            return onItemLongClickListener2.onItemLongClick(adapterView, view, i2, j);
        }
        return false;
    }
}
