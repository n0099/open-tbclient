package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class p implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ BdListView zo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BdListView bdListView) {
        this.zo = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        e eVar2;
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        eVar = this.zo.yP;
        int headersCount = eVar.getHeadersCount();
        if (i >= headersCount) {
            int i2 = i - headersCount;
            eVar2 = this.zo.yP;
            ListAdapter wrappedAdapter = eVar2.getWrappedAdapter();
            if (wrappedAdapter != null && i2 < wrappedAdapter.getCount()) {
                onItemSelectedListener = this.zo.yS;
                if (onItemSelectedListener != null) {
                    onItemSelectedListener2 = this.zo.yS;
                    onItemSelectedListener2.onItemSelected(adapterView, view, i2, j);
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        onItemSelectedListener = this.zo.yS;
        if (onItemSelectedListener != null) {
            onItemSelectedListener2 = this.zo.yS;
            onItemSelectedListener2.onNothingSelected(adapterView);
        }
    }
}
