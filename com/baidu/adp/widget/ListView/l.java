package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.f463a = bdListView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        e eVar;
        e eVar2;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        AdapterView.OnItemLongClickListener onItemLongClickListener2;
        eVar = this.f463a.f452a;
        int c = eVar.c();
        if (i < c) {
            return true;
        }
        int i2 = i - c;
        eVar2 = this.f463a.f452a;
        ListAdapter b = eVar2.b();
        if (b == null || i2 >= b.getCount()) {
            return true;
        }
        onItemLongClickListener = this.f463a.c;
        if (onItemLongClickListener != null) {
            onItemLongClickListener2 = this.f463a.c;
            return onItemLongClickListener2.onItemLongClick(adapterView, view, i2, j);
        }
        return false;
    }
}
