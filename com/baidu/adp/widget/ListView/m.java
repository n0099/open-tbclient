package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f493a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.f493a = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        e eVar2;
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        eVar = this.f493a.f481a;
        int c = eVar.c();
        if (i >= c) {
            int i2 = i - c;
            eVar2 = this.f493a.f481a;
            ListAdapter b = eVar2.b();
            if (b != null && i2 < b.getCount()) {
                onItemSelectedListener = this.f493a.d;
                if (onItemSelectedListener != null) {
                    onItemSelectedListener2 = this.f493a.d;
                    onItemSelectedListener2.onItemSelected(adapterView, view, i2, j);
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener2;
        onItemSelectedListener = this.f493a.d;
        if (onItemSelectedListener != null) {
            onItemSelectedListener2 = this.f493a.d;
            onItemSelectedListener2.onNothingSelected(adapterView);
        }
    }
}
