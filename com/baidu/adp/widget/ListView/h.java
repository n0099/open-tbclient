package com.baidu.adp.widget.ListView;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends DataSetObserver {
    final /* synthetic */ g Ht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Ht = gVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        DataSetObserver dataSetObserver;
        i iVar;
        i iVar2;
        DataSetObserver dataSetObserver2;
        super.onChanged();
        dataSetObserver = this.Ht.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Ht.mDataSetObserver;
            dataSetObserver2.onChanged();
        }
        iVar = this.Ht.Hs;
        if (iVar != null) {
            iVar2 = this.Ht.Hs;
            iVar2.nm();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        DataSetObserver dataSetObserver;
        DataSetObserver dataSetObserver2;
        super.onInvalidated();
        dataSetObserver = this.Ht.mDataSetObserver;
        if (dataSetObserver != null) {
            dataSetObserver2 = this.Ht.mDataSetObserver;
            dataSetObserver2.onInvalidated();
        }
    }
}
