package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class s implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ BdListView HT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BdListView bdListView) {
        this.HT = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        gVar = this.HT.Hu;
        int headersCount = gVar.getHeadersCount();
        if (i >= headersCount) {
            int i2 = i - headersCount;
            gVar2 = this.HT.Hu;
            ListAdapter wrappedAdapter = gVar2.getWrappedAdapter();
            if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
                onItemSelectedListener = this.HT.Hx;
                if (onItemSelectedListener != null) {
                    onItemSelectedListener2 = this.HT.Hx;
                    onItemSelectedListener2.onItemSelected(adapterView, view, i2, j);
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        onItemSelectedListener = this.HT.Hx;
        if (onItemSelectedListener != null) {
            onItemSelectedListener2 = this.HT.Hx;
            onItemSelectedListener2.onNothingSelected(adapterView);
        }
    }
}
