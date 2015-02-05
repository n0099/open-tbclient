package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ BdListView xj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(BdListView bdListView) {
        this.xj = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar;
        k kVar2;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        AdapterView.OnItemLongClickListener onItemLongClickListener2;
        kVar = this.xj.wK;
        int headersCount = kVar.getHeadersCount();
        if (i < headersCount) {
            return true;
        }
        int i2 = i - headersCount;
        kVar2 = this.xj.wK;
        ListAdapter wrappedAdapter = kVar2.getWrappedAdapter();
        if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
            return true;
        }
        onItemLongClickListener = this.xj.wM;
        if (onItemLongClickListener != null) {
            onItemLongClickListener2 = this.xj.wM;
            return onItemLongClickListener2.onItemLongClick(adapterView, view, i2, j);
        }
        return false;
    }
}
