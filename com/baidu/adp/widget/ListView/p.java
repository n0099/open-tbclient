package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class p implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        gVar = this.a.b;
        int c = gVar.c();
        if (i >= c) {
            int i2 = i - c;
            gVar2 = this.a.b;
            ListAdapter b = gVar2.b();
            if (b != null && i2 < b.getCount()) {
                onItemSelectedListener = this.a.e;
                if (onItemSelectedListener != null) {
                    onItemSelectedListener2 = this.a.e;
                    onItemSelectedListener2.onItemSelected(adapterView, view, i2, j);
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        onItemSelectedListener = this.a.e;
        if (onItemSelectedListener != null) {
            onItemSelectedListener2 = this.a.e;
            onItemSelectedListener2.onNothingSelected(adapterView);
        }
    }
}
