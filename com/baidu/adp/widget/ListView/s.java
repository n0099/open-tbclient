package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class s implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView Js;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BdTypeListView bdTypeListView) {
        this.Js = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.Js.Jr != null) {
            this.Js.Jr.onItemClick(adapterView, view, i, j);
        }
    }
}
