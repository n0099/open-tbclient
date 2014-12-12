package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class w implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ BdListView xm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(BdListView bdListView) {
        this.xm = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar;
        k kVar2;
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        kVar = this.xm.wN;
        int headersCount = kVar.getHeadersCount();
        if (i >= headersCount) {
            int i2 = i - headersCount;
            kVar2 = this.xm.wN;
            ListAdapter wrappedAdapter = kVar2.getWrappedAdapter();
            if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
                onItemSelectedListener = this.xm.wQ;
                if (onItemSelectedListener != null) {
                    onItemSelectedListener2 = this.xm.wQ;
                    onItemSelectedListener2.onItemSelected(adapterView, view, i2, j);
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        onItemSelectedListener = this.xm.wQ;
        if (onItemSelectedListener != null) {
            onItemSelectedListener2 = this.xm.wQ;
            onItemSelectedListener2.onNothingSelected(adapterView);
        }
    }
}
