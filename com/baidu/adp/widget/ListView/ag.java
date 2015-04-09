package com.baidu.adp.widget.ListView;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements AdapterView.OnItemClickListener {
    final /* synthetic */ BdTypeListView It;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(BdTypeListView bdTypeListView) {
        this.It = bdTypeListView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.It.Is != null) {
            this.It.Is.onItemClick(adapterView, view, i, j);
        }
    }
}
