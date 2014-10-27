package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class v implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ BdListView vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(BdListView bdListView) {
        this.vg = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        j jVar2;
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        jVar = this.vg.uH;
        int headersCount = jVar.getHeadersCount();
        if (i >= headersCount) {
            int i2 = i - headersCount;
            jVar2 = this.vg.uH;
            ListAdapter wrappedAdapter = jVar2.getWrappedAdapter();
            if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
                onItemSelectedListener = this.vg.uK;
                if (onItemSelectedListener != null) {
                    onItemSelectedListener2 = this.vg.uK;
                    onItemSelectedListener2.onItemSelected(adapterView, view, i2, j);
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        onItemSelectedListener = this.vg.uK;
        if (onItemSelectedListener != null) {
            onItemSelectedListener2 = this.vg.uK;
            onItemSelectedListener2.onNothingSelected(adapterView);
        }
    }
}
