package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView xz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(BdTypeListView bdTypeListView) {
        this.xz = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.xz.xy != null) {
            this.xz.xy.onItemClick(adapterView, view, i, j);
        }
    }
}
