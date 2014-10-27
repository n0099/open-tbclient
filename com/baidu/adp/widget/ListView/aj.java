package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView vz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(BdTypeListView bdTypeListView) {
        this.vz = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.vz.vy != null) {
            this.vz.vy.onItemClick(adapterView, view, i, j);
        }
    }
}
